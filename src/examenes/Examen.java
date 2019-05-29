/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Examen {

	// private int identificador;
	private EnunciadoExamen enunciado;
	private Map<Pregunta, String> respuestas;

	public Examen(EnunciadoExamen enunciado) {
		this.enunciado = enunciado;
		respuestas = new HashMap<Pregunta, String>();
	}

	public EnunciadoExamen getEnunciado() {
		return enunciado;
	}

	public boolean responder(int numPregunta, String respuesta) {
		Pregunta p = enunciado.obtenerPregunta(numPregunta);
		if (p != null) {
			respuestas.put(p, respuesta);
			return true;
		} else
			return false;
	}

	public double obtenerNotaPregunta(int indicePregunta) {
		Pregunta p = enunciado.obtenerPregunta(indicePregunta);
		if ((p != null) && respuestas.containsKey(p))
			return p.calificacion(respuestas.get(p));
		else
			return 0;
	}

	public double corregir() {
		double acumCalificaciones = 0;
		int acumPreguntasValidas = 0;
		Pregunta p;
		for (int i = 0; i < respuestas.size(); i++) {
			p = enunciado.obtenerPregunta(i);
			if ((p != null) && respuestas.containsKey(p)) {
				acumCalificaciones += obtenerNotaPregunta(i);
				acumPreguntasValidas++;
			}
		}
		return 10 * (acumCalificaciones / acumPreguntasValidas);
	}
    
}
