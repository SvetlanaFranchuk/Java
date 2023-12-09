package org.example.function;

import java.util.Optional;

public class Task {
    private final long low;
    private final long high;
    private Double result;

    public Task(long low, long high) {
        this.low = low;
        this.high = high;
    }

    public Optional<Double> getResult() {
        return Optional.ofNullable(result);
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public long getLow() {
        return low;
    }

    public long getHigh() {
        return high;
    }

    @Override
    public String toString() {
        return "Task{" +
                "low=" + low +
                ", high=" + high +
                ", result=" + result +
                '}';
    }
}
