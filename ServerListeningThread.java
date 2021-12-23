import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerListeningThread extends Thread {

    private int port;
    private String Webroot;
    private ServerSocket serverSocket;

    public ServerListeningThread(int port, String Webroot) throws IOException{
        this.port = port;
        this.Webroot = Webroot;
        serverSocket = new ServerSocket(this.port);
    }

    public void run() {
        
        while(serverSocket.isBound() && !serverSocket.isClosed()) {
            try {

                Socket socket = serverSocket.accept();
                ServerConnectedThread myServerConnectedThread = new ServerConnectedThread(socket);
                myServerConnectedThread.start();

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

        //finally {

          //  if(serverSocket != null) 
            //{ 
              //  try {
                //    serverSocket.close();
                //} catch (IOException I) {}
            //}
            
       // }

    }
    
}
