/**
 * This class is what governs all of the different golfers in the league and
 * includes methods to modify the league, its members, and their scores.
 */
public class GolfLeague 
{
   private final int MAX_SIZE = 10;
    
   private GolfLeagueMember members[] = new GolfLeagueMember[MAX_SIZE];
   private int numOfMembers = 0;
    
   private final int beginloop = 0;
   private final int notfound = -1;
   private int index;
   private final int nextMember = 1;
    
 /**
 * The add method adds a new member to the array members[] and increments the 
 * counter numOfMembers if the array is not full.
 * @param member is the object of class GolfLeagueMember to add to the array.
 * @return true if the member was added, false if it was not
 */
   public boolean add(GolfLeagueMember member)
   {
      if(numOfMembers == MAX_SIZE)
         return false;
        
      members[numOfMembers++] = member;
      return true;
   }
    
 /**
 * The add method deletes a new member from the array members[] and decreases
 * the counter by one step. It looks for the member name and if found, 
 * removes that member by replacing it with the last member on the list.
 * @param memberName is name of the member to delete
 * @return true if the member was deleted, false if it was not in the list
 */   
   public boolean delete( String memberName )
   {
      index = notfound;
      for(int i = beginloop; i < numOfMembers; i ++ )
      {
         if( memberName.equals(members[i].getName()))
                index = i;
      }
        
      if(index == notfound)
         return false;
        
      for(int i = index; i < numOfMembers - nextMember; i ++ )
      {
         members[i] = members[i + nextMember];
      }
      numOfMembers--;
      return true;
   }

 /**
 * The enterScore adds a score to a member at their current index if the 
 * member exists.
 * @param memberName is name of the member to add a score to
 * @param score is the int of the score to add to the member's scores list
 * @return true if the score was added, false the member was not in the list
 */    
   public boolean enterScore(String memberName, int score)
   {
      //We have to find the member first.
      index = findByName(memberName);
      if(index == notfound)
         return false;
        
      members[index].storeScore(score);
      return true;
   }
    
 /**
 * toString overrides the object method and attempts to display all members 
 * of the league, their index, and lastly, their scores in order.
 */   
   @Override
   public String toString()
   {
      String line = new String();
       
      line += System.lineSeparator() + ("All members of the League:") + 
              System.lineSeparator();
      //We concantenate the string line by adding all members
      for (int i = beginloop; i < numOfMembers; i ++)
      {
         line += members[i].toString() + System.lineSeparator();
      }
        
      return line;
   }
 
 /**
 * The getHandicap looks for a member, finds said member, and uses that
 * member's class to return the value of their handicap.
 * @param memberName is name of the member to find the handicap
 * @return the handicap if member was found, returns -1 otherwise
 */    
   public int getHandicap( String memberName)
   {
      //We find the name before we can get the handicap
      index = findByName(memberName);
      if( index == notfound)
         return notfound;
        
      return members[index].handicap(); //polymorphism!
   }

 /**
 * findByName takes a string and finds the index of where that person exists
 * within the array members.
 * @param memberName is name of the member to find within the array
 * @return the location of the person if found, -1 if not found
 */   
   private int findByName(String memberName)
   {
      index = notfound;  //if nothing is found, we already are returning =1.
      for (int i = beginloop; i < numOfMembers; i ++)
      {
         if(memberName.equals(members[i].getName()))
            index = i;
      }
      return index;
   }    
}

