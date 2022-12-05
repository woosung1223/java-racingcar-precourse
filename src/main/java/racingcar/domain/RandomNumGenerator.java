package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumGenerator {
    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;

    public static int makeRandomDigit() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
