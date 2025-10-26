package racingcar;

import racingcar.controller.GameController;
import racingcar.model.exception.Exception;
import racingcar.model.CarNameParsing;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        Exception exception = new Exception();
        CarNameParsing carNameParsing = new CarNameParsing();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        GameController gameController = new GameController(game,carNameParsing, inputView, outputView, exception);
        gameController.gameStart();
    }
}
