import java.util.Scanner;
public class CifrarClaves {
    public static void main(String[] args) {
        boolean finishProgram = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("1. Cifrar.\n");
            System.out.print("2. Descifrar.\n");
            System.out.print("3. Salir.\n");
            System.out.print("Elige una opción: ");
            String chosenOption = sc.nextLine();
            switch (chosenOption) {
                case "1":
                    System.out.print("Introduce la clave que ha de ser cifrada: ");
                    String clave = sc.nextLine();
                    int longitudClave = 0;
                    try {
                        int copyClaveNr = Integer.parseInt(clave);
                        while (copyClaveNr > 0) {
                            longitudClave++;
                            copyClaveNr /= 10;
                        }
                        if (longitudClave < 4 || longitudClave > 8) {
                            break;
                        }
                        String claveCifrada = "";
                        int ultimoDigito = -1;
                        boolean empiezaConCero = false;
                        for (int i = 0; i < longitudClave; i++) {
                            char ch = clave.charAt(i);
                            int valor = Integer.parseInt(String.valueOf(ch));
                            if (valor == 0 && i == 0) {
                                empiezaConCero = true;
                                break;
                            }
                            if (i == longitudClave - 1) {
                                ultimoDigito = valor;
                            } else {
                                claveCifrada += String.valueOf(valor);
                            }
                        }
                        if (empiezaConCero) {
                            longitudClave++;
                            for (int i = 0; i < longitudClave; i++) {
                                char ch = clave.charAt(i);
                                int valor = Integer.parseInt(String.valueOf(ch));
                                if (i == longitudClave - 1) {
                                    ultimoDigito = valor;
                                } else {
                                    claveCifrada += String.valueOf(valor);

                                }
                            }
                        }
                        claveCifrada = ultimoDigito + claveCifrada;
                        System.out.println("La contraseña cifrada es " + claveCifrada);
                    } catch (Exception ex) {
                        System.out.println("Error! La clave no puede contener números.");
                        break;
                    }
                    break;
                case "2":
                    System.out.print("Introduce la clave que ha de ser descifrada: ");
                    clave = sc.nextLine();
                    longitudClave = 0;
                    try {
                        int copyClaveNr = Integer.parseInt(clave);
                        while (copyClaveNr > 0) {
                            longitudClave++;
                            copyClaveNr /= 10;
                        }
                        if (longitudClave < 4 || longitudClave > 8) {
                            break;
                        }
                        String claveCifrada = "";
                        int primerDigito = -1;
                        boolean empiezaConCero = false;
                        for (int i = 0; i < longitudClave; i++) {
                            char ch = clave.charAt(i);
                            int valor = Integer.parseInt(String.valueOf(ch));
                            if (valor == 0 && i == 0) {
                                empiezaConCero = true;
                                break;
                            }
                            if (i == 0) {
                                primerDigito = valor;
                            } else {
                                claveCifrada += String.valueOf(valor);
                            }
                        }
                        if (empiezaConCero) {
                            longitudClave++;
                            for (int i = 0; i < longitudClave; i++) {
                                char ch = clave.charAt(i);
                                int valor = Integer.parseInt(String.valueOf(ch));
                                if (i == 0) {
                                    primerDigito = valor;
                                } else {
                                    claveCifrada += String.valueOf(valor);
                                }
                            }
                        }
                        claveCifrada += primerDigito;
                        System.out.println("La contraseña descifrada es " + claveCifrada);
                    } catch (Exception ex) {
                        System.out.println("Error! La clave no puede contener números.");
                        break;
                    }
                    break;
                case "3":
                    finishProgram = true;
                    break;
            }
        } while (!finishProgram);
    }
}
