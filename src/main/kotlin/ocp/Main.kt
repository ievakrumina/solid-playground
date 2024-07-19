package ocp


/**
 * Def: A software artifact should be open for extension but closed for modification.
 *
 * Description of the example:
 * Two separate views - compact and full report.
 * Requesting and generating data up to view models should use the same logic.
 *
 * Data model Dog (Main.kt) is used by database ((Main.kt) ) and DogDaycareDailyReportGenerator (Main.kt)
 * DogDaycareDailyReport (Main.kt) uses DogDaycareDailyReportGenerator (Main.kt)
 * DogDaycareDailyReportGeneratorImpl (Main.kt) implements DogDaycareDailyReportGenerator (Main.kt)
 *
 * FullDailyReport (FullReport.kt) implements DogDaycareDailyReport (Main.kt) and uses FullDailyModel (FullReport.kt)
 * CompactDailyReport (CompactReport.kt) implements DogDaycareDailyReport (Main.kt) and uses CompactDailyModel (CompactReport.kt)
 *
 * FullReportView (FullReport.kt)  uses FullDailyReport and FullDailModel (FullReport.kt). It is used in main method to print out the report
 * CompactReportView (CompactReport.kt)  uses CompactDailyReport and CompactDailyModel (CompactReport.kt). It is used in main method to print out the report*
 */
fun main() {

    val reportGenerator = DogDaycareDailyReportGeneratorImpl()
    val fullReportPrinter = FullReportView(FullDailyReport(reportGenerator))
    fullReportPrinter.printReport()

    val compactReportPrinter = CompactReportView(CompactDailyReport(reportGenerator))
    compactReportPrinter.printReport()

}
