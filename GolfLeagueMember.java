/**
 * The superclass for this project, all other members are GolfLeagueMembers.
 * This includes the important variables for the members: the current index,
 * their list of scores, and their name.
 */
public abstract class GolfLeagueMember 
{
   protected final int NUM_STORED_SCORES = 5;
   protected final double HANDICAP_PERCENT = 0.96;
    
   private final String name;
   protected int coursePar = 72;
   protected int scores[] = new int[NUM_STORED_SCORES];
   protected int curIndex;
    
   public final int beginloop = 0;      //We will use this a lot.
   
/**
* The default constructor for the superclass will set the name of the golfer
* and a list of 5 scores with the same value.
* @param newName is the name of the new member to add
* @param newScore is the set of scores to add to the new member
*/       
   GolfLeagueMember(String newName, int newScore)
   {
      name = newName;
      //We want all scores to be the newScore, we use a for loop for this.
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         scores[i] = newScore;
      }
   }

/**
* The getName() method returns a string of the name of the member called.
* @return name is the name of the member of the class
*/    
   public String getName()
   {
      return name; 
   }
 
/**
* The toString() overrides the default object method and returns a string 
* which includes the current index and the list of the scores.
* @return a string with a member's name, index, and scores.
*/       
   @Override
   public String toString()
   {
      String LineScore = (name + ": " + curIndex);
      
      //We concantenate the string as long as there are more members
      for (int i = beginloop; i < NUM_STORED_SCORES; i++)
      {
         LineScore += ("," + scores[i]);
      }
      return LineScore;
   }

/**
* The storeScore method puts a new score into a member's scores list at the
* position defined by the current index. It also updates the index.
* @param score is the value of the new score to add to the scores list.
*/    
   public void storeScore(int score)
   {
      scores[curIndex ++] = score;
      if (curIndex >= NUM_STORED_SCORES)        //We update the index to 0
         curIndex = beginloop;
   }
   
/**
* The handicap method is abstract as we need to know the subclass before we
* calculate the handicap, since all subclasses have their own handicap method
* we can make this abstract.
*/     
   public abstract int handicap();

/**
* The indexOfMax() method looks at all the scores in the scores list and
* finds the highest score and returns the index of that position.
* @return index is the location of the maximum score in the list as an int
*/      
   protected int indexOfMax()
   {
      int index = 0;
      int curMax = 0;
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         if(scores[i] >= curMax)
         {
            index = i;
            curMax = scores[index];
         }
      }
      return index;
   }
  
/**
* The indexOfMin() method looks at all the scores in the scores list and
* finds the lowest score and returns the index of that position.
* @return index is the location of the minimum score in the list as an int
*/     
   protected int indexOfMin()
   {
      int index = 0;
      int curMin = scores[index];
      for (int i = beginloop; i < NUM_STORED_SCORES; i ++)
      {
         if(scores[i] <= curMin)
         {
            index = i;
            curMin = scores[index];
         }
      }
      return index;
   } 
}
