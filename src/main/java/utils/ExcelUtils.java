package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
public class ExcelUtils 
{
	private static XSSFSheet xlsxWorkSheet;
	private static XSSFWorkbook xlsxWorkBook;
	private static XSSFCell xlsxCell;
	@SuppressWarnings("unused")
	private static XSSFRow xlsxRow;

	private static HSSFSheet xlsWorkSheet;
	private static HSSFWorkbook xlsWorkBook;
	private static HSSFCell xlsCell;
	@SuppressWarnings("unused")
	private static HSSFRow xlsRow;

	/** To get the Excel-XLSX File with Path and SheetName */
	public static void getExcelFile(String Path,String SheetName) throws Exception 
	{
		try 
		{
			File file = new File(Path);
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream fis = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(fis);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream fis = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(fis);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);
			}
		} 
		catch (Exception e)
		{
			throw (e);
		}
	}


	/** To Return the Excel-XLSX Values given Path to the File and Sheet Name */
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception
	{   
		Object[][] tabArray = null;
		try
		{
			File file = new File(FilePath);	
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsxRowCount();
				int totalCols = ExcelUtils.xlsxColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLSX(i,j);
						cj++;
					}
					ci++;
				}
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheet(SheetName);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsRowCount();
				int totalCols = ExcelUtils.xlsColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLS(i,j);
						cj++;
					}
					ci++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}


	/** To Return the Excel-XLSX Values given Path to the File */
	public static Object[][] getTableArray(String FilePath) throws Exception
	{   
		Object[][] tabArray = null;
		try
		{
			File file = new File(FilePath);			
			if(file.getAbsolutePath().endsWith(".xlsx"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsxWorkBook = new XSSFWorkbook(ExcelFile);
				xlsxWorkSheet = xlsxWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsxRowCount();
				int totalCols = ExcelUtils.xlsxColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLSX(i,j);
						cj++;
					}
					ci++;
				}
			}
			else if(file.getAbsolutePath().endsWith(".xls"))
			{
				FileInputStream ExcelFile = new FileInputStream(file);
				xlsWorkBook = new HSSFWorkbook(ExcelFile);
				xlsWorkSheet = xlsWorkBook.getSheetAt(0);

				int startRow = 1;
				int startCol = 0;
				int ci,cj;
				int totalRows = ExcelUtils.xlsRowCount();
				int totalCols = ExcelUtils.xlsColumnCount();
				tabArray=new Object[totalRows-1][totalCols];
				ci=0;
				for (int i=startRow;i<totalRows;i++) 
				{           	   
					cj=0;
					for (int j=startCol;j<totalCols;j++)
					{
						tabArray[ci][cj]=getCellData_XLS(i,j);
						cj++;
					}
					ci++;
				}
			}
		}
		catch (FileNotFoundException e)
		{
			throw new Exception("Could not Find the Excel File/Sheet");
		}
		catch (Exception e)
		{
			throw new Exception("Could not Open the Excel File");
		}
		return(tabArray);
	}


	/** To get cell data from Excel-XLSX */
	public static Object getCellData_XLSX(int RowNum, int ColNum) throws Exception
	{
		Object CellData = null;
		try
		{
			xlsxCell = xlsxWorkSheet.getRow(RowNum).getCell(ColNum);
			if(xlsxCell.getCellType() == Cell.CELL_TYPE_STRING )
			{
				String stringCellData = xlsxCell.getStringCellValue();
				CellData = stringCellData;
			}
			/*		else if(xlsxCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				double numericCellData =  xlsxCell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlsxCell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				boolean booleanCellData =  xlsxCell.getBooleanCellValue();
				CellData = booleanCellData;
			}	*/	
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	/** To get cell data from Excel-XLS */
	public static Object getCellData_XLS(int RowNum, int ColNum) throws Exception
	{
		Object CellData = null;
		try
		{
			xlsCell = xlsWorkSheet.getRow(RowNum).getCell(ColNum);
			if(xlsCell.getCellType() == Cell.CELL_TYPE_STRING )
			{
				String stringCellData = xlsCell.getStringCellValue();
				CellData = stringCellData;
			}
			/*		else if(xlsCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
			{
				double numericCellData =  xlsCell.getNumericCellValue();
				CellData = numericCellData;
			}
			else if(xlsCell.getCellType() == Cell.CELL_TYPE_BOOLEAN)
			{
				boolean booleanCellData =  xlsCell.getBooleanCellValue();
				CellData = booleanCellData;
			}	*/	
			return CellData;
		}
		catch (Exception e)
		{
			return"";
		}
	}

	/** To get Excel-XLSX Row Count */
	public static int xlsxRowCount()
	{
		int rowNum = xlsxWorkSheet.getLastRowNum()+1;
		return rowNum;
	}

	/** To get Excel-XLS Row Count */
	public static int xlsRowCount()
	{
		int rowNum = xlsWorkSheet.getLastRowNum()+1;
		return rowNum;
	}

	/** To get Excel-XLSX Column Count */
	public static int xlsxColumnCount()
	{
		int rowNum = xlsxWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}

	/** To get Excel-XLS Column Count */
	public static int xlsColumnCount()
	{
		int rowNum = xlsWorkSheet.getRow(0).getLastCellNum();
		return rowNum;
	}


	public static void writeLinesToFile(String campaignPath, List<String> campaignLead) throws IOException {
		writeLinesToFile(campaignPath, campaignLead, null);
	}


	public static void writeLinesToFile(String campaignPath, List<String> campaignLead, String header) throws IOException {
		boolean noHeader = true;
		if (header != null && !header.isEmpty()) {
			writeToFile(campaignPath, header);
			noHeader = false;
		}
		int i = 0;
		for (String line : campaignLead) {
			i++;
			if(noHeader && i == 1) {
				writeToFile(campaignPath, campaignLead.get(0));
			}
			else {
				appendToFile(campaignPath, line);
			}
		}
		return;
	}


	public static void appendToFile(String campaignPath, String line) throws IOException {
		writeToFile(campaignPath, line, true);		
	}


	public static void writeToFile(String campaignPath, String content) throws IOException {
		writeToFile(campaignPath, content, false);
	}


	public static void writeToFile(String campaignPath, String content, boolean append) throws IOException {
		createFolderForPathName(campaignPath);
		FileWriter fileWriter = new FileWriter(campaignPath, append);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(content+"\n");
		printWriter.close();
	}


	public static void createFolderForPathName(String campaignPath) {
		String[] dirs = campaignPath.replaceAll("\\\\", "/").split("/");
		String path ="";
		int last =dirs.length -1;
		for(int i=0; i < last; i++) {
			String dir = dirs[i];
			path = path.isEmpty() ? dir : path+ "/" + dir;
			createFolder(path);
		}
	}


	public static void createFolder(String folderName) {
		File file = new File(folderName);
		boolean result = false;
		try {
			if (!file.exists()) {
				file.mkdir();
			}
			result = true;
		} catch (SecurityException e) {
			e.printStackTrace();
			throw e;
		}
	}


	public static boolean fileExist(String campaignPath) {
		File file = new File(campaignPath);
		boolean exists = file != null && file.exists();
		return exists;
	}


	public static List<String> readFileToLines(String campaignPath) throws Exception {
		boolean skipCommentLine = false;
		boolean debug = false;
		return readFileToLines(campaignPath, skipCommentLine, 0, 0, debug);
	}


	private static List<String> readFileToLines(String campaignPath, boolean skipCommentLine, Integer lo, Integer hi,
			boolean debug) throws Exception {
		List<String> lines = new ArrayList<String>();

		try {
			if (debug) {
				System.out.println("filename :" + campaignPath);
			}
			BufferedReader br = new BufferedReader(new FileReader(campaignPath));
			int i = 0;
			String line;
			do {
				i++;
				if (hi != null && hi != 0 && i > hi) {
					break;
				}
				line = br.readLine();
				if (debug) {
					System.out.println("lines [" + i + " ] : " + line);
				}

				if (line == null || line.trim().isEmpty()) {
					break;
				}

				if (line.trim().isEmpty()) {
					continue;
				}
				if (skipCommentLine && line.trim().startsWith("#")) {
					continue;
				}
				if (lo != null && i >= lo) {
					lines.add(line);
				}
			} while (line != null);
			br.close();

		} catch (Exception e) {
			throw e;
		}
		return lines;
	}
}