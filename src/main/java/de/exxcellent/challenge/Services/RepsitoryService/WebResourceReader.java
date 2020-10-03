package de.exxcellent.challenge.Services.RepsitoryService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebResourceReader implements IResourceReader {
    private static final Logger logger = LogManager.getLogger(WebResourceReader.class);

    @Override
    public List<String> read(String resource)  {

        List<String> content = new ArrayList<>();

        // Open web resource
        try  {
            URL url = new URL(resource);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
        } catch (MalformedURLException e) {
            logger.error("URL is malformed");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error reading webresource");
        }
        return content;
    }
}
