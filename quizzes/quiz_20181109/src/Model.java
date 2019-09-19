import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

public class Model {

    private long number1;
    private long number2;

    public long calculate(String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0)
                    return 0;
                return number1 / number2;
            case "X^2":
                number2=number1;
                return number2*number2;
            case "SIN":
                number2=number1;
                return (long) sin (number2);
            case "COS":
                number2=number1;
                return (long) cos (number2);
            case "EXP":
                return (long) Math.pow(number1, number2);
        }

        System.out.println("Unknown operator - " + operator);
        return 0;
    }

    public long getNumber1() {
        return number1;
    }

    public void setNumber1(long number1) {
        this.number1 = number1;
    }

    public long getNumber2() {
        return number2;
    }

    public void setNumber2(long number2) {
        this.number2 = number2;
    }
}
