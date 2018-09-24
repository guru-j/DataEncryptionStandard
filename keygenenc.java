package Keygenerate;
import java.io.*;
import java.util.*;
import key.*;
public class keygenenc
{
	public String gen(String inp,int round)
	{
	String ans1="",ans2="",ans3="";
	keyhelp k=new keyhelp();
	Scanner in=new Scanner(System.in);
	String binary=k.hexbin(inp);
	System.out.println("\n----Key in Binary : "+binary);
	ans1=k.paritydrop(binary);
	System.out.println("\n-----------------------------------\nKey After Parity Drop Table : "+ans1);
	
	ans2=k.shift(ans1,round);
	System.out.println("\n--------------\nAfter Shifting : "+ans2);
	ans3=k.keycomp(ans2);
	System.out.println("\n\nRound "+round+" key in binary is : "+ans3);
	String ans=k.binhex(ans3);
	System.out.println("\n\nRound "+round+" key in Hexadecimal is : 0x"+ans);
	return ans3;
	}
}