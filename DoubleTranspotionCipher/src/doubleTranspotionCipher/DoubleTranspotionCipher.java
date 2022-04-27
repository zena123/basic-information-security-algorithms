package doubleTranspotionCipher;

import java.util.Scanner;

public class DoubleTranspotionCipher {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("input text");
		String text=sc.nextLine();
		System.out.println(text.length());
		char [] tex= text.toCharArray();
		int []k= new int[100];
		//   note : key starts from 0
		int  cols=0;
		System.out.println("input key values, input ends when -1 ");
		int kk= sc.nextInt();
		while(kk!=-1) {
			k[cols]=kk;
			cols++;
			kk= sc.nextInt();
				}
		int rows=text.length()/cols;
		if(text.length()%cols!=0) {
		rows++;}
		
		
		System.out.println(rows);
		char [][] arr= new char[rows][cols];
		
		int x=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				if(x<text.length()) {
					arr[i][j]=tex[x];
					x++;
				}
				else
					arr[i][j]='x';
			}
		}
		
		
		
		//int col1=0;
		char [][] arr1=new char[rows][cols];
		 String text1="";
		for(int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
				arr1[j][i]= arr[j][k[i]];
				text1+=arr1[j][i];
			}
			}

       
		
		text1=text1.toUpperCase();
		System.out.println(text1);
		char[] second= text1.toCharArray();
		
		int index=0;
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				
				arr1[i][j]=second[index];
				index++;
			}}
		char [][] arr2=new char[rows][cols];
		String text2="";
		for(int i=0;i<cols;i++) {
			for(int j=0;j<rows;j++) {
				arr2[j][i]= arr1[j][k[i]];
				text2+=arr2[j][i];
			}
			}
		System.out.println(text2);
		
		/*
		
		
		
		
		
		
		int col1=0;
		char [][] arr1=new char[rows][col];
		
		for(int i=0;i<col;i++) {
			for(int j=0;j<rows;j++) {
				arr1[j][i]= arr[j][2];
			}
			col1++;}
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<col;j++) {
		
		System.out.print(arr1[i][j]);
		System.out.print(" ");
		
		
			}System.out.println();}*/

	}

}
