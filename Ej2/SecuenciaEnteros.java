class SecuenciaEnteros{
    //Atrbituos de instancia
    private int[] sec;

    //Constructor
    public SecuenciaEnteros(int cant){
        sec = new int[cant];
    }

    //Comandos
    public void establecerValor(int pos, int val){
        sec[pos] = val;
    }
    public void reemplazar(int n1,int n2){
     for (int i = 0; i < sec.length; i++){
        if(sec[i] == n1){
            sec[i] = n2;
        }
     }
    }
    public void reemplazar(int n){
    int aparicion = 0;
    for (int i = 0; i < sec.length; i++) {
    if(sec[i] == n && aparicion < 1 || sec[i] == n && i == sec.length-1){
            aparicion++;
            sec[i] = 0;
            }
        }
    }
    public boolean intercambiar(int p1,int p2){
        if(0 < p1 && 0 < p2 && p1 < sec.length && p2 < sec.length){
            sec[p1] = sec[p2];
            return true;
        }else return false;
    }
    public void copy(SecuenciaEnteros a){
        if(a != null && a.cantElementos() == this.cantElementos()){
        for (int i = 0; i < sec.length; i++) {
            this.establecerValor(i, a.obtenerEntero(i));
        }}
    }

    //Consultas
    public int obtenerEntero(int p){
        return sec[p];
    }
    public int cantElementos(){
        return sec.length;
    }
    public int total(){
        int retorno = 0;
        for (int i = 0; i < sec.length; i++) {
            retorno = retorno + this.obtenerEntero(i);
        }
        return retorno;
    }
    public boolean estaNum(int n){
        boolean retorno = false;
        for (int i = 0; i < sec.length && !retorno; i++) {
            if(sec[i] == n){
                retorno = true;
            }
        }
        return retorno;
    }
    public int cantidadMayores(int n){
        int cantidad = 0;
        for (int i = 0; i < sec.length; i++) {
            if(sec[i] > n) cantidad++;
        }
        return cantidad;
    }
    public boolean mitadMayores(int n){
        int cant = 0;
        for (int i = 0; i < sec.length && cant < sec.length/2; i++) {
            if(sec[i] == n){
                cant++;
            }
        }
        if(cant == sec.length)return true;
        else return false;
    }
    public boolean equals(SecuenciaEnteros a){
        boolean retorno = true;
        for (int i = 0; i < sec.length && retorno; i++) {
            if(sec[i] != a.obtenerEntero(i))retorno = false;
        }
        return retorno;
    }
    public SecuenciaEnteros clone(){
        SecuenciaEnteros nuevaSecuencia = new SecuenciaEnteros(this.cantElementos());
        for (int i = 0; i < sec.length; i++) {
            establecerValor(i, sec[i]);
        }
        return nuevaSecuencia;
    }

}