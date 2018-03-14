/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Este programa constitui a primeira parte do flow do servidor.
 * Trata da conexão inicial a um novo cliente e a criação de uma thread que fique a comunicar com esse cliente
 * A comunicação server/cliente é feita por Sockets com o protocolo TCP
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

/*
 * Estado: Lógica principal desta parte do servidor está presente, falta dar uns toquezinhos e melhorar a robustez. Falta o resto do servidor ;-)
 * Sugestões Extra: Fazer um passo intermédio de login (pode ser noutro ficheiro java, ver README.md)
 */


import java.io.*;
import java.net.*;
import java.util.ArrayList;

// ATENÇÃO: Criei uma package 'util' em que devem meter funções úteis ao código do servidor/jogos. Criem as classes que forem precisas
// Adicionalmente, criei uma pasta/package 'games' porque acho que assim o repositório fica mais organizado 
import util.*;

public class ServerMain {

    // NOTA: Aprendi como se faz comunicação por sockets em TCP em java a partir deste link: http://www.baeldung.com/a-guide-to-java-sockets
    private static ServerSocket serverSocket;
    private static Socket clientSocket;
    private static PrintWriter out; // Usado para enviar dados
    private static BufferedReader in; // Usado para receber dados
    private static ArrayList<Client> users = new ArrayList<Client>(); // Usado para manter uma lista de clientes. (Não sei se vai ser preciso mas acho que sim)
    // Usei ArrayList para não ter que andar com uma variavel 'numDeElementos' mas se for preciso muda-se

    /*
     * NOTA: Utilização de ArrayList (vamos dar em P2): 
     * 
     * Instanciar --> ArrayList<Tipo> nome = new ArrayList<Tipo>();
     * Adicionar Elemento --> nome.add(elemento);
     * Saber o tamanho --> int i = nome.size();
     * Remover elemento (altera automáticamente os índices dos restantes elementos) --> nome.remove(index);
     * 
     */

    public static void start(int port) throws IOException {
        serverSocket = new ServerSocket(port); // Começar server
        System.out.println("Server listening on all interfaces...");

        // Continuar ad infinitum a receber potenciais novos clientes
        while (true) {
            clientSocket = serverSocket.accept(); // Aceitar conexão
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = in.readLine(); // Buscar nickname
            if (greeting.contains("nick: ")) {
                String nick = greeting.split(": ")[1];
                System.out.println("New Client: " + nick);
                out.println(Cor.WARNING + misc.getLogo() + Cor.ENDC); // Enviar logo ao client
                Client tmp = new Client(clientSocket, users.size(), nick); // Criar novo objeto Client

                new ServerThread(tmp).start(); // Começar nova thread que executa a lógica presente em ServerThread.java
                    
                users.add(tmp); // Adicionar objeto client à lista

            } // TODO: Tratar do else
        }
    }

    public static void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }

    public ArrayList<Client> getList(){
        return users;
    }

    public static void main(String[] args) throws IOException {
        start(6666); // TODO: Mudar porta 'hardcoded' para argumento/System.in
    }
}