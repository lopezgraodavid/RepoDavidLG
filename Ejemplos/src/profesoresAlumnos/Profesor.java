package profesoresAlumnos;

public class Profesor extends Persona{
	
	public Profesor(String nombre, String apellidos, int numTelefono, String email,
			Direccion direccion, int salario, String asignatura) {
		super(nombre, apellidos, numTelefono, email, direccion);
		this.salario = salario;
		this.asignatura = asignatura;
	}




	private int salario;
	private String asignatura;
	
	public int getSalario() {
		return salario;
	}
	public void setSalario(int salario) {
		this.salario = salario;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
	
	
	

}
