package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.OutputView;

public class RacingGameTest {

    @DisplayName("랜덤값이 4 이상이면 전진한다.")
    @Test
    void move_whenRandomValueGreaterThan4_moveForward() {
        // given
        Car car = new Car("pobi");
        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame();
        int randomValue = 4;

        // when
        game.moveCar(car, randomValue);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4 미만이면 이동하지 않는다.")
    @Test
    void move_whenRandomValueLessThan4_thenStayStill() {
        // given
        Car car = new Car("woni");
        OutputView outputView = new OutputView();
        RacingGame game = new RacingGame();
        int randomValue = 3;

        // when
        game.moveCar(car, randomValue);

        // then
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
