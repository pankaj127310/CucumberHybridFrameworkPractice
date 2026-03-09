package utils;

import java.util.Date;

public class Commonutils {
	
	public String GetEmailTimeStamp()
	{
		Date date=new Date();
		return "pankajshirke"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int EXPLICIT_WAIT_TIME=30;
	public static final int PAGE_LOAD_TIME=15;
	

	
}
