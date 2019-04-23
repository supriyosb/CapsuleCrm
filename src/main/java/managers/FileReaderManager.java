package managers;

import dataProviders.ConfigFileReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;

    /**
     * Constructor
     * It will initialize FileReaderManager to read files
     */
    private FileReaderManager() {
    }

    /**
     * It will return the FileReaderManager instance
     * @return
     */
    public static FileReaderManager getInstance( ) {
        return fileReaderManager;
    }

    /**
     * It will return ConfigFileReader instance
     * @return
     */
    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }
}
