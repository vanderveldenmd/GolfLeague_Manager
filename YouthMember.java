/**
 * This is the class which governs the subclass youth member. They differ 
 * from the other subclasses in terms of handicap, their course par, and 
 * their toString() methods.
 */
public class YouthMember extends GolfLeagueMember
{
   private final int YOUTH_COURSE_PAR = 73;
   
/**
* The constructor for our youth member class, we need a name and a score so
* we can call the superclass constructor and create the new class.
* @param newName is the name of the new regular member to add
* @param newScore is the set of scores to add to the new member
*/       
   YouthMember(String newName, int newScore)
   {
      super(newName,newScore);
   }

/**
* The handicap function calculates the handicap, which in this case takes all
* the scores, finds an average, subtracts average from par, multiplies it by 
* a number, and removes the lowest scores from the list to calculate and 
* return the handicap.
* @return an int which represents the handicap.
*/   
   @Override
   public int handicap()
   {
      int sum = 0;
      int numScores = 0;
      float avePar, handicap, average;
      int intHandicap;
      int minIndex = indexOfMin();
        
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         if(i != minIndex)      //we exclude the lowest score
         {
            sum += scores[i];
            numScores++;
         }
      }
      //The following calculates the handicap based on our methods.
      average = (float)sum/numScores;
      avePar = average - (float)YOUTH_COURSE_PAR;
      handicap = avePar * (float)HANDICAP_PERCENT;
      intHandicap = (int) handicap;
      
      if (intHandicap <= beginloop)     //we exclude values here less than 0
         return beginloop;
        
      return intHandicap;
   }

/**
* The toString() overrides the default object method and returns the type of
* the member, their name, their current index, and their scores by calling 
* the super toString function.
* @return a string with a member's class, name, index, and scores.
*/      
   @Override
   public String toString()
   {
      String LineScore = new String();
      LineScore = ("Youth Member " + super.toString());
      return LineScore;
   }
}
