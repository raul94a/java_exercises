import java.util.ArrayList;

public class CambiarCadenasArray {
    public static void main(String[] args) {

        String str1 = "Mi perro Iker ladra mucho";
        String str2 = "Iker Casillas robó mi perro que mucho ladraba";

        // split separa una cadena de texto por un patrón, en este caso un espacio
        // esto siginifica que obtendremos un array con cada palabra de str2
        String[] words = str2.split(" ");

        // es un bucle rápido que se utiliza con las colecciones en Java y en otros lenguajes.
        // No existe aquí una variable de control del bucle (la i que normalmente se usa)
        // en cada iteración del bucle se devuelve un elemento del array, en orden de índice (0 .. n)
        // ejemplo para words, la primera iteración devuelve Iker, la segunda Casillas y  la última devolverá ladraba
        for (String word: words) {
            if(str1.contains(word)){
                str1 = str1.replace(word,word.toUpperCase());
            }
        }

        System.out.println("STR1 modificada:");
        System.out.println(str1);

    }
}
