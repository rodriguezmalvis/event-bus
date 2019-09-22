package impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import api.AbstractEventBus;
import api.Invocation;

public class SSBTEventBus extends AbstractEventBus{

	public SSBTEventBus(String name) {
		super(name);
	}

	public void post(Object object) {
		Class<?> clazz = object.getClass();
		if (invocations.containsKey(clazz)) {
			invocations.get(clazz).forEach(invocation -> invocation.invoke(object));
		}
	}

	public void register(Object object) {
		Class<?> currentClass = object.getClass();

		List<Method> listenerMethods = findListenersMethods(currentClass);

		for (Method method : listenerMethods) {
			// we know for sure that it has only one parameter
			Class<?> type = method.getParameterTypes()[0];
			if (invocations.containsKey(type)) {
				invocations.get(type).add(new Invocation(method, object));
			} else {
				Set<Invocation> temp = new HashSet<>();
				temp.add(new Invocation(method, object));
				invocations.put(type, temp);
			}
		}
	}

	public void unregister(Object object) {
		Class<?> currentClass = object.getClass();
		while (currentClass != null) {
			List<Method> listenerMethods = findListenersMethods(currentClass);

			for (Method method : listenerMethods) {
				Class<?> type = method.getParameterTypes()[0];
				if (invocations.containsKey(type)) {
					Set<Invocation> invocationsSet = invocations.get(type);
					invocationsSet.remove(new Invocation(method, object));

					if (invocationsSet.isEmpty()) {
						invocations.remove(type);
					}
				}
			}
			currentClass = currentClass.getSuperclass();
		}
	}

	private List<Method> findListenersMethods(Class<?> type) {
		List<Method> listenerMethods = Arrays.stream(type.getDeclaredMethods()).collect(Collectors.toList());
		return filterSingleParameterMethods(listenerMethods);
	}

	private List<Method> filterSingleParameterMethods(List<Method> listenerMethods) {
		return listenerMethods.stream().filter(method -> method.getParameterCount() == 1).collect(Collectors.toList());
	}
}
