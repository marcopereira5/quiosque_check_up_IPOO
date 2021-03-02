package HelperClasses;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


/**
 *
 * Esta classe serve como auxilio ao programa e ao seu desenvolvimento. Com a sua criação tentamos facilitar o
 * desenvolvimento do projeto assim como simplificar codigo.
 * Esta classe permite-nos não só fazer validaçoes de datas como também criamos uma espécie de "countdown" que e
 * utilizado em algumas classes
 *
 *
 * @author  Marco Pereira(180221019) and Afonso Cunha(180221017)
 * @version version 1.0 (17/05/2019)
 * email afonso.cunha@estudantes.ests.ips.pt / marco.pereira@estudantes.ests.ips.pt
 */
public abstract class TimeAux {

    /**
     * Este metodo faz a validaçao de uma data através do seu formato
     * @param date Uma data em String
     * @param format o formato que a String deveria ter
     * @return um valor lógico(boolean) que representa o resulatdo da comparaçao
     */
    public static boolean isDateValid(String date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setLenient(false);
        return formatter.parse(date, new ParsePosition(0)) != null;
    }

    /**
     * Este metodo atua como um countdown
     * @param seconds os segundos para fazer a contagem decrescente
     */
    public static void systemSleep(long seconds){
        long i = seconds;
        long time;
        while (i > 0){
            time = i * i;
            System.out.println(i);
            i--;
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
