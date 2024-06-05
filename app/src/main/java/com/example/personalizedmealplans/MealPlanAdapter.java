package com.example.personalizedmealplans;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.MealViewHolder> {

    private List<Meal> mealPlan;

    public MealPlanAdapter(List<Meal> mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void setMealPlan(List<Meal> mealPlan) {
        this.mealPlan = mealPlan;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meal, parent, false);
        return new MealViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MealViewHolder holder, int position) {
        Meal meal = mealPlan.get(position);
        holder.textViewDay.setText(meal.getDay());
        holder.textViewBreakfast.setText(meal.getBreakfast());
        holder.textViewLunch.setText(meal.getLunch());
        holder.textViewDinner.setText(meal.getDinner());
    }

    @Override
    public int getItemCount() {
        return mealPlan.size();
    }

    static class MealViewHolder extends RecyclerView.ViewHolder {
        TextView textViewDay, textViewBreakfast, textViewLunch, textViewDinner;

        MealViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDay = itemView.findViewById(R.id.textViewDay);
            textViewBreakfast = itemView.findViewById(R.id.textViewBreakfast);
            textViewLunch = itemView.findViewById(R.id.textViewLunch);
            textViewDinner = itemView.findViewById(R.id.textViewDinner);
        }
    }
}
