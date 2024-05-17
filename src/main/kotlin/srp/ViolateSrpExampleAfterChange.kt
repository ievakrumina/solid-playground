package srp

/**
 * Dog class is used in doggy daycare application.
 *
 * Violation reason: Methods correspond to different actors.
 * registerDog(..) - specified and used by onboarding/off-boarding department
 * registerHours(..) - specified and used by onboarding/off-boarding department
 * calculateCosts(..) - specified and used by financial department
 *
 * Issue #2: Since registerHours(..) and calculateCosts(..) uses same logic for food costs, the code is
 * extracted. If onboarding/off-boarding department want to change the  logic, it my unintentionally affect
 * calculateCosts(..) as well.
 */

val dogListViolateExampleTwo = mutableListOf<DogViolateExampleTwo>()
class DogViolateExampleTwo() {


    var name: String = ""
    var hours: Int = 0
    var costs: Int = 0
    var toBePaidByOwner = 0

    fun registerDog(name: String) {
        this.name = name
        dogListViolateExampleTwo.add(this)
    }

    private fun findDogInDataSource(dogName: String): Pair<Int, DogViolateExampleTwo> {
        val dogObj = dogListViolateExampleTwo.find { it.name == dogName } ?: throw Error("Dog not found")
        val index = dogListViolateExampleTwo.indexOf(dogObj)
        return Pair(index, dogObj)
    }

    private fun calculateFoodEaten(hours: Int): Int = hours * 5 + 2 // Coefficient for snacks

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