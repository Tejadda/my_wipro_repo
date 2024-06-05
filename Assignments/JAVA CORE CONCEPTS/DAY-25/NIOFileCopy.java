package com.DAY_25;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOFileCopy {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileCopyUsingNIO <source-file-path> <destination-file-path>");
            return;
        }

        String sourceFilePath = args[0];
        String destinationFilePath = args[1];

        try {
            // Open file channels for both source and destination files
            Path sourcePath = Paths.get(sourceFilePath);
            Path destinationPath = Paths.get(destinationFilePath);

            FileChannel sourceChannel = FileChannel.open(sourcePath, StandardOpenOption.READ);
            FileChannel destinationChannel = FileChannel.open(destinationPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);

            // Allocate a buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // Read from source and write to destination
            while (sourceChannel.read(buffer) != -1) {
                buffer.flip(); // Prepare buffer for writing
                destinationChannel.write(buffer); // Write buffer to destination
                buffer.clear(); // Clear buffer for next read
            }

            // Close channels
            sourceChannel.close();
            destinationChannel.close();

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
