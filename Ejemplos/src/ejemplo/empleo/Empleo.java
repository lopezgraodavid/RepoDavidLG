package ejemplo.empleo;

public abstract class Empleo {
	
	protected double sueldo;
	public abstract void cobrar();
	public abstract void fichar();
	
	public double getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	
}
