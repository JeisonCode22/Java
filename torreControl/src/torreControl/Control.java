package torreControl;

import java.util.Scanner;

public class Control {

	public static void main(String[] args) {
		int seleccion;
		boolean enLinea = false;
		Aterrizable avion = new Avion();
		Aterrizable helicoptero = new Helicoptero();
		Aterrizable ovni = new Ovni();
		Aterrizable superman = new Superman();
		Aterrizable aeronaves[] = { avion, helicoptero, ovni, superman };
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print(
					"Bienvenidos a la pista de aterrizaje por favor escoja una de las siguiente opciones para saber que tipo de aeronave es"
							+ "\n" + "1. Avion" + "\n" + "2. Helicoptero" + "\n" + "3. Ovni" + "\n" + "4. Superman"
							+ "\n" + "Por favor ingrese un numero: ");

			seleccion = sc.nextInt();
			if (aeronaves[seleccion - 1].esAterrizable() == true) {
				System.out.println("--->Continue con el aterrizaje");
			} else {
				System.out.println("--->Lo sentimos, no puede aterrizar en esta pista");
			}
			System.out.print("Ha finzalizado la solicitud anterior." + "\n"
					+ "Por favor escriba true o false si hay otra solicitud en linea: ");
			enLinea = sc.nextBoolean();
			if (enLinea == false) {
				System.out.println("Turno laboral. Finalizado.");
			}
		} while (enLinea == true);
	}
}
