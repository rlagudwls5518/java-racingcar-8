package racingcar.model;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.util.RandomNumberGenerator;
import racingcar.view.OutputView;

public class RacingGame {
    private OutputView outputView = new OutputView();
    private final int MOVE_NUMBER = 4;

    public void startRace(List<Car> cars, int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(i -> playRound(cars));
    }

    private void playRound(List<Car> cars) {
        cars.forEach(car -> {
            int randomValue = RandomNumberGenerator.randomNumber();
            moveCar(car, randomValue);
        });
        outputView.printCarStatus(cars);
    }


    public void moveCar(Car car, int randomValue) {
        if (randomValue >= MOVE_NUMBER) {
            car.plusDistance();
        }
    }
}
