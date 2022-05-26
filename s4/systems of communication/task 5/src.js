
"use strict";

google.charts.load('current', {'packages':['table']});
google.charts.load('current', {'packages':['line']});

var chart_divs = window.document.getElementsByClassName("chart_div");
var table_divs = window.document.getElementsByClassName("table_div"); 

var width = window.screen.width;
initialize();

(window.document.getElementById("calculatef_T")).addEventListener("click",calculatef_T);
(window.document.getElementById("calculatef_Ts")).addEventListener("click",calculatef_Ts);
(window.document.getElementById("calculatef_fs")).addEventListener("click",calculatef_fs);
(window.document.getElementById("calculateSignal")).addEventListener("click",calculateSignals);
(window.document.getElementById("calculateNyquist")).addEventListener("click",calculateNyquist);
(window.document.getElementById("deleteResults")).addEventListener("click",clearResults);
(window.document.getElementById("deleteFields")).addEventListener("click",clearFields);
var selected = (window.document.querySelectorAll("input.selected"));
for(var input of selected)
	input.addEventListener("focusout",function(){ setffinal(selected); });
var inputs = (window.document.querySelectorAll("input"));
for(var input of inputs)
	input.addEventListener("focusin",function(){ clearResults(); });
	
//συνάρτηση αυτόματης συμπλήρωσης της τελικής τιμής της συχνότητας μετρώντας 10 συνολικά τιμές από την αρχική
function setffinal(select)
{
	var finitial = window.parseFloat(select[0].value);
	var step = window.parseFloat(select[1].value);
	var count = 0;
	var ffinal;
	while(count<9)
	{
		finitial+=step;
		count++;
	}
	ffinal = finitial;
	window.document.querySelector("input[readonly]").value = "";
	window.document.querySelector("input[readonly]").value = ffinal;
}

//"αρχικοποίηση" σελίδας, ενδεικτικές τιμές σε μονάδες μέτρησης και πεδία
function initialize()
{
	window.document.getElementById("A").value = 20;
	window.document.getElementById("finitial").value = 20; 
	window.document.getElementById("ffinal").value = 110; 
	window.document.getElementById("step").value = 10;
}

//συνάρτηση επιστροφής των δεδομένων των απαραίτητων για τους υπολογισμούς από τα πεδία στην html σαν array
function getData()
{
	var A = parseFloat((parseFloat(window.document.getElementById("A").value)).toFixed(2)); 
	var finitial = parseFloat((parseFloat(window.document.getElementById("finitial").value)).toFixed(2)); 
	var ffinal = parseFloat((parseFloat(window.document.getElementById("ffinal").value)).toFixed(2)); 
	var step = parseFloat((parseFloat(window.document.getElementById("step").value)).toFixed(2)); 
	
	var data = [A, finitial, ffinal, step];
	
	return data;
}

//συνάρτηση υπολογισμού περιόδου σήματος
function calculateT(f)
{
	var T;
	T = 1.0/f;
	return T;
}

//συνάρτηση υπολογισμού περιόδου δειγματοληψίας
function calculateTs(f)
{
	var Ts;
	Ts = 1.0/(2*f);
	return Ts;
}

//συνάρτηση υπολογισμού συχνότητας δειγματοληψίας
function calculatefs(f)
{
	var fs;
	fs = 2*f;
	return fs;
}

//συνάρτηση υπολογισμού σήματος στο χρόνο
function calculateSignal(A,f)
{
	var x = [];
	var y = [];
	var pi = Math.PI;
	var T = calculateT(f);
	for(var t=0; t<=T; t+=0.001)
	{	
		x.push(t);
		y.push(A*(Math.sin(2*pi*f*t)));
	}
	var xy = []
	xy.push(x);
	xy.push(y);
	return xy;
}

//συνάρτηση υπολογισμού σήματος 
function calculateValueOfSignal(A,f,t)
{
	var pi = Math.PI;
	var T = calculateT(f);

	return (A*(Math.sin(2*pi*f*t)));;
}

//συνάρτηση υπολογισμού περιόδου σήματος για εύρος τιμών συχνότητας
function calculateTForFrequencies(finitial,ffinal,step)
{
	var resultsForManyFrequencies = [];
	for(var f=finitial; f<=ffinal; f+=step)
	{
		var T = calculateT(f);
		resultsForManyFrequencies.push(T);
	}
	return resultsForManyFrequencies;
}

