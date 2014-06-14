/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author jcrbsa
 */
public abstract class SensorNotifier {

    protected List<SensorObserver> sensors = new ArrayList<SensorObserver>();

    protected void addObserver(SensorObserver sensor) {

        sensors.add(sensor);
    } // addObserver(Sensor)

   protected List<SensorObserver> getSensors() {
        return sensors;
    }

    protected void removeObserver(SensorObserver observer) {
        sensors.remove(observer);
    } // removeObserver(Sensor)

    String equal = "===========================";
    String hifen = "------------------------";


    protected String notifyPresenceAlarm(Sensor sensor) {

        String str = "";
        Iterator iterator = sensors.iterator();
       str = "\n" + equal  + "\n" + "NOTIFICATION ALERT" + "\n" +equal +"\n";  
        while (iterator.hasNext()) {
         Alarm so = (Alarm) iterator.next();

         str +=   so.ring();
                  sensor.addAlarmsAssociated(so);
                 
        }
                    str +=  "\n" + equal + "\n";
                    str +=  "ALARMS ASSOCIATED" ;
                    str +=  "\n"+ equal+"\n" ;
                    
                    
        for (Alarm alarm : sensor.getAlarmes()) {


            str += hifen + "\n";
            str += "Name Alarm:" + alarm.getNome() + "\n" + "Active:" + alarm.isStatus()+ "\n";
            str += hifen + "\n";

        }

        str += "\n" + equal;

// while
        return str;
    } // notify(int, int)

}
