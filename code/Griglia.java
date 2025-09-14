/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 * Classe le cui istanze sono rappresentate da matrici,
 * le cui celle sono occupate da oggetti di tipo "Slot"
 */
public class Griglia {
    
    private static final int Dimensione=10;
    private static final int Valore=10;
    private ArrayList<ArrayList<Slot>> Griglia; 
    
    
    
    /**
     * Metodo globale che ci da la dimensione della matrice di una generica "Griglia"(quadrata)
     * che questa classe istanzia
     * @return Un intero(ovvero la dimensione delle griglie)
     */
    public static int GetDimensioneGlobal()
    {
        return Dimensione;
    }
    
    /**
     * Costruttore che istanzia una nuova Griglia, generando in tutte
     * le sue celle Caramelle Normali di colori Randomici
     */
    
    public Griglia()
    {    
        
        Griglia=new ArrayList<ArrayList<Slot>>();
        ArrayList<Slot> A;
        for(int i=0;i<Dimensione;i++)
        {
            Griglia.add(new ArrayList<Slot>());
            A=Griglia.get(i);
            for(int j=0;j<Dimensione;j++)
               A.add(new Caramella());
        }
    }
    
    
    /**
     * Metodo che ci da la dimensione della griglia(quadrata)
     * @return Un intero(ovvero la dimensione della griglia)
     */
    
    public int GetDimensione()
    {
        return Dimensione;
    }
    
    
    /**
     * Metodo che restituisce il riferimento a Slot nella posizione richiesta
     * @param a intero che indica la riga in cui si trova lo Slot richiesto
     * @param b intero che indica la colonna in cui si trova lo Slot richiesto
     * @return Il riferimento allo Slot trovato nella posizione richiesta
     */
    
    
    private Slot Get(int a,int b)
    {
    
        ArrayList<Slot> e=Griglia.get(b);
        Slot c= e.get(a);
        return c;    
    }
    
    /**
     * Questo metodo restituisce il riferimento ad uno Slot passando un oggetto di tipo 
     * "Mossa"(usando però soltanto le coordinate della caramella che si intende muovere)
     * @param m Il riferimento di un oggetto di tipo Mossa
     * @return Il riferimento allo Slot
     */
    private Slot Get(Mossa m)
    {
        int a=m.GetRiga();
        int b=m.GetColonna();
        
        ArrayList<Slot> e=Griglia.get(b);
        
        Slot c = e.get(a);
        return c;    
    }
    
    /**
     * Metodo che dato il riferimento ad uno Slot che si trova NECESSARIAMENTE
     * all'interno di una cella della Griglia, ci restituisce l'indice della riga dove si trova.
     * @param S Riferimento a Slot
     * @return La riga dove si trova il riferimento
     */
    private int GetRiga(Slot S)
    {
        boolean Trovato=false;
        int k=-1;
        for(int i=0;(!Trovato) && i< Dimensione ;i++)                                       
            for(int j=0;(!Trovato) && j< Dimensione;j++ ) 
                if (S==this.Get(i, j))
                {
                    k=i;
                    Trovato=true;
                }
        return k;
    }
    
    
    
    /**
     * Metodo che dato il riferimento ad uno Slot che si trova NECESSARIAMENTE
     * all'interno di una cella della Griglia, ci restituisce l'indice della colonna dove si trova.
     * @param S Riferimento a Slot
     * @return La colonna dove si trova il riferimento
     */
    private int GetColonna(Slot S)
    {
        boolean Trovato=false;
        int k=-1;
        for(int i=0;(!Trovato) && i< Dimensione ;i++)                                       
            for(int j=0;(!Trovato) && j< Dimensione;j++ ) 
                if (S==this.Get(i, j))
                {
                    k=j;
                    Trovato=true;
                }
        return k;
    }
    
    /**
     * Metodo che inserisce in posizione data il riferimento allo 
     * Slot dato, sostituendolo a ciò che c'era prima
     * 
     * @param a Intero che indica l'indice della riga di inserimento
     * @param b Intero che indica l'indice della colonna di inserimento
     * @param c Oggetto di tipo Slot da inserire nella Griglia
     */
    private void Set(int a,int b,Slot c)
    {
        ArrayList<Slot> e=Griglia.get(b);
        e.set(a,c);
        
    }
    
    
    /**
     * Metodo che prende dall'oggetto di tipo Mossa le coordinate nella griglia 
     * e mette in quel posto un nuovo riferimento a Slot che viene passatto al metodo
     * @param m Oggetto di tipo Mossa da cui prendiamo le coordinate
     * @param c Oggetto di tipo Slot che vogliamo mettere nella griglia
     */
    private void Set(Mossa m,Slot c)
    {
        int a=m.GetRiga();
        int b=m.GetColonna();
        
        ArrayList<Slot> e=Griglia.get(b);
        e.set(a,c);
        
    }
    
