package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;



public class Main {
	
	private static List<Jugador> jugadores;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean ingresoCorrecto = false;
		jugadores = new ArrayList();
		do {
			try {
			byte op=0;
				do {
					System.out.println("---MENU---");
					System.out.println("-1 Alta Jugador");
					System.out.println("-2 Mostrar todos los jugadores");
					System.out.println("-3 Modificar posicion de un jugador");
					System.out.println("-4 Eliminar un jugaodor");
					System.out.println("-5 SALIR");
					System.out.println("--------ingrese opcion-----------");
					op=sc.nextByte();
					
					switch (op) {
					case 1:
						generarJugador();
						System.out.println("----SE HA DADO DE ALTA EL JUGADOR-----");
						break;
					case 2:
						mostrarJugadores();
						break;
					case 3:
						modificarPosicion();
						break;
					case 4:
						eliminarJugador();
						break;
					case 5:
						System.out.println("FIN DEL PROGRAMA-- <3 --");
						ingresoCorrecto=true;
						break;
					default:
						System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
						break;
					}
					
				} while (op != 5);
			}catch(InputMismatchException e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		} while (!ingresoCorrecto);

	}
	
	
	public static void generarJugador() {
		Scanner sc = new Scanner(System.in);
		Jugador jugador = new Jugador();
		System.out.println("Ingrese nombre: ");
		jugador.setNombre(sc.next());
		System.out.println("Ingrese apellido: ");
		jugador.setApellido(sc.next());
		
		
		boolean fechaParseada = false;
	    while (!fechaParseada) {
	        System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy)");
	        String fechaNacStr = sc.next();
	        try {
	            LocalDate fechaNacimiento = parsearFecha(fechaNacStr);
	            jugador.setFechaNac(fechaNacimiento);
	            fechaParseada = true;
	        } catch (DateTimeParseException e) {
	            System.err.println("FORMATO SOLICITADO ERRONEO, INGRESE NUEVAMENTE.");
	            
	        }
	    }
	    System.out.println("Ingrese nacionalidad:  (argentina, boliviana, peruana etc)");
	    jugador.setNacionalidad(sc.next());
		
	    boolean estaturaValida = false;
	    while (!estaturaValida) {
	        try {
	            System.out.println("Ingrese estatura: (en centimetros)");
	            jugador.setEstatura(sc.nextInt());
	            estaturaValida = true; // 
	        } catch (InputMismatchException e) {
	            System.err.println("Error: Debes ingresar un valor numérico.");
	            sc.next();
	        }
	    }
		
	    boolean pesoValido = false;
	    while (!pesoValido) {
	        try {
	            System.out.println("Ingrese peso: ");
	            jugador.setPeso(sc.nextFloat());
	            pesoValido = true; // 
	        } catch (InputMismatchException e) {
	            System.err.println("Error: Debes ingresar un valor numérico (ej: 65,5 / 65).");
	            sc.next();
	        }
	    }
		
		jugador.setPosicion(elegirPosicion());
		
		jugadores.add(jugador);
	}
	
	public static Posicion elegirPosicion() {
		Posicion posicion=null;
		byte op;
		Scanner sc=new Scanner(System.in);
		while(true) {
			 op=0;
			try {
				do {
					System.out.println("----POSICION----");
					System.out.println("1-DELANTERO");
					System.out.println("2-MEDIO");
					System.out.println("3-DEFENSA");
					System.out.println("4-ARQUERO");
					System.out.println("Ingrese opcion: ");
					op=sc.nextByte();
					if(op ==1) {
						posicion=Posicion.DELANTERO;
					}else if(op==2) {
						posicion=Posicion.MEDIO;
					}else if(op==3) {
						posicion=Posicion.DEFENSA;
					}else if(op==4) {
						posicion=Posicion.ARQUERO;
					}else {
						System.err.println("Eleccion incorrecta trate de nuevo.");
					}
				} while (op!= 1 && op!= 2 && op != 3 && op!=4 );
				
				break;
			} catch (InputMismatchException  e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		}
		return posicion;
	}
	
	public static void mostrarJugadores() {
		if(!jugadores.isEmpty()) {
			System.out.println("----LISTA DE JUGADORES----");
			for (Jugador jugador : jugadores) {
				System.out.println(jugador);
			}
		}else {
			System.err.println("NO EXISTEN JUGADORES");
		}
		
	}
	public static void modificarPosicion() {
		Scanner sc= new Scanner(System.in);
		boolean encontrado=false;
		if (!jugadores.isEmpty()) {
			System.out.println("Ingrese al nombre del jugador a eliminar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a eliminar");
			String apellido = sc.next();
			for (Jugador jugador : jugadores) {
				if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
					jugador.setPosicion(elegirPosicion());
					encontrado=true;
					break;
				}
			}
			
			if(encontrado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}	
		}else {
			System.err.println("---NO SE HA DADO DE ALTA NINGUN JUGADOR---");
		}
	}
	public static void eliminarJugador() {
		Scanner sc= new Scanner(System.in);
		boolean eliminado=false;
		if (!jugadores.isEmpty()) {
			System.out.println("Ingrese al nombre del jugador a eliminar");
			String nombre = sc.next();
			System.out.println("INgrese el apellido del jugador a eliminar");
			String apellido = sc.next();
			
			Iterator<Jugador> iterator= jugadores.iterator();
			while(iterator.hasNext()) {
				Jugador jugador= iterator.next();
				if(jugador.getNombre().compareToIgnoreCase(nombre)==0 && jugador.getApellido().compareTo(apellido)==0) {
					iterator.remove();
					eliminado=true;
					System.out.println("JUGADOR ELIMINADO CORRECTAMENTE");
				}
			}
			if(eliminado==false) {
				System.err.println("----El jugador ingresado NO EXISTE----");
			}	
		}else {
			System.err.println("---NO SE HA DADO DE ALTA NINGUN JUGADOR---");
		}
	}
	
	 public static LocalDate parsearFecha(String fechaStr) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        return LocalDate.parse(fechaStr, formatter);
	    }

}
