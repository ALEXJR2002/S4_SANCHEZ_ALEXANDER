package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
	
	private static final String SEPARATOR = " ";
	
	private static double [][] array;


	
	public static void readData () {
		
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
	
	public static void dataSorting () throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		for (int i = 0; i < array.length; i++) {
			
			int changesCounter = 0;
			int counter = 0;
			int changes = 1;
			
			for (int j = 1; j < array[i].length; j++) {
				changes = 0;
				for (int k = 0; k < array[i].length - j; k++) {
					if (array[i][k] > array[i][k+1]) {
						double temp = array[i][k];
						array[i][k] = array[i][k+1];
						array[i][k+1] = temp;
						changes++;
					}
				}
				counter++;
				changesCounter += changes;	
			}

			DecimalFormat  df = new DecimalFormat("0.0#");
			double average = (double) changesCounter/counter;
			double finalAverage = Math.floor(average * 100) / 100;
			bw.write(df.format(finalAverage).replace(",", ".") + " - " + Arrays.toString(array[i]).replace("[", "").replace("]", "").replace(",", " "));

			bw.newLine();
			bw.flush();
		}
		
		bw.close();
	}

	public static void main(String[] args) throws IOException {
		
		readData();
		dataSorting();

	}

}
