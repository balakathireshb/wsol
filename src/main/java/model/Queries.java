package model;
// Generated Aug 21, 2016 7:59:02 PM by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;

/**
 * Queries generated by hbm2java
 */
public class Queries implements java.io.Serializable {

	private Integer id;
	private Integer appQueryId;
	private String appname;
	private String filename;
	private String query;
	private Set<Querytable> querytables = new HashSet<Querytable>(0);

	public Queries() {
	}

	public Queries(String appname) {
		this.appname = appname;
	}

	public Queries(Integer appQueryId, String appname, String filename, String query, Set<Querytable> querytables) {
		this.appQueryId = appQueryId;
		this.appname = appname;
		this.filename = filename;
		this.query = query;
		this.querytables = querytables;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAppQueryId() {
		return this.appQueryId;
	}

	public void setAppQueryId(Integer appQueryId) {
		this.appQueryId = appQueryId;
	}

	public String getAppname() {
		return this.appname;
	}

	public void setAppname(String appname) {
		this.appname = appname;
	}

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getQuery() {
		return this.query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Set<Querytable> getQuerytables() {
		return this.querytables;
	}

	public void setQuerytables(Set<Querytable> querytables) {
		this.querytables = querytables;
	}

}