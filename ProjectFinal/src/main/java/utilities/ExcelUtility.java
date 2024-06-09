package utilities;


	
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
    public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh ; 

	public static String readStringData(int i , int j, String sheet) 
	{
		try {
		file = new FileInputStream("C:\\Users\\Meera Rupak\\git\\ProjectQALegend\\ProjectFinal\\src\\main\\resources\\Test_Data.xlsx");
		wb = new XSSFWorkbook(file);
		sh = wb.getSheet(sheet);
		XSSFRow row = sh.getRow(i);
		XSSFCell cell = row.getCell(j);
		return cell.getStringCellValue();
		} catch (Exception e) {
			throw new RuntimeException("Test data Excel sheet not found");
		}
		}
	
	public static String readIntegerData(int i, int j, String sheet) 
		{
			try {
			file = new FileInputStream("C:\\Users\\Meera Rupak\\git\\ProjectQALegend\\ProjectFinal\\src\\main\\resources\\Test_Data.xlsx");
			wb = new XSSFWorkbook(file);
			sh = wb.getSheet(sheet);
			XSSFRow row = sh.getRow(i);
			XSSFCell cell = row.getCell(j);
			int x = (int) cell.getNumericCellValue();
			return String.valueOf(x); // convert to String.valueof
			}catch(Exception r) {
				throw new RuntimeException("Test data Excel sheet not found");
			}
			}
			
      }



