/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Este programa constitui a segunda parte do flow do servidor.
 * Corre na sua própria thread por isso podem haver várias instâncias a correr simultaneamente. (uma por cliente)
 * Trata de apresentar o menu ao jogador, receber a escolha deste, e começar o jogo. Depois do jogo acabar volta a apresentar o menu
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

/*
 * Estado: Mostra o menu e recebe a escolha, mais nada
 * TODO: Completar switch, ...
 * 
 * Sugestões extra: Mostrar quem está online ao apresentar o menu
 */

import java.io.*;

import util.*;

public class ServerThread extends Thread {
    private Client client;

    public ServerThread(Client client) {
        this.client = client;
    }

    public void run() {
        // É preciso usar try/catch porque não se pode adicionar 'throws IOException' neste método (devido a ser um método proveninente da classe Thread
        try{
            System.out.println("New Thread! Client is: " + client.getNick());
            while(true){
                client.send(Misc.getMenu());
                int option = Get.getIntInRangeFromClient(client, 1, 4); // Pedir ao utilizador um número que seja uma opção válida

                // TODO: Acabar isto
                switch(option){
                    default:
                        // Nada
                        System.out.println(client.getNick() + " chose option number " + option);
                        client.send("Received " + option + "!"); // Tirar isto
                        break;
                }
            }
        } catch (Exception e){}
    }
}