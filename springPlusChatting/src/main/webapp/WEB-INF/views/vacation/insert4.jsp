<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, maximum-scale=5.0, user-scalable=yes">
    <meta http-equiv="Content-Language" content="ko">

    <title>휴가원</title>

    <!-- 스타일 시트 링크 -->
    <link id="mycss01" href="style3.css" rel="stylesheet" type="text/css">
    <style>
        /*설정*/
        html,
        body,
        table {
            font-family: "Nanum Gothic";
            font-size: 12px;
            -webkit-text-size-adjust: none;
        }

        p {
            margin: 0px;
        }



        table {
            margin: 0 auto;
        }

        table {
            border-collapse: collapse;
        }

        a {
            text-decoration: none;
        }

        /*기본*/
        .form9 {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
            border: 1px solid #ccc;
        }

        .form9 td {
            border: 1px solid #ccc;
            padding-left: 10px;
            padding-right: 10px;

        }

        .form9_contents {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
            border: 1px solid #ccc;
            table-layout: fixed;
            word-break: break-all;
        }

        .form9_contents td {
            border: 1px solid #ccc;
            padding-left: 10px;
            padding-right: 10px;

        }

        .form9_contents td.stitle {
            background: #edeaf7;
        }

        .form9_contents.bordertop2 {
            border-top: 2px solid #585170;
        }

        .form9_middle {
            font-size: 12px;
            color: #000000;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
            border: 0px solid #ccc;
        }

        .form9_middle td {
            border: 1px solid #ccc;
            padding-left: 10px;
            padding-right: 10px;

        }

        .form10 {
            font-size: 13px;
            color: #000000;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
        }

        .form11 {
            font-size: 14px;
            color: #000000;
            text-decoration: none;
            letter-spacing: 0px;
        }

        .form16b1 {
            font-size: 23px;
            color: #000000;
            text-decoration: none;
            font-weight: bold;
            letter-spacing: 1px;
            text-align: center;
        }




        /*요소*/
        .bold {
            font-weight: bold;
        }

        .stitle {
            height: 30px;
            background: #deebf1;
            border-right: 1px solid #ccc;
            text-align: center;
            padding-left: 0 !important;
            padding-right: 0 !important;
        }

        .bordertop2 {
            border-top: 2px solid #333;
        }

        .border-right_dotted {
            border-right: 1px solid #ccc;
        }

        .blank01 {
            height: 20px;
            padding: 0;
            margin: 0;
        }

        .inputBox {
            width: 100%;
            height: 100%;
        }

        .tmsedit {
            padding: 3px 0;
            min-height: 12px;
        }



        .tmsselect {
            min-height: 15px;
            line-height: 15px;
            padding: 3px 0;
            cursor: pointer;
        }

        .middle {
            font-size: 12px;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
            margin: 0 auto;
        }

        .minheight50 {
            min-height: 50px;
        }

        .minheight100 {
            min-height: 100px;
        }

        .minheight200 {
            min-height: 200px;
        }

        .minheight300 {
            min-height: 300px;
        }

        .minheight400 {
            min-height: 400px;
        }

        .minheight500 {
            min-height: 500px;
        }

        .minheight600 {
            min-height: 600px;
        }

        .textleft {
            text-align: left;
        }

        .textright {
            text-align: right;
        }

        .textcenter {
            text-align: center;
        }

        /*하단*/
        /*#footer-wrapper{
		position:relative;
		width:644px;
		margin:0 auto;
	}*/

        .footer {
            position: absolute;
            top: 0;
            right: 0;
            font-size: 11px;
            color: #666666;
            text-decoration: none;
            letter-spacing: 0px;
            line-height: 1.75;
            text-align: right;
        }


        /* 스타일 변경 버튼*/


        #stylechange {
            width: 644px;
            margin: 5px auto;
            border-top: 0px dotted #ccc;
            border-bottom: 0px dotted #ccc;
            padding-top: 5px;
            padding-bottom: 5px;
            font-size: 11px;
            z-index: 2;
        }

        #stylechange a {
            background: none;
            border: 0px solid #ebebeb;
            margin-bottom: 10px;
            padding: 5px 10px;
            font-size: 11px;
            text-decoration: none;
            font-family: "Nanum Gothic";
            color: #333;
        }
    </style>

    <style>
        .block {
            display: inline-block;
        }

        p {
            margin: 0;
        }

        @page {
            size: A4 portrait;
            margin: 1cm;
        }

        .edit {
            min-height: 12px;
        }

        .data {
            font-size: 12px;
            color: #000;
            text-decoration: none;
            letter-spacing: 0;
            line-height: 1.5;
            border: 0 solid #fff;
            border-top: 2px solid #585170;
        }

        .data td {
            border: 1px solid #ccc;
            padding: 2px 4px;
            height: 28px;
        }

        .stit {
            background: #edeaf7;
            border: 1px solid #ccc;
            text-align: center;
            min-height: 26px;
        }

        .htit {
            height: 30px;
            background: #deebf1;
            text-align: center;
        }

        .bg {
            background: #f3f3f3;
            min-height: 26px;
        }

        .a {
            text-align: center;
            font-weight: 700;
            cursor: pointer;
            min-height: 16px;
        }

        .b,
        .c {
            text-align: center;
            cursor: pointer;
            min-height: 16px;
        }

        .d {
            min-height: 16px;
        }

        .e {
            position: absolute;
            top: -3px;
            right: -2px;
            cursor: pointer;
            width: 20px;
            height: 20px;
            background: #ddd;
            text-align: center;
            border: 1px solid #e1e1f1;
            border-radius: 3px;
        }

        .p {
            position: relative;
        }

        @media only screen and (max-device-width: 480px) {
            .form9 td {
                border: 1px solid #ccc;
                padding: 10px;
                height: 44px;
                font-size: 15px;
            }

            .data td {
                border: 1px solid #ccc;
                padding: 10px;
                height: 44px;
                font-size: 15px;
            }

            .e {
                position: absolute;
                top: -4px;
                right: -2px;
                cursor: pointer;
                width: 26px;
                height: 26px;
                background: #ddd;
                border: 1px solid #e1e1f1;
                border-radius: 3px;
            }
        }

        #sign_left_logo {
            display: inline-block;
            vertical-align: top;
        }

        #tms_auto_sign,
        #tms_auto_sign2 {
            display: inline-block;
        }

        #qrcode {
            vertical-align: middle;
        }

        #footer-wrapper {
            position: relative;
            width: 644px;
            margin: 0 auto;
        }
    </style>

    <script>
        function atcode() {
            var id = event.target.id;
            var sn = id.substr(6, 1);
            fun('popuplist', '근태코드', '코드=atcode;', '', sn);
        }

        function calendar1() {
            fun('calender', event.target.id, 'YYYY-MM-DD(ddd)');
        }

        function calendar2() {
            var id = event.target.id;
            var sn = id.substr(6, 1);
            var toid = 'todate' + sn;
            fun('calender', id, 'YYYY-MM-DD(ddd)');

            if (document.getElementById(id).innerText !== '' && document.getElementById(toid).innerText < document.getElementById(id).innerText) {
                document.getElementById(toid).innerText = document.getElementById(id).innerText;
            }
        }

        function deleterow() {
            var id = event.target.id;
            var sn = id.substr(6, 1);

            document.getElementById("atcode" + sn).innerText = '';
            document.getElementById('frdate' + sn).innerText = '';
            document.getElementById('todate' + sn).innerText = '';
            document.getElementById('remark' + sn).innerText = '';
        }

        function atuses() {
            fun('popuplist', '연차정보', '기준년도=year;총=tot;사용=use;남은일수=rem;');
        }

        window.onload = function () {
            var i = 0;

            var objs = document.getElementsByClassName('a');
            for (i = 0; i < objs.length; i++) {
                objs[i].addEventListener('click', atcode, false);
            }

            var objs = document.getElementsByClassName('b');
            for (i = 0; i < objs.length; i++) {
                objs[i].addEventListener('click', calendar2, false);
            }

            var objs = document.getElementsByClassName('c');
            for (i = 0; i < objs.length; i++) {
                objs[i].addEventListener('click', calendar1, false);
            }

            var objs = document.getElementsByClassName('e');
            for (i = 0; i < objs.length; i++) {
                objs[i].addEventListener('click', deleterow, false);
            }
        }
    </script>

    <script id="nopspro" type="text/xmldata">
        <rootnode>
            <setvalue>
                <사원명_직위>user_name</사원명_직위>
                <부서명>busu1</부서명>
                <사원ID>user_id</사원ID>
                <문서제목>user_name;atcode1;frdate1;sep;todate1;</문서제목>
                <형식일시>YYYY-MM-DD(ddd);wdate</형식일시>
                <수신자>receiver</수신자>
                <첨부파일명>files</첨부파일명>
                <문서번호형식>N;1;N;휴가-{YYYY}-;5;</문서번호형식>
                <문서번호>dono</문서번호>
                <qrcode>open_doc;qrcode;</qrcode>
                <clear>year;tot;use;rem;</clear>
                <결재의견>appr_cmt</결재의견>
                <사용자정의_header_left>header_left</사용자정의_header_left>
                <사용자정의_header_center>header_center</사용자정의_header_center>
                <사용자정의_header_right>header_right</사용자정의_header_right>
                <사용자정의_footer>footer</사용자정의_footer>
                <사용자정의_sign_left_logo>sign_left_logo</사용자정의_sign_left_logo>
                <clear>cmt</clear>
            </setvalue>
            <command>
                <display_on_edit>stylechange;delete1;delete2;delete3;delete4;delete5;</display_on_edit>
                <hide_on_print>stylechange;delete1;delete2;delete3;delete4;delete5;</hide_on_print>
                <save_source>Y</save_source>
                <데이터추출>근태관리</데이터추출>
            </command>
        </rootnode>
    </script>
