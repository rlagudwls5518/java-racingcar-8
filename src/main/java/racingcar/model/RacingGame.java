package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView = new OutputView();
    private final int MOVE_NUMBER = 4;

    public void startRace(List<Car> cars, int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(i -> playRound(cars));
    }

    private void playRound(List<Car> cars) {
        cars.forEach(this::moveCar);
        outputView.printCarStatus(cars);
    }

    private void moveCar(Car car) {
        if (RandomNumberGenerator.randomNumber() >= MOVE_NUMBER) {
            car.plusDistance();
        }
    }
}
