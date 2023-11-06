import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        Scanner userScanner = new Scanner(System.in);
        String str = userScanner.next();
        byte arr[] = str.getBytes();
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

        String inputstring = new String(arr);

    }
}