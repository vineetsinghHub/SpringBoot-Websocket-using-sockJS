	
	const stompClient = new StompJs.Client({
  	  brokerURL: 'ws://localhost:8081/gs'
	});
		stompClient.onConnect = (frame) => {
		    setConnected(true);
		    console.log('Connected: ' + frame);
			
		    stompClient.subscribe('/all/messages', (greeting) => {
		        showGreeting(JSON.parse(greeting.body).content);
				console.log(greeting);
				showResponse(greeting.body);
		    });
			//stompClient.subscribe('/user/specific/messages', function (message) {
				//console.log(message);
			      //         showResponse(message.body);
			       //    });
		};

		stompClient.onWebSocketError = (error) => {
		    console.error('Error with websocket', error);
		};

		stompClient.onStompError = (frame) => {
		    console.error('Broker reported error: ' + frame.headers['message']);
		    console.error('Additional details: ' + frame.body);
		};

      {/*  stompClient.connect({}, function (frame) {
			console.log(frame);
            console.log('Connected: ' + frame);
            stompClient.subscribe('/all/messages', function (message) {
                showResponse(message.body);
            });
            stompClient.subscribe('/user/specific/messages', function (message) {
                showResponse(message.body);
            });
        });
		*/}
        function sendMessage() {
            //var message = document.getElementById("messageInput").value;
            stompClient.send("/app/sendToAll", {}, "hi ::");
        }

        function sendSpecific() {
            var message = {
                username: 'user1', // Example user, change as needed
                message: document.getElementById("messageInput").value
            };
            stompClient.send("/app/sendToSpecific", {}, JSON.stringify(message));
        }

        function showResponse(message) {
            var responseDiv = document.getElementById("response");
            responseDiv.innerHTML += "<p>" + message + "</p>";
        }
		
		function setConnected(connected) {
		    $("#connect").prop("disabled", connected);
		    $("#disconnect").prop("disabled", !connected);
		    if (connected) {
		        $("#conversation").show();
		    }
		    else {
		        $("#conversation").hide();
		    }
		    $("#greetings").html("");
		}

		function connect() {
		    stompClient.activate();
		}

		function disconnect() {
		    stompClient.deactivate();
		    setConnected(false);
		    console.log("Disconnected");
		}

		function sendName() {
		    stompClient.publish({
		        destination: "/app/hello",
		        body: JSON.stringify({'name': $("#name").val()})
		    });
		}

		function showGreeting(message) {
		    $("#greetings").append("<tr><td>" + message + "</td></tr>");
		}

		
		$(function () {
		    $("form").on('submit', (e) => e.preventDefault());
		    $( "#connect" ).click(() => connect());
		    $( "#disconnect" ).click(() => disconnect());
		    $( "#send" ).click(() => sendMessage());
		});
