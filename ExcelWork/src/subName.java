import java.util.ArrayList;

public class subName {
	private String subFull = "";
	
	
	private ArrayList<String> subCom = new ArrayList<>();
	private ArrayList<String> subLoc = new ArrayList<>();
	private ArrayList<String> subStr = new ArrayList<>();
	
	public ArrayList<String> getSubStr() {
		return subStr;
	}
	public void setSubStr(ArrayList<String> subStr) {
		this.subStr = subStr;
	}
	public String getSubFull() {
		return subFull;
	}
	public void setSubFull(String subFull) {
		this.subFull = subFull;
	}
	public ArrayList<String> getSubCom() {
		return subCom;
	}
	public void setSubCom(ArrayList<String> subCom) {
		this.subCom = subCom;
	}
	public ArrayList<String> getSubLoc() {
		return subLoc;
	}
	public void setSubLoc(ArrayList<String> subLoc) {
		this.subLoc = subLoc;
	} 
}
