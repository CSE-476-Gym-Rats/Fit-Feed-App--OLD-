package com.example.fitfeed.models;

/**
 * Class to model an individual exercise
 */
public class Exercise {
    private String name;
    private int sets;
    private int reps;
    private float weight;

    public Exercise(String name, int sets, int reps, float weight) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

}
