package sensor.concrete;

import java.util.ArrayList;
import java.util.List;
import sensor.Alarm;
import sensor.Sensor;
import sensor.SensorNotifier;

public class ThermalCamera extends ConcreteSensor {

	/*private boolean running;
	private boolean thermalPatternDetected;
	private SensorDriver driver = new SensorDriver();
        */
	public ThermalCamera(String id) {
		super(id);
              //   this.sensorNotifier = new  SensorNotifier();
                
	}
        /*
	public ThermalCamera(String id, SensorNotifier sn) {
		super(id);
                 this.sensorNotifier = sn;
                this.alarmes = new ArrayList<Alarm>();
	}
     
	@Override
	public boolean presence() {
		return  this.thermalPatternDetected;
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
			this.thermalPatternDetected = (measure >= 75); 
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
    }*/

    @Override
    boolean calculateMeasure(int measure) {
        return (measure >= 75);
    }
        
        
}
