import java.util.ArrayList;
import java.util.Scanner;

public class Notes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese # de estudiantes");
        int nEstudiante = sc.nextInt();
        System.out.println("Ingrese el # de notas");
        int nExamenes = sc.nextInt();
        String[] nombres = new String[nEstudiante];
        String[] apellidos = new String[nEstudiante];
        double[][] notas = new double[nEstudiante][nExamenes];

        for (int i = 0; i < nEstudiante; i++) {
            System.out.println("Ingrese el nombre del estudiante #" + (i + 1));
            nombres[i] = sc.next();
            System.out.println("Ingrese el apellido del estudiante " + nombres[i]);
            apellidos[i] = sc.next();
            for (int j = 0; j < nExamenes; j++) {
                System.out.println("Ingrese la nota del examen" + (j + 1));
                notas[i][j] = sc.nextDouble();
            }
        }
        double highest = 0;
        double lowest = 100000000;
        int highestIndex=0;
        int lowestIndex=0;
        ArrayList <String> aprobados = new ArrayList<>();
        ArrayList <String> reprobados = new ArrayList<>();


        for (int i = 0; i < nEstudiante; i++) {
            double sum = 0;
            for (int j = 0; j < nExamenes; j++) {
                sum += notas[i][j];
            }
            double promedio = sum / nExamenes;
            if (promedio > highest) {
                highest = promedio;
                highestIndex=i;
            }
            if (promedio < lowest) {
                lowest = promedio;
                lowestIndex =i;
            }
            if(promedio>=7){
                aprobados.add(nombres[i]+" "+apellidos[i]);
            }else {
                reprobados.add(nombres[i]+" "+apellidos[i]);
            }
        }
        System.out.println("El estudiante con mayor promedio es "+nombres[highestIndex]+" "+apellidos[highestIndex]+
                " Con un promedio de: "+highest);
        System.out.println("El estudiante con menor promedio es "+nombres[lowestIndex]+" "+apellidos[lowestIndex]+
                " Con un promedio de: "+lowest);
        System.out.println("Los estudiantes aprobados son: ");
        for (String e:aprobados){
            System.out.println(e);
        }
        System.out.println("Los estudiantes reprobados son: ");
        for(String a:reprobados){
            System.out.println(a);
        }
    }
}
