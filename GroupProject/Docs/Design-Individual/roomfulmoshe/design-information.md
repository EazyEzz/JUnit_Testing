# Design Information

1. A list consisting of reminders the users want to be aware of. The application must allow users to add reminders to a list, delete reminders from a list, and edit the reminders in the list.
We have a list of reminders for our app in the reminderList class which stores a list of reminders. In this class our app can do operations such as add reminders to the list, delete the reminder from a list and edit the reminders in a list. Satisfying the requirement. We also have a separate reminder class to model each reminder.

2. The application must contain a database (DB) of reminders and corresponding data. 

This requirement is not taken into full account in the Class Diagram, the DB should be modeled in the ER diagram. However methods are built into the classes such as retrieving lists, storing lists, and editing lists which should be called upon whenever a database operation is necessary.

3. Users must be able to add reminders to a list by picking them from a hierarchical list, where the first level is the reminder type (e.g., Appointment), and the second level is the name of the actual reminder (e.g., Dentist Appointment).

This requirement is satisfied in the reminderApp class which stores a hashmap of all different types of reminderLists as values and reminderTypes (which is also a defined class) as keys. Also, the reminderApp class has a function to return all the reminderTypes that exist for that user/app,  so this satisfies our first level. And based on that reminderType list we can iterate through the actual reminder list using our hash map, and that would satisfy the second level of the hierarchy.

4. Users must also be able to specify a reminder by typing its name. In this case, the application must look in its DB for reminders with similar names and ask the user whether that is the item they intended to add. If a match (or nearby match) cannot be found, the application must ask the user to select a reminder type for the reminder, or add a new one, and then save the new reminder, together with its type, in the DB.
This requirement is fulfilled mainly in the reminderApp class in the searchReminder(name) operation which returns a list of reminders that are similar names with the one in the parameter, then the UI will display the list. We can fulfill all the necessary operations for this using getReminderTypes and get_lists() to search for all the similar reminders in all the existing reminder lists. If no m matches we can display the reminder types list or we can use addReminderType() from the remidnerApp class if the user wants to create a new reminder Type and a corresponding list with that reminder type. Wr can use the save_lists() function to call the database.

5. The reminders must be saved automatically and immediately after they are modified
We can modify reminders using the editReminder operation which takes in a reminder and will display the stuff the user wants to change and make changes based on whatever the user selects. Once we modify the reminders we can use operations like saveReminders to make the necessary calls to the database. 

6. Users must be able to check off reminders in the list (without deleting them).
After displaying the hierarchal list of reminders, we give the user the option to check off any actual reminder and use the check and uncheck operation in the reminders class to check them off without deleting them from the database.  Satisfying the requirement

7. Users must also be able to clear all the check-off marks in the reminder list at once. 
For this we have a clearChecks and saveReminders operations in the reminderList class which will perform all the necessary tasks.

8. Check-off marks for the reminder list are persistent and must also be saved immediately.
For this we have the operation saveReminders in the reminderList class which will tamper with the database immediately and we can call this when user checks something off using the check or uncheck operation in the Reminder Class.

9. The application must present the reminders grouped by type.  
For this we have a reminderTypes list attribute  in the reminderApp. From there each type is then used as a key in the reminderList attribute hash map, which will return a reminderList based on whatever reminderType is inputted as the key. This is a neat way to group reminders easily by type and b ready to be displayed.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”, “Kid’s Reminders”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete reminder lists
The application stores multiple reminder lists at a time in the reminderApp class with the reminderList attribute and they are grouped by type “weekly” “monthly” ... And inside the class we have operations like createList, selectList, deleteList, and renameReminderType  

11. The application should have the option to set up reminders with day and time alert. If this option is selected allow option to repeat the behavior
For this we have a DateTimeAlert attribute in the reminder class, along with a repeat attribute which specifies the interval between repetitions.

12. Extra Credit: Option to set up reminder based on location.  
This requirement is satisfied in the reminder class with the location attribute which allows the user to set up a reminder associated with a location.

13. The User Interface (UI) must be intuitive and responsive
This requirement is not modeled in the class diagrams intentionally.

# Additional Information

- The ReminderApp class represents the overall application and brings together the other key classes. It contains the main application logic.
- ReminderApp has methods like save and get to handle persisting app data to file/database.
- ReminderType objects are pre-populated on app startup with default types like Appointment, Task, etc. These are retrieved from the data store by ReminderApp.
- When adding a new Reminder, the app checks if the ReminderType already exists and reuses it. Otherwise it creates a new ReminderType.
- The addReminder() method in ReminderList handles getting the ReminderType object associated with a Reminder and adding it properly.
- Each reminder can only belong to one reminderType
- The Reminder class should probably have attributes like createdDate, lastUpdated etc to track meta info but not mentioned in the requirements .
- Reminders are immutable - edits create new Reminder objects rather than modifying existing ones.
- There is basic validation on user inputs when adding/editing Reminders and ReminderTypes.
- Any other non-functional requirements related to performance, security, etc are not modeled in the design.
- SaveList operation to the ReminderList class to handle saving to the database. Call it after add/edit/delete.
- Searching reminders would look for matches on name and reminder type. Can return a list of matching reminders.
- The saveReminders() method handles updating the checkboxes.
