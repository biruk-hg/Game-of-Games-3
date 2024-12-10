import java.util.*;
public class RedThread
{
    static int threadtotal = 20;
    static int pickingquantity;
    static List<Integer> spools = new ArrayList<>();
    static int redThread;
   public static void gameSetup()
   {
       //Creating Picking Quantity per turn
       Scanner sc = new Scanner(System.in);
       System.out.print("Please enter the picking quantity: ");
       pickingquantity = sc.nextInt();
       if(pickingquantity < 10)
       {
           System.out.println("Please enter a valid picking quantity, quantity must be greater than or equal to 10!");
           System.out.print("Enter valid picking quantity here: ");
           pickingquantity = sc.nextInt();
       }
       //Creating Spool Set
       spools.clear();
       for(int i = 0; i <= 20; i++)
       {
           spools.add(i+1);
       }
       int k = 0;

       //Choosing Red Thread
       Random rand = new Random();
       redThread = rand.nextInt(20) + 1;

   }
   //Playing against Computer
    public static int playingvsComputer()
    {
        gameSetup();
        int turns = pickingquantity;
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < pickingquantity; i++)
        {
            System.out.print("Please enter select the threads you would like to pick from the list below: ");
            displayRem();
            System.out.print("Please enter a number for the spool you would like to choose: ");
            int picked = sc.nextInt();
            if(!exists(spools,picked))
            {
                System.out.print("Invalid choice, please select a spool from the list: ");
                picked = sc.nextInt();
            }
            else if(picked == redThread)
            {
                System.out.println("Red Thread Selected, You have won the game!");
                return 1;
            }
            else
            {
                System.out.println("Wrong thread selected!");
                spools.remove(Integer.valueOf(picked));
                threadtotal--;
                turns--;
                System.out.println("Turns Remaining: " + turns);
            }
        }
        System.out.println("Player has run out of turns");
        System.out.println();
        System.out.println("Computer Now Selecting Threads...");
        System.out.println("Game Over Computer has won the game!, Thread was " + redThread);
        return 0;
    }
    //Creating Player Vs. Player
    public static int pvp() {
        Scanner sc = new Scanner(System.in);
        gameSetup();

        //Deciding who goes first
        Random select = new Random();
        int sel = select.nextInt(2) + 1;
        if (sel == 1) {
            System.out.println("Player 1 goes first!");
        } else {
            System.out.println("Player 2 goes first!");
        }
        if(sel == 1) {
            //Creating Player 1s turn
            int turnsp1 = pickingquantity;
            int turnsp2 = 20 - turnsp1;
                while (turnsp1 > 0) {
                    for (int i = 0; i < pickingquantity; i++) {
                        System.out.print("Please enter select the threads you would like to pick from the list below: ");
                        displayRem();
                        System.out.print("Please enter a number for the spool you would like to choose: ");
                        int picked = sc.nextInt();
                        if (!exists(spools, picked)) {
                            System.out.print("Invalid choice, please select a spool from the list: ");
                            picked = sc.nextInt();
                        } else if (picked == redThread) {
                            System.out.println("Red Thread Selected, Player 1 have won the game!");
                            return 1;

                        } else {
                            System.out.println("Wrong thread selected!");
                            spools.remove(Integer.valueOf(picked));
                            threadtotal--;
                            turnsp1--;
                            System.out.println("Turns Remaining: " + turnsp1);
                        }
                    }
                    System.out.println("Player 1 has run out of turns");
                }
            //Creating Player 2s turn
            System.out.println("Player 2's turn");
            int p2turns = turnsp2;
            for (int i = 0; i < turnsp2; i++) {
                System.out.print("Please enter select the threads you would like to pick from the list below: ");
                displayRem();
                System.out.print("Please enter a number for the spool you would like to choose: ");
                int picked = sc.nextInt();
                if (!exists(spools, picked)) {
                    System.out.print("Invalid choice, please select a spool from the list: ");
                    picked = sc.nextInt();
                } else if (picked == redThread) {
                    System.out.println("Red Thread Selected, Player 2 have won the game!");
                    return 0;

                } else {
                    System.out.println("Wrong thread selected!");
                    spools.remove(Integer.valueOf(picked));
                    threadtotal--;
                    p2turns--;
                    System.out.println("Turns Remaining: " + p2turns);
                }

            }
            System.out.println("Player 2 has run out of turns");
        }
        else
        {
            int turnsp2 = pickingquantity;
            int turnsp1 = 20 - turnsp2;
            //Creating Player 2s turn
            System.out.println("Player 2's turn");
            for (int i = 0; i < pickingquantity; i++) {
                System.out.print("Please enter select the threads you would like to pick from the list below: ");
                displayRem();
                System.out.print("Please enter a number for the spool you would like to choose: ");
                int picked = sc.nextInt();
                if (!exists(spools, picked)) {
                    System.out.print("Invalid choice, please select a spool from the list: ");
                    picked = sc.nextInt();
                } else if (picked == redThread) {
                    System.out.println("Red Thread Selected, Player 2 have won the game!");
                    return 0;

                } else {
                    System.out.println("Wrong thread selected!");
                    spools.remove(Integer.valueOf(picked));
                    threadtotal--;
                    turnsp2--;
                    System.out.println("Turns Remaining: " + turnsp2);
                }
            }
            System.out.println("Player 2 has run out of turns");
            //Creating Player 1s turn
            System.out.println("Player 1's turn");
            int p1turns = turnsp1;
            while (turnsp1 > 0) {
                for (int i = 0; i < turnsp1; i++) {
                    System.out.print("Please enter select the threads you would like to pick from the list below: ");
                    displayRem();
                    System.out.print("Please enter a number for the spool you would like to choose: ");
                    int picked = sc.nextInt();
                    if (!exists(spools, picked)) {
                        System.out.print("Invalid choice, please select a spool from the list: ");
                        picked = sc.nextInt();
                    } else if (picked == redThread) {
                        System.out.println("Red Thread Selected, Player 1 have won the game!");
                        return 1;

                    } else {
                        System.out.println("Wrong thread selected!");
                        spools.remove(Integer.valueOf(picked));
                        threadtotal--;
                        p1turns--;
                        System.out.println("Turns Remaining: " + p1turns);
                    }
                }
                System.out.println("Player 1 has run out of turns");
            }
        }
        return -1;
   }


    private static boolean exists(List<Integer> l, int q)
    {
        if(l.contains(q))
            return true;
        return false;
    }

    private static void displayRem()
    {
        int k = 0;
        while(k < threadtotal)
        {
            if(k == 0)
            {
                System.out.print("[");
            }
            if(k != threadtotal - 1) {
                System.out.print(spools.get(k) + ",");
            }
            if(k == threadtotal - 1)
            {
                System.out.println(spools.get(k) + "]");
            }
            k++;
        }
    }

    public static void totalgame()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select the format of the game you would like to play:");
        System.out.println("Player vs. Player");
        System.out.println("Play vs. Computer");
        System.out.print("Please Enter fomat Here: ");
        String input = sc.nextLine();
        if(input.equalsIgnoreCase("Player vs. Player"))
        {
            pvp();
        }
        else if(input.equalsIgnoreCase("Play vs. Computer"))
        {
            playingvsComputer();
        }
        else
        {
            System.out.println("Not a valid input please select a valid game format");
        }
    }



   public static void main(String[] args)
   {
      totalgame();
   }



}
