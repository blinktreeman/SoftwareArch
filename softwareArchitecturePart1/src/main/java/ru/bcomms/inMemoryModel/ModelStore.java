package ru.bcomms.inMemoryModel;

import ru.bcomms.modelElements.Camera;
import ru.bcomms.modelElements.Flash;
import ru.bcomms.modelElements.PolygonalModel;
import ru.bcomms.modelElements.Scene;

import java.util.*;

public class ModelStore implements IModelChanger {
    private final List<IModelChangedObserver> changeObservers = new ArrayList<>();
    // Не совсем понятно зачем нам эти поля если все есть в Scene
    private Set<PolygonalModel> models;
    private Set<Flash> flashes;
    private Set<Camera> cameras;

    private final Set<Scene> scenes = new HashSet<>();

    public ModelStore(Scene scene) {
        // По диаграмме нужно добавить параметрами конструктора
        // еще PolygonalModel, Flash и Camera
        this.scenes.add(scene);
    }

    public Scene getScene(UUID uuid) {
        return scenes.stream()
                .filter(x -> x.getId().equals(uuid))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No scene found"));
    }

    @Override
    public void notifyChange(ModelStore store) {
        changeObservers.forEach(observer -> observer.applyUpdateModel(store));
    }

    @Override
    public void registerModelChanger(IModelChangedObserver observer) {
        changeObservers.add(observer);
    }

    @Override
    public void removeModelChanger(IModelChangedObserver observer) {
        changeObservers.remove(observer);
    }

    public boolean addScene(Scene scene) {
        if (scenes.add(scene)) {
            this.notifyChange(this);
            return true;
        }
        return false;
    }

    public boolean removeScene(Scene scene) {
        if (scenes.remove(scene)) {
            this.notifyChange(this);
            return true;
        }
        return false;
    }
}
