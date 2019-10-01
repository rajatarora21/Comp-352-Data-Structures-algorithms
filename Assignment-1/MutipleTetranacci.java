import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MutipleTetranacci {
	//static method that runs MultipleTetranacci.
	public static long tetrenacciPlus(int a){ 
		
		if(a <3 )
			return 0; 
		if (a==3)
			return 1;
			//using multiple recursion to calculate tetranacci.
			return (tetrenacciPlus(a-1)+tetrenacciPlus(a-2)+tetrenacciPlus(a-3)+tetrenacciPlus(a-4)); 
	}
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter pw=new PrintWriter("outMultiple.txt");
		for(int i=0;i<38;i++) //printing tetranacci from 0 to 38. After that it takes exponential time to calculate the value.
		{
			double start=System.currentTimeMillis(); //start time 
			long value=tetrenacciPlus(i); //calculating tetranacci 
			System.out.println(value);
			double end=System.currentTimeMillis(); //end time
			System.out.println((end-start)/1000); //time taken to calculate the value.
			pw.println();
			pw.println("The value of the tetranacci("+i+")"+value); //writing in a file.
			pw.println("The time of tetranacci ("+i+") is :"+(end-start)/1000);
			pw.println();
			
		}
		pw.close();
		
	}
}
