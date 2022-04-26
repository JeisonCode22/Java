package torreControl;

public class Helicoptero implements Aterrizable{
	public String nombre;
	public boolean aterrizable = true;
	
	@Override
	public boolean esAterrizable() {
		return this.aterrizable;
	}
}
