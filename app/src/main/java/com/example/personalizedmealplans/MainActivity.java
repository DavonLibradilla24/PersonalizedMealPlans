package com.example.personalizedmealplans;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAge, editTextWeight, editTextHeight, editTextDietaryPreferences, editTextHealthGoals, editTextDietaryRestrictions;
    private Button buttonSubmit;
    private RecyclerView recyclerViewMealPlan;
    private MealPlanAdapter mealPlanAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAge = findViewById(R.id.editTextAge);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextDietaryPreferences = findViewById(R.id.editTextDietaryPreferences);
        editTextHealthGoals = findViewById(R.id.editTextHealthGoals);
        editTextDietaryRestrictions = findViewById(R.id.editTextDietaryRestrictions);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        recyclerViewMealPlan = findViewById(R.id.recyclerViewMealPlan);

        recyclerViewMealPlan.setLayoutManager(new LinearLayoutManager(this));
        mealPlanAdapter = new MealPlanAdapter(new ArrayList<>());
        recyclerViewMealPlan.setAdapter(mealPlanAdapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateMealPlan();
            }
        });
    }

    private void generateMealPlan() {
        int age = Integer.parseInt(editTextAge.getText().toString());
        float weight = Float.parseFloat(editTextWeight.getText().toString());
        float height = Float.parseFloat(editTextHeight.getText().toString());
        String dietaryPreferences = editTextDietaryPreferences.getText().toString();
        String healthGoals = editTextHealthGoals.getText().toString();
        String dietaryRestrictions = editTextDietaryRestrictions.getText().toString();

        List<Meal> mealPlan = calculateMealPlan(age, weight, height, dietaryPreferences, healthGoals, dietaryRestrictions);

        mealPlanAdapter.setMealPlan(mealPlan);
    }

    private List<Meal> calculateMealPlan(int age, float weight, float height, String dietaryPreferences, String healthGoals, String dietaryRestrictions) {
        // Placeholder logic for generating meal plan
        List<Meal> mealPlan = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            mealPlan.add(new Meal("Day " + (i+1), "Breakfast: Oatmeal", "Lunch: Salad", "Dinner: Grilled Chicken"));
        }
        return mealPlan;
    }
}
