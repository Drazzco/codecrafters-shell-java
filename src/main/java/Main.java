import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] str = input.split(" ");
            String command = str[0];
            String parameter = "";

            if(str.length > 2) {
                for(int i = 1; i < str.length; i++) {
                    if(i < str.length-1) {
                        parameter += str[i] + " ";
                    } else {
                        parameter += str[i];
                    }
                }
            } else {
                parameter = str[1];
            }

            switch(command) {
                case "exit":
                    if(parameter.equals("0")) {
                        System.exit(0);
                    } else {
                        System.out.println(input + ": command not found");
                    }
                    break;
                case "echo":
                    System.out.println(parameter);
                    break;
                default:
                System.out.println(input + ": command not found");
            }
        }
    }
}
