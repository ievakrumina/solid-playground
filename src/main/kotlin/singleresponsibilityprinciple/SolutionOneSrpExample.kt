package singleresponsibilityprinciple

/**
 * Dog class is used in doggy daycare application.
 *
 * Solution #1:
 * Extract data class
 * Split methods into two separate classes based on actor
 * These classes don't know about each other
 * These classes only know about common Dog data object
 */

val dogListSolutionExampleOne = mutableListOf<DogSolutionOne>()

data class DogSolutionOne (
    val name: String,
    val hours: Int = 0,
    val costs: Int = 0,
    val toBePaidByOwner: Int = 0,
)

class DogRegister {
    fun registerDog(name: String) {
        val newDog = DogSolutionOne(name = name)
        dogListSolutionExampleOne.add(newDog)
    }

    private fun calculateFoodEaten(hours: Int): Int = hours * 5 + 2

    fun registerHours(dogName: String, hours: Int) {
        val (index, dogObj) = findDogInDataSourceOne(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours)
        val costs = foodEatenCoefficient + hours * 15
        dogListSolutionExampleOne[index] = dogObj.copy(hours = hours, costs = costs)
    }

}

class DogCalculateCosts {

    private fun calculateFoodEaten(hours: Int): Int = hours * 5

    fun calculateCost(dogName: String, ownFood: Boolean) {
        val (index, dogObj) = findDogInDataSourceOne(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours = dogObj.hours)
        val toBePaidByOwner =  if (ownFood) {
            dogObj.costs - foodEatenCoefficient
        } else {
            dogObj.costs
        }
        dogListSolutionExampleOne[index] = dogObj.copy(toBePaidByOwner = toBePaidByOwner)
    }
}

// Util
fun findDogInDataSourceOne(dogName: String): Pair<Int, DogSolutionOne> {
    val dogObj = dogListSolutionExampleOne.find { it.name == dogName } ?: throw Error("Dog not found")
    val index = dogListSolutionExampleOne.indexOf(dogObj)
    return Pair(index, dogObj)
}