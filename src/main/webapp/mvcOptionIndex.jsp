<%--
  Created by IntelliJ IDEA.
  User: kimjingeun
  Date: 2023/05/30
  Time: 10:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    function ajaxProcess(url, type, contentType, dataType, data) {
        $.ajax({
            url: url,
            type: type,
            contentType: contentType,
            dataType: dataType, //result type
            data: data, // 넘겨주는 타입
            success: function (val) {
                console.log(val)
            }, error: function (e) {
                alert("error")
            }
        })
    }

    $(function (){
        $("input.exception").click(function (){
            if(this.id == "exception1"){
                document.location.href="${pageContext.request.contextPath}/nullpoint"
            }
            if(this.id == "exception2"){
                document.location.href="${pageContext.request.contextPath}/classCast"
            }
            if(this.id == "exception3"){
                document.location.href="${pageContext.request.contextPath}/numberFormat"
            }
        })
    })

    $(function(){
        $("input.header").click(function (){
            if(this.id == "header1"){
                document.location.href="${pageContext.request.contextPath}/header1";
            }
            if(this.id == "header2"){
                document.location.href="${pageContext.request.contextPath}/header2";
            }

        })
    })

    $(function () {
        $("input[type='button']").click(function () {
            switch (this.id) {
                case 'ajax1':
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest1', 'POST', null, 'html');
                    alert("ajax1");
                    break;
                case 'ajax2':
                    var jsonValue = {"id": "blue", "name": "abc", "weight": 55.7, "height": 189.9};
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest2', 'POST', "application/json", "text", JSON.stringify(jsonValue)); // JSON.stringify로 해야 제이슨 데이터가 넘어간다
                    alert("ajax2");
                    break;
                case 'ajax3':
                    var jsonValue = {"name": "aop", "since": 1980, "message": "hi"};
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest3', 'POST', "application/json", "json", JSON.stringify(jsonValue)); // JSON.stringify로 해야 제이슨 데이터가 넘어간다
                    alert("ajax3");
                    break;
                case 'ajax4':
                    var jsonValue = {"userName": "SpringBooot", "userLoc": "localhost", "wait": 1000};
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest4', 'POST', "application/json", "json", JSON.stringify(jsonValue));
                    alert("ajax4");
                    break;
                case 'ajax5':
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest5', 'POST', "application/json", "text");
                    alert("ajax5")
                    break;
                case 'ajax6':
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest6', 'POST', "application/json", "text");
                    alert("ajax6")
                    break;
                case 'ajax7':
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest7', 'POST', "application/json", "json");
                    alert("ajax7")
                    break;
                case 'ajax8':
                    ajaxProcess('${pageContext.request.contextPath}/ajaxTest8', 'POST', "application/json", "json");
                    alert("ajax8")
                    break;
                default:
                    break;
            }
        })
    })

</script>
<body>
<%--
<a href="${pageContext.request.contextPath}/pathParam/EmpSelect/SMITH/SALESMAN">EMPLIST1</a>
<a href="${pageContext.request.contextPath}/pathParam/EmpSelect/ALLEN/MANAGER">EMPLIST2</a>
<a href="${pageContext.request.contextPath}/pathParam/EmpSelect/JONES">EMPLIST3</a>
<a href="${pageContext.request.contextPath}/pathParam/EmpSelect">EMPLIST4</a>--%>

<input type="button" value="AjaxValue1" id="ajax1"><br>
<input type="button" value="AjaxValue2" id="ajax2"><br>
<input type="button" value="AjaxValue3" id="ajax3"><br>
<input type="button" value="AjaxValue4" id="ajax4"><br>
<input type="button" value="AjaxValue5" id="ajax5"><br>
<input type="button" value="AjaxValue6" id="ajax6"><br>
<input type="button" value="AjaxValue7" id="ajax7"><br>
<input type="button" value="AjaxValue8" id="ajax8"><br>

SELECT JOB,MAX(SAL)
FROM EMP
GROUP BY JOB

<br>
<br>
<br>
<br>
<br>

<input type="button" value="Header1" id="header1" class="header"><br>
<input type="button" value="Header2" id="header2" class="header"><br>
<br><br><br><br><br>
<input type="button" value="Exception1" id="exception1" class="exception"><br>
<input type="button" value="Exception2" id="exception2" class="exception"><br>
<input type="button" value="Exception3" id="exception3" class="exception"><br>
<input type="button" value="Exception4" id="exception4" class="exception"><br>

</body>
</html>
