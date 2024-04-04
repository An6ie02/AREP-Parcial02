function loadGetMsg() {
    let numberList = document.getElementById("list1").value;
    let value = document.getElementById("number1").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("getrespmsg").innerHTML =
        this.responseText;
    }
    xhttp.open("GET", "/linealSearch?list="+numberList+"&value="+value);
    xhttp.send();
}

function loadGetMsg2() {
    let numberList = document.getElementById("list2").value;
    let value = document.getElementById("number2").value;
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("getrespmsg2").innerHTML =
        this.responseText;
    }
    xhttp.open("GET", "/binarySearch?list="+numberList+"&value="+value);
    xhttp.send();
}
