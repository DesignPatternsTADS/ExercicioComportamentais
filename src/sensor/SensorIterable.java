/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import java.util.Iterator;
import java.util.List;
import sensor.concrete.ColorCamera;
import sensor.concrete.ConcreteSensor;
import sensor.concrete.MovementSensor;
import sensor.concrete.TemperatureSensor;
import sensor.concrete.ThermalCamera;

/**
 *
 * @author bruno.andrade
 */
public class SensorIterable implements Iterable<Sensor> {

    private List<Sensor> sensores;
    private int length;
    private int countColorCamera = 0;
    private int countMovementSensor = 0;
    private int countTemperatureSensor = 0;
    private int countThermalCamara = 0;

    public SensorIterable(SensorGroup sensorGroup) {
        this.sensores = sensorGroup.getSensors();
        this.length = this.sensores.size();
    }

    String equal = "===========================";
    String hifen = "------------------------";

    public void countSensorsType() {
        String str = "";
        str += "\n" + equal + "\n" + "COUNT TYPE SENSOR" + "\n" + equal ;

        Iterator iterator = iterator();

        while (iterator.hasNext()) {
            Sensor temp = (Sensor) iterator.next();

            if (temp instanceof ColorCamera) {
                countColorCamera++;
            } else if (temp instanceof MovementSensor) {
                countMovementSensor++;

            } else if (temp instanceof TemperatureSensor) {
                countTemperatureSensor++;
            } else if (temp instanceof ThermalCamera) {
                countThermalCamara++;
            }

        }
        str += "\n" + hifen + "\n" + "countColorCamera: " + countColorCamera;
        str += "\n" + hifen + "\n" + "countMovementSensor: " + countMovementSensor;
        str += "\n" + hifen + "\n" + "countTemperatureSensor: " + countTemperatureSensor;
        str += "\n" + hifen + "\n" + "countThermalCamara: " + countThermalCamara + "\n" + hifen + "\n";
        str += equal + "\n";

        System.out.println(str);

        countColorCamera = 0;
        countMovementSensor = 0;
        countTemperatureSensor = 0;
        countThermalCamara = 0;

    }

     public static final Class<ColorCamera> COLORCAMERA = ColorCamera.class;
    public static final Class<MovementSensor> MOVEMENTSENSOR = MovementSensor.class;
    public static final Class<TemperatureSensor> TEMPERATURESENSOR = TemperatureSensor.class;
    public static final Class<ThermalCamera> THERMALCAMERA = ThermalCamera.class;
    
    public void enabledOrDisabledTypeSensors(boolean enabledOrDisabled, Class<? extends ConcreteSensor> sensor) {

       Iterator iterator = iterator();
        String str = "";
        str += "\n" + equal + "\n" + "ENABLED/DISAVLED TYPE SENSORS" + "\n" + equal + "\n";
        while (iterator.hasNext()) {
            Sensor temp = (Sensor) iterator.next();
            ConcreteSensor cs = (ConcreteSensor) temp;
            
            
            if ((cs.getClass() ==(ColorCamera.class)) && (sensor.equals( COLORCAMERA))) {
                ((ColorCamera) temp).setEnabledOrDisabledSensor(enabledOrDisabled);
                
            } else if ((cs.getClass().equals( MovementSensor.class)) && (sensor.equals(  MOVEMENTSENSOR))) {
                ((MovementSensor) temp).setEnabledOrDisabledSensor(enabledOrDisabled);

            } else  if ((cs.getClass().equals(TemperatureSensor.class)) && (sensor.equals( TEMPERATURESENSOR))){
                ((TemperatureSensor) temp).setEnabledOrDisabledSensor(enabledOrDisabled);
            } else  if ((cs.getClass().equals( ThermalCamera.class)) && (sensor.equals( THERMALCAMERA))) {
                ((ThermalCamera) temp).setEnabledOrDisabledSensor(enabledOrDisabled);
            }
           str += hifen + "\n" +  "Sensor:" + cs.getId() + "\n" + "Enabled/Disabled:" + cs.isEnabled() + "\n"  + hifen + "\n"; ;
        }
            str+=  equal+ "\n";
            System.out.println(str);
    }

    public SensorIterator iterator() {
        return this.new SensorIterator();
    }

    private class SensorIterator implements Iterator<Sensor> {

        int i = 0;

        @Override
        public boolean hasNext() {
            return (this.i) < SensorIterable.this.length;
        }

        @Override
        public Sensor next() {
            return SensorIterable.this.sensores.get(i++);
        }

        @Override
        public void remove() {
            SensorIterable.this.sensores.remove(i);
        }

    }

}
