package builders.cokies;

import java.util.ArrayList;
import java.util.List;

public class BuilderPatternDemo {
  private static final String TOTAL_COST = "Total Cost: ";

  public static void main(String[] args) {

    MealBuilder mealBuilder = new MealBuilder();

    Meal vegMeal = mealBuilder.prepareVegMeal();
    System.out.println("Veg Meal");
    vegMeal.showItems();
    System.out.println(TOTAL_COST + vegMeal.getCost());

    Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
    System.out.println("\n\nNon-Veg Meal");
    nonVegMeal.showItems();
    System.out.println(TOTAL_COST + nonVegMeal.getCost());

    Meal twoBurgerMeal = mealBuilder.prepareTwoBurgerMeal();
    System.out.println("\n\nTwo Burger Meal");
    twoBurgerMeal.showItems();
    System.out.println(TOTAL_COST + twoBurgerMeal.getCost());

    Meal twoDrinkMeal = mealBuilder.prepareTwoDrinkMeal();
    System.out.println("\n\nTwo Drink Meal");
    twoDrinkMeal.showItems();
    System.out.println(TOTAL_COST + twoDrinkMeal.getCost());

    System.out.println("\nWith Foreach loop.\n");
    List<Meal> meals = new ArrayList<Meal>();
    meals.add(mealBuilder.prepareVegMeal());
    meals.add(mealBuilder.prepareNonVegMeal());
    meals.add(mealBuilder.prepareTwoBurgerMeal());
    meals.add(mealBuilder.prepareTwoDrinkMeal());
    for (Meal meal : meals) {
      meal.showItems();
      System.out.println(TOTAL_COST + meal.getCost());
    }
  }
}
