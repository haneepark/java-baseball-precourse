package baseball.model;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import nextstep.utils.Randoms;

public class StrikeNumber {
    private final List<Integer> numbers;

    public StrikeNumber() {
        LinkedHashSet<Integer> numbersSet = new LinkedHashSet<>();

        while (numbersSet.size() < 3) {
            numbersSet.add(Randoms.pickNumberInRange(1, 9));
        }

        numbers = new ArrayList<>(numbersSet);
    }
}
