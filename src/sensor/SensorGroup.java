package sensor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class SensorGroup implements Sensor {

    private String groupId;
    private List<Sensor> sensors = new ArrayList<Sensor>();

    public String getGroupId() {
        return groupId;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public SensorGroup(String groupId) {
        this.groupId = groupId;

    }

    @Override
    public boolean presence() {
        boolean presense = false;

        for (Sensor sensor : this.sensors) {
            presense = presense || sensor.presence();
        }

        return presense;
    }

    @Override
    public String report() {

        String str = "";

        str += "Sensor Group: " + this.groupId + "\n";
        str += "Group Date: " + Calendar.getInstance().getTime() + "\n";
        str += "Group Presence: " + this.presence() + "\n";

        for (Sensor sensor : this.sensors) {
            str += sensor.report();

        }

        return str;
    }

    public void addSensor(Sensor sensor) {

        this.sensors.add(sensor);
    }

    @Override
    public void start() {
        for (Sensor sensor : this.sensors) {
            sensor.start();
        }
    }

    @Override
    public void stop() {
        for (Sensor sensor : this.sensors) {
            sensor.stop();
        }
    }

    /*
protected List<SensorObserver> sensores = new ArrayList<SensorObserver>();
     @Override
    public String notifyPresenceAlarm() {
          String equal = "===========================";
    String hifen = "------------------------";
        String str = "";

        str += "\n" + equal + "\n ALARMS ASSOCIATED TO " + this.getGroupId() + "\n" + equal + "\n";

        for (Alarm alarm : this.getAlarmes()) {

            str += hifen + "\n" + "Name Alarm:" + alarm.getNome() + "\n" + hifen;

        }

        Iterator iterator = sensores.iterator();
        str += "\n" + equal + "\n" + "NOTIFICATION ALERT TO " + this.groupId + "\n" + equal + "\n";
        while (iterator.hasNext()) {
            Alarm so = (Alarm) iterator.next();

            str += so.ring();

        }

        str += "\n" + equal + "\n";

// while
        return str;
    }

    @Override
    public void addObserver(SensorObserver sensor) {
        sensores.add(sensor);
        //this.addAlarmsAssociated((Alarm) sensor);
    }
    
      @Override
    public void removeObserver(SensorObserver observer) {
        sensores.remove(observer);
    }

    @Override
    public List<SensorObserver> getSensorsObservers() {
        return sensores;
    }*/

}
