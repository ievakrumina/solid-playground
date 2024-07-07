package dip

/**
 * Idea: Most flexible systems are those in which source code dependencies refer only to abstraction, not to concretions.
 *
 * Violate example:
 * class ViolatePrintReport directly uses the ViolateDailyReport to print daily report,
 * which means it depends on concrete implementation instead of interface.
 * This way ViolatePrintReport cannot be reused to other reports.
 *
 * Solve example:
 * class SolvePrintReport uses SolveReportService interface.
 * class SolveDailyReport implements SolveReportService.
 * This way SolvePrintReport can be reused for other report as well, if they implement SolveReportService.
 */

fun main() {

    printSectionName("Violate DIP")
    ViolatePrintReport().print()

    printSectionName("Solve DIP")
    SolvePrintReport(SolveDailyReport("Mailo")).print()
}

private fun printSectionName(name: String) {
    println("########## $name ##########")
}


