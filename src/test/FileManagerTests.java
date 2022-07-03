package test;

import main.Parser.FileManager;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

public class FileManagerTests {
    @Test
    public void TestGetExtension() {
        File file = new File(FileManager.pathtocsv + "test1.csv");
        File file1 = new File(FileManager.pathtocsv + "test.txt");
        String extension = FileManager.getFileExtension(file);
        String extension1 = FileManager.getFileExtension(file1);
        assertThat(extension).isEqualTo("csv");
        assertThat(extension1).isEqualTo("txt");
    }
}