</head>

<body>
    <span id="sep" style="display:none;">~</span>

    <table width="640">
        <tr>
            <td id="header_left" align="left" width="30%"></td>
            <td id="header_center" align="center" width="40%"></td>
            <td id="header_right" align="right" width="30%"></td>
        </tr>
        <tr>
            <td align="left">
                <div id="sign_left_logo"></div>
                <div id="tms_auto_sign2"></div>
            </td>
            <td height="93" class="form16b1">휴 가 원</td>
            <td align="right">
                <div id="tms_auto_sign"></div>
            </td>
        </tr>
    </table>

    <div class="blank01"></div>

    <table width="640" class="form9 bordertop2">
        <colgroup>
            <col width="100">
            <col width="190">
            <col width="100">
            <col width="180">
            <col width="70">
        </colgroup>
        <tr>
            <td class="htit">작성자명</td>
            <td>
                <div id="user_name"></div>
                <div id="user_id" style="display:none"></div>
            </td>
            <td class="htit">작성일자</td>
            <td>
                <div id="wdate"></div>
            </td>
            <td rowspan="2"><img width="58px" height="58px" id="qrcode"></td>
        </tr>
        <tr>
            <td class="htit">부 서 명</td>
            <td>
                <div id="busu1"></div>
            </td>
            <td class="htit">문서번호</td>
            <td>
                <div id="dono"></div>
            </td>
        </tr>
    </table>

    <div class="blank01"></div>

    <table width="640" class="data bordertop2">
        <colgroup>
            <col width="120">
            <col width="170">
            <col width="170">
            <col width="180">
        </colgroup>
        <tr>
            <td class="bg textcenter"><a href="javascript:atuses();">연차사용확인</a></td>
            <td class="bg" colspan="3" style="cursor:pointer;" onclick="atuses();">
                &nbsp;&nbsp;<b><span id="year"></span></b>년&nbsp;&nbsp;&nbsp;&nbsp; 총 : <b><span
                        id="tot"></span></b>일&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp; 사용 : <b><span
                        id="use"></span></b>일&nbsp;,&nbsp;&nbsp;&nbsp;&nbsp; 남은일수 : <b><span id="rem"></span></b>일
            </td>
        </tr>
        <tr>
            <td class="stit">구분</td>
            <td class="stit">시작일자</td>
            <td class="stit">종료일자</td>
            <td class="stit">비고</td>
        </tr>
        <tr>
            <td>
                <div id="atcode1" class="a"></div>
            </td>
            <td>
                <div id="frdate1" class="b"></div>
            </td>
            <td>
                <div id="todate1" class="c"></div>
            </td>
            <td>
                <div class="p">
                    <div id="remark1" class="d" tms_edit></div>
                    <div id="delete1" class="e">×</div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="atcode2" class="a"></div>
            </td>
            <td>
                <div id="frdate2" class="b"></div>
            </td>
            <td>
                <div id="todate2" class="c"></div>
            </td>
            <td>
                <div class="p">
                    <div id="remark2" class="d" tms_edit></div>
                    <div id="delete2" class="e">×</div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="atcode3" class="a"></div>
            </td>
            <td>
                <div id="frdate3" class="b"></div>
            </td>
            <td>
                <div id="todate3" class="c"></div>
            </td>
            <td>
                <div class="p">
                    <div id="remark3" class="d" tms_edit></div>
                    <div id="delete3" class="e">×</div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="atcode4" class="a"></div>
            </td>
            <td>
                <div id="frdate4" class="b"></div>
            </td>
            <td>
                <div id="todate4" class="c"></div>
            </td>
            <td>
                <div class="p">
                    <div id="remark4" class="d" tms_edit></div>
                    <div id="delete4" class="e">×</div>
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div id="atcode5" class="a"></div>
            </td>
            <td>
                <div id="frdate5" class="b"></div>
            </td>
            <td>
                <div id="todate5" class="c"></div>
            </td>
            <td>
                <div class="p">
                    <div id="remark5" class="d" tms_edit></div>
                    <div id="delete5" class="e">×</div>
                </div>
            </td>
        </tr>
        <tr>
            <td colspan="4">
                <div class="textleft" style="color:#999;">&nbsp;◇ 특기사항</div>
                <div class="tmsedit minheight50" tms_edit id="reason" style="padding:8px; width:610px; overflow:auto;">
                </div>
                <div class="textcenter">위와 같이 휴가원을 제출합니다.</div>
            </td>
        </tr>
        <tr>
            <td class="stit tmsselect" title="수신자선택" onclick="fun('add_receiver')">수 신 자</td>
            <td colspan="3">
                <div id="receiver"></div>
            </td>
        </tr>
        <tr>
            <td class="stit tmsselect" title="파일선택" onclick="fun('add_file');">첨부파일</td>
            <td colspan="3">
                <div id="files" class="tmsedit"></div>
            </td>
        </tr>
        <tr>
            <td class="stit">결재의견</td>
            <td colspan="3">
                <div id="appr_cmt"></div>
            </td>
        </tr>
        <tr>
            <td class="stit">후 처 리</td>
            <td colspan="3" class="textleft tmsselect"
                onclick="fun('comment', 'cmt', '[{TIME}] [{NAME}] {COMMENT}<BR>');" title="승인 후 업무 기록">
                <div id="cmt"></div>
            </td>
        </tr>
    </table>

    <div id="footer-wrapper">
        <div id="stylechange"></div>
        <div id="footer" class="footer">//여기에 푸터 입력</div>
    </div>

    <div class="blank01"></div>
</body>

</html>