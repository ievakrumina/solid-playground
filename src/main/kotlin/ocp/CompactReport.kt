package ocp

import java.time.LocalDate


class CompactDailyReport(override val dataResponse: DogDaycareDailyReportGenerator) : DogDaycareDailyReport {

    override val today = LocalDate.of(2022,5,5).toEpochDay()

    fun mapDataToModel() = dataResponse.getDataForDay(today).map { dog ->
        CompactDailyModel(dog.name, dog.hours, dog.cost)
    }
}

data class CompactDailyModel(
    val name: String,
    val hours: Int,
    val cost: Int,
)

class CompactReportView(private val report: CompactDailyReport){
    fun printReport() {
        val date = LocalDate.ofEpochDay(report.today)
        printSectionName("Compact report of $date")
        report.mapDataToModel().forEach {
            println("${it.name}: " +
                    "Hours in daycare - ${it.hours} | " +
                    "Total costs - ${it.cost} | ")
        }
        printSectionName("End of report")
    }
}