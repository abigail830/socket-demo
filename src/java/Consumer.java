import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Consumer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8081);
        socket.getOutputStream().write("1AA\n".getBytes());
        socket.getOutputStream().flush();
        StringBuilder textBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), Charset.forName(StandardCharsets.UTF_8.name())))) {
            String c;
            while ((c = reader.readLine()) != null) {
                textBuilder.append(c);
            }
        }
        System.out.println(textBuilder);
//        socket.close();
    }
}
