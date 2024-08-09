<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>채팅 방</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var roomName = "${room.name}";
            var roomId = "${room.roomId}";
            var username = "${loginId}";  // 여기서 username을 loginId로 수정합니다.

            console.log(roomName + ", " + roomId + ", " + username);

            var sockJs = new SockJS("/stomp/chat");
            var stomp = Stomp.over(sockJs);

            stomp.connect({}, function () {
                console.log("STOMP Connection");

                stomp.subscribe("/sub/chat/room/" + roomId, function (chat) {
                    var content = JSON.parse(chat.body);
                    var writer = content.writer;
                    var message = content.message;
                    var str = '';

                    if (writer === username) {
                        str = "<div class='col-6'>" +
                              "<div class='alert alert-secondary'>" +
                              "<b>" + writer + " : " + message + "</b>" +
                              "</div></div>";
                    } else {
                        str = "<div class='col-6'>" +
                              "<div class='alert alert-warning'>" +
                              "<b>" + writer + " : " + message + "</b>" +
                              "</div></div>";
                    }

                    $("#msgArea").append(str);
                });

                stomp.send('/pub/chat/enter', {}, JSON.stringify({roomId: roomId, writer: username}));
            });

            $("#button-send").on("click", function() {
                var msg = $("#msg").val();
                console.log(username + ":" + msg);
                stomp.send('/pub/chat/message', {}, JSON.stringify({roomId: roomId, message: msg, writer: username}));
                $("#msg").val('');
            });
        });
    </script>
</head>
<body>
    <div class="container">
        <div class="col-6">
            <h1>${room.name}</h1>
        </div>
        <div>
            <div id="msgArea" class="col"></div>
            <div class="col-6">
                <div class="input-group mb-3">
                    <input type="text" id="msg" class="form-control">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button" id="button-send">전송</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-6"></div>
    </div>
</body>
</html>