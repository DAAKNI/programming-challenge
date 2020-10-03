package de.exxcellent.challenge;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.Services.ParserService;
import de.exxcellent.challenge.Services.ProcesorService;
import de.exxcellent.challenge.Services.RepositoryService;
import de.exxcellent.challenge.exceptions.FileNotSupportedException;
import de.exxcellent.challenge.exceptions.InvalidCSVException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args)  {

        logger.info("Entering application.");

        final String weatherData = "src/main/resources/de/exxcellent/challenge/weather.csv";
        final String footballData = "src/main/resources/de/exxcellent/challenge/football.csv";

        RepositoryService repositoryService = new RepositoryService();
        ParserService parserService = new ParserService();
        ProcesorService procesorService = new ProcesorService();
        FileWrapper unparsedWeatherData = new FileWrapper();
        FileData parsedWeatherData = new FileData();

        // Get data from file
        try {
            unparsedWeatherData = repositoryService.get(weatherData);
        } catch (FileNotSupportedException e) {
            e.printStackTrace();
            logger.error("Error Reading file - File not supported");
        }

        // Parse data from file
        try {
            parsedWeatherData = parserService.parse(unparsedWeatherData);
        } catch (InvalidCSVException e) {
            e.printStackTrace();
            logger.error("Error parsing file");
        }


        // Do calculations an print to console
        String dayWithSmallestTempSpread = procesorService.calculateMinSpread(parsedWeatherData, "MxT", "MnT");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        FileWrapper unparsedFootballData = new FileWrapper();
        FileData parsedFootballData = new FileData();
        // Get data from file
        try {
            unparsedFootballData = repositoryService.get(footballData);
        } catch (FileNotSupportedException e) {
            e.printStackTrace();
            logger.error("File is not supported");
        }

        // Parse data from file
        try {
            parsedFootballData = parserService.parse(unparsedFootballData);
        } catch (InvalidCSVException e) {
            e.printStackTrace();
            logger.error("Error parsing file");
        }

        // Do calculations an print to console
        String teamWithSmallestGoalSpread = procesorService.calculateMinSpread(parsedFootballData, "Goals", "Goals Allowed");
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

    }
}
