/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viginere.cipher;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class ViginereCipher {
    
    public static String alphapet="abcdefghijklmnopqrstuvwxyz";
    public static String viginereEncryption(String msg,String key){
    String msgL=msg.toLowerCase();
    String ctext="";
    int j=0;
    for (int i=0;i<msg.length();i++){
    if(j>key.length()-1)
        j=0;
   
    int charposition=alphapet.indexOf(msgL.charAt(i));
    int keyi=alphapet.indexOf(key.charAt(j));
    int val=(charposition+keyi)%26;
    char C=alphapet.charAt(val);
    j++;
    ctext+=C;
    
    }
    
    return ctext.toUpperCase();
    }
    
  public static String viginereDecryption(String msg,String key){
    String msgL=msg.toLowerCase();
    
    String ctext="";
    int j=0;
    for (int i=0;i<msg.length();i++){
    if(j>key.length()-1)
        j=0;
    
    int charposition=alphap et.indexOf(msgL.charAt(i));
    int keyi=alphapet.indexOf(key.charAt(j));
    int val=(charposition-keyi)%26;
    char C=alphapet.charAt(val);
    j++;
    ctext+=C;
    
    }
    
    return ctext;
    }
  
    public static void main(String[] args) {
               String message;
               String key;
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a message: ");
		message = sc.nextLine();
		
		System.out.println("Enter key : ");
		key = sc.nextLine();
                System.out.println("Enter 1 to encryption or 0 to Decryption");
                int option =sc.nextInt();
            switch (option) {
                case 1:
                    {
                        String encrypted =viginereEncryption(message,key);
                        System.out.println("Encrypted:" + encrypted);
                        break;
                    }
                case 0:
                    //prints decryption
                    String decrypted = viginereDecryption(message,key);
                    System.out.println("Decrypted:" + decrypted);
                    break;
                default:
                    System.out.println("Wrong input please Enter 1 or 0");
                    break;
            }
    }
    
    
}
