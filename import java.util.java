import java.util.Scanner;
import java.util.Random;

class Main {
  /**
   * The program is a game where the player will roll 3 dice to get a total sum of
   * 12 in order to win. If you get over 12 you lose, if you get under 12 you tie
   * the game, either way the game will restart until the user decided to exit the
   * game by pressing "q".
   * 
   * 
   *
   * ludfen-4
   */

  /**
   * Below static strings are there to help you get the messages correct.
   * Autograder checks for these exact strings, so it is mentioned here.
   * You can rename them if you want, and you can directly use them in your code.
   * Just make sure these exact messages are used.
   */
  // 1. Contants
  static final String GAME_START = "Welcome to dice game 12 MF. You must roll 1-3 dice and try to get the sum of 12 ...\n";
  static final String CHOOSE_DICE = "Enter which dice you want to roll [1,2,3] (exit with q):";
  static final String ROUND_WON = "You won!!";
  static final String ROUND_LOST = "You lost!!";
  static final String ROUND_TIE = "You neither won nor lost the round.";
  static final String NEXT_ROUND = "Next round!";
  static final String GAME_OVER = "Game Over!";
  static final String ALREADY_SELECTED_DICE = "Sorry, you have already rolled that dice. Try again";
  static final String INVALID_ENTRY = "Sorry, that is an invalid entry. Try again. Valid entries are 1, 2, 3, and q\n";
  static final String AMOUNT_WIN_STRING = "#win: ";
  static final String AMOUNT_LOST_STRING = " #loss: ";
  static final String SUM_STRING = " sum: ";
  static final int MAX_DICE_VALUE = 6;
  static final int MIN_DICE_VALUE = 1;
  static final int DICE_SUM_TARGET_VALUE = 12;

  public static void main(final String[] args) {
    // 2. Variables

    int dice1Value = 0; // The value of the first dice
    boolean isDice1Rolled = false; // Whether the first dice is rolled or not

    int dice2Value = 0; // The value of the second dice
    boolean isDice2Rolled = false; // Whether the second dice is rolled or not

    int dice3Value = 0; // The value of the third dice
    boolean isDice3Rolled = false; // Whether the third dice is rolled or not

    int sum = 0; // The sum of the dice values
    int winCounter = 0; // The number of wins
    int lossCounter = 0; // The number of losses
    int diceNumber = 0; // the user entered dice number
    int numOfRolls = 0; // the number of rolls in a round

    boolean isPlaying = true; // Whether the game is being played or not
    try (// 3. Ask user to roll the three dices
    Scanner userInput = new Scanner(System.in)) {
        Random rand = new Random();

        System.out.println(GAME_START);

        while (isPlaying) {
          System.out.println(CHOOSE_DICE);

          if (userInput.hasNextInt()) {
            diceNumber = userInput.nextInt();

            if (diceNumber < 1 || diceNumber > 3) {
              System.out.println(INVALID_ENTRY);
              continue; // loops backs to while
            }

            if (diceNumber == 1) {
              if (isDice1Rolled) {
                System.out.println(ALREADY_SELECTED_DICE);
              } else {
                dice1Value = rand.nextInt(6);
                dice1Value++;
                isDice1Rolled = true;
                numOfRolls++;
                sum = sum + dice1Value;
                System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + SUM_STRING + sum + AMOUNT_WIN_STRING
                    + winCounter + AMOUNT_LOST_STRING + lossCounter);
              }

            } else if (diceNumber == 2) {
              if (isDice2Rolled) {
                System.out.println(ALREADY_SELECTED_DICE);
              } else {
                dice2Value = rand.nextInt(6);
                dice2Value++;
                isDice2Rolled = true;
                numOfRolls++;
                sum = sum + dice2Value;
                System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + SUM_STRING + sum + AMOUNT_WIN_STRING
                    + winCounter + AMOUNT_LOST_STRING + lossCounter);
              }
            } else if (diceNumber == 3) {
              if (isDice3Rolled) {
                System.out.println(ALREADY_SELECTED_DICE);
              } else {
                dice3Value = rand.nextInt(6);
                dice3Value++;
                isDice3Rolled = true;
                numOfRolls++;
                sum = sum + dice3Value;
                System.out.println(dice1Value + " " + dice2Value + " " + dice3Value + SUM_STRING + sum + AMOUNT_WIN_STRING
                    + winCounter + AMOUNT_LOST_STRING + lossCounter);
              }
            }

            if (numOfRolls == 3 || sum == 12) {
              if (sum == 12 && numOfRolls == 3) {
                System.out.println(ROUND_WON + AMOUNT_WIN_STRING);
                winCounter++;
                System.out.println(AMOUNT_WIN_STRING + winCounter);

              } else if (sum > 12 && numOfRolls == 3) {
                System.out.println(ROUND_LOST + AMOUNT_LOST_STRING);
                lossCounter++;
                System.out.println(AMOUNT_LOST_STRING + lossCounter);

              } else {
                System.out.println(ROUND_TIE);
              }

              System.out.println(NEXT_ROUND);
              isDice1Rolled = false;
              isDice2Rolled = false;
              isDice3Rolled = false;
              dice1Value = 0;
              dice2Value = 0;
              dice3Value = 0;
              sum = 0;
              numOfRolls = 0;
              continue;
            }
          } else {
            if (userInput.next().charAt(0) == 'q') {
              System.out.println(GAME_OVER);
              System.out.println(AMOUNT_WIN_STRING + winCounter + AMOUNT_LOST_STRING + lossCounter);
              isPlaying = false;
            } else {
              System.out.println(INVALID_ENTRY);
            }

          }
        }
    }
  }
}

// i need the program to calculate the wins and losses and print them out, I
// also need to print out the dice values even when the dice isn't cast yet so
// it looks like this after one dice is cast:" 6 0 0 sum: 6 #win: 0 # loss: 0 "
// i've done the 6 0 0 part.

// (dice1Value + " " + dice2Value + " " + dice3Value + SUM_STRING + winCounter +
// loseCounter);