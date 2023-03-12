import java.util.*;

public class Main2 {
    static String[][] client = new String[100][2];
    static String[][] mecanic = new String[100][3];
    static String[][] vehicle = new String[100][3];
    static String[][] reparacions = new String[100][4];
    static Scanner str = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    public static int error(){
        int x = 0;
        try{
            x = Integer.parseInt(sc.next());
        }catch (NumberFormatException exception){
            System.out.println("Entrada incorrecta. Prueba de nuevo...");
        }
        return x;
    }
    public static String[][] throughList(String[][] x, String y){
        for (int row = 0; row < x.length; row++){
                if (x[row][0] == null){
                    x[row][0] = y;
                    break;
                }
                else if(x[row][1] == null){
                    x[row][1] = y;
                    break;
                }
                else if(x[row][2] == null){
                    x[row][2] = y;
                    break;
                }
        }
        return x;
    }
    public static String[][] DNIrelease(String[][] x, int min, int max, int len, String text1, String text2){
        boolean found = false;
        String letter = "";
        String aux = "";
        int num = 0;
        do{
            while(num < min || num > max){
                System.out.println(text1);
                num = error();
            }
            while(!letter.matches(".*[A-Z].*") || !(letter.length() == len)){
                System.out.println(text2);
                letter = str.next();
            }
            aux = num+letter;
            /*if(client[0][0] == null){
                aux = true;
            }else{
                for(int i = 0; (client[i+1][0] != null && !found) || i > client.length; i++){
                    if(client[i][0].equals(DNI)){
                        found = true;
                    }else{
                        found = false;
                        aux = true;
                    }
                }
            }*/
        }while(found);
        throughList(x, aux);
        return x;
    }
    public static String[][] clientRelease(){
        String name = "";
        DNIrelease(client, 9999999, 100000000, 1, "Dígitos DNI[8]: ", "Letra DNI[A-Z]: ");
        while(name.equals("")){
            System.out.println("Introduzca el nombre del cliente: ");
            name = sc.next();
        }
        throughList(client, name);
     return client;
    }
    public static String[][] carRelease(){
        String model = "";
        DNIrelease(vehicle, 999, 10000, 3, "Dígitos matricula[4]: ", "Letras Matricula[A-Z]: ");
        while(model.equals("")){
            System.out.println("Introduzca el modelo del vehículo: ");
            model = sc.next();
        }
        throughList(vehicle, model);
        DNIrelease(vehicle, 9999999, 100000000, 1, "Dígitos DNI[8]: ", "Letra DNI[A-Z]: ");
        return vehicle;
    }
    public static String[][] employeeRelease(){


        return mecanic;
    }
    public static int menu(){
        int choise = 0;
        while(choise < 1 || choise > 6){
            System.out.println("""
                Bienvenido!
                1. Donar d’alta nou client
                2. Donar d’alta nou mecànic
                3. Introduir nou vehicle
                4. Crear fitxa de nova reparació
                5. Modificar reparació. (Només en el cas de fer el repte 4)
                6. Sortir""");
            choise = error();
        }
        return choise;
    }

    public static void main(String[] args) {
        int choise = 0;
        while(choise != 6){
            choise = menu();
            switch (choise){
                case 1:
                    clientRelease();
                    System.out.println(Arrays.toString(client[0]));
                    System.out.println(Arrays.toString(client[1]));
                    break;
                case 2:

                    break;
                case 3:
                    carRelease();
                    System.out.println(Arrays.toString(vehicle[0]));
                    System.out.println(Arrays.toString(vehicle[1]));
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    menu();
                    break;
            }
        }
    }
}