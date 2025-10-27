package racingcar.model.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final static int FIRST_NUMBER = 0;
    private final static int LAST_NUMBER = 9;

    public static int randomNumber() {
        return Randoms.pickNumberInRange(FIRST_NUMBER, LAST_NUMBER);

    }
}
