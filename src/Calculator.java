import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator {

    int boardWidth = 360;
    int boardHeight = 540;

    //At this point we are creating the colors that we'll use in the future
    Color customLightGray = new Color(212,212,210);
    Color customDarkGray = new Color(80,80,80);
    Color customBlack = new Color(28,28,28);
    Color customOrange = new Color(255,149,0);

    //in this point we are creating the window of the calculator
    JFrame frame = new JFrame("Calculator");

    //We are creating the label
    JLabel displayLabel = new JLabel();

    //we are creating the panel of the project
    JPanel displayPanel = new JPanel();



    JPanel buttonsPanel1 = new JPanel();


    //At this point we are creating the different values of the future bottons
    String[] buttonsValues = {
            "AC","+/-", "%","÷",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    String a = "0";
    String operator = null;
    String b = null;




    public Calculator (){

        //we are making a visible window
        //frame.setVisible(true);
        //we are making the dimensions of the window
        frame.setSize(boardWidth,boardHeight);

        //when the program start it will be positioned at the
        //center of the screen
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setLayout(new BorderLayout());


        //we are modifying the label values
        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.white);
        displayLabel.setFont(new Font("Arial",Font.PLAIN,80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

 

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);



        //We are creating the rows and the columns of the calculator
        //And obviously we are choosing the buttonsPanel1
        buttonsPanel1.setLayout(new GridLayout(5,3));

        // we are choosing the background color
        buttonsPanel1.setBackground(customBlack);
        frame.add(buttonsPanel1);


        //we are creating the different buttons taking the info in the array
        for (int i = 0; i  < buttonsValues.length; i++){
                JButton button = new JButton();
                String buttonValue = buttonsValues[i];
                button.setFont(new Font("Arial",Font.PLAIN,30));
                button.setText(buttonValue);
                button.setFocusable(false);
                button.setBorder(new LineBorder(customBlack));

                if (Arrays.asList(topSymbols).contains(buttonValue)){
                    button.setBackground(customLightGray);
                    button.setForeground(customBlack);
                } else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                    button.setForeground(Color.white);
                    button.setBackground(customOrange);
                }else{
                    button.setBackground(customDarkGray);
                    button.setForeground(Color.white);
                }

            buttonsPanel1.add(button);


             //At this point we are creating the logic of the buttons
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    String bottonValue = button.getText();
                    if (Arrays.asList(rightSymbols).contains(buttonValue)){
                        if (bottonValue.equals("=")){
                            if (a != null){
                                b = displayLabel.getText();
                                int firstNumber = Integer.parseInt(a);
                                int secondNumber = Integer.parseInt(b);
                                if (operator.equals("+")){
                                        int resultado = firstNumber + secondNumber;
                                        displayLabel.setText(Integer.toString(resultado));
                                        clearAll();
                                } else if (operator.equals("-")) {
                                    displayLabel.setText(Integer.toString(firstNumber-secondNumber));
                                    clearAll();
                                } else if (operator.equals("÷")) {
                                    displayLabel.setText(Integer.toString(firstNumber/secondNumber));
                                    clearAll();
                                } else if (operator.equals("×")) {
                                    displayLabel.setText(Integer.toString(firstNumber*secondNumber));
                                    clearAll();
                                }

                            }

                        }
                        else if ("÷+-×".contains(bottonValue)) {
                            if (operator == null){
                                a = displayLabel.getText();
                                displayLabel.setText("0");
                                b = "0";
                            }
                            operator = buttonValue;
                        }


                    }else if (Arrays.asList(topSymbols).contains(buttonValue)){
                            if (bottonValue.equals("AC")){
                                clearAll();
                                displayLabel.setText("0");
                            } else if (bottonValue.equals("+/-")) {
                                double numDisplay = Double.parseDouble(displayLabel.getText());
                                numDisplay *= -1;
                                displayLabel.setText(Double.toString(numDisplay));
                            } else {

                                int numDisplay = Integer.parseInt(displayLabel.getText());
                                numDisplay /= 100;
                                displayLabel.setText(Integer.toString(numDisplay));

                            }
                    }else{
                        if (bottonValue.equals(".")){

                            if (!displayLabel.getText().contains(bottonValue)){
                                displayLabel.setText(displayLabel.getText() + ".");
                            }

                        } else if ("0123456789".contains(bottonValue)) {
                            if (displayLabel.getText().equals("0")){
                                displayLabel.setText(buttonValue);
                            }else{
                                displayLabel.setText(displayLabel.getText()+bottonValue);
                            }
                        }
                    }

                }
                void clearAll (){
                    a = "0";
                    operator = null;
                    b = null;
                }
            });




        }



        frame.setVisible(true);
    }


}
