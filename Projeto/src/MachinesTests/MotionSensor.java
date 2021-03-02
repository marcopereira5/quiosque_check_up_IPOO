package MachinesTests;
/**
 * Esta interface foi criada com o proposito de simular a possibilidade de existir um erro na realizaçao de um teste
 * devido ao movimento do utilizador
 * As classes que usufruem desta interface sao: VisualMonitor, BloodPressureGauger e Balança
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public interface MotionSensor {
    String initialize();
    String shutDown();
    boolean moved();
}
