package ru.bcomms.notes.presentation.queries.views;

import ru.bcomms.notes.core.application.interfaces.NotesPresenter;
import ru.bcomms.notes.core.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }
}
