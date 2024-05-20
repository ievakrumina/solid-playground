package isp

interface FeedingDaycareActivities {
    fun feed()
}

class FeedingDaycareActivitiesImpl: FeedingDaycareActivities {
    override fun feed() {
        // Save activity in database
        println("Feed dog")
    }
}

interface PlayingDaycareActivities {
    fun play()
}

class PlayingDaycareActivitiesImpl: PlayingDaycareActivities {
    override fun play() {
        // Save activity in database
        println("Play with dog")
    }
}

interface TrainingDaycareActivities {
    fun train()
}

class TrainingDaycareActivitiesImpl: TrainingDaycareActivities {
    override fun train() {
        // Save activity in database
        println("Train dog")
    }
}

class SolveFeedingPerson(private val activity: FeedingDaycareActivities) {

    fun recordActivity() = activity.feed()
}

class SolvePlayingPerson(private val activity: PlayingDaycareActivities) {
    fun recordActivity() = activity.play()
}

class SolveTrainer(private val activity: TrainingDaycareActivities) {
    fun recordActivity() = activity.train()
}