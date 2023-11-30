package edu.qc.seclass.rlm.database;

import java.util.UUID;
public class ReminderDB {
    private String id;
    private String title;
    private String description;
    private String category;
    private String date; //format MM-DD-YYYY
    private String time; //format HH:MM
    private boolean isChecked; //check and uncheck
    public ReminderDB(String title,String description, String category){
        this.id = UUID.randomUUID().toString(); //generates unique ID, helpful for editing and deleting
        this.title = title;
        this.description = description;
        this.category = category;
        this.isChecked = false; //default value
    }
    public String getID(){
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public boolean isChecked(){
        return isChecked;
    }
    public void setChecked (boolean completed){
        isChecked = completed;
    }

    @Override
    public String toString(){
        return "Reminder{" + "Title=" + title + '\''+ ", description='" + description + '\'' +
                ", isChecked=" + isChecked + '}';
    }
}
