package needForSpeed;

import needForSpeed.engines.Engine;
import needForSpeed.core.CarManager;
import needForSpeed.io.ConsoleInputReader;
import needForSpeed.io.ConsoleOutputWriter;
import needForSpeed.utilities.InputParser;

/**
 * Created by Hristo Skipernov on 08/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        CarManager carManager = new CarManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, carManager);

        engine.run();
    }
}
