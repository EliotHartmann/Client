import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Client.getClient().createClient(9999);
            javax.swing.SwingUtilities.invokeLater(LoginGUI::new);
    }
}
