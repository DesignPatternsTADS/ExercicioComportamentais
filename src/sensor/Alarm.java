/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

/**
 *
 * @author jcrbsa
 */
public class Alarm implements SensorObserver {

    private boolean status = false;
    private String nome;

    public Alarm(String nome) {
        this.nome = nome;
    }

    public boolean isStatus() {
        return status;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String ring() {
        this.status = true;
        String equal = "===========================";
        String hifen = "------------------------";
        
        String  str = "";
        

        str += hifen + "\n" + "Name Alarm: " + this.nome +"\n" +"Active: " + this.status + "\n" + hifen  ;
       return str ;


    }

}
