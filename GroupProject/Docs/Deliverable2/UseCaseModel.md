# Use Case Model

**Author(s)**: Elibby & Moshe

## 1 Use Case Diagram
Draft 1:
<img width="340" alt="image" src="https://github.com/qc-se-fall23/370Fall23Sec131Team3/assets/131004671/328faa97-e72b-440d-bec3-d54c891e6d06">

Draft 2:
<img width="288" alt="image" src="https://github.com/qc-se-fall23/370Fall23Sec131Team3/assets/131004671/943c45d6-3b1b-422d-926d-7d3a1b073384">

[Final:](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Deliverable2/TEAM3UseCaseDiagramNEW.pdf)
[![Final](https://github.com/EazyEzz/Test_Repo/raw/31e787cff7beb7a307e386bcce9c3a0128f0bfc4/EazyEzz/TEAM3UseCaseDiagramNEW-1.png)](https://github.com/qc-se-fall23/370Fall23Sec131Team3/blob/main/GroupProject/Deliverable2/TEAM3UseCaseDiagramNEW.pdf)

## 2 Use Case Descriptions

### VIEW LISTS CASE
- REQUIREMENTS:  Allow the user to view all their reminder lists organized by reminder type. The user should be able to click on a reminder type to see the actual reminders within that list. Each reminder should display its name and description.
- Pre-Conditions: The user must have created at least one reminder type and added reminders to it.
- Post-Conditions: The reminder type lists and their contained reminders are displayed to the user.
- Scenarios: 
    * The app displays a list of the user's reminder types (e.g. Tasks, Appointments, Kids, etc).
    * The user clicks on a reminder type to expand it.
    * The app displays the name and description for each reminder within that type.
    * The user can collapse the list to go back to just viewing the reminder types.
    * The user can select a different reminder type to view the reminders in that list.


### DELETE REMINDER LIST Case
- REQUIREMENTS:  When viewing the reminder type list, the user should be able to delete the reminder type with it's associated reminders. 
- Pre-Conditions: The user must have created at least one reminder type and added reminders to it.
- Post-Conditions: The reminder type lists and their contained reminders are deleted from the UI and database.
- Scenarios: 
    * The app displays a list of the user's reminder types (e.g. Tasks, Appointments, Kids, etc).
    * The user clicks on a DELETE reminder type BUTTON.
    * The app displays the reminder type lists again without the deleted list.
    * The user can delete any remainding reminder types

### SEARCH REMINDER Case
- REQUIREMENTS:  When SEARCHING a reminder by its name, we look in the database for reminders with similar names (From all LISTS) and prompt the user to select any of the similar reminders. If there's no match, the user will instead be prompted to create a new reminder with the same name as the words he searched in the searchbar. 
- Pre-Conditions: The user must have created at least one reminder type and added reminders to it for this to be functional.
- Post-Conditions: All reminders with similar names should be displayed to the user, or the user will be prompted to create a new reminder
- Scenarios: 
    * The app displays a search bar
    * The user types a reminder name in the search bar
    * The app displays the reminders with a similar name or, if there's no match, asks the user to create a new reminder.
    * The app then goes to the homePage

### Use Case: Create Reminder
**Requirements**: The use case "Create Reminder" allows the user to create a reminder through many different
                functionalities. On the homepage of the app, users can create a reminder and then go 
                through the process of adding to an already existing list or they have the choice to add a new 
                reminder to a new list. Users can also create a reminder from the "List Display" UI (see Design 
                Document header 4).

**Pre-conditions**: The user must press the "+ new reminder" button for the database to display the "Create
                    New Reminder" screen. On that screen, the users are required to at least input their reminder's 
                    name and the list that they want their reminder to go under before they can create a 
                    reminder. The list that the users want to put their reminder under must also exist within the 
                    database or else the user will be asked to create a new list.
                       
**Post-conditions**: Once a reminder is created, it must show up underneath the list the user assigns it to. The 
                    reminder could be edited, renamed, and deleted at the user's convenience on the 
                    "List Display" UI. The user can turn on and off a repeat reminder from the "List
                    Display" screen, as well. Finally, when the reminder is searched, the user should 
                    be taken to the list that contains that reminder.

**Scenarios**:
<img width="174" alt="image" src="https://github.com/qc-se-fall23/370Fall23Sec131Team3/assets/131004671/1f4fe175-da17-410e-ba9c-d9329bd5cc5d">


### Use Case: Edit Reminder
**Requirements**: The use case allows users to edit a reminder once it has been added to a list. The user does this
                  by either searching for a reminder using the search bar or manually going through a list and then
                  pressing the provided options button. The user is then redirected back to the "Create New Reminder"
                  screen where they are then able to change the name, description, and alert system of the app.

**Pre-conditions**: The reminder must be present within the database and stored within a list.

**Post-conditions**: Once a reminder is edited and updated with the database, the information should to be saved 
                     immediately to be there for future uses.

**Scenarios**:
  - A reminder is created or already exists
  - The user must search and find a reminder
  - The user user must press the options button to access the edit function
  - The user is then allowed to edit certain parts of their reminder but they cannot change they list the remainder is
  already in

### Use Case: Delete Reminder
**Requirements**: The use case allows users to delete specified reminders off of the current list the user is in. With 
                  this change, the reminder no longer appears within the list and cannot be accessed by the user. The
                  user must also confirm that they wish to delete the reminder because the action cannot be undone.

**Pre-conditions**: The reminder must be present within the database and stored within a list.

**Post-conditions**: The reminder must be permanently deleted and must not reappear if the app crashes or is closed.

**Scenarios**:
  - A reminder is created or already exists
  - The user must search and find a reminder
  - The user user must press the options button to access the delete function
  - The user is then allowed to delete a reminder
  - A prompt is then displayed on the screen confirming the deletion
  - The reminder is successfully deleted and 1. is no longer within the list, 2. can no longer be searched  

### Use Case: Check-Off Reminder
**Requirements**: This use case allows the user to check off completed reminders from a viewed list. The check marks
                  can also be removable if the user changes their mind or updates the reminder. Multiple reminders 
                  can be checked-off at once and they remain visible on the list until the user either deletes the reminder
                  or deletes the list. The user then has the option to clear off all checked off reminders from a given
                  list.

**Pre-conditions**: For this use case, a list must exist with at least one reminder underneath. If the user wants to clear
                    all checked reminders, at least one checked reminder must exist within the list.

**Post-conditions**: After a reminder is checked off, a small checkmark will appear in a box next to the reminder as a 
                     visual to the user that it is completed. The checked-off reminder will remains present on the list.
                     If the user wants to clear all completed tasks, then a button must be pressed.

**Scenarios**:
- User must be in a list with reminders underneath
- User must click the check box
- When needed, the user can clear checked reminders from list with a button

## 2.1 User Registration

**Actor:** New User

**Description:** The new user accesses the system for the first time and opts to 
register for an account.

**Preconditions:** 
- The user is not already registered in the system.

**Basic Flow:**
1. The user selects the 'Register' option.
2. The user provides necessary details (e.g., username, password, email).
3. The system validates the details.
4. The system confirms the successful registration.

**Alternative Flow:**
- If the user provides an email or username that's already in use, the system 
prompts them to choose another one.

**Postconditions:** 
- The user is registered and can log into the system.

## 2.2 User Login

**Actor:** Registered User

**Description:** A registered user logs into the system to access their account.

**Preconditions:** 
- The user is registered in the system.

**Basic Flow:**
1. The user provides their login credentials (e.g., username and password).
2. The system validates the credentials.
3. The user is granted access to their account.

**Alternative Flow:**
- If the user provides incorrect credentials, they are informed and asked to try 
again.

**Postconditions:** 
- The user is logged into the system.
