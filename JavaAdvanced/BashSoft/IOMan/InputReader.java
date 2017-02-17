package IOMan;

import StaticData.SessionData;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by na4oy on 17.2.2017 г..
 */

public class InputReader {
    private static final String END_COMMAND = "quit";

    public static void readCommands() throws IOException {
        OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim();

        while (!input.equals(END_COMMAND)) {
            CommandInterpreter.interpretCommand(input);
            OutputWriter.writeMessage(String.format("%s > ", SessionData.currentPath));

            input = sc.nextLine().trim();
        }
    }
}
