package profesoresAlumnos;

public class Persona {
	private String Nombre;
	private String Apellidos;
	private int NumTelefono;
	private String Email;
	private Direccion Direccion;
	


	public Persona(String nombre, String apellidos, int numTelefono, String email,
			profesoresAlumnos.Direccion direccion) {
		super();
		Nombre = nombre;
		Apellidos = apellidos;
		NumTelefono = numTelefono;
		Email = email;
		Direccion = direccion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getNumTelefono() {
		return NumTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		NumTelefono = numTelefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Direccion getDireccion() {
		return Direccion;
	}

	public void setDireccion(Direccion direccion) {
		Direccion = direccion;
	}


	
	
	
}
