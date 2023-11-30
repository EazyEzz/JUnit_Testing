Yun-Ching (Kenny) Wu
Professor Abreu
CS 370 Software Engineering (Assignment 5)
October 18, 2023

1. A list consisting of reminders the users want to be aware of. The application must allow
users to add reminders to a list, delete reminders from a list, and edit the reminders in
the list.
    - To realize this requirement, I added to the design a class ReminderList with private attributes: head and tail. To realize the functions, I added an addReminder(Reminder), deleteReminder(int), and editReminder(int) operation so that the app allows for adding, deleting, and editing reminders. ReminderList is associated with the Reminder class which has private attributes: name, prev, next, descriptionText, date, and time. 'name' will be used as a parameter in the ReminderList functions to search through the doubly linked list.

2. The application must contain a database (DB) of reminders and corresponding data.
    - To realize this requirement, I added a Database class where it is associated to the Reminder class one to many. The database is not modelled. Database holds user information including all past reminders.

3. Users must be able to add reminders to a list by picking them from a hierarchical list,
where the first level is the reminder type (e.g., Appointment), and the second level is the
name of the actual reminder (e.g., Dentist Appointment).
    - To realize this requirement, I added a class ReminderType, which will extract the reminderType when the user makes their selection from attribute 'reminderTypeList'. reminderTypeList consists of a list of all reminderTypes. ReminderType is associated with the Reminder class and is one to many.

4. Users must also be able to specify a reminder by typing its name. In this case, the
application must look in its DB for reminders with similar names and ask the user
whether that is the item they intended to add. If a match (or nearby match) cannot be
found, the application must ask the user to select a reminder type for the reminder, or
add a new one, and then save the new reminder, together with its type, in the DB.
    - Not considered because it does not affect the design directly. Added a searchReminderNames(String) in the Interface.

5. The reminders must be saved automatically and immediately after they are modified.
    - Not considered because it does not affect the design directly. Added displaySaveNoti() function to Interface. Display to user that the app has saved changes. 

6. Users must be able to check off reminders in the list (without deleting them).
    - Realized by adding a new attribute in Reminders: checked:boolean. Attribute will be set to true if user checks off reminder, otherwise false. 

7. Users must also be able to clear all the check-off marks in the reminder list at once.
    -Realized by adding a new function in ReminderList: uncheckAll():void. Function should uncheck all checked reminders.

8. Check-off marks for the reminder list are persistent and must also be saved immediately.
    - Not considered because it does not affect the design directly.

9. The application must present the reminders grouped by type.
    - Not considered because it does not affect the design directly. Added displayReminders to Interface.

10. The application must support multiple reminder lists at a time (e.g., “Weekly”, “Monthly”,
“Kid’s Reminders”). Therefore, the application must provide the users with the ability to
create, (re)name, select, and delete reminder lists.
    - Realized in a similar manner as ReminderList by adding a ReminderListCollection class. I added functions that allow for the creation, deletion, renaming, and selection of ReminderLists. Some of these functions take in a newly added attribute of ReminderList 'listName' as a parameter to identify, which ReminderList is being referenced. ReminderListCollection facilitates the grouping of reminders by their ReminderTypes. ReminderListCollection is associated with ReminderList and has a one to many multiplicity.

11. The application should have the option to set up reminders with day and time alert. If this
option is selected allow option to repeat the behavior.
    - Realized by adding date, time, and repeat attributes in Reminder. User will have a drop-down or a check box (displayRepeat() in Interface) that if selected will set the repeat attribute to true. The date and time allows for the system to know when to send out an alert.

12. Extra Credit: Option to set up reminder based on location.
    - Not implemented

13. The User Interface (UI) must be intuitive and responsive
    - Not considered because it does not affect the design directly.