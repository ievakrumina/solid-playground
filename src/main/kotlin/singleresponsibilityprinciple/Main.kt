package singleresponsibilityprinciple

import utils.printSectionName
import kotlin.random.Random

/**
 * Def: The module should be responsible to one, and only one, actor.
 */

fun main(args: Array<String>) {

    // Data for examples and calculations
    val randomHours = List(size = args.size) {
        Random.nextInt(0, 13)
    }

    val randomOwnFood = List(size = args.size) {
        Random.nextInt(0, 2) != 0
    }

    printSectionName("Violate example #1")
    violateExampleOne(args, randomHours, randomOwnFood)

    printSectionName("Violate example #2")
    violateExampleTwo(args, randomHours, randomOwnFood)

    printSectionName("Solution example #1")
    solutionExampleOne(args, randomHours, randomOwnFood)

    printSectionName("Solution example #2")
    solutionExampleTwo(args, randomHours, randomOwnFood)
}

private fun violateExampleOne(args: Array<String>, randomHours: List<Int>, randomOwnFood: List<Boolean>) {
    args.forEachIndexed { index, name ->
        val dogClass = DogViolateExampleOne()
        dogClass.registerDog(name)
        dogClass.registerHours(name, randomHours[index])
    }
    println("EOD doggy daycare report:")
    dogListViolateExampleOne.forEachIndexed { index, obj ->
        obj.calculateCost(obj.name, randomOwnFood[index])
        println("Name: ${obj.name} hours spent: ${obj.hours}, total costs: ${obj.costs}, paid by owner: ${obj.toBePaidByOwner}")
    }
}

private fun violateExampleTwo(args: Array<String>, randomHours: List<Int>, randomOwnFood: List<Boolean>) {
    args.forEachIndexed { index, name ->
        val dogClass = DogViolateExampleTwo()
        dogClass.registerDog(name)
        dogClass.registerHours(name, randomHours[index])
    }
    println("EOD doggy daycare report:")
    dogListViolateExampleTwo.forEachIndexed { index, obj ->
        obj.calculateCost(obj.name, randomOwnFood[index])
        println("Name: ${obj.name} hours spent: ${obj.hours}, total costs: ${obj.costs}, paid by owner: ${obj.toBePaidByOwner}")
    }
}

fun solutionExampleOne(args: Array<String>, randomHours: List<Int>, randomOwnFood: List<Boolean>) {
    val register = DogRegister()
    val costs = DogCalculateCosts()
    args.forEachIndexed { index, name ->
        register.registerDog(name)
        register.registerHours(name, randomHours[index])
    }
    dogListSolutionExampleOne.forEachIndexed { index, obj ->
        costs.calculateCost(obj.name, randomOwnFood[index])
    }
    println("EOD doggy daycare report:")
    dogListSolutionExampleOne.forEach {
        println("Name: ${it.name} hours spent: ${it.hours}, total costs: ${it.costs}, paid by owner: ${it.toBePaidByOwner}")

    }
}

fun solutionExampleTwo(args: Array<String>, randomHours: List<Int>, randomOwnFood: List<Boolean>) {
    val dog = DogFacade()
    args.forEachIndexed { index, name ->
        dog.registerDog(name)
        dog.registerHours(name, randomHours[index])
    }
    dogListSolutionExampleTwo.forEachIndexed { index, obj ->
        dog.calculateCost(obj.name, randomOwnFood[index])
    }

    println("EOD doggy daycare report:")
    dogListSolutionExampleTwo.forEach {
        println("Name: ${it.name} hours spent: ${it.hours}, total costs: ${it.costs}, paid by owner: ${it.toBePaidByOwner}")

    }
}

