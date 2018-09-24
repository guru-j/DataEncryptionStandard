package key;
import java.io.*;
import java.util.*;
public class keyhelp
{
	public String hexbin(String h)
	{
		String ans="";
		for(int i=0;i<h.length();i++)
		{
			if(h.charAt(i)=='A')
				ans+="1010";
			else if(h.charAt(i)=='B')
				ans+="1011";
			else if(h.charAt(i)=='C')
				ans+="1100";
			else if(h.charAt(i)=='D')
				ans+="1101";
			else if(h.charAt(i)=='E')
				ans+="1110";
			else if(h.charAt(i)=='F')
				ans+="1111";
			else if(h.charAt(i)=='0')
				ans+="0000";
			else if(h.charAt(i)=='1')
				ans+="0001";
			else if(h.charAt(i)=='2')
				ans+="0010";
			else if(h.charAt(i)=='3')
				ans+="0011";
			else if(h.charAt(i)=='4')
				ans+="0100";
			else if(h.charAt(i)=='5')
				ans+="0101";
			else if(h.charAt(i)=='6')
				ans+="0110";
			else if(h.charAt(i)=='7')
				ans+="0111";
			else if(h.charAt(i)=='8')
				ans+="1000";
			else if(h.charAt(i)=='9')
				ans+="1001";
		}
		return ans;
	}
	public String binhex(String b)
	{
		String ans="";
		//System.out.println(b);
		for(int i=0;i<b.length();i=i+4)
		{
			int t=i+4;
			String temp=b.substring(i,t);
			//System.out.println(temp);
			if(temp.equals("0001"))
				ans+="1";
			else if(temp.equals("0010"))
				ans+="2";
			else if(temp.equals("0011"))
				ans+="3";
			else if(temp.equals("0100"))
				ans+="4";
			else if(temp.equals("0101"))
				ans+="5";
			else if(temp.equals("0110"))
				ans+="6";
			else if(temp.equals("0111"))
				ans+="7";
			else if(temp.equals("1000"))
				ans+="8";
			else if(temp.equals("1001"))
				ans+="9";
			else if(temp.equals("1010"))
				ans+="A";
			else if(temp.equals("1011"))
				ans+="B";
			else if(temp.equals("1100"))
				ans+="C";
			else if(temp.equals("1101"))
				ans+="D";
			else if(temp.equals("1110"))
				ans+="E";
			else if(temp.equals("1111"))
				ans+="F";
			else if(temp.equals("0000"))
				ans+="0";
		}
		return ans;
	}
	public String paritydrop(String key)
	{
	String ans="";
	ans+=key.charAt(56);
	ans+=key.charAt(48);
	ans+=key.charAt(40);
	ans+=key.charAt(32);
	ans+=key.charAt(24);
	ans+=key.charAt(16);
	ans+=key.charAt(8);
	ans+=key.charAt(0);
	ans+=key.charAt(57);
	ans+=key.charAt(49);
	ans+=key.charAt(41);
	ans+=key.charAt(33);
	ans+=key.charAt(25);
	ans+=key.charAt(17);
	ans+=key.charAt(9);
	ans+=key.charAt(1);
	ans+=key.charAt(58);
	ans+=key.charAt(50);
	ans+=key.charAt(42);
	ans+=key.charAt(34);
	ans+=key.charAt(26);
	ans+=key.charAt(18);
	ans+=key.charAt(10);
	ans+=key.charAt(2);
	ans+=key.charAt(59);
	ans+=key.charAt(51);
	ans+=key.charAt(43);
	ans+=key.charAt(35);
	ans+=key.charAt(62);
	ans+=key.charAt(54);
	ans+=key.charAt(46);
	ans+=key.charAt(38);
	ans+=key.charAt(30);
	ans+=key.charAt(22);
	ans+=key.charAt(14);
	ans+=key.charAt(6);
	ans+=key.charAt(61);
	ans+=key.charAt(53);
	ans+=key.charAt(45);
	ans+=key.charAt(37);
	ans+=key.charAt(29);
	ans+=key.charAt(21);
	ans+=key.charAt(13);
	ans+=key.charAt(5);
	ans+=key.charAt(60);
	ans+=key.charAt(52);
	ans+=key.charAt(44);
	ans+=key.charAt(36);
	ans+=key.charAt(28);
	ans+=key.charAt(20);
	ans+=key.charAt(12);
	ans+=key.charAt(4);
	ans+=key.charAt(27);
	ans+=key.charAt(19);
	ans+=key.charAt(11);
	ans+=key.charAt(3);
	return ans;

	}
	public String shift(String p,int round)
	{
	String left="",right="",ans="";
	int bits=0;
	for(int i=0;i<28;i++)
		left+=p.charAt(i);
	for(int i=28;i<56;i++)
		right+=p.charAt(i);
	for(int i=1;i<=16;i++)
	{
	if(i==1 || i==2 || i==9 || i==16)
		bits+=1;
	else
		bits+=2;
	if(round==i)
		break;
	}
	System.out.println("\n\tNo.of.Bits to be shitfted : "+bits);
	String cpyleft=left;
	String cpyright=right;
	ans=cpyleft.substring(bits);
	for(int i=0;i<bits;i++)
		ans+=left.charAt(i);
	ans+=cpyright.substring(bits);
	for(int i=0;i<bits;i++)
		ans+=right.charAt(i);
	return ans;
	}
	public String keycomp(String key)
	{
	String ans="";
	ans+=key.charAt(13);
	ans+=key.charAt(16);
	ans+=key.charAt(10);
	ans+=key.charAt(23);
	ans+=key.charAt(0);
	ans+=key.charAt(4);
	ans+=key.charAt(2);
	ans+=key.charAt(27);
	ans+=key.charAt(14);
	ans+=key.charAt(5);
	ans+=key.charAt(20);
	ans+=key.charAt(9);
	ans+=key.charAt(22);
	ans+=key.charAt(18);
	ans+=key.charAt(11);
	ans+=key.charAt(3);
	ans+=key.charAt(25);
	ans+=key.charAt(7);
	ans+=key.charAt(15);
	ans+=key.charAt(6);
	ans+=key.charAt(26);
	ans+=key.charAt(19);
	ans+=key.charAt(12);
	ans+=key.charAt(1);
	ans+=key.charAt(40);
	ans+=key.charAt(51);
	ans+=key.charAt(30);
	ans+=key.charAt(36);
	ans+=key.charAt(46);
	ans+=key.charAt(54);
	ans+=key.charAt(29);
	ans+=key.charAt(39);
	ans+=key.charAt(50);
	ans+=key.charAt(44);
	ans+=key.charAt(32);
	ans+=key.charAt(47);
	ans+=key.charAt(43);
	ans+=key.charAt(48);
	ans+=key.charAt(38);
	ans+=key.charAt(55);
	ans+=key.charAt(33);
	ans+=key.charAt(52);
	ans+=key.charAt(45);
	ans+=key.charAt(41);
	ans+=key.charAt(49);
	ans+=key.charAt(35);
	ans+=key.charAt(28);
	ans+=key.charAt(31);

	return ans;
	}
}