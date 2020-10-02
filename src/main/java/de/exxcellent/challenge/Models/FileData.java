package de.exxcellent.challenge.Models;

import java.util.ArrayList;
import java.util.List;

public class FileData {
    private List<List<String>> content = new ArrayList<>();



    public List<List<String>> getContent() {
        return content;
    }

    public void setContent(List<List<String>> content) {
        this.content = content;
    }
}
