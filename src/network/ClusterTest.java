package network;

import java.io.IOException;
import java.io.UncheckedIOException;

public class ClusterTest {

	public static void main(final String[] args) {
		String nodeId = args[0];

		// Instantiate cluster. Pass the ObjectReceiver implementation that will
		// receive any object that was sent from the other node and a failure
		// listener that will be called if there is an issue in the network
		// channel.
		Cluster cluster = new Cluster((object) -> System.out.println(nodeId + " node received Object: " + object),
				(e) -> e.printStackTrace());

		// Call connect to cluster. The connect function will return if the
		// other node is connected
		try (Cluster connectedCluster = cluster.connect()) {

			// Send any object to the other node. The object will be received
			// with the ObjectReceiver implementation.
			cluster.send("Szeva. En " + nodeId + " vagyok");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}
