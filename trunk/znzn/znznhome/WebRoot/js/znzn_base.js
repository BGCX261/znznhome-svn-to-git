
function showDescr (baseID, divID, ev) {
    baseID = document.getElementById(baseID );
    divID  = document.getElementById(divID );
    if (showDescr.timer) clearTimeout(showDescr.timer);
	hideCur();
    divID.style.display = 'block';
    if(ev.pageX || ev.pageY) {
    	divID.style.left = ev.pageX + 18 + "px";
    	divID.style.top = ev.pageY + 10 + "px";
    } else {
    	divID.style.pixelLeft = window.event.clientX + (window.document.body.scrollLeft || document.documentElement.scrollLeft) - (window.document.body.clientLeft || document.documentElement.clientLeft) + 18 ;
    	divID.style.pixelTop = window.event.clientY + (window.document.body.scrollTop || document.documentElement.scrollTop) - (window.document.body.clientTop || document.documentElement.clientTop) + 8 ;
    }

	showDescr.cur = divID;

    if (! divID.isCreate) {
        divID.isCreate = true;
        //divID.timer = 0;
        divID.onmouseover = function () {
            if (showDescr.timer) clearTimeout(showDescr.timer);
			hideCur();
            divID.style.display = 'block';
        };

        function hide () {
            showDescr.timer = setTimeout(function () {divID.style.display = 'none';}, 1000);
        }

        divID.onmouseout = hide;
        baseID.onmouseout = hide;
    }
	function hideCur () {
		showDescr.cur && (showDescr.cur.style.display = 'none');
	}
}

function fillUrl(inputId) {
	document.getElementById(inputId).value=document.URL;
}

function urlChinese(name){ 
   	return encodeURI(name); 
} 

function test1() {
	//alert($("input[name=urlIDs]:checked").val());
	var a = $("#urlIDs").attr("checked",true).get();
	alert(a[0]);
	alert(a[1]);
}

			function znzn_up(id) {
				$.ajax({url:'ajax/url-upByAjax',type : 'POST', data:{'urlID' : id}, success:function(data) {callBack(data);}
								}); 
			}
			
			function znzn_down(id) {
				$.ajax({url:'ajax/url-downByAjax',type : 'POST', data:{'urlID' : id}, success:function(data) {callBack(data);}
								}); 
			}
			
			function znzn_click(id) {
				$.ajax({url:'ajax/url-clickrateByAjax',type : 'POST', data:{'urlID' : id}, success:function(data) {callBack(data);}
								}); 
			}
			
			function callBack(data) {
				var obj_ = eval("(" + data + ")");
				//alert(obj_.rstStr);
				if(obj_.state == -1) {
					alert(obj_.rstStr);
				}else{
					if(obj_.method == "up"){
						$("#up_" + obj_.urlID ).html(obj_.count);
					}else if(obj_.method == "down"){
						$("#down_" + obj_.urlID ).html(obj_.count);
					}else if(obj_.method == "click"){
						$("#click_" + obj_.urlID ).html(obj_.count);
					}else if(obj_.method == "deleteBatch"){
						alert(obj_.rstStr);
					}
				}
				
			}
			
			function deleteBatch() {
				var urlIDs = new Array();
				$("input[@name='urlIDs']:checked").each(function() {urlIDs.push($(this).val());});
				var idStr = urlIDs.join(',');
				$.ajax({url:'ajax/url-deleteBatch',type : 'POST', data:{'urlIDs' : idStr}, success:function(data) {callBack(data);}
								}); 

			}