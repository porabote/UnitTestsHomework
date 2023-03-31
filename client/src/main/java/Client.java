import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static String host = "netology.homework";
    static int port = 8089;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        ) {

            String nameQuestion = in.readLine();
            System.out.println(nameQuestion);

            String name = reader.readLine();
            out.write(name + "\n");
            out.flush();

            String ageQuestion = in.readLine();
            System.out.println(ageQuestion);

            String age = reader.readLine();
            out.write(age + "\n");
            out.flush();

            String finalResponse = in.readLine();
            System.out.println(finalResponse);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
