package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarNameParsing;

public class CarNameValidatorTest {

    @DisplayName("쉼표를 기준으로 분리할 수 있다")
    @Test
    void listNameParsing_splitByComma_returnsCarList() {

        // given
        CarNameParsing parser = new CarNameParsing();
        String input = "pobi,woni,jun";

        // when
        List<Car> result = parser.listNameParsing(input);

        // then
        assertThat(result).hasSize(3);
        assertThat(result)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");

    }

    @DisplayName("이름에 공백이 포함된 경우, 앞뒤 공백을 제거하고 Car 리스트를 반환한다.")
    @Test
    void listNameParsing_trimSpaces_returnsTrimmedCarNames() {
        // given
        CarNameParsing parser = new CarNameParsing();
        String input = " pobi ,  woni, jun ";

        // when
        List<Car> result = parser.listNameParsing(input);

        // then
        assertThat(result)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @DisplayName("5자 초과 이름이 포함되면 예외를 던진다.")
    @Test
    void listNameParsing_invalidName_throwsException() {
        // given
        CarNameParsing parser = new CarNameParsing();
        String input = "pobi,abcdef"; // 6자 이름

        // when & then
        assertThatThrownBy(() -> parser.listNameParsing(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 5자 이하");
    }





}
