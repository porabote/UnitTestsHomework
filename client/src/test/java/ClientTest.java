import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {

    @Test
    void isHostSpecified() {
        Assertions.assertNotNull(Client.host);
    }

    @Test
    void isHostNotLocalhost() {
        Assertions.assertNotEquals("localhost", Client.host);
    }

}
