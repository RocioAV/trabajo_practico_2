package ar.unju.edu.fi.ejercicio5.model;



public class Producto {

	private String codigo;
	private String description;
	private Double precioUnitario;
	private OrigenFabricacion origenFab;
	private Categoria categoria;
	private boolean estado;
	
	//ENUMERADOS 
	public enum OrigenFabricacion{
		ARGENTINA,CHINA,BRASIL,URUGUAY
	}
	public enum Categoria{
		TELEFONIA,INFORMATICA,ELECTROHOGAR,HERRAMIENTAS
	}
	 
	//CONSTRUCTORES
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}


	

	//METODOS ACCESORES	

	public Producto(String codigo, String description, Double precioUnitario, OrigenFabricacion origenFab,
			Categoria categoria, boolean estado) {
		this.codigo = codigo;
		this.description = description;
		this.precioUnitario = precioUnitario;
		this.origenFab = origenFab;
		this.categoria = categoria;
		this.estado = estado;
	}




	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public OrigenFabricacion getOrigenFab() {
		return origenFab;
	}


	public void setOrigenFab(OrigenFabricacion origenFab) {
		this.origenFab = origenFab;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}




	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", description=" + description + ", precioUnitario=" + precioUnitario
				+ ", origenFab=" + origenFab + ", categoria=" + categoria + ", estado=" + estado + "]";
	}


	
}
