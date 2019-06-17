package io.quarkus.panache.json;

public class SerializedView<T> {

    private T value;

    public SerializedView(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
