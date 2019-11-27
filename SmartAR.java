import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class SmartAR 
{
	ArrayList<String> keys;
	Hashtable<String,String> keys1;
	int threshold;
	public SmartAR()
	{
		keys=new ArrayList<String>();
	}
	public void setThreshold(int value)
	{
		threshold=value;
	}
	public void add(String key,String value)
	{
		
		if(threshold>100)
		{
			keys1.put(key,value);
		}
		else if(threshold<100)
		{
			keys.add(key);
		}
		else if(threshold==100)
		{
			for(int i=0;i<100;i++)
			{
				keys1.put(keys.get(i),null);
			}
			keys1.put(key,value);
		}
			
		
	}
	public void remove(String key)
	{
		keys.remove(key);
	}
	public void getValues(String key)
	{
		
	}
	public String nextKey(String key)
	{
		return keys.get(keys.indexOf(key)+1);
	}
	public String prevKey(String key)
	{
		return keys.get(keys.indexOf(key)-1);
	}
	public String[] previousCars(String key)
	{
		int index=keys.indexOf(key);
		String[] temp=new String[index];
		for(int i=0;i<index;i++)
		{
			temp[i]=keys.get(i);
		}
		return temp;
	}
	public void generate(int n) 
    {   
		
		for(int j = 0; j < n; j++) {
		// chose a Character random from this String 
			String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 
  
        // create StringBuffer size of AlphaNumericString 
			StringBuilder sb = new StringBuilder(n); 
  
			for (int i = 0; i < 12; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString.charAt(index));            
        } 
			String temp=sb.toString();
			if(keys.contains(temp)==false)
				keys.add(sb.toString());
			else
				generate(n);
    }
         
    }
	public static void main(String[] args)
	{
		SmartAR obj=new SmartAR();
		
		
		while(true)
		{
			System.out.println("Enter choice:");
			System.out.println("1.add");
			System.out.println("2.remove");
			System.out.println("3.nextKey");
			System.out.println("4.prevKey");
			System.out.println("5.prevCars");
			System.out.println();
			Scanner s=new Scanner(System.in);
			int choice =s.nextInt();
			switch(choice)
			{
				case 1:System.out.println("Enter a key");
						String key =s.next();
						obj.add(key,null);
						break;
				case 2:System.out.println("Enter a key");
						String key1 =s.next();
						obj.remove(key1);
						break;
				case 3:System.out.println("Enter a key");
					String key2 =s.next();
					System.out.println(obj.nextKey(key2));;
					break;
				case 4:System.out.println("Enter a key");
					String key4=s.next();
					System.out.println(obj.prevKey(key4));;
					break;
				case 5:
					System.out.println("Enter a key");
					String key5=s.next();
					String[] temp=obj.previousCars(key5);
					for(int i=0;i<temp.length;i++)
					{
						System.out.println(temp[i]);
					}
				case 6:
					System.exit(0);
				
			}
		}
		
	}
	
	
}
