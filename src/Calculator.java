import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
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




    public Calculator (){

        //we are making a visible window
        frame.setVisible(true);
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
        }




    }


}
