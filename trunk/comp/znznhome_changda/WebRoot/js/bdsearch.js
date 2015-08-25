function baidusearchTop() 
	{ 
	var searchValue=document.getElementsByName("bdsearch")[0].value; 
	var linkValue="http://www.baidu.com/s?si=www.hongyibj.com&cl=3&ct=2097152&tn=baidulocal&word="+searchValue; 
	window.open(linkValue); 
	}