package sensor;

import java.util.List;
import sensor.SensorNotifier;

public interface Sensor {
	public  void start();
	public  void stop();
	public  boolean presence();
	public String report();
       // public void addAlarmsAssociated(Alarm alarme);
       // public List<Alarm> getAlarmes();


      
}
