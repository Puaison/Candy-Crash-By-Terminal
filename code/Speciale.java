/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * Classe il cui fine è definire le azioni che ogni singolo Slot potrebbe fare
 */
public enum Speciale 
{
    /**
     * Slot senza nessun effetto(rappresentato sul terminale da N)
     */
    Normale,
    /**
     * Slot che "Scoppia", al momento del suo Scoppio, tutti gli Slot nella sua
     * stessa colonna(rappresentato sul terminale da |)
     */
    StrisceVerticali,
    /**
     * Slot che "Scoppia", al momento del suo Scoppio, tutti gli Slot nella sua
     * stessa riga(rappresentato sul terminale da =)
     */
    StrisceOrizzontali;
    
}
