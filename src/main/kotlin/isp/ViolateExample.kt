package isp

interface ViolateDaycareActivities {
    fun feed()
    fun play()
    fun train()
}
class ViolateDaycareActivitiesImpl: ViolateDaycareActivities {
    override fun feed() {
        // Save activity in database
        println("Feed dog")
    }
    override fun play() {
        // Save activity in database
        println("Play now")
    }
    override fun train() {
        // Save activity in database
        println("Train")
    }
}

class ViolateFeedingPerson(private val activity: ViolateDaycareActivities) {
    fun recordActivity() = activity.feed()
}

class ViolatePlayingPerson(private val activity: ViolateDaycareActivities) {
    fun recordActivity() = activity.play()
}

class ViolateTrainer(private val activity: ViolateDaycareActivities) {
    fun recordActivity() = activity.train()
}