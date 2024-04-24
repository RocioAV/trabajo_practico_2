package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechaNac;
	private String nacionalidad;
	private int estatura;
	private float peso;
	private Posicion posicion;
	
	//CONSTRUCTORES
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fechaNac, String nacionalidad, int estatura, float peso,
			Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}



	//METODOS
	// Método para calcular la edad a partir de una fecha de nacimiento
    public  int calcularEdad() {
        int edad = LocalDate.now().getYear() - this.fechaNac.getYear();
        if (LocalDate.now().getDayOfYear() < this.fechaNac.getDayOfYear()) {
            edad--;
        }
        return edad;
    }
    @Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaNac=" + fechaNac + ", nacionalidad="
				+ nacionalidad + ", estatura=" + estatura + "cm , peso=" + peso + "kg , posicion=" + posicion + "]";
	}


    //metodos accesores
    
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public LocalDate getFechaNac() {
		return fechaNac;
	}



	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}



	public String getNacionalidad() {
		return nacionalidad;
	}



	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}



	public int getEstatura() {
		return estatura;
	}



	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}



	public float getPeso() {
		return peso;
	}



	public void setPeso(float peso) {
		this.peso = peso;
	}



	public Posicion getPosicion() {
		return posicion;
	}



	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
    
    
   
    

}
