package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio5.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio5.model.Producto.OrigenFabricacion;

public class Main {
	private static List<Producto> productos;
	
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
						System.out.println("-2 Mostrar productos faltantes");
						System.out.println("-3 Incrementar los precios de los productos un 20%");
						System.out.println("-4 Mostrar Productos ELECTROHOGAR disponibles");
						System.out.println("-5 Ordenar los productos por precio (descendente)");
						System.out.println("-6 Mostrar los productos con nombre en MAYUSCULA");
						System.out.println("-7 SALIR");
						System.out.println("--------ingrese opcion-----------");
						op=sc.nextByte();
						
						switch (op) {
						case 1:
							mostrarProductos();break;
						case 2:
							mostrarProductosFaltantes();break;
						case 3:
							incrementar20();break;
						case 4:
							mostrarElectroHogarDisponible();break;
						case 5:
							ordenarPorPrecio();break;
						case 6:
							mostrarProductosMayuscula();break;
						case 7:
							System.out.println("FIN DEL PROGRAMA-- <3 --");
							ingresoCorrecto=true;
							break;
						default:
							System.out.println("VALOR INCORRECTO INTENTE NUEVMAENTE");
							break;
						}
						
					} while (op != 7);
					
				}catch(InputMismatchException e) {
					System.err.println("Error: Ingresa una opción válida (número).");
			        sc.next(); 
				}
	} while (!ingresoCorrecto);
	}
	public static void mostrarProductos() {
		Consumer<Producto> printConsumerProd = p -> System.out.println(p);
		productos.forEach(printConsumerProd);
		
	}
	
	public static void mostrarProductosFaltantes() {
		Predicate<Producto> filterStateFalse = p -> p.isEstado()==false;
		productos.stream().filter(filterStateFalse).forEach(System.out::println);
	}
	
	public static void incrementar20() {
		Function<Producto,Producto> funcionIncrementar = (p) -> {
			Double resultado = p.getPrecioUnitario() + (p.getPrecioUnitario()* 0.2);
			p.setPrecioUnitario(resultado);
			return p;
		};
		List<Producto> productosIncrementados = new ArrayList<>();
		productosIncrementados = productos.stream().map(funcionIncrementar).collect(Collectors.toList());
		productosIncrementados.forEach(System.out::println);
	}
	public static void mostrarElectroHogarDisponible() {
		Predicate<Producto> filterStateTrueElectroHogar = p -> p.isEstado()==true && p.getCategoria().equals(Categoria.ELECTROHOGAR);
		productos.stream().filter(filterStateTrueElectroHogar).forEach(System.out::println);
	}
	
	public static void ordenarPorPrecio() {
		productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
		Consumer<Producto> printConsumerProd = p -> System.out.println(p);
		productos.forEach(printConsumerProd);
	}
	
	/**
	 * OPCION 6  Mostrar los productos con nombre en MAYUSCULA
	 * Se actualizará el array original, que es el de productos, ya que en la funcion toUpperCase estamos actualizando
	 * directamente los objetos de ese mismo.
	 * Si no quisieramos que esto pasase deberiamos crear un nuevo objeto Producto dentro de la funcion, el cual tomara los mismos valores que el original,
	 * modificando lo que necesitariamos y retornandolo, asi ese objeto podriamos guardarlo en un nuevo array o simplemente mostrarlo con el consumer
	 */
	public static void mostrarProductosMayuscula() {
		Function<Producto, Producto> toUpperCase = (p)-> {p.setDescription(p.getDescription().toUpperCase());return p;};
		Consumer<Producto> printConsumerProd = p -> System.out.println(p);
		productos.stream().map(toUpperCase).forEach(printConsumerProd);
		
	}
	
	public static void precargaProductos() {
		productos =new ArrayList<Producto>();
		productos.add(new Producto("1", "Heladera Frozen", 450000.0, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("2", "Taladro 2.0 ", 320000.0, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("3", "Lenovo S145 14' ", 800000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("4", "Iphone 11 pro max", 750000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
		productos.add(new Producto("5", "Xiaomi POCO X3 NFC", 150000.0, OrigenFabricacion.CHINA, Categoria.TELEFONIA, false));
		productos.add(new Producto("6", "Smart TV 32'' ITACHI", 450000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("7", "Microhondas Samsung", 280000.0, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("8", "Lavarropas DREAN ", 750000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("9", "Motorola G60 plus", 180000.0, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, false));
		productos.add(new Producto("10", "Asus M231 16' ", 1000000.0, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("11", "Procesador IntelCore i3", 450000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
		productos.add(new Producto("12", "Secador de pelo GAMA", 80000.0, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("13", "Equipo de sonido SONY M100X", 1000000.0, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("14", "Memoria RAM 8GB ", 80000.0, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto("15", "SSD 480GB Kingston", 46000.0, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		
	}
}
