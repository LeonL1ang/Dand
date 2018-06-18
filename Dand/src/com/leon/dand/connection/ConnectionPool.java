package com.leon.dand.connection;
import java.util.*;

public class ConnectionPool
{
	
	private static Set<Connection> conSet = null;

	
	static{
		conSet = Collections.synchronizedSet(new HashSet<Connection>());
	}
	
	public static void addConnection(Connection con)
	{
		conSet.add(con);
	}

	public static void removeConnection(Connection con){
		conSet.remove(con);
	}
	
	public static Set<Connection> getConSet()
	{
		return conSet;
	}
	
}
