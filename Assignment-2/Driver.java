package comp352;
//Score far Right algorithm
public class Driver {
	
	public static boolean result=false;
	public static void scoreFarRight(int [] A, int start, int[] flag) 
	{
		if(flag==null) //a flag array to check if a index repeated again or not , if repeated its an infinite loop , so return false.
			flag=new int[A.length];
		if(A[start]==0) //if my value in the array in 0 , that is the last index , then return true.
		{
			System.out.println("1st");
			result = true;
			return;
		}
		else if(start-A[start]>=0&&start+A[start]<A.length) //if we can go both right and left.
		{
			if(flag[start+A[start]]==0) //check if my value is repeated or not.
			{
				System.out.println("2nd"+(start+A[start]));
				flag[start+A[start]]=1;
				scoreFarRight(A,start+A[start],flag); //first make a right jump.
				if(result==false) //if the right jump returns false , then go left.
				{
					if(flag[start-A[start]]==0) //check on infinite loop.
					{
						System.out.println("3rd"+(start-A[start]));
						flag[start-A[start]]=1;
						scoreFarRight(A,start-A[start],flag);
					}
					else if(flag[start-A[start]]==1)
					{
						System.out.println("4th"+(start-A[start]));
						result=false;
						return;
					}
	
				}
				
			}
			else if(flag[start+A[start]]==1)
			{
				System.out.println("5th"+(start+A[start]));
				result=false;
				return;
			}
			
		}
		else if(start-A[start]<0&&start+A[start]<A.length) //can only make a right jump.
		{
			//System.out.println("2nd if");
			if(flag[start+A[start]]==0)
			{
				System.out.println("6th"+start+A[start]);
				flag[start+A[start]]=1;
				scoreFarRight(A,start+A[start],flag);
			}
			else if(flag[start+A[start]]==1)
			{
				System.out.println("7th"+(start+A[start]));
				result =false;
				return;
			}

		}
		else if(start-A[start]>=0&&start+A[start]>=A.length) //can only make a left jump
		{
			System.out.println("3rd ifsasax"+(start-A[start]));
			if(flag[start-A[start]]==0)
			{
				flag[start-A[start]]=1;
				scoreFarRight(A,start-A[start],flag);
			}
			else if(flag[start-A[start]]==1)
			{
				result =false;
				return;
			}
			
		}
		else if(start-A[start]<0&&start+A[start]>=A.length)//cannot make jump either way.
		{
			System.out.println("10th if");
			result = false;
			return;
		}
		
	}
	public static void main(String[] args)
	{
		int[] a= {4,7,7,6,3,9,2,5,0};
		int[] flag = null;
		scoreFarRight(a,0,flag);
		System.out.println(result);
	}
	
}
