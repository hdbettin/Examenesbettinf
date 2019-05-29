/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes.preguntas;

import java.util.Arrays;
import java.util.List;
import examenes.Pregunta;


/**
 *
 * @author Usuario
 */
public class PreguntaBoleana extends Pregunta{
    public PreguntaBoleana(String texto, String respuestaCorrecta) {
		super(texto, respuestaCorrecta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> opcionesValidas() {
		// TODO Auto-generated method stub
		return Arrays.asList("verdadero", "falso");
	}

	@Override
	public double calificacion(String respuesta) {
		// TODO Auto-generated method stub
		if (getRespuestaCorrecta().equals(respuesta) && opcionesValidas().contains(respuesta))
			return 1;
		else
			return -1;
	}
}
