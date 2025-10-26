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
                .mapToInt(Car::getDistance) // 각 차의 position 값(int)을 가져옴
                .max()                    // 그중 최대값을 찾음
                .orElse(0);               // 리스트가 비어있으면 0을 반환

        // 2. 최대 위치와 같은 차(들)만 필터링한 후,
        //    그 차들의 이름을 가져와서 쉼표(,)로 연결합니다.
        String winners = cars.stream()
                .filter(car -> car.getDistance() == maxPosition) // 최대 위치를 가진 차만 통과
                .map(Car::getName)                               // 차(Car)를 이름(String)으로 변경
                .collect(Collectors.joining(","));             // 이름들을 쉼표로 합침
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
