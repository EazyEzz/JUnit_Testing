package edu.qc.seclass.rlm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.qc.seclass.rlm.database.ReminderDB;

public class Homescreen extends AppCompatActivity {

    TextView date;
    Button newReminderHome;
    Button newListHome;
    LinearLayout categoriesContainer;
    SearchView homeSearchBar;
    Context context;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        newReminderHome = (Button) findViewById(R.id.newReminderHome);
        newListHome = (Button) findViewById(R.id.newListHome);
        homeSearchBar = findViewById(R.id.homeSearchBar);
        categoriesContainer = findViewById(R.id.categoriesContainer);
        context = this;

        setupSearchView();
        displayCategories();



        newReminderHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToRScreen = new Intent(Homescreen.this, NewReminder.class);
                Homescreen.this.startActivity(goToRScreen);
            }
        });

        newListHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToLScreen = new Intent(Homescreen.this, NewListPage.class);
                Homescreen.this.startActivity(goToLScreen);
            }
        });
    }
    private void displayCategories(){

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
                    List<String> childrenNames = new ArrayList<>();
                    for (DataSnapshot child : children) {
                        childrenNames.add(child.getKey());
                    }

                    // Now, childrenNames contains the names of the children ("chores", "Appointments")
                    //use this list as needed to display
                    for (String category : childrenNames) {
                        Button categoryButton = new Button(context);
                        categoryButton.setText(category);
                        categoryButton.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                //Navigate to ListPage with the selected category
                                Intent intent = new Intent(Homescreen.this, ListPage.class);
                                intent.putExtra("CATEGORY", category);
                                startActivity(intent);
                            }
                        });



                        categoriesContainer.addView(categoryButton);
                    }
                } else {

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setupSearchView(){
        homeSearchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                dismissPopupWindow();
                filterRemindersByTitle(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText){
                //filterRemindersByTitle(newText);
                return true;
            }
        });
    }
    private void filterRemindersByTitle(String query){

        try {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            String uid = user.getUid();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(uid);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        List<HashMap<String, Object>> allRemindersList = new ArrayList<>();

                        // Iterate through the children ("chores", "Appointments")
                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                            String category = childSnapshot.getKey();
                            // Get the list of reminders for each child
                            Iterable<DataSnapshot> reminderList = childSnapshot.getChildren();
                            // Iterate through the reminders in the list
                            for (DataSnapshot reminderSnapshot : reminderList) {
                                // Get the "name" field from each reminder
//                            String reminderName = (String) reminderSnapshot.child("name").getValue();
                                HashMap<String, Object> reminder = new HashMap<>();
                                String name = (String) reminderSnapshot.child("name").getValue();
                                String description = (String) reminderSnapshot.child("description").getValue();
                                boolean checked = (boolean) reminderSnapshot.child("check").getValue();

                                reminder.put("category", category);
                                reminder.put("name", name);
                                reminder.put("description", description);
                                reminder.put("checked", checked);

                                // Add the reminder name to the list
                                allRemindersList.add(reminder);
                            }
                        }

                        List<HashMap<String, Object>> filteredReminderList = new ArrayList<>();
                        for (HashMap<String, Object> reminder : allRemindersList) {

                            String name = (String) reminder.get("name");

                            if (name.toLowerCase().contains(query.toLowerCase())) {
                                filteredReminderList.add(reminder);
                            }

                        }
                        displayFilteredReminders(filteredReminderList);
                    } else {

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });
        }
        catch(Exception e){
            Toast.makeText(this, "filterRemindersByTitle: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
    private void displayFilteredReminders(List<HashMap<String, Object>> filteredReminderList) {
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        try {
            for (HashMap<String, Object> reminder : filteredReminderList) {
                String name = (String) reminder.getOrDefault("name", "Default");
                String category = (String) reminder.getOrDefault("category", "Default");
                boolean check = (boolean) reminder.getOrDefault("check", false);
                String description = (String) reminder.getOrDefault("description", "Default");

                Button reminderButton = new Button(this);

                reminderButton.setText(name);
                reminderButton.setOnClickListener(v -> {
                    //Intent to navigate to ListPage
                    Intent intent = new Intent(getApplicationContext(), ListPage.class);
                    intent.putExtra("REMINDER_name", name);
                    intent.putExtra("CATEGORY", category);
                    intent.putExtra("REMINDER_description", description);
                    startActivity(intent);
                });

                layout.addView(reminderButton);
            }
        }
        catch(Exception e){
            Toast.makeText(this, "DisplayFiltered ERROR: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

            popupWindow = new PopupWindow(layout, WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                if (homeSearchBar != null) {
                    popupWindow.showAsDropDown(homeSearchBar);
                }

        }

    private void dismissPopupWindow() {
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }
    }
}
