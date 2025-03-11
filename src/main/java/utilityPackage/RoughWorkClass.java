package utilityPackage;

import java.util.*;

public class RoughWorkClass {

	

		int missingNumber(int[] arr, int n) {
		    int sum = n * (n + 1) / 2;
		    for (int num : arr) sum -= num;
		    return sum;
		}

	
	
	
	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,6,7,8,10};
		
		RoughWorkClass roughWorkClass = new RoughWorkClass();
		
		roughWorkClass.missingNumber(arr, 11);
 
	}
}
