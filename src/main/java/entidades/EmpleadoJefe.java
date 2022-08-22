package entidades;

public class EmpleadoJefe {

	private int id_jefe;
	private String nombre;
	private int id_area;

	public EmpleadoJefe() {
	}

	public EmpleadoJefe(int id_jefe, String nombre, int id_area) {
		this.id_jefe = id_jefe;
		this.nombre = nombre;
		this.id_area = id_area;
	}

	public int getId_jefe() {
		return id_jefe;
	}

	public void setId_jefe(int id_jefe) {
		this.id_jefe = id_jefe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_area() {
		return id_area;
	}

	public void setId_area(int id_area) {
		this.id_area = id_area;
	}

	@Override
	public String toString() {
		return "Jefe" + "\nId_jefe :" + id_jefe + "\nNombre :" + nombre + "\nId_area :" + id_area;
	}
}
