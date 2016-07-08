package Service;

import java.io.File;

public abstract class AbstractFileFetcher implements FileFetcher{

    protected File inputFile = null;

    public File getFile(String classifier) {
        return inputFile;
    }
}
