## Essmer Sanchez UML Design Information

* Requirement 1
1.  A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.

    * Created a reminder list class, ReminderList, that contains a default "Weekly" attribute reminder type and a private (only visible to user) List of actual reminders.
    * Operations include add, delete, edit, clearCheckOffs, checkOff, and unCheck. All which should automatically be saved.
* Requirement 2
2. The application must contain a database (DB) of reminders and corresponding data.
    * It was give that the database does not have to be modelled but I included a ReminderDB that is dependent on the ReminderList. The attributes are a List of saved reminders and operations that provide the user with 'intended' reminders. If user input not found then automatically add to DB.
* Requirement 3
3. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment)
    * A class Level1-ReminderType that has a aggregation and composition relationship to ReminderList. A note added to indicate that Predefined types such as "Appointment", "Special Events", "Shopping", "Birthday", "Meeting", and "General" are available. Maybe include a list of available types. This class contains an aggregation and composition relationship with ReminderList.
    * A class Level2-ActualReminders with a compostion relationship to Level1. This class contains name, isCheckOff boolean, alert, and location attributes. Operations include setAlarm, and setLocation.
* Requirement 4
4. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or
add a new one, and then save the new reminder, together with its type, in the DB.
    * Noted as part of requirement 2.
* Requirement 5, 6, 7 and 8.
5. The reminders must be saved automatically and immediately after they are modified.
6. Users must be able to check off reminders in the list (without deleting them).
7. Users must also be able to clear all the check-off marks in the reminder list at once.
8. Check-off marks for the reminder list are persistent and must also be saved immediately.
    * Requirements noted as part of requirements 1 and 2. Each time an operation is processed, the reminder will automatically be saved. This includes checking and unchecking. In essence, anything done to a reminder will be automatically saved.
* Requirement 9
9. The application must present the reminders grouped by type.
    * As per requirment 1, a List is provided that contains the reminders, but instead maybe consider List of Lists. The main List would have the reminder type and within it a list of actual reminders pertaining to the type.
* Requirement 10
10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
    * A SupportedTypes class with a dependency relationship that contains a list of supported types (weekly, monthly, kids) and operations to select.
* Requirement 11 and 12
11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.
12. Extra Credit: Option to set up reminder based on location.
    * For requirement 11, location and alert classes with association relationships to the Level2-Actual Reminders are used. The ActualReminders class contains setAlert and setLocation that then use location and alert attributes. 
* Requirement 13 Not Considered.



