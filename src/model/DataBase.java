package model;

import java.time.LocalDate;
import java.util.*;
import java.util.ListIterator;


public class DataBase {
	
    //Arreglo para almacenar jugadores
   public List<Player> jugadores;
   
    //Arreglo para almacenar Equipos
   public List<Team> equipos;
   
   
    public void init(){
        this.jugadores = new ArrayList<>();
        this.equipos   = new ArrayList<>();
    }

    
//KD
    public void save(Storable e){
        boolean resultado = true;
    	
        if(e instanceof Player)
        {   //resultado = findById() ;
            if ( jugadores.isEmpty() ) 
               this.jugadores.add((Player)e);  // KD
            else if ( findById( ((Player) e).getName()) == false )  //KD
                 this.jugadores.add((Player)e);  //KD
        }else if(e instanceof Team){
            this.equipos.add((Team)e);
        }
    }

    
    public void saveAll(List<Storable> e){
        for(Storable current : e){
            save((Storable) current);
        }
    }

    public void remove(Storable e){
        if (e instanceof Player){
            this.jugadores.remove((Player)e);
        }else if(e instanceof Team){
            this.equipos.remove((Team)e);
        }
    }

    public void removeAll(List<Storable> e){
        for(Storable current : e){
            save((Storable) current);
        }
    }

    public void update(Storable e){

        //TODO: [11] - Implementar esto DESPUÉS de implementar findById

        if (e instanceof Player){
            this.jugadores.set(1, (Player)e);
        }else if(e instanceof Team){
            this.equipos.set(1, (Team)e);
        }
    }


    /**
     *
     * @param e
     * @return null en caso de no encontrar el elemento.
     */
  
    // Version Katty
    // Return int if the Object was found
    public int find (Storable e){

       // Storable result = null;
        int index = -1;

        if (e instanceof Player){
            Player p = (Player)e;
            index = this.jugadores.indexOf(p);
      
        }else if(e instanceof Team){
            Team t = (Team)e;
            index = this.equipos.indexOf(t);
          
        }

        return index;
    }
    
   // KD : Validate the Player Name before inserting ... 
    // Este me todo busca el nombre de un jugador que se encuentra en el arreglo
    // enviado por parametro.
    // ******** NO SE USA  *********
    public boolean findPlayer ( Player[] TeamValidate) 
    {   String Namei, Namek ;
        int    value = 0; 
        Player[] tmp = TeamValidate;
        
       
       for ( int i=0; i<tmp.length; i++) {
    	   Namei  = tmp[i].getName();
    	    for (int k = 0; k < tmp.length; k++) {
    	    	Namek  = tmp[k].getName();
    		        if (i != k && Namei == Namek) {
    		             System.out.println ("The Player : " + Namei + "  is duplicated"  );
    		             return true ;
    		        }
    		    }
    		}
       
    	
    	return false;
    }
    
    // KD
    // Busca un jugador en la Lista
    public boolean findById (String name)
    {
    	String id_current = "";
    	List<Player> listPlayer = this.jugadores ;
         
 	    	 for (Player current : listPlayer) {
 	    		  id_current = current.getName();
 	 
 	    	     if ( id_current.compareToIgnoreCase(name)  == 0 ) 
 	    	        {
 	    			   System.out.println("El Jugador : " + name + " ya se encuentra registrado");
 	    			   return true;
 	     		 	  }
 	    	 }   
 	
    	
    	return false;
    }
    
    
    //KD
    // Mostrar los Jugadores
    public void showPlayers () {
        System.out.println ("List of Players ...");
        ListIterator<Player> listItr = this.jugadores.listIterator() ; //  this.equipos.listIterator();
        
        while(listItr.hasNext()) 
        {
           System.out.println(listItr.next());
        }
 
     }
     
    //KD
    // Mostrar los Jugadores por equipo
    public void showTeamPlayers () {
        System.out.println ("List of Players by Teams ...");
        ListIterator<Team> listItr = this.equipos.listIterator(); 
        
        while(listItr.hasNext()) 
        {
           System.out.println(listItr.next());
        }
 
     }
    
    public Storable findByIdprofe(List<Storable> e, String NamePlayer, Integer Number_Player)
    {
    	int index   =-1;
  	    String id_seek =  NamePlayer + Number_Player.toString() ;
	    String id_current = "";
	     
  
        ListIterator<Player> listItr = this.jugadores.listIterator();
        while(listItr.hasNext()) {
        	
            System.out.println(listItr.next());
        }
        
	  	 
    	 if (e instanceof Player) {
    
    		  for(Storable current : e){
    		      Player  obj = (Player)e ;
    		      id_current = obj.getName() + obj.getNumber() ; 
    		      
    	            if (id_current == id_seek )
    	            	System.out.println ("Player found "  ) ;
    		            return null ; //e;	     
    			
    	        }
    		   
    		 
    	 }
    	 
  
    	 
    	
    	throw new UnsupportedOperationException("Not implemented yet"); 
    	//TODO: [10] - Borrar esta línea cuando vayan a empezar a codificar tu implementación.
    }

    
}