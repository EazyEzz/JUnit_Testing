# Test Plan

**Author(s)**: Mobin and Kenny

## 1 Testing Strategy

### 1.1 Overall Strategy
    Unit Testing: focuses on testing individual components of our app in isolation; therefore, we plan on having the developer(s) who wrote the code to write their own JUnit tests to ensure functionality.

    Integration Testing: involves testing the combination of components and how different units work together. We plan on designating 1 integration tester to work with the developer(s) of each component in order to combine our components into one functioning app.

    System Testing: evaluates whether our app behaves correctly from the end-user perspective. This involves understanding whether the app realizes all of the end-user's requirements. We will be designating 1 system tester to perform system testing.

    Regression Testing: ensures that the introduction of new code does not generate new bugs. The developer(s) that introduced the new code must work together with the dedicated testers to determine whether the code is safe.

    We aim to adopt a hybrid testing strategy, combining both manual and automated 
testing methods. This combination ensures that while we cover a broad spectrum of 
tests automatically, we also have the flexibility and depth of manual testing.

### 1.2 Test Selection
    Definitions:
        White-box techniques: examining the logic and structure of code
        Black-box techniques: Testers do not know the internal code and focuses on examining the external behavior of the app.

    Unit Testing: White-box. Primarily testing with full visibility of the code.
    Integration Testing: White-box and Black-box. The dedicated tester is required to understand the logic of the code as well as the design of the app.
    System Testing: Black-box. The dedicated tester will pretending to be an end-user, which inherently is black-box testing.
    Regression Testing: White-box and/or black-box. This is based on how the new code affects the app.

    The test cases will be chosen based on the criticality of the modules. 
High-priority modules, which are essential for the system's functionality, will 
undergo exhaustive testing. On the other hand, less critical modules may undergo a 
more selective testing process.

### 1.3 Adequacy Criterion
    Definitions:
        Structural coverage: assesses how much of the internal code has been exercised by a set of test cases (white-box coverage)
        Functional coverage: assesses how well the software has been tested based on its external behavior (black-box coverage)

    Unit Testing: Structural coverage
    Integration Testing: Structural and functional coverage
    System Testing: Functional coverage
    Regression Testing: Structural and/ functional coverage. This is based on how the new code affects the app.

    The adequacy will be determined based on the test coverage. Our target is to 
achieve at least 80% code coverage, ensuring that a majority of our codebase is 
validated against potential errors.

### 1.4 Bug Tracking
    We'll be using the bug tracker feature on Github. All members of the team will be able to see all the bugs that currently exist within the app.

    All discovered bugs will be recorded in our bug tracking system, which will 
categorize the bugs based on severity and assign them to the appropriate 
developers for resolution.

### 1.5 Technology
    We plan on using JUnit for unit testing, Selenium for system testing, as well as manual testing (small enough project to run manual tests).

## 2 Test Cases

Test Case 1: Successful Reminder Creation

Steps: 
1. Open the app 
2. Click the 'Create new reminder button' 
3. User is brought to 'Reminder Creation' layout 
4. Fill out form 
5. Save reminder

Expected Result: User should be able to see their newly created reminder in the reminder list. Reminder remains after closing app and reopening the app.
Actual Result:
Pass/Fail:
Additional Information: Make sure details filled in the form are displayed accurately

Test Case 2: Reminder Notification

Steps:
1. Set reminder with time and date
2. Wait for the reminder alert

Expected Result: User should receive an alert at the set time and date of the alert
Actual Result:
Pass/Fail:
Additional Information: Alert displays the reminder description and gives the User the option to snooze or close the alert


Test Case 3: Editing Reminders

Steps:
1. Click the 'options' of an existing reminder
2. Choose 'Edit'
3. Modify details of reminder
4. Save changes

Expected Result: User should see that their changes have been saved, and the changes are displayed.
Actual Result:
Pass/Fail:
Additional Information: Changes should remain after closing and reopening app. If date and time was changed, user should be alerted at the new date and time and not the what it was previously set to.

Test Case 4: Reminder Deletion

Steps:
1. Click the 'options' of an existing reminder
2. Choose 'Delete'
3. Confirm deletion

Expected Result: User should be able to see that the deleted reminder is no longer in the reminder list. Reminder remains deleted after closing app and reopening the app.
Actual Result:
Pass/Fail:
Additional Information:

Test Case 5: Recurring Reminders

Steps: 
1. Set reminder with recurring event (i.e. Alert every 30 seconds)
2. Select the 'Repeat' option
3. Wait for repeating alerts

Expected Result: Reminder alert should occur at each specific recurrence.
Actual Result:
Pass/Fail:
Additional Information:

Test Case 6: Snooze button

Steps:
1. Set reminder with time and date
2. Wait for the reminder alert
3. Set alarm to snooze

Expected Result: Snoozed reminder should reoccur every 10 minutes.
Actual Result:
Pass/Fail:
Additional Information:

Test Case 7: Responsiveness to a large number of reminders

Steps:
1. Create 100+ reminders
2. Navigate through all the reminders

Expected Result: App should remain responsive with no lag while sifting through the reminders.
Actual Result:
Pass/Fail:
Additional Information: All 100+ reminders created should be present

Test Case 8: Search Bar

Steps:
1. Create small sample size of reminders
2. Click the Search Bar and search for a specfic reminder in the sample.

Expected Result: User search should be able to successfully sort out all matching reminders by name
Actual Result:
Pass/Fail:
Additional Information: Search function should find reminders with matching substrings and user input.

