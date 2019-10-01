import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//This class implements tail-recursion of tetranacci numbers.
public class LinearTetranacci {
	//this method returns the tetranacci number at a particular index.
	//This method uses tail recursion to calculate the tetranacci number.
	public static long linearTet(int a,int i,int j,int k,int l)
	{
		if(a==0)
			return i;
		if(a==1)
			return j;
		if(a==2)
			return k;
		if(a==3)
			return l;
		return linearTet(a-1,j,k,l,i+j+k+l); //tail recursive call to calculate tetranacci.
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter pw=new PrintWriter("outLinear.txt");
		for(int i=0;i<1000;i++) //printing tetranacci from 0 to 1000.
		{
			double start=System.currentTimeMillis(); //start time in milli-seconds
			long value=linearTet(i,0,0,0,1);
			System.out.println(value);
			double end=System.currentTimeMillis(); //end time in milli-seconds
			System.out.println((end-start)/1000); //time taken to calculate the value. 
			pw.println();
			pw.println("The value of the tetranacci("+i+")"+value); //writing in file
			pw.println("The time of tetranacci ("+i+") is :"+(end-start)/1000);
			pw.println();
			
		}
		pw.close();
		
	}	
}
