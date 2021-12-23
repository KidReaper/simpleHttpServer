import java.net.Socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServerConnectedThread extends Thread {
    
    private Socket socket;

    public ServerConnectedThread(Socket socket) {
        this.socket = socket;
    }

    
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            String html = "<html><head><title>Hello World!</title></head><body><h1>What is going on bro!</h1></body></html>";
            
            final String CRLF = "\n\r"; //13, 10

            String response = "HTTP/1.1 200 ok" + CRLF + //Status Line : HTTP_VERSION RESPONSE_CODE RESPONSE_MESSAGE
                "Content-Length: " + html.getBytes().length + CRLF + 
                    CRLF + 
                    html + 
                    CRLF + CRLF;

            outputStream.write(response.getBytes());

        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream !=null) {
                try {
                    inputStream.close();
                
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(outputStream != null) {
                try {
                    outputStream.close();
                
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(socket !=null){
                try {
                    socket.close();
                } catch (IOException I) {
                    I.printStackTrace();
                }
            }

        }
    }
}
