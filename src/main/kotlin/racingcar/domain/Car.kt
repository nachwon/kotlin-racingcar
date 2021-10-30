package racingcar.domain

class Car(val name: String, position: Int = 0) {
    var position: Int = position
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { MAX_NAME_LENGTH_EXCEEDED_ERROR_MESSAGE }
    }

    fun accelerate(fuel: Int) {
        if (canAccelerate(fuel)) {
            position++
        }
    }

    private fun canAccelerate(fuel: Int): Boolean {
        return fuel >= MIN_FUEL_THRESHOLD
    }

    companion object {
        private const val MAX_NAME_LENGTH_EXCEEDED_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_FUEL_THRESHOLD = 4
    }
}
