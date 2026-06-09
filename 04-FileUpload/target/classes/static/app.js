function validateForm(){
	const fileName = document.getElementById("file");
	if(!fileName.value){
		alert("Please select file");
		return false; //to stop form submit
	}
	return true;
}