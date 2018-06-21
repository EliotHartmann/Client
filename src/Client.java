import java.io.*;
import java.net.*;
import java.util.Collection;
import java.util.Date;

public class Client {
    private Socket socket;
    static String answer;
    static public boolean ready;
    WorkJSON workJSON = new WorkJSON();
     public static ConcurrentPolicemanSet<Policeman> set = new ConcurrentPolicemanSet<Policeman>(new Date());

    public void createClient(int port) {
        try {
            socket = new Socket(InetAddress.getLocalHost(), port);
            System.out.println("Подключение к серверу");
            this.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() throws IOException {
        int n = 0;
        String string;
        try {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps = new PrintStream(socket.getOutputStream());
            try {
                    System.out.println(br.readLine());
                    n = Integer.parseInt(br.readLine());
                    System.out.println(n);
                for(int i=0; i<n; i++){
                    string = br.readLine();
                    set.copyOnWriteArraySet.add(workJSON.intoJSON(string));
                    System.out.println(string);
                }
//                while (true){
//                    if(LoginGUI.ready){
//                        ps.println(LoginGUI.login);
//                        ps.flush();
//                        ps.println(LoginGUI.pswd);
//                        ps.flush();
//                        ps.close();
//                        break;
//                    }
//                }
//                answer = br.readLine();
//                ready = true;

            }catch (IOException e){
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}