"use strict";
	
	google.charts.load('current', {'packages':['table']});
   	google.charts.load('current', {'packages':['line']});
	
	var chart_divs = window.document.getElementsByClassName("chart_div");
	var table_divs = window.document.getElementsByClassName("table_div"); 
	
	var width = window.screen.width;
	initialize();
	
	(window.document.getElementById("CB_SNR_KA")).addEventListener("click",calculateCB_SNR_KA);
	(window.document.getElementById("CB_SNR_dB")).addEventListener("click",calculateCB_SNR_dB);
	(window.document.getElementById("SNR_dB_SNR_KA")).addEventListener("click",calculateSNR_dB_SNR_KA);
	(window.document.getElementById("deleteResults")).addEventListener("click",clearResults);
	(window.document.getElementById("deleteFields")).addEventListener("click",clearFields);

	var inputs = (window.document.querySelectorAll("input"));
	for(var input of inputs)
		input.addEventListener("focusin",function(){ clearResults(); });
	
	//"αρχικοποίηση" σελίδας, ενδεικτικές τιμές σε μονάδες μέτρησης και πεδία
	function initialize()
	{
		window.document.getElementById("SNRdBinitial").value = -100;
		window.document.getElementById("SNRdBfinal").value = 100; 
		window.document.getElementById("step").value = 10;
	}
	
	//συνάρτηση επιστροφής των δεδομένων των απαραίτητων για τους υπολογισμούς από τα πεδία στην html σαν array
	function getData()
	{
		var SNRdBinitial = parseFloat((parseFloat(window.document.getElementById("SNRdBinitial").value)).toFixed(2)); 
		var SNRdBfinal = parseFloat((parseFloat(window.document.getElementById("SNRdBfinal").value)).toFixed(2)); 
		var step = parseFloat((parseFloat(window.document.getElementById("step").value)).toFixed(2)); 
		
		var data = [SNRdBinitial, SNRdBfinal, step];
		
		return data;
	}
	
	//συνάρτηση υπολογισμού SNR(KA) με δεδομένο SNRtodB
	function getSNRclearNumberHavingSNRtodB(SNRtodB)
	{
		var SNRclearNumber;
		
		SNRclearNumber = Math.pow(10, SNRtodB/10.0);
		
		return SNRclearNumber;
	}

	//συνάρτηση υπολογισμού C/B με δεδομένο SNRtodB
	function getCapacityPerbandwidthHavingSNRtodB(SNRtodB)
	{
		var capacityPerbandwidth;
			
		capacityPerbandwidth = Math.log10(1+Math.pow(10, SNRtodB/10.0))/Math.log10(2);
			
		return capacityPerbandwidth;
	}
	
	//συνάρτηση υπολογισμού C/B για εύρος τιμών SNRdB
	function calculateCBForSNRdBs(SNRdBinitial,SNRdBfinal,step)
	{
		var resultsForManySNRdBs = [];
		for(var SNRdB=SNRdBinitial; SNRdB<=SNRdBfinal; SNRdB+=step)
		{
			var CB = getCapacityPerbandwidthHavingSNRtodB(SNRdB);
			resultsForManySNRdBs.push(CB);
		}
		return resultsForManySNRdBs;
	}
	
	//συνάρτηση υπολογισμού SNRKA για εύρος τιμών SNRdB
	function calculateSNRKAForSNRdBs(SNRdBinitial,SNRdBfinal,step)
	{
		var resultsForManySNRdBs = [];
		for(var SNRdB=SNRdBinitial; SNRdB<=SNRdBfinal; SNRdB+=step)
		{
			var SNRKA = getSNRclearNumberHavingSNRtodB(SNRdB);
			resultsForManySNRdBs.push(SNRKA);
		}
		return resultsForManySNRdBs;
	}
	
	//συνάρτηση υπολογισμού SNR_KA για διάστημα τιμών SNR(KA) με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
	function calculateSNR_dB_SNR_KA()
	{
		clearResultsForOneCalculation(table_divs[0], chart_divs[0]);
		
		var data = getData();
		
		var SNRdBinitial = data[0];
		var SNRdBfinal = data[1];
		var step = data[2];
		
		var SNRKAs = calculateSNRKAForSNRdBs(SNRdBinitial,SNRdBfinal,step);
		
		var widthOfGraph = 600;
		if(width<=500)
		{
			widthOfGraph = 300;
		}
		
			var dataTable = [];
			var SNRdBs = [];
			
			for(var SNRdB=SNRdBinitial; SNRdB<=SNRdBfinal; SNRdB+=step)
			{
				SNRdBs.push(SNRdB);
			}
			for(var i=0; i<SNRdBs.length; i++)
			{
				var tempTable = [SNRdBs[i],SNRKAs[i]];
				dataTable.push(tempTable);
			}
			
			drawTable(dataTable,table_divs[0],"SNR(dB)","number","SNR(KA)","number","no");
						
			drawChartWithOneLine(chart_divs[0],widthOfGraph,"blue","SNR(dB) - SNR(KA)","SNR(dB):οριζόντιος άξονας, SNR(KA):κάθετος άξονας",
			SNRdBs,"number","SNR(dB)",SNRKAs,"number","SNR(KA)"); 
		
	}
	
	//συνάρτηση υπολογισμού C/B για διάστημα τιμών SNR_dB με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
	function calculateCB_SNR_dB()
	{
		clearResultsForOneCalculation(table_divs[1], chart_divs[1]);
		
		var data = getData();
		
		var SNRdBinitial = data[0];
		var SNRdBfinal = data[1];
		var step = data[2];
		
		var CBs = calculateCBForSNRdBs(SNRdBinitial,SNRdBfinal,step);
		
		var widthOfGraph = 600;
		if(width<=500)
		{
			widthOfGraph = 300;
		}
		
			var dataTable = [];
			var SNRdBs = [];
			
			for(var SNRdB=SNRdBinitial; SNRdB<=SNRdBfinal; SNRdB+=step)
			{
				SNRdBs.push(SNRdB);
			}
			for(var i=0; i<SNRdBs.length; i++)
			{
				var tempTable = [SNRdBs[i],CBs[i]];
				dataTable.push(tempTable);
			}
			
			drawTable(dataTable,table_divs[1],"SNR(dB)","number","C/B","number","no");
			
			drawChartWithOneLine(chart_divs[1],widthOfGraph,"green","C/B - SNR(dB)","SNR(dB):οριζόντιος άξονας, C/B:κάθετος άξονας",
			SNRdBs,"number","SNR(dB)",CBs,"number","C/B"); 
		
	}
	
	//συνάρτηση υπολογισμού C/B,SNR_KA για διάστημα τιμών SNR_dB με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
	function calculateCB_SNR_KA()
	{
		clearResultsForOneCalculation(table_divs[2], chart_divs[2]);
		
		var data = getData();
		
		var SNRdBinitial = data[0];
		var SNRdBfinal = data[1];
		var step = data[2];
		
		var CBs = calculateCBForSNRdBs(SNRdBinitial,SNRdBfinal,step);
		var SNRKAs = calculateSNRKAForSNRdBs(SNRdBinitial,SNRdBfinal,step);

		var widthOfGraph = 600;
		if(width<=500)
		{
			widthOfGraph = 300;
		}
		
			var dataTable = [];

			for(var i=0; i<CBs.length; i++)
			{
				var tempTable = [CBs[i],SNRKAs[i]];
				dataTable.push(tempTable);
			}
			
			drawTable(dataTable,table_divs[2],"C/B","number","SNR(KA)","number","no");
			
			drawChartWithOneLine(chart_divs[2],widthOfGraph,"brown","C/B - SNR(KA)","C/B:οριζόντιος άξονας, SNR(KA):κάθετος άξονας",
			CBs,"number","C/B",SNRKAs,"number","SNR(KA)"); 
		
	}
	
	//συνάρτηση απεικόνισης αποτελεσμάτων σε διάγραμμα με μία γραμμή
	function drawChartWithOneLine(div,widthOfGraph,color,title,subtitle,x,xType,xName,line,lineType,lineName) 
	{

		var data = new google.visualization.DataTable();
		data.addColumn(xType, xName);
		data.addColumn(lineType, lineName);
		
		var table = [];
		for(var i=0; i<x.length; i++)
		{
			var resultsForOneValue = [x[i],line[i]];
			table.push(resultsForOneValue);
		}	

		data.addRows(table);

		var options = {
			chart: {
			title: title,
			subtitle: subtitle
			},
			width: widthOfGraph,
			height: 500,
			series: {
            0: { color: color },
			}
		};

		var chart = new google.charts.Line(div);
		chart.draw(data, google.charts.Line.convertOptions(options));
    }

	//συνάρτηση απεικόνισης αποτελεσμάτων σε πίνακα με δύο στήλες
	function drawTable(table, div, column1Name, column1Type, column2Name, column2Type, withpages) {
		var data = new google.visualization.DataTable();
        data.addColumn(column1Type, column1Name);
        data.addColumn(column2Type, column2Name);
        data.addRows(table);

        var table = new google.visualization.Table(div);
		
		var cssClassNames = {	headerRow: 'bigAndBoldClass', 
								tableRow: 'row', 
								oddTableRow: 'oddTableRow',
								selectedTableRow : 'selectedTableRow',
								hoverTableRow: 'highlightClass',
								headerCell : 'headerCell',
								tableCell : 'tableCell' 
							};
							
		if(withpages.localeCompare("yes")==0)
			table.draw(data, {cssClassNames, alternatingRowStyle:true, showRowNumber: false, page: 'enable', pageSize: 5, width: '400px', height: '300px'});
		else
			table.draw(data, {cssClassNames, sort:'disable', alternatingRowStyle:true, showRowNumber: false, page: 'disable', width: '400px', height: '500px'});
		
    }

	//συνάρτηση καθαρισμού αποτελέσματος
	function clearResultsForOneCalculation(table_div, chart_div)
	{
		table_div.innerHTML = "";
		chart_div.innerHTML = "";
	}
	
	//συνάρτηση καθαρισμού αποτελεσμάτων
	function clearResults()
	{
		for(var div of table_divs)
			div.innerHTML = "";
		
		for(var div of chart_divs)
			div.innerHTML = "";
	}
	
	//επαναφορά των πεδίων στις αρχικές τους τιμές
	function clearFields()
	{
		window.location.reload(); 
		clearResults();
	}