//συνάρτηση υπολογισμού περιόδου δειγματοληψίας για εύρος τιμών συχνότητας
function calculateTsForFrequencies(finitial,ffinal,step)
{
	var resultsForManyFrequencies = [];
	for(var f=finitial; f<=ffinal; f+=step)
	{
		var T = calculateTs(f);
		resultsForManyFrequencies.push(T);
	}
	return resultsForManyFrequencies;
}

//συνάρτηση υπολογισμού συχνότητας δειγματοληψίας για εύρος τιμών συχνότητας
function calculatefsForFrequencies(finitial,ffinal,step)
{
	var resultsForManyFrequencies = [];
	for(var f=finitial; f<=ffinal; f+=step)
	{
		var fs = calculatefs(f);
		resultsForManyFrequencies.push(fs);
	}
	return resultsForManyFrequencies;
}

//συνάρτηση υπολογισμού σήματος για εύρος τιμών συχνότητας
function calculateSignalForFrequencies(A,finitial,ffinal,step)
{
	var resultsForManyFrequencies = [];
	for(var f=finitial; f<=ffinal; f+=step)
	{
		var signal = calculateSignal(A,f);
		resultsForManyFrequencies.push(signal);
	}
	return resultsForManyFrequencies;
}

//συνάρτηση υπολογισμού T για διάστημα τιμών f σε Hz με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
function calculatef_T()
{
	clearResultsForOneCalculation(table_divs[0], chart_divs[0]);
	
	var data = getData();
	
	var A = data[0];
	var finitial = data[1];
	var ffinal = data[2];
	var step = data[3];
	
	var Ts = calculateTForFrequencies(finitial,ffinal,step);

	var widthOfGraph = 600;
	if(width<=500)
	{
		widthOfGraph = 300;
	}
	
		var dataTable = [];
		var fs = [];
		
		for(var f=finitial; f<=ffinal; f+=step)
		{
			fs.push(f);
		}
		for(var i=0; i<Ts.length; i++)
		{
			var tempTable = [fs[i],Ts[i]];
			dataTable.push(tempTable);
		}
		
		drawTable(dataTable,table_divs[0],"f","number","T","number","no");
		
		drawChartWithOneLine(chart_divs[0],widthOfGraph,"brown","f - T","f:οριζόντιος άξονας, T:κάθετος άξονας",
		fs,"number","f",Ts,"number","T"); 
	
}

//συνάρτηση υπολογισμού Ts για διάστημα τιμών f σε Hz με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
function calculatef_Ts()
{
	clearResultsForOneCalculation(table_divs[1], chart_divs[1]);
	
	var data = getData();
	
	var A = data[0];
	var finitial = data[1];
	var ffinal = data[2];
	var step = data[3];
	
	var Tss = calculateTsForFrequencies(finitial,ffinal,step);
	
	var widthOfGraph = 600;
	if(width<=500)
	{
		widthOfGraph = 300;
	}
	
		var dataTable = [];
		var fs = [];
		
		for(var f=finitial; f<=ffinal; f+=step)
		{
			fs.push(f);
		}
		for(var i=0; i<Tss.length; i++)
		{
			var tempTable = [fs[i],Tss[i]];
			dataTable.push(tempTable);
		}
		
		drawTable(dataTable,table_divs[1],"f","number","Ts max","number","no");
		
		drawChartWithOneLine(chart_divs[1],widthOfGraph,"green","f - Ts max","f:οριζόντιος άξονας, Ts max:κάθετος άξονας",
		fs,"number","f",Tss,"number","Ts max"); 
	
}

//συνάρτηση υπολογισμού Ts για διάστημα τιμών f σε Hz με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
function calculatef_fs()
{
	clearResultsForOneCalculation(table_divs[2], chart_divs[2]);
	
	var data = getData();
	
	var A = data[0];
	var finitial = data[1];
	var ffinal = data[2];
	var step = data[3];
	
	var fss = calculatefsForFrequencies(finitial,ffinal,step);

	var widthOfGraph = 600;
	if(width<=500)
	{
		widthOfGraph = 300;
	}
	
		var dataTable = [];
		var fs = [];
		
		for(var f=finitial; f<=ffinal; f+=step)
		{
			fs.push(f);
		}
		for(var i=0; i<fss.length; i++)
		{
			var tempTable = [fs[i],fss[i]];
			dataTable.push(tempTable);
		}
		
		drawTable(dataTable,table_divs[2],"f","number","fs max","number","no");
					
		drawChartWithOneLine(chart_divs[2],widthOfGraph,"blue","f - fs max","f:οριζόντιος άξονας, fs max:κάθετος άξονας",
		fs,"number","f",fss,"number","fs max"); 
	
}

