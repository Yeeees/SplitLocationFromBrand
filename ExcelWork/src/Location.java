

import java.util.HashMap;

public class Location {
	private String name;
	private String type;
	private String lvl;
	//Location parent = new Location();
	Location parent = null;
	HashMap<String,Location> children = new HashMap<>();
	public Location(){
//		if(lvl.equals("T1"))
//			parent = null;
		
	}
	public void addChild(String name,Location loc){
		try{
		children.put(name, loc);}
		catch(Exception e){
			System.out.println(e);
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public Location getParent() {
		return parent;
	}
	public void setParent(Location parent) {
		this.parent = parent;
	}
	public HashMap<String, Location> getChildren() {
		return children;
	}
	public void setChildren(HashMap<String, Location> children) {
		this.children = children;
	}
	
}
