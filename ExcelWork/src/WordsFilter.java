import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

//import src.Company;

public class WordsFilter {
	Container container;
	public WordsFilter(Container co){
		container = co;
		genComList();
		
	}
	
	public void genComList(){
		for(int i = 0;i<this.container.getStock().size();i++){
			//System.out.println(this.container.getStock().get(i).getLine().size());
			//System.out.println("Flag at "+ findFlag(this.container.getStock().get(i)) + " at " +this.container.getStock().get(i).getFileName());
			for(int j = 0;j<this.container.getStock().get(i).getLine().size();j++){
				
				String companyFullName = "";
				String companyFirstName = "";
				String companySubName = "";
//				String companySecName="";
//				String companyThdName="";
//				String companyFrtName="";
//				String companySixName="";
//				if(companyFirstName.equals(null)||companyFirstName.equals("")||companyFirstName.equals(" ")){
//					companyFirstName = companyFirstName + "NULL";
//					System.out.println("空值  Null"+ companyFirstName+"Null");
//				}
				for(int k = 0;k<this.container.getStock().get(i).getLine().get(j).length;k++){
					companyFullName = companyFullName + this.container.getStock().get(i).getLine().get(j)[k].trim()+" ";//replaceAll(" ", "")
					
					//companyFirstName = companyFirstName + this.container.getStock().get(i).getLine().get(j)[k] +" ";
				}
				Company newCom = new Company();
				int flagRange = this.container.getStock().get(i).getAttrList().size();
				for(int fr = 0; fr<flagRange;fr++){
					//int flagCoo =  this.container.getStock().get(i).getAttrList().get(fr);
					subName sNameObj = new subName();
					if(fr == 0){
						String subName = this.container.getStock().get(i).getLine().get(j)[0].trim();
						//查找未分词
						if(subName.split(" ").length == 1)
							subName = unmodifyFilter(subName,companyFullName);
						sNameObj.setSubFull(subName);
						System.out.println("D0 "+subName);
					}
					else{
						int flagCoo =  this.container.getStock().get(i).getAttrList().get(fr-1);
						String subName = this.container.getStock().get(i).getLine().get(j)[flagCoo+1];
						sNameObj.setSubFull(subName);
						System.out.println("D"+fr+" "+subName);
					}
					newCom.getSubList().add(sNameObj);
				}
				
				companyFirstName = companyFirstName + this.container.getStock().get(i).getLine().get(j)[0];
				
				newCom.setFullName(companyFullName.trim());
				newCom.setFirstName(companyFirstName.trim());
				
				newCom = locFilter(newCom);
				this.container.getHashComList().put(companyFullName.trim().replace(" ", "").toUpperCase(),this.container.getStock().get(i).getFileName() );

				//System.out.println(companyFullName);
				//System.out.println(companyFirstName);
				if(newCom.getLocName1().size()!=0)
				System.out.println("newCom "+newCom.getLocName1().get(0));
				else
					System.out.println("等于0");
				this.container.getStock().get(i).getCompanyList().add(newCom);
			}
		}
		//misFilter();
	}
	
