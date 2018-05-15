package pack1;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class TC1_Login2 {

	@DataProvider(name="loginData")
	public static Object[][] ReadData() throws Throwable, Throwable {
		Object[][] data = null;
		File f = new File(System.getProperty("user.dir") + "\\resources\\Data1.xls");

		Workbook wb = Workbook.getWorkbook(f);

		Sheet ws = wb.getSheet("Login");

		int rowCount = ws.getRows();
		int columnCount = ws.getColumns();
		System.out.println(rowCount);
		System.out.println(columnCount);
		
		//initializing the array size with the help of row and column count  (no of records-1 and avoiding the field name reading)
		data = new Object[rowCount-1][columnCount];

		for (int i = 1; i <= rowCount - 1; i++) {
			for (int j = 0; j <= columnCount - 1; j++) {
				data[i-1][j] = ws.getCell(j, i).getContents();
				// Syst1em.out.println(data[i][j]);
				j = j + 1;
				data[i-1][j] = ws.getCell(j, i).getContents();
				// System.out.println(data[i][j]);
			}
		}
		wb.close();

		return data;
	}

	@Test(dataProvider="loginData")
	public static void login(String username,String password) throws Throwable {


				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\lib\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();

				// accessing the qahrm project home page
				driver.get("http://apps.qaplanet.in/qahrm/login.php");

				// statements to perform login action
				driver.findElement(By.name("txtUserName")).sendKeys(username);
				driver.findElement(By.name("txtPassword")).sendKeys(password);
				driver.findElement(By.name("Submit")).click();
				Thread.sleep(5000);

				// statements to perform logout action
				driver.findElement(By.linkText("Logout")).click();

				// statements to quit the browser
				driver.quit();
		
	}

}
