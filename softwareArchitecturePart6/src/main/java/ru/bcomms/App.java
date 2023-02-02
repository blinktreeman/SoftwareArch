package ru.bcomms;

import ru.bcomms.databases.NotesDatabase;
import ru.bcomms.notes.core.application.ConcreteNoteEditor;
import ru.bcomms.notes.infrastructure.DatabaseContext;
import ru.bcomms.notes.presentation.queries.controllers.NotesController;
import ru.bcomms.notes.presentation.queries.views.NotesConsolePresenter;

public class App {
    public static void main(String[] args) {
        NotesController notesController = new NotesController(
                new ConcreteNoteEditor(new DatabaseContext(new NotesDatabase()), new NotesConsolePresenter()));
        notesController.routeGetAll();
    }
}