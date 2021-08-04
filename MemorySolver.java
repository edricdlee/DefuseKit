/**
 * Class used to solve the memory module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class MemorySolver {

    /**
     * These are the answers for each stage of the module
     */
    private int stageOneAnswer;
    private int stageTwoAnswer;
    private int stageThreeAnswer;
    private int stageFourAnswer;
    private int stageFiveAnswer;


    /**
     * Constructor for MemorySolver
     * No params needed as answers are not known at the beginning of the module
     */
    public MemorySolver() {
        stageOneAnswer = 0;
        stageTwoAnswer = 0;
        stageThreeAnswer = 0;
        stageFourAnswer = 0;
        stageFiveAnswer = 0;
    }

    /**
     * solver method for the first stage of the memory module
     * 
     * @param display the output on the display of the module
     */
    public void solveStageOne(int display) {
        if (display == 3) {
            stageOneAnswer = 3;
        }
        else if (display == 4) {
            stageOneAnswer = 4;
        }
        else {
            stageOneAnswer = 2;
        }
        System.out.println("\nPRESS BUTTON " + stageOneAnswer);
    }

    /**
     * solver method for the second stage of the memory module
     * 
     * @param display the output on the display of the module
     * @param labelFourPosition the position of the button labeled '4'
     */
    public void solveStageTwo(int display, int labelFourPosition) {
        if (display == 1) {
            stageTwoAnswer = labelFourPosition;
        }
        else if (display == 3) {
            stageTwoAnswer = 1;
        }
        else {
            stageTwoAnswer = stageOneAnswer;
        }
        System.out.println("\nPRESS BUTTON " + stageTwoAnswer);
    }

    /**
     * solver method for the third stage of the memory module
     * 
     * @param display the output on the display of the module
     * @param labelFourPosition the position of the button labeled '4'
     */
    public void solveStageThree(int display, int labelFourPosition) {
        if (display == 1) {
            stageThreeAnswer = stageTwoAnswer;
        }
        else if (display == 2) {
            stageThreeAnswer = stageOneAnswer;
        }
        else if (display == 3) {
            stageThreeAnswer = 3;
        }
        else {
            stageThreeAnswer = labelFourPosition;
        }
        System.out.println("\nPRESS BUTTON " + stageThreeAnswer);
    }

    /**
     * solver method for the fourth stage of the memory module
     * 
     * @param display the output on the display of the module
     */
    public void solveStageFour(int display) {
        if (display == 1) {
            stageFourAnswer = stageOneAnswer;
        }
        else if (display == 2) {
            stageFourAnswer = 1;
        }
        else {
            stageFourAnswer = stageTwoAnswer;
        }
        System.out.println("\nPRESS BUTTON " + stageFourAnswer);
    }

    /**
     * solver method for the fifth stage of the memory module
     * 
     * @param display the output on the display of the module
     */
    public void solveStageFive(int display) {
        if (display == 1) {
            stageFiveAnswer = stageOneAnswer;
        }
        else if (display == 2) {
            stageFiveAnswer = stageTwoAnswer;
        }
        else if (display == 3) {
            stageFiveAnswer = stageThreeAnswer;
        }
        else {
            stageFiveAnswer = stageFourAnswer;
        }
        System.out.println("\nPRESS BUTTON " + stageFiveAnswer);
    }


}
