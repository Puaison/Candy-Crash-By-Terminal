/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Random;

/**
 * Classe il cui fine è definire tutte le direzioni che possono essere fatte in
 * una Mossa.
 */
public enum Direzione 
{
    /**
     *Direzione di tipo Sinistra
     */
    Sinistra,

    /**
     *Direzione di tipo Destra
     */
    Destra,

    /**
     *Direzione di tipo Sopra
     */
    Sopra,

    /**
     *Direzione di tipo Sotto
     */
    Sotto;
    
    /**
     *Metodo che restituisce una direzione a caso
     * @return Una Direzione Random
     */
    public static Direzione DirezioneRandom() 
        {
            Random ACaso = new Random();
            return values()[ACaso.nextInt(values().length)];
        }

}


