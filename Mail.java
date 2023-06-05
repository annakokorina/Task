package task;

public interface Mail<T> {
    String getTo();
    T getContent();
}

