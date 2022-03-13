package DataProvide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider2 {
@Test(dataProvider="getData")
public void sampleDataProvide2(String Name,int price) {
	System.out.println(Name+"-----"+price);
	
}
@DataProvider
public Object[][] getData()
{
	Object[][] obj=new Object[6][2];
	obj[0][0]="Mi";
	obj[0][1]=20000;
	
	
	obj[1][0]="samsung";
	obj[1][1]=50000;
	
	
	obj[2][0]="Redmi";
	obj[2][1]=25000;
	
	
	obj[3][0]="Vivi";
	obj[3][1]=25000;
	
	obj[4][0]="Iphone";
	obj[4][1]=60000;
	
	obj[5][0]="micromax";
	obj[5][1]=10000;
	
	return obj;
	
	
	
}

}
