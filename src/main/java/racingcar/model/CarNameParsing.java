package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.exception.Exception;

public class CarNameParsing {
    private final String delimiter = ",";
    private final Exception exception = new Exception();

    public List<Car> listNameParsing(String inputText){
        List<Car> carName = new ArrayList<>();
        List<String> carNames = new ArrayList<>(Arrays.asList(inputText.split(delimiter)));

        for(int i=0; i<carNames.size(); i++){
            String name = carNames.get(i);
            exception.exceptionCarNameCheck(name);
            carName.add(new Car(carNames.get(i)));
        }

        return carName;
    }


}
