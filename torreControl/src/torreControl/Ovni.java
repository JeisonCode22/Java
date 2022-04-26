package torreControl;

public class Ovni implements Aterrizable{
	public String nombre;
	public boolean aterrizable;
	
	@Override
	public boolean esAterrizable() {
		return this.aterrizable;
	}
}
