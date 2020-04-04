import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Path dir = Paths.get("C:\\Windows\\Globalization");
        listFilesAndSizeOfDirectory(dir);

    }

    public static class SizeGradesAndNames {
        public long sizeGrade;
        public String sizeName;

        SizeGradesAndNames(long sizeGrade, String sizeName) {
            this.sizeGrade = sizeGrade;
            this.sizeName = sizeName;
        }

    }

    public static SizeGradesAndNames getSizeGradesAndNames(long size) {
        final long[] SIZE_GRADES = {1L, 1024L, (1024L * 1024), (1024L * 1024 * 1024), (1024L * 1024 * 1024 * 1024)};
        final String[] SIZE_NAMES = {"bytes", "Kbs", "Mbs", "Gbs", "Tbs"};

        long sizeGrade;
        String sizeName;

        if (size >= (SIZE_GRADES[4])) {
            sizeGrade = SIZE_GRADES[4];
            sizeName = SIZE_NAMES[4];
        } else if (size >= SIZE_GRADES[3]) {
            sizeGrade = SIZE_GRADES[3];
            sizeName = SIZE_NAMES[3];
        } else if (size >= SIZE_GRADES[2]) {
            sizeGrade = SIZE_GRADES[2];
            sizeName = SIZE_NAMES[2];
        } else if (size >= SIZE_GRADES[1]) {
            sizeGrade = SIZE_GRADES[1];
            sizeName = SIZE_NAMES[1];
        } else {
            sizeGrade = SIZE_GRADES[0];
            sizeName = SIZE_NAMES[0];
        }

        return new SizeGradesAndNames(sizeGrade, sizeName);
    }

    public static void listFilesAndSizeOfDirectory (Path directory) {

        Map<String, Long> list = new TreeMap<>();
        long sizeTotal = 0L;

        try {
            Files.walk(directory).filter(Files::isRegularFile)
                    .forEach(f -> {
                        try {
                            list.put(f.toString(), Files.size(f));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String name : list.keySet()) {
            SizeGradesAndNames fileSizeGradesAndNames = getSizeGradesAndNames(list.get(name));
            sizeTotal += list.get(name);
            System.out.println(name + " - " + list.get(name) / fileSizeGradesAndNames.sizeGrade + " " +
                    fileSizeGradesAndNames.sizeName);
        }

        SizeGradesAndNames totalSizeGradesAndNames = getSizeGradesAndNames(sizeTotal);
        System.out.println("Total size: " + sizeTotal / totalSizeGradesAndNames.sizeGrade + " " +
                totalSizeGradesAndNames.sizeName);
    }

}