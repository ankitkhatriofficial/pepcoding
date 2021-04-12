import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        /* Simple Basic Approach Using Stack */
        Stack<Integer> st = new Stack<>();
        while (num > 0) {
            st.push(num % 10);
            num = num / 10;
        }
        while (st.size() > 0) {
            System.out.println(st.pop());
        }

        /* Another approach to solve it */
        /*
           int temp = num; // assigning original num to a temp variable 
	   long reverseNum = 0; // used to find the reverse of a number (long is because it can be maximum range of integer if you reverse the number) 
	   int count_of_zeros = 0; // used to count the number of zeros at the end of original num
         
           while(temp > 0){ 
		int rem = temp % 10; 
		if(rem == 0 && (reverseNum * 10 + rem) == reverseNum){ 
			count_of_zeros++; 
		} 
		reverseNum = (reverseNum * 10) + rem;
          	temp = temp / 10; 
	   } 
	
	   // Printing the reversedNumber in reverse order
           while(reverseNum > 0){ 
		System.out.println(reverseNum % 10); 
		reverseNum = reverseNum / 10; 
	   } 

	   // Printing the zeros in the last 
	   for(int i = 0; i < count_of_zeros; i++){ 
		System.out.println(0); 
	   }
         */
    }
}