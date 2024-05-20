package dip

class SolveDailyReport(private val name: String): SolveReportService {
    override val text = name
    private var action = ""

    override fun getAction() = action
    override fun setAction(amount: Int) {
        this.action = "Amount of food: $amount"
    }
}

interface SolveReportService {
    val text: String
    fun getAction(): String
    fun setAction(amount: Int)
}

class SolvePrintReport(private val report: SolveReportService) {
    fun print() {
        report.setAction(10)
        println("${report.text}: ${report.getAction()}")
    }
}