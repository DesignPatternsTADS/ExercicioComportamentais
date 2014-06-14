package sensor.concrete;

import java.util.ArrayList;
import java.util.List;
import sensor.Alarm;
import sensor.Sensor;
import sensor.SensorNotifier;

public class ColorCamera extends ConcreteSensor {

    private boolean running;
    private boolean humanFaceDetected;
    private SensorDriver driver = new SensorDriver();

    public ColorCamera(String id) {
        super(id);
        //this.sensorNotifier = new SensorNotifier();
        this.alarmes = new ArrayList<Alarm>();
    }
    public ColorCamera(String id, SensorNotifier sn) {
		super(id);
                 this.sensorNotifier = sn;
                this.alarmes = new ArrayList<Alarm>();
	}
    

    @Override
    public boolean presence() {
        return this.humanFaceDetected;
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
            this.humanFaceDetected = (measure > 10 && measure < 40);
        }
        driver.shutdown();
    }

    @Override
    public void addAlarmsAssociated(Alarm alarme) {
        super.alarmes.add(alarme);
    }

    @Override
    public List<Alarm> getAlarmes() {
        return alarmes;
    }

    public void setEnabledOrDisabledSensor(boolean enabledOrDisable ){
        enabled = enabledOrDisable;
    }
    
    
    
}
