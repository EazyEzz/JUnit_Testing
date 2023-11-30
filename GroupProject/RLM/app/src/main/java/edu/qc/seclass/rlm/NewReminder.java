package edu.qc.seclass.rlm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID; //generates unique ID's

import edu.qc.seclass.rlm.database.MockDatabase;
import edu.qc.seclass.rlm.database.ReminderDB;

public class NewReminder extends AppCompatActivity {

    private Button createReminder;
    private Button goHome;
    private EditText reminderTitleInput;
    private EditText reminderDescriptionInput;
    private MockDatabase mockDatabase;
    private Spinner spinner;

    private String initialCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_reminder);

        spinner = findViewById(R.id.spinnerReminderList);

        //retrieve array
//        String[] items = getResources().getStringArray(R.array.your_dropdown_items);
//
//        //convert to list and sort
//        List<String> itemList = new ArrayList<>(Arrays.asList(items));
//        //Collections.sort(itemList);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this, android.R.layout.simple_spinner_item, itemList
//        );
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        initializeCategories();

        loadCategoriesIntoSpinner();

        mockDatabase = MockDatabase.getInstance();

        //Initialize input fields
        reminderTitleInput = findViewById(R.id.EditReminderNameInput);
        reminderDescriptionInput = findViewById(R.id.EditReminderDescription);

        createReminder = (Button) findViewById(R.id.createReminderButton);
        goHome = (Button) findViewById(R.id.goHomeFromNewReminder);

        Intent intent = getIntent();
        initialCategory = intent.getStringExtra("CATEGORY");

        createReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = reminderTitleInput.getText().toString();
                String description = reminderDescriptionInput.getText().toString();
                String category = spinner.getSelectedItem().toString();

                //create a new Reminder
                ReminderDB newReminder = new ReminderDB(
                        name, description, category
                );

                mockDatabase.addReminder(newReminder);
                ////////////////////////////////////////////////////////////////ADD REMINDER TO LIST////////////////////////////////////////////////////////////////////////
                //ADD REMIDNER
                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser user = auth.getCurrentUser();
                String uid = user.getUid();



                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid);
                DatabaseReference appointmentsRef = myRef.child(category); //REPLACE WITH REMINDERTYPE


                appointmentsRef.addListenerForSingleValueEvent(new ValueEventListener(){

                    //...

                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        List<Map<String, Object>> appointments = new ArrayList<>();
                        if (snapshot.hasChildren()) {
                            // Data exists, read as list
                            appointments = (List<Map<String, Object>>) snapshot.getValue();
                        }

                        // Appointments list fetched
                        Map<String, Object> newReminder = new HashMap<>(); // REPLACE WITH REMINDERTYPE
                        newReminder.put("name", name);
                        newReminder.put("description", description);
                        newReminder.put("check", false);

                        appointments.add(newReminder);
                        appointmentsRef.setValue(appointments);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

////////////////////////////////////////////////////////////////END ADD REMINDER TO LIST////////////////////////////////////////////////////////////////////////


                Intent goToScreen = new Intent(NewReminder.this, ListPage.class);
                goToScreen.putExtra("CATEGORY", category); //passing category as extra
                startActivity(goToScreen);
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeScreen = new Intent(NewReminder.this, Homescreen.class);
                NewReminder.this.startActivity(goToHomeScreen);
            }
        });
    }
    private void loadCategoriesIntoSpinner(){
        SharedPreferences prefs = getSharedPreferences("categoryPref", MODE_PRIVATE);




        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        String uid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(uid);
        Context context = this;

        // Attach a listener to read the data at the uid reference
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    // dataSnapshot is the snapshot of the data at this location
                    // In this example, dataSnapshot will contain userReminderLists

                    // Get the children's names as a list of strings
                    Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                    List<String> categories = new ArrayList<>();
                    for (DataSnapshot child : children) {
                        categories.add(child.getKey());
                    }

                    // Now, childrenNames contains the names of the children ("chores", "Appointments")
                    // You can use this list as needed

                    //CHILDRENNAMES IS A SET OF STRINGS REFERING TO THE REMNIDERTYPE OF THE SPECIFIC USER

                    //////

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(
                            context, android.R.layout.simple_spinner_item, new ArrayList<>(categories)
                    );
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);

                    // Assuming 'CATEGORY' is a known value, set it as the default selection
                    String categoryIntent = initialCategory; // replace with your actual intent value
                    int index = categories.indexOf(categoryIntent);
                    if (index >= 0) {
                        spinner.setSelection(index);
                    }
                } else {
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



//        Set<String> categories = prefs.getStringSet("categories", new HashSet<>());
//
//        //////
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this, android.R.layout.simple_spinner_item, new ArrayList<>(categories)
//        );
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
    }

    private void initializeCategories(){
        SharedPreferences prefs = getSharedPreferences("categoryPref", MODE_PRIVATE);
        if(!prefs.contains("categoriesLoaded")){
            loadInitialCategories(prefs);
            prefs.edit().putBoolean("categoriesLoaded", true).apply();
        }
    }
    private void loadInitialCategories(SharedPreferences prefs){
        String[] items = getResources().getStringArray(R.array.your_dropdown_items);
        Set<String> categorySet = new HashSet<>(Arrays.asList(items));
        prefs.edit().putStringSet("categories", categorySet).apply();
    }
}
