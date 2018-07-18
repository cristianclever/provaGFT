package br.com.gft.dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.gft.dish.processor.DishProcessor;

public class Console {

	
	
	
	  private static String readLine(String prompt) {
	        String line = null;
	        java.io.Console c = System.console();
	        if (c != null) {
	             line = c.readLine(prompt);
	        } else {
	            System.out.print(prompt);
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	            try {
	                 line = bufferedReader.readLine();
	            } catch (IOException e) { 
	                //Ignore    
	            }
	        }
	        return line;
	    }	
	
	public static void main(String[] args) {
		
		System.out.println("1");
		String input = readLine("input:"); 
	

		System.out.println("3:" + input);
		try {
			String result = DishProcessor.resolve(input);
			System.out.println("result:" + result);
			System.console().printf(result);
			System.out.println(result);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		
		
		
		
		
	}
}
