package ru.bcomms.notes.core.application.interfaces;

import ru.bcomms.notes.core.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {
    void printAll();
}
