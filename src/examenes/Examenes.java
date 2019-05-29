/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import examenes.preguntas.Test;
import examenes.preguntas.PreguntaBoleana;
import examenes.preguntas.OpcionesMultiples;
/**
 *
 * @author Usuario
 */
public class Examenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EnunciadoExamen enunciado1;
		if (args.length > 0) {
			System.out.println(args[0]);
			enunciado1 = new EnunciadoExamen(args[0]);
		} else {
			System.out.println("Examen");
			enunciado1 = new EnunciadoExamen("Examen");
		}
		System.out.println();
		Pregunta p1 = new Test("Â¿CuÃ¡l es el valor decimal del nÃºmero binario 0010?\n a. 1, b. 2, c. 3", "b", 3);
		p1.setDificultad(1);
		enunciado1.agregarPregunta(p1);
		Pregunta p2 = new OpcionesMultiples("Â¿CuÃ¡les son protocolos de URL?\n a. http, b. ftp, c. coco", "a b", 3);
		enunciado1.agregarPregunta(p2);
		Pregunta p3 = new PreguntaBoleana("Â¿Un byte equivale a 16 bits?", "falso");
		enunciado1.agregarPregunta(p3);
		enunciado1.ordenar();
		Examen examen = new Examen(enunciado1);
		Scanner teclas = new Scanner(System.in);
		List<Pregunta> pgs = examen.getEnunciado().getPreguntas();
		ArrayList<String> respuestas = new ArrayList<String>();
		for (int i = 0; i < pgs.size(); i++) {
			System.out.println((i + 1) + "- " + pgs.get(i).getTexto());
			System.out.print("Opciones validas = ");
			System.out.println(pgs.get(i).opcionesValidas());
			respuestas.add(teclas.nextLine());
			if (respuestas.get(i) != null)
				examen.responder(i, respuestas.get(i));
			System.out.println();
		}
		for (int j = 0; j < respuestas.size(); j++) {
			if (respuestas.get(j).isEmpty()) {
				String r;
				do {
					System.out.println("Â¿Deseas responder otra vez la pregunta " + (j + 1) + "?");
					r = teclas.nextLine();
				} while (!r.equals("y") && !r.equals("n"));
				if (r.equals("y")) {
					System.out.println();
					System.out.println((j + 1) + "- " + pgs.get(j).getTexto());
					System.out.print("Opciones validas = ");
					System.out.println(pgs.get(j).opcionesValidas());
					respuestas.set(j, teclas.nextLine());
					if (respuestas.get(j) != null)
						examen.responder(j, respuestas.get(j));
					System.out.println();
				}

			}
		}
		System.out.println("nota final: " + examen.corregir());
		teclas.close();
    }
    
}
