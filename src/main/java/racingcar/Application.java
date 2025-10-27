package racingcar;

import racingcar.controller.GameController;
import racingcar.model.CarNameParsing;
import racingcar.model.RacingGame;
import racingcar.model.exception.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        CarNameParsing carNameParsing = new CarNameParsing();
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        TryCountValidator tryCountValidator = new TryCountValidator();

        GameController gameController = new GameController(game, carNameParsing, inputView, outputView,
                tryCountValidator);
        gameController.gameStart();
    }
}
