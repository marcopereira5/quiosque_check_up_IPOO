package MachinesTests;

import HelperClasses.*;
import PersonalInfo.Person;

/**
 * Esta classe e uma subclasse da classe TESTS. A classe HorizontalScale tem a funçao de verificar o perimetro abdominal
 * de um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class HorizontalScale extends Tests {
    private MeasureUnit result;

    /**
     * Cria um equipamento HorizontalScale
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public HorizontalScale(Person person) {
        super(person);
        result = new MeasureUnit("Centimeters", "cm", 1);
    }

    private MeasureUnit getHorizontalScale(){
        String str = Character.toString(person.getGender());
        if (str.equalsIgnoreCase("M")){
            double r = (Math.random() * (38.5 - 31.5) ) + 31.5;
            double s = (Math.random() * (27.5 - 22.5) ) + 22.5;
            result.setValue(Math.PI * Math.sqrt((Math.pow(r,2) + Math.pow(s,2))/2));
        } else {
            double r = (Math.random() * (33 - 27) ) + 27;
            double s = (Math.random() * (22 - 18) ) + 18;
            result.setValue(Math.PI * Math.sqrt((Math.pow(r,2) + Math.pow(s,2))/2));
        }
        return result;
    }

    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessarios utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        result = getHorizontalScale();
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe, cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        String str = Character.toString(person.getGender());
        String info= "Abdominal perimeter: " + result.toString();
        if ((str.equalsIgnoreCase("M") && result.getValue() > 102) || (str.equalsIgnoreCase("F") && result.getValue() > 88)){
            info += "\nWarning!!! The risk of appearing a hearth decease is really high.";
        } else {
            info += "\nValue on the healthy interval!";
        }
        return info + "\n--------------------------------------------\n";
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run(){
        InputReader reader = new InputReader();
        String choice;

        do {
            System.out.println("Please stand up facing forward.");
            choice = reader.getText("Start? Y for yes / N for no");
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        System.out.println("Now face the machine sideways: ");

        TimeAux.systemSleep(3);

        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }


}
