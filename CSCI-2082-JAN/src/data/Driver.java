package data;
// updated
import java.util.Random;
public class Driver {
  
	private BoxQueue outputChain;  
   
	/**
	 * @Descriprion  : Create a randomized and non-duplicated sequence of Box objects 
	 * @Parameters   : None
	 * @Precondition : None
	 * @Postcondition: The randomized and non-duplicated sequence of Box objects is created
	 * @ThrowList    : None
	 */
   public BoxQueue generateCollection(){
        
      BoxQueue boxQueue = new BoxQueue();
	   Random random = new Random();
      
      Box temp;
      while(boxQueue.getCount() < 5) {
      	 
    	 int x = random.nextInt(5);
     	 int y = random.nextInt(5);
     	 
     	 temp = new Box(x,y,null);
     	 boolean existed = false;

     	 Box[] boxArray = boxQueue.getArray();
     	 for(Box cursor : boxArray) {
     		 if(temp.equals(cursor))
     			 existed = true;
     	 }
     	 
     	 if(existed == false) {
     		 boxQueue.add(temp);
     	 }
      }
      outputChain = boxQueue;
      
      return outputChain;
      
    }

	/**
	 *  
	 * @Descriprion  : Compare the current sequence of Box objects generated by program
	 * 				   to the sequence of Box objects selected by player
	 * @Parameters   : inputChain - the sequence of boxes selected by player
	 * @Precondition : the two sequences are not null
	 * @Postcondition: if two sequences are equal return true, else false
	 * @ThrowList    : CloneNotSupportedException
	 */
  	public boolean compare (BoxQueue inputChain) throws CloneNotSupportedException {
  		
  		// Check the number of elements
  		if(outputChain.getCount() != inputChain.getCount())
  			return false;
  		else {
  			
  			BoxQueue inputClone = (BoxQueue)inputChain.clone();
  			BoxQueue outputClone = (BoxQueue)outputChain.clone();
  			
  			Box inputTemp;
  			Box outputTemp;
  			
  			for(int i =0;i< outputChain.getCount(); i++) {
  				inputTemp = inputClone.top();
  				outputTemp = outputClone.top();
  				if(!inputTemp.equals(outputTemp))
  					return false;
  			}	
  			return true;
  		}
  	}
    
}
