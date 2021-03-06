// Delay loading any function until the html dom has loaded. All functions are
// defined in this top level function to ensure private scope.
jQuery(document).ready(function() {

	// Installs error handling.
	jQuery.ajaxSetup({
		error : function(resp, e) {
			if (resp.status == 0) {
				alert('You are offline!!\n Please Check Your Network.');
			} else if (resp.status == 404) {
				alert('Requested URL not found.');
			} else if (resp.status == 500) {
				alert('Internel Server Error:\n\t' + resp.responseText);
			} else if (e == 'parsererror') {
				alert('Error.\nParsing JSON Request failed.');
			} else if (e == 'timeout') {
				alert('Request timeout.');
			} else {
				alert('Unknown Error.\n' + resp.responseText);
			}
		}
	}); // error:function()

	var graphString = jQuery("#graph_data_text").html().trim();
	
	var generate_btn = jQuery('#generate_btn');
	var svg_div = jQuery('#graphviz_svg_div');
	var graphPartOption = jQuery("#graph_part_id");

	function getSubGraphArray() {
		var graphArr = graphString.split(",");
		//alert("Modification 2");
		var optionVal = graphPartOption.val();
		//alert(optionVal);
		var subGraphArr;
		if (optionVal == 1){
			subGraphArr = graphArr.splice(0, 100);
		} else if (optionVal == 2){
			subGraphArr = graphArr.splice(100, 100);
		} else if (optionVal == 3){
			subGraphArr = graphArr.splice(200, 100);
		} else if (optionVal == 4){
			subGraphArr = graphArr.splice(300, graphArr.length - 300);
		}  
		//alert("graph length after splice:"+graphArr.length);
		return subGraphArr;
	}
	function getGraphText() {
		var subGraphArr = getSubGraphArray();
		var graphPrefix = "graph G {\n" +
				"rankdir=LR;";
		var graph = subGraphArr.join(";\n");
		var graphSuffix = "}";
		var graphText = graphPrefix+graph+graphSuffix; 
		//jQuery("#hiddenText").html(graphText);
		return graphText;//subGraphArr;
	}
	function UpdateGraphviz() {
		// graphviz_data_textarea.val()
		svg_div.html("");
		var data = getGraphText();
		// Generate the Visualization of the Graph into "svg".
		var svg = Viz(data, "svg");
		svg_div.html("<hr>" + svg);
	}

	// Startup function: call UpdateGraphviz
	jQuery(function() {
		// The buttons are disabled, enable them now that this script
		// has loaded.
		generate_btn.removeAttr("disabled").text("Generate Graph!");
	});

	// Bind actions to form buttons.
	generate_btn.click(UpdateGraphviz);

});