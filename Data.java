package in.edu.scse.xim.statistics;

import java.util.*;
public class Data {
	
	double arr[];  // INSTANCE VARIABLE
	int size; // INSTANCE VARIABLE
	

	/* CONSTRUCTOR */
	public Data(int size, double input[]) throws DataSetEmptyException{
    
		arr = new double[size];
		this.size = size;
		//checking if the dataset recieved as parameter is empty, if yes, we throw an exception
		if (size== 0) {
            throw new DataSetEmptyException("Please add some values in your data");
        }
		if (input.length==0){
			throw new DataSetEmptyException("Please add some values in your data");
		}
        for(int i = 0; i < size; i++) {
			arr[i] = input[i];
        }
						
	}
	
	/* METHODS */
	
	
	public double medianCalc()
    {		
        Arrays.sort(arr); // we sort the array to calculate the median
        if (size% 2 != 0) // check for even size case
            return(double)arr[size/ 2];
 
        return(double)(arr[(size- 1) / 2] + arr[size/ 2]) / 2.0;
    }
	
	
	public  double meanCalc() {
		  
		  double sum = 0;
		  
	      for(int i = 0; i < size; i++) {
	         sum+=arr[i];
	      }
		
	      return(sum/(float)size);
	}
	
	
	public int freqCalc() {
		
		int count=0;
		
		for (double i : arr) 
		{
		    if(i==size)
		    	count++;
		}
		
		return(count);
	}
	
	//Utility method for returning sum of values a different array
	public double sumCalc(double array[]) {    
		double sum = 0;
		for(double i : array) {
			sum+=i;
		}
		return(sum);
	}
	
	//Utility method for returning sum of values of the array of the particular object
	public double sumCalc() {    
		double sum = 0;
		for(double i : this.arr) {
			sum+=i;
		}
		return(sum);
	}
	
	
	//finding the maximum element in the Dataset
	public  double maxCalc() {
		double max = arr[0];
		for (double i : arr ) {
			if ( max < i ) {
				max = i;
			}
		}
		return(max);
	}
	
	
	
	//Finding the minimum element in the Dataset
	public  double minCalc() {
		double min= arr[0];
		for (double i : arr ) {
			if(min>i) {
				min = i;
			}
		}
		return(min);
	}


	//calculating the trimmed mean taking percentage trimmed as input
	public  double trimmedMean(double perc) {
		int g = (int)Math.floor((perc/100)*size);
		int len = size - 2*g;
		double temp[] = arr.clone();
		Arrays.sort(temp);
		for(int i = 0; i<size && g!=0;i++,g--) {
			temp[i] = 0;
			temp[arr.length-(i+1)] = 0 ;//defining the trimmed values as 0
			}
		return(this.sumCalc(temp)/len);
	}
	
	
	
	//method to calculate the firstQuartile
	public double firstQuartile() {
		double b[] = arr.clone();
		Arrays.sort(b);
		return(b[(int)(Math.floor(((size+1)/4)))]);
	}
	
	
	
	//method to calculate the second quartile
	public double thirdQuartile() {
		double b[] = arr.clone();
		Arrays.sort(b);
		return(b[(int)(Math.floor((3*(size+1)/4)))]);
	}
	
	
	//method to calculate inter-quartile 
	public double interQuartile()
	{
	    return(thirdQuartile()-firstQuartile());
	}
	
	
	//method to calculate variance
	public double variance() {
		double squareDifference = 0;
		int size = arr.length;
		for (int i = 0; i < size; i++)
			squareDifference += (arr[i] - meanCalc()) *
		       (arr[i] - meanCalc());
		
		return(squareDifference / size);
	}
	
	
	//method to calculate standard deviation
	public double stndDeviation() {
		int size = arr.length;
		return(Math.sqrt(variance()));
	}
	
	
	
	// Taking a Data object as an parameter		
	public double coVariance(Data obj) throws UnequalArrayException {
		

		if(this.size!=obj.size) {
			throw new UnequalArrayException("Co-variance methods require arrays of equal length");

		}
		else {
			double sum = 0;
		    double mean_a = this.meanCalc();
		    double mean_b = obj.meanCalc();
		   
		    for(int i = 0; i < this.size; i++)
		        sum = sum + (this.arr[i] - mean_a) * (obj.arr[i] - mean_b);
		    return sum / (this.size - 1);
		}
	}
	
	
	
	//method to calculate correlation
	public double correlation(Data obj) throws UnequalArrayException {
		

		if (this.size != obj.size) {
			throw new UnequalArrayException("Co-relation methods require arrays of equal length");
		}
		else {
			double sum_a = this.sumCalc(), sum_b = obj.sumCalc(), sum_ab = 0;
	        double squaresum_a = 0, squaresum_b = 0;
	       
	        for (int i = 0; i < sizeN; i++)
	        {            
	       
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
	
	
	//method to return a map where dataset elements are the keys and their frequency is the value
	public Map<Double, Integer>  frequencyNumber()
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