    /**
     * Metodo toString associato alla Griglia che ci fa vedere(sottofroma di Stringa)
     * gli "Slot" che ogni cella della mattrice possiede
     * @return La stringa contenente lo stato della Griglia
     */
    
    @Override
    public String toString(){
        
        Slot c;
        String k="";
        
       for(int i=Dimensione-1;i>=0;i--)
       {
           k=k+"  "+i+"  ";
           for(int j=0;j<10;j++)
           {   
                 c=this.Get(i,j);
                 
                 if(c.GetPieno())
                   k= k + c.toString();
                 else
                   k= k + "   ";
           }
        
           k=k+"\n";
       }
       k=k + "\n     ";                                          //+"      0 1 2 3 4 5 6 7 8 9";
       for(int i=0;i<Dimensione;i++)
           k=k+"  "+i;
       return k;
    }
    
    
    /**
     * Metodo che controlla se all'interno della Griglia ci sono combinazioni,
     * e in caso le rimuove(rendendo invisibili gli "Slot" che compongono le combinazioni)
     * tenendo anche presente Slot con poteri Speciali;
     * dopodichè ci vengono restituiti i punti così totalizzati
     * @return Un intero con i punti derivanti dalle combinazioni degli "Slot"
     */
    private int Scoppiatutto(){
        
        int Contatore;
        int Punti=0;
        
        for(int i=0;i< Dimensione ;i++)                                         //Scansione delle righe
            for(int j=0;j< Dimensione -2;j++ ){                                 //Scansione delle celle fino a lunghezza -2
                Contatore=1;                                                    //Ripristino il contatore a 1
                while ((j<Dimensione-1) && (this.Get(i,j).GetColore() == this.Get(i,j+1).GetColore()))//Controllo della successiva
                {
                    Contatore++;                                                   //Contatore caramelle in fila fino ad ora
                    j++;                                                           //aumento j
                }
                
                if (Contatore==3)                                               //se ho almeno 3 caramelle in fila
                {
                    for(int k=Contatore-1;k>=0;k--)                             //e per le "contatore-1" caramelle precedenti
                    {
                        if(this.Get(i,j-k).GetPieno())                          //se lo slot è pieno
                        {
                            Punti=Punti+this.ScoppiaCaramelle(this.Get(i,j-k)); 
                        }
                    }          
                }
                if (Contatore>3)                                               //se più di 3 caramelle in fila
                {
                    for(int k=Contatore-1;k>=0;k--)                             //e per le "contatore-1" caramelle precedenti
                    {
                        if(this.Get(i,j-k).GetPieno())                          //se lo slot è pieno
                        {
                            Punti=Punti+this.ScoppiaCaramelle(this.Get(i, j-k));                                 //lo rendo vuoto e aumento i punti
                            
                        }
                        if (k==0)
                        {
                            CaramellaSpeciale z=new CaramellaSpeciale(this.Get(i,j).GetColore(),Speciale.StrisceOrizzontali);
                            this.Set(i, j, z);
                        }
                    }          
                }
                
            }  
        
        for(int j=0;j< Dimensione ;j++)                                         //Scansione delle colonne
            for(int i=0;i< Dimensione -2;i++ ){                                 //Scansione delle celle fino a lunghezza -2
                Contatore=1;                                                    //Ripristino il contatore a 1
                while ((i<Dimensione-1) && (this.Get(i,j).GetColore() == this.Get(i+1,j).GetColore()))//Controllo della successiva
                {
                    Contatore++;                                                   //Contatore caramelle in fila fino ad ora
                    i++;                                                           //aumento i
                }
                if (Contatore==3)                                               //se ho 3 caramelle in fila
                {
                    for(int k=Contatore-1;k>=0;k--)                             //e per le "contatore-1" caramelle precedenti
                    {
                        if(this.Get(i-k,j).GetPieno())                          //se lo slot è pieno
                        {
                            Punti=Punti+this.ScoppiaCaramelle(this.Get(i-k,j)); 
                        }
                    }          
                }
                if (Contatore>3)                                               //se più di 3 caramelle in fila
                {
                    for(int k=Contatore-1;k>=0;k--)                             //e per le "contatore-1" caramelle precedenti
                    {
                        if(this.Get(i-k,j).GetPieno())                          //se lo slot è pieno
                        {
                            Punti=Punti+this.ScoppiaCaramelle(this.Get(i-k,j));                                 //lo rendo vuoto e aumento i punti
                            
                        }
                        if (k==0)
                        {
                            CaramellaSpeciale z=new CaramellaSpeciale(this.Get(i,j).GetColore(),Speciale.StrisceVerticali);
                            this.Set(i, j, z);
                        }
                    }          
                }
            }
        return Punti;
    }
   
