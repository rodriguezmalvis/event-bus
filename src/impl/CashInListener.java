package impl;

import api.Listener;

public class CashInListener implements Listener<CashInEvent> {

	@Override
	public void onEvent(CashInEvent event) {
		System.out.println(event.getAmount()+" "+event.getCurrency());
	}

}
