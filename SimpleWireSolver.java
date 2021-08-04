/**
 * Class used to solve the simple wire module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class SimpleWireSolver {

    //the last digit in the serial number written on the bomb
    private int serialNumberLastDigit;

    //The order of wires
    private int[] simpleWireSequence;

    //Number of each wire in the sequence
    private int numRed = 0;
    private int numWhite = 0;
    private int numBlue = 0;
    private int numYellow = 0;
    private int numBlack = 0;

    //NOTE
    //Colors: FIVE colors total (1-Red, 2-White, 3-Blue, 4-Yellow, 5-Black)
    //Number of wires: ONLY 3-6

    /**
     * Constructor for SimpleWire solver
     * takes in an array of integers
     * size of the array indicates the number of wires
     * array values indicate the color of the wires
     * 
     * @param wireColors the array indicating the order and color of the wires
     * @param lastDigit the last digit of the serial number
     */
    public SimpleWireSolver(int[] wireColors, int lastDigit) {
        simpleWireSequence = wireColors;
        serialNumberLastDigit = lastDigit;
    }

    /**
     * the solver method for the simple wire module
     * No params are needed as all relevant information is given in constructor
     */
    public void solveSimpleWire() {

        for (int i = 0; i < simpleWireSequence.length; i++) {
            if (simpleWireSequence[i] == 1) {
                numRed++;
            }
            else if (simpleWireSequence[i] == 2) {
                numWhite++;
            }
            else if (simpleWireSequence[i] == 3) {
                numBlue++;
            }
            else if (simpleWireSequence[i] == 4) {
                numYellow++;
            }
            else {
                numBlack++;
            }
        }

        if (simpleWireSequence.length == 3) {
            threeWires();
        }
        else if (simpleWireSequence.length == 4) {
            fourWires();
        }
        else if (simpleWireSequence.length == 5) {
            fiveWires();
        }
        else if (simpleWireSequence.length == 6) {
            sixWires();
        }
        else {
            System.out.println("INVALID NUMBER OF WIRES");
        }
    }


    /**
     * Solver method for if there are three wires
     */
    public void threeWires() {       
        //If there are no red wires, cut the second wire
        if (numRed == 0) {
            System.out.println("Cut the 2nd wire");
        }
        else {
            //Otherwise, if the last wire is white, cut the last wire
            if (simpleWireSequence[2] == 2) {
                System.out.println("Cut the last wire");
            }
            else {
                //Otherwise, if there is more than one blue wire, cut the last blue wire
                if (numBlue > 1) {
                    System.out.println("Cut the last blue wire");
                }
                //Otherwise, cut the last blue wire
                else {
                    System.out.println("Cut the last wire");
                }
            }
        }
    }

    /**
     * Solver method for if there are four wires
     */
    public void fourWires() {
        //If there is more than one red wire and the last digit of
        //the serial number is odd, cut the last red wire
        if (numRed > 1 && serialNumberLastDigit % 2 == 1) {
            System.out.println("Cut the last red wire");
        }
        else {
            //Otherwise, if the last wire is yellow and there are no red wires, cut the first wire
            if (simpleWireSequence[3] == 4 && numRed == 0) {
                System.out.println("Cut the first wire");
            }
            else {
                //Otherwise, if there is exactly one blue wire, cut the first wire
                if (numBlue == 1) {
                    System.out.println("Cut the first wire");
                }
                else {
                    //Otherwise, if there is more than one yellow wire, cut the last wire
                    if (numYellow > 1) {
                        System.out.println("Cut the last wire");
                    }
                    else {
                        //Otherwise, cut the second wire
                        System.out.println("Cut the second wire");
                    }
                }
            }
        }
    }

    /**
     * Solver method for if there are five wires
     */
    public void fiveWires() {
        //If the last wire is black and the last digit of the serial number is odd, cut the fourth wire.
        if (simpleWireSequence[4] == 5 && serialNumberLastDigit % 2 == 1) {
            System.out.println("Cut the fourth wire");
        }
        else {
            //Otherwise, if there is exactly one red wire and there is more than one yellow wire, cut the first wire.
            if (numRed == 1 && numYellow > 1) {
                System.out.println("Cut the first wire");
            }
            else {
                //Otherwise, if there are no black wires, cut the second wire
                if (numBlack == 0) {
                    System.out.println("Cut the second wire");
                }
                else {
                    //Otherwise, cut the first wire
                    System.out.println("Cut the first wire");
                }
            }
        }
    }

    /**
     * Solver method for if there are six wires
     */
    public void sixWires() {
        //If there are no yellow wires and the last digit of the serial number is odd, cut the third wire
        if (numYellow == 0 && serialNumberLastDigit % 2 == 1) {
            System.out.println("Cut the third wire");
        }
        else {
            //Otherwise, if there is exactly one yellow wire and there is more than one white wire,
            //cut the fourth wire
            if (numYellow == 1 && numWhite > 1) {
                System.out.println("Cut the fourth wire");
            }
            else {
                //Otherwise, if there are no red wires, cut the last wire
                if (numRed == 0) {
                    System.out.println("Cut the last wire");
                }
                else {
                    //Otherwise, cut the fourth wire
                    System.out.println("Cut the fourth wire");
                }
            }
        }
    }

}
