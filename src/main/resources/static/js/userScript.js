function parseJSON(data) {
    return window.JSON && window.JSON.parse ? window.JSON.parse( data ) : (new Function("return " + data))(); 
}

$(document).ready(function() {
    var userJson = $('#user');
    user = parseJSON(userJson.val());
    alert(user.firstName);
});