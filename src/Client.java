import java.io.*;
import java.net.*;
import java.util.Date;

public class Client {
    private static Client client;
    private static Socket socket;
    public static ConcurrentPolicemanSet<Policeman> set = new ConcurrentPolicemanSet<Policeman>(new Date());

    public static Client getClient(){
        if(client == null){
            client = new Client();
        }
        return client;
    }

    private Client(){

    }

    public void createClient(int port) {
        try {
            socket = new Socket(InetAddress.getLocalHost(), port);
            System.out.println("Подключение к серверу");
            this.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run() throws IOException {
            receiveCollection();
    }

    public void receiveCollection(){
        int n = 0;
        String string;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            try {
                ps.println("start");
                ps.flush();
                while (true){
                    string = br.readLine();
                    if(!string.equals("end")) {
                        Client.set.copyOnWriteArraySet.add(WorkJSON.intoJSON(string));
                        System.out.println(string);
                    }else
                        break;
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkCombination(String login, String pswd){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("check");
            System.out.println("check");
            ps.flush();
            ps.println(login);
            System.out.println(login);
            ps.flush();
            ps.println(pswd);
            System.out.println(pswd);
            ps.flush();
            String string;
            while (true){
                string = br.readLine();
                if(!string.equals(""))
                    break;
            }

            System.out.println(string);
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return "IOE";
        }

    }

    public void signUp(String login, String pswd){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println("new");
            ps.flush();
            ps.println(login);
            System.out.println(login);
            ps.flush();
            ps.println(pswd);
            System.out.println(pswd);
            ps.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}