/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 * Progetto fine alla riproduzione di una partita di Candy Crush;
 * Programmatori:
 * Luca Del Signore,
 * Alessio Perozzi
 */
public class ProgettoOggetti2019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        int i=3;
        boolean Chi=false;
        
            Scanner in=new Scanner(System.in);
            System.out.println("Selezionare 1 per giocatore umano\nSelezionare 0 per un Bot");

            
            while (i!=1 && i!=0)
            {
                i=in.nextInt();
                if (i==1)
                    Chi=true;
                if (i==0)
                    Chi=false;
            }
        Giocatore g;
        if(Chi)
            g=new Umano();
        else
            g=new Bot();
        
        Gioco Test=new Gioco(g);
        Test.Run();        
     
    }
}
