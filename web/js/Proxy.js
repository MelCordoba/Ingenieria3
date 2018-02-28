var Proxy = Proxy || {};

Proxy.userLogin = function(user,callBack){
    jsonText = JSON.stringify(user,JsonUtils.replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/SIMUTE/Login?action=login";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,JsonUtils.revive );
            callBack(object);
        }
    };
    AJAX_req.send("user="+jsonText);   
};

Proxy.userLogout = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    url="/SIMUTE/Login?action=logout";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            callBack();
        }
    };
    AJAX_req.send();   
};
