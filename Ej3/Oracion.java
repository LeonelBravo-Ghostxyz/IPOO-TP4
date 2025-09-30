package Ej3;

public class Oracion {
    // Atributo de instancia
    private char[] s;

    // Constructor
    public Oracion(String str){
    // Inicializa el array 's' con la longitud de la cadena 'str'
    s = new char[str.length()]; 
    
    // Ahora puedes copiar los caracteres a la nueva instancia del array
    for (int i = 0; i < str.length(); i++) {
        s[i] = str.charAt(i);
    }
}

    // Comandos
// Asume que 's' es un campo de la clase (e.g., private char[] s;)
public void reducirBlancos() {
    char blanco = ' ';
    int contBlancosEliminados = 0; // Usaremos esta variable para contar los espacios que quitamos.
    
    // Bucle exterior: Recorre el array buscando pares de espacios (s[i] y s[i+1]).
    for (int i = 0; i < s.length - 1; i++) {
        
        // Condición: Si encontramos DOS espacios consecutivos...
        if (s[i] == blanco && s[i+1] == blanco) {
            
            // Bucle interior (Desplazamiento): Elimina el segundo espacio (s[i+1])
            // "shifteando" todos los caracteres siguientes una posición a la izquierda.
            for (int j = 0; j < s.length - i - 1; j++) {
                s[i+j] = s[i+j+1];
            }
            // CORRECCIÓN CLAVE: Decrementamos 'i' para compensar el 'i++' del bucle exterior.
            // Esto obliga a RE-EVALUAR la posición actual en la siguiente iteración.
            // Si había TRES espacios, el array se redujo a DOS en esta posición, 
            // y necesitamos verificar si ese nuevo par debe ser reducido de nuevo.
            i--; 
            
            // Incrementamos el contador, ya que hemos eliminado un carácter efectivo.
            contBlancosEliminados++;
        }
    }
    // Una vez que se eliminan los espacios, la cola del array queda con caracteres duplicados.
    // Usamos el contador para sobrescribir el final del array con espacios vacíos o null (si procede).
    // Este bucle va desde el final 'útil' del array hasta el final real.
    // El final útil es s.length - contBlancosEliminados.
    for (int k = 0; k < contBlancosEliminados; k++) {
        // Ponemos el carácter 'blanco' en las posiciones liberadas al final.
        s[s.length - 1 - k] = blanco;
    }
    
    // NOTA FINAL: Si se tratara de un String o StringBuilder, la lógica final sería distinta, 
    // pero para un char[] se recomienda limpiar la cola como se muestra.
}
    public void establecerLetra(int pos,char l){
        s[pos] = l;
    }
    
    // Consultas
    public char obtenerLetra(int pos){
        return s[pos];
    }
    public boolean esLetra(int pos){
        boolean retorno = false;

        if(s[pos] >= 'A' && s[pos] <= 'Z')retorno = true;
        return retorno;
    }
    public boolean esPrimeraPalabra(int pos){
        boolean retorno = false;
        if(pos > 0 && pos < s.length && s[pos] >= 'A' && s[pos] <= 'Z' && s[pos-1] == ' ' && s[pos+1] >= 'A' && s[pos+1] <= 'Z'){
            retorno = true;
        }
        return retorno;
    }
    public int longitud(){
        return s.length;
    }
    public int contarPalabras(){
        int cont = 0;
        this.reducirBlancos();
        for (int i = 0; i < s.length-1; i++) {
            if(s[i+1] == ' ' && s[i] >= 'A' && s[i] <= 'Z')cont++;
        }
        return cont;
    }
    public int masLarga(){
        int cont=0,retorno=0;
        //? Retorno es la palabra mas larga

        for (int i = 0; i < s.length-1; i++) {
            if(s[i] >= 'A' && s[i] <= 'Z'){
                cont++;
            }
            if(cont > retorno && s[i+1] == ' '){ // El condicional busca que el contador sea mayor al retorno y que la palabra no tenga mas letras
                    retorno = cont;
                    cont=0;
                }else{
                    if(s[i+1] == ' ')cont=0; // Si encuentra un espacio resetea el contador
                }
        }
        return retorno;
    }
    public boolean hayNVocales(int n){
        boolean retorno = false;
        int cont=0;
        String vocales = "AEIOU";
        for (int i = 0; i < s.length && cont!=n; i++) {
            if(vocales.indexOf(s[i]) != -1){ // Comprobamos que el valor de s[i] sea una vocal para ello utilizamos el metodo indexOf, en caso de retornar -1 sabremos que no es una vocal
                cont++;
            }
        }
        if(cont == n)retorno = true;
        return retorno;
    }
    public boolean dosVocalesConsecutivas(){
        boolean retorno = false;
        String vocales = "AEIOU";

        for (int i = 0; i < s.length-1 && !retorno; i++) {
            if(vocales.indexOf(s[i]) != -1 && vocales.indexOf(s[i+1]) != -1)retorno = true;
        }
        return retorno;
    }
    public SecuenciaEnteros histograma(){
        SecuenciaEnteros histo = new SecuenciaEnteros(s.length);
        char letra = 'A';

        for (int i = 0; i < 27; i++) { // Iteración para abc
            int contador = 0;
            for (int j = 0; j < s.length; j++) { // Iteración para recorrer la secuencia+
                if((char)letra+i == s[j])contador++;
            }
            histo.establecerValor(i, contador);
        }


        return histo;
    }

}
