

import java.util.ArrayList;

public class Company {
	private String fullName;
	
	private ArrayList<subName> subList = new ArrayList<>();
	
	public ArrayList<subName> getSubList() {
		return subList;
	}
	public void setSubList(ArrayList<subName> subList) {
		this.subList = subList;
	}
	private String firstName;
	private ArrayList<String> locName1 = new ArrayList<String>();
	private ArrayList<String> comName1 = new ArrayList<String>();
	private ArrayList<String> locName2 = new ArrayList<String>();
	private ArrayList<String> comName2 = new ArrayList<String>();
	private ArrayList<String> ethnic = new ArrayList<String>();
	private ArrayList<String> addSuffix = new ArrayList<String>();
	private ArrayList<String> flag = new ArrayList<>();
	private String flag1=" ";
	public Company(){
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setFlag(){
		//this.flag.add("有歧义");
		this.flag1="有歧义";
	}
	public String getFlag(){
		return this.flag1;
	}
	public ArrayList<String> getEthnic() {
		return ethnic;
	}
	public void setEthnic(ArrayList<String> ethnic) {
		this.ethnic = ethnic;
	}
	public ArrayList<String> getAddSuffix() {
		return addSuffix;
	}
	public void setAddSuffix(ArrayList<String> addSuffix) {
		this.addSuffix = addSuffix;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public ArrayList<String> getLocName1() {
		return locName1;
	}
	public ArrayList<String> getLocName2() {
		return locName2;
	}
	public void setLocName1(ArrayList<String> locName) {
		this.locName1 = locName;
	}
	public void setLocName2(ArrayList<String> locName) {
		this.locName2 = locName;
	}
	public ArrayList<String> getComName1() {
		return comName1;
	}
	public ArrayList<String> getComName2() {
		return comName2;
	}
	public void setComName1(ArrayList<String> comName) {
		this.comName1 = comName;
	}
	public void setComName2(ArrayList<String> comName) {
		this.comName2 = comName;
	}
	public void addLocName1(String e){
		this.locName1.add(e);
	}
	public void addComName1(String e){
		this.comName1.add(e);
	}
	public void addLocName2(String e){
		this.locName2.add(e);
	}
	public void addComName2(String e){
		this.comName2.add(e);
	}
	public void addEthnic(String e){
		this.ethnic.add(e);
	}
	public void addSuffix(String e){
		this.addSuffix.add(e);
	}
}
