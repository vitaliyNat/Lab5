import java.util.Arrays;
 import java.util.List;
import java.util.Scanner;

public class Main {
    private static int [][] MatrixA;
    private static int [][] MatrixB;
    private static int [][] MatrixR;
    static int [] dimA;
    static int [] dimB;
      public static class Model{




     public static int[][] MultiplyMatrix(int[][] MatrixA, int[][] MatrixB) {

         int[][] result = new int[MatrixA.length][MatrixB[0].length];

         for (int i = 0; i < MatrixA.length; i++) {
             for (int j = 0; j < MatrixB[0].length; j++) {
                 for (int k = 0; k < MatrixA[0].length; k++) {
                     result[i][j] += MatrixA[i][k] * MatrixB[k][j];
                 }
             }
         }

         return result;
     }
     public static int[][] transpose(int [][] Matrix){
         int[][] tempMatrix =  new int[Matrix[0].length][Matrix.length];

         for (int i = 0; i < Matrix.length; i++){
             for(int j = 0; j< Matrix[0].length; j++){
                 tempMatrix[j][i] = Matrix[i][j];
             }
         }

         return tempMatrix;
     }
      }

      public class View{
     public static void showMatrix(int [][] Matrix){
         for (int[] matrix : Matrix) {
             for (int j = 0; j < Matrix[0].length; j++) {
                 System.out.print(matrix[j] + " ");
             }
             System.out.println(" ");
         }

         }
          public static void showMenu(){
              System.out.println("( 1 ) Wprowadz macierzy wejsciowe");
              System.out.println("( 2 ) Operacje arytmetyczne");
              System.out.println("( 3 ) Wyswietl macierzy");
              System.out.println("( 4 ) End program");
              Scanner choose = new Scanner(System.in);
              int ch = choose.nextInt();
              if(ch == 1){
                  System.out.println("Macierz A:");
                   dimA = Controller.dimension();
                  MatrixA = Controller.getMatrix(dimA[0],dimA[1] );
                  System.out.println("Macierz B: ");
                   dimB = Controller.dimension();
                   MatrixB = Controller.getMatrix(dimB[0],dimB[1] );
                   showMenu();
              } else if (ch ==  2) {
                try {

                  System.out.println("( 1 ) Transponuj macierzy wejsciowe");
                  System.out.println("( 2 ) Mnozenie Macierzy");
                  System.out.println("( 3 ) Transponuj Macierz Wynikowa");
                  Scanner choose1 = new Scanner(System.in);
                  int ch1 = choose1.nextInt();
                  if(ch1 == 1 ){
                      MatrixA = Model.transpose(MatrixA);
                      MatrixB = Model.transpose(MatrixB);
                  } else if (ch1 == 2) {
                      if(dimA[1] == dimB[0]) {
                          MatrixR = Model.MultiplyMatrix(MatrixA, MatrixB);
                      }else{
                          System.err.println("Nieprawidlowe rozmiary macierzy");
                      }
                  }else if(ch1 == 3){
                      MatrixR = Model.transpose(MatrixR);
                  }else {
                      System.out.println("Nieprawidlowy wybor. Sproboj jeszcze raz");
                      showMenu();
                  }}catch (Exception e ){
                    System.err.println("Najpierw wprowadz macierzy wejsciowe");
                }
                  showMenu();

              } else if (ch == 3) {
                  try{
                  System.out.println("( 1 ) Wyswietl macierzy  wejsciowe");
                  System.out.println("( 2 ) Wyswietl macierz wynikowa");
                  Scanner choose2 = new Scanner(System.in);
                  int ch2 = choose2.nextInt();
                  if( ch2 == 1){

                      showMatrix(MatrixA);
                      System.out.println("Macierz A");
                      System.out.println(" ");

                      showMatrix(MatrixB);
                      System.out.println("Macierz B");
                      System.out.println(" ");
                  } else if (ch2 == 2) {
                      showMatrix(MatrixR);
                      System.out.println("Macierz wynikowa");
                      System.out.println(" ");

                  }else {
                      System.out.println("Nieprawidlowy wybor. Sproboj jeszcze raz");
                      showMenu();
                  }
                  }catch (Exception e ){
                      System.err.println("Najpierw wprowadz macierzy wejsciowe");

                  }

                  showMenu();


              } else if (ch == 4) {
                  return;
              } else {
                  System.out.println("Nieprawidlowy wybor. Sproboj jeszcze raz");
                  showMenu();
              }
     }



      }
      public  class Controller{


          public static int[] dimension(){
              Scanner sc = new Scanner(System.in);
              int [] dim = new int[2];
              System.out.println("Wprowadz ilosc rzendow");
              dim[0] = sc.nextInt();
              System.out.println("Wprowadz ilosc kolumn");
              dim[1] = sc.nextInt();
              return dim;
          }

          public static int[][] getMatrix(int rows, int cols){
            int [][] temp = new int[rows][cols];
              Scanner sc = new Scanner(System.in);
            for(int i = 0; i < rows; i++){
                for(int j = 0; j< cols; j++){
                    System.out.println("Wprowadz liczbe do " + i + ", "+ j);
                    temp[i][j] = sc.nextInt();
                }
            }
            return  temp;
          }
      }

     public static void main(String[] args) {
         View.showMenu();

     }
 }