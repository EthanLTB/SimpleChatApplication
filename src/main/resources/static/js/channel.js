var msgBox = document.getElementById('messageBox')

function submitOnEnter(event) {
	if (event.keyCode == 13) { this.form.submit(); return false; }
	let message = {
		messageContent: msgBox.value,
		channelId: channelId,
		user: user
	}
	fetch("/createMessage", {
		method: "POST",
		headers: {
			// 			"Content-Type": "application/json",
		},
		body: JSON.stringify(message)
	}).then(response => response.json())

}



msgBox.addEventListener("keydown", submitOnEnter);