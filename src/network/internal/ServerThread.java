package network.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread implements Closeable {

	private boolean closed = false;

	private ServerSocket serverSocket;

	@Override
	public void close() {
		closed = true;
	}

	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(0);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}

		try {
			Socket socket = serverSocket.accept();
			// TODO
		} catch (IOException e) {
			// TODO
			close();
		}
	}

}