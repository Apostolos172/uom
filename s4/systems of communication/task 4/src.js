"use strict";
	
google.charts.load('current', {'packages':['line']});

var mWatt = window.document.getElementsByClassName("mWatt");
var width = window.screen.width;
initialize();

(window.document.getElementById("calculate")).addEventListener("click",calculate);
(window.document.getElementById("deleteResults")).addEventListener("click",clearResults);
(window.document.getElementById("deleteFields")).addEventListener("click",clearFields);

//"αρχικοποίηση" σελίδας, ενδεικτικές τιμές σε μονάδες μέτρησης και πεδία
function initialize()
{
	for(var i=0; i<mWatt.length; i++)
		mWatt[i].selected = true;
	window.document.getElementById("PTransmitter").value = 100;
	window.document.getElementById("d0").value = 1; 
	window.document.getElementById("N").value = 0.001; 
	window.document.getElementById("fmin").value = 2.4; 
	window.document.getElementById("fmax").value = 2.425; 
	window.document.getElementById("dinitial").value = 10; 
	window.document.getElementById("dfinal").value = 100; 
	window.document.getElementById("step").value = 10;
}

//συνάρτηση επιστροφής των δεδομένων των απαραίτητων για τους υπολογισμούς από τα πεδία στην html σαν array
function getData()
{
	var PTransmitter = parseFloat((parseFloat(window.document.getElementById("PTransmitter").value)).toFixed(2));
	if(!mWatt[0].selected)
		PTransmitter = WatttomWatt(PTransmitter);
	var d0 = parseFloat((parseFloat(window.document.getElementById("d0").value)).toFixed(2)); 
	var N = parseFloat((parseFloat(window.document.getElementById("N").value)).toFixed(6));
	if(!mWatt[1].selected)
		N = WatttomWatt(N);
	var fmin = parseFloat((parseFloat(window.document.getElementById("fmin").value)).toFixed(4)); 
	var fmax = parseFloat((parseFloat(window.document.getElementById("fmax").value)).toFixed(4)); 
	var dinitial = parseFloat((parseFloat(window.document.getElementById("dinitial").value)).toFixed(2)); 
	var dfinal = parseFloat((parseFloat(window.document.getElementById("dfinal").value)).toFixed(2)); 
	var step = parseFloat((parseFloat(window.document.getElementById("step").value)).toFixed(2)); 
	
	var data = [PTransmitter, d0, N, fmin, fmax, dinitial, dfinal, step];
	
	return data;
}

//συνάρτηση μετατροπής τιμής από Watt σε mWatt
function WatttomWatt(Watt)
{
	var mWatt = Watt*Math.pow(10,3);
	return mWatt;
}

//συνάρτηση υπολογισμού για διάστημα τιμών d σε m με εκτύπωση αποτελεσμάτων σε πίνακα
function calculate()
{
	clearResults();
	
	var data = getData();
	
	var PTransmitter = data[0];
	var d0 = data[1];
	var N = data[2];
	var fmin = data[3];
	var fmax = data[4];
	var dinitial = data[5];
	var dfinal = data[6];
	var step = data[7];
	
	var dArray = [];
	for(var i=dinitial; i<=dfinal; i+=step)
		dArray.push(i);
	
	var B = (fmax-fmin)*Math.pow(10,3);
	//console.log(dinitial,dfinal,step);
	var PReceiverArray = calculatePReceiverForRanged(PTransmitter, d0, dinitial, dfinal, step);
	var CapacityArray = calculateCapacityForRangeS(B, PReceiverArray, N);
	
	if(width<=500)
	{
		var vertical_table = window.document.getElementById("vertical_table");
		var rows = -1;
	
		var data = ["d(m)","max R (Mbps)"];
		addArow(vertical_table, rows++, data);

		for(var i=0; i<dArray.length; i++)
		{
			var resultsForOneValue = [dArray[i],CapacityArray[i]];
			addArow(vertical_table,rows++,resultsForOneValue)
		}	
		
		drawChart(300,'',dArray,CapacityArray);
	}
	else
	{
	
		var row1data = [];
		for(var i=0; i<dArray.length; i++)
			row1data.push(dArray[i].toString());
		row1data.unshift("d (m)");
		
		var row2data = [];
		for(i=0; i<CapacityArray.length; i++)
			row2data.push(CapacityArray[i].toString());
		row2data.unshift("max R (Mbps)");
		
		addArow(horizontal_table, 0, row1data);
		addArow(horizontal_table, 1, row2data);
	
		drawChart(900,"d(m):οριζόντιος άξονας, max R:κάθετος άξονας",dArray,CapacityArray);
	}
	
		
}

