import java.io.File;   
  
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;

import jxl.Cell;   
  
import jxl.CellType;   
  
import jxl.Sheet;   
  
import jxl.Workbook;   
  
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook; 
public class ExcelReader {
	//private Container stock = new Container();
	private Container stock;
	public ExcelReader(Container co){
		stock = co;
		//reader();
//		try{
//		 File filewrite=new File("C:/Users/YLY/Desktop/灵伴/excelTestOutPut.xls");   
//		  
//	        filewrite.createNewFile();   
//	  
//	        OutputStream os=new FileOutputStream(filewrite);  
//	        
//	        excelWriter(os);
//		}catch(Exception e){
//			System.out.println("Writer "+e);
//		}
		
	}
	public void reader(){
		jxl.Workbook readwb = null;   
		try{
			InputStream instream = new FileInputStream("C:/Users/YLY/Desktop/灵伴/12-16.xls"); //删除ERRORline的全部_1213_3
			//InputStream instream = new FileInputStream("C:/Users/YLY/Desktop/灵伴/测试用.xls"); 
			
            readwb = Workbook.getWorkbook(instream);
            //System.out.println("before loop");
            for(int k = 0; k<readwb.getNumberOfSheets();k++){
            	//System.out.println("loop k");
            Sheet readsheet = readwb.getSheet(k);
            int rsColumns = readsheet.getColumns();
            int rsRows = readsheet.getRows();
            SingleFile sf = new SingleFile();
            sf.setFileName(readsheet.getName());
            for(int x=0; x<rsColumns;x++){
            	
            	Cell attrCell = readsheet.getCell(x,0);
            	if(attrCell.getContents().contains("级机构"))
            		sf.getAttrList().add(x);
            
            }
            for (int i = 1; i < rsRows; i++)   
            	  
            {   
            	//System.out.println("loop i");
            	String[] newLine = new String[rsColumns];
            	
                for (int j = 0; j < rsColumns; j++)   
  
                {   
  
                    Cell cell = readsheet.getCell(j, i);   
                    newLine[j] = cell.getContents().trim().replace("　", "");
                    //System.out.print(cell.getContents() + " "); 
                    //System.out.println("111"+newLine[j]);
  
                }   
                sf.addLine(newLine);
                //System.out.println("line"+ sf.getLine().get(i));
                

            }
            this.stock.addStock(sf);
            }
            readwb.close();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	

	
	public void excelWriter(){
		try {
			File filewrite=new File("C:/Users/YLY/Desktop/灵伴/excelTestOutPut.xls");  
			PrintWriter outputFile = new PrintWriter("C:/Users/YLY/Desktop/灵伴/1124分词Error.txt");
			  
			
	        filewrite.createNewFile();   
	  
	        OutputStream os=new FileOutputStream(filewrite);
			
			
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			for(int i = 0;i<this.stock.getStock().size();i++){
				WritableSheet ws = wwb.createSheet(this.stock.getStock().get(i).getFileName(),i);  
				SingleFile tempFile = this.stock.getStock().get(i);
				System.out.println("loop i");
				
				
				for(int fc=0;fc<tempFile.getAttrList().size();fc++){
					
					//表头
					if(fc == 0){
						Label tbTitle1 = new Label(0,0,"1级A-行政区划");
						ws.addCell(tbTitle1);
						Label tbTitle2 = new Label(1,0,"1级A-地址");
						ws.addCell(tbTitle2);
						Label tbTitle3= new Label(2,0,"1级A-其他");
						ws.addCell(tbTitle3);
						char word = 'B';
						int ascii = (int) word;
						Label tbFlag = new Label(tempFile.getAttrList().get(fc)+2,0,"1级机构");
						ws.addCell(tbFlag);
						for(int rc=1;rc<tempFile.getAttrList().get(fc);rc++){
							Label rest = new Label(rc+2,0,"1级"+(char)ascii);
							//System.out.println("rc"+rc+" "+tempLine[rc]);
							ws.addCell(rest);
							ascii=ascii+1;
							
						}
						
					}
					else{
						Label tbTitle1 = new Label(tempFile.getAttrList().get(fc-1)+2*fc+1,0,(fc+1)+"级A-"+"行政区划");
						ws.addCell(tbTitle1);
						Label tbTitle2 = new Label(tempFile.getAttrList().get(fc-1)+2*fc+2,0,(fc+1)+"级A-"+"地址");
						ws.addCell(tbTitle2);
						Label tbTitle3 = new Label(tempFile.getAttrList().get(fc-1)+2*fc+3,0,(fc+1)+"级A-"+"其他");
						ws.addCell(tbTitle3);
						Label tbFlag = new Label(tempFile.getAttrList().get(fc)+2*(fc+1),0,(fc+1)+"级机构");
						ws.addCell(tbFlag);
						char word = 'B';
						int ascii = (int) word;
						for(int rc=tempFile.getAttrList().get(fc-1)+2;rc<tempFile.getAttrList().get(fc);rc++){
							Label rest = new Label(rc+2*fc+2,0,(fc+1)+"级"+(char)ascii);
							ws.addCell(rest);
							ascii=ascii+1;
						}
					}
				}//title loop
				
				
				
				
				for(int j = 0;j<tempFile.getLine().size();j++){
					String finalLine="";
					for(int fc=0;fc<tempFile.getAttrList().size();fc++){
					
					//System.out.println("loop j");
					String[] tempLine = tempFile.getLine().get(j);
					Company temCom = tempFile.getCompanyList().get(j);
					
						
						//System.out.println("loop fc");
						String locFullName = "";
						String comFullName = "";
						String strFullName = "";
						for(int x=0;x<temCom.getSubList().get(fc).getSubLoc().size();x++){
							locFullName = locFullName +temCom.getSubList().get(fc).getSubLoc().get(x)+" ";
						}
						for(int y=0;y<temCom.getSubList().get(fc).getSubCom().size();y++){
							comFullName = comFullName +temCom.getSubList().get(fc).getSubCom().get(y)+" ";
						}
						for(int z=0;z<temCom.getSubList().get(fc).getSubStr().size();z++){
							strFullName = strFullName +temCom.getSubList().get(fc).getSubStr().get(z)+" ";
						}
						if(fc == 0){
							Label locName = new Label(0,j+1,locFullName.trim());
							System.out.println("LocFullName "+locFullName);
							ws.addCell(locName);
							finalLine=finalLine+ locFullName.trim().replace(" ", "");
							Label strName = new Label(1,j+1,strFullName.trim());
							System.out.println("ComFullName "+strFullName);
							ws.addCell(strName);
							finalLine=finalLine+ strFullName.trim().replace(" ", "");
							Label comName = new Label(2,j+1,comFullName.trim());
							System.out.println("ComFullName "+comFullName);
							ws.addCell(comName);
							finalLine=finalLine+ comFullName.trim().replace(" ", "");
							
							for(int rc=1;rc<=tempFile.getAttrList().get(fc);rc++){
								Label rest = new Label(rc+2,j+1,tempLine[rc]);
								System.out.println("rc"+rc+" "+tempLine[rc].trim());
								ws.addCell(rest);
								finalLine=finalLine+ tempLine[rc].trim().replace(" ", "");
								
							}
							
							
							
						}
						else{
							Label locName = new Label(tempFile.getAttrList().get(fc-1)+2*fc+1,j+1,locFullName.trim());
							//Label locName
							ws.addCell(locName);
							finalLine=finalLine+locFullName.trim().replace(" ", "");
							Label strName = new Label(tempFile.getAttrList().get(fc-1)+2*fc+2,j+1,strFullName.trim());
							ws.addCell(strName);
							finalLine=finalLine+strFullName.trim().replace(" ", "");
							Label comName = new Label(tempFile.getAttrList().get(fc-1)+2*fc+3,j+1,comFullName.trim());
							ws.addCell(comName);
							finalLine=finalLine+comFullName.trim().replace(" ", "");
							
							for(int rc=tempFile.getAttrList().get(fc-1)+2;rc<=tempFile.getAttrList().get(fc);rc++){
								Label rest = new Label(rc+2*fc+2,j+1,tempLine[rc].trim());
								ws.addCell(rest);
								finalLine=finalLine+tempLine[rc].trim().replace(" ", "");
							}
							
						}
						
						//检查是否与原表数据相同
						
					}
					if(this.stock.getFullComList().get(finalLine.trim().replace(" ", "").toUpperCase())==null&&!finalLine.trim().isEmpty())	
						outputFile.println(finalLine);
				}//without title loop
	
			}//singlefile
			 wwb.write();
			 wwb.close();
			 outputFile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} 
	}
	
	//12.13 将原表前两列加入
	public void excelWriter2(){
		try {
			PrintWriter outputFile = new PrintWriter("C:/Users/YLY/Desktop/灵伴/1124查询不到的条目.txt");
			File filewrite=new File("C:/Users/YLY/Desktop/灵伴/加入前两列1213.xls");
			//File filewrite2 = new File("C:/Users/YLY/Desktop/灵伴/加入前两列(安顺)1213.xls");
			  
	        filewrite.createNewFile();   
	  
	        OutputStream os=new FileOutputStream(filewrite);
			
			
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			for(int i = 0;i<this.stock.getStock().size();i++){
				WritableSheet ws = wwb.createSheet(this.stock.getStock().get(i).getFileName(),i);  
				SingleFile tempFile = this.stock.getStock().get(i);
				//System.out.println("loop i");
				//表头
				for(int fc=0;fc<tempFile.getAttrList().size();fc++){
				if(fc == 0){
					Label tbTitle1 = new Label(0,0,"地区");
					ws.addCell(tbTitle1);
					Label tbTitle2 = new Label(1,0,"全称");
					ws.addCell(tbTitle2);
					char word = 'A';
					int ascii = (int) word;
					Label tbFlag = new Label(tempFile.getAttrList().get(fc)+2,0,"1级机构");
					ws.addCell(tbFlag);
					for(int rc=0;rc<tempFile.getAttrList().get(fc);rc++){
						Label rest = new Label(rc+2,0,"1级"+(char)ascii);
						ws.addCell(rest);
						ascii=ascii+1;
						
					}
					
				}
				else{

					Label tbFlag = new Label(tempFile.getAttrList().get(fc)+2,0,(fc+1)+"级机构");
					ws.addCell(tbFlag);
					char word = 'A';
					int ascii = (int) word;
					for(int rc=tempFile.getAttrList().get(fc-1)+1;rc<tempFile.getAttrList().get(fc);rc++){
						Label rest = new Label(rc+2,0,(fc+1)+"级"+(char)ascii);
						ws.addCell(rest);
						ascii=ascii+1;
					}
				}
				}
				
				for(int j = 0;j<tempFile.getLine().size();j++){
					//System.out.println("loop j");
					String[] tempLine = tempFile.getLine().get(j);
					Company tempCom = tempFile.getCompanyList().get(j);


						
						String comFullName = tempCom.getFullName().trim().replace(" ","");
						String city = this.stock.getFullComList().get(comFullName);
						String splitFullName = this.stock.getSplitComList().get(comFullName);
						
						
						
						if(city == null||splitFullName == null){
							city = this.stock.getFullComList().get(comFullName.toUpperCase());
							splitFullName = this.stock.getSplitComList().get(comFullName.toUpperCase());
							System.out.println("Error UpperCase "+comFullName);
							//outputFile.println("大小写？ "+comFullName);
							if(city == null||splitFullName == null){
								System.out.println("Error still null "+comFullName);
								outputFile.println(""+comFullName+"  "+this.stock.getStock().get(i).getFileName());
								//转为大写后仍没有  
							}
						}
						
						Label locName = new Label(0,j+1,city);
						ws.addCell(locName);
						Label splitName = new Label(1,j+1,splitFullName);
						ws.addCell(splitName);
						
						for(int x=0;x<tempLine.length;x++){
							//System.out.println("loop x");
							Label rest = new Label(x+2,j+1,tempLine[x]);
							ws.addCell(rest);
						}
						
							
							
						
					}

				
	
			}
			 wwb.write();
			 wwb.close();
			 outputFile.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("excelWriter2 "+e);
			e.printStackTrace();
		} 
	}
	
	public void unmodifyCheck(){
		try{
			PrintWriter outputFile = new PrintWriter("C:/Users/YLY/Desktop/灵伴/1124分词unmodify.txt");
			HashMap<String,String> List = this.stock.getSplitComList();
			for(Entry<String, String> entry : List.entrySet()){

				if(this.stock.getHashComList().get(entry.getKey().trim().toUpperCase())==null)
					outputFile.println(entry.getValue());
				
			}
			outputFile.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
