import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LoginGUI extends JFrame{
    public static char[] pswd;
    public static String login;
    public static boolean ready;


    LoginGUI(){
        setSize(250, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enter Login/Pass");
        JTextField logintxt = new JTextField();
        JPasswordField pwdtxt = new JPasswordField();
        JLabel loginlbl = new JLabel("Login:");
        JLabel pwdlbl = new JLabel("Password:");
        JButton submitbtn = new JButton("Submit");
        JPanel formPanel = new JPanel(new GridLayout(5,1));
        formPanel.add(loginlbl);
        formPanel.add(logintxt);
        formPanel.add(pwdlbl);
        formPanel.add(pwdtxt);
        formPanel.add(submitbtn);
        add(formPanel);

        submitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pswd = pwdtxt.getPassword();
                login = logintxt.getText();
                ready = true;
                while (true) {
                    if (Client.ready) {
                        if (Client.answer.equals("true")) {
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    new ClientGUI();
                                }
                            });
                            break;

                        } else {
                            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    new ErrorGUI();
                                }
                            });
                        }
                    }
                }
            }});
        setVisible(true);
    }
}