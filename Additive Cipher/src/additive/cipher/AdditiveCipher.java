/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package additive.cipher;

import java.util.Scanner;
public class AdditiveCipher {
     public static  String alphapet="abcdefghigklmnopqrstuvwxyz";
     public static String caesarCipherEncryption(String msg,int key){
        String cipherText="";
        String plainText=msg.toLowerCase();
        for(int i=0;i<plainText.length();i++){
            int charPosition=alphapet.indexOf(plainText.charAt(i));
            int val=(key+charPosition)%26;
            char vChip=alphapet.charAt(val);
            cipherText+=vChip;
        }
        return cipherText.toUpperCase();
    }
    public static String decryptionCaesarCipher(String cipherText,int k){
        String plainText="";
        String encryptedText=cipherText.toLowerCase();
        for(int i=0;i<encryptedText.length();i++){
            int charPosition=alphapet.indexOf(encryptedText.charAt(i));
            int val=(charPosition-k)%26;
            if(val<0){
                val=alphapet.length()+val;
            }
            char pText=alphapet.charAt(val);
            plainText+=pText;
        }
        return plainText;
    }
	public static void main(String[] args) 
	{      
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
                        String encrypted =caesarCipherEncryption(message, key);
                        System.out.println("Encrypted:" + encrypted);
                        break;
                    }
                case 0:
                    //prints decryption
                    String decrypted = decryptionCaesarCipher(message, key);
                    System.out.println("Decrypted:" + decrypted);
                    break;
                default:
                    System.out.println("Wrong input please Enter 1 or 0");
                    break;
            }
        }
}
