public class CambiarCadenas {
    public static void main(String[] args) {


        String str1 = "Mi perro Iker ladra mucho";
        String str2 = "Iker Casillas robó mi perro que mucho ladraba";


        // El ejercicio de cambiar palabras a mayúsculas se puede hacer de muchas formas
        // vamos a usar una estrategia sencilla de entender, sin usar arrays.
        // Consiste básicamente en:
        // 1. extraer palabras de la frase 2 (str2)
        // 2. Cuando tengamos una palabra, comprobamos si existe en cadena 1 (str1)
        // 3. En el caso de que exista, usamos el método replace() para sustituir la palabra
        //    de la cadena 1 (str1), por la misma palabra en mayúsculas.

        // la usaremos para construir las palabras del paso 1.
        String cadenaComprobadora = "";

        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            // ¿Cómo sabemos si tenemos una palabra? en el caso de que c sea un espacio en blanco
            // En este if vamos a concatenar el caractera cadenaComprobadora
            boolean contienePalabra = str1.contains(cadenaComprobadora);
            if(!Character.isWhitespace(c)){
                cadenaComprobadora = cadenaComprobadora + c;

            }
            // En el caso de que c sea espacio en blanco y se contenga la palabra,
            // habrá que sustituir!
            else if(Character.isWhitespace(c) && contienePalabra){
                // los métodos de los String NO modifican la cadena original, esto quiere decir
                // que devuelven la cadena modificada

                str1 = str1.replace(cadenaComprobadora,cadenaComprobadora.toUpperCase());

                cadenaComprobadora = "";
            }
            // en el caso de tener espacio en blanco debemos de reiniciar cadena comprobadora
            // ojo, ¿Qué pasaría si cambiarmos el orden de los else if? PISTA: FALLO EN MATRIX
            else if(Character.isWhitespace(c)){
                System.out.println("palabra: " + cadenaComprobadora);
                cadenaComprobadora = "";
            }

            // OJO. Esta ultima comprobación es necesaria porque la última vuelta del bucle
            // no comprueba la cadena con esta forma de hacer las cosas. Es lo complicado del ejercicio
            if(i == str2.length() -1 && !Character.isWhitespace(c) && str1.contains(cadenaComprobadora)){
               str1 = str1.replace(cadenaComprobadora,cadenaComprobadora.toUpperCase());
            }

        }

        System.out.println("La cadena str1 ahora tiene el siguiente valor:");
        System.out.println(str1);

    }
}
