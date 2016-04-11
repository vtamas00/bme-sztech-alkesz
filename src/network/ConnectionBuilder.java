package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class ConnectionBuilder {

	static final int MULTICAST_PORT = 4446;

	public static void main(final String[] args) {
		new ConnectionBuilder().buildConnection();
	}

	public void buildConnection() {
		InetAddress group;
		try {
			group = InetAddress.getByName("230.0.113.0");
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}

		String nodeId = UUID.randomUUID().toString();
		PingSender pingSender = new PingSender(group, nodeId.getBytes(StandardCharsets.UTF_8));
		new Thread(pingSender).start();

		// TODO remove
		nodeId = UUID.randomUUID().toString();
		PingReceiver pingReceiver = new PingReceiver(group, nodeId.getBytes(StandardCharsets.UTF_8));
		new Thread(pingReceiver).start();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
