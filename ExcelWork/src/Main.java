
public class Main {
	public static Container stock = new Container();
	public static void main(String[] args){
		ExcelReader er = new ExcelReader(stock);		
		er.reader();
		BasicBase bb = new BasicBase(stock);
		

		WordsFilter wf = new WordsFilter(stock);
		ExcelReader er2 = new ExcelReader(stock);	
		er2.excelWriter();
		er2.unmodifyCheck();
		//System.out.println(stock.getStock().get(1).getLine().get(3)[0]);
	}
}
