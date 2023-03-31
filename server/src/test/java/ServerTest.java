import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.util.stream.Stream;

public class ServerTest {

    ServerSocket server;

    @BeforeEach
    public void beforeConnectionTest() throws IOException {
        int port = 8089;
        server = new ServerSocket(port);
        System.out.println("Server run");
    }

    @AfterEach
    public void afterConnectionTest() throws IOException {
        server.close();
        System.out.println("Server close");
    }

    @BeforeAll
    public static void before() {
        System.out.println("Test starts");
    }

    @AfterAll
    public static void after() {
        System.out.println("Test finished");
    }

    @Test
    void isPortCorrect() {
        Assertions.assertTrue(Server.port >= 0 && Server.port <= 65536);
    }

//    @Test
//    public void isServerAvailable2() throws IOException {
//        //arrange given
//        int port = 8089;
//        boolean expected = true;
//
//        //Act when
//        ServerSocket server = new ServerSocket(port);
//
//        //assert then
//        Assertions.assertEquals(expected, server);
//        // throw new RuntimeException("Server unavailable");
//
//    }

//    @Test
//    public void testServerSocketWithSpecificPortGetsCreated() throws IOException {
//        final int testPort = 9001;
//        RMIServerSocketFactory SocketCreator = null;
//        ServerSocket testServerSocket =
//                SocketCreator.createServerSocket(testPort);
//        Assertions.assertEquals(testServerSocket.getLocalPort(), testPort);
//    }

//    @ParameterizedTest
//    @MethodSource("connectTestParameters")
//    void isPortCorrect2(int number) {
//        Assertions.assertTrue(Server.port >= 0 && Server.port <= 65536);
//    }

//    @Test
//    public void isServerAvailable() throws IOException {
//        //arrange given
//        int port = 808;//Port value out of range
//        //assert then
//        Assertions.assertNotNull(server);
//    }

//    public Stream<Arguments> connectTestParameters() {
//        return Stream.of(Arquments.of(879), Arquments.of(87979089));
//    }

//    @org.junit.jupiter.api.Test
//    public void testConcat_validArgument_success() {
//        // given:
//
//
//        // when:
//
//
//        // then:
//      //  Assertions.***;
//    }

}
