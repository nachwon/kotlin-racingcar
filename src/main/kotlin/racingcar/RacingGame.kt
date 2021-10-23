package racingcar

import racingcar.fuelproviders.FuelProvider
import racingcar.inputviews.GameInput
import racingcar.resultviews.GameResult
import racingcar.resultviews.RoundResult

class RacingGame(
    private val fuelProvider: FuelProvider,
) {
    fun run(input: GameInput): GameResult {
        val cars = createCars(input.numberOfCars)
        val roundResults = (1..input.numberOfRounds).map { runRound(it, cars) }
        return GameResult(roundResults)
    }

    private fun createCars(numberOfCars: Int): List<Car> {
        return (1..numberOfCars).map { Car(it) }
    }

    private fun runRound(round: Int, cars: List<Car>): RoundResult{
        accelCars(cars)
        return RoundResult(round, cars.map { it.currentPosition })
    }

    private fun accelCars(cars: List<Car>) {
        for (car in cars) {
            val fuel = fuelProvider.getFuel()
            car.accelerate(fuel)
        }
    }
}
