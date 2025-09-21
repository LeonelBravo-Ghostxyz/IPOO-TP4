package Ej3;

public class TesterEj3 {
    // Tester del ejercicio 3, donde se hara prueba de las clases Oracion y SecuenciaEnteros, usando todos sus metodos con casos significativos, dejando como comentario los resultados esperados
    public static void main(String[] args) {
        // Pruebas de la clase SecuenciaEnteros
        SecuenciaEnteros sec1 = new SecuenciaEnteros(5);
        sec1.establecerValor(0, 10);
        sec1.establecerValor(1, 20);
        sec1.establecerValor(2, 30);
        sec1.establecerValor(3, 20);
        sec1.establecerValor(4, 50);

        System.out.println("Secuencia Enteros:");
        for (int i = 0; i < sec1.cantElementos(); i++) {
            System.out.print(sec1.obtenerEntero(i) + " "); // Esperado: 10 20 30 20 50
        }
        System.out.println("\nTotal: " + sec1.total()); // Esperado: 130
        System.out.println("Esta el numero 20? " + sec1.estaNum(20)); // Esperado: true
        System.out.println("Esta el numero 40? " + sec1.estaNum(40)); // Esperado: false

        sec1.reemplazar(20, 99);
        System.out.println("Despues de reemplazar 20 por 99:");
        for (int i = 0; i < sec1.cantElementos(); i++) {
            System.out.print(sec1.obtenerEntero(i) + " "); // Esperado: 10 99 30 99 50
        }
        System.out.println();

        sec1.reemplazar(99);
        System.out.println("Despues de reemplazar la primera aparicion de 99 por 0:");
        for (int i = 0; i < sec1.cantElementos(); i++) {
            System.out.print(sec1.obtenerEntero(i) + " "); // Esperado: 10 0 30 99 50
        }
        System.out.println();

        boolean intercambio = sec1.intercambiar(0, 2);
        System.out.println("Intercambio entre posiciones 0 y 2 exitoso? " + intercambio); // Esperado: true
        for (int i = 0; i < sec1.cantElementos(); i++) {
            System.out.print(sec1.obtenerEntero(i) + " "); // Esperado: 30 0 10 99 50
        }
        System.out.println();

        // Pruebas de la clase Oracion
        Oracion oracion1 = new Oracion("  Hola   Mundo  Esto  Es   Java  ");
        System.out.println("\nOracion original:");
        for (int i = 0; i < oracion1.longitud(); i++) {
            System.out.print(oracion1.obtenerLetra(i)); // Esperado: "  Hola   Mundo  Esto  Es   Java  "
        }
        System.out.println();
        oracion1.reducirBlancos();
        System.out.println("Despues de reducir blancos:");
        for (int i = 0; i < oracion1.longitud(); i++) {
            System.out.print(oracion1.obtenerLetra(i)); // Esperado: " Hola Mundo Esto Es Java "
        }
        System.out.println();
        System.out.println("Longitud de la oracion: " + oracion1.longitud()); // Esperado: longitud del arreglo
        System.out.println("Contar palabras: " + oracion1.contarPalabras()); // Esperado: 5
        System.out.println("La letra en posicion 1 es letra? " + oracion1.esLetra(1)); // Esperado: true
        System.out.println("La letra en posicion 0 es letra? " + oracion1.esLetra(0)); // Esperado: false
        System.out.println("La letra en posicion 1 es el inicio de una palabra? " + oracion1.esPrimeraPalabra(1)); // Esperado: true
        System.out.println("La letra en posicion 5 es el inicio de una palabra? " + oracion1.esPrimeraPalabra(5)); // Esperado: false
        System.out.println("Longitud de la palabra mas larga: " + oracion1.masLarga()); // Esperado: 5 (Java)
        System.out.println("Hay al menos 3 vocales? " + oracion1.hayNVocales(3)); // Esperado: true
        System.out.println("Hay al menos 10 vocales? " + oracion1.hayNVocales(10)); // Esperado: false
        System.out.println("Hay dos vocales consecutivas? " + oracion1.dosVocalesConsecutivas()); // Esperado: true
    
        // Prueba de histograma
        SecuenciaEnteros hist = oracion1.histograma();
        System.out.println("Histograma de longitudes de palabras:");
        for (int i = 0; i < hist.cantElementos(); i++) {
            System.out.println("Palabras de longitud " + i + ": " + hist.obtenerEntero(i)); // Esperado: conteo de palabras por longitud
        }
    }
}
