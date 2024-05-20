package isp


/**
 * Idea: It is harmful to depend on modules that contain more than you need.
 *
 * Violate example:
 * interface DaycareActivities contain 3 methods - play, feed, train.
 * class FeedingPerson only uses DaycateActivities feed method, but changes on play or train will also require
 * to re-compile FeedingPerson class.
 * Same for PlayingPerson, Trainer.
 *
 * Solve example:
 * split interface DaycareActivities into three separate interfaces per responsibility.
 * class FeedingPerson uses interface FeedingDaycareActivities,
 * which is an inerface with only feed method.
 * Similar solution is created for PlayingPerson, Trainer.
 */
fun main() {
    printSectionName("Violate ISP")
    val violateActivity = ViolateDaycareActivitiesImpl()
    ViolateFeedingPerson(violateActivity).recordActivity()
    ViolatePlayingPerson(violateActivity).recordActivity()
    ViolateTrainer(violateActivity).recordActivity()

    printSectionName("Solve ISP")
    SolveFeedingPerson(FeedingDaycareActivitiesImpl()).recordActivity()
    SolvePlayingPerson(PlayingDaycareActivitiesImpl()).recordActivity()
    SolveTrainer(TrainingDaycareActivitiesImpl()).recordActivity()
}

private fun printSectionName(name: String) {
    println("########## $name ##########")
}

