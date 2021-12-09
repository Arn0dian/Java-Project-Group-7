import java.util.*;
public class Data {
	
	double a[]; //dynamic initialization


	public Data(int n) throws DataSetEmptyException{
    
		Scanner input = new Scanner(System.in);		
        for(int i = 0; i < n; i++) {
			System.out.print("Enter your value: ");
			a[i] = input.nextDouble();
        }
		if (n == 0) {
            throw new DataSetEmptyException("Array is empty");
        }
		
	}
	
	public static double medianCalc(double a[], int n)
    {
        Arrays.sort(a); // we sort the array to calculate the median
        
        if (n % 2 != 0) // check for even case 
            return (double)a[n / 2];
 
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }
	
	
	public static double meanCalc(double a[],int n) {
		  double sum = 0;
	      for(int i = 0; i < n; i++) {
	         sum+=a[i];
	      }
	      return(sum/(float)n);
	}
	
	
	public static int freqCalc(double a[],int n) {
		int count=0;
		for (double i : a) 
		{ 
		    if(i==n)
		    	count++;
		}
		return(count);
	}
	
	
	public static double sumCalc(double a[]) {    
		double sum = 0;
		for(double i : a) {
			sum+=i;
		}
		return(sum);
	}
	
	
	public static double maxCalc(double a[]) {
		double max = a[0];
		for (double i : a ) {
			if(max<i) {
				max = i;
			}
		}
		return(max);
	}
	
	
	public static double minCalc(double a[]) {
		double min = a[0];
		for (double i : a ) {
			if(min>i) {
				min = i;
			}
		}
		return(min);
	}

	public static double trimmedMean(double a[], double perc) {
		int g = (int)Math.floor((perc/100)*a.length);
		int len = a.length - 2*g;
		Arrays.sort(a);
		for(int i = 0; i<a.length && g!=0;i++) {
			a[i] = 0;
			a[a.length-(i+1)] = 0 ;
			g--;
		}
		return(sumCalc(a)/len);
	}
	
	
	public static double firstQuartile(double a[]) {
		Arrays.sort(a);
		return(a[(int)(Math.floor(((a.length+1)/4)))]);
	}
	
	
	public static double thirdQuartile(double a[]) {
		Arrays.sort(a);
		return(a[(int)(Math.floor((3*(a.length+1)/4)))]);
	}
	
	public static double interQuartile(double [] a)
	{
	    return(thirdQuartile(a)-firstQuartile(a));
	}
	
	static double variance(double a[],int n) {
		double squareDifference = 0;
		for (int i = 0; i < n; i++)
			squareDifference += (a[i] - meanCalc(a, n)) *
		       (a[i] - meanCalc(a, n));
		
		return(squareDifference / n);
	}
	
	
	static double stndDeviation(double a[],int n) {
		return(Math.sqrt(variance(a, n)));
	}
	
	
	
	
	public static double coVariance(double a[],double b[], int n) throws UnequalArrayException {
		if(a.length!=b.length) {
			throw new UnequalArrayException("co-variance functions require arrays of equal length");

		}
		else {
			double sum = 0;
		      double mean_a = meanCalc(a,n);
		      double mean_b = meanCalc(b,n);
		   
		    for(int i = 0; i < n; i++)
		        sum = sum + (a[i] - mean_a) *
		                        (b[i] - mean_b);
		    return sum / (n - 1);
		} 
	}
	
	
	
	
	public static double corRelation(double a[],double b[], int n) throws UnequalArrayException {
		
		if (a.length!=b.length) {
			throw new UnequalArrayException("Co-relation functions require arrays of equal length");
			
		}
		else {
			double sum_a = 0, sum_b = 0, sum_ab = 0;
	        double squaresum_a = 0, squaresum_b = 0;
	       
	        for (int i = 0; i < n; i++)
	        {
	            // sum of elements of array a
	            sum_a = sum_a + a[i];
	       
	            // sum of elements of array bY.
	            sum_b = sum_b + b[i];
	       
	            // sum of a[i] * b[i].
	            sum_ab = sum_ab + a[i] * b[i];
	       
	            // sum of square of array elements.
	            squaresum_a = squaresum_a + a[i] * a[i];
	            squaresum_b = squaresum_b + b[i] * b[i];
	            
	        }
	            // use formula for calculating correlation 
	            // coefficient.	            
	            double corr = (float)(n * sum_ab - sum_a * sum_b)/
	                     (float)(Math.sqrt((n * squaresum_a -
	                     sum_a * sum_a) * (n * squaresum_b - 
	                     sum_b * sum_b)));
	            
	            return corr;
		}
	}
	
	static Map<Double, Integer>  frequencyNumber(double arr[], int size)
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
