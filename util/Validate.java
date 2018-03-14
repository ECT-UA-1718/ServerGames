/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Esta classe contém funções úteis para serem usadas na lógica do servidor/jogos
 * O seu objetivo é ter funções que validem dados de vários tipos, fornecidos como argumento.
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

package util;

public class Validate{

    // Averigua se uma string só contém digitos (é um int válido)
    public static boolean isInt(String s){
        try {
            int i = Integer.parseInt(s);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    // Averigua se uma string só contém digitos (é um int válido) e se o int resultante está no intervalo [min, max]
    public static boolean isIntInRange(String s, int min, int max){
        if(isInt(s)) {
            int i = Integer.parseInt(s);
            return i <= max && i >= min;
        } else return false;
    }
}