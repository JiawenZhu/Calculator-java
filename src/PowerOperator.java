
public class PowerOperator extends Operator {

    final int power_priority = 3;

    @Override
    public int priority() {
        return power_priority;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        int result = (int) Math.pow(op1.getValue(), op2.getValue());
        Operand operand = new Operand(result);
        return operand;
    }
}
