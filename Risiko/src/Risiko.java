import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
		import java.util.List;
public class Risiko {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
		

		List<Integer> ang1 = new ArrayList<>();

		ArrayList<Integer> ang2 = new ArrayList<Integer>();
		ArrayList<Integer> ang3 = new ArrayList<Integer>();
		ArrayList<Integer> vert1 = new ArrayList<Integer>();
		ArrayList<Integer> vert2 = new ArrayList<Integer>();
		ArrayList<String> gewinner = new ArrayList<String>();

		int angr1 = 1;
		for (int j = 1; j<=6;j++) {
		for (int i =1; i<=1296;i++) {
		ang1.add(angr1);

		}
		angr1 = angr1 + 1;
		}

		int angr2 = 1;
		for (int j = 1; j<=36;j++) {
		for (int i =1; i<=216;i++) {
		ang2.add(angr2);
		}
		angr2 = angr2 + 1;
		if (angr2 == 7) {
		angr2 = 1;

		}
		}

		int angr3 = 1;
		for (int j = 1; j<=216;j++) {
		for (int i =1; i<=36;i++) {
		ang3.add(angr3);
		}
		angr3 = angr3 + 1;
		if (angr3 == 7) {
		angr3 = 1;

		}
		}

		int verte1 = 1;
		for (int j = 1; j<=1296;j++) {
		for (int i =1; i<=6;i++) {
		vert1.add(verte1);
		}
		verte1 = verte1 + 1;
		if (verte1 == 7) {
		verte1 = 1;

		}
		}
		int verte2 = 1;
		for (int j = 1;j <=7776;j++) {

		vert2.add(verte2);

		verte2 = verte2 + 1;
		if (verte2 == 7) {
		verte2 = 1;

		}
		}
	
		
		

        int gleichstand=0;
        int verteidigungsieg=0;
        int angriffsieg=0;
        int zeile = 0;
        int prio1angriff = 0; // höchster würfel des angriffs
        int prio2angriff = 0;
        int prio1verteidigung;
        int prio2verteidigung;
       
        
        // Anfang der zeilendurchläufe
        
        for (int l = 1; l<=7776; l++) {
        if ((ang1.get(zeile) > ang2.get(zeile)) && (ang1.get(zeile) > ang3.get(zeile))) {
        	
        	prio1angriff = ang1.get(zeile);
        	if ((ang2.get(zeile) > ang3.get(zeile)) ) {
    	   
        			prio2angriff = ang2.get(zeile);
    	  
    	   
        		}
        		else {
        				prio2angriff = ang3.get(zeile);
       }
        }
        
       if ((ang2.get(zeile) > ang1.get(zeile)) && (ang2.get(zeile) > ang3.get(zeile))) {
        	
        	prio1angriff = ang2.get(zeile);
        	if ((ang1.get(zeile) > ang3.get(zeile)) ) {
    	   
        			prio2angriff = ang1.get(zeile);
    	  
    	   
        		}
        		else {
        				prio2angriff = ang3.get(zeile);
       }
        }
        
        
       if ((ang3.get(zeile) > ang2.get(zeile)) && (ang3.get(zeile) > ang1.get(zeile))) {
       	
       	prio1angriff = ang3.get(zeile);
       	if ((ang2.get(zeile) > ang1.get(zeile)) ) {
   	   
       			prio2angriff = ang2.get(zeile);
   	  
   	   
       		}
       		else {
       				prio2angriff = ang1.get(zeile);
      }
       }
        
        
       if (	(ang1.get(zeile) == ang2.get(zeile)) && (ang1.get(zeile) >	ang3.get(zeile))		) {
    	   
    	   prio1angriff = ang1.get(zeile);
    	   prio2angriff = ang1.get(zeile);
    	   
    	   
       } 
        
      
       
       
     if (	(ang2.get(zeile) == ang3.get(zeile)) && (ang2.get(zeile) >	ang1.get(zeile))		) {
    	   
    	   prio1angriff = ang2.get(zeile);
    	   prio2angriff = ang2.get(zeile);
    	   
    	   
       } 
        
        
     if (	(ang1.get(zeile) == ang3.get(zeile)) && (ang1.get(zeile) >	ang2.get(zeile))		) {
  	   
  	   prio1angriff = ang1.get(zeile);
  	   prio2angriff = ang1.get(zeile);
  	   
  	   
     } 
        
        
     if( (ang1.get(zeile) == ang2.get(zeile)) && (ang1.get(zeile) == ang3.get(zeile))) {
    	 
    	 prio1angriff = ang1.get(zeile);
    	 prio2angriff = ang1.get(zeile);
     
     }
    
        
     
     
     // Verteidigung
     // auslese der prioritäten
     
     if (vert1.get(zeile) > vert2.get(zeile) ) {
    	 prio1verteidigung = vert1.get(zeile);
    	 prio2verteidigung = vert2.get(zeile);   	 
    	 
     }else {
    	 prio1verteidigung = vert2.get(zeile);
    	 prio2verteidigung = vert1.get(zeile);
    	 
     }
     
     // ende auslese
     
     if ((prio1verteidigung >= prio1angriff) && (prio2verteidigung >= prio2angriff)) {
    	 
    	 verteidigungsieg++;
    	 gewinner.add("Sieg der Verteidigung");
    	 
     }
     
     if (	(prio1angriff>prio1verteidigung)	&&	(prio2angriff>prio2verteidigung)		) {
    	 
    	 angriffsieg++;
    	 gewinner.add("Sieg des Angriffs");
    	 
    	 
     }
     
     if ( ((prio1angriff>prio1verteidigung)	&&	(prio2verteidigung>=prio2angriff))		|| ((prio1verteidigung>=prio1angriff) &&(prio2angriff>prio2verteidigung))						) {
    	 gleichstand++;
    	 gewinner.add("Gleichstand! YAY");
    	 
     }	

     zeile++;
        }
     // ende auswertung des gewinners
        
