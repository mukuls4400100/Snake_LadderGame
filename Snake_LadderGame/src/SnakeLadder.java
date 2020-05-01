import java.util.Random;
import java.util.Scanner;
public class SnakeLadder {
	
  static int p1=-1,p2=-1,t=0,initial1=0,initial2=0,c=0,c1=0,dice,count=0,first=0,sec=0,cou;
  static int[][] a=new int[10][10];
	 
     void player1()                                                          
    {
        Random rand = new Random(); 
        System.out.println("Player1 turn");
        
        dice=rand.nextInt(6)+1;
        
        System.out.println("dice value  "+dice);
        System.out.println();
        
        while(dice==6)                                                      //checking for no. of 6's
        {
           ++first;
           ++count;
           ++cou; 
           
           System.out.println(); 
           System.out.println("Player1 turn    ");
           
           dice=rand.nextInt(6)+1;
           
           if(initial1==0 && dice==6)
           count-=1;
           
           System.out.println("dice value "+dice);
           System.out.println();
           
           initial1=1;
        }
        
        if(cou>=3 && c==0){                                                //if initially no. of 6's is 3 
        	initial1=0;
            c=1;
            t++;  
        }
        else if(initial1==1 && (count>0 && count<3) && first!=1){           
        	p1+=(count)*6+dice;
            t++;
            	if(p1>99)
            		p1-=(count)*6+dice;
        }
        else if(initial1==1){
        	p1+=dice;
            t++;
             if(p1>99)
                p1-=dice;
        }
        else
        	++t;
        
        System.out.println();
        
        if(p1==3) {                                                          //adding/deleting if player1 is at any ladder or snake         
    	   p1+=10; 
    	   System.out.println("     ladder here");}                                                    
        else if(p1==21) {
        	p1+=21;
        	 System.out.println("     ladder here");}
        else if(p1==50) {
        	p1+=17; System.out.println("     ladder here");}
        else if(p1==32) {
        	p1-=22; System.out.println("     snake here");}
        else if(p1==62) {
        	p1-=44; System.out.println("     snake here");}
        else if(p1==97) {
        	p1-=19;
        	 System.out.println("     snake here");}
        
        System.out.println(); 
        
        System.out.println("player1 value "+p1);
        
        for(int i=0;i<10;i++)                                             //updating the positions of player1 and player2
        {
        	for(int j=0;j<10;j++)
        	{
        		if(a[i][j]==p1)
        			System.out.print("P1 ");	
        		else if(a[i][j]==p2)
        			System.out.print("P2 ");
        		else
        			System.out.print(a[i][j]+" ");
        	}
        	System.out.println();
        }
    }
     
     
     void player2()
    {
        Random rand = new Random(); 
        System.out.println("                                          Player2 turn    ");
       
        dice=rand.nextInt(6)+1;
        
        System.out.println("                                          dice value "+dice);
        System.out.println();
        
        while(dice==6)
        {
           
           ++sec;
           ++count;
           ++cou;
           
           System.out.println();
           System.out.println("                                          Player2 turn    ");
           
           dice=rand.nextInt(6)+1;
           
           if(initial2==0 && dice==6)
           count-=1;
           
           System.out.println("                                          dice value "+dice);
           System.out.println();
           
           initial2=1;  
        }
       
       if(cou>=3 && c1==0){
            initial2=0;
            c1=1;
            t++;
        }
        else if(initial2==1 && (count>0 && count<3) && sec!=1){
        	p2+=(count)*6+dice;
            t++;
             if(p2>99)
            	 p2-=(count)*6+dice;
        }
        else if(initial2==1){
        	p2+=dice;
            t++;
            	if(p2>99)
            		p2-=dice;
        }
        else
        	t++;
       
       if(p2==3) {                                                     
    	   p2+=10; 
    	   System.out.println("                                     ladder here");}                                                    
        else if(p2==21) {
        	p2+=21;
        	 System.out.println("                                    ladder here");}
        else if(p2==50) {
        	p2+=17; System.out.println("                                 ladder here");}
        else if(p2==32) {
        	p2-=22; System.out.println("                                 snake here");}
        else if(p2==62) {
        	p2-=44; System.out.println("                                 snake here");}
        else if(p2==97) {
        	p2-=19;
        	 System.out.println("                                    snake here");}
       
       System.out.println();
     
    System.out.println("                                          Player2 value "+p2);
    
       for(int i=0;i<10;i++)
       {
    	    System.out.print("                                          ");
       		for(int j=0;j<10;j++)
       		{
       		   if(a[i][j]==p1)
    			   System.out.print("P1 ");
       		   else if(a[i][j]==p2)
    			   System.out.print("P2 ");
    		   else
    			   System.out.print(a[i][j]+" ");
       		}
          System.out.println();
       }
    }
     
     
    public static void main(String args[]) {
    
    	int k=0;
    	
    	for (int i = 9; i >=0; i--)                                                      //traversing array like snake pattern
		{
			if (((10-i) % 2)!=0) 
			{ 
				for (int j = 0; j < 10; j++) 
					a[i][j]=k++;
			} 
			else
			{ 
				for (int j = 9; j >= 0; j--) 
					a[i][j]=k++;
			} 
			
		}	
    	
    	Scanner s =new Scanner(System.in);
    	
    	System.out.println("Ladder is at 3 to 13 diff 12 , 21 to 42 diff 21, 50 to 67 diff 17");	 //adding ladders
    	System.out.println("Snake is at 32 to 10 diff 22 , 62 to 18 diff 44, 97 to 78 diff 19");     //adding snakes
    	System.out.println();
    	System.out.println();
    	
    	SnakeLadder my=new SnakeLadder();
        
     while(p1<=99 || p2<=99)                              
     {
         count=0;cou=0;
         
         if(t%2==0)
              my.player1();
         else                                                                                        //calling player1 and player2 simultaneously 
              my.player2();
         
         if((p1==p2) && (t%2==0))
        	 p1=-1;                                                                               
         else if((p1==p2) && (t%2!=0))
        	 p2=-1;
         
         if(p1==99)
         {
        	 System.out.println();
             System.out.println("                     Player1 wins   "+p1);
             break;
         }
         else if(p2==99)
         {
        	 System.out.println();
             System.out.println("                     Player2 wins   "+p2);
             break;
         }
         
         System.out.println();
         System.out.print("Enter character 'w' ");
         System.out.println();
         
         char c=s.next().charAt(0);
         
     }
     
    }
}
