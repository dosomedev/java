package com.dosomedev;

public class Cat implements Comparable<Cat> {
    private String name;
    private int likability;

    public Cat(String name, int likability) {
        this.name = name;
        this.likability = likability;
    }

    @Override
    public int compareTo(Cat comparedCat) {
        return Integer.compare(comparedCat.likability, this.likability);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", likability: " + this.likability;
    }
}
