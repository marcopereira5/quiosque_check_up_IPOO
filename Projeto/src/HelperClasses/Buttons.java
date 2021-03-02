
package HelperClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * Esta classe tem o proposito de simular a escolha do utilizador na classe VisualMonitor
 * Esta simulaçao podia ser simplificada mas apos ponderação decidimos optar esta implementaçao ao pensarmos na
 * possibilidade de no futuro adicionarmos mais opçoes para o utilizador caso queiramos desenvolver mais um pouco este
 * projeto
 *
 * https://stackoverflow.com/questions/21059328/how-to-randomly-select-a-string-between-two-strings-from-enum-in-java
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public enum Buttons {
    RIGHT,LEFT;

    private static ArrayList<Buttons> buttons = new ArrayList<>();

    static{
        buttons.addAll(Arrays.asList(Buttons.values()));
    }

    /**
     * Este metodo e utilizado para obter um dos botões aleatoriamente
     * Para fazer isto decidimos criar um ArrayList e escolher aleatoriamente um dos indices, assim escolhendo
     * aleatoriamente um dos botoes
     * @return o botao escolhido
     */
    public static Buttons randomButton(){
        int idx = new Random().nextInt(Buttons.values().length);
        return Buttons.values()[idx];
    }

    /**
     * Este metodo simplesmente retorna uma String em representação do botao
     * @return uma String que representa o botao
     */
    @Override
    public String toString() {
        switch (this) {
            case LEFT: return " Left Button (Can't see clearly)";
            case RIGHT: return " Right Button (Can see clearly)";
            default: return " Invalid";
        }
    }
}
