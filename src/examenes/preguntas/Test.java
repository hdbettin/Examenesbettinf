/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes.preguntas;

import java.util.ArrayList;
import java.util.List;
import examenes.Pregunta;

/**
 *
 * @author Usuario
 */
public class Test extends Pregunta{
    
    private int numOpciones;

	public Test(String texto, String respuestaCorrecta, int numOpciones) {
		super(texto, respuestaCorrecta);
		// TODO Auto-generated constructor stub
		this.numOpciones = numOpciones;
	}

	@Override
	public double calificacion(String respuesta) {
		// TODO Auto-generated method stub
		if (opcionesValidas().contains(respuesta) && getRespuestaCorrecta().equals(respuesta))
			return 1;
		else
			return -(1 / numOpciones);
	}

	@Override
	public List<String> opcionesValidas() {
		// TODO Auto-generated method stub
		ArrayList<String> opciones = new ArrayList<String>();
		for (int i = 0; i < numOpciones; i++)
			opciones.add("" + ((char) ('a' + i)));
		return opciones;
	}

    
}
