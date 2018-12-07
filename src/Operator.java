
import java.util.HashMap;

public abstract class Operator {
    // The Operator class should contain an instance of a HashMap
    // This map will use keys as the tokens we're interested in,
    // and values will be instances of the Operators.

    // Example:
    // Where does this declaration go? What should its access level be?
    // Class or instance variable? Is this the right declaration?
    // HashMap operators = new HashMap();
    // operators.put( "+", new AdditionOperator() );
    // operators.put( "-", new SubtractionOperator() );
    public static HashMap<String, Operator> hashMap;

    static {

        hashMap = new HashMap<String, Operator>();
        hashMap.put("+", new AdditionOperator());
        hashMap.put("-", new SubtractionOperator());
        hashMap.put("*", new MultiplicationOperator());
        hashMap.put("/", new DivisionOperator());
        hashMap.put("^", new PowerOperator());
//		hashMap.put("!", new Exclamation());
        hashMap.put("#", new HashTag());
        hashMap.put("(", new LeftParenthesis());
    }

    // gets the Operator token
    public static Operator getToken(String token) {
        return hashMap.get(token);
    }

    public abstract int priority();

    public abstract Operand execute(Operand op1, Operand op2);

    public static boolean check(String token) {

        return token.matches("[+*-/^!()]");
    }

}