//συνάρτηση υπολογισμού για διάστημα τιμών f σε Hz με εκτύπωση αποτελεσμάτων σε πίνακα και διάγραμμα
function calculateSignals()
{
	clearResultsForOneCalculation(table_divs[3], chart_divs[3]);
	
	var data = getData();
	
	var A = data[0];
	var finitial = data[1];
	var ffinal = data[2];
	var step = data[3];
	
	var signals = calculateSignalForFrequencies(A,finitial,ffinal,step);
	
	var title = "Σήμα για διάφορες συχνότητες";
	var subtitle = "χρόνος:οριζόντιος άξονας, πορεία του σήματος:κάθετος άξονας";
	var widthOfGraph = 1300;
	if(width<=500)
	{
		widthOfGraph = 300;
		subtitle = '';
	}
	
		var dataTable = [];
		var signal = signals[0];
		var axonasx = signals[0][0];
		var axonasy = signals[0][1];
		for(var i=0; i<axonasx.length; i++)
		{
			var tempTable = [axonasx[i],axonasy[i]];
			dataTable.push(tempTable);
		}
		
		drawTable(dataTable,table_divs[3],"t (sec)","number","A (σήμα 1ο)","number","yes");
					
		var x = drawChartWith10Lines(widthOfGraph,title,subtitle,signals[0][0],signals[0][1],signals[1][1],signals[2][1],signals[3][1],signals[4][1],signals[5][1],signals[6][1],signals[7][1],signals[8][1],signals[9][1]);
	
}

//συνάρτηση ενδεικτικής κωδικοποίησης
function calculateNyquist()
{
	clearResultsForOneCalculation(table_divs[4], chart_divs[4]);
	clearResultsForOneCalculation(table_divs[5], chart_divs[4]);
	clearResultsForOneCalculation(table_divs[6], chart_divs[4]);
	
	var data = getData();
	
	var A = data[0];
	var finitial = data[1];
	
	var signal = calculateSignal(A,finitial);
	
	var dataTable = [];
	var axonasx = signal[0];
	var axonasy = signal[1];
	var T = calculateT(finitial);
	var Tsmax = calculateTs(finitial); 
	
	var info_div = table_divs[4];
	var para = document.createElement("p");
	var tempString = "";
	var ts = T/4.0;
	tempString = "Επιλέγεται διάστημα δειγματοληψίας = " + ts.toFixed(4) + " sec < Ts max = " + Tsmax.toFixed(4) + " = 1/(2*fmax), " + 
	"όπου η συχνότητα για το συγκεκριμένο σήμα είναι " + finitial + "Hz.";
	var node = document.createTextNode(tempString);
	para.appendChild(node);
	var br = document.createElement("br");
	para.appendChild(br);
	tempString = "Δειγματοληπτώντας λοιπόν ανά " + ts.toFixed(4) + " sec (ομοιόμορφα), και κρατώντας ως δείγματα το αντίστοιχο " + 
	"πλάτος του αναλογικού σήματος (φαίνονται στον πίνακα με τη σειρά), ορίζω κβαντισμένες τιμές (όμοιες στην συγκεκριμένη " +
	"κωδικοποίηση με τα δείγματα), τις κωδικοποιώ με 2 bits και προκύπτει η παλμοκωδική διαμόρφωση " +
	"του ψηφιακού σήματος, όπως φαίνεται παρακάτω.";
	var node = document.createTextNode(tempString);
	para.appendChild(node);
	info_div.appendChild(para);
	
	var dataTable = [];
	var tempTable = [];
	for(var i=0; i<=T; i+=T/4.0)
	{
		tempTable = [];
		var s = parseFloat((calculateValueOfSignal(A,finitial,i)).toFixed(2));
		if(s==0)
			tempTable = [0,0,"00"];
		else if(s>0)
			tempTable = [A,A,"01"];
		else
			tempTable = [-A,-A,"11"];
		dataTable.push(tempTable);
	}
	
	var ft = [];
	for(var i=0; i<=T/4.0; i+=0.001)
		ft.push(0);
	for(var i=T/4.0; i<=2*(T/4.0); i+=0.001)
		ft.push(A);
	for(var i=2*(T/4.0); i<=3*(T/4.0); i+=0.001)
		ft.push(0);
	for(var i=3*(T/4.0); i<=(T); i+=0.001)
		ft.push(-A);
	
	var widthOfGraph = 600;
	var widthofTable = '500px';
	var heightofTable = '500px';
	if(width<=500)
	{
		widthofTable = '400px';
		heightofTable = '500px';
		widthOfGraph = 300;
	}
	
	drawTableWith3Columns(dataTable, table_divs[5], widthofTable, heightofTable, "δείγματα", "number", "κβαντισμένες τιμές", "number", "κωδικοποιημένες τιμές", "string", "no");
	drawChartWith2Lines(widthOfGraph,'Κωδικοποίηση','',axonasx,axonasy,ft);
	
	var pcm_sequence_div = table_divs[6];
	var para = document.createElement("p");
	var tempString = "PCM sequence: ";
	for(var j=0; j<dataTable.length; j++)
	{
		var temp = dataTable[j][2];
		tempString = tempString + temp + " ";
	}
	var node = document.createTextNode(tempString);
	para.appendChild(node);
	var br = document.createElement("br");
	para.appendChild(br);
	pcm_sequence_div.appendChild(para);
}

