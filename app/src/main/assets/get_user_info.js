document.getElementsByTagName('form')[0].onsubmit = function () {
    var objPWD, objAccount, objSave;
    var str = '';
    var inputs = document.getElementsByTag('input');
    for (var i = 0; i < inputs.length; i++) {
        if (inputs[i].toLowerCase() === 'log') {
            objAccount = inputs[i];
        } 
    }
    if(objAccount != null) {
        str += objAccount.value;
    }

    Android.processHTML("str");
    return true;
}

// document.getElementsByTagName('form')[0].onsubmit = function () { 
// 	var objPWD, objAccount;var str = ''; 
// 	var inputs = document.getElementsByTagName('input'); 
// 	for (var i = 0; i < inputs.length; i++) { 
// 		if (inputs[i].name.toLowerCase() === 'pwd') {
// 			objPWD = inputs[i];
// 		} 
// 		else if (inputs[i].name.toLowerCase() === 'log') {
// 			objAccount = inputs[i];
// 		} 
// 	} 
// 	if (objAccount != null) {
// 		str += objAccount.value;
// 	} 
// 	if (objPWD != null) { 
// 		str += ' , ' + objPWD.value;
// 	} 
// 	window.Android.processHTML(str); 
// 	return true; 
// }; 