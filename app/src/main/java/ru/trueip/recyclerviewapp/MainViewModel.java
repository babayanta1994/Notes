package ru.trueip.recyclerviewapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static NotesDatabase database;
    private LiveData<List<Note>> notes;

    public MainViewModel(@NonNull Application application) {
        super(application);
        database = NotesDatabase.getInstance(getApplication());
        notes = database.notesDao().getAllNotes();
    }

    public LiveData<List<Note>> getNotes() {
        return notes;
    }

    private static class insertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(final Note... params) {
            database.notesDao().insertNote(params[0]);
            return null;
        }
    }
    private static class deleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        @Override
        protected Void doInBackground(final Note... params) {
            database.notesDao().deleteNote(params[0]);
            return null;
        }
    }

    private static class deleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(final Void... params) {
            database.notesDao().deleteAllNotes();
            return null;
        }
    }

    public void insertNote(final Note note){
        new insertNoteAsyncTask().execute(note);
    }
    public void deleteNote(final Note note){
        new deleteNoteAsyncTask().execute(note);
    }

    public void deleteAllNotes(){
        new deleteAllNotesAsyncTask().execute();
    }


}
