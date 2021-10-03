package baseball.model;

import java.util.List;

public class TurnResult {
	private int numberOfBalls;
	private int numberOfStrikes;

	public TurnResult(List<NumberResult> numberResults) {
		for (NumberResult numberResult : numberResults) {
			addCount(numberResult);
		}
	}

	private void addCount(NumberResult numberResult) {
		if (NumberResult.BALL.equals(numberResult)) {
			numberOfBalls++;
			return;
		}

		if (NumberResult.STRIKE.equals(numberResult)) {
			numberOfStrikes++;
		}
	}

	public boolean isWin() {
		return numberOfStrikes == 3;
	}
}
