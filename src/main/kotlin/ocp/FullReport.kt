package ocp

import java.time.LocalDate

class FullDailyReport(override val dataResponse: DogDaycareDailyReportGenerator) : DogDaycareDailyReport {
    override val today = LocalDate.of(2022,5,5).toEpochDay()

    fun mapDataToModel() = dataResponse.getDataForDay(today).map { dog ->
        FullDailyModel(dog.name, dog.hours, dog.food, dog.trainingHours, dog.cost, dog.comments)
    }
}

data class FullDailyModel(
    val name: String,
    val hours: Int,
    val food: Int,
    val trainingHours: Int,
    val cost: Int,
    val comments: String,
)

interface FullReportView {
    val report: FullDailyReport
    fun printReport()
}

class FullReportViewImpl(override val report: FullDailyReport) : FullReportView {
    override fun printReport() {
        val date = LocalDate.ofEpochDay(report.today)
        printSectionName("Full report of $date")
        report.mapDataToModel().forEach {
            println("${it.name}: " +
                    "Hours in daycare - ${it.hours} | " +
                    "Food portions eaten - ${it.food} | " +
                    "Hours of training - ${it.trainingHours} | " +
                    "Total costs - ${it.cost} | ")
            println("Additional notes: ${it.comments}")
            println()
        }
        printSectionName("End of report")
    }
}