package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;



public class Main {
	
	private static List<Efemeride> efemerides;
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		boolean ingresoCorrecto = false;
		efemerides= new ArrayList<>();
		do {
			try {
				byte op=0;
					do {
						System.out.println("---MENU---");
						System.out.println("-1 Crear efemeride");
						System.out.println("-2 Mostrar todos las efemerides");
						System.out.println("-3 Eliminar efemeride");
						System.out.println("-4 Modificar efemeride");
						System.out.println("-5 SALIR");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							crearEfemeride();break;
						case 2:
							mostrarEfemeride();break;
						case 3:
							eliminarEfemeride();break;
						case 4:
							modificarEfemeride();break;
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

	public static void crearEfemeride(){
		Efemeride efemeride = new Efemeride();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Ingrese codigo de efemeride: ");
		efemeride.setCodigo(sc.next());
		
		efemeride.setMes(elegirMes());
		while(true) {
			try {
				boolean passed;
				int dia;
				do {
					System.out.println("Ingrese dia: ");
	                dia=sc.nextInt();
	                passed=comprobarDia(dia, efemeride);
	                if (!passed) {
	                	System.err.println("DIA INCORRECTO segun su mes");
	                }
				} while (!passed);
                efemeride.setDia(dia);
                break;
            } catch (InputMismatchException e) {
                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
                sc.next(); 
            }
		}
		sc.nextLine();
		System.out.println("Ingrese detalle de la efemeride: ");
		efemeride.setDetalle(sc.nextLine());
		efemerides.add(efemeride);
		
		
	}
	public static boolean comprobarDia(int dia, Efemeride efemeride) {
		boolean ok= false;
		int cont=1;
		for (Mes mes : Mes.values()) {
			if(mes.equals(efemeride.getMes())) {
				break;
			}else {
				cont++;
			}
		}
		if((cont==1|| cont==3 || cont==5 || cont==7 || cont==8 || cont==10 || cont==12) && (dia>0 && dia<=31)) {
			ok=true;
		}else if((cont==2 ) && (dia>0 && dia<=28)) {
			ok=true;
		}else if((cont==4|| cont==6 || cont==9 || cont==11 ) && (dia>0 && dia<=30)) {
			ok=true;
		}
		
		return ok;
	}
	
	public static void mostrarEfemeride() {
		
		if(!efemerides.isEmpty()) {
			System.out.println("----LISTA DE EFEMERIDES----");
			for (Efemeride efemeride : efemerides) {
				System.out.println(efemeride);
			}
		}else {
			System.err.println("La lista de efemerides se encuentra vacia");
		}
		
	}
	public static void eliminarEfemeride() {
		Scanner sc=new Scanner(System.in);
		if(!efemerides.isEmpty()) {
			System.out.println("Ingrese codigo de la efemeride a eliminar: ");
			String codigo= sc.next();
			boolean eliminado = false;
			Iterator<Efemeride> iterator= efemerides.iterator();
			while(iterator.hasNext()) {
				Efemeride efemeride= iterator.next();
				if(efemeride.getCodigo().compareToIgnoreCase(codigo)==0) {
					iterator.remove();
					eliminado=true;
					System.out.println(efemeride);
					System.out.println("EFEMERIDE ELIMINADA CORRECTAMENTE");
				}
			}
			if(!eliminado) {
				System.err.println("xxxx-NO SE HA ENCONTRADO LA EFEMERIDE-xxxx");
			}
		}else {
			System.err.println("--- NO SE HA DADO DE ALTA NINGUNA EFEMERIDE ---");
		}
	}
	public static void modificarEfemeride() {
		Scanner sc= new Scanner(System.in);
		boolean encontrado=false;
		if(!efemerides.isEmpty()) {
			System.out.println("Ingrese codigo de la efemeride a modificar");
			String codigo=sc.next();
			for(Efemeride efemeride:efemerides) {
				if(efemeride.getCodigo().compareToIgnoreCase(codigo)==0) {
					System.out.println("---EFEMERIDE ENCONTRADA---");
					encontrado=true;
					System.out.println("Que desea modificar?");
					while(true) {
						 byte op=0;
						try {
							do {
								System.out.println("-1 Mes");
								System.out.println("-2 Dia");
								System.out.println("-3 Detalle");
								System.out.println("Ingrese opcion: ");
								op=sc.nextByte();
								if(op ==1) {
									efemeride.setMes(elegirMes());
								}else if(op==2) {
									while(true) {
										try {
											boolean passed;
											int dia;
											do {
												System.out.println("Ingrese dia: ");
								                dia=sc.nextInt();
								                passed=comprobarDia(dia, efemeride);
								                if (!passed) {
								                	System.err.println("DIA INCORRECTO segun su mes");
								                }
											} while (!passed);
							                efemeride.setDia(dia);
							                break;
							            } catch (InputMismatchException e) {
							                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
							                sc.next(); 
							            }
									}
								}else if(op==3) {
									sc.nextLine();
									System.out.println("Ingrese detalle de la efemeride: ");
									efemeride.setDetalle(sc.nextLine());
								}else {
									System.err.println("Eleccion incorrecta trate de nuevo.");
								}
							} while (op!= 1 && op!= 2 && op != 3 );
							
							break;
						} catch (InputMismatchException  e) {
							System.err.println("Error: Ingresa una opción válida (número).");
					        sc.next(); 
						}
					}
					break;
				}
			}
			if(!encontrado) {
				System.err.println("El producto no se ha encontrado");
			}
		}else {
			System.err.println("--- NO SE HA DADO DE ALTA NINGUN PRODUCTO ---");
		}
	}
	
	public static Mes elegirMes() {
		Mes mes=null;
		byte op;
		Scanner sc=new Scanner(System.in);
		while(true) {
			 op=0;
			try {
				do {
					System.out.println("Ingrese mes: (1 al 12)");
					op=sc.nextByte();
					if(op ==1) {
						mes=Mes.ENERO;
					}else if(op==2) {
						mes=Mes.FEBRERO;
					}else if(op==3) {
						mes=Mes.MARZO;
					}else if(op==4) {
						mes=Mes.ABRIL;
					}else if(op==5) {
						mes=Mes.MAYO;
					}else if(op==6) {
						mes=Mes.JUNIO;
					}else if(op==7) {
						mes=Mes.JULIO;
					}else if(op==8) {
						mes=Mes.AGOSTO;
					}else if(op==9) {
						mes=Mes.SEPTIEMBRE;
					}else if(op==10) {
						mes=Mes.OCTUBRE;
					}else if(op==11) {
						mes=Mes.NOVIEMBRE;
					}else if(op==12) {
						mes=Mes.DICIEMBRE;
					}else {
						System.err.println("Eleccion incorrecta trate de nuevo.");
					}
				} while (op!= 1 && op!= 2 && op != 3 && op!=4 && op!=5 && op!=6 && op!=7 && op!=8 && op!=9 && op!=10 && op!=11 && op!=12);
				
				break;
			} catch (InputMismatchException  e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		}
		
		return mes;
	}
	
}