    /**
     * Metodo che controlla se ci sono celle della Griglia con "Slot" invisibili(Pieno=false),
     * li rimuove e lo spazio lasciato libero viene occupato dagli "Slot" sovrastanti ancora visibili.
     * Ogni volta che rimuoviamo uno "Slot", viene anche generata in cima alla colonna di
     * appartenenza dello Slot appena rimosso una nuova Caramella Normale
     */
    private void RiempiBuchi()
    {
        ArrayList<Slot> e= new ArrayList<Slot>();
        for(int j=0;j<Dimensione;j++)                                           //Per ogni Colonna
           {
        
                for(int i=0;i<Dimensione;i++)                                   //Scorro le righe a partire dal basso
                {
           
                    if(! this.Get(i,j).GetPieno())                              //Nel caso di una vuota
                    {
                        while(! this.Get(i,j).GetPieno())                       //E finchè continua a essere vuota(a causa dello scorrimento di arraylist)
                        {
                            e=Griglia.get(j);
                            e.remove(i);                              //Rimuovi l'elemento all'indice (i,j)
                            e.add((Dimensione-1),new Caramella());    //E genera una caramella in cima alla griglia nella colonna in cui sto operando
                        }
                    }
                 }   
           }
    }
    
    /**
     * Metodo che continua a far scoppiare e riempire gli Slot della griglia 
     * finchè non ci sono più abbinamenti(senza calcolare il punteggio conseguito).
     * Questo metodo serve per prepare l'oggetto "Griglia" in modo tale che 
     * all'inizio di una partita non ci siano già combinazioni
     */
    public void Inizializza()
    {
        int Punti;
        
        do
        {
            Punti=0;
            Punti=this.Scoppiatutto(); 
            this.RiempiBuchi();
        }
        while(Punti!=0);
        System.gc();
    }

    
    /**
     * Metodo che dato un Oggetto di tipo Mossa controlla se è una Mossa possibile
     * all'interno dell'oggetto di tipo "Griglia" a cui è applicato
     * @param m Oggetto di tipo Mossa
     * @return Vero se la Mossa è valida, Falso altrimenti
     */
    public boolean MossaPossibile(Mossa m)
    {
    
        int c=m.GetColonna();
        int r=m.GetRiga();
        Direzione d=m.GetVerso();
        
        if ( (c > (Dimensione-1)) || (c <0) || (r > (Dimensione-1)) || (r <0))
            return false;
        
        switch (m.GetVerso())
        {
            case Destra:
            {
                if (c==Dimensione-1)
                    return false;
                break;
            }
            case Sinistra:
            {
                if (c==0)
                    return false;
                break;
            }
            case Sopra:
            {
                if (r==Dimensione-1)
                    return false;
                break;
            }
            case Sotto:
            {
                if (r==0)
                    return false;
                break;
            }   
        }
        return true;
    }
    
    /**
     * Metodo che data la Mossa che si vuole eseguire(dopo aver controllato la sua validità),
     * muove lo Slot nella posizione indicata dalla Mossa nella direzione desiderata.
     * Il suo spazio lasciato vuoto viene riempito dallo Slot presente nella 
     * posizione che ha appena occupato
     * @param m L'oggetto di tipo mossa che si vuole eseguire
     */
    
    public void Scambia(Mossa m)
    {
        int a=m.GetRiga();
        int b=m.GetColonna();
        int c=0;
        int d=0;
          
        switch (m.GetVerso())
        {
            case Destra:
            {
               c=a;
               d=b +1;
               break;
            }
            case Sinistra:
            {
               c=a;
               d=b -1;
               break;
            }
            case Sopra:
            {
               c=a+1;
               d=b;
               break;
            }
            case Sotto:
            {
               c=a-1;
               d=b;
               break;
            }    
        }
            
        Slot S;
        S=this.Get(a, b);
        this.Set(a, b, this.Get(c, d));
        this.Set(c, d, S);
    }
   
