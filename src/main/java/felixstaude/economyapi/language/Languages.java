package felixstaude.economyapi.language;

import java.io.File;

public enum Languages {
    GERMAN("german.yml"),
    ENGLISH("english.yml");

    public String fileName;

    Languages(String s) {
        this.fileName = getFileName();
    }

    public String getFileName() {
        return fileName;
    }


}
