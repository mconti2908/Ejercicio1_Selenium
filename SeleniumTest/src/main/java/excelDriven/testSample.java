package excelDriven;


import java.io.IOException;
import java.util.ArrayList;

public class testSample {

	
		
		DataDriven dd =new DataDriven();
	
		 
		ArrayList<String> data ;
		
		
		public String getexcel(String a, int b) throws IOException {
			data = dd.getData(a);
			String value = data.get(b);
			return value;
			
		}

	//ArrayList data=	d.getData(String s, String d, String b);
	
	
	
	//System.out.println(data.get(1));
	//System.out.println(data.get(2));
	//System.out.println(data.get(3));
	
	

	}


