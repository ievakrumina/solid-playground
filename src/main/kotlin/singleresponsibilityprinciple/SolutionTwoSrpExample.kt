package singleresponsibilityprinciple

/**
 * Dog class is used in doggy daycare application.
 *
 * Solution #2:
 * Extract data class
 * Use facade pattern.
 * DogFacade() will initiate and delegate to classe with functions
 */

val dogListSolutionExampleTwo = mutableListOf<DogSolutionTwo>()

data class DogSolutionTwo(
    val name: String,
    val hours: Int = 0,
    val costs: Int = 0,
    val toBePaidByOwner: Int = 0,
)

class DogFacade {
    fun registerDog(name: String) = DogRegisterTwo().registerDog(name)
    fun registerHours(dogName: String, hours: Int) = DogRegisterTwo().registerHours(dogName, hours)
    fun calculateCost(dogName: String, ownFood: Boolean) = DogCalculateCostsTwo().calculateCost(dogName, ownFood)
}

private class DogRegisterTwo {
    fun registerDog(name: String) {
        val newDog = DogSolutionTwo(name = name)
        dogListSolutionExampleTwo.add(newDog)
    }

    private fun calculateFoodEaten(hours: Int): Int = hours * 5 + 2

    fun registerHours(dogName: String, hours: Int) {
        val (index, dogObj) = findDogInDataSourceTwo(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours)
        val costs = foodEatenCoefficient + hours * 15
        dogListSolutionExampleTwo[index] = dogObj.copy(hours = hours, costs = costs)
    }

}

private class DogCalculateCostsTwo {

    private fun calculateFoodEaten(hours: Int): Int = hours * 5

    fun calculateCost(dogName: String, ownFood: Boolean) {
        val (index, dogObj) = findDogInDataSourceTwo(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours = dogObj.hours)
        val toBePaidByOwner = if (ownFood) {
            dogObj.costs - foodEatenCoefficient
        } else {
            dogObj.costs
        }
        dogListSolutionExampleTwo[index] = dogObj.copy(toBePaidByOwner = toBePaidByOwner)
    }
}

// Util
fun findDogInDataSourceTwo(dogName: String): Pair<Int, DogSolutionTwo> {
    val dogObj = dogListSolutionExampleTwo.find { it.name == dogName } ?: throw Error("Dog not found")
    val index = dogListSolutionExampleTwo.indexOf(dogObj)
    return Pair(index, dogObj)
}