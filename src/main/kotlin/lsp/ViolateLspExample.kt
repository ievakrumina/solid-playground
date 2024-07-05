package lsp

/**
 * Violate LSP.
 *
 * DaycareCalculator has different logic and doesn't implement Calculator interface,
 * which leads to more complicated logic in CostReport print method
 */
class ViolateCostReport(
    private val calculator: ViolateCalculator? = null,
    private val daycareCalculator: ViolateDaycareCalculator? = null,
    private val dogSize: ViolateDaycareCalculator.DogSize = ViolateDaycareCalculator.DogSize.SMALL
) {
    private val  time = 10 // Hardcoded for simplicity
    fun print() {
        if (daycareCalculator!= null )   {
            println("${daycareCalculator.typeName}, cost: ${ViolateDaycareCalculator().getCosts(time, dogSize)}")
        }
        if (calculator != null) {
            println("${calculator.typeName} cost: ${calculator.getCosts(time)}")
        }
    }
}

enum class ViolateCostType {
    BOARD, BOARD_TRAIN, DAYCARE
}

interface ViolateCalculator {
    val typeName: ViolateCostType
    fun getCosts(time: Int): Int
}

class ViolateBoardCalculator: ViolateCalculator {
    override val typeName: ViolateCostType
        get() = ViolateCostType.BOARD

    override fun getCosts(time: Int) = 10 * time
}

class ViolateBoardAndTrainCalculator: ViolateCalculator {
    override val typeName: ViolateCostType
        get() = ViolateCostType.BOARD_TRAIN

    override fun getCosts(time: Int) = 15 * time
}

class ViolateDaycareCalculator {

    val typeName = ViolateCostType.DAYCARE

    enum class DogSize {
        SMALL, MEDIUM, BIG
    }

    fun getCosts(time: Int, dogSize:DogSize) = 5 * time * getCoefficient(dogSize)
    private fun getCoefficient(dogSize: DogSize) = when(dogSize) {
        DogSize.SMALL -> 1
        DogSize.MEDIUM -> 2
        DogSize.BIG -> 3
    }
}