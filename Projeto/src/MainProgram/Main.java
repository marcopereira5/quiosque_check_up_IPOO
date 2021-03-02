package MainProgram;

/**
 * Esta classe e usada para correr o programa, mostrando logo um prompt para o utilizador criar um perfil ou usar um ja existente;
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

public class Main {
    /**
     * Corre o programa
     * @param args programa
     */
    public static void main(String[] args) {
        Module module = new Module();
        Menu menu = new Menu(module);
        module.turnModuleOn();
        menu.backEndMenu();
    }
}
