package com;

import java.util.Scanner;
import java.util.Stack;

public class EPMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EPMain mainObj=new EPMain();
		String palMain="";
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the stringto be made into Palindrome:");
		palMain=scan.next();
		System.out.println("you entered:"+palMain);
		if(mainObj.checkPalindrome(palMain))
		{
			System.out.println("Already Palindrome");
		}
		else
		{
			mainObj.convert2Palindrome(palMain);
		}
		
	}
	
	public boolean checkPalindrome(String str)
	{
		char [] strArr=str.toCharArray();
		int i=0,j=str.length()-1;
		boolean var=false;
//		System.out.println(str.length());
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
	
	public void convert2Palindrome(String str)
	{
		Stack<Character> charStack=new Stack<Character>();
		char[] strArr=str.toCharArray();
		int i=0,j=str.length()-1,count=0,k=0;
		while(strArr[i]!=strArr[j])
		{
			i++;
		}
		count=i;
		
		System.out.println("So you need "+i+" insertions to make this string palindrome");
		char[] palStrArr=new char[str.length()+count];
		i=0;
		while(i<count)
		{
			charStack.push(strArr[i]);
			i++;
		}
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
		
		System.out.println("Palindromic rendering of the original string is:\n");
		k=0;
		while(k<palStrArr.length)
		{
			System.out.print(palStrArr[k]);
			k++;
		}
	}

}
