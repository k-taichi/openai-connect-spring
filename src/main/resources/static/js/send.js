$( function() {
    $('#ajaxButton').on('click', function () {
        // Ajaxリクエストを発行
        var sendData={question: $("#inputField").val()};
        $.ajax({
            url: '/send', // サーバーエンドポイントのURLを指定
            type: 'POST', // GETやPOSTなどのHTTPメソッドを指定
            contentType:'application/json;charset=UTF-8',
            dataType: 'json', // サーバーからのレスポンスのデータタイプを指定
            data: JSON.stringify(sendData),
            success: function (response) {
                // 成功時の処理
                console.log('Ajax Success:', response);
                $("#outputField").html(response.message.replace(/\n/g,'<br />'))
            },
            error: function (xhr, status, error) {
                // エラー時の処理
                console.error('Ajax Error:', status, error);
            }
        });
    });
});