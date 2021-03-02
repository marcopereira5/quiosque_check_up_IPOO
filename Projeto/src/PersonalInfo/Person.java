package PersonalInfo;

import MachinesTests.Tests;

import java.io.Serializable;

/**
 * Esta classe acaba por representar uma Pessoa ou um utilizador sendo definida pelo seu nome, data de Nascimento e
 * género. Cada pessoa tem a sua propia ClinicalData
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public class Person implements Serializable {
    private String name;
    private String birthDate;
    private char gender;
    private ClinicalData clinicalData;

    /**
     * Cria uma Pessoa
     * @param name nome da pessoa
     * @param birthDate data de nascimento da pessoa
     * @param gender genero da pessoa
     */
    public Person(String name, String birthDate,  char gender){
        if (name == null || name.equalsIgnoreCase("")){
            throw new IllegalArgumentException("Invalid Name");
        } else {
            this.name = name;
        }
        String str = Character.toString(gender);
        if(str.equalsIgnoreCase("M") || str.equalsIgnoreCase("F")){
            this.gender = gender;
        } else {
            throw new IllegalArgumentException("Invalid Gender");
        }
        clinicalData = new ClinicalData();
    }

    /**
     * Metodo para obter o nome da pessoa
     * @return o nome da Pessoa
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para obter a data de Nascimento da pessoa
     * @return a data de nascimento da pessoa
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Metodo para mudar o nome da Pessoa
     * @param name novo nome da Pessoa
     */
    public void setName(String name) {
        if(name != null){
            this.name = name;
        }else{
            this.name = "Invalid";
        }
    }

    /**
     * Metodo para obter o genero da pessoa
     * @return género da pessoa
     */
    public char getGender() {
        return gender;
    }

    private void setGender(char gender){
        String str = Character.toString(gender);
        if(str.equalsIgnoreCase("M") || str.equalsIgnoreCase("F")){
            this.gender = gender;
        }else {
            gender = 'M';
        }
    }

    /**
     * Metodo para adicionar testes à ClinicalData da Pessoa
     * @param test teste a adicionar
     * @return um valor logico(boolean) que representa o resultado da adiçao
     */
    public boolean addTest(Tests test){
        return clinicalData.addTest(test);
    }

    /**
     * Metodo para obter a ClinicalData de uma Pessoa
     * @return a ClinicalData da Pessoa
     */
    public ClinicalData getClinicalData() {
        return clinicalData;
    }
}
