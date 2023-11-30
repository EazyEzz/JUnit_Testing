package edu.qc.seclass.rlm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.SharedPreferences;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NewListPage extends AppCompatActivity {

    Button createList;
    Button goHome;
    EditText newCategoryInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_page);

        createList = (Button) findViewById(R.id.buttonCreateList);
        goHome = (Button) findViewById(R.id.goHomefromNewList);
        newCategoryInput = (EditText) findViewById(R.id.inputCategory);

        createList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newCategory = newCategoryInput.getText().toString().trim();
                if(!newCategory.isEmpty()){
                    addCategoryToSharedPreferences(newCategory);
                    //Redirect to ListPage
                    Intent goToRScreen = new Intent(NewListPage.this, ListPage.class);
                    goToRScreen.putExtra("CATEGORY", newCategory); //passing category as extra
                    NewListPage.this.startActivity(goToRScreen);
                } else {
                    Toast.makeText(NewListPage.this, "Please Enter A Category Name", Toast.LENGTH_SHORT).show();
                }

//                Intent goToRScreen = new Intent(NewListPage.this, ListPage.class);
//
//                NewListPage.this.startActivity(goToRScreen);
            }
        });
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToHomeScreen = new Intent(NewListPage.this, Homescreen.class);
                NewListPage.this.startActivity(goToHomeScreen);
            }
        });
    }
    private void addCategoryToSharedPreferences(String newCategory){
        SharedPreferences prefs = getSharedPreferences("categoryPref", MODE_PRIVATE);
        Set<String> categories = prefs.getStringSet("categories", new HashSet<>());
        if(categories.add(newCategory)){
            prefs.edit().putStringSet("categories", categories).apply();


            ///////////////////////////////////////////////////////////////ADD REMINDER TYPE (PLACEHOLDER PROBLEM)////////////////////////////////////////////////////////////////////////

            //ADD REMIDNER TYPE
            FirebaseAuth auth = FirebaseAuth.getInstance();
            FirebaseUser user = auth.getCurrentUser();
            String uid = user.getUid();





            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference(uid);
            DatabaseReference newReminderTypeRef = myRef.child(newCategory); //REPLACE WITH REMINDERTYPE


            newReminderTypeRef.addListenerForSingleValueEvent(new ValueEventListener(){

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
                    newReminder.put("name", "PLACEHOLDER");
                    newReminder.put("description", "PLACEHOLDER");
                    newReminder.put("check", false);

                    appointments.add(newReminder);
                    newReminderTypeRef.setValue(appointments);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
///////////////////////////////////////////////////////////////ADD REMINDER TYPE////////////////////////////////////////////////////////////////////////
            //////////////////////////////////////////////////////////////////////////////////////////

            Toast.makeText(this, "New Category Added", Toast.LENGTH_SHORT).show();








            //////////////////////////////////////////////////////////////////////////////////////////

        } else{
            Toast.makeText(this, "Category Already Exists, Try Again", Toast.LENGTH_SHORT).show();
        }
    }
}