package de.exxcellent.challenge.Services.RepsitoryService;

import de.exxcellent.challenge.Config.FileType;
import de.exxcellent.challenge.Models.FileWrapper;

import java.util.ArrayList;
import java.util.List;

public interface IResourceReader {
    public List<String> read(String resource);
}


