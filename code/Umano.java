/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 * Classe che implementa l'interfaccia "Giocatore"; contiene tutti i dati
 * necessari per identificare l'utente giocante e gli permette di inserire
 * le Mosse che vuole fare nel gioco da tastiera.
 *
 */
public class Umano implements Giocatore {
    
    private String Nome;
    
    /**
     * Costruttore della Classe Umano che richiede all'utente di inserire da
     * tastiera il suo nome
     */
    public Umano()
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Inserire nome :");
        Nome=in.nextLine();
    }
    
    /**
     * Costruttore della Classe Umano, che dato come parametro una Stringa, essa
     * verrà messa come valore dell'attributo "Nome"
     * @param s Stringa corrispondente nome del giocatore "Umano"
     */
    public Umano(String s)
    {
        Nome=s;
    }
  
    /**
     * Metodo Get che ritorna il valore dell'attributo "Nome"
     * @return Una Stringa, valore dell'attributo "Nome"
     */
    public String GetNome()
    {
        return Nome;
    }
    /**
     * Metodo che permette di cambiare il valore dell'attributo "Nome" di un oggetto
     * di tipo "Umano" tramite Tastiera
     */
    public void SetNome()
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Inserire nuovo nome :");
        Nome=in.nextLine();
    }
    
    /**
     * Metodo che permette di cambiare il valore dell'attributo "Nome" di un oggetto
     * di tipo "Umano" passandogli il nuovo nome sottoforma di Stringa
     * @param s Stringa con il nuovo nome
     */
    public void SetNome(String s)
    {
        Nome=s;
    }
    

    /**
     * Metodo che chiede all'utente di inserire i dati necessari per creare
     * un oggetto di tipo Mossa(che corrisponde allo scambio che vuole fare sulla
     * griglia)
     * @return Il riferimento all'oggetto di tipo Mossa desiderato dall'utente.
     */
    public Mossa Gioca()
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Inserire riga :");
        int a=in.nextInt();
        
        System.out.print("Inserire Colonna :");
        int b=in.nextInt();
        
        System.out.print("Inserire Direzione 1=Dex 2=Sin 3=Sop 4=Sot :");
        int d=in.nextInt();
        Direzione c;
        switch (d)
        {
             case 1:
            {
               c=Direzione.Destra;
               break;
            }
            case 2:
            {
               c=Direzione.Sinistra;
               break;
            }
            case 3:
            {
               c=Direzione.Sopra;
               break;
            }
            case 4:
            {
               c=Direzione.Sotto;
               break;
            }    
            default:
            {
               System.out.print("\n Hai messo un valore non valido e l'ho sostituito con DESTRA \n");
               c=Direzione.Destra;
               break;
            }
        }
    
        Mossa m=new Mossa(a,b,c);
        return m;
    }
    
    /**
     * toString della classe Umano che stampa lo stato dell'attributo "Nome"
     * @return Il "Nome" dell'utente giocante sttoforma di Stringa
     */
    @Override
    public String toString()
    {
        return Nome;
    }
    
}
