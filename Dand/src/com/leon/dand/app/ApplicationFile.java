package com.leon.dand.app;

import java.io.*;

public class ApplicationFile
{
	
	private String fileName;
	private String path;
	private String mime;
	private byte[] fileBytes;
    private Integer fileLength;

	public void setFileLength(Integer fileLength)
	{
		this.fileLength = fileLength;
	}

	public Integer getFileLength()
	{
		return fileLength;
	}
	public void setFileBytes(byte[] fileBytes)
	{
		this.fileBytes = fileBytes;
	}

	public byte[] getFileBytes()
	{
		return fileBytes;
	}
	
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String getPath()
	{
		return path;
	}

	public void setMime(String mime)
	{
		this.mime = mime;
	}

	public String getMime()
	{
		return mime;
	}
	
}
