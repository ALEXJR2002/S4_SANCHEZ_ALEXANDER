package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static final String SEPARATOR = " ";
	
	private static double [][] array;

	public Main() {
	
	}
	
	public void readData () {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			String line = br.readLine();
			int size = Integer.parseInt(line);
			array = new double [size][];
			line = br.readLine();
			for (int i = 0; i < array.length && line != null; i++){
				String[] parts = line.split(SEPARATOR);
				double [] numbersSequence = new double [parts.length];
				for (int j = 0; j < parts.length; j++) {
					numbersSequence[j] = Double.parseDouble(parts[j]);
				}
				array[i] = numbersSequence;
				line = br.readLine();
			}
		br.close();	
			
		} catch (NumberFormatException exception) {
			System.out.println("First line is not an integer");
	    } catch (IOException exception) {
			System.out.println("The text cannot be read");
	    	
	    }

		
	}

	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		

		
		bw.write("sssfafad\n");
		
		
		bw.close();
		
		
	}

}
