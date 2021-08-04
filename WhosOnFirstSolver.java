/**
 * Class used to solve the who's on first module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class WhosOnFirstSolver {

    /**
     * Constructor for WhosOnFirstSolver
     */
    public WhosOnFirstSolver() {
        //Nothing to instantiate
    }

    /**
     * solver method for step one of the who's on first module
     * 
     * @param displayOne the output of the display in step one
     * @return 0 if user input is invalid, 1 otherwise
     */
    public int solveStepOne(String displayOne) {
        String displayCap = displayOne.toUpperCase();

        if (displayCap.equals("UR")) {
            System.out.println("Input the letter combination on the TOP LEFT");
        }
        else if (displayCap.equals("FIRST") || displayCap.equals("OKAY") || displayCap.equals("C")) {
            System.out.println("Input the letter combination on the TOP RIGHT");
        }
        else if (displayCap.equals("YES") || displayCap.equals("NOTHING") || displayCap.equals("LED") || 
        displayCap.equals("THEY ARE")) {
            System.out.println("Input the letter combination on the MIDDLE LEFT");
        }
        else if (displayCap.equals("BLANK") || displayCap.equals("READ") || displayCap.equals("RED") ||
        displayCap.equals("YOU") || displayCap.equals("YOUR") || displayCap.equals("YOU'RE") || displayCap.equals("THEIR")) {
            System.out.println("Input the letter combination on the MIDDLE RIGHT");
        }
        else if (displayCap.equals("") || displayCap.equals("REED") || displayCap.equals("LEED") || 
        displayCap.equals("THEY'RE")) {
            System.out.println("Input the letter combination on the BOTTOM LEFT");
        }
        else if (displayCap.equals("DISPLAY") || displayCap.equals("SAYS") || displayCap.equals("NO") || 
        displayCap.equals("LEAD") || displayCap.equals("HOLD ON") || displayCap.equals("YOU ARE") ||
        displayCap.equals("YOU ARE") || displayCap.equals("THERE") || displayCap.equals("SEE") || displayCap.equals("CEE")) {
            System.out.println("Input the letter combination on the BOTTOM RIGHT");
        }
        else {
            System.out.println("Not one of the possible letter combinations on display");
            return 0;
        }
        
        return 1;
    }

    /**
     * solver method for step two of the who's on first module
     * 
     * @param displayTwo the output of the display in step two
     */
    public void solveStepTwo(String displayTwo) {
        String displayCap = displayTwo.toUpperCase();

        System.out.println("Push the first button that appears in the list");
        if (displayCap.equals("READY")) {
            System.out.println("YES, OKAY, WHAT, MIDDLE, LEFT, PRESS, RIGHT, BLANK, READY, NO, FIRST, UHHH, NOTHING, WAIT");
        }
        else if (displayCap.equals("FIRST")) {
            System.out.println("LEFT, OKAY, YES, MIDDLE, NO, RIGHT, NOTHING, UHHH, WAIT, READY, BLANK, WHAT, PRESS, FIRST");
        }
        else if (displayCap.equals("NO")) {
            System.out.println("BLANK, UHHH, WAIT, FIRST, WHAT, READY, RIGHT, YES, NOTHING, LEFT, PRESS, OKAY, NO, MIDDLE");
        }
        else if (displayCap.equals("BLANK")) {
            System.out.println("WAIT, RIGHT, OKAY, MIDDLE, BLANK, PRESS, READY, NOTHING, NO, WHAT, LEFT, UHHH, YES, FIRST");
        }
        else if (displayCap.equals("NOTHING")) {
            System.out.println("UHHH, RIGHT, OKAY, MIDDLE, YES, BLANK, NO, PRESS, LEFT, WHAT, WAIT, FIRST, NOTHING, READY");
        }
        else if (displayCap.equals("YES")) {
            System.out.println("OKAY, RIGHT, UHHH, MIDDLE, FIRST, WHAT, PRESS, READY, NOTHING, YES, LEFT, BLANK, NO, WAIT");
        }
        else if (displayCap.equals("WHAT")) {
            System.out.println("UHHH, WHAT, LEFT, NOTHING, READY, BLANK, MIDDLE, NO, OKAY, FIRST, WAIT, YES, PRESS, RIGHT");
        }
        else if (displayCap.equals("UHHH")) {
            System.out.println("READY, NOTHING, LEFT, WHAT, OKAY, YES, RIGHT, NO, PRESS, BLANK, UHHH, MIDDLE, WAIT, FIRST");
        }
        else if (displayCap.equals("LEFT")) {
            System.out.println("RIGHT, LEFT, FIRST, NO, MIDDLE, YES, BLANK, WHAT, UHHH, WAIT, PRESS, READY, OKAY, NOTHING");
        }
        else if (displayCap.equals("RIGHT")) {
            System.out.println("YES, NOTHING, READY, PRESS, NO, WAIT, WHAT, RIGHT, MIDDLE, LEFT, UHHH, BLANK, OKAY, FIRST");
        }
        else if (displayCap.equals("MIDDLE")) {
            System.out.println("BLANK, READY, OKAY, WHAT, NOTHING, PRESS, NO, WAIT, LEFT, MIDDLE, RIGHT, FIRST, UHHH, YES");
        }
        else if (displayCap.equals("OKAY")) {
            System.out.println("MIDDLE, NO, FIRST, YES, UHHH, NOTHING, WAIT, OKAY, LEFT, READY, BLANK, PRESS, WHAT, RIGHT");
        }
        else if (displayCap.equals("WAIT")) {
            System.out.println("UHHH, NO, BLANK, OKAY, YES, LEFT, FIRST, PRESS, WHAT, WAIT, NOTHING, READY, RIGHT, MIDDLE");
        }
        else if (displayCap.equals("PRESS")) {
            System.out.println("RIGHT, MIDDLE, YES, READY, PRESS, OKAY, NOTHING, UHHH, BLANK, LEFT, FIRST, WHAT, NO, WAIT");
        }
        else if (displayCap.equals("YOU")) {
            System.out.println("SURE, YOU ARE, YOUR, YOU'RE, NEXT, UH HUH, UR, HOLD, WHAT?, YOU, UH UH, LIKE, DONE, U");
        }
        else if (displayCap.equals("YOU ARE")) {
            System.out.println("YOUR, NEXT, LIKE, UH HUH, WHAT?, DONE, UH UH, HOLD, YOU, U, YOU'RE, SURE, UR, YOU ARE");
        }
        else if (displayCap.equals("YOUR")) {
            System.out.println("UH UH, YOU ARE, UH HUH, YOUR, NEXT, UR, SURE, U, YOU'RE, YOU, WHAT?, HOLD, LIKE, DONE");
        }
        else if (displayCap.equals("YOU'RE")) {
            System.out.println("YOU, YOU'RE, UR, NEXT, UH UH, YOU ARE, U, YOUR, WHAT?, UH HUH, SURE, DONE, LIKE, HOLD");
        }
        else if (displayCap.equals("UR")) {
            System.out.println("DONE, U, UR, UH HUH, WHAT?, SURE, YOUR, HOLD, YOU'RE, LIKE, NEXT, UH UH, YOU ARE, YOU");
        }
        else if (displayCap.equals("U")) {
            System.out.println("UH HUH, SURE, NEXT, WHAT?, YOU'RE, UR, UH UH, DONE, U, YOU, LIKE, HOLD, YOU ARE, YOUR");
        }
        else if (displayCap.equals("UH HUH")) {
            System.out.println("UH HUH, YOUR, YOU ARE, YOU, DONE, HOLD, UH UH, NEXT, SURE, LIKE, YOU'RE, UR, U, WHAT?");
        }
        else if (displayCap.equals("UH UH")) {
            System.out.println("UR, U, YOU ARE, YOU'RE, NEXT, UH UH, DONE, YOU, UH HUH, LIKE, YOUR, SURE, HOLD, WHAT?");
        }
        else if (displayCap.equals("WHAT?")) {
            System.out.println("YOU, HOLD, YOU'RE, YOUR, U, DONE, UH UH, LIKE, YOU ARE, UH HUH, UR, NEXT, WHAT?, SURE");
        }
        else if (displayCap.equals("DONE")) {
            System.out.println("SURE, UH HUH, NEXT, WHAT?, YOUR, UR, YOU'RE, HOLD, LIKE, YOU, U, YOU ARE, UH UH, DONE");
        }
        else if (displayCap.equals("NEXT")) {
            System.out.println("WHAT?, UH HUH, UH UH, YOUR, HOLD, SURE, NEXT, LIKE, DONE, YOU ARE, UR, YOU'RE, U, YOU");
        }
        else if (displayCap.equals("HOLD")) {
            System.out.println("YOU ARE, U, DONE, UH UH, YOU, UR, SURE, WHAT?, YOU'RE, NEXT, HOLD, UH HUH, YOUR, LIKE");
        }
        else if (displayCap.equals("SURE")) {
            System.out.println("YOU ARE, DONE, LIKE, YOU'RE, YOU, HOLD, UH HUH, UR, SURE, U, WHAT?, NEXT, YOUR, UH UH");
        }
        else {
            System.out.println("YOU'RE, NEXT, U, UR, HOLD, DONE, UH UH, WHAT?, UH HUH, YOU, LIKE, SURE, YOU ARE, YOUR");
        }
        
    }

}
