package spbu.hw2.task1;


public class StackCalculator {
    private Stack<Character> operators;
    private Stack<Integer> numbers;

    public StackCalculator() {
        operators = new StackList<>();
        numbers = new StackList<>();
    }

    public int computing(String expression) {
        int size = expression.length();
        int i = 0;

        while (i < size) {
            i = takeNumber(expression, i);

            switch (expression.charAt(i)) {
                case '(':
                    operators.push('(');
                    break;
                case ')':
                    operators.push(')');
                    break;
                case '+':
                    operators.push('+');
                    break;
                case '-':
                    operators.push('-');
                    break;
                case '*':
                    operators.push('*');
                    break;
                case '/':
                    operators.push('/');
                    break;
            }

            i++;
        }
        
        return numbers.pop();
    }

    private int takeNumber(String expression, int i) {
        boolean isNum = false;
        int num = 0;

        while ((expression.charAt(i) >= '0') && (expression.charAt(i) <= '9')) {
            isNum = true;
            num *= 10;
            num += expression.charAt(i) - '0';
            i++;
        }

        if (isNum) {
            numbers.push(num);
        }

        return i;
    }
}
