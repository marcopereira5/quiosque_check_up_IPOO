package MainProgram;

import MachinesTests.*;
import PersonalInfo.Person;

/**
 * Esta classe e o módulo do quiosque que interliga as máquinas e e usada no menu para correr os testes
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

class Module {
    private boolean isActive;

    /**
     * Cria o modulo do quiosque e inicializa o atributo isActive como false que simboliza o modulo estar desligado
     */
    Module(){
        isActive = false;
    }

    /**
     * Liga o modulo
     */
    void turnModuleOn(){
        isActive = true;
    }

    /**
     * Realiza o teste de altura e de pesos (calculando o imc)
     * @param person a pessoa a ser realizado o teste
     */
    void checkHeightAndWeight(Person person){
        Balance balance = new Balance(person);
        if(isActive){
            balance.run();
            person.addTest(balance);
        }
    }

    /**
     * Realiza o teste do perimetro abdominal
     * @param person a pessoa a ser realizado o teste
     */
    void getHorizontalScale(Person person){
        HorizontalScale horizontalScale = new HorizontalScale(person);
        if(isActive){
            horizontalScale.run();
            person.addTest(horizontalScale);
        }
    }

    /**
     * Realiza o teste auditivo
     * @param person a pessoa a ser realizado o teste
     */
    void doAudioTest(Person person){
        Audiometer audiometer = new Audiometer(person);
        if (isActive){
            audiometer.run();
            person.addTest(audiometer);
        }
    }

    /**
     * Realiza o teste da pressao no sangue
     * @param person a pessoa a ser realizado o teste
     */
    void getBloodPressure(Person person){
        BloodPressureGauger bloodPressureGauger = new BloodPressureGauger(person);
        if (isActive){
            bloodPressureGauger.run();
            person.addTest(bloodPressureGauger);
        }
    }

    /**
     * Realiza o teste em relaçao aos batimentos cardiacos e ao nivel de oxigenio no sangue
     * @param person a pessoa a ser realizado o teste
     */
    void getHeartbeatAndOxygenLevel(Person person){
        Oximeter oximeter = new Oximeter(person);
        if (isActive){
            oximeter.run();
            person.addTest(oximeter);
        }
    }

    /**
     * Realiza o teste em relaçao à temperatura
     * @param person a pessoa a ser realizado o teste
     */
    void getTemperature(Person person){
        Thermometer thermometer = new Thermometer(person);
        if (isActive){
            thermometer.run();
            person.addTest(thermometer);
        }
    }

    /**
     * Realiza o teste da pressao intra-ocular
     * @param person a pessoa a ser realizado o teste
     */
    void getPIO(Person person){
        Tonometer tonometer = new Tonometer(person);
        if(isActive){
            tonometer.run();
            person.addTest(tonometer);
        }
    }

    /**
     * Realiza o teste visual
     * @param person a pessoa a ser realizado o teste
     */
    void doEyeTest(Person person){
        VisualMonitor visualMonitor = new VisualMonitor(person);
        if (isActive){
            visualMonitor.run();
            person.addTest(visualMonitor);
        }
    }
}
