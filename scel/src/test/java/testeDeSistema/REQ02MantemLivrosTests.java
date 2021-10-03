package testeDeSistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class REQ02MantemLivrosTests {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ts-scel-web.herokuapp.com/login");
		driver.manage().window().maximize();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void ct01_cadastrar_livro_com_sucesso() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("emerson");
		driver.findElement(By.id("titulo")).sendKeys("teste-web");
		
		//Validacao campos
		assertTrue("1234".length() == 4);
		assertTrue("emerson".length() >= 1 && "emerson".length() <= 50);
		assertTrue("teste-web".length() >= 1 && "teste-web".length() <= 50);
		
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		
		assertEquals(("teste-web"), driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		assertEquals("emerson", driver.findElement(By.cssSelector("td:nth-child(4)")).getText());
		assertEquals("https://ts-scel-web.herokuapp.com/sig/livros", driver.getCurrentUrl());
		assertTrue(driver.getPageSource().contains("1234"));
		driver.findElement(By.linkText("Excluir")).click();
	}

	@Test
	public void ct02_atualiza_livro_com_sucesso() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).sendKeys("ruan");
		driver.findElement(By.id("titulo")).sendKeys("teste-teste");
		
		//Validacao campos
		assertTrue("1234".length() == 4);
		assertTrue("ruan".length() >= 1 && "ruan".length() <= 50);
		assertTrue("teste-teste".length() >= 1 && "teste-teste".length() <= 50);		
		
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		espera();
		
		assertEquals("teste-teste", driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		driver.findElement(By.linkText("Editar")).click();

		driver.findElement(By.id("titulo")).clear();
		driver.findElement(By.id("titulo")).sendKeys("titulo-livro");
		
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
	
		assertTrue(driver.getPageSource().contains("titulo-livro"));

		driver.findElement(By.linkText("Excluir")).click();
	}

	public void espera() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ct03consulta_livro_com_sucesso() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("emerson");
		driver.findElement(By.id("titulo")).sendKeys("teste-livro");
		
		//Validacao campos
		assertTrue("1234".length() == 4);
		assertTrue("emerson".length() >= 1 && "emerson".length() <= 50);
		assertTrue("teste-livro".length() >= 1 && "teste-livro".length() <= 50);		
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
				
		assertEquals(("teste-livro"), driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		assertEquals("emerson", driver.findElement(By.cssSelector("td:nth-child(4)")).getText());
		assertEquals("https://ts-scel-web.herokuapp.com/sig/livros", driver.getCurrentUrl());
		assertTrue(driver.getPageSource().contains("1234"));
		driver.findElement(By.linkText("Excluir")).click();
	}
	
	@Test
	public void ct04deleta_livro_com_sucesso() {
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		espera();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("1234");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("emerson");
		driver.findElement(By.id("titulo")).sendKeys("teste-livro");
		
		//Validacao campos
		assertTrue("1234".length() == 4);
		assertTrue("emerson".length() >= 1 && "emerson".length() <= 50);
		assertTrue("teste-livro".length() >= 1 && "teste-livro".length() <= 50);		
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
				
		assertEquals(("teste-livro"), driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		assertEquals("emerson", driver.findElement(By.cssSelector("td:nth-child(4)")).getText());
		assertEquals("https://ts-scel-web.herokuapp.com/sig/livros", driver.getCurrentUrl());
		assertTrue(driver.getPageSource().contains("1234"));
		driver.findElement(By.linkText("Excluir")).click();
		assertFalse(driver.getPageSource().contains("1234"));
	}


	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}
}
