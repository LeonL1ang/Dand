package com.leon.dand.http;

public class HttpRequest {

	private String method;// 请求方法   
	private String requestURL;   
	private String requestURI;//请求的URI地址 在HTTP请求的第一行的请求方法后面   
	private String host;//请求的主机信息   
	private String connection;//Http请求连接状态信息 对应HTTP请求中的Connection   
	private String agent;// 代理，用来标识代理的浏览器信息 ,对应HTTP请求中的User-Agent:   
	private String language;//对应Accept-Language   
	private String encoding;//请求的编码方式 对应HTTP请求中的Accept-Encoding   
	private String charset;//请求的字符编码 对应HTTP请求中的Accept-Charset   
	private String accept;
	private Integer contentLength;
	
	private String entityBody;

	public void setContentLength(Integer contentLength)
	{
		this.contentLength = contentLength;
	}

	public Integer getContentLength()
	{
		return contentLength;
	}//实体部分

	public void setEntityBody(String entityBody)
	{
		this.entityBody = entityBody;
	}

	public String getEntityBody()
	{
		return entityBody;
	}

	public void setConnection(String connection)
	{
		this.connection = connection;
	}

	public String getConnection()
	{
		return connection;
	}

	public void setRequestURL(String requestURL)
	{
		this.requestURL = requestURL;
	}

	public String getRequestURL()
	{
		return requestURL;
	}

	public void setRequestURI(String requestURI)
	{
		this.requestURI = requestURI;
	}

	public String getRequestURI()
	{
		return requestURI;
	}

	public void setHost(String host)
	{
		this.host = host;
	}

	public String getHost()
	{
		return host;
	}

	public void setAgent(String agent)
	{
		this.agent = agent;
	}

	public String getAgent()
	{
		return agent;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getLanguage()
	{
		return language;
	}

	public void setEncoding(String encoding)
	{
		this.encoding = encoding;
	}

	public String getEncoding()
	{
		return encoding;
	}

	public void setCharset(String charset)
	{
		this.charset = charset;
	}

	public String getCharset()
	{
		return charset;
	}

	public void setAccept(String accept)
	{
		this.accept = accept;
	}

	public String getAccept()
	{
		return accept;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public String getMethod()
	{
		return method;
	}

	@Override
	public String toString()
	{
		return method+"--->"+requestURL+accept+charset+language+connection;
	}
	
}
