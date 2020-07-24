package parser;

import java.io.File;

public class Parser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		String fileName = "test.csv";
        ClassLoader classLoader = new Parser().getClass().getClassLoader();
 
        File file = new File(classLoader.getResource(fileName).getFile());
         
        //File is found
        System.out.println("File Found : " + file.exists());
	}

}
