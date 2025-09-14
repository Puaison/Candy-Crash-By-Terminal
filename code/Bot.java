/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *Classe che implementa l'interfaccia "Giocatore"; nel momento in cui un oggetto della Classe
 * "Gioco" chiederà a un oggetto di questa classe di fare una Mossa, essò la farà randomicamente.
 */
public class Bot implements Giocatore
{ 
    /**
     * Costruttore della classe Bot(non avendo attributi istanzia soltanto un
     * nuovo oggetto di tipo "Bot")
     */
    public Bot()
    {

    }
    /**
     * Metodo che restituisce il nome di un oggetto di questa classe. Essendo il nome
     * dei bot uguali per tutti, restiuirà sempre la stessa Stringa.
     * @return Stringa ("Bot")
     */
    public String GetNome()
    {
        return "Bot";
    }
    /**
     * Metodo che genera un'istanza della Classe Mossa totalmente a caso(tenendo presente la grandezza della griglia)
     * @return Riferimento a questa "Mossa" casuale
     */
    public Mossa Gioca()
    {
        
        Random ACaso=new Random();
        int a=ACaso.nextInt(Griglia.GetDimensioneGlobal());
        int b=ACaso.nextInt(Griglia.GetDimensioneGlobal());
        Direzione c=Direzione.DirezioneRandom();        

        System.out.print("\nSto facendo la mossa: " + a + "  " + b +"  "+ c + "\n");
        Mossa m=new Mossa(a,b,c);
        return m;
    }
    /**
     * Metodo che ritorna il nome del bot(uguale per qualsiasi oggetto di questa classe)
     * @return Sempre la stessa Stringa : "Bot"
     */
    @Override
    public String toString()
    {
        return "Bot";
    }
    
}
    

