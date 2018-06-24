import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;


class LoginGUI extends JFrame {
    private String answer;
    private MyDialog errorDialog;
    public static ResourceBundle cuBundle;
    private ResourceBundle ruBundle = ResourceBundle.getBundle("resource.resource", new Locale("ru", "RU"));
    private ResourceBundle enBundle = ResourceBundle.getBundle("resource.resource", new Locale("en", "US"));
    private ResourceBundle uaBundle = ResourceBundle.getBundle("resource.resource", new Locale("ua", "UA"));
    private ResourceBundle fiBundle = ResourceBundle.getBundle("resource.resource", new Locale("fi"));
    private ResourceBundle esBundle = ResourceBundle.getBundle("resource.resource", new Locale("es"));


    LoginGUI() {


        cuBundle = enBundle;


        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Enter Login/Pass");
        JTextField logintxt = new JTextField(15);
        JPasswordField pwdtxt = new JPasswordField(15);
        JLabel loginlbl = new JLabel("Login:");
        JLabel pwdlbl = new JLabel("Password:");
        JButton submitbtn = new JButton("Log in");
        JButton signUpbtn = new JButton("Sign up");
        JPanel formPanel = new JPanel(new GridLayout(6, 1));
        JMenuBar jMenuBar = new JMenuBar();
        JMenu language = new JMenu("language");
        JMenuItem ru = new JMenuItem("Русский");
        JMenuItem ua = new JMenuItem("Український");
        JMenuItem fi = new JMenuItem("Suomalainen");
        JMenuItem es = new JMenuItem("Español");


        ru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(ruBundle.getString("loginTitle"));
                loginlbl.setText(ruBundle.getString("login"));
                pwdlbl.setText(ruBundle.getString("password"));
                submitbtn.setText(ruBundle.getString("log in"));
                signUpbtn.setText(ruBundle.getString("sign up"));
                language.setText(ruBundle.getString("language"));
                cuBundle = ruBundle;
                revalidate();
                repaint();
            }
        });
        ua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(uaBundle.getString("loginTitle"));
                loginlbl.setText(uaBundle.getString("login"));
                pwdlbl.setText(uaBundle.getString("password"));
                submitbtn.setText(uaBundle.getString("log in"));
                signUpbtn.setText(uaBundle.getString("sign up"));
                language.setText(uaBundle.getString("language"));
                cuBundle = uaBundle;
                revalidate();
                repaint();
            }
        });
        fi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(fiBundle.getString("loginTitle"));
                loginlbl.setText(fiBundle.getString("login"));
                pwdlbl.setText(fiBundle.getString("password"));
                submitbtn.setText(fiBundle.getString("log in"));
                signUpbtn.setText(fiBundle.getString("sign up"));
                language.setText(fiBundle.getString("language"));
                cuBundle = fiBundle;
                revalidate();
                repaint();
            }
        });
        es.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTitle(esBundle.getString("loginTitle"));
                loginlbl.setText(esBundle.getString("login"));
                pwdlbl.setText(esBundle.getString("password"));
                submitbtn.setText(esBundle.getString("log in"));
                signUpbtn.setText(esBundle.getString("sign up"));
                language.setText(esBundle.getString("language"));
                cuBundle = esBundle;
                revalidate();
                repaint();
            }
        });

        language.add(es);
        language.add(fi);
        language.add(ua);
        language.add(ru);
        jMenuBar.add(language);
        formPanel.add(loginlbl);
        formPanel.add(logintxt);
        formPanel.add(pwdlbl);
        formPanel.add(pwdtxt);
        formPanel.add(submitbtn);
        formPanel.add(signUpbtn);
        setJMenuBar(jMenuBar);
        add(formPanel);

        submitbtn.addActionListener(e -> {
            errorDialog = new MyDialog(LoginGUI.this, cuBundle, "check_error");
            answer = Client.getClient().checkCombination(logintxt.getText(), pwdtxt.getText());
            if (answer.equals("true")) {
                SwingUtilities.invokeLater(ClientGUI::new);
                setVisible(false);
            } else if (answer.equals("false")) {
                errorDialog.setVisible(true);
                logintxt.setText("");
                pwdtxt.setText("");
            } else if (answer.equals("ban")) {
                MyDialog banDialog = new MyDialog(LoginGUI.this, cuBundle, "banMessage");
                banDialog.setVisible(true);
                logintxt.setText("");
                pwdtxt.setText("");
            }
        });

        signUpbtn.addActionListener(e -> {
            MyDialog successDialog = new MyDialog(LoginGUI.this, cuBundle, "successSignUpMessage");
            Client.getClient().signUp(logintxt.getText(), pwdtxt.getText());
            successDialog.setVisible(true);
        });
        setVisible(true);
    }
}