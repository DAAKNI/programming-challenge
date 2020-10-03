package de.exxcellent.challenge.Services.RepsitoryService;

public class ReaderFactory {
    public IResourceReader getReader(String resource) {

        if (resource.startsWith("https://") | resource.startsWith("http://")){
            return new WebResourceReader();
        } else {
            return new FileResourceReader();
        }
    }

}
