package Ej4;

public class Sensor {
    /* Atributos de Clase */
    private static final float max = 0.01f;

    /* Atributos de Instancia */
    private float p1,p2;

    /* Constructor */
    public Sensor(float p1, float p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    /* Comandos */
    public void establecerP1(float p){
        p1 = p;
    }
    public void establecerP2(float p){
        p2 = p;
    }
    public void copy(Sensor s){
        this.p1 = s.obtenerP1();
        this.p2 = s.obtenerP2();
    }

    /* Consultas */
    public float obtenerP1(){
        return this.p1;
    }
    public float obtenerP2(){
        return this.p2;
    }
    public boolean riesgo(){
        if(p2 > p1)return true;
        else return false;
    }
    public boolean emergencia(){
        if(p1 < max)return true;
        else return false;
    }
    public boolean equals(Sensor s){
        if(s != null && this.p1 == s.obtenerP1() & this.p2 == s.obtenerP2())return true;
        else return false;
    }
    public Sensor clone(){
        return new Sensor(this.p1, this.p2);
    }
}