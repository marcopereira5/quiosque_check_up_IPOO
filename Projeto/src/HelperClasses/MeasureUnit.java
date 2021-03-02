package HelperClasses;

import java.io.Serializable;

/**
 * Esta classe tem o proposito de auxiliar com a recolha de dados
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */

public class MeasureUnit implements Serializable {
    private String name;
    private String acronym;
    private double value;

    /**
     * Cria uma unidade de medida a partir do nome, acronimo(abreviatura) e o seu valor
     * @param name nome da unidade
     * @param acronym acronimo da unidade
     * @param value valor a receber
     */
    public MeasureUnit(String name, String acronym, double value) {
        if(name != null && !name.equals("")){
            this.name = name;
        } else {
            this.name = "Invalid";
        }
        if(acronym != null && !acronym.equals("")){
            this.acronym = acronym;
        } else {
            this.acronym = "Invalid";
        }
        if (value > 0){
            this.value = value;
        } else {
            this.value = 1;
        }
    }

    /**
     * Este metodo retorna uma String contendo o valor arredondado e o acronimo da unidade de medida
     * @return uma string contendo informaçao referida acima
     */
    @Override
    public String toString() {
        return (double) Math.round(value * 100.0) / 100.0 + " " + acronym;
    }

    /**
     * Este metodo e utilizado para alterar o valor do value
     * @param value é o novo valor
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Este metodo retorna o valor
     * @return o valor
     */
    public double getValue() {
        return value;
    }
}
