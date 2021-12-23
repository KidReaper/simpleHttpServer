import Utilities.configureTxt;

public class httpServer {
    private static configureTxt mycConfigureTxt;

    public static void main(String[] args) {
        mycConfigureTxt = new configureTxt(); 
        System.out.println(mycConfigureTxt.getWebroot());

        try {
            ServerListeningThread serverListeningThread = new ServerListeningThread(mycConfigureTxt.getPort(), mycConfigureTxt.getWebroot());
            serverListeningThread.start(); //starts thread it is a extended inheritance method
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}