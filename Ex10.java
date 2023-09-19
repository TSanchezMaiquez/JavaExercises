import java.util.HashMap;
import java.util.Map;

public class Ex10 {
	
	public static void main (String args []) {

		int [] numbers = {2, 8, 6, 5, 7,5};
		System.out.print("Suma pares, suma impares y devuelve la difenrencia: ");
		System.out.println(Ex10.warOfNumbers(numbers));
		
		System.out.print("Metodo recursivo que suma los numeros de un array: ");
		System.out.println(Ex10.sum(numbers));
		
		int [][] numbers2 = Ex10.squarePatch(5);
		
		for (int i = 0; i < numbers2.length; i++) {
			for (int j = 0; j < numbers2.length; j++) {
				System.out.print(numbers2[i][j]);
			}
			System.out.println();
		}
		
		char [][] char2 = {
				{'D', 'E', 'Y', 'H', 'A', 'D'},
				{'C', 'B', 'Z', 'Y', 'J', 'K'},
				{'D', 'B', 'C', 'A', 'M', 'N'},
				{'F', 'G', 'G', 'R', 'S', 'R'},
				{'V', 'X', 'H', 'A', 'S', 'S'}
			};
		System.out.println(Ex10.letterCounter(char2, 'D'));
		
		
		System.out.println("Cuenta cuantos números tiene. "+ Ex10.count(+612834));
		
		
		Map<String, String> map1 = new HashMap<>();
        map1.put("a", "1");
        map1.put("b", "2");
        map1.put("c", "3");
		
		String [] values = Ex10.getValues(map1);
		for (String value : values) {
			System.out.println(value);
		}
		
		System.out.println("Suma: 5+1, 1+1, 2+1. Resultado: "+Ex10.add("512", "111"));
		
		System.out.println("numero pasado corresponde a los lados de un cuadrado. \n"
		+"Se devuelve el numero de espacios que no son ocupados por las diagonales: "+ Ex10.emptySq(6));
	
		System.out.println("Busca los divisores del numero pasado y los suma.Si la suma es igual al numero pasado devuelve true. "+Ex10.checkPerfect(97));
	
		System.out.println("Se pasan dos notas: la del examen y la de corte, para comprobar si ha aprobado o no. "+Ex10.gradePercentage("65%", "85%"));
		
		
	}
	
	/*Create a function that takes an array of integers, sums the even and odd numbers separately, 
	 * then returns the difference between the sum of the even and odd numbers.
	 Examples
	 warOfNumbers([2, 8, 7, 5]) ➞ 2
	// 2 + 8 = 10
	// 7 + 5 = 12*/
	  public static int warOfNumbers(int[]numbers){
			int par=0;
			int impar=0;
			int result=0;
		  for (int i = 0; i < numbers.length; i++) {
			if(numbers[i]%2==0) {
				par+=numbers[i];
			}else {
				impar+=numbers[i];
			}
		}
		  if (par>impar) {
			  return result=par-impar;
		  }
		  else {
			  return result=impar-par;
		  }
	  }
	
	/*Create a function that takes an integer and outputs an n x n square solely consisting of the integer n.

Examples
squarePatch(3) ➞ [
  [3, 3, 3],
  [3, 3, 3],
  [3, 3, 3]
]*/
		public static int[][] squarePatch(int n) {
			
			
			int [][] number = new int [n][n];
			for (int i = 0; i < number.length; i++) {
				for (int j = 0; j < number.length; j++) {
					number[i][j]=n;
				}
			}
			return number;
		}
	
		
	
	/*Write a function that finds the sum of an array. Make your function recursive.
Examples
sum([1, 2, 3, 4]) ➞ 10

sum([1, 2]) ➞ 3

sum([1]) ➞ 1

sum([]) ➞ 0*/
		
		public static int sum(int[] arr) {
			
			
				return sumRec(arr, 0);
			
			
			}
		
		private static int sumRec(int [] arr, int index) {
			if(index>=arr.length) {
				return 0;
			}
				return arr[index]+ sumRec(arr, index+1);
			
		}
		/*Create a function that counts the number of times a particular letter shows up in the word search.

		Examples
		letterCounter([
		  ["D", "E", "Y", "H", "A", "D"],
		  ["C", "B", "Z", "Y", "J", "K"],
		  ["D", "B", "C", "A", "M", "N"],
		  ["F", "G", "G", "R", "S", "R"],
		  ["V", "X", "H", "A", "S", "S"]
		], "D") ➞ 3*/
		
