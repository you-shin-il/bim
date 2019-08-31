$(document).ready(function(){
	mainChartLoad();
	monitorChartLoad();
});

function mainChartLoad(){
	for(i=1;i<22;i++){
		var chart = c3.generate({
				bindto: '#mainChart'+i,
				data: {			
					x:'monitor',
					columns: [				
						['monitor', 'CPU', 'MEM', 'DISK'],
						['USAGE', 10, 30, 55],
						['IDLE', 90, 70, 45]
					],
					type: 'bar',
					groups: [
						['USAGE', 'IDLE']
					]
				},
				bar: {
						width: {ratio:0.3}
				},
				axis: {					
					rotated: true,
						x: {
							type: 'category',
							tick: {
								multiline: false 
									} // this needed to load string x value
							},
						y: {
							max: 100,
							min: 10,
							}
						},						
				grid: {
					y: {
						lines: [{value:0}]
					}
				},
				legend: {
					hide:true
				},
				color:{
					pattern: ['#02e00d', '#666']
				}
			});
	}
}

function monitorChartLoad(){
	var chart = c3.generate({
		bindto: '#monitorChart',
		data: {
			columns: [
				['data1', 30, 200, 100, 400, 150, 250],
				['data2', 50, 20, 10, 40, 15, 25]
			]
		},
		color:{
			pattern: ['#00afd7', '#f35757']
		}
	});
}