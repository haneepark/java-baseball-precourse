package baseball;

import baseball.model.TurnResult;

public class View {
	public void displayEnterNumberMessage() {
		System.out.print("숫자를 입력해주세요 :");
	}

	public void displayWinMessage() {
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	public void displayInputErrorMessage() {
		System.out.println("[ERROR] 잘못된 입력값 입니다. 유효한 숫자를 입력해주세요.");
	}

	public void displayHintMessage(TurnResult turnResult) {
		if (turnResult.isNothing()) {
			displayNothingMessage();
			return;
		}

		displayStrikeAndOrBallHintMessage(turnResult);
	}

	private void displayNothingMessage() {
		System.out.println("낫싱");
	}

	private void displayStrikeAndOrBallHintMessage(TurnResult turnResult) {
		String message = getStrikeHintMessage(turnResult.getNumberOfStrikes())
			+ getSeparatorForHintMessage(turnResult)
			+ getBallHintMessage(turnResult.getNumberOfBalls());

		System.out.println(message);
	}

	private String getStrikeHintMessage(int numberOfStrikes) {
		if (numberOfStrikes > 0) {
			return String.format("%d스트라이크", numberOfStrikes);
		}

		return "";
	}

	private String getSeparatorForHintMessage(TurnResult turnResult) {
		if (turnResult.getNumberOfStrikes() > 0 && turnResult.getNumberOfBalls() > 0) {
			return " ";
		}
		return "";
	}

	private String getBallHintMessage(int numberOfBalls) {
		if (numberOfBalls > 0) {
			return String.format("%d볼", numberOfBalls);
		}

		return "";
	}
}
