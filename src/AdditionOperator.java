
public class AdditionOperator extends Operator {

    final int addition_priority = 2;

    @Override
    public int priority() {
        return addition_priority;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = op1.getValue() + op2.getValue();
        Operand operand = new Operand(result);
        return operand;
    }
}
