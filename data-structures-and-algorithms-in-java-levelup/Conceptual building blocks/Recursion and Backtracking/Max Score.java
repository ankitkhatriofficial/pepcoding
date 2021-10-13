import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String[] words, int[] farr, int[] score, int idx) {
		if(idx == words.length)
		    return 0;
		
		int score_no = solution(words, farr, score, idx + 1);
		
		/* Checking if this word should be included or not */
		String word = words[idx];
		int word_score = 0;
        boolean flag = true; // this flag will become false if the word should not be included
		for(int i = 0; i < word.length(); i++){
		    char ch = word.charAt(i);
		    if(farr[ch - 'a'] == 0)
		        flag = false;
		    word_score += score[ch - 'a'];
		    farr[ch - 'a']--;
		}
		
		/* Make yes call only if the flag is set to be true */
		int score_yes = 0;
		if(flag == true)
		    score_yes = word_score + solution(words, farr, score, idx + 1);
		
		/* Undoing the steps while back tracking */
		for(int i = 0; i < word.length(); i++){
		    char ch = word.charAt(i);
		    farr[ch - 'a']++;
		}
		
		return Math.max(score_no, score_yes);
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}