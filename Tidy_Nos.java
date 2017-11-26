import java.io.*;
import java.math.BigInteger;

public class Tidy_Nos
{


static void tidy_check(int line,String str)
{
			
			BigInteger num=new BigInteger(str);
			
			int n=1;
			BigInteger temp=num;
			BigInteger one=new BigInteger("1");
				
			
			while(temp.divide(BigInteger.TEN) != BigInteger.ZERO)
			{
			
			n++;
				temp=temp.divide(BigInteger.TEN);
			}
			
			int d[]=new int[n];
			for(int i=n-1;i>=0;i--)
			{
				
				d[i]=Character.getNumericValue(str.charAt(i));
				
								
			}
			
			for(int i=0;i<n-1;i++)
			{
				
					
				if(d[i]<=d[i+1])
				{
					
					continue;
					
				}
				else if(i!=0 && d[i]==d[i-1])
				{   
					
						int t;
						for(t=i;t>=1;t--) 
						{   
							if(d[t]==d[t-1]) 
							{ 
								continue;
							} 
						}
						
							d[t]=d[i]-1;
						for(int r=t+1;r<=n-1;r++)
						{
							d[r]=9;
							i=r;
						}
					
						
					break;
					
				
				}
					
				else
				{	
					d[i]=d[i]-1;
					
					i++;
					for(;i<=n-1;i++)
					{
						d[i]=9;
					}
				}
					
					
			}

try{			
File f=new File("output.txt");
f.createNewFile();
FileWriter fw=new FileWriter(f,true);
String op="";
for(int i=0;i<d.length;i++)
{
	if(d[0]==0 && i==0)
	{
		continue;
	}
	
	op=op+d[i];
}

fw.write("Case #"+line+": "+op);
fw.write(System.getProperty( "line.separator" ));

fw.flush();
}
catch(Exception e)
{
	System.out.println(e);
}
}



	
public static void main(String []args)
{

try
{
	
	FileReader fr=new FileReader("B-large.in");
	BufferedReader br=new BufferedReader(fr);
	
	int input_lines=Integer.parseInt(br.readLine());
	String str=br.readLine();
	int line=0;
	while( !str.equals(null))
	{
		
		line++;
		tidy_check(line,str);
		str=br.readLine();

		
	}


	
}//try
catch(Exception e)
{
	
}

}//main
}//class