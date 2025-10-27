package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.model.exception.CarNameValidator;

public class CarNameParsing {
    private static final String DELIMITER = ",";
    private final CarNameValidator carNameValidator = new CarNameValidator();

    public List<Car> listNameParsing(String input) {
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .peek(carNameValidator::validate)
                .map(Car::new)
                .toList();
    }
}
