package openclosedprinciple

import java.time.LocalDate

data class Dog(
    val id: Int,
    val name: String,
    val hours: Int,
    val food: Int,
    val trainingHours: Int,
    val cost: Int,
    val date: Long,
    val comments: String,
)

val database: MutableList<Dog> = mutableListOf()

interface DogDaycareDailyReportGenerator {
    fun getDataForDay(date: Long): List<Dog>
}
class DogDaycareDailyReportGeneratorImpl: DogDaycareDailyReportGenerator {
    // generate data for demonstration purposes
    private val fakeDate = LocalDate.of(2022,5,5).toEpochDay()
    private val data = database.apply {
        add(Dog(1,"Mailo", 8,2,0,150,fakeDate,""))
        add(Dog(1,"Kiko", 8,3,2,250,fakeDate,"Sit, stay training"))
        add(Dog(1,"Bruno", 12,3,5,350,fakeDate,"Heel, agility"))
    }

    override fun getDataForDay(date: Long): List<Dog> = data.filter { it.date == date }
}
interface DogDaycareDailyReport {
    val dataResponse: DogDaycareDailyReportGenerator
    val today: Long
}

fun printSectionName(name: String) {
    println("########## $name ##########")
}