        // Anfang 3:1
        

		ArrayList<Integer> ang31 = new ArrayList<Integer>();

		ArrayList<Integer> ang32 = new ArrayList<Integer>();

		ArrayList<Integer> ang33 = new ArrayList<Integer>();

		ArrayList<Integer> vert31 = new ArrayList<Integer>();
		ArrayList<String> gewinner3 = new ArrayList<String>();
		
		
		int angr31 = 1;
		for (int j = 1; j<=6;j++) {
		for (int i =1; i<=216;i++) {
		ang31.add(angr31);

		}
		angr31 = angr31 + 1;
		}
		
        
		

		int angr32 = 1;
		for (int j = 1; j<=36;j++) {
		for (int i =1; i<=36;i++) {
		ang32.add(angr32);
		}
		angr32 = angr32 + 1;
		if (angr32 == 7) {
		angr32 = 1;

		}
		}
		

		int angr33 = 1;
		for (int j = 1; j<=216;j++) {
		for (int i =1; i<=6;i++) {
		ang33.add(angr33);
		}
		angr33 = angr33 + 1;
		if (angr33 == 7) {
		angr33 = 1;

		}
		}

		int verte31 = 1;
		for (int j = 1; j<=1296;j++) {
		for (int i =1; i<=1;i++) {
		vert31.add(verte31);
		}
		verte31 = verte31 + 1;
		if (verte31 == 7) {
		verte31 = 1;

		}
		}
		
		
		
        int verteidigungsieg3=0;
        int angriffsieg3=0;
        int zeile3 = 0;
        int prio1angriff3 = 0; // höchster würfel des angriffs
      
      for (int l = 1;l<=1296;l++) {  
        if ((ang31.get(zeile3) > ang32.get(zeile3)) && (ang31.get(zeile3) > ang33.get(zeile3))) {
        	
        	prio1angriff3 = ang31.get(zeile3);
        
        }
        
     if ((ang32.get(zeile3) > ang31.get(zeile3)) && (ang32.get(zeile3) > ang33.get(zeile3))) {
        	
        	prio1angriff3 = ang32.get(zeile3);
        
        }
		
     if ((ang33.get(zeile3) > ang32.get(zeile3)) && (ang33.get(zeile3) > ang31.get(zeile3))) {
     	
     	prio1angriff3 = ang33.get(zeile3);
     
     }
     
    
     if ((ang31.get(zeile3) == ang32.get(zeile3)) && (ang31.get(zeile3) > ang33.get(zeile3))) {
      	
      	prio1angriff3 = ang31.get(zeile3);
      
      }
     
     if ((ang31.get(zeile3) == ang33.get(zeile3)) && (ang31.get(zeile3) > ang32.get(zeile3))) {
       	
       	prio1angriff3 = ang31.get(zeile3);
       
       }
     if ((ang32.get(zeile3) == ang33.get(zeile3)) && (ang32.get(zeile3) > ang31.get(zeile3))) {
       	
       	prio1angriff3 = ang32.get(zeile3);
       
       }
     
      
     
     if( (ang31.get(zeile3) == ang32.get(zeile3)) && (ang31.get(zeile3) == ang33.get(zeile3))) {
    	 
    prio1angriff3 = ang31.get(zeile3);
     
     }
     
     if (vert31.get(zeile3) >= prio1angriff3) {
    	 
    	 verteidigungsieg3++;
    	 gewinner3.add("Sieg der Verteidigung");
    	 
    	 
    	 
     }
     else {
    	 
    	 
    	 angriffsieg3++;
    	 gewinner3.add("Sieg des Angriffs");
    	 
     }
     zeile3++;
      }
     
      
      // Anfang 2:1
      
