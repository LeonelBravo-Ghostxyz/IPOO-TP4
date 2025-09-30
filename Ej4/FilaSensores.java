package Ej4;

public class FilaSensores {
    // Atributos de instancia
    private Sensor[] fs;

    // Constructor
    public FilaSensores(int cant){
        fs = new Sensor[cant];
    }

    // Comandos
    public void establecerSensor(int p, Sensor s){
        if(posicionValida(p)){
            fs[p-1] = s;
        }
    }
    public void intercambiar(int p1,int p2){
        Sensor aux;
        if(posicionValida(p1) && posicionValida(p2)){
            aux= fs[p1-1];
            fs[p1-1]=fs[p2-1];
            fs[p2-1]=aux;
        }
    }
    public void copy(FilaSensores a){
        for (int i = 0; i < fs.length; i++) {
            fs[i].copy(a.obtenerSensor(i)); 
        }
    }


    // Consultas
    public Sensor obtenerSensor(int p){
        return fs[p];
    }
    public boolean posicionValida(int  p){
        if(p>0 && fs[p-1] != null)return true;
        else return false;
    }
    public int cantFilas(){
        return fs.length;
    }
    public int cantSensores(){
        int cant = 0;
        for (int i = 0; i < fs.length; i++) {
            if(fs[i] != null) cant++;
        }
        return cant;
    }
    public int cantRiesgo(){
        int cant = 0;
        for (int i = 0; i < fs.length; i++) {
            if(fs[i].riesgo())cant++;
        }
        return cant;
    }
    public boolean hayNRiesgo(int n){
        return cantRiesgo() == n;
    }
    public boolean dosConsecutivosEmergencia(){
        boolean retorno = false;
        for (int i = 0; i < fs.length-1 && !retorno; i++) { // For que recorré el array para encontrar 2 consecutivos, recorre el array hasta fs.length-1 para no salirse del tamaño, agregamos como condicion para que el recorrido no sea exhaustivo
            if(fs[i].emergencia() && fs[i+1].emergencia())retorno = true;
        }

        return retorno;
    }
    public boolean equals(FilaSensores a){
        return (this == a);
    }
    public FilaSensores clone(){
        FilaSensores a = new FilaSensores(this.cantFilas());
        for (int i = 0; i < a.cantFilas(); i++) { // Recorro el array para asignar los sensores a cada posición
            a.establecerSensor(i, fs[i].clone()); // Asigno un sensor, clonando el sensor el la posición i
        }
        return a;
    }
    public FilaSensores filaCompleta(){
        FilaSensores newfs = new FilaSensores(this.cantFilas());
        for (int i = 0; i < newfs.cantFilas(); i++) { // Recorre el array newfs
            for (int j = 0; j < fs.length; j++) { // Recorro el array fs buscando los valores distintos de null
                if(fs[j] != null){ // Si fs[j] es distinto de null se lo asigno a newfs en la posición i
                    newfs.establecerSensor(i, fs[j]);
                }
            }
        }
        return newfs;
    }
    

}
