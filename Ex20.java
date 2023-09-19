import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex20 {

	public static void main(String[] args) {
		System.out.println(Ex20.flipEndChars("Ayuda"));
		System.out.println(Ex20.dnaToRna("ATTAGCGCGATATACGCGTAC"));
		System.out.println(Ex20.reverse("Hello"));
		System.out.println(Ex20.isInOrder("12ABCabc"));
		System.out.println(Ex20.rev(123456023));
		System.out.println(Ex20.euclidean(49, 14));
		System.out.println(Ex20.highestDigit(377654608));
		System.out.println(Ex20.split("Abaj()45!eo"));
		sortByLength("La casa de sasa es verde");
		int [] numbers = {5,3,2,1,4,6};
		consecutionNumbers(numbers);
		
	}

	/*11 Switcharoo
	 Create a function that takes a string and returns a new string with its first and 
	 last characters swapped, except under two conditions:

If the length of the string is less than two, return "Incompatible.".
If the first and last characters are the same, return "Two's a pair.".
Examples
flipEndChars("Cat, dog, and mouse.") ➞ ".at, dog, and mouseC"

flipEndChars("ada") ➞ "Two's a pair."

flipEndChars("Ada") ➞ "adA"
	 */
	public static String flipEndChars(String s) {

		
		char start = s.charAt(0);
		char end = s.charAt(s.length()-1);
		if(start == end) return "Two's a pair";
		else if (s.length()<2) return " Incompatible";
		else {
			String newWord=s.substring(1, s.length()-1);
			return end + newWord+start;
		}
	}
	
	/*12 Transcribe To mRNA
	 * Transcribe the given DNA strand into corresponding mRNA - a type of RNA, that will be 
	 * formed from DNA after transcription. DNA has the bases A, T, G and C, while RNA converts 
	 * to U, A, C and G respectively.

Examples
dnaToRna("ATTAGCGCGATATACGCGTAC") ➞ "UAAUCGCGCUAUAUGCGCAUG"

dnaToRna("CGATATA") ➞ "GCUAUAU"

dnaToRna("GTCATACGACGTA") ➞ "CAGUAUGCUGCAU"*/
	public static String dnaToRna(String strand) {
		
		return strand.replace("A", "U").replace("T", "A")
				.replace("G", "M").replace("C", "G").replace("M", "C");	
	
	}
	
	/*13 Recursion: Reverse a String
Write a function that reverses a string. Make your function recursive.

Examples
reverse("hello") ➞ "olleh"*/
	
	public static String reverse(String str) {
		
		return reverseA(str, str.length()-1);
	}
	private static String reverseA(String str, int index) {
		if (index <0) return " ";
		return str.charAt(index)+ reverseA(str, index -1);
	}
	
	/*14 Is the String in Order?
Create a function that takes a string and returns true or false, 
depending on whether the characters are in order or not.

Examples
isInOrder("abc") ➞ true

isInOrder("edabit") ➞ false

isInOrder("123") ➞ true

isInOrder("xyzz") ➞ true*/
	 public static boolean isInOrder(String str){
			for (int i = 0; i < str.length()-1; i++) {
				
				if(str.charAt(i)>str.charAt(i+1))return false;
				
			}
			return true;
	  }
	
	
	 /*15 Reverse the Number
Create a function that takes an integer n and reverses it.

Examples
rev(5121) ➞ "1215"

rev(69) ➞ "96"

rev(-122157) ➞ "751221"*/
	 public static String rev(int n) {
		 String nA= Integer.toString(n);
		 return  revA(nA, nA.length()-1);
			
		}
	 private static String revA(String nA, int index) {
		 if(index <0)return "";
		 else {
			 return nA.charAt(index)+revA(nA, index-1);
		 }
	 }
	 
	 /*16 Algorithms II: The Euclidean Algorithm

Ensure that "a" >= "b". If "a" < "b", swap them.
Find the remainder. Divide "a" by "b" and set "r" as the remainder.
Is "r" zero? If so terminate the function and return "b" (the second number).
Set "a" = "b" and "b" = "r" and start the algorithm over again.
*/
	 public static int euclidean(int a, int b) {
			if(a<b) {
				int aux=a;
					a=b;
					b=aux;
			}
			int r=a%b;
			if(r==0) return b;
		
			return euclidean(b, r);
		}
	
	/*17 Highest Digit  ***********************************************************************************
Create a function that takes a number as an argument and returns the highest digit in that number.

Examples
highestDigit(4666) ➞ 6

highestDigit(544) ➞ 5

highestDigit(379) ➞ 9
*/
	  public static int highestDigit(int n) {
		    
		  int result=0;
		  while (n >0) {
			  /*the remainder of dividing n by 10 results in the last number of n
			   Ex: 379/10 remainder=9*/ 
			  int lastNumber=n%10;
			  if(lastNumber > result) result=lastNumber;
			  
			  n /=10;
		  }
		  return result;
	  } 
	 
	 /*18 Split a String Based on Vowels and Consonants******************************************************
Write a function that takes a string, breaks it up and returns it with vowels first, consonants second. For any character that's not a vowel (like special characters or spaces), treat them like consonants.

Examples
split("abcde") ➞ "aebcd"

split("Hello!") ➞ "eoHll!"

split("What's the time?") ➞ "aeieWht's th tm?"*/
	  public static String split(String str) {
		  String vowels = str.replaceAll("(?i)[^aeiou]", "");
		    String consonants = str.replaceAll("(?i)[aeiou\\W\\s]", "");
		    return vowels + consonants;
		}
	 
	 /*19 Sort by length. Create a function that takes a string and returns a string ordered by the length 
	  * of the words. From shortest to longest word. If there are words with the same amount
	  *  of letters, order them alphabetically.*/
	 
	 public static void sortByLength (String textString) {  
		 
		 String words [] = textString.split(" ");
		 
		 String aux="", first="", second="";
		 
		 for (int i = 0; i < words.length; i++) {
			 for (int j = 0; j < words.length; j++) {
				
				 if(words[i].length()>words[j].length()) {
					 aux=words[i];
					 words[i]=words[j];
					 words[j]=aux;
				 }
			}
		} 
		 for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if(words[i].length()==words[j].length()) {
					if(words[i].compareTo(words[j])<0) {
						 aux=words[i];
						 words[i]=words[j];
						 words[j]=aux;
					}
				}
			}
		}
		 for (String word : words) {
			System.out.println(word);
		}
	 
	 }
	 
	 /*20 Create a function that determines whether elements in an array can be re-arranged
	  *  to form a consecutive list of numbers where each number appears exactly once. 
	  *  cons([5, 1, 4, 3, 2]) ➞ true
			Can be re-arranged to form [1, 2, 3, 4, 5]
			
		cons([5, 1, 4, 3, 2, 8]) ➞ false
			
		cons([5, 6, 7, 8, 9, 9]) ➞ false
			9 appears twice*/
	 
	 public static void consecutionNumbers(int [] numbers) {
		 
		int amount = numbers.length, count=0, count2=0, count3=0;
		boolean cont =true, check=false;
		
		while (cont && count3!=amount) {
			count++;
			++count3;
			for (int i = 0; i < numbers.length; i++) {
				if(numbers[i]==count) {
					check=true;
					count2++;	
				}
			}
			
			if(check && count2==1) {
				check=false;
				count2=0;
			}else {
				cont=false;
			}
		}
		if(count3==amount) System.out.println("yes");
		else System.out.println("No");
	 }
}