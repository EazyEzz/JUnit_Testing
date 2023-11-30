# Test Plan for ReminderManager App

## 1. Testing Strategy

### 1.1 Test Levels

- **Unit Testing**: Verify individual components, such as reminder 
creation, editing, deletion, and list management.
- **Integration Testing**: Ensure that various components (reminders, 
lists, search functionality, user authentication) work together 
seamlessly.
- **System Testing**: Conduct end-to-end testing, simulating user behavior 
to validate the entire application against requirements.
- **Regression Testing**: Re-test after code changes to ensure that 
previous functionalities still work as expected.

### 1.2 Test Types

- **Functional Testing**: Validate features against requirements (CRUD 
operations, searching, list management).
- **Usability Testing**: Assess UI/UX for intuitiveness and ease of use.
- **Performance Testing**: Test the app’s responsiveness and stability, 
especially when handling a large number of reminders.
- **Security Testing**: Ensure data integrity and security, particularly 
in user authentication via Firebase.

## 2. Test Environment

- **Devices**: Various Android devices with different screen sizes and API 
levels (minimum API level 28).
- **Network Conditions**: Testing under different network environments 
(Wi-Fi, Cellular, Offline).
- **Database**: SQLite for local storage testing.

## 3. Test Cases

### 3.1 Functional Test Cases

1. **Login and Registration Workflow**:
   - Steps: Open app, use login/register screen, verify successful 
login/registration.
   - Expected Result: User can log in/register and access the home screen.
   - Actual Result: (Partial) Successfully tested on 2 devices. Further 
testing ongoing.
   - Pass/Fail: Pass (Partial)

2. **Reminder Creation**:
   - Steps: Create a new reminder, fill out details, save it.
   - Expected Result: The reminder appears in the appropriate 
list/category.
   - Actual Result: (Partial) Creation successful, but some reminders 
missing from the list view.
   - Pass/Fail: Fail (Partial)

3. **Editing a Reminder**:
   - Steps: Edit an existing reminder, change details, save.
   - Expected Result: Changes are reflected and persistent.
   - Actual Result: (Partial) Edits are saved, but app crashes 
occasionally after saving.
   - Pass/Fail: Fail (Partial)

4. **Deleting a Reminder**:
   - Steps: Delete a reminder and confirm deletion.
   - Expected Result: The reminder is removed from the list.
   - Actual Result: (Partial) Deletion works, but requires app restart to 
reflect changes.
   - Pass/Fail: Pass with notes (Partial)

5. **List Management**:
   - Steps: Create, view, and delete lists.
   - Expected Result: Lists are properly managed and updated.
   - Actual Result: (Partial) Lists function as expected, but deletion 
sometimes slow.
   - Pass/Fail: Pass (Partial)

6. **Search Functionality**:
   - Steps: Use the search bar to find specific reminders.
   - Expected Result: Relevant reminders are displayed.
   - Actual Result: (Partial) Search function works, but has occasional 
inaccuracies.
   - Pass/Fail: Pass with notes (Partial)

7. **Reminder Notifications**:
   - Steps: Set a reminder with an alert, wait for notification.
   - Expected Result: Notification is received at the correct time.
   - Actual Result: (Partial) Notifications work but sometimes delayed.
   - Pass/Fail: Pass with notes (Partial)

8. **Recurring Reminders** (Note: TBD):
   - Steps: Create a recurring reminder, observe repeat alerts.
   - Expected Result: Reminder recurs as set.
   - Actual Result: (Partial) Recurring reminders function correctly.
   - Pass/Fail: Pass (Partial)

9. **Data Persistence**:
   - Steps: Create reminders/lists, close app, reopen app.
   - Expected Result: All data persists across sessions.
   - Actual Result: (Partial) All data persisting as expected.
   - Pass/Fail: Pass (Partial)

10. **Category Constraints**:
    - Steps: Attempt to create a reminder without a category.
    - Expected Result: Reminder must be assigned to a category.
    - Actual Result: (Partial) Reminders without categories cannot be 
created.
    - Pass/Fail: Pass (Partial)

### 3.2 Usability and Performance Test Cases

1. **UI Responsiveness**:
   - Steps: Navigate through various screens, create/edit reminders.
   - Expected Result: App remains responsive with no lag.
   - Actual Result: (Partial) Responsive on most devices, some lag on 
older models.
   - Pass/Fail: Pass with notes (Partial)

2. **Load Testing**:
   - Steps: Create a large number of reminders/lists.
   - Expected Result: App handles load without crashing or significant 
performance degradation.
   - Actual Result: (Partial) Handles up to 200 reminders smoothly.
   - Pass/Fail: Pass (Partial)

### 3.3 Security Test Cases

1. **User Authentication**:
   - Steps: Attempt login with incorrect credentials, reset password.
   - Expected Result: Secure authentication process.
   - Actual Result: (Partial) Authentication secure, reset process 
functional.
   - Pass/Fail: Pass (Partial)

## 4. Bug Tracking and Reporting

- **Tool**: GitHub Issue Tracker.
- **Procedure**: Report bugs with detailed steps, expected vs. actual 
results, and severity level.

## 5. Testing Tools

- **Unit Testing**: JUnit for Android.
- **UI Testing**: Espresso for automated UI tests.
- **Performance Testing**: Android Profiler.
- **Security Testing**: Manual testing for authentication flows.

## 6. Test Deliverables

- Test case document with partial results.
- Bug reports and resolution documentation (in progress).
- Test summary report (to be completed).

