import java.io.*;
import java.util.*;
import encryption.*;
import Keygenerate.*;
class encrypt
{
	static String nextleft="",nextright="";
	public static void perform(String left,String right,String inpu,int round,int ch)
	{
		String ans="";
		keygenenc k=new keygenenc();
		encrypthelp e=new encrypthelp();
	String righthex=e.binhex(right);
	System.out.println("\nLeft Part    : "+left);
	System.out.println("Right Part : "+right);
	String exp=e.expansion(right);
	System.out.println("\nAfter Expanded Permutation: "+exp);
	
	String key=k.gen(inpu,round);
	
	String xor=e.exor(exp,key);
	System.out.println("\n\n------After Exor with Key : ");
	System.out.println("In Binary : "+xor);
	String hexor=e.binhex(xor);
	System.out.println("In hexadecimal : 0x"+hexor);
	//System.out.println("Hex Xor : "+hexor);
	String sb=e.sbox(xor);
	System.out.println("After using S box : "+sb);
	String pb=e.pbox(sb);
	System.out.println("After using P Box : "+pb);
	ans=e.exor(left,pb);
	String anshex=e.binhex(ans);
	System.out.println("\n\t------------------------<>----------------------------");
	if(round!=16)
	{
	System.out.println("Next Round left in binary : "+right);
	System.out.println("Next Round right in binary: "+ans);
	System.out.println("Next Round left in HexaDecimal : 0x"+righthex);
	System.out.println("Next Round right in HexaDecimal : 0x"+anshex);
	nextleft=right;
	nextright=ans;
	}
	else if(round==16 && ch==1)
	{
	System.out.println("Encrypted left in binary : "+ans);
	System.out.println("Encrypted right in binary: "+right);
	System.out.println("Encrypted left in HexaDecimal : 0x"+anshex);
	System.out.println("Encrypted right in HexaDecimal : 0x"+righthex);
	nextleft=right;
	nextright=ans;
	}
	else if(round==16 && ch==2)
	{
	System.out.println("Decrypted left in binary : "+ans);
	System.out.println("Decrypted right in binary: "+right);
	System.out.println("Decrypted left in HexaDecimal : 0x"+anshex);
	System.out.println("Decrypted right in HexaDecimal : 0x"+righthex);
	nextleft=right;
	nextright=ans;
	}
	}
public static void main(String args[])
{
	encrypthelp e=new encrypthelp();
	keygen k=new keygen();
	Scanner in=new Scanner(System.in);
	System.out.println("Choose \n \t1.Encryption\n\t2.Decryption");
	int ch=in.nextInt();
	in.nextLine();
	if(ch==1)
		System.out.println("Enter plaintext in hexadecimal : ");
	else if(ch==2)
		System.out.println("Enter ciphertext in hexadecimal : ");
	String inp=in.nextLine();
	System.out.println("Enter key in Hexadecimal : ");
	String inpu=in.nextLine();
	System.out.println("Enter number of round to perform : ");
	int round=in.nextInt();
	inpu=inpu.toUpperCase();
	
	String left="",right="";
	String binary=e.hexbin(inp);
	System.out.println("\nGiven Message in Binary : "+binary);
	String initial=e.initperm(binary);
	System.out.println("\n\n------After Initial Permutation: ");
	System.out.println("In Binary : "+initial);
	String temp=e.binhex(initial);
	System.out.println("In Hexadecimal : 0x"+temp);
	for(int i=0;i<32;i++)
		left+=initial.charAt(i);
	for(int i=32;i<64;i++)
		right+=initial.charAt(i);
	if(ch==1){
		for(int i=1;i<=round;i++)
		{
			System.out.println("\n\n\n\n\t************************ROUND "+i+"*********************** ");
			perform(left,right,inpu,i);
			left=nextleft;
			right=nextright;
		}
		if(round==16){
		String efinal=right+left;
		String cipher=e.finalperm(efinal);
		String cipherhex=e.binhex(cipher);
		System.out.println("\n\nCipher Text After Final Permutation is : ");
		System.out.println("In Binary : "+cipher);
		System.out.println("In Hexadecimal : 0x"+cipherhex);
		}
	}
	else if(ch==2)
	{
		/*for(int i=1;i<=16;i++)
		{
			System.out.println("\n\n\n\n\t************************ROUND "+i+"*********************** ");
			perform(left,right,inpu,i);
			left=nextleft;
			right=nextright;
		}
		String efinal=left+right;
		String cipher=e.finalperm(efinal);
		String cipherhex=e.binhex(cipher);
		System.out.println("\n\nCipher Text After Final Permutation is : ");
		System.out.println("In Binary : "+cipher);
		System.out.println("In Hexadecimal : 0x"+cipherhex);
		System.out.println("\n\n\n\n\n\t\t------------------------->Encryption is Over<-------------------------");
		
		String initial2=e.initperm(cipher);
	System.out.println("\n\n------After Initial Permutation: ");
	System.out.println("In Binary : "+initial2);
	String temp2=e.binhex(initial);
	System.out.println("In Hexadecimal : 0x"+temp2);
	for(int i=0;i<32;i++)
		left+=initial2.charAt(i);
	for(int i=32;i<64;i++)
		right+=initial2.charAt(i);  */
		
		int i=16;
		for(int j=0;j<round;j++)
		{
			System.out.println("\n\n\n\n\t************************ROUND "+i+"*********************** ");
			perform(left,right,inpu,i,ch);
			left=nextleft;
			right=nextright;
			i-=1;
		}
		if(round==16){
		String dfinal=right+left;
		String plaintext=e.finalperm(dfinal);
		String phex=e.binhex(plaintext);
		System.out.println("\n\nPlaintext after final Permutation is : ");
		System.out.println("In Binary : "+plaintext);
		System.out.println("In Hexadecimal : 0x"+phex);
		}
	}
}
}