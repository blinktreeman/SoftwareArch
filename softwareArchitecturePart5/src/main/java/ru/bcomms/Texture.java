package ru.bcomms;

/**
 * Текстура
 */
public class Texture implements Entity {
    private static int counter = 50000;
    private int id;

    public int getId() {
        return id;
    }

    {
        id = ++counter;
    }

    @Override
    public String toString() {
        return String.format("Texture #%s", id);
    }
}
