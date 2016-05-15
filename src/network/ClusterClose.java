package network;

import java.io.Serializable;

public final class ClusterClose implements Serializable {

	public static final ClusterClose INSTANCE = new ClusterClose();

	private static final long serialVersionUID = 1L;

	private ClusterClose() {
	}

	@Override
	public boolean equals(final Object obj) {
		return obj instanceof ClusterClose;
	}

	@Override
	public int hashCode() {
		return 0;
	}
}
