package pack1;

import java.io.File;


import jxl.Sheet;
import jxl.Workbook;

public class C8 {

	public static Object[][] ReadData() throws Throwable, Throwable {
		Object[][] data = null;
		File f = new File(System.getProperty("user.dir") + "\\resources\\Data1.xls");

		Workbook wb = Workbook.getWorkbook(f);

		Sheet ws = wb.getSheet("Login");

		int rowCount = ws.getRows();
		int columnCount = ws.getColumns();
		System.out.println(rowCount);
		System.out.println(columnCount);

		// initializing the array size with the help of row and column count (no of
		// records-1 and avoiding the field name reading)
		data = new Object[rowCount - 1][columnCount];

		for (int i = 1; i <= rowCount - 1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				data[i - 1][j] = ws.getCell(j, i).getContents();
				// Syst1em.out.println(data[i][j]);
				j = j + 1;
				data[i - 1][j] = ws.getCell(j, i).getContents();
				// System.out.println(data[i][j]);
			}
		}
		wb.close();

		System.out.println("data is read successfully");
		return data;
	}

	public static void main(String[] args) throws Throwable {

		Object[][] fetchedData = ReadData();
		System.out.println(fetchedData.length);
		System.out.println(fetchedData[0].length);

		for (int i = 0; i <= fetchedData.length - 1; i++) {
			for (int j = 0; j <= fetchedData[0].length - 1; j++) {

				String username = (String) fetchedData[i][j];
				System.out.println(username);
				j = j + 1;
				String password = (String) fetchedData[i][j];
				System.out.println(password);

			}
		}

	}

}
