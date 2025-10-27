package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView extends Printer {

    private final String INPUT_PROMPT_CARNAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_PROMPT_TRYCOUNT = "시도할 횟수는 몇 회인가요?";
    private final String OUTPUT_PROMPT_WINNER = "최종 우승자 : ";
    private final String OUTPUT_PROMPT_DISTANCE = "-";

    public void printReadyMessage() {
        println(INPUT_PROMPT_CARNAME);
    }

    public void printReadyTryCount() {
        println(INPUT_PROMPT_TRYCOUNT);
    }

    public void printCarStatus(List<Car> cars) {
        for (Car car : cars) {
            print(car.getName() + " : ");
            printDistance(car);
        }
    }

    public void printResultMessage(String winner) {
        print(OUTPUT_PROMPT_WINNER);
        println(winner);
    }

    private void printDistance(Car car) {
        for (int i = 0; i < car.getDistance(); i++) {
            print(OUTPUT_PROMPT_DISTANCE);
        }
        println("");
    }


}
