package com.leon.dand.http;

import java.util.*;

public class HttpResponse
{
	
	private String serverId;  //Dand1.0
	private String httpVersion;  //HTTP/1.0  
	private Integer code;
	private Date date;
	private String codeInfo;
	private String contentMimeType;
	private Integer contentLength;
	private byte[] contentBytes;

	public HttpResponse(String serverId, String httpVersion){
		this.serverId = serverId;
		this.httpVersion = httpVersion;
	}

	public void setServerId(String serverId)
	{
		this.serverId = serverId;
	}

	public String getServerId()
	{
		return serverId;
	}

	public void setHttpVersion(String httpVersion)
	{
		this.httpVersion = httpVersion;
	}

	public String getHttpVersion()
	{
		return httpVersion;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}

	public Integer getCode()
	{
		return code;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Date getDate()
	{
		return date;
	}

	public void setCodeInfo(String codeInfo)
	{
		this.codeInfo = codeInfo;
	}

	public String getCodeInfo()
	{
		return codeInfo;
	}

	public void setContentMimeType(String contentMimeType)
	{
		this.contentMimeType = contentMimeType;
	}

	public String getContentMimeType()
	{
		return contentMimeType;
	}

	public void setContentLength(Integer contentLength)
	{
		this.contentLength = contentLength;
	}

	public Integer getContentLength()
	{
		return contentLength;
	}

	public void setContentBytes(byte[] contentBytes)
	{
		this.contentBytes = contentBytes;
	}

	public byte[] getContentBytes()
	{
		return contentBytes;
	}
}
