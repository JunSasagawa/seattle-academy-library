<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta name="description" content="社内の書籍検索や貸出を行うことができます。" />
<meta name="robots" content="noindex,nofollow" />
<meta http-equiv="content-type" content="text/html" charset="utf-8" />
<title>ログイン｜シアトルライブラリ｜シアトルコンサルティング株式会社</title>
<link href="<c:url value="/resources/css/reset.css" />" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+JP" rel="stylesheet">
<link href="<c:url value="/resources/css/default.css" />" rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="wrapper">
        <div class="authorization_head">
            <img class="mark" src="resources/img/logo.png" />
            <div class="logo">Seattle Library</div>
        </div>
        <div class="authorization">
            <div class="authorization_form">
                <form method="post" action="reset">
                    <div class="title">パスワードリセット</div>
                   <label class="label">メールアドレス</label> <input type="email" class="input" id="email" name="email" autocomplete="off" required> <label class="label">パスワード</label> <input type="password" class="input" id="password" name="password" required> 
                   <label class="label">パスワード（確認用）</label><input type="password" class="input" id="passwordForCheck" name="passwordForCheck" required>
                    <c:if test="${!empty errorMessage}">
                        <div class="error">${errorMessage}</div>
                    </c:if>
                    <input type="submit" class="button primary" value="リセット" /> <!---押されるとform実行--->
                </form>
            </div>
        </div>
        <footer>
            <div class="copyright">© 2019 Seattle Consulting Co., Ltd. All rights reserved.</div>
        </footer>
    </div>
</body>
</html>