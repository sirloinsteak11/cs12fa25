import java.util.Scanner;

public class RPS extends RPSAbstract {
    // Messages for the game.
    protected static final String GAME_NOT_IMPLEMENTED =
            "Game not yet implemented.";
    /**
     * Construct a new instance of RPS with the given possible moves.
     *
     * @param moves all possible moves in the game.
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }

    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            System.arraycopy(args, 0, moves, 0, args.length);
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);

        // While user does not input "q", play game
        String input = new String();
        while (true) {
            System.out.println(RPS.PROMPT_MOVE);
            input = in.nextLine();
            if (input.equals("q")) {
                break;
            }
            String cpu = game.genCPUMove();
            game.playRPS(input, cpu);
        }
        game.displayStats();

        // TODO: Insert the code to play the game.
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written
        // to do most of the work! And don't forget Javadoc.

        in.close();
    }

    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        // -1 invalid, 0 tie, 1 player, 2 cpu

        int playerPos = indexOfString(possibleMoves, playerMove);
        int cpuPos = indexOfString(possibleMoves, cpuMove);

        //check invalid
        if (playerPos == -1 || cpuPos == -1) {
            return INVALID_INPUT_OUTCOME;
        }

        // check player win
        int playerTmp = playerPos - 1;
        if (playerTmp < 0) {
            playerTmp = possibleMoves.length - 1;
        }

        if (cpuPos == playerTmp) {
            return PLAYER_WIN_OUTCOME;
        }
        // end check

        // check cpu win
        int cpuTmp = cpuPos - 1;
        if (cpuTmp < 0) {
            cpuTmp = possibleMoves.length - 1;
        }

        if (playerPos == cpuTmp) {
            return CPU_WIN_OUTCOME;
        }
        // end check

        // otherwise, tie
        return TIE_OUTCOME;
    }

    private int indexOfString(String[] array, String string) {
        int result = -1;

        for (int i = 0; i < array.length; i++) {
                if (array[i].equals(string)) {
                        result = i;
                        break;
                }
        }

        return result;
    }
}
