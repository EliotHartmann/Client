import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorGUI extends JFrame {
    ErrorGUI(){
        super("Ошибкка");
        JButton okButton = new JButton("OK");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Неправильный логин/пароль!");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginGUI();
                    }
                });
            }
        });
    }

}
