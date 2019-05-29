/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes;

import java.util.List;

/**
 *
 * @author Usuario
 */
public abstract class Pregunta implements Comparable<Pregunta>{
    private String texto;
	private String respuestaCorrecta;
	private int dificultad;

	public Pregunta(String texto, String respuestaCorrecta) {
		this.texto = texto;
		this.respuestaCorrecta = respuestaCorrecta;
		dificultad = 0;
	}

	public final String getTexto() {
		return texto;
	}

	public final String getRespuestaCorrecta() {
		return respuestaCorrecta;
	}

	public final int getDificultad() {
		return dificultad;
	}

	public final void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	public abstract List<String> opcionesValidas();

	public abstract double calificacion(String respuesta);

	@Override
	public String toString() {
		return "Pregunta [texto=" + texto + ", dificultad=" + dificultad + ", opcionesValidas=" + opcionesValidas()
				+ "]";
	}

	@Override
	public int compareTo(Pregunta o) {
		// TODO Auto-generated method stub
		if (dificultad == o.getDificultad()) {
			return texto.compareTo(o.getTexto());
			// return texto.compareToIgnoreCase(o.getTexto());
			// return Collator.getInstance().compare(texto, o.getTexto());
		} else {
			if (dificultad > o.getDificultad())
				return 1;
			else
				return -1;
		}
	}
}
