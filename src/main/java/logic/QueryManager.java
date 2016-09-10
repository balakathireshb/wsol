package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.*;
import util.HibernateUtil;

public class QueryManager {
	private HashMap<Integer, QueryDetails> oracleQueryTableMap = new HashMap<Integer, QueryDetails>();
	private HashMap<Integer, QueryDetails> mySQLQueryTableMap = new HashMap<Integer, QueryDetails>();
	

	public  QueryManager() {
		//1. Query the details
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<QueryAppTableDb> queryAppTableDbs = new ArrayList<>();
		try {

			Query query = session.createQuery(
					"select new model.QueryAppTableDb(q.id, q.appname, qt.tableid, qt.tablename, wt.databasename)"
							+ " from Queries as q, Querytable as qt, WsolTables as wt"
							+ " where q.id=qt.queryid and qt.tableid=wt.id");
			queryAppTableDbs = query.list();
			System.out.println("#of query table combinations:" + queryAppTableDbs.size());
		} catch (Exception e) {
			System.out.println(e);
			trans.setRollbackOnly();
		} finally {
			trans.commit();
			session.close();
		}

		//2. Group based on query id for oracle and mysql
		for (QueryAppTableDb queryAppTableDb : queryAppTableDbs) {
			Integer queryId = queryAppTableDb.getQueryId();
			HashMap<Integer, QueryDetails> queryTableMap;
			if (queryAppTableDb.getDbName().equalsIgnoreCase("oracle")) {//oracle
				queryTableMap = oracleQueryTableMap;
			} else {//mysql
				queryTableMap = mySQLQueryTableMap;
			}
			if (!queryTableMap.containsKey(queryId)) { // if not present add new
				queryTableMap.put(queryId, new QueryDetails(queryId));
			}
			QueryDetails queryDetails= queryTableMap.get(queryId);
			queryDetails.addQueryTableDetails(queryAppTableDb);
		}
		System.out.println("#of queries with oracle tables:" + oracleQueryTableMap.size());
		System.out.println("#of queries with mysql tables:" + mySQLQueryTableMap.size());
	}


	public HashMap<Integer, QueryDetails> getOracleQueryTableMap() {
		return oracleQueryTableMap;
	}


	public HashMap<Integer, QueryDetails> getMySQLQueryTableMap() {
		return mySQLQueryTableMap;
	}

	
	

}
