package network;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UncheckedIOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import network.internal.PingSender;
import network.internal.ServerThread;

public class Cluster implements Closeable {

	private static final InetAddress GROUP;

	private static final String MULTICAST_IP = "230.0.113.0";

	public static final int MULTICAST_PORT = 4446;

	static {
		try {
			GROUP = InetAddress.getByName(MULTICAST_IP);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}

	private Socket clientSocket = null;

	private AtomicBoolean closed = new AtomicBoolean(false);

	private final FailureListener failureListener;

	private ObjectOutputStream objectOutputStream;

	private final ObjectReceiver objectReceiver;

	private PingSender pingSender;

	private ServerSocket serverSocket;

	private ServerThread serverThread;

	public Cluster(final ObjectReceiver objectReceiver, final FailureListener failureListener) {
		super();
		this.objectReceiver = objectReceiver;
		this.failureListener = failureListener;
	}

	@Override
	public synchronized void close() throws IOException {
		if (!closed.getAndSet(true)) {
			if (pingSender != null) {
				pingSender.close();
			}

			if (serverThread != null) {
				serverThread.close();
			}

			if (serverSocket != null) {
				serverSocket.close();
			}
			if (objectOutputStream != null) {
				trySendingCloseToOtherNode();
				objectOutputStream.close();
			}

			if (clientSocket != null) {
				clientSocket.close();
			}
		}
	}

	public Cluster connect() throws IOException {
		this.serverSocket = new ServerSocket(0);

		int serverPort = serverSocket.getLocalPort();
		byte[] serverPortBA = convertIntToByteArray(serverPort);
		this.pingSender = new PingSender(GROUP, serverPortBA, failureListener);

		this.serverThread = new ServerThread(serverSocket, objectReceiver, failureListener, pingSender);
		this.serverThread.start();

		new Thread(pingSender).start();

		InetSocketAddress remoteSocketAddress = waitForPing(serverPortBA);

		clientSocket = new Socket(remoteSocketAddress.getAddress(), remoteSocketAddress.getPort());

		objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
		return this;
	}

	private int convertByteArrayToInt(final byte[] bytes) {
		return bytes[0] << 24 | (bytes[1] & 0xFF) << 16 | (bytes[2] & 0xFF) << 8 | (bytes[3] & 0xFF);
	}

	private byte[] convertIntToByteArray(final int data) {
		byte[] result = new byte[Integer.BYTES];

		result[0] = (byte) ((data & 0xFF000000) >> 24);
		result[1] = (byte) ((data & 0x00FF0000) >> 16);
		result[2] = (byte) ((data & 0x0000FF00) >> 8);
		result[3] = (byte) ((data & 0x000000FF) >> 0);

		return result;
	}

	public synchronized void send(final Object object) throws IOException {
		objectOutputStream.writeObject(object);
		objectOutputStream.flush();
	}

	private void trySendingCloseToOtherNode() {
		try {
			send(ClusterClose.INSTANCE);
		} catch (IOException e) {
			// We do not care if there is an exception on the channel at this
			// point
		}
	}

	private InetSocketAddress waitForPing(final byte[] serverPortBA) {
		try (MulticastSocket socket = new MulticastSocket(Cluster.MULTICAST_PORT)) {
			System.out.println(GROUP.getHostAddress());
			socket.joinGroup(GROUP);

			InetSocketAddress remoteSocketAddress = null;
			while (!closed.get() && remoteSocketAddress == null) {
				byte[] buf = new byte[Integer.BYTES];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				if (!Arrays.equals(buf, serverPortBA)) {
					int remotePort = convertByteArrayToInt(buf);
					remoteSocketAddress = new InetSocketAddress(packet.getAddress(), remotePort);
				}
			}
			socket.leaveGroup(GROUP);
			return remoteSocketAddress;
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
