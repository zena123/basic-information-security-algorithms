package column.cipher;
import java.util.*;

public class ColumnCipher {

   /* public static void swap(int k,int n,char[][] z,int rows){
         char b;
       
        for (int i=0;i<rows;i++){
            b=z[i][k];
            z[i][k]=z[i][n];
            z[i][n]=b;
            
            
            
            
    }}*/
         
        
        
        
        
        
    
        
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the key");
        String s= sc.nextLine();
        char[]arr=s.toCharArray();
       Arrays.sort(arr);
       String m= String.valueOf(arr);
       System.out.println("Enter the plain text:");
         String plain=sc.nextLine();
        int co=arr.length;
        int row=((co+plain.length())/co);
        if((co+plain.length())%co!=0) {
		row++;}
        System.out.println(co);
        System.out.println(row);
        System.out.println(plain.length());
         char[][]a1=new char[row][co];
         
         for ( int i=0;i<co;i++){
             a1[0][i]=s.charAt(i);
         }  
         
          /*   for(int j=0;j<co;j++){
             System.out.print(a1[0][j]);
             
             
             }*/
         System.out.println();
         int k=0;
        for (int i=1;i<row;i++){
            for(int j=0; j<co;j++)
            {
           if (k<plain.length()){
              a1[i][j]=plain.charAt(k);
              k++;
           } 
           else {
               a1[i][j]='x';
               k++;
           } 
    }}
         /* for (int i=0;i<row;i++) {
             {
                 for(int j=0;j<co;j++)
             System.out.print(a1[i][j]);
          }System.out.println();}
          
        */
        
        char [][] zc=new char[row][co];
            for(int i=0;i<co;i++)
            {
                int g=m.indexOf(a1[0][i]);
                        System.out.println(g);
               if (g!=i)
                    
               {
                   for (int j=0;j<row;j++){
                   /* z=zc[j][g]; 
                    zc[j][g]=zc[j][i];
                    zc[j][i]=z;*/
                   zc[j][i]=a1[j][g];
                   }
                  
                   
                   }
               
         
         
         
        }
            a1=zc;
            String st="";
            System.out.println("The Encryption text is :");
        for (int j=0;j<co;j++){
            
        for (int i=1;i<row;i++){
            
                st+=a1[i][j];
                
               
            }
           
        }
     System.out.print(st.toUpperCase());
     
            
    }}