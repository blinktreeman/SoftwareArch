package ru.bcomms.modelElements;

import java.util.HashSet;
import java.util.Set;

public class PolygonalModel {
    private final Set<Polygon> polygons;
    private final Set<Texture> textures;

    public PolygonalModel() {
        this.polygons = new HashSet<>();
        this.textures = new HashSet<>();
    }

    public Set<Polygon> getPolygons() {
        return polygons;
    }

    public Set<Texture> getTextures() {
        return textures;
    }

    public boolean addPolygon(Polygon polygon) {
        return polygons.add(polygon);
    }

    public boolean removePolygon(Polygon polygon) {
        return polygons.remove(polygon);
    }

    public boolean addTexture(Texture texture) {
        return textures.add(texture);
    }

    public boolean removeTexture(Texture texture) {
        return textures.remove(texture);
    }
}
