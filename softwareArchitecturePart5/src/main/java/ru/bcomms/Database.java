package ru.bcomms;

import java.util.Collection;

/**
 * Database Layer
 */
public interface Database {
    void load();
    void save();
    Collection<Entity> getAll();
}
