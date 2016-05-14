package network;

/**
 * Programmer must implement the receiver to get objects sent by the other
 * computer.
 */
public interface ObjectReceiver {

	void receive(Object object);
}
