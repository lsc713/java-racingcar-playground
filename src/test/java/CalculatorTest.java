import com.sun.org.apache.xpath.internal.operations.String;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {

    /*
    * 기능 요구사항
쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
* (예: “” => 0,
* "1,2" => 3,
* "1,2,3" => 6,
* “1,2:3” => 6)
*/

    StringCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    @DisplayName("빈값에 대한 처리를 해보자")
    void contain_N0() {
        int result = calculator.splitAdd(null);
        assertThat(result).isEqualTo(0);

        result = calculator.splitAdd("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열을 구분자를 기준으로 더해보자")
    void containOver1() {
        int result = calculator.splitAdd("1,2");
        org.junit.jupiter.api.Assertions.assertEquals(3,result);
    }

    @Test
    @DisplayName("문자열을 여러 구분자를 기준으로 더해보자")
    void containOver3() {
        int result = calculator.splitAdd("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("문자열을 여러 구분자를 기준으로 더해보자 with Custom")
    void containOver_Custom() {
        int result = calculator.splitAdd("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 확인 테스트")
    public void ExceptionInMinus() throws Exception {
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> {
            int result = calculator.splitAdd("-1,2,3");
        });
    }

    /*앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.


문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.*/
}
