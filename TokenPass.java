package frq2013;

public class TokenPass {

	 /** instance variables */
	 private int[] board;
	 private int currentPlayer;
	 
	 /** Creates the board array to be of size playerCount and fills it with
	 * random integer values from 1 to 10, inclusive. Initializes currentPlayer to a
	 * random integer value in the range between 0 and playerCount-1, inclusive. 
	 * @param playerCount the number of players
	 */
	 public TokenPass(int playerCount){
		 // Creates the board array to be of size playerCount
		 board = new int[playerCount];
		 
		 // fills it with random integer values from 1 to 10, inclusive.
		 for(int i = 0; i < playerCount; i++) {
			 board[i] = 1 + (int)(Math.random()*10);
		 }
		 
		 // Initializes currentPlayer to a random integer value in range [0, playerCount-1]
		 currentPlayer = (int)(Math.random()*playerCount);
	 }
	 
	 /** 
	  * Distributes the tokens from the current player's position one at a time to each player in
	  * the game. Distribution begins with the next position and continues until all the tokens
	  * have been distributed. If there are still tokens to distribute when the player at the
	  * highest position is reached, the next token will be distributed to the player at position 0.
	  * Precondition: the current player has at least one token.
	  * Postcondition: the current player has not changed.
	  */
	 public void distributeCurrentPlayerTokens(){
		 int collectedTokens = board[currentPlayer];
		 board[currentPlayer] = 0;
		 
		 for(int i = 1; i <= collectedTokens; i++) {
			 int nextPlayer = (currentPlayer + i) % board.length; // ArrayIndexOutOfBoundsException
			 board[nextPlayer]++;  
		 }
	 }
	 
	 /**
	  * @return the position of current player.
	  */
	 public int getCurrentPlayer() {
		 return currentPlayer;
	 }
	 
	 /**
	  * Return a string representation of TokenPass game's current status.
	  */
	 public String toString() {
		 if(board.length == 0) return "[]";
		 
		 StringBuilder res = new StringBuilder();
		 res.append("[");
		 for(int i = 0; i < board.length-1; i++) {
			 res.append(board[i] + ", ");
		 }
		 res.append(board[board.length-1] + "]");
		 return res.toString();
	 }
	 
	 /**
	  * For testing use.
	  */
	 public static void main(String[] args) {
		 TokenPass game = new TokenPass(8);
		 System.out.println(game + " currentPlayer: " + game.getCurrentPlayer());
		 game.distributeCurrentPlayerTokens();
		 System.out.println(game);
	 }
}