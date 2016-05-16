package network.internal;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicBoolean;

public class PingReceiver implements Runnable, Closeable {

	private AtomicBoolean closed = new AtomicBoolean(false);

	private InetAddress group;

	private byte[] nodeId;

	public PingReceiver(final InetAddress group, final byte[] nodeId) {
		this.group = group;
		this.nodeId = nodeId;
	}

	@Override
	public void close() {
		closed.set(true);
	}

	private void fail(final IOException e) {
		e.printStackTrace();
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {

	}

}
