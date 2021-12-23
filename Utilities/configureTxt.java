package Utilities;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;

public class configureTxt {
    //hard coded for server
    private static String filePath = "setup.txt";

    //dynamic varaibles
    private static readInTxt myrReadInTxt;
    private int port;
    private String webroot;

    public configureTxt() {
        if(myrReadInTxt == null) myrReadInTxt = new readInTxt(); createFile(); getValues();
    }

    public void createFile() {
        try {
            myrReadInTxt.fileRead(filePath);
            myrReadInTxt.fillFromFile();   
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException a) {
            a.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getValues() {
        try {
            port = Integer.parseInt(myrReadInTxt.getField(0, 1).trim());
            webroot = myrReadInTxt.getField(1, 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPort() {
        return port;
    }

    public String getWebroot() {
        return webroot;
    }
}
