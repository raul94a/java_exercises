public class CambiarCadenasFormaDos {
    public static void main(String[] args) {
        String str1 = "Mi perro Iker ladra mucho";
        String str2 = "Iker Casillas robó mi perro que mucho ladraba";


        String cadenaComprobadora = "";
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);

            // en esta segunda forma vamos a concatenar antes. Esto puede ser beneficioso
            if(!Character.isWhitespace(c)){
                cadenaComprobadora += c;
            }

            // Lo mismo. Si c es espacio en blanco, significa que hemos llegado al final de la palabra
            // y tenemos que reiniciarla... pero antes de hacerlo tenemos que comprobar que esta palabra esté
            // en str1. Si está, reiniciamos también
            // No se si lo he escrito antes... pero comprobamos que contenga la cadena
            // cuando obtenemos un espacio en blanco porque así pillamos la palabra completa.
            // aun así este algoritmo no es perfecto...
            boolean contienePalabra = str1.contains(cadenaComprobadora);
            if(Character.isWhitespace(c) && contienePalabra ){
                // en este caso debemos de reemplazar. Y después reinicar
                str1 = str1.replace(cadenaComprobadora,cadenaComprobadora.toUpperCase());
                cadenaComprobadora = "";
            }
            // ahora bien, si puede ser que no contenga palabra pero siga siendo espacio en blanco.
            // en ese caso hacemos lo de este else if (¿QUE PASARIA SI ESTE FUERA EL IF, EN VEZ DEL ELSE IF? PISTA: ERROR EN MATRIX)
            else if(Character.isWhitespace(c)){
                cadenaComprobadora = "";
            }
        }

        System.out.println("La cadena str1 ahora tiene el siguiente valor:");
        System.out.println(str1);
    }
}
