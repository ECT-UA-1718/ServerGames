/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Esta classe contém funções úteis para serem usadas na lógica do servidor/jogos
 * O seu objetivo é ter funções que pedem ao cliente dados de um certo tipo e só devolvem o valor quando o input do cliente for válido
 * Só aqui devem estar funções que pedem esses valores ao utilizador. Funções que simplesmente validam um valor dado como argumrnto devem estar em Validate.java
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

import java.io.*;

import util.*;

public class Get {

    // Devolve um int que esteja contido em [min, max]
    public static int getIntInRangeFromClient(Client client, int min, int max) throws IOException{
        boolean cond = false;
        String response = "";
        do {
            response = client.receive();
            cond = Validate.isIntInRange(response, min, max);
            if(!cond){
                client.send("Error! Enter a valid number: ");
            }
        } while(!cond);

        return Integer.parseInt(response);
    }

}