package com.example.fitfeed.viewAdapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fitfeed.R;
import com.example.fitfeed.models.Workout;

import java.util.List;

/**
 * RecyclerViewAdapter for Social tab's feed.
 */
public class PostsRecyclerViewAdapter extends RecyclerView.Adapter<PostsRecyclerViewAdapter.ViewHolder> {

    private List<Workout> workouts;
    private LayoutInflater inflater;

    public PostsRecyclerViewAdapter(Context context, List<Workout> workouts) {
        this.inflater = LayoutInflater.from(context);
        this.workouts = workouts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Use the workout name as the caption
        Workout workout = workouts.get(position);
        holder.textView.setText(workout.getWorkoutName());
        holder.imageView.setImageResource(R.drawable.placeholder1);
    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.postTextView);
            imageView = itemView.findViewById(R.id.postImageView);
        }
    }
}
