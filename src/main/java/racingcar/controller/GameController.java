package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNameParsing;
import racingcar.model.RacingGame;
import racingcar.model.exception.CarNameValidator;
import racingcar.model.exception.TryCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final RacingGame game;
    private final CarNameParsing carNameParsing;
    private final InputView inputView;
    private final OutputView outputView;
    private final TryCountValidator tryCountValidator;

    public GameController(RacingGame game, CarNameParsing carNameParsing, InputView inputView, OutputView outputView,
                          TryCountValidator tryCountValidator){
        this.game = game;
        this.carNameParsing = carNameParsing;
        this.inputView = inputView;
        this.outputView = outputView;
        this.tryCountValidator = tryCountValidator;
    }


    public void gameStart(){
        outputView.printReadyMessage();
        String inputCarNames = inputView.input();
        List<Car> cars = carNameParsing.listNameParsing(inputCarNames);

        outputView.printReadyTryCount();
        String tryCountInput = inputView.input();
        tryCountValidator.validate(tryCountInput);
        int TryCount = Integer.parseInt(tryCountInput);

        game.Racing(cars, TryCount);
        outputView.printResultMessage(game.winner(cars));
    }


}
