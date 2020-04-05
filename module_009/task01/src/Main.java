import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Path dir = Paths.get("C:\\Windows\\Globalization");
        try {
            listFilesAndSizeOfDirectory(dir);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }

    }

    public static void listFilesAndSizeOfDirectory (Path directory) {

        Map<String, Long> list = new TreeMap<>();
        long sizeTotal = 0L;
        Long divisor = 1L;
        String sizeName = null;

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
            throw new RuntimeException("File read error: " + e);
        }

        for (String name : list.keySet()) {
            sizeTotal += list.get(name);

            HashMap<Long, String> sizeGrades = getSizeGrade(list.get(name));
            for (Object key : sizeGrades.keySet()) {
                divisor = (Long) key;
                sizeName = (String) sizeGrades.get(key);
            }

            System.out.println(name + " - " + list.get(name) / divisor + " " +
                    sizeName);
        }

        HashMap<Long, String> sizeGrades = getSizeGrade(sizeTotal);
        for (Object key : sizeGrades.keySet()) {
            divisor = (Long) key;
            sizeName = sizeGrades.get(key);
        }

        System.out.println("Total size: " + sizeTotal / divisor + " " +
                sizeName);
    }

    public static HashMap<Long, String> getSizeGrade (long size) {

        HashMap<Long, String> sizeGrade = new HashMap<>();
        long[] sizeGrades = {1L, 1024L, (1024L * 1024), (1024L * 1024 * 1024), (1024L * 1024 * 1024 * 1024)};
        String[] sizeNames = {"bytes", "Kbs", "Mbs", "Gbs", "Tbs"};

        if (size >= (sizeGrades[4])) {
            sizeGrade.put(sizeGrades[4], sizeNames[4]);
        } else if (size >= sizeGrades[3]) {
            sizeGrade.put(sizeGrades[3], sizeNames[3]);
        } else if (size >= sizeGrades[2]) {
            sizeGrade.put(sizeGrades[2], sizeNames[2]);
        } else if (size >= sizeGrades[1]) {
            sizeGrade.put(sizeGrades[1], sizeNames[1]);
        } else {
            sizeGrade.put(sizeGrades[0], sizeNames[0]);
        }

        return sizeGrade;
    }

}