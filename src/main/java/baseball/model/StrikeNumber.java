package baseball.model;

import java.util.LinkedHashSet;

import nextstep.utils.Randoms;

public class StrikeNumber {
    private final LinkedHashSet<Integer> numbers = new LinkedHashSet<>();

    public StrikeNumber() {
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1,9));
        }
    }
}
