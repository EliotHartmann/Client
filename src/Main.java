import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        new Client().createClient(9999);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });

    }
}
