import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter1 extends JFrame {
   
    private final JComboBox<String> fromCurrency;
    private final JComboBox<String> toCurrency;
    private final JTextField amountField;
    private final JTextField resultField;
    private final JButton convertButton;

    public CurrencyConverter1() {
        
        setTitle("Currency Converter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        setLocationRelativeTo(null);

      
        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(50, 50, 100, 25);
        add(fromLabel);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(50, 100, 100, 25);
        add(toLabel);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 150, 100, 25);
        add(amountLabel);

        String[] currencies = {"USD", "EUR", "INR", "GBP", "JPY"};
        fromCurrency = new JComboBox<>(currencies);
        fromCurrency.setBounds(150, 50, 150, 25);
        add(fromCurrency);
        toCurrency = new JComboBox<>(currencies);
        toCurrency.setBounds(150, 100, 150, 25);
        add(toCurrency);
     
        amountField = new JTextField();
        amountField.setBounds(150, 150, 150, 25);
        add(amountField);
        
        convertButton = new JButton("Convert");
        convertButton.setBounds(50, 200, 100, 25);
        add(convertButton);
        
        resultField = new JTextField();
        resultField.setBounds(150, 200, 150, 25);
        resultField.setEditable(false);
        add(resultField);
      
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });
        setVisible(true);
    }

    private void convertCurrency() {
       
        double[][] rates = {
                {1.0, 0.96, 86.46, 0.81, 156.62}, 
                {1.04, 1.0, 89.93, 0.85, 162.92},
                {0.012, 0.011, 1.0, 0.0094, 1.81}, 
                {1.23, 1.18, 106.44, 1.0, 192.82},
                {0.0064, 0.0061, 0.55, 0.0052, 1.0}  
        };

        int fromIndex = fromCurrency.getSelectedIndex();
        int toIndex = toCurrency.getSelectedIndex();

        try {
            double amount = Double.parseDouble(amountField.getText());
            double convertedAmount = amount * rates[fromIndex][toIndex];
            resultField.setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter1();
    }
}