//συνάρτηση απεικόνισης πολλαπλών γραμμών (10) στο ίδιο διάγραμμα
function drawChartWith10Lines(widthOfGraph,title,subtitle,x,line1,line2,line3,line4,line5,line6,line7,line8,line9,line10) 
{

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'χρόνος σε sec');
	data.addColumn('number', 'σήμα για fmin');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα');
	data.addColumn('number', 'σήμα για fmax');
	
	var table = [];
	for(var i=0; i<line1.length; i++)
	{
		var resultsForOneValue = [x[i],line1[i],line2[i],line3[i],line4[i],line5[i],line6[i],line7[i],line8[i],line9[i],line10[i]];
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
		0: { color: 'blue' },
		1: { color: 'yellow' },
		2: { color: 'brown' },
		3: { color: 'red' },
		4: { color: 'green' },
		5: { color: 'orange' },
		6: { color: 'purple' },
		}
	};

	var div = chart_divs[3];
	var chart = new google.charts.Line(div);
	chart.draw(data, google.charts.Line.convertOptions(options));
}

//συνάρτηση απεικόνισης πολλαπλών γραμμών (2) στο ίδιο διάγραμμα
function drawChartWith2Lines(widthOfGraph,title,subtitle,x,line1,line2) 
{

	var data = new google.visualization.DataTable();
	data.addColumn('number', 'χρόνος');
	data.addColumn('number', 'αναλογικό σήμα');
	data.addColumn('number', 'ψηφιακό σήμα');
	
	var table = [];
	for(var i=0; i<line1.length; i++)
	{
		var resultsForOneValue = [x[i],line1[i],line2[i]];
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
		0: { color: 'blue' },
		1: { color: 'brown' },
		}
	};

	var div = chart_divs[4];
	var chart = new google.charts.Line(div);
	chart.draw(data, google.charts.Line.convertOptions(options));
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

//συνάρτηση απεικόνισης αποτελεσμάτων σε πίνακα με 3 στήλες
function drawTableWith3Columns(table, div, width, height, column1Name, column1Type, column2Name, column2Type, column3Name, column3Type, withpages) {
	var data = new google.visualization.DataTable();
	data.addColumn(column1Type, column1Name);
	data.addColumn(column2Type, column2Name);
	data.addColumn(column3Type, column3Name);
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
		table.draw(data, {cssClassNames, alternatingRowStyle:true, showRowNumber: false, page: 'enable', pageSize: 5, width: width, height: height});
	else
		table.draw(data, {cssClassNames, sort:'disable', alternatingRowStyle:true, showRowNumber: false, page: 'disable', width: width, height: height});
	
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
