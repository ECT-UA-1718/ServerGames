import java.io.*;
import java.net.*;

public class Client{
    private String nickname;
    private int index;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private ServerThread st;

    public Client(Socket s, int i, String n) throws IOException {
        clientSocket = s;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        index = i;
        nickname = n;
    }

    public void setThread(ServerThread st){
        this.st = st;
    }

    public ServerThread getThread(){
        return st;
    }

    public String getNick(){
        return nickname;
    }

    public int getIndex(){
        return index;
    }

    public void send(String message) throws IOException {
        out.println(message);
    }

    public String receive() throws IOException {
        // BufferedReader only allows reading using the readLine() method. That method only reads one line
        // Therefore, it's necessary to loop through all the lines the buffer may have
        
        StringBuilder data = new StringBuilder();
        String line;
        
        while( (line = in.readLine()) != null) {
            data.append(line + "\n");
        }

        String s = data.toString();
        return s.substring(0, s.length() - 1);
    }
} 