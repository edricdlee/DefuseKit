/**
 * Password object used in the password class
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class Password {

    //Array of boolean where each element indicates whether or not
    //any of the letters on a dial matches the corresponding letter in the password string
    private boolean dialMatch[];
    
    //a possible password
    private String password;

    /**
     * Constructor for Password
     * dialMatch has all elements set as true because 
     * a password will be considered possible until a contradicting dial is inputted
     * 
     * @param word the possible password
     */
    public Password(String word) {
        password = word;
        dialMatch = new boolean[] {true, true, true, true, true}; 
    }

    /**
     * setter method for dialMatch
     * 
     * @param updatedDialMatch the updated dialMatch
     */
    public void setDialMatch(boolean updatedDialMatch[]) {
        dialMatch = updatedDialMatch;
    }

    /**
     * getter method for dialMatch
     * 
     * @return dialMatch
     */
    public boolean[] getDialMatch() {
        return dialMatch;
    }

    /**
     * setter method for password
     * 
     * @param updatedPassword the updated password
     */
    public void setPassword(String updatedPassword) {
        password = updatedPassword;
    }

    /**
     * getter method for password
     * 
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Method to check if this password is possible
     * 
     * @return whether or not the password is possible
     */
    public boolean isPossible() {
        boolean isPossible = true;

        for (int i = 0; i < dialMatch.length; i++) {
            if (!dialMatch[i]) {
                isPossible = false;
                break;
            }
        }

        return isPossible;
    }
}
