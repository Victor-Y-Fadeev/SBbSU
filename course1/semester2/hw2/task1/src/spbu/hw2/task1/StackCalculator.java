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

            if (i < size) {
                switch (expression.charAt(i)) {
                    case '(':
                        operators.push('(');
                        break;
                    case ')':
                        lowPriority();
                        operators.pop();
                        break;
                    case '+':
                        lowPriority();
                        operators.push('+');
                        break;
                    case '-':
                        lowPriority();
                        operators.push('-');
                        break;
                    case '*':
                        highPriority();
                        operators.push('*');
                        break;
                    case '/':
                        highPriority();
                        operators.push('/');
                        break;
                }
            }

            i++;
        }

        lowPriority();
        return numbers.pop();
    }

    private int takeNumber(String expression, int i) {
        int size = expression.length();
        boolean isNum = false;
        int num = 0;

        while ((i < size) && (expression.charAt(i) >= '0') && (expression.charAt(i) <= '9')) {
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

   private void highPriority() {
       Character temp = operators.pop();

       while ((temp != null) && (temp != '(') && (temp != '+') && (temp != '-')) {
           int a = numbers.pop();
           int b = numbers.pop();
           int result = 0;

           switch (temp) {
               case '*':
                   result = b * a;
                   break;
               case '/':
                   result = b / a;
                   break;
           }

           numbers.push(result);
           temp = operators.pop();
       }

       if ((temp != null) && ((temp == '(') || (temp == '+') || (temp == '-'))) {
           operators.push('(');
       }
   }

   private void lowPriority() {
        Character temp = operators.pop();

        while ((temp != null) && (temp != '(')) {
            int a = numbers.pop();
            int b = numbers.pop();
            int result = 0;

            switch (temp) {
                case '+':
                    result = b + a;
                    break;
                case '-':
                    result = b - a;
                    break;
                case '*':
                    result = b * a;
                    break;
                case '/':
                    result = b / a;
                    break;
            }

            numbers.push(result);
            temp = operators.pop();
        }

        if ((temp != null) && (temp == '(')) {
            operators.push(temp);
        }
    }
}
