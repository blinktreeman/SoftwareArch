package ru.bcomms.inMemoryModel;

public class AnotherSceneObserver implements IModelChangedObserver {
    @Override
    public void applyUpdateModel(ModelStore store) {
        // Update something...
        System.out.println("Something changed in " + this.getClass().getName());
    }
}
