package in.edu.scse.xim.statistics;

import java.util.*;
public class Data {
	
	double arr[];  // INSTANCE VARIABLE
	

	/* CONSTRUCTOR */
	public Data(int size) throws DataSetEmptyException{
    
		arr = new double[size];
		Scanner input = new Scanner(System.in);
		System.out.println();
        for(int i = 0; i < size; i++) {
			System.out.print("Enter your value: ");
			arr[i] = input.nextDouble();
        }
		if (size== 0) {
            throw new DataSetEmptyException("Array is empty");
        }
		
		System.out.println();
		
	}
	
	/* METHODS */
	
	public double medianCalc()
    {		
        Arrays.sort(arr); // we sort the array to calculate the median
        int size = arr.length;
        if (size% 2 != 0) // check for evesizecase
            return(double)arr[size/ 2];
 
        return(double)(arr[(size- 1) / 2] + arr[size/ 2]) / 2.0;
    }
	
	
	public  double meanCalc() {
		  
		  int size = arr.length;
		  double sum = 0;
		  
	      for(int i = 0; i < size; i++) {
	         sum+=arr[i];
	      }
		
	      return(sum/(float)size);
	}
	
	
	public int freqCalc() {
		
		int count=0;
		int size = arr.length;
		
		for (double i : arr) 
		{
		    if(i==size)
		    	count++;
		}
		
		return(count);
	}
	
	
	public double sumCalc(double array[]) {    
		double sum = 0;
		for(double i : array) {
			sum+=i;
		}
		return(sum);
	}
	
	// overloaded method
	public double sumCalc() {    
		double sum = 0;
		for(double i : arr) {
			sum+=i;
		}
		return(sum);
	}
	
	public  double maxCalc() {
		double max = arr[0];
		for (double i : arr ) {
			if ( max < i ) {
				max = i;
			}
		}
		return(max);
	}
	
	
	public  double minCalc() {
		double min= arr[0];
		for (double i : arr ) {
			if(min>i) {
				min = i;
			}
		}
		return(min);
	}

	public  double trimmedMean(double perc) {
		int g = (int)Math.floor((perc/100)*arr.length);
		int len = arr.length - 2*g;
		double temp[] = arr.clone();
		Arrays.sort(arr);
		for(int i = 0; i<arr.length && g!=0;i++) {
			temp[i] = 0;
			temp[arr.length-(i+1)] = 0 ;
			g--;
		}
		return(this.sumCalc(temp)/len);
	}
	
	
	public double firstQuartile() {
		double b[] = arr.clone();
		Arrays.sort(b);
		return(b[(int)(Math.floor(((b.length+1)/4)))]);
	}
	
	
	public double thirdQuartile() {
		double b[] = arr.clone();
		Arrays.sort(b);
		return(b[(int)(Math.floor((3*(b.length+1)/4)))]);
	}
	
	public double interQuartile()
	{
	    return(thirdQuartile()-firstQuartile());
	}

	public double variance() {
		double squareDifference = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++)
			squareDifference += (arr[i] - meanCalc()) *
		       (arr[i] - meanCalc());
		
		return(squareDifference / size);
	}
	
	
	public double stndDeviation() {
		int size = arr.length;
		return(Math.sqrt(variance()));
	}
	
	
	
	public double coVariance(Data obj) throws UnequalArrayException {
		
		int sizeN = (this.arr).length;
		int sizeM = (obj.arr).length;
		if(sizeN!=sizeM) {
			throw new UnequalArrayException("Co-variance functions require arrays of equal length");

		}
		else {
			double sum = 0;
		    double mean_a = meanCalc();
		    double mean_b = meanCalc();
		   
		    for(int i = 0; i < sizeN; i++)
		        sum = sum + (this.arr[i] - mean_a) *
		                        (obj.arr[i] - mean_b);
		    return sum / (sizeN - 1);
		}
	}
	
	
	public double correlation(Data obj) throws UnequalArrayException {
		
		int sizeN = (this.arr).length;
		int sizeM = (obj.arr).length;

		if (sizeN != sizeM) {
			throw new UnequalArrayException("Co-relation functions require arrays of equal length");
		}
		else {
			double sum_a = 0, sum_b = 0, sum_ab = 0;
	        double squaresum_a = 0, squaresum_b = 0;
	       
	        for (int i = 0; i < sizeN; i++)
	        {
	            // sum of elements of array a
	            sum_a = sum_a + this.arr[i];
	       
	            // sum of elements of array bY.
	            sum_b = sum_b + obj.arr[i];
	       
	            // sum of a[i] * b[i].
	            sum_ab = sum_ab + this.arr[i] * obj.arr[i];
	       
	            // sum of square of array elements.
	            squaresum_a = squaresum_a + this.arr[i] * this.arr[i];
	            squaresum_b = squaresum_b + obj.arr[i] * obj.arr[i];
	            
	        }
	            // use formula for calculating correlation 
	            // coefficient.	            
	            double corr = (float)(sizeN * sum_ab - sum_a * sum_b)/
	                     (float)(Math.sqrt((sizeN * squaresum_a -
	                     sum_a * sum_a) * (sizeN * squaresum_b - 
	                     sum_b * sum_b)));
	            
	            return corr;
		}
	}
	
	public Map<Double, Integer>  frequencyNumber(int size)
    {
        // Creating a HashMap containing integer
        // as a key and occurrences as a value
        HashMap<Double, Integer> freqMap = new HashMap<Double, Integer>();
 
        for (int i=0;i<size;i++) {
            if (freqMap.containsKey(arr[i])) {
 
                // If number is present in freqMap,
                // incrementing it's count by 1
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }
            else {
 
                // If integer is not present in freqMap,
                // putting this integer to freqMap with 1 as it's value
                freqMap.put(arr[i], 1);
            }
        }
            return freqMap;
        }
}
