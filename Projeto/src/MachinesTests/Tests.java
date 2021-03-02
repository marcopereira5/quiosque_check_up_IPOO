package MachinesTests;
import HelperClasses.RandomHelp;
import HelperClasses.TimeAux;
import PersonalInfo.Person;

import java.io.Serializable;
import java.util.Objects;

/**
 *  Esta classe e a superclasse de todos os equimentos existentes no nosso projeto
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public abstract class Tests implements MotionSensor, Serializable {

    Person person;
    private String name;

    /**
     * Construtor a ser utilizado pelas subclasses
     *
     * @param person pessoa a quem vai corresponder o teste
     */
    Tests(Person person) {
        if (person != null) {
            this.person = person;
            this.name = this.getClass().getName();
        }
    }

    /**
     * Metodo implementado nas subclasses
     *
     */
    public abstract void runTests();

    /**
     * Metodo implementado nas subclasses
     *
     */
    public abstract void run();

    /**
     * Metodo equals estudado nas aulas. Criado com o proposito de comparar objetos
     * @param o objeto a ser comparado
     * @return o resultado da comparação
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tests tests = (Tests) o;
        return Objects.equals(name, tests.name);
    }

    /**
     * Metodo hashCode estudado nas aulas. Dois objetos são iguais se tiverem o mesmo hashCode
     * @return int hascode do name
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Metodo implementado nas subclasses
     * @return String
     */
    public abstract String getInfo();

    /**
     * Metodo da interface MotionSensor
     * @return String referindo a inicialização do teste
     */
    @Override
    public String initialize() {
        return "Motion Sensor is initializing... Please don't move";
    }

    /**
     * Metodo da interface MotionSensor
     * @return String referindo o desligamento do teste
     */
    @Override
    public String shutDown() {
        return "Motion Sensor is now shutting down... You can now move";
    }

    /**
     * Metodo da interface MotionSensor
     * Simula um boolean para verificar se o utilizador mexe-se durante a realizaçao do teste ou nao
     * @return boolean(true or false)
     */
    @Override
    public boolean moved() {
        if (RandomHelp.generateRandom(1.0, 1.0) < 0) {
            return true;
        }
        return false;
    }

    /**
     *  Metodo utilizado no Menu, pondo em prática os metodos da interface MotionSensor
     * @param choice Escolha recolhida durante o correr do programa
     * @return um boolean(true or false) como simulaçao do movimento do utilizador
     */
    public boolean checkIfMoved(String choice){
        boolean moved;
        moved = moved();
        if(choice.equalsIgnoreCase("y")){
            System.out.println(initialize());
            TimeAux.systemSleep(3);
        }
        if (moved && !choice.equalsIgnoreCase("n")){
            System.out.println("You moved, please repeat the test.");
        } else if (choice.equalsIgnoreCase("y")){
            System.out.println(shutDown());
        }
        return moved;
    }
}
