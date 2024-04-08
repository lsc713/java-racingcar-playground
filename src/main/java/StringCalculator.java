import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int splitAdd(String operand) {
        if (isBlank(operand)) {
            return 0;
        }
        String[] values = split(operand);
        return sum(values);
    }

    private int sum(String[] values) {
        int sum = 0;
        for (String value : values) {
            sum += toPositive(value);
        }
        return sum;
    }

    private int toPositive(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException();
        }
        return number;
    }

    private String[] split(String operand) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(operand);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }
        return operand.split(",|:");
    }



    private boolean isBlank(String operand) {
        return operand == null || operand.isEmpty();
    }

    private int add(String[] split, int result) {
        for (int i = 0; i < split.length; i++) {
            int sum = Integer.parseInt(split[i]);
            result += sum;
        }
        return result;
    }
}
