import java.util.*;

import javax.sound.midi.Soundbank;
public class javapractical {
	
	
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
	
	
	
	
	public static void main(String[] args) {
		double a[] = {1, 19, 7, 6, 5, 9, 12, 27, 18, 2, 15};
		int n = a.length;

		System.out.println(firstQuartile(a));
		System.out.println(thirdQuartile(a));
		System.out.println(variance(a, n));
		System.out.println(interQuartile(a));
	}
}
