package datamine;

/**
 *
 * @author Vishma
 */

public class DataRow
{
	 private String distribution_chanel;
	 private String booking_date; 
	 private String dep_date;
	 private String action;
	 private String user_name;
	 private String pax;
	 private String nights;
	 private String city;
	 private String country;
	 private String code;
	 
	 
	public String getDistribution_chanel()
	{
		return distribution_chanel;
	}
	public void setDistribution_chanel( String distribution_chanel )
	{
		this.distribution_chanel = distribution_chanel;
	}
	public String getSearch_date()
	{
		return booking_date;
	}
	public void setSearch_date( String search_date )
	{
		this.booking_date = search_date;
	}
	public String getDep_date()
	{
		return dep_date;
	}
	public void setDep_date( String dep_date )
	{
		this.dep_date = dep_date;
	}
	public String getAction()
	{
		return action;
	}
	public void setAction( String action )
	{
		this.action = action;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name( String user_name )
	{
		this.user_name = user_name;
	}
	public String getPax()
	{
		return pax;
	}
	public void setPax( String pax )
	{
		this.pax = pax;
	}
	public String getNights()
	{
		return nights;
	}
	public void setNights( String nights )
	{
		this.nights = nights;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity( String city )
	{
		this.city = city;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry( String country )
	{
		this.country = country;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode( String code )
	{
		this.code = code;
	}
	
	
	public DataRow( String distribution_chanel, String search_date, String dep_date, String action, String user_name, String pax, String nights, String city, String country, String code )
	{
		
		this.distribution_chanel = distribution_chanel;
		this.booking_date = search_date;
		this.dep_date = dep_date;
		this.action = action;
		this.user_name = user_name;
		this.pax = pax;
		this.nights = nights;
		this.city = city;
		this.country = country;
		this.code = code;
	}
	
	
}
