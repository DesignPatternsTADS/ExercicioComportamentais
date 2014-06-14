/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sensor;

import java.util.List;

/**
 *
 * @author bruno.andrade
 */
public interface InterfaceSensorNotifier {
        public  String notifyPresenceAlarmAbstract();
    public  void addObserverAbstract(SensorObserver sensor);
   public  List<SensorObserver> getSensorsAbstract();
}
