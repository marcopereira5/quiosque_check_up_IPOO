//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package MainProgram;

import HelperClasses.FileHandler;
import HelperClasses.InputReader;
import HelperClasses.TimeAux;
import PersonalInfo.Person;

/**
 * Esta classe e usada para o menu, tendo todos os metodos para obter os dados das pessoas, realizar os testes e dar output dos resultados
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

public class Menu {
    private InputReader reader = new InputReader();
    private Module module;
    private Person person;

    /**
     * Este construtor e usado para criar um menu correspondente ao modulo do quioque
     * @param module o modulo do quiosque a usar
     */
    Menu(Module module) {
        this.module = module;
        this.person = new Person("Invalid", "10/03/2000", 'M');
    }

    /**
     * Define a pessoa que esta a fazer os testes
     * @param person a pessoa a usar
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    private void showWelcome() {
        System.out.println("Welcome to our check-up clinic! Please enter your information: ");
    }

    private String validateInformation() {
        System.out.println("*****************************************\nName: " + this.person.getName() + "\nBirthDate: " + this.person.getBirthDate() + "\nGender: " + this.person.getGender());

        String choice;
        do {
            choice = this.reader.getText("Is your information correct? Y for yes / N for no ");
        } while(!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));

        return choice;
    }

    private void showMainMenu() {
        System.out.println("Indique o que pretende verificar abaixo. Os resultados serão impressos no fim:");
        System.out.println("\n1 - Medir a tensão arterial");
        System.out.println("2 - Medir o peso e altura e obter o IMC (Indice de Massa Corporal");
        System.out.println("3 - Medir o perímetro abdominal");
        System.out.println("4 - Medir a pressão ocular");
        System.out.println("5 – Medir os batimentos cardíacos e o nível de oxigénio no sangue");
        System.out.println("6 – Estimar a temperatura corporal");
        System.out.println("7 – Fazer o diagnóstico de acuidade auditiva");
        System.out.println("8 – Fazer o diagnóstico da visão");
        System.out.println("9 – Fazer todos os testes");
        System.out.println("\n0 – Imprimir os resultados e terminar");
    }

    private String getName() {
        String name;
        do {
            name = this.reader.getText("Nome e apelido: ");
        } while(name.trim().equals(""));

        return name;
    }

    private char getGender() {
        String gender;
        do {
            gender = this.reader.getText("Sexo");
        } while(!gender.equalsIgnoreCase("M") && !gender.equalsIgnoreCase("F"));

        return gender.charAt(0);
    }

    private String getBirthDate() {
        String date;
        do {
            date = this.reader.getText("Data de nascimento (dd/mm/aaaa)");
        } while(!TimeAux.isDateValid(date, "dd/MM/yyyy"));

        return date;
    }

    private void confirmInformation(Person person) {
        this.showWelcome();
        this.setPerson(person);
    }

    private Person chooseProfile() {
        String choice;
        do {
            System.out.println("Please note that you have to have the name.bin in the same directory of the program");
            choice = this.reader.getText("Do you want to select a previously created profile? Y for yes / N for no");
        } while(choice.equalsIgnoreCase("y") && choice.equalsIgnoreCase("n"));

        if (choice.equalsIgnoreCase("y")) {
            String person = this.reader.getText("Please specify your profile name.");
            return FileHandler.load(person + ".bin");
        } else {
            return new Person(this.getName(), this.getBirthDate(), this.getGender());
        }
    }

    /**
     * Faz o funcionamento do menu, utilizando todos os métodos privados definidos acima
     * E possivel escolher um perfil ou criar um novo (introduzindo novas informacoes)
     * Depois disso confirma a sua informacao e em seguida faz todos os testes ou escolhe os que quer fazer
     * No fim pode-se imprimir os resultados e grava-se num ficheiro o perfil e os dados clinicos
     */
    void backEndMenu() {
        do {
            this.confirmInformation(this.chooseProfile());
        } while(this.person.getName().equalsIgnoreCase("Invalid") || this.validateInformation().equalsIgnoreCase("n"));

        InputReader reader = new InputReader();

        int choice;
        do {
            System.out.println("*****************Please note that this check-up doesn't replace a doctor!*****************");
            this.showMainMenu();
            choice = reader.getIntegerNumber("Please select an option");
            switch(choice) {
                case 0:
                    System.out.println(this.person.getClinicalData().printClinicalData());
                    FileHandler.clinicalDataSave(this.person.getClinicalData(), this.person.getName() + " - Clinical Data");
                    FileHandler.save(this.person);
                    break;
                case 1:
                    this.module.getBloodPressure(this.person);
                    break;
                case 2:
                    this.module.checkHeightAndWeight(this.person);
                    break;
                case 3:
                    this.module.getHorizontalScale(this.person);
                    break;
                case 4:
                    this.module.getPIO(this.person);
                    break;
                case 5:
                    this.module.getHeartbeatAndOxygenLevel(this.person);
                    break;
                case 6:
                    this.module.getTemperature(this.person);
                    break;
                case 7:
                    this.module.doAudioTest(this.person);
                    break;
                case 8:
                    this.module.doEyeTest(this.person);
                    break;
                case 9:
                    this.module.getBloodPressure(this.person);
                    this.module.checkHeightAndWeight(this.person);
                    this.module.getHorizontalScale(this.person);
                    this.module.getPIO(this.person);
                    this.module.getHeartbeatAndOxygenLevel(this.person);
                    this.module.getTemperature(this.person);
                    this.module.doAudioTest(this.person);
                    this.module.doEyeTest(this.person);
            }
        } while(choice != 0);
    }
}
