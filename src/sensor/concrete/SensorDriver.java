package sensor.concrete;

public class SensorDriver {
	public void initialize() {
		// starting spinning the wheels
	}
	
	public void shutdown() {
		// cleaning up stuff		
	}
	
	public void sendRequest() {
		try {
			Thread.sleep(Double.valueOf(Math.random() * 100).intValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int readReply() {
		return Double.valueOf(Math.random() * 100).intValue(); 
	}

}
