function setErrorMsg(errorId,message){
	document.getElementById(errorId).innerHTML = message;
	document.getElementById(errorId).style.color = "Red";
}

function removeErrorMsg(errorId){
	document.getElementById(errorId).innerHTML = "";
}



function validateName(){
	let name = document.forms.form.name.value;
	if(name === ""){
		setErrorMsg("nameError","*Name cannot be blank");
		return false;
	}
	else if(name.length < 3){
		setErrorMsg("nameError","*Minimum 3 characters required");
		return false;
	}
	else{
		removeErrorMsg("nameError");
		return false;
	}
	
}

let isUsername = (username) =>{
    let atSymbol = username.indexOf('@');
    if(atSymbol < 1){
		return false;
	}
    let dot = username.lastIndexOf('.');
    if(dot <= atSymbol + 2){
		return false;
	}
    return true;
}

function validateUsername(){
	let username = document.forms.form.username.value;
	if(username === ""){
		setErrorMsg("usernameError","*Username cannot be blank");
		return false;
	}
	else if(!isUsername(username)){
		setErrorMsg("usernameError","*Username not valid");
		return false;
	}
	else{
		removeErrorMsg("usernameError");
		return false;
	}
}

function validatePassword(){
	let password = document.forms.form.password.value;
	let numberPattern = /[0-9]/g;
	let alphaPattern = /[A-Z]/gi;
	let specialPattern = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/g;
	if(password === ""){
		setErrorMsg("passwordError","*Password cannot be blank");
		return false;
	}
	else if(password.length < 3){
		setErrorMsg("passwordError","*Minimum 3 characters required");
		return false;
	}
	else if(password.length > 8){
		setErrorMsg("passwordError","*Maximum 8 characters required");
		return false;
	}
	else if(!numberPattern.test(password)){
		setErrorMsg("passwordError","*Password has no numbers");
		return false;
	}
	else if(!alphaPattern.test(password)){
		setErrorMsg("passwordError","*Password has no alphabets");
		return false;
	}
	else if(!specialPattern.test(password)){
		setErrorMsg("passwordError","*Password has no special characters");
		return false;
	}
	else{
		removeErrorMsg("passwordError");
		return false;
	}
}

function validateAddress(){
	let address = document.forms.form.address.value;
	if(address === ""){
		setErrorMsg("addressError","*Address cannot be blank");
		return false;
	}
	else{
		removeErrorMsg("addressError");
		return false;
	}
}