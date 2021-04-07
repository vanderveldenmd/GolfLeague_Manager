/**
 * This is the class which governs the subclass regular member. They differ 
 * from the other subclasses in terms of handicap and their toString() methods.
 */
public class RegularMember extends GolfLeagueMember
{

 /**
 * The constructor for our regular member class, we need a name and a score so
 * we can call the superclass constructor and create the new class.
 * @param newName is the name of the new regular member to add
 * @param newScore is the set of scores to add to the new member
 */    
   RegularMember(String Name, int newScore)
   {
      super(Name, newScore);
   }

 /**
 * The toString() overrides the default object method and returns the type of
 * the member, their name, their current index, and their scores by calling the
 * super toString function.
 * @return a string with a member's class, name, index, and scores.
 */    
   @Override
   public String toString()
   {
      String LineScore = new String();
      LineScore = ("Regular Member " + super.toString());
      return LineScore;
   }
    
/**
* The handicap function calculates the handicap, which in this case takes all
* the scores, subtracts them from course par, multiplies it by a number, and
* removes the highest score from the list to calculate and return the handicap.
* @return an int which represents the handicap.
*/   
   @Override
   public int handicap()
   {
      int sum = 0;
      int numScores = 0;
      float avePar, handicap, average;
      int intHandicap;
      int maxIndex = indexOfMax();      //finding index and setting to variable
        
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         if(i != maxIndex)
         {
            sum += scores[i];
            numScores++;
         }
      }
      //The way of calculating the handicap score.
      average = (float)sum/numScores;
      avePar = average - (float)coursePar;
      handicap = avePar * (float)HANDICAP_PERCENT;
      intHandicap = (int) handicap;
      if (intHandicap <= beginloop)     //in case handicap is below 0.
      {
         return beginloop;
      }
        
      return intHandicap;
   }
}
