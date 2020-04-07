import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

enum Option {
    PASS("Pass"),
    PASS_ALL("Pass all"),
    REPLACE("Replace "),
    REPLACE_ALL("Replace all");

    public final String desc;

    Option(String desc) {
        this.desc = desc;
    }
}

public class Main {

    public static void main(String[] args) {

        Path from = Paths.get("C:\\Windows\\Globalization\\ELS\\SpellDictionaries");
        Path to = Paths.get("C:\\testFolder\\copiedFiles");

        try {
            copyDir(from, to);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copyDir(Path from, Path to) throws IOException {
        if(Files.notExists(to)) {
            Files.createDirectories(to);
        }
        try {
            Files.walkFileTree(from, new HashSet<>(), Integer.MAX_VALUE, new SimpleFileVisitor<>() {
                //EnumSet.noneOf(FileVisitOption.class)
                boolean passAll = false;
                boolean replaceAll = false;

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path subTo = to.resolve(from.relativize(dir));
                    if(Files.notExists(subTo)) {
                        Files.createDirectories(subTo);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path newFile = to.resolve(from.relativize(file));
                    if (Files.exists(newFile) && !replaceAll && !passAll) {
                        Option copyOption = getCopyOption(newFile);
                        if (copyOption == Option.PASS) {
                            return FileVisitResult.CONTINUE;
                        } else if (copyOption == Option.PASS_ALL) {
                            passAll = true;
                            return FileVisitResult.CONTINUE;
                        } else if (copyOption == Option.REPLACE) {
                            Files.copy(file, newFile, StandardCopyOption.REPLACE_EXISTING);
                        } else if (copyOption == Option.REPLACE_ALL) {
                            replaceAll = true;
                            Files.copy(file, newFile, StandardCopyOption.REPLACE_EXISTING);
                        }
                    } else if (Files.exists(newFile) && replaceAll) {
                        Files.copy(file, newFile, StandardCopyOption.REPLACE_EXISTING);
                    } else if (Files.exists(newFile) && passAll) {
                        return FileVisitResult.CONTINUE;
                    }
                    Files.copy(file, newFile);
                    return FileVisitResult.CONTINUE;
                }
            } );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Option getCopyOption(Path file) {
        Scanner input = new Scanner(System.in);
        System.out.println("File \"" + file.toString() + "\" already exists!");

        System.out.println("Type: " + Arrays.stream(Option.values())
                .map((Option e) -> e.ordinal() + " - " + e.desc)
                .collect(Collectors.joining(", ")));
        do {
            String text = input.next();
            if (text.matches("\\d+")) {
                int i = Integer.parseInt(text);
                if (i < Option.values().length) {
                    return Option.values()[i];
                }
            }
            System.out.println("Invalid input!");
        } while (true);
    }
    
}
