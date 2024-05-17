package lsp

/**
 * Implement LSP.
 *
 * DaycareCalculator does implement Calculator interface,
 * simplified CostReport print method.
 * DaycareCalculator should apply to same principles as other Calculators.
 */
class SolutionCostReport(
    private val calculator: SolutionCalculator
) {
    fun print() {
        println("${calculator.typeName} cost: ${calculator.getCosts(10)}")
    }
}

enum class SolutionCostType {
    BOARD, BOARD_TRAIN, DAYCARE
}

interface SolutionCalculator {
    val typeName: SolutionCostType
    fun getCosts(coefficient: Int): Int
}

class SolutionBoardCalculator() : SolutionCalculator {
    override val typeName: SolutionCostType
        get() = SolutionCostType.BOARD
    override fun getCosts(coefficient: Int) = 10 * coefficient
}

class SolutionBoardAndTrainCalculator() : SolutionCalculator {
    override val typeName: SolutionCostType
        get() = SolutionCostType.BOARD_TRAIN
    override fun getCosts(coefficient: Int) = 15 * coefficient
}

class SolutionDaycareCalculator() : SolutionCalculator {

    override val typeName: SolutionCostType
        get() = SolutionCostType.DAYCARE
    override fun getCosts(coefficient: Int): Int = 20 * coefficient
}