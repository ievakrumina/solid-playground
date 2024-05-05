package singleresponsibilityprinciple

/**
 * Dog class is used in doggy daycare application.
 *
 * Violation reason: Methods correspond to different actors.
 * registerDog(..) - specified and used by onboarding/off-boarding department
 * registerHours(..) - specified and used by onboarding/off-boarding department
 * calculateCosts(..) - specified and used by financial department
 *
 * Issue #1: If multiple departments need to change requirements there is higher merge conflict risk.
 */

val dogListViolateExampleOne = mutableListOf<DogViolateExampleOne>()
class DogViolateExampleOne {

    var name: String = ""
    var hours: Int = 0
    var costs: Int = 0
    var toBePaidByOwner = 0

    fun registerDog(name: String) {
        this.name = name
        dogListViolateExampleOne.add(this)
    }

    private fun findDogInDataSource(dogName: String): Pair<Int, DogViolateExampleOne> {
        val dogObj = dogListViolateExampleOne.find { it.name == dogName } ?: throw Error("Dog not found")
        val index = dogListViolateExampleOne.indexOf(dogObj)
        return Pair(index, dogObj)
    }

    private fun calculateFoodEaten(hours: Int): Int = hours * 5

    fun registerHours(dogName: String, hours: Int) {
        val (_, dogObj) = findDogInDataSource(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours)
        val costs = foodEatenCoefficient + hours * 15
        dogObj.apply {
            this.hours = hours
            this.costs = costs
        }
    }

    fun calculateCost(dogName: String, ownFood: Boolean) {
        val (_, dogObj) = findDogInDataSource(dogName)
        val foodEatenCoefficient = calculateFoodEaten(hours = dogObj.hours)
        dogObj.toBePaidByOwner =  if (ownFood) {
            dogObj.costs - foodEatenCoefficient
        } else {
            dogObj.costs
        }
    }
}