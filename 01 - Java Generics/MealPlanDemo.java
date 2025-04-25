import java.util.*;
interface MealPlan {
    String getPlan();
}
class VegetarianMeal implements MealPlan {
    public String getPlan() {
        return "Vegetarian Meal Plan";
    }
}
class VeganMeal implements MealPlan {
    public String getPlan() {
        return "Vegan Meal Plan";
    }
}
class KetoMeal implements MealPlan {
    public String getPlan() {
        return "Keto Meal Plan";
    }
}
class Meal<T extends MealPlan> {
    T plan;
    public Meal(T plan) {
        this.plan = plan;
    }
    public T getPlan() {
        return plan;
    }
}
class MealGenerator {
    public static <T extends MealPlan> void generatePlan(T plan) {
        System.out.println("Generated: " + plan.getPlan());
    }
}

public class MealPlanDemo {
    public static void main(String[] args) {
        VegetarianMeal veg = new VegetarianMeal();
        VeganMeal vegan = new VeganMeal();
        KetoMeal keto = new KetoMeal();
        MealGenerator.generatePlan(veg);
        MealGenerator.generatePlan(vegan);
        MealGenerator.generatePlan(keto);
    }
}
