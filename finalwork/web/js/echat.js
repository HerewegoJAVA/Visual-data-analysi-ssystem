
$(function () {

    ceshis();
    ceshis1();
    ceshis2();
    ceshis3();
    ceshis4();

    var xhr4 = new XMLHttpRequest();
    xhr4.onreadystatechange = function() {
        if (xhr4.readyState === 4 && xhr4.status === 200) {
            var responseJson = xhr4.responseText;
            getDataCallbackBrith(responseJson);
        }
    };
    xhr4.open('GET', 'http://localhost:8082/finalwork_war_exploded/servletBrith');
    xhr4.send();

    function getDataCallbackBrith(responseJson) {
        var brith1 ={
            year_brith:[],
            rate_brith:[],
        };
        var responseObject = JSON.parse(responseJson);
        for (var i = 0; i < responseObject.length; i++) {
            var year = responseObject[i].date_Brith;
            var rate = responseObject[i].brith_Years;
            brith1.year_brith.push(year);
            brith1.rate_brith.push(rate);

        }
        var year_brith = brith1.year_brith;
        var rate_brith = brith1.rate_brith;
        ceshis( year_brith.reverse(),rate_brith.reverse())
    }


    function ceshis(year_brith,rate_brith) {
        var myChart = echarts.init(document.getElementById('chart1'));

        option = {
            title: {
                text: '生育率',
                left:'center',
                textStyle: {
                    color:'red'
                }
            },

            tooltip: {
                trigger: 'axis'
                },
            xAxis: {
                type: 'category',
                axisLine: {
                    lineStyle: {
                        color:'pink'
                    }
                },
                //生育率年份
                // data: [1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021]
                data:year_brith,
            },
            yAxis: {
                type: 'value',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
            },
            series: [
            {
                //生育率比列
                // data: [5.6,4.45,5.91,6.08,7.51,6.67,6.61,6.31,5.81,6.51,6.17,6.08,5.52,5.11,4.73,4.17,3.57,3.23,2.84,2.72,2.75,2.74,2.79,2.97,2.56,2.61,2.63,2.72,2.76,2.54,2.52,2.51,1.93,1.78,1.69,1.63,1.59,1.55,1.53,1.52,1.53,1.63,1.56,1.57,1.57,1.6,1.62,1.64,1.67,1.7,1.71,1.69,1.67,1.8,1.71,1.77,1.67,1.77,1.81,1.55,1.5,1.28,1.16],
                data:rate_brith,
                lineStyle: {
                    normal: {
                        color: 'orange '
                    },
                },
                type: 'line'
            }
             ]
        };


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }


    //Ajax传递Brith数据给data属性
    //生育率、结婚率 1978年对比

    var xhr3 = new XMLHttpRequest();
    xhr3.onreadystatechange = function() {
        if (xhr3.readyState === 4 && xhr3.status === 200) {
            var responseJson = xhr3.responseText;
            getDataCallbackBrithAndMarr(responseJson);
        }
    };
    xhr3.open('GET', 'http://localhost:8082/finalwork_war_exploded/servletBrith');
    xhr3.send();

    function getDataCallbackBrithAndMarr(responseJson) {
        var brith ={
            year_brith:[],
            rate_brith:[],
        };
        var responseObject = JSON.parse(responseJson);
        for (var i = 0; i < responseObject.length; i++) {

            if (1978<=responseObject[i].date_Brith && responseObject[i].date_Brith<=2007) {
                var year = responseObject[i].date_Brith;
                var rate = responseObject[i].brith_Years;
                brith.year_brith.push(year);
                brith.rate_brith.push(rate);

            }

        }
        var yearBrith = brith.year_brith.reverse();
        var rateBrith = brith.rate_brith.reverse()
        ceshis1(yearBrith, rateBrith)
    }

    function ceshis1(yearBrith,rateBrith) {
        var myChart = echarts.init(document.getElementById('chart2'));

        option = {
            tooltip: {
            trigger: 'axis'
            },
            legend: {
            data: ['生育率', '结婚率'],
            textStyle:{
                color:'red'
            }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            
            xAxis: {
                type: 'category',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
                //生育率结婚
                boundaryGap: false,
                data:yearBrith
                // data: [1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007]
            },
            yAxis: {
                type: 'value',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
            },
            series: [
            {           
                name: '生育率',
                type: 'line',
                lineStyle: {
                    normal: {
                        color: 'orange'
                    },
                },
                stack: 'Total',
                data:rateBrith,
                // data: [2.72,2.75,2.74,2.79,2.97,2.56,2.61,2.63,2.72,2.76,2.54,2.52,2.51,1.93,1.78,1.69,1.63,1.59,1.55,1.53,1.52,1.53,1.63,1.56,1.57,1.57,1.6,1.62,1.64,1.67]
            },
            {
                name: '结婚率',
                type: 'line',
                lineStyle: {
                    normal: {
                        color: 'green'
                    },
                },
                stack: 'Total',
                data: [12.4,13.4,14.6,20.8,16.5,14.9,15.0,15.7,16.4,17.2,16.6,16.8,16.4,16.5,16.5,15.5,15.6,15.4,15.3,14.7,14.4,14.1,13.4,12.6,12.2,12.6,13.3,12.6,14.4,15.0]
            }   
            ]
        };
        myChart.setOption(option);

        // 使用刚指定的配置项和数据显示图表。
        /*myChart.setOption(option);*/
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    function ceshis2() {
        var myChart = echarts.init(document.getElementById('chart3'));

        option = {
            tooltip: {
                trigger: 'axis'
                },
            xAxis: {
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
                data: [2007, 2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022,2023]
            },
            yAxis: {
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
            },
            series: [
                {
                type: 'candlestick',
                itemStyle:{
                    
                    color0:'green'
                },
                    //房价
                data: [
                [1005,1073,912,1171],
                [1077,510,411,1149],
                [518,1484,518,1657],
                [1490,1271,1033,1594],
                [1276,960,918,1514],
                [966,1192,888,1321],
                [1200,1117,931,1247],
                [1115,1644,1015,1676],
                [1656,2908,1509,4071],
                [2908,2541,1865,2908],
                [2545,2186,2146,2700],
                [2190,1446,1259,2444],
                [1450,1713,1419,2063],
                [1732,1681,1386,2050],
                [1676,1761,1501,1911],
                [1757,1830,1545,2263],
                [1829,1547,1477,1928]
                ]
                }
            ]
	    };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

    //Ajax传递GDP数据给data属性

    var xhr2 = new XMLHttpRequest();
    xhr2.onreadystatechange = function() {
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            var responseJson = xhr2.responseText;
            getDataCallbackGDP(responseJson);
        }
    };
    xhr2.open('GET', 'http://localhost:8082/finalwork_war_exploded/servletGDP');
    xhr2.send();

    function getDataCallbackGDP(responseJson) {
        var gdpDATE ={
            year_gpd:[],
            rate_gdp:[],
        };
        var responseObject = JSON.parse(responseJson);
        for (var i = 0; i < responseObject.length; i++) {

            var year = responseObject[i].date_GDP;
            var rate = responseObject[i].gdp_Number;
            gdpDATE.year_gpd.push(year);
            gdpDATE.rate_gdp.push(rate);

        }

        var yearGDP = gdpDATE.year_gpd.reverse();
        var rateGDP = gdpDATE.rate_gdp.reverse();
        ceshis3(yearGDP,rateGDP)
    }
    function ceshis3(yearGDP,rateGDP) {
        var myChart = echarts.init(document.getElementById('chart4'));

        option = {
            tooltip: {
            trigger: 'axis'
            },
            xAxis: {
                type: 'category',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
                data:yearGDP,
                // data: [1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021]
            },
            yAxis: {
                type: 'value',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
            },
            //GDP
            series: [
            {
                data:rateGDP,
                // data: [0.059716,0.050057,0.047209,0.050707,0.070436,0.07672,0.072882,0.070847,0.079706,0.092603,0.099801,0.113688,0.138544,0.144182
                // ,0.163432,0.15394,0.174938,0.149541,0.178281,0.191149,0.195866,0.20509,0.230687,0.259947,0.309488,0.300758,0.272973,0.312354,0.347768
                // ,0.360858,0.383373,0.426916,0.444731,0.564325,0.734548,0.863747,0.961604,1.03,1.09,1.21,1.34,1.47,1.66,1.96,2.29,2.75,3.55,4.59
                // ,5.1,6.09,7.55,8.53,9.57,10.48,11.06,11.23,12.31,13.89,14.28,14.69,17.73],
                lineStyle: {
                    normal: {
                        color: 'orange '
                    },
                },
                type: 'line'
            }
             ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }



    //Ajax传递CPI数据给data属性

    var xhr1 = new XMLHttpRequest();
    xhr1.onreadystatechange = function() {
        if (xhr1.readyState === 4 && xhr1.status === 200) {
            var responseJson = xhr1.responseText;
            getDataCallback(responseJson);
        }
    };
    xhr1.open('GET', 'http://localhost:8082/finalwork_war_exploded/servletJson');
    xhr1.send();

    function getDataCallback(responseJson) {
        var cpi ={
            year_cpi:[],
            rate_cpi:[],
        };
        var responseObject = JSON.parse(responseJson);
        for (var i = 0; i < responseObject.length; i++) {
            var year = responseObject[i].date_CPI;
            var rate = responseObject[i].cpi_Rate;
            cpi.year_cpi.push(year);
            cpi.rate_cpi.push(rate);
        }
        var yearCPI = cpi.year_cpi.reverse();
        var rateCPI = cpi.rate_cpi.reverse();
        ceshis4(yearCPI,rateCPI)
    }

        function ceshis4(yearCPI,rateCPI) {

            var myChart = echarts.init(document.getElementById('chart5'));

        option = {

            tooltip: {
                trigger: 'axis'
                },
            xAxis: {
                type: 'category',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
                // data:Mycpi.year
                date:yearCPI,
                // data: [1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2010,2011,2012,2013,2014,2015,2016,2017,2018,2019,2020,2021,2022]
            },
            yAxis: {
                type: 'value',
                axisLine: {
                    lineStyle:{
                        color:'pink'
                    }
                },
            },
            series: [
            {
                data:rateCPI,
                // data: [7.23,18.81,18.25,3.05,3.56,6.35,14.61,24.26,16.79,8.31,2.79,-0.77,-1.4,0.35,0.72,-0.73,1.13,3.82,1.78,1.65,4.82,5.95,-0.73,3.18,5.55,2.62,2.62,1.92,1.44,2.0,1.59,2.07,2.9,2.42,0.98,1.97],
                type: 'bar',
                itemStyle: {
                    color:'orange'
                },
                showBackground: true,
                backgroundStyle: {
                color: 'rgba(180, 180, 180, 0.2)'
                }
            }
            ]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }

    function ceshis5() {
        var myChart = echarts.init(document.getElementById('chart_1'));


        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        window.addEventListener("resize",function(){
            myChart.resize();
        });
    }
    

});