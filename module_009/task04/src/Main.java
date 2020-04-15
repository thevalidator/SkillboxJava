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

            List<String> imagesList = Jsoup.connect(url).timeout(5000).maxBodySize(0).get()
                    .select("img[class=g-picture]").eachAttr("src");

            for (Path dir : Arrays.asList(tempFolder, imagesFolder)) {
                Files.createDirectories(dir);
            }

            imagesList.forEach(link -> {
                try (FileWriter writer = new FileWriter(imageAddressLinks.toFile(), true)) {
                    Path fileName = imagesFolder.resolve(Paths.get(URI.create(link)
                            .getPath()).getFileName());
                    download(link, fileName);
                    writer.write(link + "\n");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void download(String fromUrl, Path toFile) {
        try (InputStream in = new URL(fromUrl).openStream()) {
            Files.copy(in, toFile, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
