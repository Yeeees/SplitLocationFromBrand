import java.util.ArrayList;
import java.util.HashMap;

public class SingleFile {
	private ArrayList<String[]> line = new ArrayList<>();
	private String fileName;
	private ArrayList<Company> companyList = new ArrayList<>();
//	private HashMap<String,Integer> attrList = new HashMap<>();
	private ArrayList<Integer> attrList = new ArrayList<>(); 
	
//	public HashMap<String, Integer> getAttrList() {
//		return attrList;
//	}
//
//	public void setAttrList(HashMap<String, Integer> attrList) {
//		this.attrList = attrList;
//	}

	public ArrayList<Integer> getAttrList() {
		return attrList;
	}

	public void setAttrList(ArrayList<Integer> attrList) {
		this.attrList = attrList;
	}

	public ArrayList<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}

	public void setFileName(String name){
		this.fileName = name;
	}
	
	public String getFileName(){
		return this.fileName;
	}

	public ArrayList<String[]> getLine() {
		return line;
	}

	public void setLine(ArrayList<String[]> line) {
		this.line = line;
	}
	public void addLine(String[] newLine){
		this.line.add(newLine);
	}
}
