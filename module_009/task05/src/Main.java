import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import data.StructuredDataForGson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main {

    public static void main(String[] args) {

        Path tempFolder = Paths.get("tmp");
        Path metroStructureFile = tempFolder.resolve("structure.json");

        try {

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.createDirectories(tempFolder);
            FileWriter writer = new FileWriter(metroStructureFile.toFile(), false);
            WikiParser data = new WikiParser();

            StructuredDataForGson jsonData = data.getAllData();
            String jsontxt = gson.toJson(jsonData);
            writer.write(jsontxt);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
