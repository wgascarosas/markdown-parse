import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path filename = Path.of("test-file2.md");
        String contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html"));

        filename = Path.of("test-file.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of("https://something.com", "some-page.html", "hello"));

        filename = Path.of("test-file3.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of());

        filename = Path.of("test-file4.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of("a link on the first line"));

        filename = Path.of("test-file5.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of());

        filename = Path.of("test-file6.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of("page.com"));

        filename = Path.of("test-file7.md");
        contents = Files.readString(filename);
        assertEquals(MarkdownParse.getLinks(contents), List.of());

        filename = Path.of("test-file8.md");
        contents = Files.readString(filename);
        //assertEquals(MarkdownParse.getLinks(contents), List.of("a link on the first line"));
        assertEquals(MarkdownParse.getLinks(contents), List.of("a link on the first line"));
    }
}