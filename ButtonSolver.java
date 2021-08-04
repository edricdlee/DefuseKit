/**
 * Class used to solve the button module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class ButtonSolver {

    //Button has a color (1-Blue, 2-White, 3-Yellow, 4-Red, 5-Other)
    private int buttonColor;

    //Button may or may not have a label
    private String buttonLabel;

    //Number of batteries on the device
    private int numberOfBatteries;

    //Lit indicator label
    private String litIndicatorLabel;

    /**
     * Constructor for the ButtonSolver
     * 
     * @param bColor Color of the button
     * @param bLabel Label of the button
     * @param numBatteries Number of batteries on the bomb
     * @param litLabel The label on the lit indicator
     */
    public ButtonSolver(int bColor, String bLabel, int numBatteries, String litLabel) {       
        buttonColor = bColor;
        buttonLabel = bLabel;
        numberOfBatteries = numBatteries;
        litIndicatorLabel = litLabel;
    }

    /**
     * Solver method for the button module.
     * No additional params are required other than those given in the constructor
     */
    public void solveButton() {
        //If the button is blue and the button says "Abort", hold the button and refer to "Releasing a Held Button"
        if (buttonColor == 1 && buttonLabel.equals("Abort")) {
            holdButtonProtocol();
        }
        else {
            //If there is more than 1 battery on the bomb and the button says "Detonate"
            //press and immediately release the button
            if (numberOfBatteries > 1 && buttonLabel.equals("Detonate")) {
                System.out.println("Press and immediately release the button");
            }
            else {
                //If the button is white and there is a lit indicator with label CAR,
                //hold the button and refer to "Releasing a Held Button"
                if (buttonColor == 2 && litIndicatorLabel.equals("CAR")) {
                    holdButtonProtocol();
                }
                else {
                    //If there are more than 2 batteries on the bomb and there is a lit indicator
                    //with label FRK, press and immediately release the button
                    if (numberOfBatteries > 2 && litIndicatorLabel.equals("FRK")) {
                        System.out.println("Press and immediately release the button");
                    }
                    else {
                        //If the button is yellow, hold the button and refer to "Releasing a Held Button"
                        if (buttonColor == 3) {
                            holdButtonProtocol();
                        }
                        else {
                            //If the button is red and the button says "Hold",
                            //press and immediately release the button
                            if (buttonColor == 4 && buttonLabel.equals("Hold")) {
                                System.out.println("Press and immediately release the button");
                            }
                            else {
                                //If none of the above apply, hold the button and refer to "Releasing a Held Button"
                                holdButtonProtocol();
                            }
                        }
                    }
                        
                }
            }
        }

    }

    /**
     * Protocol for if the defuser must hold down the button and release at a certain time.
     * This protocol must always be done live so only print statements exist.
     */
    public void holdButtonProtocol() {
        System.out.println("Hold the button");
        System.out.println("Blue: Release when the countdown timer has a 4 in any position");
        System.out.println("Yellow: Release when the countdown timer has a 5 in any position");
        System.out.println("Other: Release when the countdown timer has a 1 in any position");
    }


}
