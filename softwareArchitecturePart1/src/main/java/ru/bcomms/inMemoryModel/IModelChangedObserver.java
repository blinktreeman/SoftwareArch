package ru.bcomms.inMemoryModel;

public interface IModelChangedObserver {
    void applyUpdateModel(ModelStore store);
}
