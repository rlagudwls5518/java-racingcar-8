package racingcar.model;



import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.view.OutputView;



public class RacingGame {
    private final OutputView outputView = new OutputView();

    public void Racing(List<Car> cars, int tryCount){
        for(int i=0; i<tryCount; i++){
            for(Car car : cars){
                moveCar(car);
            }
            outputView.printCarStatus(cars);
        }
    }
    public String winner(List<Car> cars){
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
    private void moveCar(Car car){
        if(randomNumber()>=4){
            car.plusDistance();
        }
    }
    private int randomNumber(){
        return Randoms.pickNumberInRange(0, 9);

    }
}
