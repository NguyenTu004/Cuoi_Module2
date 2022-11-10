import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ISystem  system = new ISystem();
        system.SystemStudent(scanner);
    }
}
