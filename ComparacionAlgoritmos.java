import java.util.ArrayList;
import java.util.Random;
public class ComparacionAlgoritmos {
    public static void main(String[] args) {
        MultiplicacionMatrices m = new MultiplicacionMatrices();
        Strasen s =new Strasen();
        int n;
        int Base=2;
        int aleatorio;
        int i = 8;
        int Nfilas = 0;
        int Ncolumnas=0;
        int[][]A=new int[Nfilas][Ncolumnas];
        int[][]B=new int[Nfilas][Ncolumnas];

        while (i <= 20) {
            Nfilas=(int)(Math.pow(Base,i));
            Ncolumnas=(int)(Math.pow(Base,i));
            for(int a=0;a<Nfilas;a++){
                for (int b=0;b<Ncolumnas;b++){
                    aleatorio=(int)(Math.random()*10+1);
                    A[a][b]=aleatorio;
                    aleatorio=(int)(Math.random()*10+1);
                    B[a][b]=(int)(Math.random()*10+1);
                }
            }
            long incio=System.currentTimeMillis(); /*Iniciamos a tomar el tiempo para el metodo normal*/
            int C[][]=MultiplicacionMatrices.multiply(A,B);
            long Final=System.currentTimeMillis(); /*Terminamos de tomar el tiempo*/
            long tiempo=Final-incio;
            long incio2=System.currentTimeMillis();/*Iniciamos a tomar el tiempo para el metodo de strasen*/
            int C2[][]=Strasen.strasen(A,B);
            long final2=System.currentTimeMillis();/*terminamos de tomar el tiempo para el metodo strassemn





        }
    }
}
