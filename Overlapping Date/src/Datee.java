import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

public class Datee {	


	public static void main(String[] args) throws ParseException
	{
		boolean ovelap=false;
		Integer index=null;
		Date StartDate = null,EndDate = null;
		Date Initailstsrat = null,InitialEnd = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<String> al = new ArrayList<>();
		al.add("01-09-2017");
		al.add("05-10-2017");
		al.add("04-10-2017");
		al.add("08-10-2017");
		al.add("12-12-2017");
		al.add("18-12-2017");
		
		/*HashMap<String, String> hm = new HashMap<String,String>();		
		hm.put("01-09-2017"," 05-10-2017");
		hm.put("04-10-2017"," 08-10-2017");
		hm.put("12-12-2017"," 18-12-2017");
		Iterator<String> itkey = hm.keySet().iterator();
		Iterator<String> itvalue = hm.values().iterator();		
		while(itkey.hasNext())
		{
			int indexx=0;
			StartDate = sdf.parse(itkey.next());
			al.add(indexx, StartDate);	
			indexx=indexx+2;
		}
		while(itvalue.hasNext())
		{
			int index2=1;
			EndDate = sdf.parse(itvalue.next());
			al.add(index2,EndDate);
			index2+=2;
		}		*/
		
		for(int i=0;i<al.size();i++)
		{
			if(i==0)
			{
				Initailstsrat = sdf.parse(al.get(0));	
			}
			else if(i==1)
			{
				InitialEnd=sdf.parse(al.get(1));
			}
			else if(i%2==0)
			{
				Date abcd = sdf.parse(al.get(i));
				if(abcd.after(Initailstsrat)&&abcd.before(InitialEnd))
				{
					ovelap=true;
					index=i;
				}
			}
			
		}
		for(int j=0;j<=index+1;j++)
		{
			System.out.println(al.get(j)); 
		}
	

	}

}
