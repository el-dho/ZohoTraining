/**
 * 
 */

const isUsername = (username) =>{
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

function Validate1(){
	let name =
        document.forms.form.name.value;
    let username =
        document.forms.form.username.value;
    let password =
        document.forms.form.password.value;
    let address =
        document.forms.form.address.value;
        
   	//name
	if(name === ""){
		document.getElementById("nameError").innerHTML = "*Name cannot be blank";
		document.getElementById("nameError").style.color = "Red";
		return false;
	}
	else if(name.length < 3){
		document.getElementById("nameError").innerHTML = "*Minimum 3 characters required";
		document.getElementById("nameError").style.color = "Red";
		return false;
	}
	else{
		document.getElementById("nameError").innerHTML = "";

	}
        
    //username
    if(username === ""){
		document.getElementById("usernameError").innerHTML = "*Username cannot be blank";
		document.getElementById("usernameError").style.color = "Red";
		return false;
	}
	else if(!isUsername(username)){
		document.getElementById("usernameError").innerHTML = "*Username not valid";
		document.getElementById("usernameError").style.color = "Red";
		return false;
	}
	else{
		document.getElementById("usernameError").innerHTML = "";

	}
	
	//password
	let numberPattern = /[0-9]/g;
	let alphaPattern = /[A-Z]/gi;
	let specialPattern = /[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/g;
	
	if(password === ""){
		document.getElementById("passwordError").innerHTML = "*Password cannot be blank";
		document.getElementById("passwordError").style.color = "Red";
		return false;
	}
	else if(password.length < 3){
		document.getElementById("passwordError").innerHTML = "*Minimum 3 characters required";
		document.getElementById("passwordError").style.color = "Red";
		return false;
	}
	else if(password.length > 8){
		document.getElementById("passwordError").innerHTML = "*Maximum 8 characters required";
		document.getElementById("passwordError").style.color = "Red";
		return false;
	}
	else if(!numberPattern.test(password)){
		document.getElementById("passwordError").innerHTML = "*Password has no numbers";
		document.getElementById("passwordError").style.color = "Red";
		return false;
	}
	else if(!alphaPattern.test(password)){
		document.getElementById("passwordError").innerHTML = "*Password has no alphabets";
		document.getElementById("passwordError").style.color = "Red";
		return false;
	}
	else if(!specialPattern.test(password)){
		document.getElementById("passwordError").innerHTML = "*Password has no special characters";
		document.getElementById("passwordError").style.color = "Red";
	}
	else{
		document.getElementById("passwordError").innerHTML = "";
	}

	//address
	if(address === ""){
		document.getElementById("addressError").innerHTML = "*Address cannot be blank";
		document.getElementById("addressError").style.color = "Red";
		return false;
	}
	else{
		document.getElementById("addressError").innerHTML = "";
	}
	window.alert("Succes");
}