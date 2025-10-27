package racingcar.model;

import java.util.List;
import racingcar.model.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView = new OutputView();
    private final int MOVE_NUMBER = 4;

    public void startRace(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
        }
    }

    private void playRound(List<Car> cars) {
        moveCars(cars);
        outputView.printCarStatus(cars);
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            moveCar(car);
        }
    }

    private void moveCar(Car car) {
        if (RandomNumberGenerator.randomNumber() >= MOVE_NUMBER) {
            car.plusDistance();
        }
    }
}
