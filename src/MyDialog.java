import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

public class MyDialog extends JDialog {
    public MyDialog(JFrame owner, ResourceBundle resourceBundle, String message){
        super(owner, resourceBundle.getString("message"), true);
        add(new JLabel("       " + resourceBundle.getString(message)), BorderLayout.CENTER);
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JPanel panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        setSize(300, 150);
    }
}
