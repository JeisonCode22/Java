package entidades;

public class AreaJefe {
	private Integer id_area;
	private String nombre;

	public AreaJefe() {
	}

	public AreaJefe(Integer id_area, String nombre) {
		this.id_area = id_area;
		this.nombre = nombre;

	}

	public Integer getId_area() {
		return id_area;
	}

	public void setId_area(Integer id_area) {
		this.id_area = id_area;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Area" + "\nid_area:" + id_area + "\nnombre:'" + nombre;
	}
}
