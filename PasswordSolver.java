/**
 * Class used to solve the password module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class PasswordSolver {

    //Word bank of possible passwords
    private Password passwordList[];

    //The letters that appear on each dial of the lock
    private String dialLetters[];

    /**
     * Constructor for PasswordSolver
     * 
     * No params are needed as the list of possible passwords is constant
     */
    public PasswordSolver() {
      
        //Set the lock's default values as null
        dialLetters = new String[] {null, null, null, null, null};

        //These are the only possible passwords in the module
        String[] wordList = new String[]{
            "about", "after", "again", "below", "could",
            "every", "first", "found", "great", "house",
            "large", "learn", "never", "other", "place",
            "plant", "point", "right", "small", "sound",
            "spell", "still", "study", "their", "there",
            "these", "thing", "think", "three", "water",
            "where", "which", "world", "would", "write"     
            };

        //Create array of Password objects using the wordList
        passwordList = new Password[wordList.length];

        for (int i = 0; i < wordList.length; i++) {
            passwordList[i] = new Password(wordList[i]);
            System.out.println(passwordList[i].getPassword());
        }

    }
 
    /**
     * Update a dial with new letters
     * 
     * @param dialIndex the dial to update
     * @param updatedLetters the new letters to overwrite the dial with
     */
    public void update(int dialIndex, String updatedLetters) {
        dialLetters[dialIndex] = updatedLetters;

        //Test print
        System.out.println("Updated letters for dial " + (dialIndex + 1) + ": " + dialLetters[dialIndex]);

        filterWordList(dialIndex);
    }

    /**
     * filters possible passwords based on the dial that was just updated
     * 
     * @param dialIndex The most recently updated dial
     */
    public void filterWordList(int dialIndex) {
        
        //for every password in the bank
        for (int i = 0; i < passwordList.length; i++) {
            //Start by assuming that none of the letters in the dial will match
            boolean passwordMatch = false;
            //for every letter on the dial
            for (int j = 0; j < dialLetters[dialIndex].length(); j++) {
                //if any of the letters match, 
                if (dialLetters[dialIndex].substring(j, j+1).equals(passwordList[i].getPassword().substring(dialIndex, dialIndex + 1))) {
                    //make the boolean true again and break the loop
                    passwordMatch = true;

                }
                //update the boolean values in the current password in the list
                boolean[] copyDialMatch = passwordList[i].getDialMatch();
                copyDialMatch[dialIndex] = passwordMatch;
                passwordList[i].setDialMatch(copyDialMatch);
            }
        }

    }

    /**
     * prints out the list of possible passwords given the values on the dials
     */
    public void printPossiblePasswords() {
       
        System.out.println("List of possible passwords:");
        for (int i = 0; i < passwordList.length; i++) {
           if (passwordList[i].isPossible()) {
                System.out.println(passwordList[i].getPassword());
           }
            
        }
    }

    /**
     * printAllPasswords method used to print all 35 passwords in the bank
     */
    public void printAllPasswords() {
        System.out.println("List of possible passwords:");
        for (int i = 0; i < passwordList.length; i++) {
            System.out.println(passwordList[i].getPassword());
        }
    }
 
}
