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
			ageArray = bubbleSort(ageArray);
		}
		bw.write(output);
		
		br.close();
		bw.close();
	}
	
	public static double[] bubbleSort(double[] ageArray) {
		double totalChanges = 0;
		int changes = 1;
		double[] sortedArray = new double[ageArray.length+1];
		for(int  i = 1; i < ageArray.length && changes > 0; i++) {
			changes = 0;
			for(int j = 0; j < ageArray.length-i; j++) {
				if(ageArray[j] > ageArray[j+1]) {
					double temp = ageArray[j];
					ageArray[j] = ageArray[j+1];
					ageArray[j+1] = temp;
					changes++;
				}
			}
			totalChanges += changes;
		}
		totalChanges = totalChanges/(ageArray.length-1);
		sortedArray[0] = totalChanges;
		for(int i = 0; i < ageArray.length; i++) {
			sortedArray[i+1] = ageArray[i];
		}
		return sortedArray;
	}
}