    /**
     * Metodo che si occupa di verificare di che tipo è uno Slot e se è ancora 
     * visibile all'interno della cella della Griglia. In caso affermativo cambia il suo stato,fa
     * eseguire la mossa speciale ad esso associata(se è una caramella speciale) e
     * ci da il punteggio derivante dall'esecuzione dal suo scoppio( e in caso anche
     * dal suo effetto)
     * @param S Slot in una combinazione che si vuole scoppiare
     * @return Un intero che ci da il punteggio totalizzato grazie allo scoppio di 
     * quello Slot
     */
    private int ScoppiaCaramelle(Slot S)
    {
        int v=0;
        Speciale Tipo=S.GetTipo();
        switch (Tipo)
        {
            case Normale:
            {
                if (S.GetPieno())
                    v=Valore;
                S.Scoppia();
                return v;
            }
            case StrisceOrizzontali:
            {
                if (S.GetPieno())
                    v=Valore;
                else break;
                
                S.Scoppia();
                
                int i=this.GetRiga(S);
                    for(int j=0;j<Dimensione;j++)
                        v=v+this.ScoppiaCaramelle(this.Get(i, j));             
            }
            case StrisceVerticali:
            {
                if (S.GetPieno())
                    v=Valore;
                else break;
                
                S.Scoppia();
                
                int j=this.GetColonna(S);
                    for(int i=0;i<Dimensione;i++)
                        v=v+this.ScoppiaCaramelle(this.Get(i, j));             
            }
                
        }
        return v;
    }
    /**Metodo che esegue le esplosioni delle combinazioni e i riempimenti 
     * all'interno della Griglia in modo iterativo(considerando le reazioni a catena)
     * finchè non c'è più nulla da esplodere, e ci ridà i punti così generati
     * @return Punti totalizzati
     */
     
    public int Risolvi()
    {
        int PuntiTot=0;
        int Punti;
        
        do
        {
            Punti=0;
            Punti=this.Scoppiatutto();
            
            if (Punti!=0)
            {
            System.out.println("\n Dopo lo Scoppio");
            System.out.println(this.toString());
            try {
                Thread.sleep(1000); // aspetta 1 secondo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            this.RiempiBuchi();
            PuntiTot=PuntiTot+Punti;
            System.out.println("\n \nPunti in questa iterazione: " + Punti + "\n\n");
            
            System.out.println(this.toString());
            System.out.println("\n Dopo il riempimento");
            try {
                Thread.sleep(1000); // aspetta 1 secondo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
        while(Punti!=0);
        
        System.gc();
        return PuntiTot;
    }
    
     /**
     * Metodo Creato per Debugging, Rimuovere
     * @return Una Stringa
     
    public String TestString(){
        
        Slot c;
        String k="";
        
       for(int i=0;i<Dimensione;i++)
       {
           for(int j=0;j<10;j++)
           {   
                 c=this.Get(i,j);
                 
                 if(c.GetPieno())
                   k= k + c.toString();
                 else
                   k= k + "   ";
           }
        
           k=k+"\n";
       }
        return k;
    }*/
    
    
    
/*    public boolean CiSonoMosse(){
        
//        SCANNERIZZO LA GRIGLIA E FACCIO OGNI POSSIBILE SCAMBIO,PER OGNI SCAMBIO
//      CONTROLLO CON L'ALGORITMO SOTTO SE CI SONO COMBINAZIONI
       
        
        
        boolean Mosse=false;
        int Contatore;
        for(int i=0;i< Dimensione ;i++)                                         //Scansione delle righe
            for(int j=0;j< Dimensione -2;j++ ){                                 //Scansione delle celle fino a lunghezza -2
                Contatore=1;                                                    //Ripristino il contatore a 1
                while ((j<Dimensione-1) && (this.Get(i,j).GetColore() == this.Get(i,j+1).GetColore()))//Controllo della successiva
                {
                 Contatore++;                                                   //Contatore caramelle in fila fino ad ora
                 j++;                                                           //aumento j
                }
                if (Contatore>=3)                                               //se ho almeno 3 caramelle in fila
                    Mosse=true;                                                 //C'è ALMENO una mossa valida
            }  
        
        for(int j=0;j< Dimensione ;j++)                                         //Scansione delle colonne
            for(int i=0;i< Dimensione -2;i++ ){                                 //Scansione delle celle fino a lunghezza -2
                Contatore=1;                                                    //Ripristino il contatore a 1
                while ((i<Dimensione-1) && (this.Get(i,j).GetColore() == this.Get(i+1,j).GetColore()))//Controllo della successiva
                {
                 Contatore++;                                                   //Contatore caramelle in fila fino ad ora
                 i++;                                                           //aumento i
                }
                if (Contatore>=3)                                               //se ho almeno 3 caramelle in fila
                    Mosse=true;                                                 //C'è ALMENO una mossa valida
                
            }  
        return Mosse;
    }
*/

    /**
     *Metodo che rimischia gli oggetti nella Griglia senza sostituirli
     

    public void Rimischiati()
    {
        LinkedList<Slot> L=new LinkedList<>() ;
        Slot c;
        
        for(int i=Dimensione-1;i>=0;i--)
       {
           for(int j=0;j<10;j++)
           {   
                 c=this.Get(i,j);
                 L.add(c);
           }
       }

        Collections.shuffle(L);
        
        for(int i=0;i<Dimensione;i++)
        {
            for(int j=0;j<Dimensione;j++)
            {
                this.Set(i,j,L.getFirst());
                L.pop();
            }
        }
    }*/
    
}
