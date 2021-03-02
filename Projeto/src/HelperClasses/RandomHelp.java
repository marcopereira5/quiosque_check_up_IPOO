package HelperClasses;
import java.util.Random;

/**
 * Esta classe tem o proposito de auxiliar com a aleatorizaçao de valores
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public abstract class RandomHelp {

    /**
     * Gera um valor double aleatorio dentro de um intervalo calculado atraves do valor medio e desvio
     * @param valor valor medio
     * @param desvio desvio padrao
     * @return um valor double dentro do intervalo
     */
    public static double generateRandom(double valor, double desvio){
        Random random = new Random();
        double val = ((double) random.nextGaussian() * desvio) + valor;

        return Math.round(val * 10.0)/10.0;
    }

    /**
     * Gera um valor booleano(true ou false)
     * @return um valor booleano
     */
    public static boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }
}
