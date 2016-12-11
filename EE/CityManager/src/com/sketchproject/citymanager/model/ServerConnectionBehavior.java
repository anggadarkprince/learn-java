package com.sketchproject.citymanager.model;

import java.sql.Connection;

/**
 *	ServerConnectionBehavior allows polymorphic database connections. 
 *
 */
public interface ServerConnectionBehavior 
{
	Connection getConnection();
	String getConnectionURL();
	String getConnectionDetails();
	String getTablesSchemaQuery();
}
