package Service;

import java.io.File;

public class LocalFile extends AbstractFileFetcher {

    @Override
    public File getFile(String classifier) {
        if(classifier.equalsIgnoreCase("noDrill")) {
            inputFile = new File("/home/alama/Documents/myHVAC/HVAC/HVAC-Reporter/data/secondResult.csv");
        }else{
            inputFile = new File("/home/alama/Documents/myHVAC/HVAC/HVAC-Reporter/data/firstResult.csv");
        }
        return inputFile;
    }
}