	public int findFlag(SingleFile sf){
		int flag = 0;
		int base = 0;
		String charMax="";
		HashMap<String,String> charMap = new HashMap<>();
		for(int i = 0;i<sf.getLine().size();i++){
			String[] tempLine = sf.getLine().get(i);
			for(int j = 0;j<tempLine.length;j++){
				if(!tempLine[j].trim().equals("")){
				if(!charMap.containsKey(tempLine[j]))
					charMap.put(tempLine[j], "1");
				else{
					int index = Integer.valueOf(charMap.get(tempLine[j])) + 1;
	                charMap.put(tempLine[j], String.valueOf(index));
	                if(index > base){
	                    base = index;
	                    flag = j;
	                    charMax = tempLine[j];
	                }
				}
				}
			}
		}
		System.out.println("Max char is " + charMax);
		return flag;
	}
	//unfinshed
	public Company locFilter(Company temp){
		Company tempCom = temp;
//		for(int i = 0;i<this.container.getStock().size();i++){
//			SingleFile tempFile = this.container.getStock().get(i);
//			for(int j = 0;j<tempFile.getCompanyList().size();j++){
				//Company tempCom = tempFile.getCompanyList().get(j);
		//subName count
		HashMap<String,Boolean> cityList = lvlDetect(tempCom.getFullName());
		
		
		for(int sc=0;sc<tempCom.getSubList().size();sc++){
			
		
				//Company tempCom = com;
				//String[] holderLvl2 = tempCom.getFirstName().split(" ");
			String[] holderLvl2 = tempCom.getSubList().get(sc).getSubFull().trim().split(" ");
				boolean mark1 = true;
				boolean mark2 = true;
				
				List<String> list = new ArrayList<String>();

			    for(String s : holderLvl2) {
			       if(s != null && s.length() > 0) {
			          list.add(s);
			       }
			    }

			    holderLvl2 = list.toArray(new String[list.size()]);
				
				for(int j = 0;j<holderLvl2.length;j++){
					try{
						
	    				if(mark1 || mark2){
	    					if(searchPlaceHash(holderLvl2[j])  
	    							//&& this.container.getT6().get(holderLvl2[j]) == null
	    							&& cityList.get(holderLvl2[j]) != null
	    							&& !searchIsMisUds(holderLvl2[j],tempCom)
	    							&& mark1
	    							&& holderLvl2[j]!=null)
	    					//if(xmlControl.searchExist(holderLvl2[j]))
	    					{
	    						System.out.println("add loc1 "+holderLvl2[j]);	    					
	    						tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    						
	    					}
	    					else{
	    						//System.out.println("add com1 "+holderLvl2[j]);
	    						//this.container.getCompanyList().get(i).addComName1(holderLvl2[j]);
//	    						if(j!=0)
	    							
//	    						else
//	    							j = 0;
	    						mark1=false;
	    						
	    							String lastChar = holderLvl2[j].substring(holderLvl2[j].length()-1);
	    							if(lastChar.equals("路") || lastChar.equals("街") || //lastChar.equals("城") ||
	    								//lastChar.equals("桥") || 
	    								lastChar.equals("寺"))
	    								tempCom.getSubList().get(sc).getSubStr().add(holderLvl2[j]);
	    						
	    						//ethnic
	    						else if(searchEthnic(holderLvl2[j])){
	        						if(searchAddSuffix(holderLvl2[j+1])){
	        							System.out.println("add ethnic1 "+ holderLvl2[j]);
	        							tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	        						}
	        						
	        					//suffix
	        						
	        						
	        						else{
	        							for(int v=1;v<holderLvl2.length-j;v++){
	        								if(searchEthnic(holderLvl2[j+v]) && searchAddSuffix(holderLvl2[j+v+1])){
	        									System.out.println("add ethnic1 "+ holderLvl2[j]);
	        									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	        									break;
	        								}
	        								else if(!searchEthnic(holderLvl2[j+v])){
	        									tempCom.getSubList().get(sc).getSubCom().add(holderLvl2[j]);
	        									break;
	        								}
	        							}
	        						}
	        						
	        				}
	    						//对应经济技术开发区或经济开发区
	    						else if(holderLvl2[j].equals("经济")
	    								&&j<holderLvl2.length-2
	    								&&holderLvl2[j+1].equals("技术")&&holderLvl2[j+2].equals("开发区")){
	    								//if(){
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j+1]);
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j+2]);
	    									j=j+2;
	    									mark1=true;
	    									continue;
	    								//}
	    							}
	    						else if(holderLvl2[j].equals("经济")
	    								&&j<holderLvl2.length-1
	    								&&holderLvl2[j+1].equals("开发区")){
	    								//if(){
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j+1]);
	    									j=j+1;
	    									mark1=true;
	    									continue;
	    								//}
	    							}
	    						else if(holderLvl2[j].equals("技术")
	    								&&j<holderLvl2.length-1
	    								&&holderLvl2[j+1].equals("开发区")){
	    								//if(){
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    									tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j+1]);
	    									j=j+1;
	    									mark1=true;
	    									continue;
	    								//}
	    							}
	    						else if(j!=0) {
//	    								if((holderLvl2[j].equals("开发区")|| holderLvl2[j].equals("经济") || holderLvl2[j].equals("技术"))){ 
//	    										if(specialSuffix(holderLvl2[j],holderLvl2[j-1],holderLvl2[j+1],holderLvl2[j+2])){
//	    											tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
//	    											System.out.println("后缀判断 "+ holderLvl2[j]);
//	    										}
//	    								}
	    							
	    							
	    							
	    						
	    								if(searchAddSuffix(holderLvl2[j])){
	    									//System.out.println("add Suffix1 "+ holderLvl2[j]);
	    									String tag;
	    									if(holderLvl2[j-1] == null)
	    										tag = "org";
	    									else if(j<(holderLvl2.length-2)){
	    										tag = suffixFilter(holderLvl2[j],holderLvl2[j-1],holderLvl2[j+1],holderLvl2[j+2],tempCom.getFullName());
	    										System.out.println("tag "+tag);
	    									}
	    									else{
	    										tag="suffix";
	    									}
	    									switch(tag){
	    									case "org": tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    												mark1=true;
	    												System.out.println("switch org");break;
	    									case "place": tempCom.getSubList().get(sc).getSubCom().add(holderLvl2[j]);
	    												mark1=true;
	    												mark2=false;
	    												System.out.println("switch place");break;
	    									case "suffix": tempCom.getSubList().get(sc).getSubLoc().add(holderLvl2[j]);
	    												mark1=true;
        	    									System.out.println("switch suffix");break;
	    									}
        	    					//this.container.getCompanyList().get(i).addSuffix(holderLvl2[j]);
	    								}
	    								else{
	    									mark2=false;
	    									j=j-1;
	    								}
	    							}
	    						
	    							else{
	    								mark2=false;
	    								j=j-1;
	    							}
	    						
	    							
	    						
	    						}
	    				}
	    				
	    				
	    				
	    				else{
	    					//System.out.println(searchPlaceHash(holderLvl2[j]));
	    					System.out.println("add com1 "+holderLvl2[j]);
	    					tempCom.getSubList().get(sc).getSubCom().add(holderLvl2[j]);
	    					
	    					}
	    			}
	    			catch(Exception e)
	    			{
	    				System.out.println("locFilter "+e);
	    				e.printStackTrace();
	    			}
				}
	
