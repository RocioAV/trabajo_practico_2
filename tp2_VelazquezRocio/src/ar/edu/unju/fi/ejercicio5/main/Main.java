package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.unju.edu.fi.ejercicio5.model.PagoEfectivo;
import ar.unju.edu.fi.ejercicio5.model.PagoTarjeta;
import ar.unju.edu.fi.ejercicio5.model.Producto;
import ar.unju.edu.fi.ejercicio5.model.Producto.Categoria;
import ar.unju.edu.fi.ejercicio5.model.Producto.OrigenFabricacion;



public class Main {
	
	private static List<Producto> productos;
	private static List<Producto> carrito;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean ingresoCorrecto = false;
		do {
			try {
				byte op=0;
				precargaProductos();
					do {
						System.out.println("---MENU---");
						System.out.println("-1 Mostrar productos");
						System.out.println("-2 Realizar compra");
						System.out.println("-3 SALIR");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							mostrarProductos();break;
						case 2:
							carrito= new ArrayList<Producto>();
							seleccionarProductos();
							realizarCompra();
							carrito.clear(); // luego de la compra realizada limpio el carrito para una nueva
							break;
						case 3:
							System.out.println("FIN DEL PROGRAMA-- <3 --");
							ingresoCorrecto=true;
							break;	
						default:
							System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
							break;
						}
						
					} while (op != 3);
					
				}catch(InputMismatchException e) {
					System.err.println("Error: Ingresa una opción válida (número).");
			        sc.next(); 
				}
	} while (!ingresoCorrecto);

	}

	public static void precargaProductos() {
		productos =new ArrayList<Producto>();
		productos.add(new Producto("1", "Heladera Frozen", 450000.0, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("2", "Taladro 2.0 ", 320000.0, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("3", "Lenovo S145 14' ", 800000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("4", "Iphone 11 pro max", 750000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("5", "Xiaomi POCO X3 NFC", 150000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("6", "Smart TV 32'' ITACHI", 450000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("7", "Microhondas Samsung", 280000.0, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("8", "Lavarropas DREAN ", 750000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("9", "Motorola G60 plus", 180000.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("10", "Asus M231 16' ", 1000000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("11", "Procesador IntelCore i3", 450000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		productos.add(new Producto("12", "Secador de pelo GAMA", 80000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("13", "Equipo de sonido SONY M100X", 1000000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("14", "Memoria RAM 8GB ", 80000.0, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto("15", "SSD 480GB Kingston", 46000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		
	}
	
	public static void mostrarProductos() {
		System.out.println("----LISTA DE PRODUCTOS----");
		for (Producto producto : productos) {
			System.out.println(producto);
		}
		System.out.println("--------------------------");
	}
	
	public static void seleccionarProductos() {
		Scanner sc = new Scanner(System.in);
		String codigo;
		String op;
				do {
					System.out.println("ingrese el codigo del producto que desea agregar al carrito");
					codigo=sc.next();
					boolean encontrado= false;
					for (Producto producto : productos) {
						if(producto.getCodigo().equals(codigo)  && producto.isEstado()==true) {
							encontrado=true;
							System.out.println("PRODUCTO ENCONTRADO: " + producto);
							carrito.add(producto);
							break;
						}
					}
					if(!encontrado) {
						System.err.println("Producto NO encontrado o NO disponemos stock");
					}
					
					System.out.println("¿Desea agregar mas productos? s/n");
					op=sc.next();
				} while (op.compareToIgnoreCase("s")==0);
		
		
	}
	
	
	public static void realizarCompra() {
		Scanner sc = new Scanner(System.in);
		double montoFinal=sumarCarrito();
		mostrarCarrito();
		
		System.out.println("El TOTAL es: $"+ (float)montoFinal);
		boolean ingreso = true;
			try {
				byte op=0;
					do {
						System.out.println("-1 Pago Tarjeta");
						System.out.println("-2 Pago Efectivo");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							System.out.println("ingrese numero de tarjeta: ");
							String numT = sc.next();
							PagoTarjeta tarjeta = new PagoTarjeta(numT, LocalDate.now(), montoFinal);
							tarjeta.realizarPago(montoFinal);
							tarjeta.imprimirRecibo();
							ingreso=false;
							break;
						case 2:
							PagoEfectivo efectivo= new PagoEfectivo(montoFinal, LocalDate.now());
							efectivo.realizarPago(montoFinal);
							efectivo.imprimirRecibo();
							ingreso=false;
							break;
						default:
							System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
							break;
						}
						
					} while (ingreso==true);
					
				}catch(InputMismatchException e) {
					System.err.println("Error: Ingresa una opción válida (número).");
			        sc.next(); 
				}
		
	}
	
	/**
	 * le muestra al usuario una lista de su carrito
	 */
	public static void mostrarCarrito() {
		if(!carrito.isEmpty()) {
			System.out.println("--------CARRITO--------");
			for (Producto producto : carrito) {
				System.out.println(producto);
			}
		}else {
			System.err.println("CARRITO VACIO");
		}
	}
	/**
	 * suma el precio de todos los productos seleccionados del usuario
	 * @return preciofinal
	 */
	public static double sumarCarrito() {
		double precioFinal=0;
		for (Producto producto : carrito) {
			precioFinal += producto.getPrecioUnitario();
		}
		return precioFinal;
	}
}
