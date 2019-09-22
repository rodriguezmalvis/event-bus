package api;

public interface Listener<T> {

	void onEvent(T event);

}
