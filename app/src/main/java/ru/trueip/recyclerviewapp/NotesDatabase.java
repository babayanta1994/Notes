package ru.trueip.recyclerviewapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NotesDatabase extends RoomDatabase {
    private static NotesDatabase notesDatabase;
    private static final String DBNAME="notes.db";
    private static final Object LOCK = new Object();

    public static NotesDatabase getInstance(Context context){
        synchronized (LOCK){
            if(notesDatabase == null){
                notesDatabase = Room.databaseBuilder(context,NotesDatabase.class,DBNAME)
                        .build();
            }
        }
        return notesDatabase;
    }

    public abstract NotesDao notesDao();

}
