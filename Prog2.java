/**
 * The class which runs the classes we defined above. It includes a scanner
 * to input the commands and tell the program what to run by pointing to the
 * GolfLeague class.
 */
import java.util.Scanner;

public class Prog2 
{
   private static GolfLeague league = new GolfLeague();
   private static Scanner sc = new Scanner(System.in);
   
 
/**
* The addMember reads in a name, group, and score to find the correct
* constructor to call to finish the new member and add it to the league.
*/       
   private static void addMember()
   {
      String name = sc.next();
      String group = sc.next();
      int score = sc.nextInt();
      String line = new String();       
      Boolean memberAdded = false;
      
         switch (group) 
         {
            case "Regular":
               memberAdded = league.add(new RegularMember(name, score));
               line = ("Regular Member " + name + " is added");
               break;
            case "Youth":
               memberAdded = league.add(new YouthMember(name, score));
               line = ("Youth Member " + name + " is added");
               break;
            case "Senior":
               memberAdded = league.add(new SeniorMember(name, score));
               line = ("Senior Member " + name + " is added");
               break;
         }
        
      if(memberAdded)
         System.out.println(line);
      else
         System.out.println(name + " is not added");
    }
    
/**
* The deleteMember method tries to find a member name after reading it in and
* call the delete method in GolfLeague to remove the member from the league.
*/ 
   public static void deleteMember()
   {
      String name = sc.next();
      String line = new String(); 
      line = (name + " is deleted");
       
      if(!(league.delete(name)))
      {
         line = (name + " is not in the league");
      }
        
      System.out.println(line);
   }
    
/**
* The addScore method reads in a name and score and calls the GolfLeague class
* to add a new score to the member. Prints a string whether or not the operation
* was successful.
*/ 
   private static void addScore()
   {
      String name = sc.next();
      String line = new String();       
      int score = sc.nextInt();
        
      if(!(league.enterScore(name, score)))
      {
         System.out.println(name + " is not in the league");
         return;
      }
      line = ("Score of " + score + " is stored for " + name);
      System.out.println(line);
   }

/**
* The displayHandicap method reads in a name and tries to find the name to 
* call the handicap method and prints the handicap of that person if successful
* it also prints a message of the process was unsuccessful.
*/    
   private static void displayHandicap()
   {
      final int notfound = -1;
      String name = sc.next();
      String line = new String(); 
      
      int handicap = league.getHandicap(name);
      if(handicap == notfound)
      {
         System.out.println(name + " is not in the league");
         return;           
      }
        
      line = (name + " has a handicap of " + handicap);
      System.out.println(line);
   }

/**
* The main loop of the function executes a command. It reads in a command and 
* converts it to a form which allows the program to send it to the proper 
* method. It continues to read until there is no more data input.
*/     
   public static void main(String args[])
   {
      while( sc.hasNext() )
      {
         String command = sc.next();
         command = command.toLowerCase();            
            
         if(command.equals("add"))
            addMember();
         else if(command.equals("delete"))
            deleteMember();
         else if(command.equals("score"))
            addScore();
         else if(command.equals("handicap"))
            displayHandicap();
         else if(command.equals("print"))
            System.out.println(league.toString());
      }    
   }
}
