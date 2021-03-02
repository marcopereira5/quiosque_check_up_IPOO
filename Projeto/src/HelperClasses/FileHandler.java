package HelperClasses;

import PersonalInfo.ClinicalData;
import PersonalInfo.Person;

import java.io.*;

/**
 * Esta classe serve como auxilio ao programa e faz gestao de ficheiros, gravando e carregando ficheiros das informaçoes
 * das pessoas
 *
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public abstract class FileHandler {
    /**
     * Este metodo e utilizado paa criar um ficheiro com os testes feitos por uma pessoa
     * @param clinicalData os testes feitos pela pessoa
     * @param filename o nome do ficheiro
     */
    public static void clinicalDataSave(ClinicalData clinicalData, String filename){
        File file = new File(filename);

        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter= new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(clinicalData.printClinicalData());
            printWriter.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo guarda as informaçoes da pessoa pela primeira vez que ela usufrui do Quiosque de Check-UP. Com este
     * metodo implementado no programa é possivel guardar o perfil da pessoa podendo ser reutilizado mais tarde
     * @param person A pessoa que faz o check-up
     */
    public static void save(Person person){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(person.getName() + ".bin"));

            oos.writeObject(person);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Este metodo permite ler as informaçoes de um ficheiro. Com este methodo e os metodos anteriores e possivel manter
     * um sistema do estilo de perfis.
     * @param filename O nome do ficheiro a ler
     * @return a pessoa a quem o ficheiro pertence
     */
    public static Person load(String filename){
        Person person;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename + ".bin"));

            person = (Person) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            person = new Person("Invalid", "10/03/2000", 'M');
            System.out.println("Profile not valid!");
        }
        return person;
    }


}
