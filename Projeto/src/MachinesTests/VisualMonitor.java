package MachinesTests;


import HelperClasses.*;
import PersonalInfo.Person;

import java.util.Random;

/**
 * Esta classe e uma subclasse da classe TESTS. A classe VisualMonitor tem a funçao de verificar se o utilizador tem
 * daltonismo, astigmatismo e a Acuidade Visual
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class VisualMonitor extends Tests {
    private MeasureUnit visualAcuity;

    /**
     * Cria um equipamento VisualMonitor
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public VisualMonitor(Person person){
        super(person);
        visualAcuity = new MeasureUnit("Chart Level", "CL", 1);
    }

    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessarios utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        checkVisualAcuity();
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run() {
        InputReader reader = new InputReader();
        String choice;
        boolean moved;
        do{
            System.out.println("Please stand one feet apart the machine and cover one eye.");
            choice = reader.getText("Start? Y for yes / N for no");
            moved = checkIfMoved(choice);
            if (choice.equalsIgnoreCase("y")){
                System.out.println("Now cover the other eye.");
                moved = checkIfMoved(choice);
            }
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") || moved && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }

    private String checkAstigmatism(){
        return "Astigmatism:\nRight Eye:"+ Buttons.randomButton().toString() +"\nLeft Eye:" + Buttons.randomButton().toString();
    }

    private String checkColorBlindness(){
        String info = "ColorBlindness: ";
        if (person.getGender() == 'M' && RandomHelp.generateRandom(50, 50) > 8 || person.getGender() == 'F' && RandomHelp.generateRandom(50, 50) > 0.5){
            info += "The user doesn't have color blindness problems";
        } else {
            info += "The user has color blindness problems";
        }
        return info;
    }

    private void checkVisualAcuity(){
        visualAcuity.setValue(RandomHelp.generateRandom(7,2));
    }

    private String visualAcuityInfo(){
        String info = "Visual Acuity: ";
        if (visualAcuity.getValue()< 8){
            info += "The user has a vision impairment, please see a doctor.";
        }else if (visualAcuity.getValue() == 8){
            info += "The user has no problem in his vision";
        } else {
            info += "The user's visual acuity is higher than average";
        }
        return info;
    }


    /**
     * Este metodo, com recurso a outros metodos desta mesma classe, cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo() {
        return checkAstigmatism() +"\n"+ checkColorBlindness() + "\n"+ visualAcuityInfo() + "\n--------------------------------------------\n";
    }
}
