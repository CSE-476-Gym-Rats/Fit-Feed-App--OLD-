package com.example.fitfeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewWorkoutActivity extends AppCompatActivity {

    private Button addExerciseButton; // Button to add new exercise
    private LinearLayout linearLayoutContainer; // Exercise rows

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        linearLayoutContainer = findViewById(R.id.linearLayoutContainer);
        addExerciseButton = findViewById(R.id.addExerciseButton);
        addExerciseButton.setOnClickListener(v -> addNewExerciseRow());
    }

    /**
     * Insert a new exercise row
     * Called when "Add Exercise" is pressed
     */
    private void addNewExerciseRow() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View newRow = inflater.inflate(R.layout.exercise_row, null);

        // Insert the new row above the "Add Exercise" button
        int index = linearLayoutContainer.indexOfChild(addExerciseButton);
        linearLayoutContainer.addView(newRow, index);
    }
}