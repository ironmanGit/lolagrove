/**
 * @Author Vivekanandan Sampath
 * @Date Mar 09, 2020
 */
package controllers;


import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfigReader 
{
	
	public ApplicationConfigReader()
	{
		PropertyLoader.newInstance().populate(this);
	}
	
	@Property(value = "Browser")
	private String Browser;
	
	@Property(value="Url")
	private String WebsiteUrl;
	
	@Property(value="MaxPageLoadTime")
	private int MaxPageLoadTime;
	
	@Property(value="Username")
	private String Username;
	
	@Property(value="Password")
	private String Password;
	
	@Property(value="Campaign")
	private String Campaign;
	
	@Property(value="ImplicitlyWait")
	private int ImplicitlyWait;
	
	public String getBrowser() {
		return Browser;
	}
	
	public String getUsername() {
		return Username;
	}

	public String getPassword() {
		return Password;
	}

	public String getCampaign() {
		return Campaign;
	}

	public String getWebsiteUrl() {
		return WebsiteUrl;
	}

	public int getMaxPageLoadTime() {
		return MaxPageLoadTime;
	}

	public int getImplicitlyWait() {
		return ImplicitlyWait;
	}

}
