package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
		
		String line = "";
		String output = "";
		String[] ageStringArray;
		double[] ageArray;
		int numLines = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < numLines; i++) {
			line = br.readLine();
			ageStringArray = line.split(" ");
			int length = ageStringArray.length;
			ageArray = new double[length];
			for(int j = 0; j < length; j ++) {
				ageArray[j] = Double.parseDouble(ageStringArray[j]);
			}
			
		}
		bw.write(output);
		
		br.close();
		bw.close();
	}
	
	
}