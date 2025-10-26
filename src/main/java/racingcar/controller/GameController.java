package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNameParsing;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.model.exception.Exception;

public class GameController {

    private final RacingGame game;
    private final CarNameParsing carNameParsing;
    private final InputView inputView;
    private final OutputView outputView;
    private final Exception exception;

    public GameController(RacingGame game, CarNameParsing carNameParsing, InputView inputView, OutputView outputView,
                          Exception exception){
        this.game = game;
        this.carNameParsing = carNameParsing;
        this.inputView = inputView;
        this.outputView = outputView;
        this.exception = exception;
    }


    public void gameStart(){
        outputView.printReadyMessage();
        String inputCarNames = inputView.input();
        exception.exceptionCarNameCheck(inputCarNames);
        List<Car> cars = carNameParsing.listNameParsing(inputCarNames);

        outputView.printReadyTryCount();
        String tryCountInput = inputView.input();
        exception.exceptionTryCountCheck(tryCountInput);
        int TryCount = Integer.parseInt(tryCountInput);

        game.Racing(cars, TryCount);
        outputView.printResultMessage(game.winner(cars));
    }


}
