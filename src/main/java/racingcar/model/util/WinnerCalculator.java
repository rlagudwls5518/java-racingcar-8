package racingcar.model.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class WinnerCalculator {

    public static String calculateWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        String winners = cars.stream()
                .filter(car -> car.getDistance() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(","));
        return winners;
    }
}
