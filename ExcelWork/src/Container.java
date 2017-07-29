import java.util.ArrayList;
import java.util.HashMap;

//import src.Company;
//import src.Location;

//import src.Location;

public class Container {
	private ArrayList<SingleFile> stock = new ArrayList<>();
	
	//for xml file
	private HashMap<String,String> t6 = new HashMap<>();
	private HashMap<String,Location> fullList = new HashMap<>();
	
	//for others
	private ArrayList<Company> companyList = new ArrayList<>();
	private HashMap<String,String> locationList = new HashMap<>();
	private ArrayList<String> ethnicList = new ArrayList<>();
	private ArrayList<String> addSuffix = new ArrayList<>();
	private ArrayList<String> misUdsList = new ArrayList<>();
	//所有company name，表名
	private HashMap<String,String> hashComList = new HashMap<>();
	//全表1124
	private HashMap<String,String> fullComList = new HashMap<>();
	private HashMap<String,String> splitComList = new HashMap<>();
	
		private ArrayList<Location> locations = new ArrayList<>();
		
		private HashMap<String,HashMap<String,Boolean>> t3Tree = new HashMap<>();
		
		
		public HashMap<String, String> getHashComList() {
			return hashComList;
		}

		public void setHashComList(HashMap<String, String> hashComList) {
			this.hashComList = hashComList;
		}
	public HashMap<String, HashMap<String, Boolean>> getT3Tree() {
			return t3Tree;
		}

		public void setT3Tree(HashMap<String, HashMap<String, Boolean>> t3Tree) {
			this.t3Tree = t3Tree;
		}

	public HashMap<String, String> getSplitComList() {
			return splitComList;
		}

		public void setSplitComList(HashMap<String, String> splitComList) {
			this.splitComList = splitComList;
		}

	public HashMap<String, String> getFullComList() {
		return fullComList;
	}

	public void setFullComList(HashMap<String, String> fullComList) {
		this.fullComList = fullComList;
	}

	
	public HashMap<String, String> getT6() {
		return t6;
	}

	public void setT6(HashMap<String, String> t6) {
		this.t6 = t6;
	}

	public HashMap<String, Location> getFullList() {
		return fullList;
	}

	public void setFullList(HashMap<String, Location> fullList) {
		this.fullList = fullList;
	}

	public Container(){
		
	}

	public ArrayList<SingleFile> getStock() {
		return stock;
	}

	public void setStock(ArrayList<SingleFile> stock) {
		this.stock = stock;
	}
	public void addStock(SingleFile file){
		this.stock.add(file);
	}
	
	public ArrayList<String> getMisUdsList(){
		return this.misUdsList;
	}
	
	public void addMisUdsList(String e){
		this.misUdsList.add(e);
	}
	
	public ArrayList<Company> getCompanyList() {
		return companyList;
	}

	public void addCompany(Company e) {
		this.companyList.add(e);
		
	}
	public void addLocation(String name,String suffix){
		this.locationList.put(name, suffix);
	}
	public HashMap<String,String> getLocationList(){
		return this.locationList;
	}
	public void addEthnic(String name){
		this.ethnicList.add(name);
	}
	public ArrayList<String> getEthnicList(){
		return this.ethnicList;
	}
	public void addSuffix(String name){
		this.addSuffix.add(name);
	}
	public ArrayList<String> getAddSuffix(){
		return this.addSuffix;
	}
}
