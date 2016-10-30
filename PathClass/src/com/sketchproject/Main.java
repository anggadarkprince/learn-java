package com.sketchproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // relative path
        Path path = Paths.get("loremipsum.txt");

        Path source = Paths.get("files/inside.txt");

        System.out.println(path.toString());
        System.out.println(path.getFileName());
        System.out.println(path.getNameCount());

        System.out.println();

        System.out.println(source.toString());
        System.out.println(source.getFileName());
        System.out.println(source.getNameCount());
        System.out.println(source.getName(0));
        System.out.println(source.getName(1));

        System.out.println();

        //fileOperation(path, source);

        readWriteFile();

        fileTree();

        fileFinder();

        watchingDirectory();
    }

    private static void watchingDirectory() {
        try(WatchService service = FileSystems.getDefault().newWatchService()){
            Map<WatchKey, Path> keyMap = new HashMap<>();
            Path path = Paths.get("files/empty");
            keyMap.put(path.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY),
                    path);

            WatchKey watchKey;

            do{
                watchKey = service.take();
                Path eventDir = keyMap.get(watchKey);
                for(WatchEvent<?> event : watchKey.pollEvents()){
                    WatchEvent.Kind<?> kind = event.kind();
                    Path eventPath = (Path) event.context();
                    System.out.println(eventDir + " : " + kind + " : "+eventPath);
                }
                System.out.println("a");
            } while(watchKey.reset());
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    private static void fileFinder() {
        try {
            Path fileDir = Paths.get("files");
            FileFinder finder = new FileFinder("file*.txt");
            Files.walkFileTree(fileDir, finder);

            ArrayList<Path> foundFiles = finder.foundPaths;

            if(foundFiles.size() > 0){
                for(Path path:foundFiles){
                    System.out.println(path.toRealPath(LinkOption.NOFOLLOW_LINKS));
                }
            } else {
                System.out.println("No files were found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileOperation(Path path, Path source) {
        try {
            // real path
            Path realPath = path.toRealPath(LinkOption.NOFOLLOW_LINKS);
            System.out.println(realPath.toString());

            // copy file
            Path target = Paths.get("files/newfile.txt");
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File was copied");

            // delete file
            Path toDelete = Paths.get("files/newfile.txt");
            Files.delete(toDelete);
            System.out.println("File was deleted");

            // create dir
            Path newDir = Paths.get("files/newdir");
            Files.createDirectories(newDir);
            System.out.println("New directory was created");

            // move
            Files.move(source, newDir.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File was moved");
        } catch (IOException e) {
            System.err.println(e.getMessage() + " no such file");
        }
    }

    public static void readWriteFile() {
        Path source = Paths.get("files/backup.txt");
        System.out.println(source.getFileName());
        Path target = Paths.get("files/newfile.txt");
        System.out.println(target.getFileName());

        Charset charset = Charset.forName("US-ASCII");
        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(source, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(target, charset)) {
            Iterator<String> iterator = lines.iterator();
            while (iterator.hasNext()) {
                String s = iterator.next();
                writer.append(s, 0, s.length());
                writer.newLine();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void fileTree(){
        Path fileDir = Paths.get("files");
        MyFileVisitor visitor = new MyFileVisitor();
        try {
            Files.walkFileTree(fileDir, visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
