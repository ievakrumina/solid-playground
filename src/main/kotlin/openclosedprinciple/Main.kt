package openclosedprinciple


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
 * FullReportView (FullReport.kt)  uses FullDailyReport (FullReport.kt)
 * CompactReportView (CompactReport.kt)  uses CompactDailyReport (CompactReport.kt)
 *
 * FullReportImpl (FullReport.kt)  implements FullReportView (FullReport.kt)  is used in main method to print out the report
 * CompactReportImpl (CompactReport.kt) implements CompactReportView (CompactReport.kt) is used in main method to print out the report
 *
 */
fun main() {

    val reportGenerator = DogDaycareDailyReportGeneratorImpl()
    val fullReportPrinter = FullReportViewImpl(FullDailyReport(reportGenerator))
    fullReportPrinter.printReport()

    val compactReportPrinter = CompactReportViewImpl(CompactDailyReport(reportGenerator))
    compactReportPrinter.printReport()

}
