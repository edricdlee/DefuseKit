import java.util.Scanner;

/**
 * Main class of the DefuseKit.
 * Purpose of this is to prompt the user for the inputs required for each class to be
 * able to solve their specific module. It will also provide a menu for users to be
 * able to choose which module they would like solved.
 */
public class Defuser {



    /**
     * Main class, runs the menu which prompts the user to select a module
     * @param args
     */
    public static void main(String args[]) {
        menu();
    }

    /**
     * Creates a WireSequenceSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param wsInput the scanner used to store user inputs
     */
    public static void solveWireSequence(Scanner wsInput) {
        WireSequenceSolver wsSolver = new WireSequenceSolver();
        boolean exit = false;
        int wireNum = 1;
        //Need to know the color of the wire and the letter it is connected to.
        //1-red, 2-blue, 3-black

        while (!exit) {
            int color = 1;
            String letter = "A";

            //Prompt user for color
            System.out.println("What color is wire " + wireNum + "?");
            System.out.println("1 - Red");
            System.out.println("2 - Blue");
            System.out.println("3 - Black");

            boolean validColor = false;

            while (!validColor) {
                String colorInput = wsInput.nextLine();

                if (colorInput.equals("1") || colorInput.equals("2") || colorInput.equals("3")) {
                    validColor = true;
                    color = Integer.parseInt(colorInput);
                }
                else {
                    System.out.println("Please enter a valid input");
                    System.out.println("1 - Red");
                    System.out.println("2 - Blue");
                    System.out.println("3 - Black");
                }
            }

            //Prompt user for letter
            System.out.println("What letter is the wire connected to? (A, B, C)");

            boolean validLetter = false;

            while (!validLetter) {
                String letterInput = wsInput.nextLine();

                if (letterInput.equalsIgnoreCase("A") || letterInput.equalsIgnoreCase("B") || letterInput.equalsIgnoreCase("C")) {
                    validLetter = true;
                    letter = letterInput;
                }
                else {
                    System.out.println("Please enter a valid letter (A, B, C)");
                }
            }

            wsSolver.solveSingleWire(color, letter);

            System.out.println("Press enter to solve next wire, enter 'e' to exit to menu.");
            String exitInput = wsInput.nextLine();

            if (exitInput.equalsIgnoreCase("e")) {
                exit = true;
            }
        }

    }

    /**
     * Creates a ComplicatedWireSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param cwInput the scanner used to store user inputs
     */
    public static void solveComplicatedWire(Scanner cwInput) {
        
        //Needed Variables to solve complicated wires:
        // (Number of batteries on bomb, Serial number, parallel port)
        int numBatteries = 0;
        int serialLastDigit = 0;
        boolean port = false;

        //Prompt user for number of batteries
        System.out.println("How many batteries are on the bomb?");
        boolean validInput = false;
        while (!validInput) {
            String batteryInput = cwInput.nextLine();
            if (batteryInput.contains("0") || batteryInput.contains("1") || batteryInput.contains("2") ||
            batteryInput.contains("3") || batteryInput.contains("4") || batteryInput.contains("5") ||
            batteryInput.contains("6") || batteryInput.contains("7") || batteryInput.contains("8") ||
            batteryInput.contains("9")) {
                validInput = true;
                String batteryNumberString = batteryInput.replaceAll("[^\\d]", "");
                numBatteries = Integer.parseInt(batteryNumberString);
            }
            else {
                System.out.println("Please enter the number of batteries. (input 0 if there are no batteries)");
            }
        }

        //Prompt user for serial number
        System.out.println("Enter the serial number.");
        String serialNumber = cwInput.nextLine();
        serialLastDigit = findLastDigit(serialNumber);

        //Prompt user for parallel port
        System.out.println("Is there a parallel port on the bomb?");
        System.out.println("y - yes");
        System.out.println("n - no");

        String portYesNo = cwInput.nextLine();
        if (portYesNo.contains("y") || portYesNo.contains("Y")) {
            port = true;
        }

        //Start solving wires from here
        ComplicatedWireSolver cwSolver = new ComplicatedWireSolver(port, serialLastDigit, numBatteries);

        boolean exit = false;

        while (!exit) {
            int color = 0;
            boolean star = false;
            boolean led = false;

            //Color
            System.out.println("What color is the wire?");
            System.out.println("1 - Red / Red and White");
            System.out.println("2 - Blue / Blue and White");
            System.out.println("3 - Red and Blue");
            System.out.println("4 - White");
            boolean validColor = false;
            
            while (!validColor) {
                String colorInput = cwInput.nextLine();
                
                if (colorInput.equals("1") || colorInput.equals("2") ||
                colorInput.equals("3") || colorInput.equals("4")) {
                    color = Integer.parseInt(colorInput);
                }
                else {
                    System.out.println("Please enter a valid color");
                    System.out.println("1 - Red / Red and White");
                    System.out.println("2 - Blue / Blue and White");
                    System.out.println("3 - Red and Blue");
                    System.out.println("4 - White");
                }
            }


            //Star
            System.out.println("Is there a star on the wire?");
            System.out.println("y - yes");
            System.out.println("n - no");

            String starYesNo = cwInput.nextLine();
            if (starYesNo.contains("y") || starYesNo.contains("Y")) {
                star = true;
            }

            //led
            System.out.println("Is there an LED on the wire?");
            System.out.println("y - yes");
            System.out.println("n - no");

            String ledYesNo = cwInput.nextLine();
            if (ledYesNo.contains("y") || ledYesNo.contains("Y")) {
                led = true;
            }

            cwSolver.solveComplicatedWire(color, star, led);

            System.out.println("Press enter to solve another wire or 'e' to exit to menu");
            String exitInput = cwInput.nextLine();

            if (exitInput.equalsIgnoreCase("e")) {
                exit = true;
            }
        }


    }

