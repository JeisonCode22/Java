package torreControl;

public class Superman implements Aterrizable {
	public String nombre;
	public boolean aterrizable;

	@Override
	public boolean esAterrizable() {
		return this.aterrizable;
	}

}
