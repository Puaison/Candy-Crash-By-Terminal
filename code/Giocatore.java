/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Interfaccia i cui oggetti delle classi che la implementano possono eseguire 
 * i metodi che vengono richiesti da un oggetto della classe "Gioco"(POLIMORFISMO). 
 * Concettualmente, ogni Classe che la realizza implementa il metodo "Gioca()" in modo diverso
 */
public interface Giocatore 
{   
    /**
     * Metodo che restituisce il nome del "Giocatore"
     * @return Una stringa con il nome del "Giocatore"
     */
    String GetNome();
    
    /**
     * Metodo che restituisce un oggetto di tipo "Mossa" decisa dal "Giocatore"
     * @return La Mossa proposta dal "Giocatore" corrente
     */
    Mossa Gioca();  
    
    /**
     * Metodo che restituisce i dati del "Giocatore"
     * @return Una Stringa con le informazioni necessarie
     */
    String toString();
}
