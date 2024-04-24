package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53291.0),SALTA(1440672,155488.0),TUCUMÁN(1731820,22524.0),CATAMARCA(429562,102602.0),LARIOJA(383865,89680.0),SANTIAGODELESTERO(1060906,136351.0);
	
	private int CANT_POBLACION;
	private Double SUPERFICIE;
	
	private Provincia(int CANT_POBLACION, Double SUPERFICIE) {
		this.CANT_POBLACION= CANT_POBLACION;
		this.SUPERFICIE=SUPERFICIE;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	public int getCANT_POBLACION() {
		return CANT_POBLACION;
	}
	public void setCANT_POBLACION(int cANT_POBLACION) {
		CANT_POBLACION = cANT_POBLACION;
	}
	public Double getSUPERFICIE() {
		return SUPERFICIE;
	}
	public void setSUPERFICIE(Double sUPERFICIE) {
		SUPERFICIE = sUPERFICIE;
	}
	
	
	public Double densidadPoblacion() {
		return this.CANT_POBLACION/this.SUPERFICIE;
	}
	
}
