package ru.bcomms.notes.core.application.interfaces;

import ru.bcomms.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {
    Collection<Note> getAll();

    boolean saveChanges();
}
