package com.jw.faye.finance.stock.dataRetrieval;
import java.net.*;
import java.text.DateFormat;
import java.util.*;
import java.io.*;
import com.google.gson.Gson; 

public class GoogleStockDataRetrieval {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		while(true){
			URL oracle = new URL("http://finance.google.com/finance/info?client=ig&q=NASDAQ:GOOG");
	        URLConnection yc = oracle.openConnection();
	        
	
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    yc.getInputStream()));
	        String inputLine;
	        StringBuffer totalOutputBuffer = new StringBuffer();
	        String totalOutput = "";
	        
	        while ((inputLine = in.readLine()) != null) {
	        	totalOutputBuffer.append(inputLine);
	            //System.out.println(input"Line);
	        }
	        
	        totalOutput = totalOutputBuffer.substring(2);
	        //System.out.print(totalOutput+"\n");
	        in.close();
	        
	        Gson gson = new Gson();
	        
	        GoogleStockDataObject[] stockObj = gson.fromJson(totalOutput, GoogleStockDataObject[].class);
	        System.out.print("Current Time is : "+getFormattedCurrentTime()+
	                "		Stock Market-"+stockObj[0].getE()+
	        		"		Stock Code-"+stockObj[0].getT()+
	        		"		Current Price-"+stockObj[0].getL()+
	        		"		Last Trade Time-"+stockObj[0].getLtt()+"\n");
	        Thread.currentThread().sleep(2000);
		}
    }
	
	public static String getStockDataForSpecificCompany(String marketName,String companyName){
		
		String resultString = "";
		
		try{
			URL oracle = new URL("http://finance.google.com/finance/info?client=ig&q=NASDAQ:GOOG");
	        URLConnection yc = oracle.openConnection();
	        
	
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                    yc.getInputStream()));
	        String inputLine;
	        StringBuffer totalOutputBuffer = new StringBuffer();
	        String totalOutput = "";
	        
	        while ((inputLine = in.readLine()) != null) {
	        	totalOutputBuffer.append(inputLine);
	            //System.out.println(input"Line);
	        }
	        
	        totalOutput = totalOutputBuffer.substring(2);
	        //System.out.print(totalOutput+"\n");
	        in.close();
	        
	        resultString = totalOutput;
	        /*
	        Gson gson = new Gson();
	        
	        GoogleStockDataObject[] stockObj = gson.fromJson(totalOutput, GoogleStockDataObject[].class);
	        System.out.print("Current Time is : "+getFormattedCurrentTime()+
	                "		Stock Market-"+stockObj[0].getE()+
	        		"		Stock Code-"+stockObj[0].getT()+
	        		"		Current Price-"+stockObj[0].getL()+
	        		"		Last Trade Time-"+stockObj[0].getLtt()+"\n");
	        		*/
		}
		catch(Exception e){
			
		}
		
		return resultString;
		
	}
	
	
	public static String getFormattedCurrentTime(){
		String formattedTimeString;
		
		//Calendar cal1 = new GregorianCalendar();
		
		Date date = new Date();
		
		formattedTimeString = DateFormat.getDateTimeInstance(
	            DateFormat.SHORT, DateFormat.SHORT).format(date);
		
		//SimpleDateFormat date_format = new SimpleDateFormat("yyyyMMdd ");
		
		return formattedTimeString;
	}
	
}

