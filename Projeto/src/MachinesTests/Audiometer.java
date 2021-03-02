package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.RandomHelp;
import HelperClasses.TimeAux;
import PersonalInfo.Person;

import java.util.HashMap;
import java.util.Objects;
/**
 * Esta classe e uma subclasse da classe TESTS. A classe AudiometerFx tem a função de verificar a audiometria tonal de
 * um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class Audiometer extends Tests {

    /**
     * Cria um equipamento de teste
     * @param person uma pessoa para a sua superclasse
     */
    public Audiometer(Person person){
        super(person);
    }

    /**
     * E um metodo da superclasse para correr as funcionalidades do equipamento
     * Executa os testes necessários utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        System.out.println(getInfo());
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run() {
        InputReader reader = new InputReader();
        String choice;

        do {
            System.out.println("Welcome to the audiometer test: ");
            choice = reader.getText("Start? Y for yes / N for no");
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
        }
    }

    /**
     * Este metodo faz o teste em si, simulando os valores do utilizador
     * @return uma string contendo o teste feito
     */
    @Override
    public String getInfo(){
        StringBuilder info = new StringBuilder("Tonal Audiometry");
        for (int z = 0; z  < 2; z++) {
            info.append((z == 0) ? "\n************ LEFT EAR ************\n" : "\n************ RIGHT EAR ************\n");
            for (int i = 500; i <= 8000; i += 500) {
                for (int j = -10; j <= 30; j += 10) {
                    boolean w = RandomHelp.getRandomBoolean();
                    info.append("\nFrequency: ").append(i).append("Hz -> ").append("Volume Decibels: ").append(j).append("dB \nPressed: ").append(Boolean.toString(w));
                    if (w) {
                        break;
                    }
                }
            }
        }
        return info.toString() + "\n--------------------------------------------\n";
    }

    public HashMap<Integer, Integer> getResults(){
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 500; i <= 8000; i += 500) {
            for (int j = -10; j <= 30; j += 10) {
                boolean w = RandomHelp.getRandomBoolean();
                if (w) {
                    map.put(i,j);
                    break;
                }
            }
        }
        return map;
    }
}
