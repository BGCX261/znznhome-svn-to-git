        function iframeTest() {            
        	var frame1 = document.getElementById("iframeA");           
        	var frame2 = document.getElementById("iframeB");            
        	var frameA = document.frames["iframeA"]; //等价于 var frameAa = document.frames.iframeA;    
        	var frameB = document.frames["iframeB"]; //等价于 var frameBb = document.frames.iframeB;  
        	//**********************************************            
        	alert(frame1 == frameA); //false 
        	alert(frame2 == frameB); //false           
        	alert(frame1.src); //FrameA.aspx         
        	alert(frame1.location); //undefined         
        	alert(frameA.src); //undefined          
        	alert(frameA.location); //location           
        	alert(frameA.document.location);           
        	alert(frame1.document.body.innerHTML); //这里返回的是MainForm.aspx的body里的innerHTML 
        	alert(frame1.document.documentElement.innerHTML); //这里返回的是MainForm.aspx的html里的innerHTML  
        	alert(frameA.document.body.innerHTML); //这里返回的是FrameA.aspx的body里的innerHTML            
        	alert(frameA.document.documentElement.innerHTML); //这里返回的是FrameA.aspx的html里的innerHTML       
        	//**********************************************               var childFrameDoc = undefined;      
        	//取FrameA.aspx内的input文本        
        	if (document.all) {//IE            
        	childFrameDoc = frameA.document; //*** 如果是frame1,就取不到FrameA.aspx页面里的input ***   
        	} else {
        		//Firefox               
        		childFrameDoc = frameA.contentDocument;         
        		
        	}     
        		alert(childFrameDoc.body.innerHTML);       
        		var childTxt = childFrameDoc.getElementById("txtUserName");    
        		var childTxtByName = childFrameDoc.getElementsByName("txtUserName");       
        		alert(childTxt == childTxtByName[0]); //true       
        		alert(childTxt.value); //jeff wong          
        		alert(childTxtByName[0].value); // jeff wong      
        		//取FrameB.aspx内的input文本            
        		childFrameDoc = undefined;    
        		if (document.all) {//IE            
        			childFrameDoc = frameB.document;          
        			} 
        		else {//Firefox              
        			childFrameDoc = frameB.contentDocument;        
        			}           
        		alert(childFrameDoc.body.innerHTML);   
        		var childTxt = childFrameDoc.getElementById("txtUserNameB");    
        		var childTxtByName = childFrameDoc.getElementsByName("txtUserNameB");        
        		alert(childTxt == childTxtByName[0]); //true      
        		alert(childTxt.value); //jeffery zhao          
        		alert(childTxtByName[0].value); // jeffery zhao      
        		}
