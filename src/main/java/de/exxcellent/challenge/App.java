package de.exxcellent.challenge;

import de.exxcellent.challenge.Models.FileData;
import de.exxcellent.challenge.Models.FileWrapper;
import de.exxcellent.challenge.Services.ParserService;
import de.exxcellent.challenge.Services.ProcesorService;
import de.exxcellent.challenge.Services.RepositoryService;
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
    public static void main(String... args) {

        logger.info("Entering application.");

        final String weatherData = "src/main/resources/de/exxcellent/challenge/weather.csv";
        final String footballData = "src/main/resources/de/exxcellent/challenge/football.csv";

        RepositoryService repositoryService = new RepositoryService();
        ParserService parserService = new ParserService();
        ProcesorService procesorService = new ProcesorService();

        FileWrapper unparsedWeatherData = repositoryService.get(weatherData);
        FileData parsedWeatherData = parserService.parse(unparsedWeatherData);




        String dayWithSmallestTempSpread = procesorService.calculateMinSpread(parsedWeatherData, "MxT", "MnT");
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);


        FileWrapper unparsedFootballData = repositoryService.get(footballData);
        FileData parsedFootballData = parserService.parse(unparsedFootballData);
        String teamWithSmallestGoalSpread = procesorService.calculateMinSpread(parsedFootballData, "Goals", "Goals Allowed");
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);

    }
}
