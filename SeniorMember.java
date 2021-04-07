/**
 * This is the class which governs the subclass senior member. They differ 
 * from the other subclasses in terms of handicap, their course par, and 
 * their toString() methods.
 */
public class SeniorMember extends GolfLeagueMember
{
   private final int SENIOR_COURSE_PAR = 74;
   
/**
* The constructor for our senior member class, we need a name and a score so
* we can call the superclass constructor and create the new class.
* @param newName is the name of the new regular member to add
* @param newScore is the set of scores to add to the new member
*/    
   SeniorMember(String newName, int newScore)
   {
      super(newName, newScore);
   }

/**
* The handicap function calculates the handicap, which in this case takes all
* the scores, subtracts them from course par, multiplies it by a number, and
* removes the highest and lowest scores from the list to calculate and return
* the handicap.
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
      int maxIndex = indexOfMax();
        
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         //we exclude both the highest and the lowest scores
         if(i != minIndex && i != maxIndex)
         {
            sum += scores[i];
            numScores++;
         }
      }
      //This is the calculation method outlined by the rubric
      average = (float)sum/numScores;
      avePar = average - (float)SENIOR_COURSE_PAR;
      handicap = avePar * (float)HANDICAP_PERCENT;
      intHandicap = (int) handicap;
      if (intHandicap <= beginloop)     //if we have less than 0, returns -1
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
      LineScore = ("Senior Member " + super.toString());
      return LineScore;
   }
}
