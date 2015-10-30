package com;

import java.util.Scanner;
import java.util.Stack;

/**
 * 
 * @author msheikh2
 * This program tries to make Palindromes out of strings using insertion
 * Main Class has a driver method main() and
 * two other methods for processing strings
 */

public class Main {

	/**
	 * 
	 * @param args
	 * 1.Enter a string
	 * 2.A check is performed to see if its already a palindrome using method checkPalindrome()
	 * 3.If its not then method convertToPalindrome() is called
	 * 4.Prints the result
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main mainObj=new Main();
		String palMain="";
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the string to be made into Palindrome:");
		palMain=scan.next();
		System.out.println("you entered:"+palMain);
		if(mainObj.checkPalindrome(palMain.toLowerCase()))
		{
			System.out.println("Already Palindrome");
		}
		else
		{
			char result[]=mainObj.convertToPalindrome(palMain);
			int k=0;

			System.out.println("Palindromic rendering of the original string is:\n");
			while(k<result.length)
			{
				System.out.print(result[k]);
				k++;
			}

		}
		scan.close();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 * Takes in a String as a parameter
	 * returns true if its already a Palindrome
	 */
	private boolean checkPalindrome(String str)
	{
		char [] strArr=str.toCharArray();
		int i=0,j=str.length()-1;
		boolean var=false;
		if(str.length()%2!=0)
		{
			while(i!=j)
			{
				if(strArr[i]==strArr[j])
				{
					var=true;
					i++;
					j--;
				}
				else
				{
					var=false;
					break;
				}
				
			}
		}
		return var;
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 * Takes in the string as a parameter
	 * determines how many insertions to make it Palindromic
	 * then makes that change and returns a char[]
	 */
	private char[] convertToPalindrome(String str)
	{
		Stack<Character> charStack=new Stack<Character>();
		char[] strArr=str.toCharArray();
		int i=0,j=str.length()-1,count=0,k=0;
		while(strArr[i]!=strArr[j])
		{
			charStack.push(strArr[i]);
			i++;
		}
		count=i;
		
		System.out.println("So you need "+i+" insertions to make this string palindrome");
		char[] palStrArr=new char[str.length()+count];
		while(k<str.length())
		{
			palStrArr[k]=strArr[k];
			k++;
		}
		j=str.length();
		while(j<palStrArr.length)
		{
			palStrArr[j]=charStack.pop();
			j++;
		}
		
		return palStrArr;
		
	}

}

