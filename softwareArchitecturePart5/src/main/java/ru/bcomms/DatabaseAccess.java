package ru.bcomms;

import java.util.Collection;

/**
 * Data Access Layer
 */
public interface DatabaseAccess {
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    Collection<Texture> getAllTextures();
    Collection<Model3D> getAllModels();
}
