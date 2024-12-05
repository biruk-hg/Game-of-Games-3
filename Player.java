import java.util.Scanner;
/* POTENTIALLY implement a special player that can execute commands at any time from the input line */
public class Player {
    /* allow for custom player usernames */
    String player_name;
    /* keep track of player score */
    public int player_score = 0;
    /* scanner(sc) to keep track of inputs */
    Scanner sc = new Scanner(System.in);
    /* keep track of players made to automate player_name creation */
    int player_count = 1;

    public Player() {
        set_name();
        player_count++;
    }

    /* set player username, set to P# if no input */
    void set_name() {
        String input;
        System.out.println("What's your name?");
        input = sc.nextLine();
        if (input == null) {
            player_name = "P" + player_count;
        }
        else {
            player_name = input;
        }
    }
    /* retrieve player name */
    String get_name() {
        return player_name;
    }
    /* upon winning, increase the players score */
    void increase_score() {
        player_score++;
    }
    /* retrieve payer score */
    int get_score() {
        return player_score;
    }

}
