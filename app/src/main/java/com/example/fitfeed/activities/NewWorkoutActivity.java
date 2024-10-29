package com.example.fitfeed.activities;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfeed.R;
import com.example.fitfeed.models.Workout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.ZonedDateTime;

public class NewWorkoutActivity extends AppCompatActivity {

    private Button addExerciseButton;
    private FloatingActionButton cancelButton;
    private FloatingActionButton saveButton;
    private LinearLayout exerciseRows;
    private Workout workout = new Workout();

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
     * Save a workout to json format
     * Called when saveButton is pressed
     */
    private void saveWorkout() {
        try {
            // Loop through the exercise rows
            for (int i = 0; i < exerciseRows.getChildCount(); i++) {
                View exerciseRow = exerciseRows.getChildAt(i);
                if (exerciseRow instanceof LinearLayout) {

                    EditText editExerciseName = exerciseRow.findViewById(R.id.editExerciseName);
                    EditText editSets = exerciseRow.findViewById(R.id.editSets);
                    EditText editReps = exerciseRow.findViewById(R.id.editReps);
                    EditText editWeight = exerciseRow.findViewById(R.id.editWeight);

                    String name = editExerciseName.getText().toString();
                    int sets = Integer.parseInt(editSets.getText().toString());
                    int reps = Integer.parseInt(editReps.getText().toString());
                    float weight = Float.parseFloat(editWeight.getText().toString());

                    workout.addExercise(name, sets, reps, weight);
                }
            }

            // Convert Workout to json
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(workout);

            // Save json to file
            saveToFile(json);
            Toast.makeText(this, "Workout saved successfully!", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e("NewWorkoutActivity", e.toString());
            Toast.makeText(this, "Error saving workout: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    /**
     * Save JSON string to file "workouts.json"
     */
    private void saveToFile(String json) throws IOException {
        String filename = "workouts.json";
        try (FileOutputStream fos = openFileOutput(filename, Context.MODE_PRIVATE)) {
            fos.write(json.getBytes());
        } catch (IOException e) {
            Log.e("NewWorkoutActivity", e.toString());
            throw e;
        }
    }

}