      ArrayList<Integer> ang21 = new ArrayList<Integer>();
      ArrayList<Integer> ang22 = new ArrayList<Integer>();
      ArrayList<Integer> vert21 = new ArrayList<Integer>();
  	  ArrayList<String> gewinner2 = new ArrayList<String>();
      
      int angr21 = 1;
		for (int j = 1; j<=6;j++) {
		for (int i =1; i<=36;i++) {
		ang21.add(angr21);
		}
		angr21 = angr21 + 1;
		
		if (angr21 == 7) {
		angr21 = 1;
		}
		
		}
	      int angr22 = 1;
			for (int j = 1; j<=36;j++) {
			for (int i =1; i<=6;i++) {
			ang22.add(angr22);
			}
			angr22 = angr22 + 1;
			if (angr22 == 7) {
			angr22 = 1;

			}
			}
		      int verte21 = 1;
				for (int j = 1; j<=216;j++) {
				vert21.add(verte21);
				verte21 = verte21 + 1;
				if (verte21 == 7) {
				verte21 = 1;

				}
				}
				
			//anfang auswertung
				
				int verteidigungsieg2=0;
		        int angriffsieg2=0;
		        int zeile2 = 0;
		        int prio1angriff2 = 0;	
				
		        for (int j = 1; j<=216;j++) {
		        	
		        	if (ang21.get(zeile2)  > ang22.get(zeile2)) {
		        		prio1angriff2 = ang21.get(zeile2);
		        		
		        		
		        		
		        	}else {
		        		
		        		prio1angriff2 = ang22.get(zeile2);
		        	}
		        	if (vert21.get(zeile2) >=prio1angriff2) {
		        		verteidigungsieg2++;
		        		gewinner2.add("Sieg der Verteidigung!");
		        		
		        	}else {
		        		
		        		angriffsieg2++;
		        		gewinner2.add("Sieg des Angriffs!");
		        	}
		        	
		        	
		        	
		        	
		        	
		        	zeile2++;
		        }
		        
				
				
      
      
		PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new BufferedWriter(new FileWriter("Ausgabe.txt")));
            int x = 0;
            pWriter.println("Würfel Angriff:     Würfel Verteidigung:     Ausgang:");
            for (int i =1;i<=7776;i++) {
         
            	   pWriter.println(ang1.get(x) + (" ") +  ang2.get(x) + (" ") +  ang3.get(x) + ("               ") +  vert1.get(x) + (" ") +  vert2.get(x) + ("                      ") +  gewinner.get(x));
           x++;
            }
            pWriter.println(" ");
            pWriter.println("Anzahl der Siege der Verteidigung:  " + verteidigungsieg);
            pWriter.println("Anzahl der Siege des Angriffs:  " + angriffsieg);          
            pWriter.println("Anzahl der Gleichstände:  " + gleichstand);             
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println("Würfel Angriff:     Würfel Verteidigung:     Ausgang:");
            int n = 0;
            for (int i =1;i<=1296;i++) {
                
         	   pWriter.println(ang31.get(n) + (" ") +  ang32.get(n) + (" ") +  ang33.get(n) + ("               ") +  vert31.get(n)+ ("                        ") +  gewinner3.get(n));
        n++;
         }
            pWriter.println("Anzahl der Siege der Verteidigung:  " + verteidigungsieg3);
            pWriter.println("Anzahl der Siege des Angriffs:  " + angriffsieg3);     
            
            
            //anfang 2:1 ausgabe
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println(" ");
            pWriter.println("Würfel Angriff:    Würfel Verteidigung:     Ausgang:");
            int n2 = 0;
            for (int i =1;i<=216;i++) {
                
         	   pWriter.println(ang21.get(n2) + (" ") +  ang22.get(n2) + (" ") + ("               ") +  vert21.get(n2)+ ("                        ") +  gewinner2.get(n2));
        n2++;
         }
            pWriter.println("Anzahl der Siege der Verteidigung:  " + verteidigungsieg2);
            pWriter.println("Anzahl der Siege des Angriffs:  " + angriffsieg2);     
            
                   
         
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (pWriter != null){
                pWriter.flush();
                pWriter.close();
            }
        }
        
   
        
        
     
     
     
     
     System.out.println("Anzahl der Siege der Verteidigung:  " + verteidigungsieg);
     System.out.println("Anzahl der Siege des Angriffs:  " + angriffsieg);
     System.out.println("Anzahl der Gleichstände:  " + gleichstand);
     
     
     
        
      
		}
		}
		
	


