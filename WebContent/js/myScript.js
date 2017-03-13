function checkForm() {
	var email = document.getElementById("email").value;
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (re.test(email) == false) {
		alert("email is not valid");
		return false;
	}
	
	return true;
}

function checkPassword() {
	var pass1 = document.getElementById("password").value;
	var pass2 = document.getElementById("password1").value;
	
	if (pass1 != pass2) {
		window.alert("Niste unijeli identicnu sifru kao u prethodnom polju, molimo da pokusate ponovo");
		document.getElementById("mySubmit").disabled = true;
		return false;
	} else {
		document.getElementById("mySubmit").disabled = false;
		return true;
	}
}

function checkName(){
	var name = document.getElementById("firstName").value;
	if (name.length > 30) {
		window.alert("Morate unijeti ime duzine izmedju 0 i 30 karaktera");
		document.getElementById("mySubmit").disabled = true;
		
		return false;
	} else {
		document.getElementById("mySubmit").disabled = false;
		return true;
	}
}

function checkLastName(){
	var lastName = document.getElementById("lastName").value;
	if (lastName.length > 30) {
		window.alert("Morate unijeti prezime duzine izmedju 0 i 30 karaktera");
		return false;
	} else {
		return true;
	}
}

function checkPassword2() {
	var pass1 = document.getElementById("password").value;
	var pass2 = document.getElementById("password1").value;
	
	if (pass1 != pass2) {
		window.alert("Niste unijeli odgovarajucu sifru, pokusajte ponovo!");
		return false;
	} else {
		return true;
	}
}

function checkTitle() {
	var title = document.getElementById("title").value;
	if (title.length > 30) {
		window.alert("Naslov ne smije biti duzi od 30 karaktera");
		document.getElementById("mySubmit").disabled = true;
		return false;
	} else {
		document.getElementById("mySubmit").disabled = false;
		return true;
	}
}
