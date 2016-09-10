<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.*, logic.*, java.util.*"%>
<%
	AnalysisController analysisController = AnalysisController.getInstance();
	HashMap<Integer, QueryDetails> queryTableMap = analysisController.getOracleQueryTableMap();
	GraphManager gm = analysisController.getGraphManager(AnalysisController.dbOracle);
	HashSet<TreeSet<String>> optimizedGraphData = gm.generateGraphData(GraphManager.graphOptmized);
	HashSet<TreeSet<String>> unOptimizedGraphData = gm.generateGraphData(GraphManager.graphNonOptmized);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script id="tinyhippos-injected">
	if (window.top.ripple) {
		window.top.ripple("bootstrap").inject(window, document);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WSol</title>
</head>
<body>
	<style>
button {
	margin: 4px;
	cursor: pointer;
	font-size: 70%; font-family; arial ,sans-serif;
	margin-right: 5px
}
</style>
	<header> <%@include file="header.jsp"%>
	</header>
	<div>
		<%
			out.print("# of queries with hitting Oracle tables: " + queryTableMap.size()+"<br>");
			out.print("# of queries with single table name: " + gm.getQueriesWithSingleTableName().size()+"<br>");
			out.print("# of queries with multi table names: " + gm.getQueriesWithMultiTableNames().size()+"<br>");
			out.println("# of unique table names from single table queries but not in multi table queries: "
					+ gm.getUniqTabsFromSingleMinusMultiTabQueries().size()+"<br>");
			out.print("Unique table names from single table queries but not in multi table queries: " + gm.getUniqTabsFromSingleMinusMultiTabQueries()+"<br>");
			out.println("# of unique table names from multi table queries: " + gm.getUniqTabNameFromMultiTabQueries().size()+"<br>");
			out.print("Unique table names from multi table queries:" + gm.getUniqTabNameFromMultiTabQueries()+"<br>");
			
		%>
	</div>
	<section>
	
	
	<br>
	<textarea id="graphviz_data" rows="20" cols="80" width="100%"
		wrap="off">
graph G {
rankdir=TP;
	size="10,10"
<%out.print(gm.generateGraph(unOptimizedGraphData));
%>
  
}
</textarea>
	<p>
		<button id="generate_btn" style="font-size: 120%">Generate Graph!</button>
	</p>
	<div id="graphviz_svg_div">
		<!-- Target for dynamic svg generation -->
	</div>
</section>
	<!-- Defer loading of javascript by placing these tags at the tail end of the document -->
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/jquery.min.js">
		
	</script>
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/oraclesite.js"></script>
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/viz.js">
		
	</script>
	<script type="bogus" id="graph_data_text">
graph g {
  size="10,10"
  labelloc=t      
  node [style=filled]
<%out.print(gm.generateGraph(unOptimizedGraphData));
%>
  
}
</script>
<footer><hr><p> @copyrighted Impiger Technologies <p></footer>
</body>
</html>