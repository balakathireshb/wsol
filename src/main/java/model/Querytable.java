package model;
// Generated Aug 21, 2016 7:59:02 PM by Hibernate Tools 5.1.0.Beta1

/**
 * Querytable generated by hbm2java
 */
public class Querytable implements java.io.Serializable {

	private Integer id;
	private Integer queryid;
	
	private String querytype;
	private String tablename;

	public Querytable() {
	}

	public Querytable(Integer queryid, String querytype, String tablename) {
		this.queryid = queryid;
		this.querytype = querytype;
		this.tablename = tablename;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQueryid() {
		return queryid;
	}

	public void setQueryid(Integer queryid) {
		this.queryid = queryid;
	}

	public String getQuerytype() {
		return this.querytype;
	}

	public void setQuerytype(String querytype) {
		this.querytype = querytype;
	}

	public String getTablename() {
		return this.tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