//			}
//		}
//	}
		}
				return tempCom;
	}
	
	public boolean searchPlaceHash(String searchWords){
    	boolean flag = false;    	
    	if(this.container.getFullList().get(searchWords)!=null)
    		flag = true;
    	
    	return flag;
    }
	
	public void misFilter(){
		for(int i = 0;i<this.container.getCompanyList().size();i++){
			
			for(int j = 0;j<this.container.getCompanyList().get(i).getLocName1().size();j++){
				int nsize = this.container.getCompanyList().get(i).getLocName1().size();
//				System.out.println("No. "+j+" of "+nsize+" at "+i);
//				System.out.println("locName "+this.container.getCompanyList().get(i).getLocName1().get(j));
				if(searchIsMisUds(this.container.getCompanyList().get(i).getLocName1().get(j),this.container.getCompanyList().get(i))){
					this.container.getCompanyList().get(i).addComName1(this.container.getCompanyList().get(i).getLocName1().get(j));
					//System.out.println("remove "+ this.container.getCompanyList().get(i).getLocName1().get(j));
					this.container.getCompanyList().get(i).getLocName1().remove(j);
					j=j-1;

					this.container.getCompanyList().get(i).setFlag();
					//System.out.println(this.container.getCompanyList().get(i).getFlag());

				}
			}
		}
	}
	
	public boolean searchIsMisUds(String searchWords,Company company) {
    	boolean flag = false;
    	String[] fullName = company.getFullName().trim().split(" ");

    	for(int i=0;i<this.container.getMisUdsList().size();i++){
    		String listLine[] = this.container.getMisUdsList().get(i).split("\t");
    		//System.out.println("misKey"+listLine[0]);
            if(listLine[0].trim().contains(searchWords)){
            	//System.out.println("Might Mis " + searchWords);
                if(listLine[0].contains("#")){
                	flag = true;
                	
                	//System.out.println("fuName "+fullName[0]);
                	//String[] brandName = fullName[0].split(" ");//gai
                	//String[] misName = listLine[2].split(" ");
                	for(int j=0;j<fullName.length;j++){
                		//System.out.println("brandName "+brandName[j]);
                		if(this.container.getMisUdsList().get(i).contains(fullName[j])){
                			
                			//System.out.println("包含"+brandName[j]);
                		}else{
                			flag = false;
                			//System.out.println(this.container.getMisUdsList().get(i)+"不包含 "+brandName[j]);
                			break;
                			//
                		}
                			
                	}

            }
    }
            if(flag==true){
            	break;
            }
    	}
    	return flag;
    	
    }
	
	public boolean searchEthnic(String searchWords){
    	boolean flag = false;
    	for(int i=0;i<this.container.getEthnicList().size();i++){
            if(this.container.getEthnicList().get(i).equals(searchWords)){
                
                	flag = true;
                	break;
                
            }
    }
    	return flag;
    }
	
	public boolean searchAddSuffix(String searchWords){
    	boolean flag = false;
    	for(int i=0;i<this.container.getAddSuffix().size();i++){
            if(this.container.getAddSuffix().get(i).equals(searchWords)){
                flag = true;
                break;
            }
    }
    	return flag;
    }
	
	public String suffixFilter(String suffixWords, String pWords,String nWords,String n2Words, String fullName){
 		if(searchEthnic(pWords)){
 			return "suffix";
 		}
 		if(this.container.getFullList().get(pWords) == null){
 			return "org";
 		}
 		else if(this.container.getFullList().get(pWords).getType() == suffixWords){
 			return "suffix";
 		}
 		else if(this.container.getFullList().get(pWords).getChildren().size() == 0){
// 			System.out.print(suffixWords+" 在 "+fullName+" 中是否为地址后缀（y/n）？ ");
// 			Scanner scString = new Scanner(System.in);
// 			String asw = null;
// 			try{
// 				asw = scString.nextLine();
// 				while((!asw.equals("y")) && (!asw.equals("n"))){
// 					System.out.println("请输入y或n");
// 					asw = scString.nextLine();
// 				}
// 			}catch(Exception e){
// 				System.out.println(e);
// 			}
// 			if(asw.equals("y")){
// 				return "suffix";
// 				
// 			}else{
// 				return "org";
// 			}
 			return "suffix";
 		}
 		//determined by next 2 words
 		
 		else{
 				ArrayList<Integer> hasChild = new ArrayList<>();
 				if(this.container.getFullList().get(pWords).getChildren().size() !=0&&suffixWords.length()!=0){
// 				for(int i=0;i<this.container.getFullList().get(pWords).getChildren().size();i++){
// 					
// 						if(this.container.getFullList().get(pWords).getChildren().get(i).getType().equals(suffixWords)){
// 							hasChild.add(i);
// 						}
// 					}
 					HashMap<String,Location> List = this.container.getFullList().get(pWords).getChildren();
 					for(Entry<String, Location> entry : List.entrySet()){

 						if(entry.getValue().getType().equals(suffixWords))
 							hasChild.add(1);
 						
 					}
 				}
 				if(hasChild.size()==1){
 					return "place";
 				}
 				else{
 					return "org";
 					//return "name";
 				}
 		}
 			
 		//return null;
 	}
	
	public boolean specialSuffix(String suffixWords, String pWords,String nWords,String n2Words){
		boolean flag=false;
		if((suffixWords.equals("经济") && nWords.equals("技术") && n2Words.equals("开发区")) || 
 				(pWords.equals("经济") && suffixWords.equals("技术") && nWords.equals("开发区")) ||
 				(pWords.equals("技术") && suffixWords.equals("开发区")) || 
 				(suffixWords.equals("经济") && nWords.equals("开发区")) || 
 				(pWords.equals("经济") && suffixWords.equals("开发区"))	 ||
 				(suffixWords.equals("技术") && nWords.equals("开发区")) || 
 				(pWords.equals("技术") && suffixWords.equals("开发区"))){
 			flag = true;
 		}
		return flag;
	}
	
	public String unmodifyFilter(String checkWords,String fullName){
		String modified = "";
		fullName = fullName.replace(" ", "");
		
		String searchResult = this.container.getSplitComList().get(fullName.toUpperCase());
		if(searchResult!=null){
		String[] orgName = searchResult.split(" ");
		
		for(int i = 0;i<orgName.length;i++){
			if(checkWords.contains(orgName[i]))
				modified = modified + orgName[i] + " ";
			else
				break;
		}
		if(modified.trim().isEmpty())
			modified = checkWords;
		}else{
			System.out.println("未分词且1124原表查询不到 "+fullName);
			modified = checkWords;
		}
		System.out.println("分词结果 "+modified);
		return modified;
	}
	
	public HashMap<String,Boolean> lvlDetect(String comFullName){
		
		comFullName = comFullName.replace(" ", "");
		String upLvlCityName = this.container.getFullComList().get(comFullName.toUpperCase());
		HashMap<String,Boolean> cityList = new HashMap<>();
		if(upLvlCityName != null){
		cityList=this.container.getT3Tree().get(upLvlCityName);
		}else{
			System.out.println("Null "+ comFullName);
		}
		
		
//		for(int i=0;i<upLvlCity.getChildren().size();i++){
//			//System.out.println(upLvlCity.getName()+" "+upLvlCity.getLvl()+" "+upLvlCity.getChildren()+" "+upLvlCity.ge);
//			cityList.put(upLvlCity.getChildren().get(i).getName(), true);
//			for(int j=0;j<upLvlCity.getChildren().get(i).getChildren().size();j++){
//				cityList.put(upLvlCity.getChildren().get(i).getChildren().get(j).getName(), true);
//			}
//			
//		}
		
		return cityList;
	}
	
	
}
