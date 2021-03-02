package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.MeasureUnit;
import HelperClasses.RandomHelp;
import PersonalInfo.Person;

/**
 * Esta classe e uma subclasse da classe TESTS. A classe Tonometer tem a função de verificar o valor da pressao
 * intra-ocular de um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class Tonometer extends Tests {
    private MeasureUnit pio;

    /**
     * Cria um equipamento Tonometer
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public Tonometer (Person person){
        super(person);
        pio = new MeasureUnit("Milimeter of Mercury","mmHg",1);
    }
    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessários utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        getPIOTestResults();
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run() {
        InputReader reader = new InputReader();
        String choice;
        do{
            System.out.println("Please use the tissue provided to wipe your eyes and put your head on the machine and look at light maintaining your eyes opened." +
                    "You're gonna feel a slight breeze in your eyes.");
            choice = reader.getText("Start? Y for yes / N for no");
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }

    private void getPIOTestResults(){
        pio.setValue(RandomHelp.generateRandom(16,3.2));
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe, cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        String info = "PIO: \n" + pio.toString();
        if (pio.getValue() < 11 || pio.getValue() > 21){
            info += "\nAttention! The interocular pressure is of the healthy range. Please consider seeing a doctor.";
        } else {
            info += "\nValue on the healthy interval!";
        }
        return info + "\n--------------------------------------------\n";
    }
}
