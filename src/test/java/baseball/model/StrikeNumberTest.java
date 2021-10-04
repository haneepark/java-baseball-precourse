package baseball.model;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import nextstep.utils.Randoms;

public class StrikeNumberTest {
	@ParameterizedTest
	@CsvSource(value = {"1:STRIKE", "2:BALL", "9:NOTHING"}, delimiter=':')
	void checkResult(int guessNumber, NumberResult expectedResult) {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3);
			StrikeNumber strikeNumber = new StrikeNumber();

			NumberResult numberResult = strikeNumber.checkResult(0, guessNumber);

			assertThat(numberResult).isEqualTo(expectedResult);
		}
	}
}
