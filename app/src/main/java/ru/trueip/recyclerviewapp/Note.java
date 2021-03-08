package ru.trueip.recyclerviewapp;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String dayOfWeak;
    private String priority;

    public Note(int id,String title, String description, String dayOfWeak, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dayOfWeak = dayOfWeak;
        this.priority = priority;
    }

    @Ignore
    public Note(String title, String description, String dayOfWeak, String priority) {
        this.title = title;
        this.description = description;
        this.dayOfWeak = dayOfWeak;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDayOfWeak() {
        return dayOfWeak;
    }

    public void setDayOfWeak(String dayOfWeak) {
        this.dayOfWeak = dayOfWeak;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
