package label;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Integer.parseInt;
public class Game extends JFrame{
    private JTextField pIn;
    private JTextArea outputArea;
    private int sc = 0;

    int playerInput = 0;
    public Game() {
        setTitle("Hand Cricket Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);
        setVisible(true);
    }
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        JLabel label = new JLabel("Enter your choice (Head or Tail):");
        label.setBounds(10, 20, 250, 25);
        panel.add(label);
        pIn = new JTextField(20);
        pIn.setBounds(250, 20, 120, 25);
        panel.add(pIn);
        JButton playButton = new JButton("Play");
        playButton.setBounds(10, 50, 80, 25);
        panel.add(playButton);
        JLabel scoreLabel = new JLabel("Highlights !!!");
        scoreLabel.setBounds(10, 80, 150, 25);
        panel.add(scoreLabel);
        outputArea = new JTextArea();
        outputArea.setBounds(10,70,250,250);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(10, 110, 360, 150);
        panel.add(scrollPane);
        outputArea.setVisible(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play();
            }
        });
    }
    private void play() {
        String choice = pIn.getText().toLowerCase();
        if(choice.equalsIgnoreCase("Head") || choice.equalsIgnoreCase("Tail")){
            ;
        }
        else
        {
            JOptionPane.showMessageDialog(this,"Since you are not interested in the game..Exiting");
            System.exit(1);
        }
        int computer = (int) (Math.random()*10);
        int player = parseInt(JOptionPane.showInputDialog("Enter your guess (0 for Heads and 1 for Tails):"));
        String result;
        outputArea.setVisible(true);
        if (player==0 && computer>5) {
            result = "head";
            outputArea.append("Toss outcome was Head\n");
        } else {
            result = "Tail";
            outputArea.append(" Toss outcome was Tail\n");
        }
        int k;
        if (choice.equalsIgnoreCase(result)) {
            k = parseInt(JOptionPane.showInputDialog("You want to Bat(1) or ball(0):"));
            switch (k) {
                case 0:
                    outputArea.append("You chose to ball");
                    playInGUI(0);
                    break;
                case 1:
                    outputArea.append("You chose to bat");
                    playInGUI(1);
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid Input");
            }
        } else {
            outputArea.append("Computer will bat\n");
            playInGUI(0);
        }
    }
    private void playInGUI(int x) {
        int n = (int) (Math.random() * 10);
        playerInput = 0;
        while (n != playerInput) {
            outputArea.append("Score = " + sc + "\n");
            n = (int) (Math.random() * 10);
            outputArea.append("Player Turn: ");
            String num = JOptionPane.showInputDialog(this,"Enter your number: ","Your Turn",JOptionPane.YES_OPTION);
            playerInput = parseInt(num);
            outputArea.append(""+playerInput+"\n");
            outputArea.append("Computers turn: " + n + "\n");
            if (x == 0) {
                sc += n;
            } else
                sc += playerInput;
        }
        playerInput = 0;
        sc=sc-n+1;
        while ((n != playerInput) && sc >= 0){
            outputArea.append("Required runs = " + sc + "\n");
            outputArea.append("Player Turn: ");
            String num = JOptionPane.showInputDialog(this,"Enter your number: ","Your Turn",JOptionPane.YES_OPTION);
            playerInput = parseInt(num);
            outputArea.append(""+playerInput+"\n");
            n = (int) (Math.random() * 10);
            outputArea.append("Computer's Turn " + n + "\n");
            if (x == 0) {
                sc -= playerInput;
            } else
                sc -= n;
        }
        if ((sc >= 0 && x == 0) || (sc < 0 && x == 1))
            outputArea.append("Computer Win\n");
        else if ((sc >= 0 && x == 1) || (sc < 0 && x == 0))
            outputArea.append("Player Win\n");
    }
}
