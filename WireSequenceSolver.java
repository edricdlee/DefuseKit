/**
 * Class used to solve the wire sequence module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class WireSequenceSolver {

    private String[] redDecisions;
    private String[] blueDecisions;
    private String[] blackDecisions;
    private int redCount;
    private int blueCount;
    private int blackCount;

    /**
     * Constructor for the wireSequenceSolver.
     * Params not needed as initial variable values will always
     * be the same at start of module
     */
    public WireSequenceSolver() {
        redDecisions = new String[] {"C", "B", "A", "AC", "B", "AC", "ABC", "AB", "B"};
        blueDecisions = new String[] {"B", "AC", "B", "A", "B", "BC", "C", "AC", "A"};
        blackDecisions = new String[] {"ABC", "AC", "B", "AC", "B", "BC", "AB", "C", "C"};
        redCount = 0;
        blueCount = 0;
        blackCount = 0;
    }


    /**
     * solver method for the wire sequence module
     * Solves one wire at a time
     * 
     * @param wireColor the color of the wire
     * @param connectedLetter the letter the wire is connected to
     */
    public void solveSingleWire(int wireColor, String connectedLetter) {
        //1 - red, 2 - blue, 3 - black
        if (wireColor == 1) {
            if (redDecisions[redCount].contains(connectedLetter)) {
                System.out.println("CUT");
            }
            else {
                System.out.println("DO NOT CUT");
            }

            redCount++;
        }
        else if (wireColor == 2) {
            if (blueDecisions[blueCount].contains(connectedLetter)) {
                System.out.println("CUT");
            }
            else {
                System.out.println("DO NOT CUT");
            }

            blueCount++;
        }
        else {
            if (blackDecisions[blackCount].contains(connectedLetter)) {
                System.out.println("CUT");
            }
            else {
                System.out.println("DO NOT CUT");
            }

            blackCount++;
        }
    }
}
