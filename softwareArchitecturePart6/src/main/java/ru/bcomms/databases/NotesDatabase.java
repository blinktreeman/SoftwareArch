package ru.bcomms.databases;

import ru.bcomms.notes.infrastructure.Database;

public class NotesDatabase implements Database {
    private NotesTable notesTable = new NotesTable();

    public NotesTable getNotesTable() {
        return notesTable;
    }
}
