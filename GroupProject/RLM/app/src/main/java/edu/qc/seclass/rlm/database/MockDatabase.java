package edu.qc.seclass.rlm.database;

import android.text.method.MovementMethod;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MockDatabase {
    private static MockDatabase instance;
    private HashMap<String, List<ReminderDB>> remindersBYCategory;

    private MockDatabase(){
        remindersBYCategory = new HashMap<>();
    }
    public static synchronized MockDatabase getInstance(){
        if(instance == null){
            instance = new MockDatabase();
        }
        return instance;
    }
    public void addReminder(ReminderDB reminder){
        String category = reminder.getCategory();
        remindersBYCategory.computeIfAbsent(category, k -> new ArrayList<>()).add(reminder);
    }

    public List<ReminderDB> getRemindersByCategory(String category){
        return remindersBYCategory.getOrDefault(category, new ArrayList<ReminderDB>());
    }
    public List<String> getCategories(){
        return new ArrayList<>(remindersBYCategory.keySet());
    }
    public List<ReminderDB> getAllReminders(){
        List<ReminderDB> allReminders = new ArrayList<>();
        for(List<ReminderDB> categoryReminders : remindersBYCategory.values()){
            allReminders.addAll(categoryReminders);
        }
        return allReminders;
    }
    public void editReminder(ReminderDB updatedReminder){
        List<ReminderDB> reminders = remindersBYCategory.get(updatedReminder.getCategory());
        if(reminders != null){
            for(int i = 0; i < reminders.size(); i++){
                if(reminders.get(i).getID().equals(updatedReminder.getID())){
                    reminders.set(i, updatedReminder);
                    break;
                }
            }
        }
    }
    public void deleteReminder(ReminderDB reminderToDelete){
        List<ReminderDB> reminders = remindersBYCategory.get(reminderToDelete.getCategory());
        if(reminders != null){
            reminders.removeIf(reminder -> reminder.getID().equals(reminderToDelete.getID()));
        }
    }
    public String getCategoryByReminderID(String reminderID){
        for(String category : remindersBYCategory.keySet()){
            for(ReminderDB reminder : remindersBYCategory.get(category)){
                if(reminder.getID().equals(reminderID)){
                    return category;
                }
            }
        }
        return null;
    }
}
