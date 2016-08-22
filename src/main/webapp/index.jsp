<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.*, logic.*, java.util.*"%>
<%
	QueryManager qm = new QueryManager();
	String graphData = qm.getGraphData();
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
<title>Insert title here</title>
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
	Welcome to WSOL!
	<br>
	<button id="getTablesData1_btn">Get Tables Data</button>
	<br>
	<textarea id="graphviz_data" rows="20" cols="80" width="100%"
		wrap="off">
digraph G {
  
}
</textarea>
	<p>

		<button id="generate_btn" style="font-size: 120%">Generate
			Graph!</button>

	</p>
	<div id="graphviz_svg_div">
		<!-- Target for dynamic svg generation -->
	</div>
	<!-- Defer loading of javascript by placing these tags at the tail end of the document -->
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/jquery.min.js">
		
	</script>
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/site.js"></script>
	<script language="javascript" type="text/javascript"
		src="js/webgraphviz/viz.js">
		
	</script>
	<script type="bogus" id="tablesData_text">
graph minimal_nonplanar_graphs {
  size="4,4"

  labelloc=t           label="Minimal nonplanar graphs (9 edges / 5 nodes)"
  node [style=filled]

  subgraph cluster_0 {
    label="Oracle"  color=lightblue  style=filled
    node [color=white]
    {A B C} -- {D E F}
  }

  subgraph cluster_1 {
    label="MySQL"  color=blue
    node [color=yellow  shape=box]
    1 -- {2 -- {3 -- {4 -- 5}}}} 
  }
}
</script>
</body>
</html>