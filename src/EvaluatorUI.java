
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField("", 0);
    private Panel buttonPanel = new Panel();
    private boolean newOperation = false;

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }

        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        Evaluator evaluator = new Evaluator();
        String result = null;

        // initialize a new operation(when the textField is not empty, sets it as empty)
        if (newOperation != false && txField.getText() != null) {
            txField.setText("");
            newOperation = false;
        }
        for (int i = 0; i < bText.length; i++) {

            // delete entire line 
            if (arg0.getSource() == buttons[18]) {
                txField.setText("");

                // delete one character 
            } else if (arg0.getSource() == buttons[19]) {
                int txLength = txField.getText().length();
                if (txLength != 0) {
                    txField.setText(txField.getText().substring(0, txLength - 1));
                    break;
                }
            } // press a button except "="
            else if (arg0.getSource() == buttons[i]
                    && arg0.getSource() != buttons[14]) {
                txField.setText(txField.getText() + bText[i]);

                // press "="
            }
            if (arg0.getSource() == buttons[14] && txField.getText().length() > 2) {
                result = evaluator.eval(txField.getText()) + "";
                txField.setText(result);
                newOperation = true;

            }

        }

    }

}
