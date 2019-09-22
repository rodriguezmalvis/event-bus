package impl;

import api.AbstractEvent;

public class LogInEvent extends AbstractEvent {

	private final String username;

	private final String uid;

	public LogInEvent(String uuid, String type, String username, String uid) {
		super(uuid, type);
		this.username = username;
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public String getUid() {
		return uid;
	}

}
