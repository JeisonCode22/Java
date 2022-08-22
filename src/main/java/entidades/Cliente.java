package entidades;

public class Cliente {

	private int id_cliente;
	private String direccion;
	private String ciudad;
	private String nombre;
	private int Id_empleadoAsignado;
	private int id_cuenta;

	public Cliente() {
	}

	public Cliente(int id_cliente, String nombre, String direccion, String ciudad, int Id_empleadoAsignado,
			int id_cuenta) {
		this.id_cliente = id_cliente;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.nombre = nombre;
		this.Id_empleadoAsignado = Id_empleadoAsignado;
		this.id_cuenta = id_cuenta;
	}

	public int getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(int id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public int getid_cliente() {
		return id_cliente;
	}

	public void setid_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getdireccion() {
		return direccion;
	}

	public void setdireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getciudad() {
		return ciudad;
	}

	public void setciudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_empleadoAsignado() {
		return Id_empleadoAsignado;
	}

	public void setid_empleadoAsignado(int Id_empleadoAsignado) {
		this.Id_empleadoAsignado = Id_empleadoAsignado;
	}

	@Override
	public String toString() {
		return "Cliente" + " id_cliente:" + id_cliente + " $direccion: " + direccion + '\'' + " $ciudad: " + ciudad
				+ '\'' + " nombre: " + nombre + '\'' + " $Id_empleadoAsignado: " + Id_empleadoAsignado
				+ " tipo_cuenta: " + id_cuenta;
	}
}
