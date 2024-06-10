import java.util.Scanner;

public class Main { //1
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> builtins = builtins();
        
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
            } else if(str.length > 1) {
                parameter = str[1];
            }

            switch(command) {
                case builtins.get(0):
                    if(parameter.equals("0")) {
                        System.exit(0);
                    } else {
                        System.out.println(input + ": command not found");
                    }
                    break;
                case builtins.get(1):
                    System.out.println(parameter);
                    break;
                case builtins.get(2):
                    switch(parameter) {
                        case builtins.get(0) || builtins.get(1) || builtins.get(2):
                            System.out.println(parameter + " is a shell builtin");
                            break;
                        default:
                            System.out.println(parameter + ": not found");
                    }
                    break;
                default:
                System.out.println(input + ": command not found");
            }
        }
    }

    private static List<String> builtins() {
        List<String> builtins = new ArrayList<>();
        builtins.add("exit");
        builtins.add("echo");
        builtins.add("type");
        return builtins;
    }
}
