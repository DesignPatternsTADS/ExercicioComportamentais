package monitor;

import java.util.ArrayList;
import java.util.List;

import sensor.Sensor;
import sensor.SensorNotifier;

public class Monitor {

	private List<Sensor> sensors = new ArrayList<Sensor>();

	public void addSensor(Sensor sensor) {
		this.sensors.add(sensor);		
	}

	public void run() {

		for (Sensor sensor : this.sensors) {
			sensor.start();
		}
		
             
                
		for (Sensor sensor : this.sensors) {
			System.out.print(sensor.report());
               
                    }
                       
		
                
               
		
                
                
                
               
               
		for (Sensor sensor : this.sensors) {
			sensor.stop();
		}
	}
}
