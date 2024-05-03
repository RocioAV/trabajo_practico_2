package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		
		FelinoDomestico gato = new FelinoDomestico("Tom", (byte)5, 12.5f);
		 // usamos uso de la interfaz funcional con expresion lambda 
		Converter<FelinoDomestico,FelinoSalvaje> converter = x -> new FelinoSalvaje(gato.getNombre(), gato.getEdad(), gato.getPeso());
		
		FelinoSalvaje felino1 = converter.convert(gato);
		
		converter.mostrarObjeto(felino1);
		
		
		// CONVERSION DE FELINO SALVAJE A FELINO DOMESTICO
		
		FelinoSalvaje felinoS = new FelinoSalvaje("Mufasa", (byte)15, 35.5f);
		//prueba para ver si el iisNotNull funciona
		//FelinoSalvaje felinoS=null 
		Converter <FelinoSalvaje,FelinoDomestico> converter2 = x -> new FelinoDomestico(felinoS.getNombre(), felinoS.getEdad(), felinoS.getPeso());
		
		if (Converter.isNotNull(felinoS)) {
			FelinoDomestico gato2 = converter2.convert(felinoS);
			converter2.mostrarObjeto(gato2);
		}else {
			System.err.println("El objeto a convertir es nulo");
		}

	}

}
