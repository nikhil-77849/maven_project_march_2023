package in.techlift.utils;

import java.io.FileInputStream;

		import java.io.FileNotFoundException;

		import java.io.FileOutputStream;

		import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

		import org.apache.poi.xssf.usermodel.XSSFRow;

		import org.apache.poi.xssf.usermodel.XSSFSheet;

		import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelUtils {

		private static XSSFWorkbook ExcelWorkBook;

    	private static XSSFSheet ExcelWSheet;

		private static XSSFRow Row;

			private static XSSFCell Cell;



		public static Object[][] getTableArray(String FilePath, String SheetName) {

		   String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWorkBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWorkBook.getSheet(SheetName);

			   int startRow = 1;

			   int startCol = 1;

			   int ci,cj;

			   int totalRows = ExcelWSheet.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = 3;

			   // defining the size of array with total number of rows and clomns having data
			   tabArray=new String[totalRows][totalCols];

			   ci=0;// table array row count where we are storing the data


			   // Reading the complete row and column data
			   for (int rowCount=startRow;rowCount<=totalRows;rowCount++, ci++) {

				  cj=0;// table array column count where we are storing the data

				   // This for loop is responsible for reading complete row data i.e
				   // it will go through each column 1 by 1 in the same row
				   for (int colCount=startCol;colCount<=totalCols;colCount++, cj++){

					   try {
						   tabArray[ci][cj]=getCellData(rowCount,colCount);
					   } catch (Exception e) {
						   e.printStackTrace();
					   }

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}

		public static String getCellData(int RowNum, int ColNum) throws Exception {
			String CellData="";
			try{

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

				CellType celltype = Cell.getCellType();

				if  (celltype == CellType.BLANK) {

					return CellData;

				}else{

					CellData = Cell.getStringCellValue();
				}

			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return CellData;

		}

	}