/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eriikah.ejercicio3;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author erikah
 */
public class Juego {

    private int NumeroReintentos = 3;
    private int VictoriasJugador1 = 0;
    private int VictoriasJugador2 = 0;
    private int Empates = 0;

    public void IniciarJuego() throws IOException {
        System.out.println("Este es un juego de adivinazas");
        System.out.println("---");

        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        boolean ganaJugador1 = false;
        boolean ganaJugador2 = false;
        while (continuar) {

            ganaJugador2 = Jugar(1);
            ganaJugador1 = Jugar(2);
            ComputarPuntaje(ganaJugador1, ganaJugador2);

            System.out.println("Desea continuar? (S/n)");
            String ingresa = leer.nextLine().toLowerCase();
            if (ingresa.equals("n")) {
                continuar = false;
                break;
            }
        }

        MostrarEstadisticas();
        System.out.println("---");
        System.out.println("Presiona una tecla para terminar el juego");
        leer.nextLine();
    }

    public boolean Jugar(int JugadorNumero) {
        System.out.println("Jugador " + JugadorNumero + ": Ingrese su numero asi lo adivina el otro jugador.");

        Scanner leer = new Scanner(System.in);
        int Numero = leer.nextInt();

        Boolean continuar = true;
        int Intento = 1;

        while (continuar) {

            if (Intento > NumeroReintentos) {
                System.out.println("Ya llegaste al numero de intento maximo, lo siento amigo!");
                break;
            }
            Intento += 1;

            System.out.println("Que numero pensas que es?");
            int Numero2 = leer.nextInt();
            if (Numero == Numero2) {
                System.out.println("GANASTE!!!!");
                continuar = false;
                return true;

            } else if (Numero2 > Numero) {
                System.out.println("Te fuiste muy arriba");
            } else if (Numero2 < Numero) {
                System.out.println("Te fuiste muy abajo");
            } else {
                System.out.println("Incorrecto amigo! Volve a intentar.");
            }
        }
        return false;
    }

    public void ComputarPuntaje(boolean ganaJugador1, boolean ganaJugador2) {
        if (ganaJugador1 && ganaJugador2) {
            Empates++;
        }

        if (!ganaJugador1 && !ganaJugador2) {
            Empates++;
        }

        if (ganaJugador1 && !ganaJugador2) {
            VictoriasJugador1++;
        }

        if (!ganaJugador1 && ganaJugador2) {
            VictoriasJugador2++;
        }
    }

    public void MostrarEstadisticas() {
        System.out.println("---");
        System.out.println("Tabla de resultados:");
        System.out.println("Victorias Jugador 1 :" + VictoriasJugador1);
        System.out.println("Victorias Jugador 2 :" + VictoriasJugador2);
        System.out.println("Empates :" + Empates);
        System.out.println("-");
    }

}
