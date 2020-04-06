import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Scanner;

enum Option {PASS, PASS_ALL, REPLACE, REPLACE_ALL}

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
        Integer result = null;
        System.out.println("File \"" + file.toString() + "\" already exists!");
        System.out.println("Type: 0 - pass, 1 - pass ALL, 2 - replace, 3 - replace ALL.");

        do {
            try {
                result = input.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                input.next();
            }
        } while (result == null || result < 0 || result > 3);

        if (result == 0) {
            return Option.PASS;
        } else if (result == 1) {
            return Option.PASS_ALL;
        } else if (result == 2) {
            return Option.REPLACE;
        } else {
            return Option.REPLACE_ALL;
        }

    }


}
