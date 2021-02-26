package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

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
			output += output(ageArray)+"\n";
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
	
	public static String output(double[] ageArray) {
		DecimalFormat df = new DecimalFormat("#.00");
		double decimals = ageArray[0] - (int)ageArray[0];
		String dString = decimals+"";
		String average = "";
		if(ageArray[0] % 1 == 0) {
			average = df.format(ageArray[0]) + "-";
		}
		else if(dString.charAt(3) == '0') {
			average = df.format(ageArray[0]) + "-";
			average = average.substring(0, average.length()-1)+"-";
		}
		else {
			df.setRoundingMode(RoundingMode.DOWN);
			average = df.format(ageArray[0]) + "-";
		}
		for(int i = 1; i < ageArray.length; i++) {
			average += ageArray[i]+" ";
		}
		
		average = average.substring(0, average.length()-1);
		
		return average;
	}
}