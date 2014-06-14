package sensor.concrete;

import java.util.ArrayList;
import java.util.List;
import sensor.Alarm;
import sensor.Sensor;
import sensor.SensorNotifier;

public class TemperatureSensor extends ConcreteSensor {

	private static int PERSON_TEMP = 37;
	private boolean running;
	private boolean personTempDetected;
	private SensorDriver driver = new SensorDriver();
	
	public TemperatureSensor(String id) {
		super(id);
//s               this.sensorNotifier =  new SensorNotifier();
                this.alarmes = new ArrayList<Alarm>();
	}
        public TemperatureSensor(String id, SensorNotifier sn) {
		super(id);
                 this.sensorNotifier = sn;
                this.alarmes = new ArrayList<Alarm>();
	}
     
      

	@Override
	public boolean presence() {
		return this.personTempDetected;
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
			this.personTempDetected = (measure == PERSON_TEMP); 
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
