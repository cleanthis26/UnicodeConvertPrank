// Does not work on Windows
import java.io.File;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UnicodeConverter {
	
	public static void main(String[] args) {
		Character normalQM = '\u003B';
		Character greekQM = '\u037E';
		String prankFile = "Pointless.java";

		/*
		String line = "int i = 3;";
		System.out.println(normalQM.equals(';'));
		System.out.println(greekQM.equals(';'));
		System.out.println(line);
		System.out.println("TEST");
		System.out.println("ΔΟΚΙΜΗ");
		System.out.println(line.contains(normalQM + ""));
		line = line.replace(normalQM, greekQM);
		System.out.println(line);
		System.out.println(line.contains(greekQM + ""));
		*/


		File tempFile;
    	FileWriter fw = null;

    	Reader fr = null;
    	BufferedReader br = null;

		try {
			//tempFile = File.createTempFile("tempprank", ".tmp");
			tempFile = new File("Prank.java");
			fw = new FileWriter(tempFile);
    		fr = new FileReader(prankFile);
    		br = new BufferedReader(fr);
 
			String currLine;
 
			br = new BufferedReader(new FileReader(prankFile));
 
			while ((currLine = br.readLine()) != null) {
				fw.write(currLine.replaceAll(normalQM + "",greekQM + "") + "\n");
			}

			//System.out.println(tempFile.renameTo(new File()));
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			    br.close();
    			fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}