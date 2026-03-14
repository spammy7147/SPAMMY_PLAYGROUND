package spammy.eve.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.function.Consumer;

public final class JsonlReader {
    private JsonlReader() {}

    public static void forEachLine(Path path, Consumer<String> lineConsumer) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) lineConsumer.accept(line);
            }
        }
    }
}