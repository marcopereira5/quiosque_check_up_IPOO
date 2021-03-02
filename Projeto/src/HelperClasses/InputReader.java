package HelperClasses;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.util.Scanner;

/**
 * A classe InputReader foi estudada e trabalhada durante as aulas de IPOO e POO
 * Esta classe serve como auxilio ao programa e permite-nos ler o que o utilizador introduz na consola, assim tendo
 * um menu interagivel
 *
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class InputReader {
    private Scanner reader;

    /**
     * Cria um objeto InputReader
     */
    public InputReader() {
        this.reader = new Scanner(System.in);
    }

    private void showFormattedQuestion(String question) {
        if (question == null) {
            question = "";
        }

        question = question + "> ";
        System.out.print(question);
    }

    /**
     * Este metodo "le" o número real introduzido pelo utilizador
     * @param question Uma String a qual o utilizador vai indicar um número a seguir
     * @return o numero escolhido pelo utilizador
     */
    public double getRealNumber(String question) {
        this.showFormattedQuestion(question);

        while(!this.reader.hasNextDouble()) {
            this.reader.nextLine();
            this.showFormattedQuestion(question);
        }

        double number = this.reader.nextDouble();
        this.reader.nextLine();
        return number;
    }

    /**
     * Este metodo "le" o número inteiro introduzido pelo utilizador
     * @param question Uma String a qual o utilizador vai indicar um número a seguir
     * @return o numero escolhido pelo utilizador
     */
    public int getIntegerNumber(String question) {
        this.showFormattedQuestion(question);

        while(!this.reader.hasNextInt()) {
            this.reader.nextLine();
            this.showFormattedQuestion(question);
        }

        int number = this.reader.nextInt();
        this.reader.nextLine();
        return number;
    }

    /**
     * Este metodo "le" a resposta introduzida pelo utilizador
     * @param question Uma String a qual o utilizador vai escrever algo a seguir
     * @return a resposta do utilizador
     */
    public String getText(String question) {
        this.showFormattedQuestion(question);
        return this.reader.nextLine();
    }
}
