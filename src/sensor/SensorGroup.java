package sensor;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SensorGroup implements Sensor {

    private String groupId;
    private List<Sensor> sensors = new ArrayList<Sensor>();

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

    @Override
    public void addAlarmsAssociated(Alarm alarme) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alarm> getAlarmes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String notifyPresenceAlarm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addObserver(SensorObserver sensor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SensorObserver> getSensorsObservers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
