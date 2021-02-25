import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {

	public static double[] array;
	public static DecimalFormat df = new DecimalFormat("#.0#");
	public final static String SPLITTER=" ";
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		String nLines = br.readLine();
		int num = Integer.parseInt(nLines);
		
		String message="";
		
		for(int i=0; i<num;i++) {
			String line = br.readLine();
			String[] parts=line.split(SPLITTER);
			array=new double[parts.length];
	
			for(int j=0; j<parts.length;j++) {

				array[j]= Double.parseDouble(parts[j]);
				
			}
			double average=bubbleSort();
			df.setRoundingMode(RoundingMode.DOWN);
			message+=df.format(average).replace(",", ".")+"-";
			for(int j=0; j<array.length;j++) {
				if(j!=array.length-1) {
					message+=array[j]+" ";
				}
				else {
					message+=array[j];
				}
				
			}
			
			
			message+="\n";
			
		}
		
		

		bw.write(message);	

		br.close();
		bw.close();


	}
	
	public static double bubbleSort() {
		double average=0;
		
		for(int i=1; i<array.length;i++) {
			int changes=0;
			for(int j=0;j<array.length-i;j++) {
				if(array[j]>array[j+1]) {
					changes++;
					double temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;
				}
			}
			average+=changes;

		}
		
		return average/(array.length-1);
	}

}
