package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.MeasureUnit;
import HelperClasses.RandomHelp;
import PersonalInfo.Person;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Esta classe e uma subclasse da classe TESTS. A classe Oximeter tem a função de verificar a percentagem de oxigenio
 * no sangue e o batimento cardiaco de um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

public class Oximeter extends Tests {
    private MeasureUnit heartRate;
    private MeasureUnit bloodOxygenLevel;
    private double[] valuesHeartRate;

    /**
     * Cria um equipamento Oximeter
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public Oximeter(Person person){
        super(person);
        heartRate = new MeasureUnit("Beats per Minute","bpm",1);
        bloodOxygenLevel = new MeasureUnit("Percentage","%",1);
    }

    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessarios utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        getHeartRate();
        getBloodOxygenLevel();
    }

    /**
     * Um metodo utilizado para correr e usar o equipamento durante o progama no menu
     */
    @Override
    public void run() {
        InputReader reader = new InputReader();
        String choice;
        do{
            System.out.println("Please put your index finger on the sensor.");
            choice = reader.getText("Start? Y for yes / N for no");
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
            System.out.println(checkHealthyRange(valuesHeartRate));
        }
    }


    private double[] getHeartRate(){
        int nbeats = (int) (60 / 0.86);

        double values[] = new double[nbeats];

        for (int i = 0; i < 60 ; i++) {
            values[i] = RandomHelp.generateRandom(70,7);
        }

        double sum = 0;
        double number = 0;
        for (int i = 0; i < 60; i++) {
            sum += values[i];
            number++;
        }

        double avg = sum/number;
        heartRate.setValue(avg);
        valuesHeartRate = values;
        return values;
    }

    private void getBloodOxygenLevel(){
        bloodOxygenLevel.setValue(RandomHelp.generateRandom(97,2));
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe, cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        if (bloodOxygenLevel.getValue() < 90) {
            return "Rítmo Cardíaco \n" + heartRate.toString() + "\n\nPercentagem de Oxigénio \n" + bloodOxygenLevel.toString()
                    + "\nThe Oxygen level in you blood is under the advised limit. Please consider seeing a doctor.";
        }
        return "Beats per minute: \n" + heartRate.toString() + "\n\nO2 percentage:  \n" + bloodOxygenLevel.toString() + "\nAll values on the healthy interval!\n--------------------------------------------\n";
    }

    private String checkHealthyRange(double[] values){
        for (Double value: values) {
            if (value > 100 || value < 60){
                return "There are values outside the healthy range";
            }
        }
        return "There are no problems with the person's heartbeat";
    }

    public HashMap<Double, Double> getResults(){
        double[] arr = getHeartRate();
        int beat = (int) (60/0.86);
        double nbeats[] = new double[beat];
        double j = 0;

        for (int i = 0; i < nbeats.length; i++){
            j += 0.86;
            nbeats[i] = j;
        }
        HashMap<Double, Double> map = new HashMap();
        for (int i = 0; i < 60; i++) {
            double value = arr[i];
            map.put(nbeats[i],arr[i]);
        }
        return map;
    }

    private ArrayList<Integer> getHeartRate2(){
        int nbeats = (int) (60 / 0.86);

        ArrayList<Integer> values = new ArrayList<>();

        for (double i = 0; i < 60; i += 0.86) {
            values.add( (int) RandomHelp.generateRandom(70,7));
            System.out.println("oh yeah");
        }

        double sum = 0;
        double number = 0;
        for (int i = 0; i < values.size(); i++) {
            sum += values.get(i);
            number++;
        }

        double avg = sum/number;
        double arr[] = new double[nbeats];
        for (int h = 0 ; h < values.size(); h++){
            arr[h] = values.get(h);
        }
        heartRate.setValue(avg);
        valuesHeartRate = arr;
        return values;
    }
}
