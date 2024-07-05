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

    private val  time = 10 // Hardcoded for simplicity

    fun print() {
        println("${calculator.typeName} cost: ${calculator.getCosts(time)}")
    }
}

enum class SolutionCostType {
    BOARD, BOARD_TRAIN, DAYCARE
}

interface SolutionCalculator {
    val typeName: SolutionCostType
    fun getCosts(time: Int): Int
}

class SolutionBoardCalculator() : SolutionCalculator {
    override val typeName: SolutionCostType
        get() = SolutionCostType.BOARD
    override fun getCosts(time: Int) = 10 * time
}

class SolutionBoardAndTrainCalculator() : SolutionCalculator {
    override val typeName: SolutionCostType
        get() = SolutionCostType.BOARD_TRAIN
    override fun getCosts(time: Int) = 15 * time
}

class SolutionDaycareCalculator(
    private val dogSize: ViolateDaycareCalculator.DogSize = ViolateDaycareCalculator.DogSize.SMALL
) : SolutionCalculator {

    override val typeName: SolutionCostType
        get() = SolutionCostType.DAYCARE
    override fun getCosts(time: Int): Int = 5 * time * getCoefficient()

    private fun getCoefficient() = when(dogSize) {
        ViolateDaycareCalculator.DogSize.SMALL -> 1
        ViolateDaycareCalculator.DogSize.MEDIUM -> 2
        ViolateDaycareCalculator.DogSize.BIG -> 3
    }
}