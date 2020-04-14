import org.jsoup.Jsoup;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String url = "https://lenta.ru";
        Path tempFolder = Paths.get("tmp");
        Path imagesFolder = Paths.get("images");
        Path imageAddressLinks = tempFolder.resolve("readMe.txt");

        try {

            List<String> imagesList = Jsoup.connect(url).maxBodySize(0).get()
                    .select("img[class=g-picture]").eachAttr("src");

            for (Path dir : Arrays.asList(tempFolder, imagesFolder)) {
                Files.createDirectories(dir);
            }

            if (Files.notExists(imageAddressLinks) ) {
                Files.createFile(imageAddressLinks);
            }

            imagesList.forEach(str -> {
                try (FileWriter writer = new FileWriter(String.valueOf(imageAddressLinks), false)) {
                    String fileName = imagesFolder.resolve(Paths.get(URI.create(str)
                            .getPath()).getFileName()).toString();
                    download(str, fileName);
                    writer.write(str + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void download(String FILE_URL, String FILE_NAME) {
        try (InputStream in = new URL(FILE_URL).openStream()) {
            Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
