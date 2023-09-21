import java.lang.reflect.Array;
import java.util.Arrays;

public class Ex30 {

	public static void main(String[] args) {

		System.out.println(countDigits(399));
		CurzonNumber(14);
		int [] numbers = {1,15,16,17,18,20,21};
		largestGap(numbers);
		
		int [] numbers1 = {1,2,6,7,9};
		int [] numbers2 = {1, 2, 5, 9, 9};
		NumberedCards(numbers1, numbers2);
		isFactorial(27);
		String [] person1 = {"share", "share"};
		String [] person2 = {"share", "steal"};
		CoinOperation(person1, person2);

		HarshadNumber(171);
	
	
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


/*24 Numbered Cards
	You have a pack of 5 randomly numbered cards, which can range from 0-9. You can win if you can produce a higher two-digit number
	 from your cards than your opponent. Return true if your cards win that round.

	Examples
	winRound([2, 5, 2, 6, 9], [3, 7, 3, 1, 2]) ➞ true
	// Your cards can make the number 96
	// Your opponent can make the number 73
	// You win the round since 96 > 73*/ 


	    public  static void NumberedCards (int [] array1, int array2 []) {

	        Arrays.sort(array1);
	        Arrays.sort(array2);

	        if(array1[array1.length-1]>array2[array2.length-1]){
	            System.out.println("array 1 win");
	        }
	        else  if(array1[array1.length-1]==array2[array2.length-1]){
	        	if(array1[array1.length-2]>array2[array2.length-2])
	        		System.out.println("Array 1 win");
	        	else System.out.println("Array 2 win");

	        }else System.out.println("Array 2 win");
	        	
	        }
/*25 Is the Input Factorial of an Integer?
Create a function that checks if a given integer is exactly the factorial of an integer or not. true if it is, false otherwise.

Examples
isFactorial(2) ➞ true
// 2 = 2 * 1 = 2!

isFactorial(27) ➞ false

isFactorial(24) ➞ true
// 24 = 4 * 3 * 2 * 1 = 4!*/
	    
	public static void isFactorial(int num) {
		
		int addition=1, count=1;
		
		while (addition<num) {
			
			addition += addition*count;
			count++;
		}
		if(num==addition) System.out.println(num + " is factorial of "+ count);
		else System.out.println(num + " isn't a factorial");
	}
	    
/*26Coin Co-Operation
Let's say that there exists a machine that gives out free coins, but with a twist!

Separating two people is a wall, and this machine is placed in such a way that both people are able to
 access it. Spending a coin in this machine will give the person on the other side 3 coins and vice 
 versa.

If both people continually spend coins for each other (SHARING), then they'll both gain a net profit
 of 2 coins per turn. However, there is always the possibility for someone to act selfishly
  (STEALING): they spend no coins, yet they still receive the generous 3 coin gift from the 
  other person!
  getCoinBalances(["share"], ["share"]) ➞ [5, 5]
// Both people spend one coin, and receive 3 coins each.

getCoinBalances(["steal"], ["share"]) ➞ [6, 2]
// Person 1 gains 3 coins, while person 2 loses a coin.

getCoinBalances(["steal"], ["steal"]) ➞ [3, 3]
// Neither person spends any coins and so no one gets rewarded.

getCoinBalances(["share", "share", "share"], ["steal", "share", "steal"]) ➞ [3, 11]
  */
	public static void CoinOperation(String [] array1, String [] array2) {
		
		int coin1=3, coin2=3;
		
		for (int i = 0; i < array1.length; i++) {
				if(array1[i].equalsIgnoreCase("Share")) {
						if(array2[i].equalsIgnoreCase("Share")) {
							coin1+=2;
							coin2+=2;
						}else {
							coin1-=1;
							coin2+=3;
						}
				}else {
					if(array2[i].equalsIgnoreCase("Share")) {
						coin1+=3;
						coin2-=1;
					}
				}
		}
		System.out.println("person one has "+ coin1+ " and person two has "+ coin2);
	}
	
/*27 Recursion: Harshad Number
A number is said to be Harshad if it's exactly divisible by the sum of its digits. 
Create a function that determines whether a number is a Harshad or not.
isHarshad(75) ➞ false
// 7 + 5 = 12
// 75 is not exactly divisible by 12
 
isHarshad(171) ➞ true
// 1 + 7 + 1 = 9
// 9 exactly divides 171*/	
	public static void HarshadNumber(int num) {
		int result = RHarshadNumber(num);
		if(num%result==0) 
			System.out.println("the result of the sum of their digits gives an integer division ");
		else System.out.println("the result of the sum of their digits doesn't give an integer division");
	}
	
	private static int RHarshadNumber(int num) {
		
	      if (num < 10) {
	            return num;
	        } else {
	            int lastDigit = num % 10;
	            int remainingDigits = num / 10;
	            return lastDigit + RHarshadNumber(remainingDigits);
	        }
	    }
}

