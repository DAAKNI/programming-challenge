package de.exxcellent.challenge.Services.RepsitoryService;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic Interface for a reader of resources
 */
public interface IResourceReader  {
    public List<String> read(String resource);
}


