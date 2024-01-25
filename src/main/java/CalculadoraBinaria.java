import java.util.Scanner;

public class CalculadoraBinaria {
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
        String lastResult = "";


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

                    System.out.print("1. Decimal -> Binario.\n");
                    System.out.print("2. Binario -> Decimal.\n");
                    System.out.print("3. Ver último resultado.\n");
                    System.out.print("4. Salir del programa.\n");
                    System.out.print("Elige una opción: ");
                    String chosenOption = sc.nextLine();


                    switch (chosenOption) {
                        case "1":
                            System.out.println("Has elegido pasar un número (entero) a binario.");
                            System.out.println("Introduce el número que quieras: ");
                            String str = sc.nextLine();
                            try {

                                long number = Long.parseLong(str);
                                long copyNumber = number;
                                String binaryString = "";
                                while (number > 1) {
                                    long  module = number % 2;

                                    number = number / 2;

                                    binaryString = module + binaryString;
                                    if (number <= 1) {
                                        binaryString = number + binaryString;
                                    }
                                }

                                System.out.println("El número " + copyNumber + " en binario es " + binaryString);
                                lastResult = binaryString;

                            } catch (Exception exception) {
                                System.out.println("Error: " + exception.getLocalizedMessage());
                            }

                            break;
                        case "2":
                            System.out.println("Has elegido pasar de binario a decimal:.");
                            System.out.println("Introduce el binario ");
                            str = sc.nextLine();
                            System.out.println("\nComenzando el cálculo....");

                            int length = str.length();
                            int j = 0;
                            long nr = 0;
                            for (int i = length - 1; i >= 0; i--) {
                                int parsedNr = Integer.parseInt(String.valueOf(str.charAt(i)));
                                long valorPosicion = (long) Math.pow(2, j) * parsedNr;
                                nr += valorPosicion;
                                j++;
                            }

                            System.out.println("El binario " + str + " es el número " + nr);
                            lastResult = "" + nr;

                            break;
                        case "3":
                            System.out.println(lastResult);
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
}
