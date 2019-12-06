package builders.cokies;

public class MealBuilder {

  public Meal prepareVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new VegBurger());
    meal.addItem(new Coke());
    return meal;
  }

  public Meal prepareNonVegMeal() {
    Meal meal = new Meal();
    meal.addItem(new ChickenBurger());
    meal.addItem(new Pepsi());
    return meal;
  }

  public Meal prepareTwoBurgerMeal() {
    Meal meal = new Meal();
    meal.addItem(new VegBurger());
    meal.addItem(new ChickenBurger());
    return meal;
  }

  public Meal prepareTwoDrinkMeal() {
    Meal meal = new Meal();
    meal.addItem(new Coke());
    meal.addItem(new Pepsi());
    return meal;
  }
}