		public static String letterCounter(char[][] arr, char c) {
			int count=0;
			int count2=0;
			int i2=0;
			String result= "";
			for (int i = 0; i < arr.length; i++) {
				i2=i;
				for (int j = 0; j < arr[0].length; j++) {
					if(arr[i][j]==c) {
						count++;
						count2++;
						
					}
				}
				if(count!=0) {
					result+=count+" veces en la línea "+(i2+1)+".\n";
				}
				count=0;
				i2=0;
			}
			return "El caracter "+ c+" ha aparecido "+ count2 + " veces: \n"+ result;
		}
	
	/*Create a function that counts the integer's number of digits.

Examples
count(4666) ➞ 4

count(544) ➞ 3*/
		
		public static int count(int n) {
			
			String num = Integer.toString(n);
			num = num.replace("[^0-9]", "");
			
			int number = num.length();
			
			return number;
			
		}
	
/*Create a method that takes a Map<String, String> and return the values as a separate array. 
 * Return the keys sorted alphabetically, and their corresponding values in the same order.

Examples
getValues({ "a": "1", "b": "2", "c": "3" } )
➞ ["1", "2", "3"]

getValues({ "a": "Apple", "b": "Microsoft", "c": "Google" })
➞ ["Apple", "Microsoft", "Google"]*/
		
		public static String[] getValues(Map<String,String> dict) {
			
			String [] values = new String [dict.size()];
			int index=0;
			
			for (String value : dict.values()) {
			values[index]=value;
			index++;
			}
			return values;
		}	

/*Create a function that takes two number strings and returns their sum as a string.

Examples
add("111", "111") ➞ 1+1, 1+1, 1+1 "222"

add("10", "80") ➞ 1+8, 0+0 "90"

add("", "20") ➞ "Invalid Operation"
Notes
Return "Invalid Operation" If either input is "" or null.*/
		
		public static String add(String a, String b) {
			
			int sum =0;
			String result= "";
			for (int i = 0; i < a.length(); i++) {
				sum = Character.getNumericValue(a.charAt(i))+ Character.getNumericValue(b.charAt(i));
				result+=sum+"";
			}
			return result;
		}
		
		/*In the image below, squares are either empty or filled with a circle.

Steps vs Empty Squarest

Create a function that takes a number step (which equals HALF the width of a square) and returns the amount of empty squares. The image shows the squares with step 1, 2 and 3. The return value is the number of cells not on a diagonal, which is 0 for the first square, 8 for the second, and 24 for the third.

xx      x    x		6*6=36
xx		 x	x		x=12 " "=24
		  xx
		  xx
		 x  x
		x    x
	         
Examples
emptySq(1) ➞ 0

emptySq(3) ➞ 24*/
		public static int emptySq(int step) {
			int x=step*2;
			return (step*step)-x;
		  }	
		
		/*Create a function that tests whether or not an integer is a perfect number. A perfect number is a number that can be written as the sum of its factors, (equal to sum of its proper divisors) excluding the number itself.

For example, 6 is a perfect number, since 1 + 2 + 3 = 6, where 1, 2, and 3 are all factors of 6. Similarly, 28 is a perfect number, since 1 + 2 + 4 + 7 + 14 = 28.

Examples
checkPerfect(6) ➞ true

checkPerfect(28) ➞ true*/
		public static boolean checkPerfect(int num) {
			int sum=0;
			for (int i = 1; i <=num/2; i++) {
				if(num%i==0) sum+=i;
			}
			if(sum==num)return true;
			else return false;
		}
		
		/*First parameter is the user's score.
Second parameter is the required score.
Examples
grade_percentage("85%", "85%") ➞ "You PASSED the Exam"

grade_percentage("99%", "85%") ➞ "You PASSED the Exam"

grade_percentage("65%", "90%") ➞ "You FAILED the Exam"*/
		public static String gradePercentage(String userScore, String passScore){
		
			int userScore1 = Integer.parseInt((String) userScore.subSequence(0, 1));
			int passScore1 = Integer.parseInt((String) passScore.subSequence(0, 1));
			
			if(userScore1>=passScore1) return "Has aprobado";
			else return "Has suspendido";
			
				}
}
