package restaurant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class data {
	static ArrayList<Store> data = new ArrayList<Store>();
	static ArrayList<Store> data_2 = new ArrayList<Store>();
	static ArrayList<Store> data_3 = new ArrayList<Store>();
	static ArrayList<Store> data_4 = new ArrayList<Store>();

	public static void main(String arg[])
	{	

	}
	
	//從List中random出一家餐廳
	public static void Random(String filePath)
	{
		int answer=0;
		answer=(int) (Math.random()*data_2.size());  //0~0.999
		answer=answer+1;
		File file=new File(filePath);
	    try 
	    {
	    	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            for(int i=1;i<answer;i++)
            	buffer=bufferedReader.readLine();  
            Store store=new Store();
            buffer=bufferedReader.readLine();
            store.setStoreName(buffer.split("\\|")[0]);
    		store.setArea(buffer.split("\\|")[1]);
    		store.setPrice(buffer.split("\\|")[2]);
    		store.setTaste(buffer.split("\\|")[3]);
    		store.setFavorite(buffer.split("\\|")[4]);
    		data_3.add(store);
            inputStream.close(); 
            
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	//把資料存進arraylist
	public static void store_add(String filePath,String target,int judgement)
	{
		File file=new File(filePath);
		int set=0;
		int count=0;
		set=data_2.size();
		data_2.clear(); 
		try 
	    {
		  	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            for(int i=0;i<set;i++)
            {
            	Store store=new Store();
            	buffer=bufferedReader.readLine();
            	if(buffer.split("\\|")[0].equals("沒有符合的資料唷"))
            		break;
            	if(buffer.split("\\|")[judgement].equals(target))
            	{
            		store.setStoreName(buffer.split("\\|")[0]);
            		store.setArea(buffer.split("\\|")[1]);
            		store.setPrice(buffer.split("\\|")[2]);
            		store.setTaste(buffer.split("\\|")[3]);
            		store.setFavorite(buffer.split("\\|")[4]);
            		data_2.add(store);
            		count=1;
            	}
            }
            if(count==0)
            {
            	Store store=new Store();
        		store.setStoreName("沒有符合的資料唷");
        		store.setArea(".");
        		store.setPrice(".");
        		store.setTaste(".");
        		store.setFavorite(".");
        		data_2.add(store);
            }
            inputStream.close();        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	//地區選擇
	public static void checkArea(String filePath,String target)
	{
        store_add(filePath,target,1);
	}
	
	//價位選擇
	public static void checkPrice(String filePath,String target)
	{
		File file=new File(filePath);
		int set=0,count=0;
		set=data_2.size();
		data_2.clear();
		try 
	    {
		  	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            for(int i=0;i<set;i++)
            {
            	Store store=new Store();
            	buffer=bufferedReader.readLine();
            	if(buffer.split("\\|")[0].equals("沒有符合的資料唷"))
            		break;
            	int money=Integer.parseInt(buffer.split("\\|")[2]);
            	if(target.equals("1"))       //100以下
        		{
            		if(money<100)
                	{
                		store.setStoreName(buffer.split("\\|")[0]);
                		store.setArea(buffer.split("\\|")[1]);
                		store.setPrice(buffer.split("\\|")[2]);
                		store.setTaste(buffer.split("\\|")[3]);
                		store.setFavorite(buffer.split("\\|")[4]);
                		data_2.add(store);
                		count=1;
                	}
        		}
        		else if(target.equals("2"))  //100~200
        		{
        			if((money>100&&money<200)||money==100)
                	{
                		store.setStoreName(buffer.split("\\|")[0]);
                		store.setArea(buffer.split("\\|")[1]);
                		store.setPrice(buffer.split("\\|")[2]);
                		store.setTaste(buffer.split("\\|")[3]);
                		store.setFavorite(buffer.split("\\|")[4]);
                		data_2.add(store);
                		count=1;
                	}
        		}
        		else if(target.equals("3"))  //200以上
        		{
        			if(money>200||money==200)
                	{
                		store.setStoreName(buffer.split("\\|")[0]);
                		store.setArea(buffer.split("\\|")[1]);
                		store.setPrice(buffer.split("\\|")[2]);
                		store.setTaste(buffer.split("\\|")[3]);
                		store.setFavorite(buffer.split("\\|")[4]);
                		data_2.add(store);
                		count=1;
                	}
        		}	
            }
            if(count==0)
            {
            	Store store=new Store();
            	buffer=bufferedReader.readLine();	
        		store.setStoreName("沒有符合的資料唷");
        		store.setArea(".");
        		store.setPrice(".");
        		store.setTaste(".");
        		store.setFavorite(".");
        		data_2.add(store);
            }
            inputStream.close();        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	//葷素是否
	public static void checkTaste(String filePath,String target)
	{
        store_add(filePath,target,3);
	}
	
	//最愛是否
	public static void checkFavorite(String filePath,String target)
	{
        store_add(filePath,target,4);
	}
	
	//新增資料
	public static void  add(String str) //ArrayList<Store>
	{ 
		int size=data.size();  
		Store store=new Store();
		store.setStoreName(str.split("\\ ")[0]);      //店名 地區 價位 素食 最愛
		store.setArea(str.split("\\ ")[1]);
		store.setPrice(str.split("\\ ")[2]);
		store.setTaste(str.split("\\ ")[3]);
		store.setFavorite(str.split("\\ ")[4]);
		data.add(store);
	}
	
	//刪除資料和加入最愛
	public static void delete_and_favorite(String filePath,String target,int judgement)
	{
		File file=new File(filePath);
		int set=data.size();
		data.clear();
		try 
	    {
		  	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            for(int i=0;i<set;i++)
            {
            	Store store=new Store();
            	buffer=bufferedReader.readLine();
            	if(!buffer.split("\\|")[0].equals(target))
            	{
            		store.setStoreName(buffer.split("\\|")[0]);
            		store.setArea(buffer.split("\\|")[1]);
            		store.setPrice(buffer.split("\\|")[2]);
            		store.setTaste(buffer.split("\\|")[3]);
            		store.setFavorite(buffer.split("\\|")[4]);
            		data.add(store);
            	}
            	else
            	{
            		if(judgement==2) //改成最愛
            		{
            			store.setStoreName(buffer.split("\\|")[0]);
                		store.setArea(buffer.split("\\|")[1]);
                		store.setPrice(buffer.split("\\|")[2]);
                		store.setTaste(buffer.split("\\|")[3]);
                		store.setFavorite("yes");
                		data.add(store);
            		}
            	}
            }
            inputStream.close();        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	//把資料從list中讀出來
	public static void read(String filePath) 
	{
		File file=new File(filePath);
	    try 
	    {
			data_2.clear();
		  	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while((buffer=bufferedReader.readLine())!=null) 
            {
        		Store store=new Store();
        		store.setStoreName(buffer.split("\\|")[0]);
        		store.setArea(buffer.split("\\|")[1]);
        		store.setPrice(buffer.split("\\|")[2]);
        		store.setTaste(buffer.split("\\|")[3]);
        		store.setFavorite(buffer.split("\\|")[4]);
        		if(filePath.equals("data/list.txt"))	
        			data.add(store);
        		else if(filePath.equals("data/buffer.txt"))
        			data_2.add(store);	
            }   
            inputStream.close();        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	public static void copy(String filePath) 
	{
		File file=new File(filePath);
	    try 
	    {
			data_2.clear();
		  	String buffer;
            FileInputStream inputStream =  new FileInputStream(file);
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            while((buffer=bufferedReader.readLine())!=null) 
            {
        		Store store=new Store();
        		store.setStoreName(buffer.split("\\|")[0]);
        		store.setArea(buffer.split("\\|")[1]);
        		store.setPrice(buffer.split("\\|")[2]);
        		store.setTaste(buffer.split("\\|")[3]);
        		store.setFavorite(buffer.split("\\|")[4]);	
        		data_2.add(store);	
            }   
            inputStream.close();        
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");                
        }
        catch(IOException ex) 
	    {
	        System.out.println("Error reading file '" + filePath + "'");                  
        }
	}
	
	//把資料寫進list
	public static void write(String filePath)
	{
		File file=new File(filePath);
		 try 
		 {
		 	FileOutputStream fileOutputStream=new FileOutputStream(file);
		 	OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            
            if(filePath.equals("data/list.txt"))
            {
            	for(Store element:data) 
                {
                	bufferedWriter.write(element.export());
            		bufferedWriter.newLine();
    	        }
                bufferedWriter.close();
            }
            else if(filePath.equals("data/buffer.txt")) 
            {

            	for(Store element:data_2) 
                {
                	bufferedWriter.write(element.export());
            		bufferedWriter.newLine();
    	        }
                bufferedWriter.close();
            }
            else if(filePath.equals("data/random.txt")) 
            {

            	for(Store element:data_3) 
                {
                	bufferedWriter.write(element.export());
            		bufferedWriter.newLine();
    	        }
                bufferedWriter.close();
            }
         }
		 catch(IOException ex) 
		 {
            System.out.println("Error writing to file '" + filePath + "' cause"+ex.toString());
	     }		
	}
}