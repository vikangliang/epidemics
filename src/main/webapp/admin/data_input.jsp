<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/2/28
  Time: 20:17
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
    <title>疫情数据录入</title>
    <jsp:include page="../template/bootstrap_common.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="../template/top.jsp"></jsp:include>
    <div class="row">
        <div class="col-md-3">
            <jsp:include page="../template/menu.jsp"></jsp:include>
        </div>
        <div class="col-md-9">
            <ul class="breadcrumb">
                <li><a href="../main.jsp">主页</a></li>
                <li>数据录入</li>
            </ul>
            <div class="row">
                <div class="col-md-4">
                    <div class="input-group date" id="datepicker" data-date-format="yyyy-mm-dd">
                        <div class="input-group-addon">数据日期：</div>
                        <input class="form-control" size="16" type="text" value="" readonly id="dataDate">
                        <div class="input-group-addon"><span class="add-on glyphicon glyphicon-calendar"></span></div>
                    </div>
                </div>
                <div class="col-md-4">
                    <button type="button" class="btn btn-primary" id="btn_submit">提交<span
                            class="glyphicon glyphicon-log-in"></span></button>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>省份</th>
                            <th>确诊</th>
                            <th>疑似</th>
                            <th>隔离</th>
                            <th>治愈</th>
                            <th>死亡</th>
                        </tr>
                        </thead>
                        <tbody id="tbody1">
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div id="msg"></div>
            </div>
        </div>
    </div>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<link href="https://cdn.bootcss.com/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
    var province = null;
    $(function () {
        var datepicker = $("#datepicker");
        datepicker.datepicker({
            autoclose: true
        });
        var current = new Date();
        datepicker.datepicker("setDate", current);
        var lastTwoWeek = new Date();
        lastTwoWeek.setDate(current.getDate() - 14);
        datepicker.datepicker("setStartDate", lastTwoWeek);
        datepicker.datepicker("setEndDate", current);
        //给日期选择器设置事件处理
        datepicker.datepicker().on("changeDate", loadProvinceList);
        loadProvinceList()
    });

    //装载省份列表
    function loadProvinceList() {
        var tbody = $("#tbody1");
        tbody.empty();
        //获取当前日期框值
        var date = $("#dataDate").val();
        //    从服务器获取还没录入省份的列表
        $.get("${pageContext.request.contextPath}/provinces/ajax/nodataList", {date: date}, function (resp) {
            if (resp.code < 0) {
                alert(msg);
            } else {
                fillProvinceToTable(resp.data);
            }
        }), "json"
    }

    function fillProvinceToTable(array) {
        if (array && array.length > 0) {
            province = array;
            //填充到table
            var tbody1 = $("#tbody1");
            $.each(array, function (index, province) {
                var tr = $("<tr>");
                var td = $("<td>");
                td.text(province.provinceName);
                tr.append(td);

                var td = $("<td>");
                td.html('<input type="text" size="4" max="4" class="form-control" name="affirmed" value="0">');
                tr.append(td);

                var td = $("<td>");
                td.html('<input type="text" size="4" max="4" class="form-control" name="suspect" value="0">');
                tr.append(td);

                var td = $("<td>");
                td.html('<input type="text" size="4" max="4" class="form-control" name="isolated" value="0">');
                tr.append(td);

                var td = $("<td>");
                td.html('<input type="text" size="4" max="4" class="form-control" name="cured" value="0">');
                tr.append(td);

                var td = $("<td>");
                td.html('<input type="text" size="4" max="4" class="form-control" name="dead" value="0">');
                tr.append(td);

                tbody1.append(tr);
            })

        } else {
            //
            $("#msg").html("本日所有省份都已经录入了数据");
        }
    }

    $("#btn_submit").click(checkAndSubmitData);

    function checkAndSubmitData() {
        var valid = true;
        var affirmed = $("input[name=affirmed]");
        var suspect = $("input[name=suspect]");
        var isolated = $("input[name=isolated]");
        var cured = $("input[name=cured]");
        var dead = $("input[name=dead]");
        affirmed.each(function (index, ele) {
            if (isNaN(Number(ele.value))) {
                valid = false;
            }
        });
        if (valid) {
            //提交
            var dataArray = [];
            for (var i = 0; i < province.length; i++) {
                var obj = {};
                obj.provinceId = province[i].provinceId;
                obj.affirmed = affirmed.get(i).value;
                obj.suspect = suspect.get(i).value;
                obj.isolate = isolated.get(i).value;
                obj.cured = cured.get(i).value;
                obj.dead = dead.get(i).value;
                dataArray.push(obj);
            }
            var date = $("#dataDate").val();
            var data = {};
            data.date = date;
            data.array = dataArray;
            <%--$.post("${pageContext.request.contextPath}/epidemic/ajax/input", data, function (resp) {--%>
            <%--    console.info(resp);--%>
            <%--}, "json");--%>

            $.ajax({
                url:"${pageContext.request.contextPath}/epidemic/ajax/input",
                type:"POST",
                contentType:"application/json",
                data:JSON.stringify(data),
                dataType:"json",
                success:function (resp) {
                    console.info(resp);
                }
            });
        } else {
            alert("请检出你的输入");
        }
    }
</script>
</body>
</html>
