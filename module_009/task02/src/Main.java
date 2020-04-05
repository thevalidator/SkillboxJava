import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Scanner;

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
            Files.walkFileTree(from, new HashSet<>(), Integer.MAX_VALUE, new FileVisitor<Path>() {
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
                        int copyOption = getCopyOption();
                        if (copyOption == 0) {
                            return FileVisitResult.CONTINUE;
                        } else if (copyOption == 1) {
                            passAll = true;
                            return FileVisitResult.CONTINUE;
                        } else if (copyOption == 2) {
                            Files.copy(file, newFile, StandardCopyOption.REPLACE_EXISTING);
                        } else if (copyOption == 3) {
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

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.SKIP_SUBTREE;
                }
            } );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getCopyOption() {
        Scanner option = new Scanner(System.in);
        Integer result = null;
        System.out.println("File already exists!");
        System.out.println("Type: 0 - pass, 1 - pass ALL, 2 - replace, 3 - replace ALL.");

        do {
            try {
                result = option.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        } while (result == null);
        return result;
    }

}
