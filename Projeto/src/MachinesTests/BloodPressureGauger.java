package MachinesTests;

import HelperClasses.InputReader;
import HelperClasses.MeasureUnit;
import HelperClasses.TimeAux;
import PersonalInfo.Person;
import HelperClasses.RandomHelp;
/**
 * Esta classe e uma subclasse da classe TESTS. A classe BloodPressureGauger tem a funçao de verificar as pressões sistolica e
 * diastolica de um utilizador
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class BloodPressureGauger extends Tests {
    private MeasureUnit systolicPressure;
    private MeasureUnit diastolicPressure;

    /**
     * Cria um equipamento BloodPressureGauger
     * @param person recebe uma pessoa para a superclasse Tests
     */
    public BloodPressureGauger(Person person){
        super(person);
        systolicPressure = new MeasureUnit("Milimeter of Mercury","mmHg",1);
        diastolicPressure = new MeasureUnit("Milimeter of Mercury","mmHg",1);
    }

    /**
     * E um metodo para correr as funcionalidades do equipamento
     * Executa os testes necessarios utilizando metodos desta mesma classe
     */
    @Override
    public void runTests() {
        systolicPressure.setValue(getSystolicPressure());
        diastolicPressure.setValue(getDiastolicPressure());
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
            System.out.println("Please sit and relax. Put you arm in the band adjust it above your elbow.");
            choice = reader.getText("Are you comfortable? Start? Y for yes / N for no");
            moved = checkIfMoved(choice);
        } while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n") || moved && !choice.equalsIgnoreCase("n"));
        if(choice.equalsIgnoreCase("y")){
            runTests();
            System.out.println(getInfo());
        }
    }

    private double getSystolicPressure(){
        return RandomHelp.generateRandom(120,20);
    }

    private double getDiastolicPressure(){
        return RandomHelp.generateRandom(80,20);
    }

    /**
     * Este metodo, com recurso a outros metodos desta mesma classe cria e retorna uma String com todos os testes feitos
     * @return Uma String com os testes feitos
     */
    @Override
    public String getInfo(){
        String info = "Systolic Pressure \n" + systolicPressure.toString() + "\nDiastolic Pressure \n"+ diastolicPressure.toString();

        if (systolicPressure.getValue() > 180 && diastolicPressure.getValue() > 120){
            info += "\nThe user was diagnosed with Hypertensive Crisis" ;
        } else  if (systolicPressure.getValue() > 140 || diastolicPressure.getValue() > 90){
            info += "\nThe user was diagnosed with Hypertension Stage 2" ;
        } else  if ((systolicPressure.getValue() > 130 && systolicPressure.getValue() < 139) || (diastolicPressure.getValue() > 80 && diastolicPressure.getValue() < 89)){
            info += "\nThe user was diagnosed with Hypertension Stage 1" ;
        } else  if ((systolicPressure.getValue()> 120 && systolicPressure.getValue() < 129) || diastolicPressure.getValue() < 80){
            info += "\nThe user was diagnosed with Pre-Hypertension" ;
        } else {
            info += "\nThe user has Normal Blood Pressure";
        }
        return info + "\n--------------------------------------------\n";
    }
}
