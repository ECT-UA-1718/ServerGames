/*
 * ServerGames by ECT UA 17/18
 * https://github.com/ECT-UA-1718/ServerGames
 * 
 * Esta classe contém funções úteis para serem usadas na lógica do servidor/jogos
 * O seu objetivo é ter várias cores que se podem chamar para imprimir no terminal do utilizador
 * Para além disso, pode ter funções relacionadas com a aplicação dessas cores
 * 
 * ESTE PROGRAMA NÃO ESTA ACABADO
 */

 // NOTA: Utilização: print(Cor.BLUE + "olá" + Cor.ENDC);

package util;

public class Cor {
    // TODO: Ainda há muito mais cores que se podem adicionar, incluido 'background colors' 
    public static final String HEADER = "\033[95m";
    public static final String BLUE = "\033[94m";
    public static final String GREEN = "\033[92m";
	public static final String WARNING = "\033[93m";
	public static final String FAIL = "\033[91m";
    public static final String ENDC = "\033[0m"; // ENDC faz a cor voltar ao normal
	public static final String BOLD = "\033[1m";
    public static final String UNDERLINE = "\033[4m";
    
    // Utilização: print(applyColor("olá", Cor.BLUE));
    // O resultado desta função é igual a fazer print(Color.BLUE + "olá" + Color.ENDC);
    // Existe meramente para simplificar o processo
    public static String applyColor(String s, String color){
        return color + s + ENDC;
    }
}