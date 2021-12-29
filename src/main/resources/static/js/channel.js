var msgBox = document.getElementById('messageBox')
console.log(msgBox)
let messageContainer = document.getElementById("messageDisplay")
const queryString = window.location.href;
console.log(queryString)
let userId = user.userId
console.log(userId)
let channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);
console.log(channelId)

let messageDisplay = document.getElementById("messageDisplay")
console.log(messageDisplay)

msgBox.addEventListener("keypress", submitOnEnter);

//setInterval(500, getMessages())

function submitOnEnter(event) {
	if (event.keyCode === 13) {
		let message = {
			messageContent: msgBox.value,
			channelId: channelId,
			userId: userId
		}
		console.log("submitting message")
		fetch(`/channels/${channelId}/createMessage`, {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify(message)

		}).then(response => {getMessages()})

		
		return false;
	}
}


function getMessages(){
	
	fetch(`/channels/${channelId}/getMessages`, {
		method: "POST",
		headers: {
				"Content-Type": "application/json"
		}
		}).then(response => response.json).then(messages => { 
//			messageContainer.innerHTML = ''
//			messages.forEach(message => {
				console.log(messages.toString)
//				messageContainer.innerHTML += `<div>
//			   	  <span class="name">${user.name}: </span>
//		  		  <span class="message">${message.messgeContent}</span>
//				  </div>`
		})
//	})
	
	
}




