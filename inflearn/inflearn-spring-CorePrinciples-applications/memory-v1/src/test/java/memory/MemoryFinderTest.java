package memory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemoryFinderTest {

    @Test
    void get() {
        MemoryFinder finder = new MemoryFinder();
        Memory memory = finder.get();
        Assertions.assertThat(memory).isNotNull();
    }
}
