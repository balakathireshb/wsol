package model;

import java.util.*;

public class QueryDetails {
	private Integer queryId;
	private String appName;
	private Set<String> tableSet = new HashSet<> ();
	private String dbName;
	
	public QueryDetails(Integer queryId) {
		this.queryId = queryId;
		
	}

	public void addQueryTableDetails(QueryAppTableDb queryAppTableDb) {
		this.appName = queryAppTableDb.getAppName();
		this.dbName = queryAppTableDb.getDbName();
		this.tableSet.add(queryAppTableDb.getTableName());
		
	}
	
	public Set<String> getTableSet() {
		return this.tableSet;
	}

}
