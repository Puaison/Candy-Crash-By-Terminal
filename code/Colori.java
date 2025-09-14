/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;

/**
 * Classe il cui fine è definire il tipo di colori da attribuire agli oggetti nella matrice della griglia
 */
public enum Colori {

    /**
     *Colore di tipo Rosso
     */
    R,

    /**
     *Colore di tipo Verde
     */
    V,

    /**
     *Colore di tipo Blu
     */
    B,

    /**
     *Colore di tipo Giallo
     */
    G;

        /**
         * Metodo che genera un "Colori" randomicamente
         * @return Il colore casuale creato
         */
        
        public static Colori ColoreRandom() 
        {
            Random ACaso = new Random();
            return values()[ACaso.nextInt(values().length)];
        }
    }
