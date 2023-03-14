import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner lector = new Scanner(System.in);
        System.out.println("Ingrese un número:");
        n = lector.nextInt();
        System.out.println("Factorial es: "+Factorial(n));
    }
    public static int Factorial(int n){
        if(n==0){
            return 1;
        }else{
            return n*Factorial(n-1);
        }
    }
}