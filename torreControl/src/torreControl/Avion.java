package torreControl;

public class Avion extends Aeronave implements Aterrizable{
	public String nombre = "carlos";
	public boolean aterrizable = true;
	
	@Override
	public boolean esAterrizable() {
		return this.aterrizable;
	}
}
