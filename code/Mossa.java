/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Classe che descrive la Mossa che un oggetto di una classe generica che implementa l'interfaccia
 * "Giocatore" vuole eseguire all'interno del gioco
 *
 */
public class Mossa {
    private int Riga;
    private int Colonna;
    private Direzione Verso;


    /**
     * Costtuttore dell'oggetto di tipo Mossa, che ha bisogno di due interi
     * (indice di riga e colonna dello Slot da Muovere) e una Direzione
     * (che sarebbe il verso in cui si vuole muovere lo Slot selezionato)
     * @param a Intero(indice della riga)
     * @param b Intero(indice della colonna)
     * @param c Direzione
     */
    public Mossa(int a, int b,Direzione c)
    {
        this.Riga=a;
        this.Colonna=b;
        this.Verso=c;
    }

    /**
     * Metodo Get che ci dà il valore dell'attributo "Riga" dell'oggetto Mossa
     * in questione
     * @return Intero(indice della riga della Mossa)
     */
    public int GetRiga()
    {
        return this.Riga;
    }

    /**
     * Metodo Get che ci dà il valore dell'attributo "Colonna" dell'oggetto Mossa
     * in questione
     * @return Intero(indice della colonna della Mossa)
     */
    public int GetColonna()
    {
        return this.Colonna;
    }

    /**
     * Metodo Get che ci dà il valore dell'attributo "Verso" dell'oggetto Mossa
     * in questione
     * @return Riferimento di tipo Direzione
     */
    public Direzione GetVerso()
    {
        return this.Verso;
    }

}
