package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingReceiver implements Runnable {

	private InetAddress group;

	private byte[] nodeId;

	private AtomicBoolean stopped = new AtomicBoolean(false);

	public PingReceiver(final InetAddress group, final byte[] nodeId) {
		this.group = group;
		this.nodeId = nodeId;
	}

	private void fail(final IOException e) {
		e.printStackTrace();
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try (MulticastSocket socket = new MulticastSocket(ConnectionBuilder.MULTICAST_PORT)) {
			System.out.println(group.getHostAddress());
			socket.joinGroup(group);
			while (!stopped.get()) {
				byte[] buf = new byte[nodeId.length];
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				if (Arrays.equals(buf, nodeId)) {
					if (Thread.interrupted()) {
						stopped.set(true);
					}
				} else {
					System.out.println("JEEEEEEEEEE: " + packet.getSocketAddress());
					stopped.set(true);
				}

			}
			socket.leaveGroup(group);
		} catch (IOException e) {
			fail(e);
		}
	}

}
