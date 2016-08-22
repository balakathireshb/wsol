package logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

import model.*;

public class QueryManager {

	public HashMap<Integer, HashSet<String>> getQueryTableDetails() {
		HashMap<Integer, HashSet<String>> queryTableMap = new HashMap<Integer, HashSet<String>>();
		QuerytableHome qth = new QuerytableHome();
		List<Querytable> querytables = qth.findAll();
		System.out.print(querytables.size());
		for (Querytable querytable : querytables) {
			Integer queryID = querytable.getQueryid();
			String tableName = querytable.getTablename();
			if (!queryTableMap.containsKey(queryID)) { // if not present add new
														// set
				queryTableMap.put(queryID, new HashSet<String>());
			}
			HashSet<String> tablesSet = queryTableMap.get(queryID);
			tablesSet.add(tableName);
		}

		System.out.println("#of queries with tables:"+queryTableMap.size());

		return queryTableMap;

	}

	public static void main(String[] arg) {
		QueryManager qm = new QueryManager();
		HashMap<Integer, HashSet<String>> queryTableMap = qm.getQueryTableDetails();
		SortedSet<String> tablesWithoutJoins = new TreeSet<String>();
		StringJoiner graph = new StringJoiner("\n");
		Iterator it = queryTableMap.keySet().iterator();
		while (it.hasNext()) {
			Integer queryId = (Integer) it.next();
			HashSet<String> tableNames = queryTableMap.get(queryId);
			if (tableNames.size() > 1) {// add to graph
				Iterator<String> it1 = tableNames.iterator();
				String joins = "{" + it1.next() + "}"; // first name
				while (it1.hasNext()) { // if there are more
					joins = "{" + joins + "--" + it1.next() + "}";

				}
				graph.add(joins);
			} else { // just add to a set and show as list
				tablesWithoutJoins.add(tableNames.iterator().next());
			}

		}
		System.out.println(tablesWithoutJoins.toString());
		System.out.println(graph.toString());
	}

}
