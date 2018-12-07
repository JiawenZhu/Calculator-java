
public class HashTag extends Operator {
    final int hashTag_priority =0;
    @Override
    public int priority() {
        return hashTag_priority;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        return null;
    }

}
