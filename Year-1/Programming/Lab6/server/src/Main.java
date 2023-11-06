import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        byte arr[] = new byte[10];
        int len = arr.length;
        Socket sock; ServerSocket serv;
        OutputStream os; InputStream is;
        InetAddress host; int port = 6789;

        host = InetAddress.getLocalHost();

        serv = new ServerSocket(port);
        sock = serv.accept();

        is = sock.getInputStream();
        is.read(arr);

        arr[0] = 'F';

        os = sock.getOutputStream();
        os.write(arr);
    }
}