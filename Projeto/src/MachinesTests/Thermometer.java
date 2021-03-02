package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.MeasureUnit;
import HelperClasses.RandomHelp;
import HelperClasses.TimeAux;
import PersonalInfo.Person;

/**
 * Esta classe e uma subclasse da classe TESTS. A classe Thermometer tem a funçao de verificar a temperatura
 * corporal de um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class Thermometer extends Tests{
    private MeasureUnit temperature;

    /**
     * Cria um equipamento Thermometer
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public Thermometer(Person person){
        super(person);
        temperature = new MeasureUnit("Celsius","º C", 1);
    }

    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessarios utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        getTemperature();
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run() {
        InputReader reader = new InputReader();
        String choice;
        do{
            System.out.println("Please stand still when probe is in you temple.");
            choice = reader.getText("Start? Y for yes / N for no");
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        TimeAux.systemSleep(5);
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }


    private void getTemperature(){
        temperature.setValue(RandomHelp.generateRandom(36.7,1.835));
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe, cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        String info = "Temperature\n" + temperature.toString();
        if (temperature.getValue() <= 36.0){
            info += "\nAttention! The temperature is off the healthy values, you can enter hypothermia state, please consider seeing a doctor.";
        } else if (temperature.getValue() >= 37.4) {
            info += "\nAttention! The temperature is off the healthy values, you have a fever, please consider seeing a doctor.";
        } else {
            info += "\nHealthy!";
        }
        return info + "\n--------------------------------------------\n";
    }

}
