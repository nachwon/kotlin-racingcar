package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `accelerate 실행 시 4 이상의 fuel 을 받으면 currentPosition 이 1 증가 한다`(input: Int) {
        val car = Car(0)

        car.accelerate(input)

        assertThat(car.currentPosition).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `accelerate 실행 시 4 미만의 fuel 을 받으면 currentPosition 이 증가하지 않는다`(input: Int) {
        val car = Car(0)

        car.accelerate(input)

        assertThat(car.currentPosition).isEqualTo(0)
    }
}
