import java.io.FileNotFoundException;
import java.io.FileReader;

import org.dom4j.Document;
import org.xml.sax.InputSource;

import java.io.BufferedReader;

//import src.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class BasicBase {
	Container stock;
	private Document doc =null;
	public BasicBase(Container co){
		stock = co;
		
		final String path = "C:/Users/YLY/Desktop/���/guizhou_out.xml";
		
		  
		readAddSuffix();
		readMisUds();
		readEthnic();
		 readFullCom();
		InputSource reader=null;
		try {
			reader = new InputSource(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("xmlDom "+ e);
		}
	   doc = parse(reader);
		
	   try {
	
		   t6List();
		   createFullList();
		   genT3Tree();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	 public Document parse(InputSource url)  {
	        SAXReader reader = new SAXReader();
	        Document document=null;
			try {
				document = reader.read(url);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	        return document;
	    }
	 
	 public void t6List(){
	    	//t6 = new HashMap<>();
	    	try{
	    		List<Node> nodes = doc.selectNodes("//T1/T2/T3/T4/T5/T6");
	    		for(Node node : nodes){
	    			//System.out.println(node.getName());
	    			this.stock.getT6().put(node.valueOf("@name"), node.valueOf("@type"));
	    		}
	    	}catch(Exception e){
	    		System.out.println("t6List()"+e);
	    	}
	    	//return t6;
	    	
	    }
	 
	 public Location createLocation(Element e){
	    	Location loc = new Location();
	    	loc.setName(e.valueOf("@name"));
			loc.setType(e.valueOf("@type"));
			loc.setLvl(e.getName());
	    	return loc;
	    }
	 public void createFullList(){
	    	List<Node> nodes = doc.selectNodes("//*");
	  			Location loc2 = null;
	    			Element root = doc.getRootElement();
	    			for(Iterator i = root.elementIterator();i.hasNext();){
	    				Element element2 = (Element) i.next();
	    				loc2 = createLocation(element2);
	    				
	    				for(Iterator j = element2.elementIterator();j.hasNext();){
	    					Element element3 = (Element) j.next();
	    					Location loc3 = createLocation(element3);
	    					loc3.setParent(loc2);
	    					loc2.addChild(loc3.getName(), loc3);
	    					loc2.addChild(loc3.getName()+"�ؼ���", loc3);
	    					loc2.addChild(loc3.getName()+"������", loc3);
	    					loc2.addChild(loc3.getName()+"��", loc3);
	    					
	    					loc2.addChild(loc3.getName()+"��", loc3);//�Լ��ӵ�
	    					for(Iterator k = element3.elementIterator();k.hasNext();){
	        					Element element4 = (Element) k.next();
	        					Location loc4 = createLocation(element4);
	        					loc4.setParent(loc3);
	        					loc3.addChild(loc4.getName(), loc4);
	        					loc3.addChild(loc4.getName()+"��", loc4);//�Լ��ӵ�
	        					loc3.addChild(loc4.getName()+"��Ͻ��", loc4);
	        					loc3.addChild(loc4.getName()+"��", loc4);
	        					loc3.addChild(loc4.getName()+"�ؼ���", loc4);
	        					loc3.addChild(loc4.getName()+"����", loc4);
	        					loc3.addChild(loc4.getName()+"����", loc4);
	        					loc3.addChild(loc4.getName()+"���ÿ�����", loc4);
	        					loc3.addChild(loc4.getName()+"���ü���������", loc4);
	        					loc3.addChild(loc4.getName()+"������", loc4);
	        					loc3.addChild(loc4.getName()+"��", loc4);
	        					
	        					loc3.addChild(loc4.getName()+"��", loc4);//�Լ��ӵ�
	        					for(Iterator a = element4.elementIterator();a.hasNext();){
	            					Element element5 = (Element) a.next();
	            					Location loc5 = createLocation(element5);
	            					loc5.setParent(loc4);
	            					loc4.addChild(loc5.getName(), loc5);
	            					loc4.addChild(loc5.getName()+"��", loc5);
	            					loc4.addChild(loc5.getName()+"��", loc5);
	            					loc4.addChild(loc5.getName()+"�ֵ�", loc5);
	            					loc4.addChild(loc5.getName()+"����", loc5);
	            					loc4.addChild(loc5.getName()+"��ҵ������", loc5);
	            					loc4.addChild(loc5.getName()+"������", loc5);
	            					loc4.addChild(loc5.getName()+"���ÿ�����", loc5);
	            					
	            					
	            					for(Iterator b = element5.elementIterator();b.hasNext();){
	                					Element element6 = (Element) b.next();
	                					Location loc6 = createLocation(element6);
	                					loc6.setParent(loc5);
	                					//loc5.addChild(loc6.getName(), loc6);
	                					loc5.addChild(loc6.getName()+"��", loc6);
	                					loc5.addChild(loc6.getName()+"����", loc6);
	                					loc5.addChild(loc6.getName()+"��", loc6);//��ӵ�
	                					loc5.addChild(loc6.getName()+"��", loc6);//��ӵ�
	                					//this.stock.getFullList().put(loc6.getName(), loc6);
	                					this.stock.getFullList().put(loc6.getName()+"��", loc6);
	                					this.stock.getFullList().put(loc6.getName()+"����", loc6);
	                					this.stock.getFullList().put(loc6.getName()+"��", loc6);//��ӵ�
	                					this.stock.getFullList().put(loc6.getName()+"��", loc6);//��ӵ�
	                					
	                					
	                				}
	            					//System.out.println("Loc5 "+loc5.getName());
	            					this.stock.getFullList().put(loc5.getName(), loc5);
	            					this.stock.getFullList().put(loc5.getName()+"��", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"��", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"�ֵ�", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"����", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"��ҵ������", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"������", loc5);
	            					this.stock.getFullList().put(loc5.getName()+"���ÿ�����", loc5);
	            				}
	        					this.stock.getFullList().put(loc4.getName(), loc4);
	        					this.stock.getFullList().put(loc4.getName()+"��", loc4);//�Լ��ӵ�
	        					this.stock.getFullList().put(loc4.getName()+"��Ͻ��", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"��", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"�ؼ���", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"����", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"����", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"���ÿ�����", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"���ü���������", loc4);
	        					this.stock.getFullList().put(loc4.getName()+"������", loc4);
	        					
	        					this.stock.getFullList().put(loc4.getName()+"��", loc4);//�Լ��ӵ�
	        					this.stock.getFullList().put(loc4.getName()+"��", loc4);
	        				}
	    					this.stock.getFullList().put(loc3.getName(), loc3);
	    					this.stock.getFullList().put(loc3.getName()+"�ؼ���", loc3);
	    					this.stock.getFullList().put(loc3.getName()+"������", loc3);
	    					
	    					this.stock.getFullList().put(loc3.getName()+"��", loc3);//�Լ��ӵ�
	    					this.stock.getFullList().put(loc3.getName()+"��", loc3);//�Լ��ӵ�
	    				}
	    				this.stock.getFullList().put(loc2.getName(), loc2);
						this.stock.getFullList().put(loc2.getName()+"ʡ", loc2);
	    				
	    			}

	    }
	 
	 public void readAddSuffix(){
	    	try{
	    		BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/YLY/Desktop/���/dizhihouzhui.txt")));
	    		String searchResult = null;
				while ((searchResult  = br.readLine()) != null) {
					this.stock.addSuffix(searchResult);
					
					
				}
				br.close();
	    	}catch(Exception e){
	    		System.out.println("readAddSuffix "+e);
	    	}
	    }
	 
	 public void readMisUds(){
	    	String searchResult = null;
	    	try{
	    		BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/YLY/Desktop/���/dirrerentCityItems_1116.txt")));
	    		while ((searchResult = br.readLine()) != null) {
	                this.stock.addMisUdsList(searchResult);
	    		}
	    		br.close();
	    	}catch(Exception e){
	    		System.out.println("readMisUds "+e);
	    	}
	    }
	 
	 public void readEthnic(){
	    	try{
	    		BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/YLY/Desktop/���/ethnic.txt")));
	    		String searchResult = null;
				while ((searchResult  = br.readLine()) != null) {
					this.stock.addEthnic(searchResult);
				}
				br.close();
	    	}catch(Exception e){
	    		System.out.println("readEthnic "+e);
	    	}
	    }
	
	 public void readFullCom(){
		 try{
			 BufferedReader br = new BufferedReader(new FileReader(new File("C:/Users/YLY/Desktop/���/guizhou_test_out_1124ANSI.txt")));
			 String searchResult = null;
				while ((searchResult  = br.readLine()) != null) {
					String[] line = searchResult.trim().split("\t");
					//System.out.println("line1 "+line[1]);
					//System.out.println("line0 "+line[0]);
					this.stock.getFullComList().put(line[1].trim().replace(" ", "").toUpperCase(), line[0].trim());
					this.stock.getSplitComList().put(line[1].trim().replace(" ", "").toUpperCase(), line[1].trim());
					
					

				}
				//System.out.println("�ټ��̵�full  " + this.stock.getSplitComList().get("�ټ��̵�"));
				//System.out.println("�ټ��̵� split " + this.stock.getSplitComList().get("�ټ��̵�"));
				br.close();
		 }catch(Exception e){
	    		System.out.println("readFullCom "+e);
	    	}
	 }
	 
	 public void genT3Tree(){
		 try{
			 List<Node> nodes = doc.selectNodes("//T1/T2/T3");
	    		for(Node node : nodes){
	    			System.out.println("T3 "+node.valueOf("@name"));
	    			
	    			HashMap<String,Boolean> cityList = new HashMap<>();
	   			 	Location upLvlCity = this.stock.getFullList().get(node.valueOf("@name")+"�ؼ���");
	   				//System.out.println(upLvlCityName+" "+upLvlCity.getName());
	   				HashMap<String,Location> t4List = upLvlCity.getChildren();

	   				for (Entry<String, Location> entry : t4List.entrySet()) {  
	   					   //System.out.println("T4 entry");
	   					   cityList.put(entry.getKey(), true);
	   					   for (Entry<String, Location> entry2 : entry.getValue().getChildren().entrySet()) {
	   						   cityList.put(entry2.getKey(), true);
	   						   for (Entry<String, Location> entry3 : entry2.getValue().getChildren().entrySet()) {
	   							   cityList.put(entry3.getKey(), true);
	   						   }
	   					   }
	   				}
	   				cityList.put(node.valueOf("@name"), true);
	   				cityList.put(node.valueOf("@name")+"�ؼ���", true);
	   				cityList.put(node.valueOf("@name")+"������", true);
	   				cityList.put(node.valueOf("@name")+"��", true);
	   				cityList.put(node.valueOf("@name")+"��", true);

	   				cityList.put("����", true);
	   				cityList.put("����ʡ", true);
	   				this.stock.getT3Tree().put(node.valueOf("@name"),cityList);
	    		}
				
				
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	
}
