/**
 * Class used to solve the complicated wire module in "Keep Talking and Nobody Explodes"
 * 
 * @author: Edric Lee
 * @version 08.04.2021
 */
public class ComplicatedWireSolver {


    //Colors: FIVE colors total (1-Red / Red and White, 2-Blue / Blue and White, 3-Red and Blue, 4-White)
    private int wireColor;

    //indicator of the existence of a star symbol on the wire
    private boolean starSymbol;

    //indicator of the existence of an LED on the wire
    private boolean ledOn;

    //indicator of the existence of a parallel port on the bomb
    private boolean parallelPort;

    //The last digit on the serial number written on the bomb
    private int serialNumberLastDigit;

    //the number of batteries on the bomb
    private int numberOfBatteries;

    /**
     * Constructor for the ComplicatedWireSolver
     * 
     * @param port the existence of a parallel port
     * @param lastDigit the last digit of the serial number
     * @param numBatteries the number of batteries on the bomb
     */
    public ComplicatedWireSolver(boolean port, int lastDigit, int numBatteries) {
        parallelPort = port;
        serialNumberLastDigit = lastDigit;
        numberOfBatteries = numBatteries;
    }

    /**
     * The solver method for the complicated wire module
     * 
     * @param color color(s) of the wire
     * @param star existence of a star on the wire
     * @param led existence of an LED on the wire
     */
    public void solveComplicatedWire(int color, boolean star, boolean led) {
        wireColor = color;
        starSymbol = star;
        ledOn = led;

        //If the wire is RED
        if (wireColor == 1) {
            //If wire has STAR AND LED
            if (starSymbol == true && ledOn == true) {
                bCondition();
            }
            //If wire has STAR ONLY
            else if (starSymbol == true) {
                cCondition();
            }
            //If wire has LED ONLY
            else if (ledOn == true) {
                bCondition();
            }
            //If wire has NONE
            else {
                sCondition();
            }

        }
        //If the wire is BLUE
        else if (wireColor == 2) {
            //If wire has STAR AND LED
            if (starSymbol == true && ledOn == true) {
                pCondition();
            }
            //If wire has STAR ONLY
            else if (starSymbol == true) {
                dCondition();
            }
            //If wire has LED ONLY
            else if (ledOn == true) {
                pCondition();
            }
            //If wire has NONE
            else {
                sCondition();
            }
        }
        //If the wire is BOTH RED AND BLUE
        else if (wireColor == 3) {
            //If wire has STAR AND LED
            if (starSymbol == true && ledOn == true) {
                dCondition();
            }
            //If wire has STAR ONLY
            else if (starSymbol == true) {
                pCondition();
            }
            //If wire has LED ONLY
            else if (ledOn == true) {
                sCondition();
            }
            //If wire has NONE
            else {
                sCondition();
            }
        }
        //If the wire is WHITE
        else {
            //If wire has STAR AND LED
            if (starSymbol == true && ledOn == true) {
                bCondition();
            }
            //If wire has STAR ONLY
            else if (starSymbol == true) {
                cCondition();
            }
            //If wire has LED ONLY
            else if (ledOn == true) {
                dCondition();
            }
            //If wire has NONE
            else {
                cCondition();
            }
        }
    }

    /**
     * Parameter combination lands on choice B on the manual's diagram
     */
    public void bCondition() {
        //Cut the wire if the bomb has two or more batteries
        if (numberOfBatteries >= 2) {
            System.out.println("Cut the wire");
        }
        else {
            System.out.println("Do not cut the wire");
        }
    }

    /**
     * Parameter combination lands on choice P on the manual's diagram
     */
    public void pCondition() {
        //Cut the wire if the bomb has a parallel port
        if (parallelPort == true) {
            System.out.println("Cut the wire");
        }
        else {
            System.out.println("Do not cut the wire");
        }
    }

    /**
     * Parameter combination lands on choice S on the manual's diagram
     */
    public void sCondition() {
        //Cut the wire if the last digit of the serial number is even
        if (serialNumberLastDigit % 2 == 0) {
            System.out.println("Cut the wire");
        }
        else {
            System.out.println("Do not cut the wire");
        }
    }

    /**
     * Parameter combination lands on choice D on the manual's diagram
     */
    public void dCondition() {
        //Do not cut the wire
        System.out.println("Do not cut the wire");
    }

    /**
     * Parameter combination lands on choice C on the manual's diagram
     */
    public void cCondition() {
        //Cut the wire
        System.out.println("Cut the wire");
    }

}
