package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.MeasureUnit;
import PersonalInfo.Person;
/**
 * Esta classe e uma subclasse da classe TESTS. A classe Balance tem a função de verificar o peso, altura e IMC de
 * um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

public class Balance extends Tests{
    private MeasureUnit height;
    private MeasureUnit weight;
    private MeasureUnit IMC;

    /**
     * Cria um equipamento Balance
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public Balance(Person person){
        super(person);
        height = new MeasureUnit("Meters", "M", 1);
        weight = new MeasureUnit("Kilograms", "KG", 1);
        IMC = new MeasureUnit("Kilogramas por metros ao quadrado", "KG/m^2", 1);
    }

    private MeasureUnit getWeight() {
        String str = Character.toString(person.getGender());
        if (str.equalsIgnoreCase("M")){
            weight.setValue((Math.random() * (87.5 - 72.5) ) + 72.5);
        }else {
            weight.setValue((Math.random() * (72.5 - 57.5) ) + 57.5);
        }
        return weight;
    }

    private MeasureUnit getHeight(){
        String str = Character.toString(person.getGender());
        if (str.equalsIgnoreCase("M")){
            height.setValue((Math.random() * (2.35 - 1.15) ) + 1.15);
        }else {
            height.setValue((Math.random() * (2.3 - 1.1) ) + 1.1);
        }
        return height;
    }

    private MeasureUnit getIMC(MeasureUnit height, MeasureUnit weight){
        IMC.setValue((weight.getValue() /(height.getValue() * height.getValue())));
        return IMC;
    }

    /**
     * E um metodo da superclasse para correr as funcionalidades do equipamento
     * Executa os testes necessários utilizando metodos desta mesma classe
     */
    @Override
    public void runTests(){
        height = getHeight();
        weight = getWeight();
        IMC = getIMC(height, weight);
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        return "Weight: " + weight.toString() + "\nHeight: " + height.toString() + "\nIMC: " + IMC.toString() + "\nType: " + getImcResult(IMC) + "\n" + "--------------------------------------------\n";
    }

    private String getImcResult(MeasureUnit imc){
        if (imc.getValue() < 17){
            return "Very underweight.";
        }
        else if(imc.getValue() >= 17 && imc.getValue() < 18.5){
            return "Underweight.";
        }
        else if(imc.getValue() >= 18.5 && imc.getValue() < 25){
            return "Normal weight.";
        }
        else if(imc.getValue() >= 25 && imc.getValue() < 30){
            return "Overweight";
        }
        else if(imc.getValue() >= 30 && imc.getValue() < 35){
            return "Obesity 1";
        }
        else if (imc.getValue() >= 35 && imc.getValue() < 40){
            return "Severe obesity";
        }
        return "Morbid obesity";
    }

    private String showTable(){
        return  "|     IMC     |     Classificação     |     Risco de Comorbilidade     |\n" +
                "|    <18.5    |      Baixo Peso       |            Baixo               |\n" +
                "|  18.5-24.9  |      Peso normal      |            Baixo               |\n" +
                "|   25-29.9   |    Excesso de peso    |          Aumentado             |\n" +
                "|   30-34.9   |      Obesidade 1      |          Moderado              |\n" +
                "|   35-39.9   |      Obesidade 2      |            Grave               |\n" +
                "|    >=40     |      Obesidade 3      |         Muito Grave            |\n";
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    public void run(){
        InputReader reader = new InputReader();
        String choice;
        boolean moved;
        do{
            System.out.println("Please stand up on the balance pad.");
            choice = reader.getText("Start? Y for yes / N for no");
            moved = checkIfMoved(choice);
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") || moved && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }

}
