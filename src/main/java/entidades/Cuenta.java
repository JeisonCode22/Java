package entidades;

public class Cuenta {

	private int id_c;
	private String No_cuenta;
	private String tipo_cuenta;

	public Cuenta() {
	}

	public Cuenta(int id_c, String no_cuenta, String tipo_cuenta) {
		this.id_c = id_c;
		No_cuenta = no_cuenta;
		this.tipo_cuenta = tipo_cuenta;
	}

	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public String getNo_cuenta() {
		return No_cuenta;
	}

	public void setNo_cuenta(String no_cuenta) {
		No_cuenta = no_cuenta;
	}

	public String getTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(String tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

	@Override
	public String toString() {
		return "Cuenta" + "\nId_c: " + id_c + "\nNo_Cuenta: " + No_cuenta + "\ntipo_Cuenta:" + tipo_cuenta;
	}
}
