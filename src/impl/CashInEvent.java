package impl;

import java.math.BigDecimal;

import api.AbstractEvent;

public class CashInEvent extends AbstractEvent {

	private final BigDecimal amount;
	private final String currency;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getCurrency() {
		return currency;
	}

	public CashInEvent(String uuid, String type, BigDecimal amount, String currency) {
		super(uuid, type);
		this.amount = amount;
		this.currency = currency;
	}

}
