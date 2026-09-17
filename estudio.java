import java.util.Scanner;

public static void main (String[] args){

    Scanner scanner = new Scanner(System.in);

    final int MAYORIA_DE_EDAD;
    int capacidadDeLaClase;

    System.out.println("Cuantos alumnos hay en clase?");
    capacidadDeLaClase = scanner.nextInt();

    double[] alumnos = new double[capacidadDeLaClase];
    calculoDeEdades(alumnos, capacidadDeLaClase);
}

static void calculoDeEdades(double[] alumnos, int capacidadDeLaClase){

    for(int i = 0 ; i < capacidadDeLaClase ; i++ ){
        alumnos[i] = Math.random()*100;
        System.out.println(i + " " + alumnos[i]);
    }
}