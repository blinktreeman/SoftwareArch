package ru.bcomms;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 3D модель
 */
public class Model3D implements Entity {
    private static int counter = 10000;
    private int id;
    private Collection<Texture> textures = new ArrayList<>();

    public int getId() {
        return id;
    }


    public Collection<Texture> getTextures() {
        return textures;
    }

    {
        id = ++counter;
    }

    @Override
    public String toString() {
        return String.format("Model #%s", id);
    }
}
