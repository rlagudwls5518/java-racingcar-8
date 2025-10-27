package racingcar.model.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final static int ZERO =0;
    private final static int NINE =9;

    public static int randomNumber(){
        return Randoms.pickNumberInRange(ZERO, NINE);

    }
}
