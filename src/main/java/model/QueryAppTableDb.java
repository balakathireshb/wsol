package model;

public class QueryAppTableDb {
	private Integer queryId;
	private String appName;
	private Integer tableId;
	private String tableName;
	private String dbName;
	public QueryAppTableDb(Integer queryId, String appName, Integer tableId, String tableName, String dbName) {
		super();
		this.queryId = queryId;
		this.appName = appName;
		this.tableId = tableId;
		this.tableName = tableName;
		this.dbName = dbName;
	}
	public Integer getQueryId() {
		return queryId;
	}
	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	
	

}