    /**
     * Creates a MemorySolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param mInput the scanner used to store user inputs
     */
    public static void solveMemory(Scanner mInput) {
        MemorySolver mSolver = new MemorySolver();
        boolean validInput = false;

        //STAGE 1
        System.out.println("\nStage 1");
        System.out.println("--------------------------------------------------");
        System.out.println("What is the display? (1, 2, 3, 4)");

        while (!validInput) {
            String stageOneInput = mInput.nextLine();
            if (stageOneInput.equals("1") || stageOneInput.equals("2") || stageOneInput.equals("3") || stageOneInput.equals("4")) {
                validInput = true;
                mSolver.solveStageOne(Integer.parseInt(stageOneInput));
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        //STAGE 2
        int stageTwoPosition = 0;

        System.out.println("\nStage 2");
        System.out.println("--------------------------------------------------");
        System.out.println("What position is the button labeled '4' in? (1, 2, 3, 4)");
        
        validInput = false;
        while (!validInput) {
            String fourPosition = mInput.nextLine();
            if (fourPosition.equals("1") || fourPosition.equals("2") || fourPosition.equals("3") || fourPosition.equals("4")) {
                validInput = true;
                stageTwoPosition = Integer.parseInt(fourPosition);
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        System.out.println("\nWhat is the display? (1, 2, 3, 4)");
        
        validInput = false;
        while (!validInput) {
            String stageTwoInput = mInput.nextLine();
            if (stageTwoInput.equals("1") || stageTwoInput.equals("2") || stageTwoInput.equals("3") || stageTwoInput.equals("4")) {
                validInput = true;
                mSolver.solveStageTwo(Integer.parseInt(stageTwoInput), stageTwoPosition);
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        //STAGE 3
        int stageThreePosition = 0;

        System.out.println("\nStage 3");
        System.out.println("--------------------------------------------------");
        System.out.println("What position is the button labeled '4' in? (1, 2, 3, 4)");
        
        validInput = false;
        while (!validInput) {
            String fourPosition = mInput.nextLine();
            if (fourPosition.equals("1") || fourPosition.equals("2") || fourPosition.equals("3") || fourPosition.equals("4")) {
                validInput = true;
                stageThreePosition = Integer.parseInt(fourPosition);
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        System.out.println("\nWhat is the display? (1, 2, 3, 4)");
        
        validInput = false;
        while (!validInput) {
            String stageThreeInput = mInput.nextLine();
            if (stageThreeInput.equals("1") || stageThreeInput.equals("2") || stageThreeInput.equals("3") || stageThreeInput.equals("4")) {
                validInput = true;
                mSolver.solveStageThree(Integer.parseInt(stageThreeInput), stageThreePosition);
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        //STAGE 4
        System.out.println("\nStage 4");
        System.out.println("--------------------------------------------------");
        System.out.println("What is the display? (1, 2, 3, 4)");

        validInput = false;
        while (!validInput) {
            String stageFourInput = mInput.nextLine();
            if (stageFourInput.equals("1") || stageFourInput.equals("2") || stageFourInput.equals("3") || stageFourInput.equals("4")) {
                validInput = true;
                mSolver.solveStageFour(Integer.parseInt(stageFourInput));
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        //STAGE 5
        System.out.println("\nStage 5");
        System.out.println("--------------------------------------------------");
        System.out.println("What is the display? (1, 2, 3, 4)");
        
        validInput = false;
        while (!validInput) {
            String stageFiveInput = mInput.nextLine();
            if (stageFiveInput.equals("1") || stageFiveInput.equals("2") || stageFiveInput.equals("3") || stageFiveInput.equals("4")) {
                validInput = true;
                mSolver.solveStageFive(Integer.parseInt(stageFiveInput));
            }
            else {
                System.out.println("Please enter a number between 1 and 4");
            }
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Press Enter to return to menu");
        mInput.nextLine();
    }

    /**
     * Creates a WhosOnFirstSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param wofInput the scanner used to store user inputs
     */
    public static void solveWhosOnFirst(Scanner wInput) {
        WhosOnFirstSolver wofSolver = new WhosOnFirstSolver();

        boolean quitOut = false;

        while (!quitOut) {            
            System.out.println("Input the word on the display");      
            
            //Check validity of step one input
            boolean validStepOneInput = false;
            while (!validStepOneInput) {
                String stepOneInput = wInput.nextLine();

                int validInputCheck = wofSolver.solveStepOne(stepOneInput);

                if (validInputCheck == 1) {
                    validStepOneInput = true;
                }
            }

            //Step One prompts user to enter the letter combination read back to them
            String stepTwoInput = wInput.nextLine();
            wofSolver.solveStepTwo(stepTwoInput);

            //Module repeats itself through multiple stages
            System.out.println("--------------------------------------------------");
            System.out.println("Press enter to repeat module");
            System.out.println("Input 'e' to exit to menu");
            String option = wInput.nextLine();

            if (option.equals("e")) {
                quitOut = true;
            }
        }
        
    }

    /**
     * Creates a ButtonSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param bInput the scanner used to store user inputs
     */
    public static void solveButton(Scanner bInput) {
        //Required user inputs: button color, button label, number of batteries, lit indicator
        int buttonColorNum = 0;
        String buttonLabel = "";
        int numBatteries = 0;
        String litIndicatorLabel = "";

        //PROMPT USER FOR BUTTON COLOR
        //Button colors are (1-Blue, 2-White, 3-Yellow, 4-Red, 5-Other)
        System.out.println("What color is the button?");
        System.out.println("1 - Blue");
        System.out.println("2 - White");
        System.out.println("3 - Yellow");
        System.out.println("4 - Red");
        System.out.println("5 - Other\n");

        //Check validity of input
        boolean validInput = false;
        while (!validInput) {
        String buttonColor = bInput.nextLine();
            if (buttonColor.equals("1") || buttonColor.equals("2") || buttonColor.equals("3") ||
            buttonColor.equals("4") || buttonColor.equals("5")) {
                validInput = true;
                buttonColorNum = Integer.parseInt(buttonColor);
            }
            else {
                System.out.println("Please enter a valid input:");
                System.out.println("1 - Blue");
                System.out.println("2 - White");
                System.out.println("3 - Yellow");
                System.out.println("4 - Red");
                System.out.println("5 - Other\n");
            }
        }

        //PROMPT USER FOR NUMBER OF BATTERIES ON BOMB
        System.out.println("How many batteries are on the bomb?");

        validInput = false;
        while (!validInput) {
            String batteryInput = bInput.nextLine();
            if (batteryInput.contains("0") || batteryInput.contains("1") || batteryInput.contains("2") ||
            batteryInput.contains("3") || batteryInput.contains("4") || batteryInput.contains("5") ||
            batteryInput.contains("6") || batteryInput.contains("7") || batteryInput.contains("8") ||
            batteryInput.contains("9")) {
                validInput = true;
                String batteryNumberString = batteryInput.replaceAll("[^\\d]", "");
                numBatteries = Integer.parseInt(batteryNumberString);
            }
            else {
                System.out.println("Please enter the number of batteries. (input 0 if there are no batteries)");
            }
        }

        //PROMPT USER FOR BUTTON LABEL IF IT EXISTS
        System.out.println("Is there a label on the button?");
        System.out.println("y - yes");
        System.out.println("n - no");

        boolean buttonLabelExist = false;

        String buttonLabelYesNo = bInput.nextLine();
        if (buttonLabelYesNo.contains("y") || buttonLabelYesNo.contains("Y")) {
            buttonLabelExist = true;
        }

        if (buttonLabelExist) {
            System.out.println("What is labeled on the button?");
            buttonLabel = bInput.nextLine();
        }

        //PROMPT USER FOR A LABELED LIT INDICATOR IF IT EXISTS
        System.out.println("Is there a labeled lit indicator on the bomb?");
        System.out.println("y - yes");
        System.out.println("n - no");

        boolean litLabelExist = false;

        String litLabelYesNo = bInput.nextLine();
        if (litLabelYesNo.contains("y") || litLabelYesNo.contains("Y")) {
            litLabelExist = true;
        }

        if (litLabelExist) {
            System.out.println("What is labeled on the lit indicator?");
            litIndicatorLabel = bInput.nextLine();
        }

        ButtonSolver bSolver = new ButtonSolver(buttonColorNum, buttonLabel, numBatteries, litIndicatorLabel);
        bSolver.solveButton();
        System.out.println("--------------------------------------------------");
        System.out.println("Press Enter to return to menu");
        bInput.nextLine();
    }

    /**
     * Creates a SimpleWireSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param swInput the scanner used to store user inputs
     */
    public static void solveSimpleWire(Scanner swInput) {
        //NOTE
        //Colors: FIVE colors total (1-Red, 2-White, 3-Blue, 4-Yellow, 5-Black)
        //Number of wires: ONLY 3-6
        
        int serialLastDigit = 0;
        int numberOfWires = 1;

        //Prompt user for serial number
        System.out.println("Enter the serial number.");
        String serialNumber = swInput.nextLine();
        serialLastDigit = findLastDigit(serialNumber);

        //Prompt user for number of wires on the module
        System.out.println("Enter the number of wires (3-6)");
        String wireInput = swInput.nextLine();

        //Check validity of input
        boolean validInputNumWires = false;

        while (!validInputNumWires) {
            if (wireInput.equals("3") || wireInput.equals("4") || wireInput.equals("5") || wireInput.equals("6")) {
                validInputNumWires = true;
                numberOfWires = Integer.parseInt(wireInput);
            }
            else {
                System.out.println("Please enter a valid number of wires. (3, 4, 5, 6)");
            }
        }

        int[] wireColors = new int[numberOfWires];

        //Prompt user to fill in the wire colors from top to bottom
        for (int i = 0; i < wireColors.length; i++) {
            System.out.println("\nWhat color is wire " + (i + 1) + "?");
            System.out.println("1 - Red");
            System.out.println("2 - White");
            System.out.println("3 - Blue");
            System.out.println("4 - Yellow");
            System.out.println("5 - Black");
            String colorInput = swInput.nextLine();

            //Check validity of the input
            boolean validInputColor = false;

            while (!validInputColor) {
                if (colorInput.equals("1") || colorInput.equals("2") || colorInput.equals("3") ||
                colorInput.equals("4") || colorInput.equals("5")) {
                    validInputColor = true;
                    wireColors[i] = Integer.parseInt(colorInput);
                }
                else {
                    System.out.println("Please input a valid option.");
                }
            }
        }

        SimpleWireSolver swSolver = new SimpleWireSolver(wireColors, serialLastDigit);
        swSolver.solveSimpleWire();
        System.out.println("--------------------------------------------------");
        System.out.println("Press Enter to return to menu");
        swInput.nextLine();
    }


    /**
     * Creates a PasswordSolver and prompts user for the proper inputs required for
     * it to solve the module
     * 
     * @param passwordInput the scanner used to store user inputs
     */
    public static void solvePassword(Scanner passwordInput) {
        
        
        PasswordSolver pSolver = new PasswordSolver();
        boolean exit = false;

        //Begin by showing user list of possible passwords
        pSolver.printAllPasswords();
        
        //Prompt user to pick which dial to update, reprompting them if
        //their input is invalid and if there are more than one passwords left
        while (!exit) {
            

            System.out.println("Select dial number (1-6) or enter 'e' to exit");
            String dialNum = passwordInput.nextLine();

            //Check validity of input
            if (dialNum.equals("1") || dialNum.equals("2") || dialNum.equals("3") ||
            dialNum.equals("4") || dialNum.equals("5") || dialNum.equals("6")) {
                int dialIndex = Integer.parseInt(dialNum) - 1;

                //Prompt user to enter the letters on the dial
                System.out.println("Please enter all letters on the dial");
                String dialLetters = passwordInput.nextLine();

                //Update the dial and filter out passwords
                pSolver.update(dialIndex, dialLetters);
                pSolver.printPossiblePasswords();

            }
            else if (dialNum.equals("e")) {
                exit = true;
            }
            //Reprompt user if input is invalid
            else {
                System.out.println("Not a valid input.");
            }

            
        }

        System.out.println("end of passwords");

    }


    /**
     * The main menu of the program used to prompt the user to select a module
     */
    public static void menu() {

        boolean exit = false;


        //MENU OPTIONS
        Scanner menuInput = new Scanner(System.in);
        while (!exit) {
            

            System.out.println("Please select a module.");
            System.out.println("--------------------------------------------------");
            System.out.println("1 - Simple Wires");
            System.out.println("2 - The Button");
            System.out.println("3 - Who's on First");
            System.out.println("4 - Memory");
            System.out.println("5 - Complicated Wires");
            System.out.println("6 - Wire Sequences");
            System.out.println("7 - Passwords");
            System.out.println("--------------------------------------------------");
            System.out.println("(s - update serial number)    (e - exit program)");
        
            String selectedModule = menuInput.nextLine();
        

            if (selectedModule.equals("1")) {
                solveSimpleWire(menuInput);
            }
            else if (selectedModule.equals("2")) {
                solveButton(menuInput);
            }
            else if (selectedModule.equals("3")) {
                solveWhosOnFirst(menuInput);
            }
            else if (selectedModule.equals("4")) {
                solveMemory(menuInput);
            }
            else if (selectedModule.equals("5")) {
                solveComplicatedWire(menuInput);
            }
            else if (selectedModule.equals("6")) {
                solveWireSequence(menuInput);
            }
            else if (selectedModule.equals("7")) {
                solvePassword(menuInput);
            }
            else if (selectedModule.equalsIgnoreCase("e")) {
                exit = true;
            }
            else {
                System.out.println("Not a valid input");
            }

           
        }
        menuInput.close();
    }

    /**
     * Finds the last digit of the serial number given by the user
     * given that the input is valid
     * 
     * @param serialNumber
     * @return the last digit of the serial number
     */
    public static int findLastDigit(String serialNumber) {
        int lastDigit = 0;

        String digits = serialNumber.replaceAll("[^\\d]", "");

        if (digits.contains("0") || digits.contains("1") || digits.contains("2") ||
        digits.contains("3") || digits.contains("4") || digits.contains("5") ||
        digits.contains("6") || digits.contains("7") || digits.contains("8") ||
        digits.contains("9")) {
            lastDigit = Integer.parseInt(digits) % 10; 
        }

        return lastDigit;
    }

}
