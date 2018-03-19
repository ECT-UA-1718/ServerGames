/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Esta classe contém funções úteis para serem usadas na lógica do servidor/jogos
 * O seu objetivo é ter funções/variaveis variadas que não se aplicam a qualquer outra classe desta package
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

package util;

public class Misc{
    public static final String getLogo(){
        String logo;
        logo =  " __                           ___                          \n";
        logo += "/ _\\ ___ _ ____   _____ _ __ / _ \\__ _ _ __ ___   ___  ___ \n";
        logo += "\\ \\ / _ \\ '__\\ \\ / / _ \\ '__/ /_\\/ _` | '_ ` _ \\ / _ \\/ __|\n";
        logo += "_\\ \\  __/ |   \\ V /  __/ | / /_\\\\ (_| | | | | | |  __/\\__ \\\n";
        logo += "\\__/\\___|_|    \\_/ \\___|_| \\____/\\__,_|_| |_| |_|\\___||___/\n";

        return logo;
    }

    public static final String getMenu(){
        String menu;
        menu =  "\n-----------------------------------------------------------\n";
        menu += "Options: \n";
        menu += "[1] Play game x\n";
        menu += "[2] Play game y\n";
        menu += "[3] Play game z\n";
        menu += "[4] Leave\n";
        menu = menu + "> \n";

        return menu;
    }
}