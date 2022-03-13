package DataProvide;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {
@Test(dataProvider = "getData")
public void sampleDataProvider(String Name,String Model,int qty)
{
	System.out.println(Name+ "----"+Model+"-----"+qty);
}
@DataProvider
public Object[][] getData()
{
	Object[][] obj=new Object[4][3];
	
	obj[0][0]="Mi";
	obj[0][1]="13 pro max";
	obj[0][2]=25;
	
	obj[1][0]="samsung";
	obj[1][1]="17 max";
	obj[1][2]=12;
	
	obj[2][0]="Redmi";
	obj[2][1]="Note 15";
	obj[2][2]=40;
	
	obj[3][0]="Oneplus";
	obj[3][1]="A12";
	obj[3][2]=20;
	
	return obj;
	
}
}
