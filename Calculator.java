import java.text.*;
import java.util.*;

public class Calculator {
    private String expression;
    private float op1, op2, result;
    private char oper;

    public void getOperation() {
        Scanner a = new Scanner(System.in);
        expression = a.next();
        a.close();
    }

    public boolean checkOper(int i) {
        if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'
                || expression.charAt(i) == '/') {
            return true;
        } else {
            return false;
        }
    }

    public void evaluateExpression() {
        int i = 0;
        String ope = "";
        StringBuilder sb1 = new StringBuilder();
        do{
            sb1.setLength(0);
            sb1.append(expression.charAt(i));
            ope = ope.concat(sb1.toString());
            i++;
        }
        while (!checkOper(i));
        op1 = Float.parseFloat(ope);
        oper = expression.charAt(i);
        i++;
        String ope2 = "";
        StringBuilder sb2 = new StringBuilder();
        while (i < expression.length()) {
            sb2.setLength(0);
            sb2.append(expression.charAt(i));
            ope2 = ope2.concat(sb2.toString());
            i++;
        }
        op2 = Float.parseFloat(ope2);
    }

    public void calculate() {
        switch (oper) {
            case '+':
                result = op1 + op2;
                break;
            case '-':
                result = op1 - op2;
                break;
            case '*':
                result = op1 * op2;
                break;
            case '/':
                result = op1 / op2;
                break;
        }
        System.out.println(result);
    }

    public void unroll() {
        getOperation();
        evaluateExpression();
        calculate();
    }
}
