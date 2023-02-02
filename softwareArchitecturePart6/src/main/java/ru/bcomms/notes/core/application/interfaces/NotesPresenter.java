package ru.bcomms.notes.core.application.interfaces;

import ru.bcomms.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {
    void printAll(Collection<Note> notes);
}
