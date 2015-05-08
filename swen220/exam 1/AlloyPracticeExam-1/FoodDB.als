/**
 * A simple model of a food database.
 * Foods can be basic (like bread) or recipes (like a sandwich).
 * Recipes in the database have ingredients drawn from other foods
 *    (basic or recipes) in the database.
 * There may be foods and recipes that are not in the database (yet).
 */

/**
 * Foods are either but not both basic or a recipe.
 */
abstract sig Food {}
sig BasicFood extends Food{}
sig Recipe extends Food {
	ingredients : set Food
}

/**
 * The database is simply a set of foods.
 * Note that there is exactly one database, so
 * FDB.foods is all the foods known in the DB.
 */
one sig FDB {
	foods : set Food
}

/**
 * All recipes not in the database have no ingredients.
 */

fact RecipesNotInFDBDoNotHaveIngredients {
	// Fill in
}

/**
 * All recipes in the database have at least 2 ingredients.
 */
fact RecipesInFDBHaveTwoOrMoreIngredients {
	// Fill in
}

/**
 * All ingredients needed for a recipe in the database are also
 * in the database.
 */
fact RecipeIngredientsInDatabase {
	// Fill in
}

/**
 * No recipe is directly or indirectly an
 * ingredient of itself.
 * That is, the foods in the database form a DAG.
 */
fact NoRecipeCycles {
	// Fill in
}

/**
 * Assertion: All the ingredients needed for any recipe in the database,
 * either directly or indirectly, are also in the database.
 */
assert AllNecessaryIngredientsInDatabase {
	// Fill in
}
check AllNecessaryIngredientsInDatabase for 10

/**
 * If you run this predicate and you model is correct
 * you should get solutions.
 */
run {
	// some recipes have other recipes as ingredients
	some Recipe.ingredients & Recipe
	// some recipes have no ingredients
	some r : Recipe | no r.ingredients
} for exactly 10 Food
