
public class Ex30 {

	public static void main(String[] args) {

		System.out.println(countDigits(399));
		CurzonNumber(14);
		int [] numbers = {1,15,16,17,18,20,21};
		largestGap(numbers);
	
	
	
	}
	
/*21 Create a function that recursively counts the integer's number of digits.
Examples
count(318) ➞ 3 
count(-92563) ➞ 5*/
	
	public static int countDigits(int num) {
        // Handle negative numbers by converting them to positive
        num = Math.abs(num);
        
        // Base case: if the number is less than 10, it has only one digit
        if (num < 10) {
            return 1;
        } else {
            // Recursive case: divide the number by 10 and count the remaining digits
            return 1+ countDigits(num / 10);
        }
    }


/*22 Given a positive integer n and if 1 plus 2 times n exactly divides 1 plus 2 
 * raised to the power n, then n is said to be a Curzon number.
 * isCurzon(5) ➞ true
// 2 ** 5 + 1 = 33
// 2 * 5 + 1 = 11
// 33 is a multiple of 11

isCurzon(10) ➞ false
// 2 ** 10 + 1 = 1025
// 2 * 10 + 1 = 21
// 1025 is not a multiple of 21
 * */
	public static void CurzonNumber(int num) {
		
		int num2 = (int) (Math.pow(2, num)+1);
		int num3 = 2*num+1;
		
		if(num2%num3==0) {
			System.out.println("It's a curzon number");
	}else System.out.println("It's not a curzon number");
	
	}

	
/*23 Given an array of integers, return the largest gap between the sorted elements of the array.

	For example, consider the array:
	
	[9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5]
	... in which, after sorting, the array becomes:
	
	[0, 0, 4, 5, 5, 6, 9, 20, 25, 26, 26]
	... so that we now see that the largest gap in the array is between 9 and 20 which is 11.*/
	
	
	public static void largestGap (int [] numbers) {
		
		int aux=0, num1=0, num2=0, addition=0, difference=0;
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if(numbers[i]<numbers[j]) {
					aux=numbers[j];
					numbers[j]=numbers[i];
					numbers[i]= aux;
				}
			}
		}
		for(int number : numbers) {
			System.out.println(number);
		}
		for (int i = 0; i < numbers.length; i++) {
			if(i<=numbers.length-2) {
				addition= numbers[i+1] - (numbers[i]);
			}
			if(addition>difference) {
				difference = addition;
			}
			addition=0;
		}
		System.out.println("The lasgest difference is "+difference);
		
	}
}

