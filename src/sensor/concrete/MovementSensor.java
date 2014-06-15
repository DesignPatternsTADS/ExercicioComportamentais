package sensor.concrete;

import java.util.ArrayList;
import java.util.List;
import sensor.Alarm;
import sensor.Sensor;
import sensor.SensorNotifier;

public class MovementSensor extends ConcreteSensor {

	private static final int THRESHOLD = 30;
	/*private boolean running;
	private boolean movementDetected;
	private SensorDriver driver = new SensorDriver();
        */
	public MovementSensor(String id) {
		super(id);
             //           this.sensorNotifier =  new SensorNotifier();
               // this.alarmes = new ArrayList<Alarm>();
	}
        
         /*
         public MovementSensor(String id, SensorNotifier sn) {
		super(id);
                 this.sensorNotifier = sn;
                this.alarmes = new ArrayList<Alarm>();
	}
 
	
        
	@Override
	public boolean presence() {
		return this.movementDetected;
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
			this.movementDetected = measure > MovementSensor.THRESHOLD;
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
        return measure > MovementSensor.THRESHOLD;
    }
}
