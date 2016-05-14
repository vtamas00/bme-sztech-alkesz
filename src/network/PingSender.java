package network;

import java.io.Closeable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingSender implements Runnable, Closeable {

	private AtomicBoolean closed = new AtomicBoolean(false);

	private InetAddress group;

	private byte[] nodeId;

	public PingSender(final InetAddress group, final byte[] nodeId) {
		this.group = group;
		this.nodeId = nodeId;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	private void fail(final IOException e) {
		e.printStackTrace();
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try (DatagramSocket socket = new DatagramSocket()) {
			while (!closed.get()) {
				DatagramPacket packet = new DatagramPacket(nodeId, nodeId.length, group, Cluster.MULTICAST_PORT);
				socket.send(packet);
				Thread.sleep(100);
			}
		} catch (IOException e) {
			fail(e);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
