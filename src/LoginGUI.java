import javax.swing.*;
import java.awt.*;


    class LoginGUI extends JFrame{
    private String answer;
    private MyDialog errorDialog;

    LoginGUI(){
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
        JPanel formPanel = new JPanel(new GridLayout(6,1));
        formPanel.add(loginlbl);
        formPanel.add(logintxt);
        formPanel.add(pwdlbl);
        formPanel.add(pwdtxt);
        formPanel.add(submitbtn);
        formPanel.add(signUpbtn);
        add(formPanel);

        submitbtn.addActionListener(e -> {
            errorDialog = new MyDialog(LoginGUI.this, "Invalid login/password combination");
            answer = Client.getClient().checkCombination(logintxt.getText(), pwdtxt.getText());
            if(answer.equals("true")){
                SwingUtilities.invokeLater(ClientGUI::new);
                setVisible(false);
            }else if(answer.equals("false")){
                errorDialog.setVisible(true);
                logintxt.setText("");
                pwdtxt.setText("");
            }else if(answer.equals("ban")){
                MyDialog banDialog = new MyDialog(LoginGUI.this, "You are permanenly banned on server");
                banDialog.setVisible(true);
                logintxt.setText("");
                pwdtxt.setText("");
            }
        });

        signUpbtn.addActionListener(e -> {
            MyDialog successDialog = new MyDialog(LoginGUI.this, "You successfully sign up");
            Client.getClient().signUp(logintxt.getText(), pwdtxt.getText());
            successDialog.setVisible(true);
        });
    setVisible(true);
}
}