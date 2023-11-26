package org.example.downloadPictures;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;

public class DownloadPictures {
    public static void main(String[] args) {
        deleteFile("File1.gif");
        deleteFile("File2.png");
        deleteFile("File3.png");
        deleteFile("File4.gif");
        deleteFile("File5.png");

        download("https://www.google.com/logos/doodles/2023/celebrating-the-appalachian-trail-6753651837110071.2-2xa.gif","File1.gif");
        download("https://www.google.com/logos/doodles/2023/tomie-ohtakes-110th-birthday-6753651837110095-2x.png","File2.png");
        download("https://www.google.com/logos/doodles/2023/lily-poulett-harris-150th-birthday-6753651837110079-2x.png","File3.png");
        download("https://www.google.com/logos/doodles/2023/teachers-day-2023-oct-15-6753651837110166-2xa.gif","File4.gif");
        download("https://www.google.com/logos/doodles/2022/celebrating-enrique-de-la-mora-6753651837109441-2x.png","File5.png");
}

    public static void deleteFile (String fileStr){
        File file = new File(fileStr);
        if (file.delete()) System.out.printf("File %s deleted \n",fileStr);
    }

    public static void download(String urlStr, String fileName){
        try {
            URL url = null;
            url = new URL(urlStr);
            InputStream input = null;
            input = url.openStream();
            Path path = Path.of(fileName);
            Files.copy(input, path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
