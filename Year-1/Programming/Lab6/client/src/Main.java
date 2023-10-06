import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {
    public static void main(String[] args) throws IOException {
        byte arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int len = arr.length;
        Socket sock;
        OutputStream os; InputStream is;
        InetAddress host; int port;

        host = InetAddress.getLocalHost();

        port = 6789;
        sock = new Socket(host, port);

        os = sock.getOutputStream();
        os.write(arr);

        is = sock.getInputStream();
        is.read(arr);

        for (byte j : arr) {
            System.out.println(j);
        }
    }
}