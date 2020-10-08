package de.exxcellent.challenge.Services.RepsitoryService;

/**
 * The ReaderFactory provides a WebResourceReader or a FileResourceReader depending
 * on a Link or a file location is passed to it
 */
public class ReaderFactory {
    public IResourceReader getReader(String resource) {

        if (resource.startsWith("https://") | resource.startsWith("http://")){
            return new WebResourceReader();
        } else {
            return new FileResourceReader();
        }
    }

}
