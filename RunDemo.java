import java.util.*;
class RunDemo{
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many entries? ");
        	int size = input.nextInt();
		System.out.println("Enter your Data Set separated by a new line");
		for(int i = 0; i < size; i++) {
			System.out.print("Enter your value: ");
			arr[i] = input.nextDouble();
        }
		Data values = new Data(size,arr);
		
		int flag;
		flag = input.nextInt();
		while(flag!=0) {
			
			System.out.println("-------------- M E N U ---------------");
			System.out.println("Which operation do you want to perform on your set of data? (enter corresponding number from 1 to 13)");
			System.out.println("1. Calculate median");
			System.out.println("2. Calculate mean");
			System.out.println("3. Calculate frequency");
			System.out.println("4. Calculate total sum of data");
			System.out.println("5. Find maximum");
			System.out.println("6. Find minimum");
			System.out.println("7. Calculate trimmed mean");
			System.out.println("8. Calculate first quartile");
			System.out.println("9. Calculate third quartile");
			System.out.println("10. Calculate third quartile");
			System.out.println("11. Calculate variance");
			System.out.println("12. Calculate co-variance");
			System.out.println("13. Calculate standard deviation");
			System.out.println("14. Calculate correlation");
            		System.out.println("15. Calculate frequency number");
			System.out.println("ENTER 0 TO QUIT.");

            int i = input.nextInt();
			
			switch(i){
				case 1 :
					System.out.println("Printing median: " +  values.medianCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 2 : 
					System.out.println("Printing mean: " +  values.meanCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 3 :
					System.out.println("Printing frequency: " +  values.freqCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 4 :
					System.out.println("Printing sum of data: " +  values.sumCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 5 :
					System.out.println("Printing max from data: " +  values.maxCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 6 :
					System.out.println("Printing min from data: " +  values.minCalc());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 7 :
					System.out.println("Printing trimmed mean: " +  values.trimmedMean(percentage)); // pass percentage value
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 8 :
					System.out.println("Printing first quartile: " +  values.firstQuartile());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 9 :
					System.out.println("Printing third quartile: " +  values.thirdQuartile());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 10 :
					System.out.println("Printing inter-quartile: " +  values.interQuartile());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 11 :
					System.out.println("Printing variance: " +  values.variance());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 12 :
					System.out.println("Printing co-variance: " +  values.coVariance());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 13 :
					System.out.println("Printing standard deviation: " +  values.stndDeviation());
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
				
				case 14 :
                
                    			Data b = new Data(size);
					System.out.println("Printing correlation: " +  values.correlation(b));
                    
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush();
					break;
					
				case 15 :
                
					for (Map.Entry<Double,Integer> iterator :values.frequencyNumber().entrySet())
                   `			{
                        		System.out.println(iterator.getKey() +" element has frequency "+iterator.getValue());
                        		}
					System.out.print("\033[H\033[2J"); // clear screen
					System.out.flush(); // clear screen
					break;
		}
		flag--;
	}
    System.out.println("Terminated.");
}
}

