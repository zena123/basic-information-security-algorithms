/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package affine.cipher;

import java.util.Scanner;

/**
 *
 * @author Marina
 */
public class AffineCipher {

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
       public static String affineCipherEncryption(String msg,int k1,int k2){
            String cipherText="";
            String plaiText=msg.toLowerCase();
            for(int i=0;i<plaiText.length();i++){
                int charPosition=alphapet.indexOf(plaiText.charAt(i));
                int val=(charPosition*k1+k2)%26;
                char cText=alphapet.charAt(val);
                cipherText+=cText;
            }
            return cipherText.toUpperCase();
        }
        public static String affineCipherDecryption(String msg,int k1,int k2){
            String plainText="";
            int dK1=dKey(k1);
            System.out.println(dK1);
            if(dK1==0){
                System.err.println("Can not encrypt with key "+ k1);
                return null;
            }
            String cipherText=msg.toLowerCase();
            for(int i=0;i<cipherText.length();i++){
                int charPosition=alphapet.indexOf(cipherText.charAt(i));
                int val=((charPosition-k2)*dK1)%26;
                if(val<0){
                    int val1=(val*-1)%alphapet.length();
                    val=alphapet.length()-val1;
                }
                char pText=alphapet.charAt(val);
                plainText+=pText;
            }
            return plainText;
        }
    public static void main(String[] args) {
        String message;
		int key1;
                int key2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a message: ");
		message = sc.nextLine();
		
		System.out.println("Enter key1: ");
		key1 = sc.nextInt();
                System.out.println("Enter key2:");
                key2=sc.nextInt();
                System.out.println("Enter 1 to encryption or 0 to Decryption");
                int option =sc.nextInt();
            switch (option) {
                case 1:
                    {
                        String encrypted =affineCipherEncryption(message,key1,key2);
                        System.out.println("Encrypted:" + encrypted);
                        break;
                    }
                case 0:
                    //prints decryption
                    String decrypted = affineCipherDecryption(message,key1,key2);
                    System.out.println("Decrypted:" + decrypted);
                    break;
                default:
                    System.out.println("Wrong input please Enter 1 or 0");
                    break;
            }
    }
    
}
