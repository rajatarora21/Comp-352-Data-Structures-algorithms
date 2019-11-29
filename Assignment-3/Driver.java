import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args)
	{
		System.out.println("********** WELCOME TO SMARTAR **********");
		Scanner input =new Scanner(System.in);
		SmartAR smartARObj=new SmartAR();
		smartARObj.setThreshold();
		smartARObj.setKeyLength();
		while(true)
		{
			System.out.println("1.Enter cars");
			System.out.println("2.Remove Cars");
			System.out.println("3.Get values of the Key");
			System.out.println("4.Next Car just after your registration");
			System.out.println("5.Previous car before your registration");
			System.out.println("6.All the previous cars registered before you");
			System.out.println("7.Return all the keys in sorted way.");
			System.out.println("8.Print all the deleted cars.");
			System.out.println("9.Print all the cars.");
			System.out.println("10.exit");
			int choice =input.nextInt();
			switch(choice)
			{
				case 1:
						System.out.println("How many cars:");
						int cars=input.nextInt();
						smartARObj.generate(cars);
						break;
				case 2:
						System.out.println("Enter the key of the car to remove:");
						String key =input.next();
						smartARObj.Remove(key);
						break;
				case 3:
						System.out.println("Enter the key of the car to get Values:");
						String keyValue =input.next();
						smartARObj.getValues(keyValue);
						break;
				case 4:
						System.out.println("Enter a key to get the next key:");
						String nextKey=input.next();
						System.out.println(smartARObj.nextKey(nextKey));;
						break;
				case 5:
						System.out.println("Enter a key  to get the previous key:");
						String prevKey=input.next();
						System.out.println(smartARObj.prevKey(prevKey));;
						break;
				case 6:
						System.out.println("Enter the key to get previous cars:");
						String prevKeys=input.next();
						ArrayList<String> tempList=smartARObj.previousCars(prevKeys);
						for(int i=tempList.size()-1;i>=0;i--)
						{
							System.out.println(tempList.get(i));
						}
						break;
				case 7:
						System.out.println("Here are the sorted keys");
						ArrayList<String> list=smartARObj.allKeys();
						for(int i=0;i<list.size();i++)
						{
							System.out.println(list.get(i));
						}
						break;
				case 8:
						smartARObj.printDeletedCars();
						break;
				case 9:
						smartARObj.printCars();
						break;
				case 10:
						System.exit(0);
			
			
			}

		}
				
		
		
	}
}
