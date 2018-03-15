/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Esta classe represnta um cliente
 * Trata da enviar e receber dados e também de guardar informação sobre o cliente
 * A comunicação server/cliente é feita por Sockets com o protocolo TCP
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

/*
 * Estado: Lógica base presente, pode ser melhorado
 * TODO: Adicionar condições a send() e receive() que detetem desconexão e matem a thread
 */

import java.io.*;
import java.net.*;

public class Client{
    private String nickname;
    private int index; // Vai ser usado para guardar em que indice o cliente está na lista de users. (Assim dá para o tirar da lista mais facilmente (mas, sendo um array list, a variavel 'index' de todos os restantes ojetos Cleinte teria de ser alterada porque ao remover um elemento os indices dos restantes mudam))
    private Socket clientSocket;
    private PrintWriter out; // Usado para enviar dados
    private BufferedReader in; // Usado para receber dados
    //private ServerThread st;

    public Client(Socket s, int i, String n) throws IOException {
        clientSocket = s;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        index = i;
        nickname = n;
    }

    /*
    Estes métodos e a variável st servem para guardar a thread em que o server está para que esta possa ser, se necessário, morta quando o cliente desconectar
    Mas não sei se é realmente preciso

    public void setThread(ServerThread st){
        this.st = st;
    }

    public ServerThread getThread(){
        return st;
    }
    */

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
        // O BufferedReader só deixa ler usando o método readLine(). Contudo, esse método só lê uma linha e a string pode ter várias (\n)
        // Portanto, é necessário iterar por todas as linhas que possam existir

        // ATENÇÃO: Há um bug aqui! Só faz print de uma linha se essa linha tiver \n no fim. Ou seja, o \n não pode ser colocado no início da linha seguinte. Ainda não percebi o porquê do bug

        StringBuilder data = new StringBuilder();
        String line;

        while (!((line = in.readLine()).equals(""))) {
            data.append(line + "\n");
        }

        String s = data.toString();
        return s.substring(0, s.length() - 1); // Eliminar o último \n (que foi adicionado no while loop desta função)
    }
} 