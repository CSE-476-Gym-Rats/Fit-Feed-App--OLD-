package com.example.fitfeed.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfeed.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NewWorkoutActivity extends AppCompatActivity {

    private Button addExerciseButton;
    private FloatingActionButton cancelButton;
    private FloatingActionButton saveButton;
    private LinearLayout exerciseRows; // Exercise rows

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        // Listener for addExerciseButton
        exerciseRows = findViewById(R.id.linearLayoutContainer);
        addExerciseButton = findViewById(R.id.addExerciseButton);
        addExerciseButton.setOnClickListener(v -> addNewExerciseRow());

        // Listener for cancel
        cancelButton = this.findViewById(R.id.cancelNewWorkout);
        cancelButton.setOnClickListener(v -> finish());

        // Listener for save
        saveButton = this.findViewById(R.id.saveNewWorkout);
        saveButton.setOnClickListener(v -> saveWorkout());
    }

    /**
     * Insert a new exercise row
     * Called when "Add Exercise" is pressed
     */
    private void addNewExerciseRow() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View newRow = inflater.inflate(R.layout.exercise_row, null);

        // Insert the new row above the "Add Exercise" button
        int index = exerciseRows.indexOfChild(addExerciseButton);
        exerciseRows.addView(newRow, index);
    }

    /**
     * Save a workout to JSON format
     * Called when saveButton is pressed
     */
    private void saveWorkout() {
        finish();
    }

}