function formatAMPM(date) {
    var hours = date.getHours();
    var minutes = date.getMinutes();
    var ampm = hours >= 12 ? 'PM' : 'AM';
    hours = hours % 12;
    hours = hours ? hours : 12; // the hour '0' should be '12'
    minutes = minutes < 10 ? '0'+minutes : minutes;
    var strTime = hours + ':' + minutes + ' ' + ampm;
    return strTime;
}            


function insertChat(who, text){
    var control = "";
    var date = formatAMPM(new Date());
    
    if (who %2 == 0){
    	control = '<div class="container green">'+
  					  '<img src="http://s1.thingpic.com/images/2T/1SL9eAWko9U1ZhnPvMvAzvw2.png" alt="Avatar" style="width:100%;">'+
					  '<p>'+text+'</p>'+
				    '<span class="time-right">'+date+'</span>'+
                   '</div>';
                  
    }else{
        control = '<div class="container darker">'+
        			  '<img src="http://cdn.newsapi.com.au/image/v1/9fdbf585d17c95f7a31ccacdb6466af9" alt="Avatar" class="right" style="width:100%;">'+
        			  '<p class="text-right">'+text+'</p>'+
        			  '<span class="time-left">'+date+'</span>'
        		   '</div>';
    }
    var cd = document.getElementById("customcol-92");
	cd.innerHTML += control;
    
}

function resetChat(){
	var cd = document.getElementsByClassName("chatdisplay");
	cd='';
}