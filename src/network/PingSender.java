package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingSender implements Runnable {

	private InetAddress group;

	private byte[] nodeId;

	private AtomicBoolean stopped = new AtomicBoolean(false);

	public PingSender(final InetAddress group, final byte[] nodeId) {
		this.group = group;
		this.nodeId = nodeId;
	}

	private void fail(final IOException e) {
		e.printStackTrace();
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		try (DatagramSocket socket = new DatagramSocket()) {
			while (!stopped.get()) {
				DatagramPacket packet = new DatagramPacket(nodeId, nodeId.length, group,
						ConnectionBuilder.MULTICAST_PORT);
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
