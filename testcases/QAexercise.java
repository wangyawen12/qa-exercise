package regressionsuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QAexercise {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/yawenwang/Documents/workspace/selenium/chromedriver");
		
		 driver = new ChromeDriver();
		 
		 driver.get("http://localhost:8000/index.php");
		
		
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 addCategory("Job","Yellow");
		 createTodo("TESTING","Job",14,"Jul","2019");
		 removeTodo("TESTING");
		 
	}

	
  
  
public static void addCategory(String category, String color) {
  
  By addCategoryButton =  By.xpath("//input[@value='Add category']");
  By addCategoryInput = By.name("categorydata");
  
  driver.findElement(addCategoryInput).sendKeys(category);
  
  Select categoryColor = new Select(driver.findElement(By.name("colour")));
  
  categoryColor.selectByVisibleText(color);
  
  driver.findElement(addCategoryButton).click();
   
}
  
  
 public static void createTodo(String todoName, String category, int n, String mon, String year) {
	  
	  
	  By addInput = By.name("data");
	  By addButton = By.xpath("//input[@value='Add']");
	  
	  driver.findElement(addInput).sendKeys(todoName);
		
	  Select dropCategory = new Select(driver.findElement(By.name("category")));
		
	  dropCategory.selectByVisibleText(category);
	  
	  Select dueDay = new Select(driver.findElement(By.name("due_day")));
	  
	  dueDay.selectByIndex(n);
	  
	  Select dueMonth = new Select(driver.findElement(By.name("due_month")));
	  
	  dueMonth.selectByVisibleText(mon);
	  
	  Select dueYear = new Select(driver.findElement(By.name("due_year")));
	  
	  dueYear.selectByVisibleText(year);
	  
	  driver.findElement(addButton).click();
  
  
}
 
 
 public static void completeTodo(String todoName)  {
	  
	  List<WebElement>todoList = driver.findElements(By.xpath("//form[@name='todo']/ul/li"));
	  

       int count = todoList.size();
       for(int i=0;i<count;i++) {
       	
       	if(todoList.get(i).getText().contains(todoName)) {
       		
       		todoList.get(i).findElement(By.tagName("input")).click(); 
       		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       		driver.findElement(By.xpath("//input[@value='Complete']")).click();
       		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       		
       	};

   }
	 
	  
 }
 
 
 
 public static void removeTodo(String todoName)  {
	  
	  List<WebElement>todoList = driver.findElements(By.xpath("//form[@name='todo']/ul/li"));
	  

       int count = todoList.size();
       for(int i=0;i<count;i++) {
       	
       	if(todoList.get(i).getText().contains(todoName)) {
       		
       		todoList.get(i).findElement(By.tagName("input")).click(); 
       		
       		driver.findElement(By.xpath("//input[@value='Remove']")).click();
       		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       		
       		break;
       	};

   }
	 
	  
 }
 
 
 

}