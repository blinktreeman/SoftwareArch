package ru.bcomms.inMemoryModel;

public interface IModelChanger {
    void notifyChange(ModelStore store);
    void registerModelChanger(IModelChangedObserver observer);
    void removeModelChanger(IModelChangedObserver observer);
}
