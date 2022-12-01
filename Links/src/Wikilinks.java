    import java.util.Scanner;
	import java.util.List;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class Wikilinks 
	{
	   public static void main( String args[] )
	   {

	 //Code snippet to get the number between 1 to 20 from the user
	 Scanner myInput = new Scanner(System.in);
	 int n;
	 System.out.print( "Enter a number between 1 to 20: \n" );
	 n = myInput.nextInt();
	 System.out.printf( "The number of iterations is:  %d\n", n );

	//For loop for the repetition of the Wiki url launch for 'n' cycles
	 for(int j=0;j<n;j++)  
	 {
	     //Code snippet to get the wiki link input from the user
	        System.out.print("Enter a wiki url : \n");
	        Scanner scanner = new Scanner(System. in);
	        String inputString = scanner. nextLine();
	        System.out.println("The Wiki URL read from the console is : \n"+inputString);
	     
	        //Code snippet to validate whether the wiki link is valid or not
	        if(inputString.contains("https://en.wikipedia.org/wiki/"))
	        {
	     
	        //Code snippet to launch the valid wiki url
	        System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get(inputString);
	        boolean status = driver.findElement(By.xpath("//body/div/div[3]/div[text()='From Wikipedia, the free encyclopedia']")).isDisplayed();
	        System.out.println("The status is : "+status);

	        if(status)
	        {
	        System.out.println("The Wiki Link is valid");
	        driver.get(inputString);
	       
	   //Code snippet to repeat the step 3 for 2 times
	        for (int i=1;i<=2; i++)
	        {
	        List<WebElement> links = driver.findElements(By.tagName("a"));
	        int Linkscount = links.size();
	        System.out.println("Total number of links available in the page are: "+Linkscount);
	        for(WebElement link: links)
	        {
	        System.out.println(link.getAttribute("href"));
	         
	        }  
	        }
	     driver.quit();
	        }
	      }
	else
	{
	System.out.println("Link is Invalid");
	}
	}
	}
	}
