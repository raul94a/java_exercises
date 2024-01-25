import java.util.Scanner;

public class MorseDecoder {
    // 1. Variables de decodificación morse predefinidas
    final static String a = ".-   ";
     final static  String p = ".--. ";
     final static String b = "-... ";
     final static String q = "--.- ";
     final static String c = "-.-. ";
     final static  String r = ".-.  ";
     final static String d = "-..  ";
     final static String s = "...  ";
     final static String e = ".    ";
     final static String t = "-    ";
     final static String f = "..-. ";
     final static   String u = "..-  ";
     final static    String g = "--.  ";
     final static  String v = "...- ";
     final static  String h = ".... ";
     final static  String w = ".--  ";
     final static  String i = "..   ";
     final static  String x = "-..- ";
     final static  String j = ".--- ";
     final static  String y = "-.-- ";
     final static String k = "-.-  ";
     final static String z = "--.. ";
     final static  String l = ".-.. ";
     final static String uno = ".----";
     final static String m = "--   ";
     final static String dos = "..---";
     final static String n = "-.   ";
     final static String tres = "...--";
     final static String o = "---  ";
     final static String cuatro = "....-";
     final static String cinco = ".....";
     final static String seis = "-....";
     final static String siete = "--...";
     final static String ocho = "---..";
     final static String nueve = "----.";
     final static String cero = "-----";
     final static String espacio = "     ";

    public static void main(String[] args) {

        // 0. Usuario y contraseña del ejercicio
        final String user = "admin";
        final String password = "123456";
        boolean loggedIn = false;
        boolean finishProgram = false;
        int tries = 0;
        Scanner sc = new Scanner(System.in);
        String scUser = "";
        String scPassword = "";


        // 2. Control del bucle principal
        do {
            if (tries > 3) {
                System.out.println("El programa ha terminado.");
                finishProgram = true;
            }
            System.out.print("Introduce el usuario: ");
            scUser = sc.nextLine();
            System.out.print("\nIntroduce la contraseña: ");
            scPassword = sc.nextLine();
            if (scUser.equals(user) && scPassword.equals(password)) {
                // Nos logueamos porque la contraseña coincide
                loggedIn = true;
                tries = 0;
            } else {
                tries++;
            }

            if (loggedIn) {
                // 3. Control del bucle del usuario logeado
                while (loggedIn) {

                    System.out.print("1. Codificar a código morse.\n");
                    System.out.print("2. Decodificar a lenguaje natural.\n");
                    System.out.print("3. Ver datos del usuario.\n");
                    System.out.print("4. Salir del programa.\n");
                    System.out.print("Elige una opción: ");
                    String chosenOption = sc.nextLine();
                    System.out.println("");

                    switch (chosenOption) {
                        case "1":
                            System.out.println("Has elegido CODIFICAR una cadena de texto.");
                            System.out.println("Introduce la cadena que quieras: ");
                            String str = sc.nextLine();
                            System.out.println("\nComenzando la decodificación....");
                            int length = str.length();
                            String codifiedStr = "";
                            for (int i = 0; i < length; i++) {
                                String letter = String.valueOf(str.charAt(i));
                                codifiedStr += codificador(letter);
                            }
                            System.out.println("¡LA CODIFICACIÓN HA TERMINADO! EL RESULTADO ES: ");
                            System.out.println(codifiedStr);

                            break;
                        case "2":
                            System.out.println("Has elegido DECODIFICAR una MORSE.");
                            System.out.println("Introduce el morse: ");
                             str = sc.nextLine();
                            System.out.println("\nComenzando la decodificación....");
                            length = str.length();
                            if(length % 5 != 0){
                                System.out.println("La cadena morse introducida no es válida.");
                                break;
                            }
                            codifiedStr = "";
                            String growingString = "";
                            for (int i = 0; i < length; i++) {
                               growingString += String.valueOf(str.charAt(i));
                               if(growingString.length() == 5){
                                   codifiedStr += decodificador(growingString);
                                   growingString = "";
                               }
                            }
                            System.out.println("¡LA DECODIFICACIÓN HA TERMINADO! EL RESULTADO ES: ");
                            System.out.println(codifiedStr);
                            break;
                        case "3":
                            break;
                        case "4":
                            loggedIn = false;
                            finishProgram = true;
                            break;
                        default:
                            System.out.println("Opción " + chosenOption + " es incorrecta, compadre.");
                    }

                }
            }


        } while (!finishProgram);


    }

    private static String codificador(String letter) {
        switch (letter.toUpperCase()) {
            case "A":
                return a;
            case "B":
                return b;
            case "C":
                return c;
            case "D":
                return d;
            case "E":
                return e;
            case "F":
                return f;
            case "G":
                return g;
            case "H":
                return h;
            case "I":
                return i;
            case "J":
                return j;
            case "K":
                return k;
            case "L":
                return l;
            case "M":
                return m;
            case "N":
                return n;
            case "O":
                return o;
            case "P":
                return p;
            case "Q":
                return q;
            case "R":
                return r;
            case "S":
                return s;
            case "T":
                return t;
            case "U":
                return u;
            case "V":
                return v;
            case "W":
                return w;
            case "X":
                return x;
            case "Y":
                return y;
            case "Z":
                return z;
            case "1":
                return uno;
            case "2":
                return dos;
            case "3":
                return tres;
            case "4":
                return cuatro;
            case "5":
                return cinco;
            case "6":
                return seis;
            case "7":
                return siete;
            case "8":
                return ocho;
            case "9":
                return nueve;
            case "0":
                return cero;
            case " ":
                return espacio;
            default:
                return "";

        }
    }

    private static String decodificador(String morse) {
        return switch (morse) {
            case espacio -> " ";
            case a -> "a";
            case b -> "b";
            case c -> "c";
            case d -> "d";
            case e -> "e";
            case f -> "f";
            case g -> "g";
            case h -> "h";
            case i -> "i";
            case j -> "j";
            case k -> "k";
            case l -> "l";
            case m -> "m";
            case n -> "n";
            case o -> "o";
            case p -> "p";
            case q -> "q";
            case r -> "r";
            case s -> "s";
            case t -> "t";
            case u -> "u";
            case v -> "v";
            case w -> "w";
            case x -> "x";
            case y -> "y";
            case z -> "z";
            case uno -> "1";
            case dos -> "2";
            case tres -> "3";
            case cuatro -> "4";
            case cinco -> "5";
            case seis -> "6";
            case siete -> "7";
            case ocho -> "8";
            case nueve -> "9";
            case cero -> "0";
            default -> "*****";
        };
    }
}
