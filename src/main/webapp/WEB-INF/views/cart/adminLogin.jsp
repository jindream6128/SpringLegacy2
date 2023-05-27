<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>관리자</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <meta name="copyright" content="Copyright 2020 @ high1 all rights reserved"/>
    <link href="${pageContext.request.contextPath}/resources/css/contents.css" rel="stylesheet" type="text/css"/>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        //버튼을 눌렀을때 해당경로로 이동하도록
        $(function () {
            let id = '${cookie_id}'; //쿠키에 아이디가 있다면
            console.log(id)
            //저장된 아이디가 있을때
            if(id != ''){
                $('input#user_id').val(id);
                $('input#checker').attr("checked", true);
            }



            $("#btnSubmit").click(function () {

                if ($('input#user_id').val().length == 0) {
                    alert("아이디를 입력해 주세요")
                    return;
                }
                if ($('input#user_passwd').val().length == 0) {
                    alert("비밀번호를 입력해 주세요")
                    return;
                }

                $.ajax({
                    url: '${pageContext.request.contextPath}/login/logincheck',
                    type: 'POST',
                    data: $('form#login').serialize(), //이렇게 serialize 해서 보내면 변수명이 같으면 바로 받을수 있다 -> name으로 받을수 있다.
                    success: function (data) {
                        console.log(data)
                        if (data == "fail") {
                            alert("로그인에 실패하였습니다");
                        } else {
                            location.href = "${pageContext.request.contextPath}/page/productList"
                        }
                    },error:function (){
                     console.log('error');
                 }

                })


            });
        });
    </script>

</head>
<body>

<%--form--%>
<form name="login" id='login' method="post" action="${pageContext.request.contextPath}/cartloginchk">
    <div id="loginWrapper">
        <div class="loginForm">
            <fieldset>
                <legend>관리자 시스템 로그인</legend>
                <dl>
                    <%--아이디 --%>
                    <dt><img src="${pageContext.request.contextPath}/resources/img/common/th_id.gif" alt="아이디"/></dt>
                    <dd><input type="text" name="user_id" class="text" id="user_id"/></dd>

                    <%--비밀번호--%>
                    <dt><img src="${pageContext.request.contextPath}/resources/img/common/th_pw.gif" alt="비밀번호"/></dt>
                    <dd><input type="password" name="user_passwd" class="text" id="user_passwd"/></dd>
                </dl>

                <%--버튼--%>
                <div class="btn">
                    <img id="btnSubmit" src="${pageContext.request.contextPath}/resources/img/button/btn_login.gif"
                         alt="LOGIN" title="LOGIN"/>
                </div>

                <div class="saveId"><input type="checkbox" id="checker" name="checker"/>
                    <img src="${pageContext.request.contextPath}/resources/img/common/save_id.gif" alt="아이디 저장"/>
                </div>

            </fieldset>
        </div>
    </div>
</form>
</body>
</html>