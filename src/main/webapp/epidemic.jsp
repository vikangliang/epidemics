<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/2/26
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>疫情信息</title>

    <jsp:include page="template/bootstrap_common.jsp"></jsp:include>
</head>
<body style="background-color: #2aabd2">
<div class="container">
    <div class="row">
        <div class="col-md-12" style="background-color: #fff;margin-bottom: 5px">
            <div id="mymap" style="height: 600px"></div>
        </div>
    </div>
    <div class="row" style="height: 400px;overflow: auto">
        <div class="col-md-12" style="background-color: #fff">
            <table class="table table-hover table-bordered table-striped">
                <thead>
                <th>省份</th>
                <th>确诊</th>
                <th>疑似</th>
                <th>隔离</th>
                <th>治愈</th>
                <th>死亡</th>
                </thead>
                <tbody id="tbody1">
                </tbody>
            </table>
        </div>
    </div>
    <div class="row" style="margin-top: 5px">
        <div class="col-md-12">
            <div id="mycharts" style="height: 500px;border: 1px solid gray;background-color: #fff"></div>
        </div>
    </div>
    <div class="row">
        <a href="login.jsp">登入</a>
    </div>
</div>
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.js"></script>
<script type="text/javascript">
    //发送请求获取最新疫情数据
    $(function () {
        $.get("${pageContext.request.contextPath}/epidemic/ajax/lastestData", {}, function (resp) {
            if (resp.code < 0) {
                alert(resp.msg);
            } else {
                fillToTable(resp.data);
                fillToCharts(resp.data);
                fillToMap(resp.data);
            }
        }, "json");
    });

    var fillToTable = function (epidemics) {
        var tbody1 = $("#tbody1");
        tbody1.empty();
        $.each(epidemics, function (index, e) {
            var tr = $("<tr>");
            var td = $("<td>");
            td.text(e.provinceName);
            tr.append(td);

            td = $("<td>");
            td.html("" + e.affirmedTotal + " <span class='small'>+" + e.affirmed + "</span>");
            tr.append(td);

            td = $("<td>");
            td.html("" + e.suspectTotal + " <span class='small'>+" + e.suspect + "</span>");
            tr.append(td);

            td = $("<td>");
            td.html("" + e.isolatedTotal + " <span class='small'>+" + e.isolated + "</span>");
            tr.append(td);

            td = $("<td>");
            td.html("" + e.curedTotal + " <span class='small'>+" + e.cured + "</span>");
            tr.append(td);

            td = $("<td>");
            td.html("" + e.deadTotal + " <span class='small'>+" + e.dead + "</span>");
            tr.append(td);

            tbody1.append(tr);
        })
    }


    //初始化图表
    var mycharts = echarts.init($("#mycharts").get(0));
    var option = {
        title: {
            text: '当日全国疫情柱状图'
        },
        tooltip: {},
        legend: {
            data: ["2020-03-02"]
        },
        grid: {
            show: true
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            type: 'bar'
        }]
    };
    mycharts.setOption(option);

    //将服务器端返回的数据返回到图表
    var fillToCharts = function (epidemics) {
        console.info(epidemics)
        var provinceName = [];
        var affTotal = [];
        $.each(epidemics, function (index, e) {
            provinceName.push(e.provinceName);
            affTotal.push(e.affirmedTotal);
        });
        console.info(affTotal);
        mycharts.setOption({
            xAxis: {
                data: provinceName,

            },
            series: [{
                data: affTotal
            }]
        });
    }

    var mymap = null;
    //获取地图数据，显示中国地图
    $.getJSON("https://cdn.jsdelivr.net/npm/echarts@4.3.0/map/json/china.json", {}, function (chinaJson) {
            echarts.registerMap("china", chinaJson);
            mymap = echarts.init($("#mymap").get(0));
            var option = {
                title: {text: "2020-03-02 全国疫情统计"},
                legend: {data: ["确诊人数"]},
                tooltip: {},
                visualMap: {
                    type: 'piecewise',  // 分段型视觉映射
                    min: 0,
                    max: 10000,
                    splitNumber: 5,   //分为5个段
                    textStyle: {
                        color: 'orange'   //文本颜色
                    }
                },
                series: [{
                    type: "map",
                    mapType: "china",
                    data:[]
                }]
            };
            mymap.setOption(option);
        },
        "json"
    );
    var fillToMap = function (epidemics) {
        var data = [];
        $.each(epidemics, function (index, e) {
            var obj = {};
            obj.name = e.provinceName;
            obj.value = e.affirmedTotal;
            data.push(obj);
        });
        mymap.setOption({
            series: [{
                data:data
            }]
        });
    }
</script>
</body>
</html>