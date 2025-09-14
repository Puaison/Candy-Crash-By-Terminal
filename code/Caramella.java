/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
/**
 *Classe ottenuta per ereditarierà da "Slot", e quindi le sue instanze possono entrare nelle celle
 * di un oggetto di tipo "Griglia"; descrive Caramelle con un propio colore e senza alcun effetto
 */
public class Caramella extends Slot {
    
    private Colori colore;
    
/**
 *Costruttore che genera una caramella di colore randomico
 */
    
    public Caramella(){
        super ();  //Richiamo il costruttore di slot
        colore=Colori.ColoreRandom();
    }
    
 /**
 * Costruttore che genera una caramella con il colore che scegliamo noi
 * @param a Parametro di tipo Colori che si vuole dare alla Caramella 
 */
    
    public Caramella(Colori a){
        super ();  //Richiamo il costruttore di slot
        colore=a;
    }

 /**
 * Metodo che fa scoppiare la caramella rendendola invisibile nella griglia
 * ,cambiando il suo attributo "Pieno" da true a false
 */
    
    @Override
    public void Scoppia(){
        this.SetPieno(false);
    };
 /**Metodo Ereditato dalla Classe astratta "Slot" e che ci dà il tipo di effetto
  * dello Slot (in questo caso Caramella) a cui è applicato
  * @return Restituirà sempre lo stesso Tipo di potere che è quello non fare nulla,
  * poichè le "Caramelle" normali non hanno alcun potere Speciale.
  */
    public Speciale GetTipo()
    {
        return Speciale.Normale;
        
    }
    
 /**
 * Metodo che ritorna una stringa con le informazioni del tipo di "Caramella" in questione
 * @return Una Stringa
 */
    
    @Override
    public String toString(){
        return (" N"+colore);
    };
    
 /**
 * Metodo che restituisce il colore della caramella
 * @return Il colore ("di tipo Colori") della caramella
 */
    
    public Colori GetColore(){return colore;};
    
/**
 * Metodo che sostituisce il colore della caramella
 * @param a Il colore (di tipo "Colori") che si vuole attribuire alla Caramella
 */
    
    public void SetColore(Colori a){this.colore=a;};
}
    
