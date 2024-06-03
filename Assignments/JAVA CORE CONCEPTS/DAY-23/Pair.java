package com.DAY_23;
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public Pair<U, T> reverse() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

    public static void main(String[] args) {
        Pair<String, Integer> originalPair = new Pair<>("Hello", 123);
        System.out.println("Original Pair: " + originalPair);

        Pair<Integer, String> reversedPair = originalPair.reverse();
        System.out.println("Reversed Pair: " + reversedPair);
    }
}

