/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * This program serves as the client. It is the only file users need.
 * The server/client communication is done via TCP Sockets
 * The only function of the client is to send and receive messages. All remaining logic is handled by the server
 * 
 * Este programa serve como cliente. É o único ficheiro de que os utilizadores precisam.
 * A comunicação server/cliente é feita por Sockets com o protocolo TCP
 * A única função do cliente é enviar e receber mensagens. A restante lógica é executada no servidor
 * 
 * ESTE PROGRAMA NÃO ESTÁ ACABADO
 */


import java.io.*;
import java.net.*;
import java.util.Scanner;

import util.*;

public class ServerGamesClient{
    private static Socket clientSocket;
    private static PrintWriter out; // Usado para enviar dados
    private static BufferedReader in; // Usado para receber dados

    public static void main(String[] args) throws IOException{
        startConnection("127.0.0.1", 6666); 
        // TODO: substituir IP 'hardcoded' por args[0] ou input via System.in.
        // IMPORTANTE: Primeiro é necessário fazer uma função que verfique se o IP é válido (255.255.255.255). Essa função não pode estar na package 'util' porque só queremos dar aos users o ficheiro ServerGamesClient.java
        // TODO: Tratar de network exceptions tipo não haver internet ou o servidor não estar ON, etc...

        // Se o nickname não for fornecido como argumento, peguntar ao utilizador via System.in
        String nick = "";
        if(args.length == 1) nick = args[0];
        else{
            Scanner sc = new Scanner(System.in);
            do{
                System.out.print("Nickname: ");
                nick = sc.nextLine();
            } while (nick.equals(""));
        }
        
        // Enviar nickname para o server
        sendMessage("nick: " + nick);

        // TODO, IMPORTANTE: Ler por socket e por System.in simultaneamente. (será que há 'select' como em python?)
        while(true){
            System.out.print(readMessage());
        }
    }
 
    public static void startConnection(String ip, int port) throws IOException{
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }
 
    public static void sendMessage(String msg) throws IOException{
        out.println(msg);
    }

    public static String readMessage() throws IOException{
        // O BufferedReader só deixa ler usando o método readLine(). Contudo, esse método só lê uma linha e a string pode ter várias (\n)
        // Portanto, é necessário iterar por todas as linhas que possam existir

        // ATENÇÃO: Há um bug aqui! Só faz print de uma linha se essa linha tiver \n no fim. Ou seja, o \n não pode ser colocado no início da linha seguinte. Ainda não percebi o porquê do bug

        StringBuilder data = new StringBuilder();
        String line;
    
        while( !((line = in.readLine()).equals(""))) {
            data.append(line + "\n");
        }

        String s = data.toString();
        return s.substring(0, s.length() - 1); // Eliminar o último \n (que foi adicionado no while loop desta função)
    }
 
    public static void stopConnection() throws IOException{
        in.close();
        out.close();
        clientSocket.close();
    }
}