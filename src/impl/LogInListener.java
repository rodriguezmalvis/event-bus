package impl;

import api.Listener;

public class LogInListener implements Listener<LogInEvent> {

	@Override
	public void onEvent(LogInEvent event) {

		System.out.println("User "+event.getUid()+" | "+event.getUsername()+" has logged in the system");
		
	}

}
