/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokey.cipher;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class AutokeyCipher {

     
    public static String alphapet="abcdefghijklmnopqrstuvwxyz";
    public static String AutokeyEncryption(String msg,String key){
    String msgL=msg.toLowerCase();
    String ctext="";
    String Key1=key+msg;
    int val;
    char C;
    for (int i=0;i<msg.length();i++){
        
    int charposition=alphapet.indexOf(msgL.charAt(i));
    int keyi=alphapet.indexOf(Key1.charAt(i));
      val=(charposition+keyi)%26;
      C=alphapet.charAt(val);
       
    ctext+=C;
   
    }
    
    return ctext;
    }
 
     public static String AutokeyDecryption(String msg,String key){
    String msgL=msg.toLowerCase();
    String ctext="";
    String Key1=key;
    int val,keyi;
    char C;
    for (int i=0;i<msg.length();i++){
        
    int charposition=alphapet.indexOf(msgL.charAt(i));
     keyi=alphapet.indexOf(Key1.charAt(i));
      val=(charposition-keyi)%26;
      val = (val<0)? val + 26 : val;
      C=alphapet.charAt(val);
       
    ctext+=C;
    Key1+=C;
   
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
                        String encrypted =AutokeyEncryption(message,key);
                        System.out.println("Encrypted:" + encrypted);
                        break;
                    }
                case 0:
                    //prints decryption
                    String decrypted = AutokeyDecryption(message,key);
                    System.out.println("Decrypted:" + decrypted);
                    break;
                default:
                    System.out.println("Wrong input please Enter 1 or 0");
                    break;
            }
    }
    
    
}
