
public class LeftParenthesis extends Operator {
    final int leftParenthesis_priority = 1;
    @Override
    public int priority() {

        return 1;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {

        return null;
    }

}
