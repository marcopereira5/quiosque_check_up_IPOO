package PersonalInfo;

import MachinesTests.Tests;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta classe funciona como um armazenamento dos testes feito por uma pessoa sendo possivel adicionar e atualizar
 * quaisquer testes feitos
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class ClinicalData implements Serializable {
    private List<Tests> testsData;

    /**
     * Cria um objeto ClinicalData
     */
    ClinicalData(){
        testsData = new ArrayList<>();
    }

    /**
     * Adiciona um teste feito pela pessoa propriataria da ClinicalData ao conjunto de testes que a pessoa ja ou nao fez
     * @param test teste a adicionar a clinicalData de uma Pessoa
     * @return um valor logico(boolean) que representa o resultado da adiçao
     */
    boolean addTest(Tests test){
        if (test == null){
            return false;
        }

        if (testsData.contains(test)){
            testsData.set(testsData.indexOf(test), test);
            return true;
        } else {
            testsData.add(test);
            return true;
        }
    }

    /**
     * Este metodo apenas mostra todos os resultados dos testes ja feitos
     * @return uma String de todos os testes ja feitos de uma Pessoa
     */
    public String printClinicalData(){
        StringBuilder list = new StringBuilder("-----------------------------\n****** CLINICAL DATA ****** \nSHOWN BY THE ORDER YOU HAVE TAKEN THE TESTS\n");
        for (int i = 0; i < testsData.size(); i++){
            list.append(testsData.get(i).getInfo());
        }
        return list.toString();
    }
}
