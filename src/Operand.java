/**
 * 
 * @author Jiawen
 */
public class Operand {

    private String token;
    private int value;

    public Operand(String token) {
        this.token = token;
    }

    public Operand(int value) {
        this.value = value;
    }

    public int getValue() {

        if (token != null) {
            return Integer.parseInt(token);
        } else {
            return value;
        }
    }

    public static boolean check(String token) {
        try {
            Integer.parseInt(token);
            return true;
            // not an integer
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
