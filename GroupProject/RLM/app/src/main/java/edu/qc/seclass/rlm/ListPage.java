package edu.qc.seclass.rlm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ContextThemeWrapper;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.qc.seclass.rlm.database.MockDatabase;
import edu.qc.seclass.rlm.database.ReminderDB;
public class ListPage extends AppCompatActivity {

    Button newReminderList;
    Button goHome;
    LinearLayout linearLayout;
    TextView listTitle;

    Button deleteList;

    private String category;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        listTitle = findViewById(R.id.listTitle);
        newReminderList = (Button) findViewById(R.id.listScreenButton);
        goHome = (Button) findViewById(R.id.goHomeFromListPage);
        linearLayout = findViewById(R.id.reminderContainer);
        deleteList = findViewById(R.id.deleteListButton);


        handleIntent();

        newReminderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToScreen = new Intent(ListPage.this, NewReminder.class);

                goToScreen.putExtra("CATEGORY", category);
                ListPage.this.startActivity(goToScreen);
            }
        });


        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeScreen = new Intent(ListPage.this, Homescreen.class);
                ListPage.this.startActivity(goToHomeScreen);
            }
        });

        deleteList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                FirebaseUser user = auth.getCurrentUser();
                String uid = user.getUid();

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference(uid);
                DatabaseReference categoryRef = myRef.child(category); //REPLACE WITH REMINDERTYPE
                categoryRef.removeValue();

                Intent goToHomeScreen = new Intent(ListPage.this, Homescreen.class);
                ListPage.this.startActivity(goToHomeScreen);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        handleIntent();
    }
    private void handleIntent(){
        Intent intent = getIntent();

        String reminderID = intent.getStringExtra("REMINDER_ID");
        String name = intent.getStringExtra("REMINDER_name");
        category = intent.getStringExtra("CATEGORY");
        String description = intent.getStringExtra("REMINDER_description");


        //String category, name, description

//        if(reminderID != null){
//            category = findCategoryByReminderID(reminderID);
//        }else{
//            category = intent.getStringExtra("CATEGORY");
//        }

        if(category != null){
            listTitle.setText(category);
            displayReminders(category);
        }
    }
    private String findCategoryByReminderID(String reminderID){
        MockDatabase db = MockDatabase.getInstance();
        return db.getCategoryByReminderID(reminderID);
    }
    private void displayReminders(String category){


        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();

        String uid = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference categoryRef = rootRef.child(uid).child(category);

        ArrayList<HashMap<String, Object>> categoryList = new ArrayList<>();

        Context context = this;
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()){
                    HashMap<String, Object> map = (HashMap<String, Object>)ds.getValue();
                    categoryList.add(map);
                }
                linearLayout.removeAllViews(); //clear previous views


                for(HashMap<String, Object> map : categoryList) {

                    // get values from hashmap
                    String name = (String) map.get("name");
                    String description = (String) map.get("description");
                    Boolean checked = (Boolean) map.get("check");


                    LinearLayout reminderMainLayout = new LinearLayout(context);
                    reminderMainLayout.setOrientation(LinearLayout.VERTICAL);
                    reminderMainLayout.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    //Horizontal layout for displaying reminder details
                    LinearLayout reminderDisplayLayout = new LinearLayout(context);
                    reminderDisplayLayout.setOrientation(LinearLayout.HORIZONTAL);
                    reminderDisplayLayout.setLayoutParams(new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    ));

                    //TextView for displaying reminder details
                    TextView textView = new TextView(new ContextThemeWrapper(context, R.style.ReminderTextViewStyle), null, 0);
                    textView.setText(name + " ---> " + description);
                    reminderDisplayLayout.addView(textView);

                    //Horizontal layout for buttons
                    LinearLayout buttonLayout = new LinearLayout(context);
                    buttonLayout.setOrientation(LinearLayout.HORIZONTAL);

                    //EditTexts for editing (initially hidden)
                    EditText editTitle = new EditText(context);
                    editTitle.setText(name);
                    editTitle.setVisibility(View.GONE);
                    EditText editDescription = new EditText(context);
                    editDescription.setText(description);
                    editDescription.setVisibility(View.GONE);

                    //Add EditTexts to the same layout as TextView
                    reminderDisplayLayout.addView(editTitle);
                    reminderDisplayLayout.addView(editDescription);

                    //Add the display layout to the main layout
                    reminderMainLayout.addView(reminderDisplayLayout);

                    //Edit, Save, Cancel, Delete Buttons
                    Button editButton = new Button(context);
                    editButton.setText("Edit");
                    Button saveButton = new Button(context);
                    saveButton.setText("Save");
                    saveButton.setVisibility(View.GONE);
                    Button cancelButton = new Button(context);
                    cancelButton.setText("Cancel");
                    cancelButton.setVisibility(View.GONE);
                    Button deleteButton = new Button(context);
                    deleteButton.setText("Delete");

                    buttonLayout.addView(editButton);
                    buttonLayout.addView(saveButton);
                    buttonLayout.addView(cancelButton);
                    buttonLayout.addView(deleteButton);

                    reminderMainLayout.addView(buttonLayout);

                    //Edit Button onClickListener
                    editButton.setOnClickListener(v -> {
                        //Toggle visibility for editing
                        textView.setVisibility(View.GONE);
                        editTitle.setVisibility(View.VISIBLE);
                        editDescription.setVisibility(View.VISIBLE);
                        editButton.setVisibility(View.GONE);
                        saveButton.setVisibility(View.VISIBLE);
                        cancelButton.setVisibility(View.VISIBLE);
                    });

                    deleteButton.setOnClickListener(v -> {

                        //////////////////////////////////////DELETE FIREBASE BY CATEGORY AND NAME (FIRST ONE)//////////////////////////////////////////////////////////
                        FirebaseAuth auth = FirebaseAuth.getInstance();
                        FirebaseUser user = auth.getCurrentUser();

                        //DELETE REMINDER
                        String uid = user.getUid();


                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference(uid);
                        DatabaseReference appointmentsRef = myRef.child(category); //REPLACE WITH REMINDERTYPE

                        appointmentsRef.addListenerForSingleValueEvent(new ValueEventListener(){
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                List<Map<String, Object>> appointments = (List<Map<String, Object>>) snapshot.getValue();
                                for(Map<String, Object> appointment : appointments) {
                                    if(appointment.get("name").equals(name) && appointment.get("description").equals(description)) { //REPLACE HW WITH THE NAME OF THE REMINDER YOU WANT TO DELETE
                                        appointments.remove(appointment);
                                        break;
                                    }
                                }
                                appointmentsRef.setValue(appointments);
                                displayReminders(category);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        ////////////////////////////////////// END DELETE FIREBASE BY CATEGORY AND NAME (FIRST ONE)//////////////////////////////////////////////////////////

                    });

                    //Save Button onClickListener
                    saveButton.setOnClickListener(v -> {
                        //Update DB
                        String newTitle = editTitle.getText().toString();
                        String newDescription = editDescription.getText().toString();


                        ////////////////////////////////////////////////////////////////EDIT REMINDER TO LIST////////////////////////////////////////////////////////////////////////
                        FirebaseAuth auth = FirebaseAuth.getInstance();
                        FirebaseUser user = auth.getCurrentUser();
                        // The user is signed in
                        String uid = user.getUid();


                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                        DatabaseReference myRef = database.getReference(uid);
                        DatabaseReference categoryRef = myRef.child(category);

                        categoryRef.addListenerForSingleValueEvent(new ValueEventListener(){
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                List<Map<String, Object>> reminderList = (List<Map<String, Object>>) snapshot.getValue();

                                // Appointments list fetched, now delete specific item
                                for(Map<String, Object> actualReminder : reminderList) {
                                    if(actualReminder.get("name").equals(name) && actualReminder.get("description").equals(description)) {
                                        actualReminder.put("description", newDescription);
                                        actualReminder.put("name", newTitle);
                                        actualReminder.put("check", false);
                                        break;
                                    }
                                }
                                categoryRef.setValue(reminderList);
//                                reminder.setTitle(newTitle);
//                                reminder.setDescription(newDescription);
//                                db.editReminder(reminder);
                                displayReminders(category);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
////////////////////////////////////////////////////////////////END EDIT REMINDER TO LIST////////////////////////////////////////////////////////////////////////

                    });

                    linearLayout.addView(reminderMainLayout);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        };

        categoryRef.addListenerForSingleValueEvent(valueEventListener);

    }
}
