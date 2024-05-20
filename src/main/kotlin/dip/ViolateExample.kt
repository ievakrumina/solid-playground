package dip

class ViolateDailyReport(private val name: String) {
    val text = name
    private var action = ""

    fun getAction() = action
    fun setAction(amount: Int) {
        this.action = "Amount of food: $amount"
    }
}

class ViolatePrintReport {
    private val dailyReport = ViolateDailyReport("Mailo")
    fun print() {
        dailyReport.setAction(10)
        println("${dailyReport.text}: ${dailyReport.getAction()}")
    }
}