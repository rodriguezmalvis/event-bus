package runner;

import java.math.BigDecimal;

import impl.CashInEvent;
import impl.CashInListener;
import impl.LogInEvent;
import impl.LogInListener;
import impl.SSBTEventBus;

public class Runner {

	public static void main(String[] args) {

		System.out.println("starting");

		SSBTEventBus bus = new SSBTEventBus("LOCAL_EVENT_BUS");

		CashInListener cashInListener = new CashInListener();
		LogInListener logInListener = new LogInListener();

		bus.register(cashInListener);
		bus.register(logInListener);

		bus.post(new CashInEvent("uuid", "CASH_IN", BigDecimal.valueOf(100.50), "EUR"));
		bus.post(new LogInEvent("uuid", "LOG_IN", "rrodriguez", "4553-554-332-112"));

		bus.unregister(cashInListener);

		bus.post(new CashInEvent("uuid", "CASH_IN", BigDecimal.valueOf(100.50), "EUR"));
		bus.post(new LogInEvent("uuid", "LOG_IN", "rrodriguez", "4553-554-332-112"));

		bus.unregister(logInListener);

		bus.post(new CashInEvent("uuid", "CASH_IN", BigDecimal.valueOf(100.50), "EUR"));
		bus.post(new LogInEvent("uuid", "LOG_IN", "rrodriguez", "4553-554-332-112"));

		bus.register(cashInListener);

		bus.post(new CashInEvent("uuid", "CASH_IN", BigDecimal.valueOf(100.50), "EUR"));
		bus.post(new LogInEvent("uuid", "LOG_IN", "rrodriguez", "4553-554-332-112"));
		
		bus.register(logInListener);

		bus.post(new CashInEvent("uuid", "CASH_IN", BigDecimal.valueOf(100.50), "EUR"));
		bus.post(new LogInEvent("uuid", "LOG_IN", "rrodriguez", "4553-554-332-112"));
		
		System.out.println("finished");
	}

}
