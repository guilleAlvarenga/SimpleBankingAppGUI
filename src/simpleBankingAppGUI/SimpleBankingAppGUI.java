package simpleBankingAppGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class SimpleBankingAppGUI extends JFrame {

    private double balance;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton, withdrawButton, checkBalanceButton, exitButton;

    //Constructor para configurar la interfaz
    public SimpleBankingAppGUI(double initialBalance) {
        this.balance = initialBalance;

        //Configuracion de la ventana
        setTitle("Simple Banking Application");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //Centrar la ventana
        setLayout(new BorderLayout(10, 10)); // BorderLayout con espaciado

        // Panel superior (para el saldo)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        balanceLabel = new JLabel("Your current balance is: $" + balance);
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        topPanel.add(balanceLabel);
        topPanel.setBorder(new EmptyBorder(10,20,10,20)); //Margen alrededor del panel superior

        //Panel central (para los campos de entrada y botones)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 2, 10, 10));
        centerPanel.setBorder(new EmptyBorder(10,20,10,20));

        JLabel amountLabel = new JLabel("Enter amount: ");
        amountLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        amountField = new JTextField();
        amountField.setFont(new Font("Arial", Font.PLAIN, 16));

        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        checkBalanceButton = new JButton("Check Balance");
        exitButton = new JButton("Exit");

        //Estilo de botones
        setButtonStyle(depositButton);
        setButtonStyle(withdrawButton);
        setButtonStyle(checkBalanceButton);
        setButtonStyle(exitButton);

        centerPanel.add(amountLabel);
        centerPanel.add(amountField);
        centerPanel.add(depositButton);
        centerPanel.add(withdrawButton);
        centerPanel.add(checkBalanceButton);
        centerPanel.add(exitButton);

        // Panel inferior (decoracion)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel footerLabel = new JLabel("Thank you for using Simple Banking App!");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        bottomPanel.add(footerLabel);

        //Añadir paneles a la ventana principal
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        //Action Listeners para los botones
        depositButton.addActionListener((ActionEvent e) -> {
            deposit();
        });
        
        withdrawButton.addActionListener((ActionEvent e) -> {
            withdraw();
        });
        
        checkBalanceButton.addActionListener((ActionEvent e) -> {
            checkBalance();
        });
        
        exitButton.addActionListener((ActionEvent e) -> {
            System.exit(0); //Salir de la aplicacion
        });

        setVisible(true);

    }

    //Metodo para aplicar estilo a los botones
    private void setButtonStyle(JButton jbutton) {

    }

    //Metodo para depositar dinero
    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                balance += amount;
                JOptionPane.showMessageDialog(this, "Successfully deposited: $" + amount);
                updateBalanceLabel();
            } else {
                JOptionPane.showMessageDialog(this, "Deposit amount must be poaitive");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Number.");
        }
    }

    //Metodo para retirar dinero
    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                JOptionPane.showMessageDialog(this, "Successfully withdrawn: $"+amount);
                updateBalanceLabel();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number");
        }
    }
    
    //Metodo para mostrar el saldo actual
    
    private void checkBalance(){
        JOptionPane.showMessageDialog(this, "Your current balance is: $" +balance);
    }

    //Actualizar el label de saldo
    private void updateBalanceLabel() {
        balanceLabel.setText("Your current balance is: $" + balance);
    }

    //Metodo principal para ejecutar la aplicacion
    public static void main(String[] args) {
        new SimpleBankingAppGUI(1000);
    }

}
