/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Classe il cui fine è quello di generalizzare tutti gli oggetti e componenti 
 * che possono essere messi all'interno di una cella della matrice della Griglia
 * (POLIMORFISMO)
 */
public abstract class Slot {
    
/**
 * Attributo boleano che indica se l'oggetto all'interno di una cella di una 
 * griglia è da considerarsi presente (Pieno=true) oppure da rimuovere
 * (Pieno=false, che corripsonde alla condizione di cella rimasta "vuota")
 */ 
    protected boolean Pieno;
    
 /**
  * Costruttore che inizializza l'attribbuto "Pieno=true" dell'oggetto appena 
  * creato in una cella di una "Griglia"
 */
    
    public Slot(){
        Pieno=true;
    }
    
 /**
  * Metodo che restituise il valore booleano dell'attributo "Pieno"
  * (che ci dice se lo "Slot" è da considerarsi ancora presente nella Cella oppure no)
  * @return Lo stato dell'attributo "Pieno"
 */
    
    public boolean GetPieno(){
        return Pieno;
    }
    
 /**
  * Metodo che cambia lo stato di presenza dello "Slot"
  * @param a Booleano da assegnare all'attributo Pieno
 */
    
    public void SetPieno(boolean a){Pieno=a;}
    
 /**
  * Metodo astratto che cambia lo stato dello "Slot" quando questo viene fatto 
  * "Esplodere" all'interno della Griglia
 */
    
    public abstract void Scoppia();
    
 /**
  * Metodo astratto che restituisce una stringa che
  * descrive lo stato dello "Slot"
  * @return La Stringa definita nelle classi che slot generalizza
 */
    
    public abstract String toString();
    
    /**
     * Metodo astratto che restituisce il Tipo speciale dell'Oggetto "Slot" a cui è applicato
     * @return un enum di tipo "Speciale" che di dice l'effetto di quello "Slot"
     */

    public abstract Speciale GetTipo();
    
     /**
     * Metodo che restituisce il Colore dell'Oggetto a cui è applicato
     * @return un enum di tipo "Colori"
     */
    public abstract Colori GetColore();
    
}
