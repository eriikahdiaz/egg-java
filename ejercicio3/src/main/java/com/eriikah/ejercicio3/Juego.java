/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eriikah.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author erikah
 */
public class Juego {
    
    int NumeroReintentos = 3;
    public void IniciarJuego() throws IOException {
        System.out.println("Este es un juego de adivinazas");     
        System.out.println("---");
        
        
        
        System.out.println("Jugador 1: Ingrese la palabra para que adivine el Jugador 2"); 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String palabra = br.readLine().strip().toLowerCase();
               
        
        Boolean continuar =  true;
        int Intento = 1;
        
        while (continuar) {   
            
            if (Intento  > NumeroReintentos) {
                System.out.println("Ya llegaste al numero de intento maximo, lo siento amigo!");
                break;                
            }
            Intento+=1;
            
            System.out.println("Que palabra pensas que es?");
            String palabra2 = br.readLine().strip().toLowerCase();;
            if (palabra.equals(palabra2)){
                System.out.println("GANASTE!!!!");
                continuar = false;
              
            } else if ("".equals(palabra2))
            {
                System.out.println("Sos un triste perdedor!!!! Chau!");
                continuar = false;
            }            
            else {
                 System.out.println("Incorrecto amigo! Volve a intentar, si te das por vencido solo presiona ENTER.");
            }                                    
        }
        System.out.println("---"); 
        System.out.println("Presiona una tecla para terminar el juego"); 
        palabra = br.readLine();
        
        
    }
    
}
