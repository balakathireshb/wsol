package logic;

import java.util.*;


import model.QueryDetails;

public class AnalysisController {
	public static final String dbOracle = "oracle";
	public static final String dbMySQL = "mysql";
	
	private HashMap<Integer, QueryDetails> oracleQueryTableMap;
	private HashMap<Integer, QueryDetails> mySQLQueryTableMap;

	private static AnalysisController analysisController = null;
	
	private AnalysisController() {
		QueryManager qm = new QueryManager();
		oracleQueryTableMap = qm.getOracleQueryTableMap();
		mySQLQueryTableMap = qm.getOracleQueryTableMap();
	}

	public static AnalysisController getInstance() {
		if (analysisController==null) {
			analysisController=new AnalysisController();
		}
		return analysisController;
	}

	public GraphManager getGraphManager(String dbName) {
		GraphManager gm = null;
		if (dbName.equalsIgnoreCase(dbOracle)) {
			gm = new GraphManager(oracleQueryTableMap);
		} else {
			gm = new GraphManager(mySQLQueryTableMap);
		}
		
		return gm;

	}
	
	public HashMap<Integer, QueryDetails> getOracleQueryTableMap() {
		return oracleQueryTableMap;
	}

	public HashMap<Integer, QueryDetails> getMySQLQueryTableMap() {
		return mySQLQueryTableMap;
	}

	public static void main(String[] arg) {
		AnalysisController analysisController = AnalysisController.getInstance();
		GraphManager gm = analysisController.getGraphManager(dbOracle);
		HashSet<TreeSet<String>> optGraphData = gm.generateGraphData(GraphManager.graphOptmized);
		System.out.println(optGraphData);
		
		
		ArrayList l1 = new ArrayList<>();
		
		
	}

}
