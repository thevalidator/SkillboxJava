import org.jsoup.Jsoup;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> imagesList = Jsoup.connect("https://lenta.ru").get()
                    .select("img[class=g-picture]").eachAttr("src");
            ArrayList<Path> directories = new ArrayList<>();
            Path tempFolder = Paths.get("tmp");
            Path imagesFolder = Paths.get("images");
            Path imageAddressLinks = tempFolder.resolve("readMe.txt");
            directories.add(tempFolder);
            directories.add(imagesFolder);

            for (Path dir : directories) {
                if (Files.notExists(dir)) {
                    Files.createDirectory(dir);
                }
            }
            if (Files.notExists(imageAddressLinks) ) {
                Files.createFile(imageAddressLinks);
            }

            FileWriter writer = new FileWriter(String.valueOf(imageAddressLinks), false);
            imagesList.forEach(str -> {
                try {
                    String fileName = imagesFolder.resolve(str.substring(str.lastIndexOf("/") + 1)).toString();
                    download(str, fileName);
                    writer.write(str + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void download(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
