package sensor.concrete;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import sensor.Alarm;

import sensor.Sensor;
import sensor.SensorNotifier;
import sensor.SensorObserver;

public abstract class ConcreteSensor implements Sensor, Runnable {

    protected String id = null;

    public String getId() {
        return id;
    }

    public ConcreteSensor(String id) {
        this.id = id;
        this.alarmes = new ArrayList<Alarm>();

    }

    //  protected SensorNotifier sensorNotifier;
    protected boolean statusAlarme;
    protected List<Alarm> alarmes;
    protected boolean enabled = true;

    public boolean isEnabled() {
        return enabled;
    }

    String equal = "===========================";
    String hifen = "------------------------";

    public String report() {
        String str = "";
        str += "Sensor Id: " + this.id + "\n";
        str += "Date: " + Calendar.getInstance().getTime() + "\n";
        boolean status = false;
        if (this.isEnabled()) {
            status = this.presence();

            status = true;
        }
        str += "Presence: " + status + "\n";
        if (status) {

//                    str +=   sensorNotifier.notifyPresenceAlarm(this);
            str += notifyPresenceAlarm();
            this.statusAlarme = true;

        }

        return str;
    }

    protected List<SensorObserver> sensors = new ArrayList<SensorObserver>();

    @Override
    public String notifyPresenceAlarm() {
        String str = "";

        str += "\n" + equal + "\n ALARMS ASSOCIATED TO " + this.id + "\n" + equal + "\n";

        for (Alarm alarm : this.getAlarmes()) {

            str += hifen + "\n" + "Name Alarm:" + alarm.getNome() + "\n" + hifen;

        }

        Iterator iterator = sensors.iterator();
        str += "\n" + equal + "\n" + "NOTIFICATION ALERT TO " + this.id + "\n" + equal + "\n";
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
        sensors.add(sensor);
        this.addAlarmsAssociated((Alarm) sensor);
    }

    @Override
    public List<SensorObserver> getSensorsObservers() {
        return sensors;
    }

    @Override
    public void removeObserver(SensorObserver observer) {
        sensors.remove(observer);
    }

    protected boolean running;
    protected boolean concretSensorDetected;
    protected SensorDriver driver = new SensorDriver();

    @Override
    public boolean presence() {
        return this.concretSensorDetected;
    }

    @Override
    public void start() {
        running = true;
        new Thread(this).start();
    }

    @Override
    public void stop() {
        this.running = false;
    }

    @Override
    public void run() {
        driver.initialize();
        while (running) {
            driver.sendRequest();
            int measure = driver.readReply();
            this.concretSensorDetected = calculateMeasure(measure);
        }
        driver.shutdown();
    }

    abstract boolean calculateMeasure(int measure);

    @Override
    public void addAlarmsAssociated(Alarm alarme) {
        this.alarmes.add(alarme);
    }

    @Override
    public List<Alarm> getAlarmes() {
        return alarmes;
    }

    public void setEnabledOrDisabledSensor(boolean enabledOrDisable) {
        enabled = enabledOrDisable;
    }

}
