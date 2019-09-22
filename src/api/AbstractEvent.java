package api;

public abstract class AbstractEvent {

	private final String uuid;
	private final String type;

	public AbstractEvent(String uuid, String type) {
		super();
		this.uuid = uuid;
		this.type = type;
	}

	public String getUuid() {
		return uuid;
	}

	public String getType() {
		return type;
	}

}
