package ru.bcomms;

import java.util.Collection;
import java.util.Random;

/**
 * Business Logical Layer
 * Описываю реализацию конкретных функций приложения
 */
public class EditorBusinessLogicalLayer implements BusinessLogicalLayer {
    private final DatabaseAccess databaseAccess;

    public EditorBusinessLogicalLayer(DatabaseAccess databaseAccess) {
        this.databaseAccess = databaseAccess;
    }

    @Override
    public Collection<Model3D> getAllModels() {
        return databaseAccess.getAllModels();
    }

    @Override
    public Collection<Texture> getAllTextures() {
        return databaseAccess.getAllTextures();
    }

    @Override
    public void renderModel(Model3D model) {
        processRender(model);
    }

    @Override
    public void renderAllModels() {
        for (Model3D model : getAllModels()) {
            processRender(model);
        }
    }

    private Random random = new Random();

    private void processRender(Model3D model) {
        try {
            Thread.sleep(2500 - random.nextInt(2001));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
