
import java.util.ArrayList;
import java.util.List;
import monitor.Monitor;
import sensor.Alarm;
import sensor.Sensor;
import sensor.SensorGroup;
import sensor.SensorIterable;
import sensor.SensorNotifier;
import sensor.SensorObserver;
import sensor.concrete.ColorCamera;
import sensor.concrete.ConcreteSensor;
import sensor.concrete.MovementSensor;
import sensor.concrete.TemperatureSensor;
import sensor.concrete.ThermalCamera;

public class Main {

    public static void main(String[] args) {

        SensorGroup building = new SensorGroup("Building");

        building.addSensor(new TemperatureSensor("LocalTemp1"));
        building.addSensor(new ThermalCamera("RemThermCam1"));
        building.addSensor(new ThermalCamera("LocalThermCam1"));
        building.addSensor(new TemperatureSensor("RemTemp1"));
        building.addSensor(new ColorCamera("LocalColCam1"));

     //   SensorNotifier sn = new SensorNotifier();

        List<Alarm> alarms = new ArrayList<Alarm>();

        alarms.add(new Alarm("alarm1"));
        alarms.add(new Alarm("alarm2"));
        alarms.add(new Alarm("alarm3"));
        alarms.add(new Alarm("alarm4"));
        alarms.add(new Alarm("alarm5"));

        ConcreteSensor ts = new TemperatureSensor("Room1LocalTemp");
        for (Alarm alarm : alarms) {

            ts.addObserverAbstract(alarm);

        }

 

        SensorGroup room1 = new SensorGroup("Room1");
       // room1.addSensor(new TemperatureSensor("Room1LocalTemp",sn));
        room1.addSensor(ts);
       //SensorNotifier sn1 = new SensorNotifier();

       List<Alarm> alarms1 = new ArrayList<Alarm>();

        alarms1.add(new Alarm("alarm6"));
        alarms1.add(new Alarm("alarm7"));
        alarms1.add(new Alarm("alarm8"));
        alarms1.add(new Alarm("alarm8"));
        alarms1.add(new Alarm("alarm10"));
                ConcreteSensor cc = new ColorCamera("Room1SecureColorCamera");

        for (Alarm alarm : alarms1) {

            cc.addObserverAbstract(alarm);

        }

        

        //room1.addSensor(new ColorCamera("Room1SecureColorCamera",sn1));
        room1.addSensor(cc);
    

       // SensorNotifier sn2 = new SensorNotifier();

        List<Alarm>alarms2 = new ArrayList<Alarm>();

        alarms2.add(new Alarm("alarm11"));
        alarms2.add(new Alarm("alarm12"));
        alarms2.add(new Alarm("alarm13"));
        alarms2.add(new Alarm("alarm14"));
        alarms2.add(new Alarm("alarm15"));
        
        ConcreteSensor ms = new MovementSensor("Movement");
        for (Alarm alarm : alarms2) {

           // sn2.addObserver(alarm);
            ms.addObserverAbstract(alarm);

        }
   
        
        ConcreteSensor ms1 = new MovementSensor("Movement1");
        ConcreteSensor ms2 = new MovementSensor("Movement2");
        ConcreteSensor ms3 = new MovementSensor("Movement3");
        room1.addSensor(ms);
        room1.addSensor(ms1);
        room1.addSensor(ms2);
        room1.addSensor(ms3);
     
       // building.addSensor(room1);
        
        
        SensorIterable sensorIterable  =  new SensorIterable(room1);
       // SensorIterable sensorIterable  =  new SensorIterable(building);
        sensorIterable.countSensorsType();
        sensorIterable.enabledOrDisabledTypeSensors(false, SensorIterable.MOVEMENTSENSOR  );
        

        Monitor monitor = new Monitor();

       //monitor.addSensor(building);
       //monitor.addSensor(room1);

        //monitor.run();

    }

}
