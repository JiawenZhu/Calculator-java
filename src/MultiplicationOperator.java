
public class MultiplicationOperator extends Operator {
        final int multiplcation_priority = 3; 
	@Override
	public int priority() {
		return multiplcation_priority;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		int result = op1.getValue() * op2.getValue();
		Operand operand = new Operand(result);
		return operand;
	}
}