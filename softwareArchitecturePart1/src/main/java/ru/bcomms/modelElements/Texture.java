package ru.bcomms.modelElements;

import java.awt.*;
import java.util.UUID;

public class Texture {
    private final UUID uuid;
    private final String name;
    private final Image image;

    public Texture(String name, Image image) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.image = image;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}
