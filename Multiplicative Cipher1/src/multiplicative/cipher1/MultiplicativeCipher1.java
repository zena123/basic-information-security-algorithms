/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiplicative.cipher1;

import java.util.Scanner;


public class MultiplicativeCipher1 {
 
    public static final String alphapet="abcdefghigklmnopqrstuvwxyz";
     public static int dKey(int key){
        int r1=alphapet.length();
        int r2=key;
        int t1=0;
        int t2=1;
        while(r2>0){
            int q=r1/r2;
            
            int r=r1-q*r2;
            
            r1=r2;
            r2=r;
            int t=t1-q*t2;
            
            t1=t2;
            t2=t;
        }
        if(r1==1)
            return t1;
        else
            return 0;
    }
    public static String multiplicativeCipherEncryption(String msg,int key){
        String cipherText="";
        String plainText=msg.toLowerCase();
        for(int i=0;i<plainText.length();i++){
            int charPosition=alphapet.indexOf(plainText.charAt(i));
            int val=(charPosition*key)%26;
            char cText=alphapet.charAt(val);
            cipherText+=cText;
        }
        return cipherText.toUpperCase();
    }
        public static String multiplicativeCipherDecryption(String msg,int key){
        String plainText="";
        int dKey=dKey(key);
        if(dKey==0){
            System.err.println("Can not Decryption with this key");
            return null;
        }
        String cipherText=msg.toLowerCase();
        for(int i=0;i<cipherText.length();i++){
            int charPosition=alphapet.indexOf(cipherText.charAt(i));
            int val=(charPosition*dKey)%26;
            char cText=alphapet.charAt(val);
            plainText+=cText;
        }
        return plainText;
    }
    
    public static void main(String[] args) {
        
		String message;
		int key;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a message: ");
		message = sc.nextLine();
		
		System.out.println("Enter key: ");
		key = sc.nextInt();
                System.out.println("Enter 1 to encryption or 0 to Decryption");
                int option =sc.nextInt();
            switch (option) {
                case 1:
                    {
                        String encrypted =multiplicativeCipherEncryption(message, key);
                        System.out.println("Encrypted:" + encrypted);
                        break;
                    }
                case 0:
                    //prints decryption
                    String decrypted = multiplicativeCipherDecryption(message, key);
                    System.out.println("Decrypted:" + decrypted);
                    break;
                default:
                    System.out.println("Wrong input please Enter 1 or 0");
                    break;
            }
        }
}
   
    

