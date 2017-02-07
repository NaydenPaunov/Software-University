package FilesAndDirectories;

import java.io.FileInputStream;

import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		String path = "D:\\input.txt";
		
		try (FileInputStream fis = new FileInputStream(path)){
			
			int oneByte = fis.read();
			
			while(oneByte >= 0){
				System.out.println(Integer.toBinaryString(oneByte) + " ");
				oneByte = fis.read();
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}

}
