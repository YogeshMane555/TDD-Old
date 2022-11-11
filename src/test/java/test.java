import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test {

	public static void main(String[] args) throws Exception {
	
		File f=new File("C:\\Users\\Admin\\Documents\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(f);
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheetAt(0);
		
		int lastrow=sheet.getLastRowNum();
		
		System.out.println("Total Number of ROW :" +lastrow);
		
		for(int i=0; i<lastrow; i++)
		{
			
			String data=sheet.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println("Excel sheet data is : "+ data);
		}
		
	}

}
