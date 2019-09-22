package api;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractEventBus implements EventBus{
	
	protected Map<Class<?>, Set<Invocation>> invocations;

	private final String name;

	public AbstractEventBus(String name) {
		this.name = name;
		invocations = new ConcurrentHashMap<>();
	}

	public Map<Class<?>, Set<Invocation>> getInvocations() {
		return Collections.unmodifiableMap(invocations);
	}

	public String getName() {
		return name;
	}

}
