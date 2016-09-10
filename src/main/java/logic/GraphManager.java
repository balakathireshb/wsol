package logic;

import java.util.*;

import model.QueryDetails;

public class GraphManager {
	public static final int graphOptmized = 2;
	public static final int graphNonOptmized = 1;

	private HashMap<Integer, TreeSet<String>> queriesWithMultiTableNames = new HashMap<>();
	private HashMap<Integer, String> queriesWithSingleTableName = new HashMap<>();
	private TreeSet<String> uniqTabNameFromSingleTabQueries = new TreeSet<>();
	private TreeSet<String> uniqTabNameFromMultiTabQueries = new TreeSet<>();
	private TreeSet<String> uniqTabsFromSingleMinusMultiTabQueries = new TreeSet<>();
	

	public GraphManager(HashMap<Integer, QueryDetails> queryTableMap) {
		analyzeTabeSetsInQueries(queryTableMap);
	}

	private void analyzeTabeSetsInQueries(HashMap<Integer, QueryDetails> queryTableMap) {
		Iterator it = queryTableMap.keySet().iterator();
		// 1. split queries into two categories: single table queries and multi
		// table queries
		while (it.hasNext()) {
			Integer queryId = (Integer) it.next();
			Set<String> tableNames = queryTableMap.get(queryId).getTableSet();
			if (tableNames.size() > 1) {// add to graph
				queriesWithMultiTableNames.put(queryId, new TreeSet<String>(tableNames));
				uniqTabNameFromMultiTabQueries.addAll(tableNames);
			} else { // just add to a set and show as list
				String tableName = tableNames.iterator().next();
				queriesWithSingleTableName.put(queryId, tableName);
				uniqTabNameFromSingleTabQueries.add(tableName);
			}
		}
		uniqTabsFromSingleMinusMultiTabQueries = new TreeSet<>(uniqTabNameFromSingleTabQueries);
		uniqTabsFromSingleMinusMultiTabQueries.removeAll(uniqTabNameFromMultiTabQueries);
		System.out.println("#Queries with single table names:" + queriesWithSingleTableName.size());
		System.out
				.println("# of unique table names from single table queries:" + uniqTabNameFromSingleTabQueries.size());
		System.out.println("Unique table names from single table queries:" + uniqTabNameFromSingleTabQueries);

		System.out.println("#Queries with multi table names:" + queriesWithMultiTableNames.size());
		System.out
				.println("# of unique table names from multi table queries:" + uniqTabNameFromMultiTabQueries.size());
		System.out.println("Unique table names from single table queries:" + uniqTabNameFromMultiTabQueries);
		System.out
		.println("# of unique table names from single minus multi table queries:" + uniqTabsFromSingleMinusMultiTabQueries.size());
System.out.println("Unique table names from single minus table queries:" + uniqTabsFromSingleMinusMultiTabQueries);


	}

	private HashSet<TreeSet<String>> getTableSetsForGraphGeneration(int graphType) {
		HashSet<TreeSet<String>> unOptimizedTableSets = new HashSet<>(queriesWithMultiTableNames.values());
		System.out.println("#of unoptimized set of tables:" + unOptimizedTableSets.size());
		System.out.println("unoptimized set of tables:" + unOptimizedTableSets);

		if (graphType == graphNonOptmized) {
			return unOptimizedTableSets;
		} else {
			return optimizedTableSets(unOptimizedTableSets);
		}
	}

	private HashSet<TreeSet<String>> optimizedTableSets(HashSet<TreeSet<String>> unOptimizedTableSets) {
		HashSet<TreeSet<String>> optimizedTableSets = new HashSet<>();
		for (TreeSet<String> tableSet : unOptimizedTableSets) {
			// find all the table sets in optimized sets which are having any table names from this set
			List<TreeSet<String>> optSetsWithTablesFromUnOptTableSet = new ArrayList<>();
			for (String tableName : tableSet) {
				for (TreeSet<String> optimizedTableSet : optimizedTableSets) {
					if (optimizedTableSet.contains(tableName)) {
						optSetsWithTablesFromUnOptTableSet.add(optimizedTableSet);
					}
				}
			}
			//remove the identified sets from the optmized sets
			optimizedTableSets.removeAll(optSetsWithTablesFromUnOptTableSet);
			
			//now collate the identified sets and form a new one along with current un optimized table set
			TreeSet<String> newOptimizedSet = new TreeSet<>();
			for (TreeSet<String> identifiedSet : optSetsWithTablesFromUnOptTableSet) {
				newOptimizedSet.addAll(identifiedSet);
			}
			newOptimizedSet.addAll(tableSet);
			
			//add this new optmied set to optmized sets
			optimizedTableSets.add(tableSet);	
		} 
		System.out.println("#of optimized set of tables:" + optimizedTableSets.size());
		System.out.println("optimized set of tables:" + optimizedTableSets);

		return optimizedTableSets;
	}

	public HashSet<TreeSet<String>> generateGraphData(int graphType) {
		HashSet<TreeSet<String>> graphData = getTableSetsForGraphGeneration(graphType);
		
		return graphData;
	}
	
	public String generateGraph(HashSet<TreeSet<String>> graphData) {
		StringJoiner graph = new StringJoiner("\n");
		for (TreeSet<String> tableSet : graphData) {
			Iterator<String> it = tableSet.iterator();
			String joins = "{" + it.next() + "}"; // first name
			while (it.hasNext()) { // if there are more
				joins = "{" + joins + "--" + it.next() + "}";
			}
			graph.add(joins);
		}
		return graph.toString();
		
	}

	public HashMap<Integer, TreeSet<String>> getQueriesWithMultiTableNames() {
		return queriesWithMultiTableNames;
	}

	public HashMap<Integer, String> getQueriesWithSingleTableName() {
		return queriesWithSingleTableName;
	}

	public TreeSet<String> getUniqTabNameFromMultiTabQueries() {
		return uniqTabNameFromMultiTabQueries;
	}

	public TreeSet<String> getUniqTabsFromSingleMinusMultiTabQueries() {
		return uniqTabsFromSingleMinusMultiTabQueries;
	}
	
	

}
