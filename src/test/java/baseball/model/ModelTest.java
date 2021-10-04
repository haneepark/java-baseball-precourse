package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.InvalidBaseballNumberException;

public class ModelTest {
	Model model;

	@BeforeEach
	void setUp() {
		model = new Model();
		model.initGame(new StrikeNumber());
	}

	@Test
	void initGame() {
	    model.initGame(new StrikeNumber());

	    assertThat(model.getTurnResult()).isNull();
	    assertThat(model.isTurnContinue()).isTrue();
	    assertThat(model.isWin()).isFalse();
	}

	@ParameterizedTest
	@CsvSource(value = {"STRIKE:0:3", "BALL:3:0", "NOTHING:0:0"}, delimiter = ':')
	void playTurn(NumberResult numberResult, int expectedNumberOfBalls, int expectedNumberOfStrikes)
		throws InvalidBaseballNumberException {
		StrikeNumber strikeNumber = mock(StrikeNumber.class);
		when(strikeNumber.checkResult(anyInt(), anyInt())).thenReturn(numberResult);
		model.initGame(strikeNumber);

		model.playTurn("123");

		assertThat(model.getTurnResult().getNumberOfBalls()).isEqualTo(expectedNumberOfBalls);
		assertThat(model.getTurnResult().getNumberOfStrikes()).isEqualTo(expectedNumberOfStrikes);
	}

	@Test
	void playTurnAllStrikes() throws InvalidBaseballNumberException {
		StrikeNumber strikeNumber = mock(StrikeNumber.class);
		when(strikeNumber.checkResult(anyInt(), anyInt())).thenReturn(NumberResult.STRIKE);
		model.initGame(strikeNumber);

		model.playTurn("123");

		assertThat(model.isTurnContinue()).isFalse();
		assertThat(model.isWin()).isTrue();
	}

	@ParameterizedTest
	@ValueSource(strings = {"ANY_STRING", "12345", "000"})
	void playTurnWithInvalidInput(String input) {
		assertThatThrownBy(() -> {
			model.playTurn(input);
		}).isInstanceOf(InvalidBaseballNumberException.class);

		assertThat(model.isTurnContinue()).isFalse();
		assertThat(model.isWin()).isFalse();
	}
}
