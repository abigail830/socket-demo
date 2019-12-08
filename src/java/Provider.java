import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {

    public static void main(String[] args) {

        System.out.println("Hello World!");
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Reading...");
                InputStream is = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                String value = bufferedReader.readLine();
                System.out.println(value);

                if(value.startsWith("0")){
                    System.out.println("Writing...");
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeBytes("20020191212");
                }else{
                    System.out.println("Writing...");
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);
                    dos.writeBytes("40420191212");
                }

                System.out.println("Close...");
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
