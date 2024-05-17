package lsp

/**
 * Def:   Substitution property: If for each object x of type S
 * there is an object y of type T such that for all programs P
 * defined in terms of T, the behaviour of P is unchanged when x is
 * substituted for y then S is subtype of T.
 */
fun main() {

    printSectionName("Violate LSP example")
    ViolateCostReport(null, ViolateDaycareCalculator()).print()
    ViolateCostReport(ViolateBoardCalculator()).print()
    ViolateCostReport(ViolateBoardAndTrainCalculator()).print()

    printSectionName("Solution LSP example")
    SolutionCostReport(SolutionDaycareCalculator()).print()
    SolutionCostReport(SolutionBoardCalculator()).print()
    SolutionCostReport(SolutionBoardAndTrainCalculator()).print()

}

fun printSectionName(name: String) {
    println("########## $name ##########")
}

