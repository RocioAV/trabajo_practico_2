package ar.unju.edu.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	
	
}
