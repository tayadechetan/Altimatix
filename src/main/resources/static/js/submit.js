[‎10/‎15/‎2018 5:54 PM]  Siddharth Singh:  
No Title 
$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#loginForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		email : $("#email").val(),
    		password :  $("#password").val()
    	}
    	
    	console.log(window.location + "j_spring_security_check");
    	console.log( JSON.stringify(formData))
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "j_spring_security_check",
			data : JSON.stringify(formData),
			dataType : 'json',
			success : function(result){
				console.log("####################  " + result)
			}
		});
    	
    	
    	

    }
    
   
}) 
 
