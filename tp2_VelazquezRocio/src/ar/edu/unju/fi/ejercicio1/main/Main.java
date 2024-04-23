package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;


public class Main {

	private static List<Producto> productos;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean ingresoCorrecto = false;
		do {
			try {
				byte op=0;
				productos= new ArrayList<>();
					do {
						System.out.println("---MENU---");
						System.out.println("-1 Crear producto");
						System.out.println("-2 Mostrar todos los Productos");
						System.out.println("-3 Modificar producto");
						System.out.println("-4 SALIR");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							crearProducto();break;
						case 2:
							mostrarProductos();break;
						case 3:
							modificarProducto();break;
						case 4:
							System.out.println("FIN DEL PROGRAMA-- <3 --");
							ingresoCorrecto=true;
							break;
							
						default:
							System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
							break;
						}
						
					} while (op != 4);
					
				}catch(InputMismatchException e) {
					System.err.println("Error: Ingresa una opción válida (número).");
			        sc.next(); 
				}
	} while (!ingresoCorrecto);

	}

	public static void crearProducto(){
		Producto producto = new Producto();
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Ingrese codigo de producto: ");
		producto.setCodigo(sc.next());
		sc.nextLine();
		System.out.println("Ingrese descripcion del producto: ");
		producto.setDescription(sc.nextLine());
		
		while(true) {
			try {
                System.out.println("Ingrese precio: ");
                producto.setPrecioUnitario(sc.nextDouble());
                break;
            } catch (InputMismatchException e) {
                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
                sc.next(); 
            }
		}
		producto.setCategoria(elegirCategoria());
		producto.setOrigenFab(elegirOrigen());
		productos.add(producto);
		
		
	}
	
	public static void mostrarProductos() {
		
		if(!productos.isEmpty()) {
			System.out.println("----LISTA DE PRODUCTOS----");
			for (Producto producto : productos) {
				System.out.println(producto);
			}
		}else {
			System.err.println("La lista de productos se encuentra vacia");
		}
		
	}
	public static void modificarProducto() {
		 Scanner sc= new Scanner(System.in);
		boolean encontrado=false;
		if(!productos.isEmpty()) {
			System.out.println("Ingrese codigo del producto a modificar");
			String codigo=sc.next();
			for(Producto producto:productos) {
				if(producto.getCodigo().compareToIgnoreCase(codigo)==0) {
					System.out.println("---PRODUCTO ENCONTRADO---");
					encontrado=true;
					System.out.println("Que desea modificar?");
					while(true) {
						 byte op=0;
						try {
							do {
								System.out.println("-1 Descripcion");
								System.out.println("-2 Precio Unitario");
								System.out.println("-3 Orgigen de fabricacion");
								System.out.println("-4 Categoria");
								System.out.println("Ingrese opcion: ");
								op=sc.nextByte();
								if(op ==1) {
									sc.nextLine();
									System.out.println("Ingrese descripcion del producto: ");
									producto.setDescription(sc.nextLine());
								}else if(op==2) {
									while(true) {
										try {
							                System.out.println("Ingrese precio: ");
							                producto.setPrecioUnitario(sc.nextDouble());
							                break;
							            } catch (InputMismatchException e) {
							                System.err.println("Tipo de dato incorrecto. Por favor, ingrese un valor válido.");
							                sc.next(); 
							            }
									}
								}else if(op==3) {
									producto.setOrigenFab(elegirOrigen());
								}else if(op==4) {
									producto.setCategoria(elegirCategoria());
								}else {
									System.err.println("Eleccion incorrecta trate de nuevo.");
								}
							} while (op!= 1 && op!= 2 && op != 3 && op!=4);
							
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
	public static OrigenFabricacion elegirOrigen() {
		OrigenFabricacion origen=null;
		byte op;
		Scanner sc=new Scanner(System.in);
		while(true) {
			 op=0;
			try {
				do {
					System.out.println("----Origen de fabricaicon----");
					System.out.println("-1 Argentina");
					System.out.println("-2 China");
					System.out.println("-3 Brasil");
					System.out.println("-4 Uruguay");
					System.out.println("Ingrese opcion: ");
					op=sc.nextByte();
					if(op ==1) {
						origen=OrigenFabricacion.ARGENTINA;
					}else if(op==2) {
						origen=OrigenFabricacion.CHINA;
					}else if(op==3) {
						origen=OrigenFabricacion.BRASIL;
					}else if(op==4) {
						origen=OrigenFabricacion.URUGUAY;
					}else {
						System.err.println("Eleccion incorrecta trate de nuevo.");
					}
				} while (op!= 1 && op!= 2 && op != 3 && op!=4);
				
				break;
			} catch (InputMismatchException  e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		}
		
		return origen;
	}
	public static Categoria elegirCategoria() {
		Categoria categoria=null;
		byte op;
		Scanner sc=new Scanner(System.in);
		while(true) {
			 op=0;
			try {
				do {
					System.out.println("----Categoria----");
					System.out.println("-1 Telefonia");
					System.out.println("-2 Informatica");
					System.out.println("-3 Electro Hogar");
					System.out.println("-4 Herramientas");
					System.out.println("Ingrese opcion: ");
					op=sc.nextByte();
					if(op ==1) {
						categoria=Categoria.TELEFONIA;
					}else if(op==2) {
						categoria=Categoria.INFORMATICA;
					}else if(op==3) {
						categoria=Categoria.ELECTROHOGAR;
					}else if(op==4) {
						categoria=Categoria.HERRAMIENTAS;
					}else {
						System.err.println("Eleccion incorrecta trate de nuevo.");
					}
				} while (op!= 1 && op!= 2 && op != 3 && op!=4);
				
				break;
			} catch (InputMismatchException  e) {
				System.err.println("Error: Ingresa una opción válida (número).");
		        sc.next(); 
			}
		}
		return categoria;
	}
}