//συνάρτηση υπολογισμού της ισχύος σήματος στον δέκτη του καναλιού 
function calculatePReceiver(PTransmitter, d0, d)
{
	var PReceiver = PTransmitter*Math.pow((d0/d),2);
	return parseFloat(PReceiver.toFixed(2));
}

//συνάρτηση υπολογισμού της ισχύος σήματος στον δέκτη του καναλιού για range τιμών
function calculatePReceiverForRanged(PTransmitter, d0, dinitial, dfinal, step)
{
	var PReceiverArray = [];
	//console.log(dinitial,dfinal,step);
	for(var i=dinitial; i<=dfinal; i+=step)
	{
		var currentPReceiver = calculatePReceiver(PTransmitter, d0, i);
		PReceiverArray.push(currentPReceiver);
	}
	return PReceiverArray;
}

//συνάρτηση υπολογισμού της χωρητικότητας του καναλιού από τον νόμο του Shannon
function calculateCapacity(B, S, N)
{
	var C = B*Math.log2(1+S/N);
	return parseFloat(C.toFixed(2));
}

//συνάρτηση υπολογισμού της χωρητικότητας του καναλιού από τον νόμο του Shannon για range τιμών
function calculateCapacityForRangeS(B, Sarray, N)
{
	var Carray = [];
	for(var i=0; i<Sarray.length; i++)
	{
		var c = calculateCapacity(B, Sarray[i], N);
		Carray.push(c);
		//console.log(B, Sarray[i], N, c);
	}
	return Carray;
}

//συνάρτηση απεικόνισης αποτελεσμάτων σε διάγραμμα
function drawChart(widthOfGraph,subtitle,dArray,CapacityArray) 
{

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'd (m)');
	data.addColumn('number', 'max R');
	  
	var table = [];
	for(var i=0; i<dArray.length; i++)
	{
		var resultsForOneValue = [dArray[i],CapacityArray[i]];
		table.push(resultsForOneValue);
	}	

	data.addRows(table);

	var options = {
		chart: {
		title: "d(m) με max R",
		subtitle: subtitle
		},
		width: widthOfGraph,
		height: 500
	};

	var chart = new google.charts.Line(document.getElementById('chart_div'));
	chart.draw(data, google.charts.Line.convertOptions(options));
}

//συνάρτηση προσθήκης γραμμής σε πίνακα table(resultsElement) με τα δεδομένα να βρίσκονται στο array dataOfRow
function addArow(resultsElement, row, dataOfRow)
{

	// Create an empty <tr> element and add it to the resultsElement at the position row:
	var row = window.document.createElement("TR");
	resultsElement.append(row);

	// Insert new cells (<td> elements) at the positions of the "new" <tr> element:
	var cellsNo = dataOfRow.length;
	var cells = [];
	var cell;
	for(var i=0; i<cellsNo; i++)
	{
		cell = row.insertCell(i);
		cells.push(cell);
	}

	// Add some text to the new cells:
	for(i=0; i<cellsNo; i++)
		cells[i].innerHTML = ""+dataOfRow[i];

}

//συνάρτηση καθαρισμού αποτελεσμάτων
function clearResults()
{
	
	var trs = document.getElementsByTagName("tr");
	for(var i=0; i<trs.length; i++)
		trs[i].innerHTML = "";
	
	var resultsElement = document.getElementById("vertical_table").innerHTML = "";
	document.getElementById("chart_div").innerHTML = "";
}

//επαναφορά των πεδίων στις αρχικές τους τιμές
function clearFields()
{
	window.location.reload(); 
	clearResults();
}
