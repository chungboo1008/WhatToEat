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
	
	//�qList��random�X�@�a�\�U
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
	
	//���Ʀs�iarraylist
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
            	if(buffer.split("\\|")[0].equals("�S���ŦX����ƭ�"))
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
        		store.setStoreName("�S���ŦX����ƭ�");
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
	
	//�a�Ͽ��
	public static void checkArea(String filePath,String target)
	{
        store_add(filePath,target,1);
	}
	
	//������
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
            	if(buffer.split("\\|")[0].equals("�S���ŦX����ƭ�"))
            		break;
            	int money=Integer.parseInt(buffer.split("\\|")[2]);
            	if(target.equals("1"))       //100�H�U
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
        		else if(target.equals("3"))  //200�H�W
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
        		store.setStoreName("�S���ŦX����ƭ�");
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
	
	//�����O�_
	public static void checkTaste(String filePath,String target)
	{
        store_add(filePath,target,3);
	}
	
	//�̷R�O�_
	public static void checkFavorite(String filePath,String target)
	{
        store_add(filePath,target,4);
	}
	
	//�s�W���
	public static void  add(String str) //ArrayList<Store>
	{ 
		int size=data.size();  
		Store store=new Store();
		store.setStoreName(str.split("\\ ")[0]);      //���W �a�� ���� ���� �̷R
		store.setArea(str.split("\\ ")[1]);
		store.setPrice(str.split("\\ ")[2]);
		store.setTaste(str.split("\\ ")[3]);
		store.setFavorite(str.split("\\ ")[4]);
		data.add(store);
	}
	
	//�R����ƩM�[�J�̷R
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
            		if(judgement==2) //�令�̷R
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
	
	//���Ʊqlist��Ū�X��
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
	
	//���Ƽg�ilist
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