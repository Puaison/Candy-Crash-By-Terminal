/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *Classe ottenuta per ereditarierà da "Slot", e quindi le sue instanze possono entrare nelle celle
 * di un oggetto di tipo "Griglia";
 * descrive Caramelle con un propio colore e con effetti "Speciali"(2 effetti in particolare).
 */
public class CaramellaSpeciale extends Slot 
{
   private Speciale Tipo;
   private Colori Colore;
   
   /**
    * Costruttore della Caramella Speciale
    * @param a Oggetto di tipo Colori(Il colore che si vuole dare alla caramella speciale)
    * @param b Oggetto di tipo Speciale che ci dice quale effetto applicherà questa caramella una volta scoppiata.
    */
   public CaramellaSpeciale(Colori a, Speciale b)
   {
       Tipo=b;
       Colore=a;
   }
   /**
    * Metodo che ritorna il colore della Caramella Speciale a cui è applicato il metodo
    * @return Stato dell'attributo "Colore" di tipo Colori
    */
   public Colori GetColore()
   {
       return Colore;
   }
   
   /**
    * Metodo che ci dice che potere speciale ha la Caramella Speciale a cui è applicata
    * @return Il valore dell'attributo "Tipo", che è un oggetto di tipo "Speciale"
    */
   public Speciale GetTipo()
   {
       return Tipo;
   }
   /**
    * Metodo che ci permette di cambiare l'attributo "Colore" alla Caramella Speciale a cui è applicato
    * @param a Il Colore di tipo "Colori" che voglio mettere
    */
   public void SetColore(Colori a)
   {
       Colore=a;
   }
   
   /**
    * Metodo che ci permette di impostare il potere speciale della Caramella Speciale a cui è applicato
    * @param a Potere speciale di tipo "Speciale"
    */
   public void SetTipo(Speciale a)
   {
       Tipo=a;
   }
   
   
    /**
     * Metodo che fa scoppiare la caramella speciale,cambiando il suo attributo 
     * "pieno" da true a false, e che quindi non sarà più visibile all'interno della
     * cella dell'oggetto di tipo "Griglia" a cui appartiene
     */
    @Override
    public void Scoppia()
    {
        this.SetPieno(false);
    };
   
     /**
     * Metodo che ritorna una stringa che descrive lo stato della caramella speciale
     * @return Una stringa che identifica la caramella speciale per colore e specialità
     */
    @Override
    public String toString()
    {
        String s;
        switch(Tipo)
        {
            case StrisceVerticali:
            {
                s=" |";
                break;
            }
            case StrisceOrizzontali:
            {
                s=" =";
                break;
            }
            default:
            {
                   s=" ERRORE";  
            }
        }
        
        
        return (s+Colore);
    };
}
