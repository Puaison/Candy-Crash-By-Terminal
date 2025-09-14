/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Questa classe è la parte più importante dell'intero programma; ha la responsabilità di gestire, 
 * di comunicare con le altri classi e di richiamare i loro metodi nel momento in cui servono.
 */
public class Gioco 
{   
    private Griglia Campo;
    private Giocatore Gamer;
    private int MosseRimanenti;
    private int Punti; 
    private static final int MosseIniziali=5;
    
    /**
     * Costruttore che istanzia un oggetto di tipo gioco(una partita), creando
     * la sua griglia personale e richiedendo il "Giocatore" che vuole affrontare
     * la sfida
     * @param u Riferimento di tipo "Giocatore" che vuole iniziare la partita
     */
    public Gioco(Giocatore u)
    {
        MosseRimanenti=MosseIniziali;
        Punti=0;
        Gamer=u;
        Campo=new Griglia();
    }
    
    /**
     * Metodo che controlla se le mosse della partita sono finite
     * @return Vero se sono terminate le mosse, falso altrimenti
     */
    public boolean Finito()
    {
        if (MosseRimanenti==0)
            return true;
        else
            return false;
    }
    
    /**
     * Metodo che passa un oggetto di tipo Mossa all'oggetto Campo(istanza della Classe Griglia)
     * per sapere se può essere eseguita.
     * @param m Oggetto di tipo Mossa che si vuole eseguire
     * @return Vero se si può eseguire la Mossa, falso altrimenti
     */
    public boolean MossaValida(Mossa m)
    {
        return Campo.MossaPossibile(m);
    }
    /**
     * Metodo che, data una Mossa valida, la esegue e poi vede se si sono create combinazioni;
     * in caso affermativo le esegue(considerando anche quelle concatenate) e salva i punti così fatti
     * @param m Istanza di tipo Mossa da eseguire
     */
    public void FaiMossa(Mossa m)
    {
        MosseRimanenti--;
        Campo.Scambia(m);
        Punti=Punti + Campo.Risolvi();
    }
    
    /**
     * Metodo che chiede all'oggetto "Giocatore" associato a questo "Gioco" che mossa
     * desidera fare
     * @return Riferimento alla Mossa che il Gamer ha scelto.
     */
    public Mossa ChiediMossa()
    {
        return Gamer.Gioca();
    }
    
    /**
     * Metodo che restituisce i punti fatti fino ad ora
     * @return Un intero con i punti della partita 
     */
    public int GetPunti()
    {
        return Punti;
    }
    
    /**
     * Metodo che restituisce le mosse rimanenti del Gioco
     * @return Un intero con le mosse restanti
     */
    public int GetMosseRim()
    {
        return MosseRimanenti;
    }
    
    /**
     * Metodo che, una volta creato un nuovo oggetto di tipo "Gioco", lo prepara per la partita;
     * ovvero esegue tutte le combinazione che si sono create e si creeranno (senza
     * dare punti) finchè non ne è presente più nessuna. Dopodichè la Griglia di
     * questo "Gioco" è pronta.
     */
    public void UniformaCampo()
    {
        Campo.Inizializza();
    }
    
    /**
     * Metodo che restituisce lo stato del Gioco(numero di mosse rimanenti, 
     * punti totalizzati, situazione della Geiglia etc.) sotto forma di stringa
     * @return la stringa con lo stato del Gioco
     */
    @Override
    public String toString()
    {
        String k;
        k="Sta giocando il giocatore: " + Gamer.toString() + "\n";
        k=k+ "Hai totalizzato " + Punti + " fino ad ora \n";
        k=k+ "Ti rimangono " + MosseRimanenti + " mosse prima della fine del gioco \n \n";
        k=k+ Campo.toString(); 
        return k;
    }
    
    /**
     * Metodo che svolge nella sua interezza la fase di gioco.
     */
    public void Run()
    {
        this.UniformaCampo();
        Mossa m;
        System.out.println("\n\n\n INIZIA IL GIOCO \n\n\n");
        System.out.println(this);
        
        while (!this.Finito())
        {
            do
            {
                m=this.ChiediMossa();
            }
            while(!this.MossaValida(m));
            
            this.FaiMossa(m);
            System.out.println(this);
        }
        
        System.out.println("\n\n Gioco Terminato,i tuoi punti sono:" + this.GetPunti() + "\n\n");
    }
    
}


