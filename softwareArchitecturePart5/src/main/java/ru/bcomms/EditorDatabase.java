package ru.bcomms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * База данных всех сущностей проекта (Database Layer)
 */
public class EditorDatabase implements Database {
    private final ProjectFile projectFile;
    private Collection<Entity> entities;

    public EditorDatabase(ProjectFile projectFile) {
        this.projectFile = projectFile;
        load();
    }


    @Override
    public void load() {
        //TODO: Загрузка всех сущностей проекта (модели, текстуры)
    }

    @Override
    public void save() {
        //TODO: Сохранение всех сущностей проекта в источник (файл)
    }


    private Random random = new Random();

    @Override
    public Collection<Entity> getAll() {
        if (entities == null) {
            entities = new ArrayList<>();

            int modelsCount = 10 - random.nextInt(6);
            for (int i = 0; i < modelsCount; i++)
                generateModelAndTextures();
        }
        return entities;
    }

    private void generateModelAndTextures() {
        Model3D model = new Model3D();
        int textureCount = random.nextInt(3);
        for (int i = 0; i < textureCount; i++) {
            Texture texture = new Texture();
            model.getTextures().add(texture);
            entities.add(texture);
        }
        entities.add(model);
    }
}
