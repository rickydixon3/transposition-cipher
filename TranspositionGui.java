import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class TranspositionGui extends JFrame implements ActionListener {

    public static void main(String[] args) {

        TranspositionGui frame = new TranspositionGui();

    }

    JButton encryptButton;
    JButton decryptButton;
    JButton clearButton;
    JTextArea input;
    JTextArea output;
    JTextArea matrix;
    JTextField keyTextField;


    public TranspositionGui()  {
        // Frame
        this.setTitle("Transposition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(430,500));
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        //Fonts
        Font font1 = new Font("SansSerif", Font.PLAIN, 20);
        Font font2 = new Font("SansSerif", Font.PLAIN,15);
      
        // Header Pnael
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout(10,50));
        header.setBackground(Color.white);
        header.setPreferredSize(new Dimension(100,50));

        JLabel headerText = new JLabel("Transpositon Encryption/Decryption", SwingConstants.CENTER);
        headerText.setFont(font1);
        header.add(headerText);
        this.add(header, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2,10,10));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));
        this.add(mainPanel, BorderLayout.CENTER);
        
        // Input Text Panel
        JPanel inputTextPanel = new JPanel(new BorderLayout());
        inputTextPanel.setBackground(Color.white);
        inputTextPanel.setBorder(new LineBorder(Color.white, 2, true));

        JLabel inputLabel = new JLabel("Input Text", SwingConstants.CENTER);
        inputLabel.setFont(font2);

        input = new JTextArea();
        input.setBackground(Color.white);
        input.setLineWrap(true);
        input.setWrapStyleWord(true);
        input.setFont(font2);
        JScrollPane inputScroll = new JScrollPane(input);

        JPanel edPanel = new JPanel();
        edPanel.setBackground(Color.white);

        encryptButton = new JButton("Encrypt");
        decryptButton = new JButton("Decrypt");

        encryptButton.addActionListener(this);
        decryptButton.addActionListener(this);

        encryptButton.setFocusable(false);
        decryptButton.setFocusable(false);
        edPanel.add(encryptButton);
        edPanel.add(decryptButton);

        inputTextPanel.add(inputLabel, BorderLayout.NORTH);
        inputTextPanel.add(inputScroll, BorderLayout.CENTER);
        inputTextPanel.add(edPanel, BorderLayout.SOUTH);
        mainPanel.add(inputTextPanel);

        // Output Text
        JPanel outputTextPanel = new JPanel(new BorderLayout());
        outputTextPanel.setBackground(Color.white);
        outputTextPanel.setBorder(new LineBorder(Color.white,2,true));

        output = new JTextArea();
        output.setBackground(Color.white);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setFont(font2);
        output.setEditable(false);
        output.setFocusable(true);
        JScrollPane outputScroll = new JScrollPane(output);

        JLabel outputLabel = new JLabel("Plain/Cipher Text", SwingConstants.CENTER);
        outputLabel.setFont(font2);
        outputTextPanel.add(outputLabel, BorderLayout.NORTH);
        outputTextPanel.add(outputScroll, BorderLayout.CENTER);

        mainPanel.add(outputTextPanel);

        // Options Panel
        JPanel optionsPanel = new JPanel(new FlowLayout());
        optionsPanel.setBackground(Color.white);
        optionsPanel.setBorder(new LineBorder(Color.white, 1, true));
     
        JLabel optionsLabel = new JLabel("Enter Key");
        optionsLabel.setFont(font2);
        keyTextField = new JTextField(5);
        keyTextField.setBackground(new Color(245,245,245));
        keyTextField.setBorder(new LineBorder(Color.white, 1));

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clearButton.setFocusable(false);
        optionsPanel.add(optionsLabel);
        optionsPanel.add(keyTextField);
        optionsPanel.add(clearButton);
        mainPanel.add(optionsPanel);

        // Matrix Panel
        JPanel matrixPanel = new JPanel(new BorderLayout());
        matrixPanel.setBackground(Color.white);
        matrixPanel.setBorder(new LineBorder(Color.white, 2, true));

        JLabel matrixLabel = new JLabel("Matrix", SwingConstants.CENTER);
        matrixLabel.setFont(font2);


        matrix = new JTextArea();
        matrix.setBackground(Color.white);
        matrix.setLineWrap(true);
        matrix.setWrapStyleWord(false);
        matrix.setFont(font2);
        matrix.setEditable(false);
        matrix.setFocusable(false);

        JScrollPane matrixScroll = new JScrollPane(matrix);

        matrixPanel.add(matrixLabel, BorderLayout.NORTH);
        matrixPanel.add(matrixScroll, BorderLayout.CENTER);
        mainPanel.add(matrixPanel);

        // Makes Frame Visible
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == encryptButton) {
            String keyString = keyTextField.getText();
            int key = Integer.parseInt(keyString);

            String text = input.getText();
            System.out.println(text);
            output.setText(TranspositionCipher.encrypt(text, key));

            String outputText = TranspositionCipher.encrypt(text, key);
            // Debugging
            System.out.println(outputText);
            String matrixText = TranspositionCipher.printMatrix(text, key);
            matrix.setText(matrixText);
            System.out.println(matrixText);

        } else if (e.getSource() == decryptButton) {
            String keyString = keyTextField.getText();
            int key = Integer.parseInt(keyString);
            String text = input.getText();
            System.out.println(text);
            output.setText(TranspositionCipher.decrypt(text, key));
            System.out.println(output);
            String matrixText = TranspositionCipher.printMatrix(text, key);
            matrix.setText(matrixText);
            System.out.println(matrixText);
        
        } else if (e.getSource() == clearButton) {
            System.out.println("Clear");
            input.setText(null);
            output.setText(null);
            keyTextField.setText(null);
            matrix.setText(null);
        }

    }

}