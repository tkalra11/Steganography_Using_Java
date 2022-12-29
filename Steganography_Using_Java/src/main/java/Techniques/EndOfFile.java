package Techniques;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EndOfFile {
    
	public void eofencode(String filePath,String text) {
                OutputStream os = null;
		try {
			text = "startofmessage " + text;
			os = new FileOutputStream(new File(filePath), true);
			os.write(text.getBytes(), 0, text.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
                }
                
	}
        public String eofdecode(String filePath)
        {
            String fileAsString ="";
            try{
                BufferedReader br = new BufferedReader(new FileReader(filePath));
                StringBuilder sb = new StringBuilder();

                String line = br.readLine();
                while (line.indexOf("startofmessage ") == -1) {
                  line = br.readLine();
                }
                sb.append(line.substring(line.indexOf("startofmessage ")+15)).append("\n");
                line=br.readLine();
                while(line!=null){
                    sb.append(line).append("\n");
                    line=br.readLine();
                }
                fileAsString = sb.toString();
            }catch(IOException e){
                e.printStackTrace();
            }
            return fileAsString;
        }
}