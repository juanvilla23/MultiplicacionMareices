import javax.swing.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Matriz {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        int matriz[][] = {{1, 2, 3,4}, {4, 5, 6,7}, {7, 8, 9,9},{2,3}};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println("");
        }

        int matriz2[][], Nfilas, Ncolumna;
        Nfilas = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de filas"));
        Ncolumna = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de columnas"));
        matriz2 = new int[Nfilas][Ncolumna];
        for (int i = 0; i < Nfilas; i++) {
            for (int j = 0; j < Ncolumna; j++) {
                System.out.println("Matriz [" + i + "][" + j + "]: ");
                matriz2[i][j] = e.nextInt();
            }

        }
        for (int i = 0; i < Nfilas; i++) {
            for (int j = 0; j < Ncolumna; j++) {
                System.out.print(matriz2[i][j]);
            }
            System.out.println("");

        }
    }
}
