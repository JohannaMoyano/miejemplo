
package gui22;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui22 extends JFrame 
{
    Container panel;
    JTextField jtfNum1, jtfNum2, jtfResult;
    JMenuItem jmiSuma, jmiResta, jmiMul, jmiDiv, jmiCerrar;
    
public Gui22() {
    super("Menús");
    JMenuBar jmb = new JMenuBar();
    setJMenuBar(jmb);
    JMenu operationMenu = new JMenu("Operación");
    operationMenu.setMnemonic('O'); // Letra distinguida
    jmb.add(operationMenu);
    operationMenu.add(jmiSuma = new JMenuItem("Suma", 'S'));
    operationMenu.add(jmiResta = new JMenuItem("Resta", 'R'));
    operationMenu.add(jmiMul = new JMenuItem("Multiplica",'M'));
    operationMenu.add(jmiDiv = new JMenuItem("Divide", 'D'));
    JMenu exitMenu = new JMenu("Salir");
    jmb.add(exitMenu);
    exitMenu.add(jmiCerrar = new JMenuItem("Cerrar", 'C'));
    JPanel p1 = new JPanel();
    p1.setLayout(new FlowLayout());
    p1.add(new JLabel("Número 1"));
    p1.add(jtfNum1 = new JTextField(3));
    p1.add(new JLabel("Número 2"));
    p1.add(jtfNum2 = new JTextField(3));
    p1.add(new JLabel("Resultado"));
    p1.add(jtfResult = new JTextField(4));
    jtfResult.setEditable(false);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(p1, BorderLayout.CENTER);
    jmiSuma.addActionListener(new OyenteMenu());
    jmiResta.addActionListener(new OyenteMenu());
    jmiMul.addActionListener(new OyenteMenu());
    jmiDiv.addActionListener(new OyenteMenu());
    jmiCerrar.addActionListener(new OyenteMenu());
}


public static void main(String args[]) 
{
    Gui22 ventana = new Gui22();
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.pack();
    ventana.setVisible(true);
}


private void calculate(char operator) 
{
    int num1 = (Integer.parseInt(jtfNum1.getText().trim()));
    int num2 = (Integer.parseInt(jtfNum2.getText().trim()));
    int result = 0;
    switch (operator) {
    case '+': result = num1 + num2; break;
    case '-': result = num1 - num2; break;
    case '*': result = num1 * num2; break;
    case '/': result = num1 / num2;
}
jtfResult.setText(String.valueOf(result));
}


class OyenteMenu implements ActionListener 
{
    public void actionPerformed(ActionEvent e) 
{
        String actionCommand = e.getActionCommand();
        if(e.getSource() instanceof JMenuItem) {
        if("Suma".equals(actionCommand)) calculate('+');
        else if("Resta".equals(actionCommand)) calculate('-');
        else
        if("Multiplica".equals(actionCommand)) calculate('*');
        else if("Divide".equals(actionCommand)) calculate('/');
        else if("Cerrar".equals(actionCommand)) System.exit(0);
}
}
}
}