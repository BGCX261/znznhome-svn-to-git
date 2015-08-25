function $(id) { return document.getElementById(id); }
function addLoadEvent(func){
var oldonload = window.onload;
if (typeof window.onload != 'function') {
window.onload = func;
} else {
window.onload = function(){
   oldonload();
   func();
}
}
}
function moveElement(elementID,final_x,final_y,interval) {
if (!document.getElementById) return false;
if (!document.getElementById(elementID)) return false;
var elem = document.getElementById(elementID);
if (elem.movement) {
    clearTimeout(elem.movement);
}
if (!elem.style.left) {
    elem.style.left = "0px";
}
if (!elem.style.top) {
    elem.style.top = "0px";
}
var xpos = parseInt(elem.style.left);
var ypos = parseInt(elem.style.top);
if (xpos == final_x && ypos == final_y) {
return true;
}
if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/10);
    xpos = xpos + dist;
}
if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/10);
    xpos = xpos - dist;
}
if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/10);
    ypos = ypos + dist;
}
if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/10);
    ypos = ypos - dist;
}
elem.style.left = xpos + "px";
elem.style.top = ypos + "px";
var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
elem.movement = setTimeout(repeat,interval);
}
function classNormal(iFocusBtnID){
var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
for(var i=0; i<iFocusBtns.length; i++) {
iFocusBtns[i].className='normal';
}
}
function classCurrent(iFocusBtnID,n){
var iFocusBtns= $(iFocusBtnID).getElementsByTagName('li');
iFocusBtns[n].className='current';
}
function iFocusChange() {
if(!$('ifocus')) return false;
$('ifocus').onmouseover = function(){atuokey = true};
$('ifocus').onmouseout = function(){atuokey = false};
var iFocusBtns = $('ifocus_btn').getElementsByTagName('li');
var listLength = iFocusBtns.length;
iFocusBtns[0].onmouseover = function() {
moveElement('ifocus_piclist',0,0,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',0);
}
if (listLength>=2) {
iFocusBtns[1].onmouseover = function() {
   moveElement('ifocus_piclist',0,-108,5);
   classNormal('ifocus_btn');
   classCurrent('ifocus_btn',1);
}
}
if (listLength>=3) {
iFocusBtns[2].onmouseover = function() {
   moveElement('ifocus_piclist',0,-216,5);
   classNormal('ifocus_btn');
   classCurrent('ifocus_btn',2);
}
}
if (listLength>=4) {
iFocusBtns[3].onmouseover = function() {
   moveElement('ifocus_piclist',0,-324,5);
   classNormal('ifocus_btn');
   classCurrent('ifocus_btn',3);
}
}
if (listLength>=5) {
iFocusBtns[4].onmouseover = function() {
   moveElement('ifocus_piclist',0,-432,5);
   classNormal('ifocus_btn');
   classCurrent('ifocus_btn',4);
}
}
}
setInterval('autoiFocus()',5000);
var atuokey = false;
function autoiFocus() {
if(!$('ifocus')) return false;
if(atuokey) return false;
var focusBtnList = $('ifocus_btn').getElementsByTagName('li');
var listLength = focusBtnList.length;
for(var i=0; i<listLength; i++) {
if (focusBtnList[i].className == 'current') var currentNum = i;
}
if (currentNum==0&&listLength!=1 ){
moveElement('ifocus_piclist',0,-108,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',1);
}
if (currentNum==1&&listLength!=2 ){
moveElement('ifocus_piclist',0,-216,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',2);
}
if (currentNum==2&&listLength!=3 ){
moveElement('ifocus_piclist',0,-324,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',3);
}
if (currentNum==3&&listLength!=4 ){
moveElement('ifocus_piclist',0,-432,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',4);
}
if (currentNum==4 ){
moveElement('ifocus_piclist',0,0,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',0);
}
if (currentNum==1&&listLength==2 ){
moveElement('ifocus_piclist',0,0,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',0);
}
if (currentNum==2&&listLength==3 ){
moveElement('ifocus_piclist',0,0,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',0);
}
if (currentNum==3&&listLength==4 ){
moveElement('ifocus_piclist',0,0,5);
classNormal('ifocus_btn');
classCurrent('ifocus_btn',0);
}
}
addLoadEvent(iFocusChange);
//???1??
//** Featured Content Slider script- (c) Dynamic Drive DHTML code library: http://www.dynamicdrive.com.
//???2 JS??
var featuredcontentslider={
enablepersist: true, //persist to last content viewed when returning to page?
settingcaches: {}, //object to cache "setting" object of each script instance

buildcontentdivs:function(setting){
	var alldivs=document.getElementById(setting.id).getElementsByTagName("div")
	for (var i=0; i<alldivs.length; i++){
		if (this.css(alldivs[i], "contentdiv", "check")){ //check for DIVs with class "contentdiv"
			setting.contentdivs.push(alldivs[i])
				alldivs[i].style.display="none" //collapse all content DIVs to begin with
		}
	}
},

buildpaginate:function(setting){
	this.buildcontentdivs(setting)
	var sliderdiv=document.getElementById(setting.id)
	var pdiv=document.getElementById("paginate-"+setting.id)
	var toc=setting.toc
	var pdivlinks=pdiv.getElementsByTagName("a")
	var toclinkscount=0 //var to keep track of actual # of toc links
	for (var i=0; i<pdivlinks.length; i++){
		if (this.css(pdivlinks[i], "toc", "check")){
			if (toclinkscount>setting.contentdivs.length-1){ //if this toc link is out of range (user defined more toc links then there are contents)
				pdivlinks[i].style.display="none" //hide this toc link
				continue
			}
			pdivlinks[i].setAttribute("rel", ++toclinkscount) //store page number inside toc link
			pdivlinks[i][setting.revealtype]=function(){
				featuredcontentslider.turnpage(setting, this.getAttribute("rel"))
				return false
			}
			setting.toclinks.push(pdivlinks[i])
		}
		else if (this.css(pdivlinks[i], "prev", "check") || this.css(pdivlinks[i], "next", "check")){ //check for links with class "prev" or "next"
			pdivlinks[i].onclick=function(){
				featuredcontentslider.turnpage(setting, this.className)
				return false
			}
		}
	}
	this.turnpage(setting, setting.currentpage, true)
	if (setting.autorotate[0]){ //if auto rotate enabled
		pdiv[setting.revealtype]=function(){
			featuredcontentslider.cleartimer(setting, window["fcsautorun"+setting.id])
		}
		sliderdiv["onclick"]=function(){ //stop content slider when slides themselves are clicked on
			featuredcontentslider.cleartimer(setting, window["fcsautorun"+setting.id])
		}
		setting.autorotate[1]=setting.autorotate[1]+(1/setting.enablefade[1]*50) //add time to run fade animation (roughly) to delay between rotation
	 this.autorotate(setting)
	}
},

urlparamselect:function(fcsid){
	var result=window.location.search.match(new RegExp(fcsid+"=(\\d+)", "i")) //check for "?featuredcontentsliderid=2" in URL
	return (result==null)? null : parseInt(RegExp.$1) //returns null or index, where index (int) is the selected tab's index
},

turnpage:function(setting, thepage, autocall){
	var currentpage=setting.currentpage //current page # before change
	var totalpages=setting.contentdivs.length
	var turntopage=(/prev/i.test(thepage))? currentpage-1 : (/next/i.test(thepage))? currentpage+1 : parseInt(thepage)
	turntopage=(turntopage<1)? totalpages : (turntopage>totalpages)? 1 : turntopage //test for out of bound and adjust
	if (turntopage==setting.currentpage && typeof autocall=="undefined") //if a pagination link is clicked on repeatedly
		return
	setting.currentpage=turntopage
//	setting.contentdivs[turntopage-1].style.zIndex=++setting.topzindex
	this.cleartimer(setting, window["fcsfade"+setting.id])
	setting.cacheprevpage=setting.prevpage
	if (setting.enablefade[0]==true){
		setting.curopacity=0
		this.fadeup(setting)
	}
	if (setting.enablefade[0]==false){ //if fade is disabled, fire onChange event immediately (verus after fade is complete)
		setting.contentdivs[setting.prevpage-1].style.display="none" //collapse last content div shown (it was set to "block")
		setting.onChange(setting.prevpage, setting.currentpage)
	}
	setting.contentdivs[turntopage-1].style.visibility="visible"
	setting.contentdivs[turntopage-1].style.display="block"
	if (setting.prevpage<=setting.toclinks.length) //make sure pagination link exists (may not if manually defined via "markup", and user omitted)
		this.css(setting.toclinks[setting.prevpage-1], "selected", "remove")
	if (turntopage<=setting.toclinks.length) //make sure pagination link exists (may not if manually defined via "markup", and user omitted)
		this.css(setting.toclinks[turntopage-1], "selected", "add")
	setting.prevpage=turntopage
	if (this.enablepersist)
		this.setCookie("fcspersist"+setting.id, turntopage)
},

setopacity:function(setting, value){ //Sets the opacity of targetobject based on the passed in value setting (0 to 1 and in between)
	var targetobject=setting.contentdivs[setting.currentpage-1]
	if (targetobject.filters && targetobject.filters[0]){ //IE syntax
		if (typeof targetobject.filters[0].opacity=="number") //IE6
			targetobject.filters[0].opacity=value*100
		else //IE 5.5
			targetobject.style.filter="alpha(opacity="+value*100+")"
	}
	else if (typeof targetobject.style.MozOpacity!="undefined") //Old Mozilla syntax
		targetobject.style.MozOpacity=value
	else if (typeof targetobject.style.opacity!="undefined") //Standard opacity syntax
		targetobject.style.opacity=value
	setting.curopacity=value
},

fadeup:function(setting){
	if (setting.curopacity<1){
		this.setopacity(setting, setting.curopacity+setting.enablefade[1])
		window["fcsfade"+setting.id]=setTimeout(function(){featuredcontentslider.fadeup(setting)}, 50)
	}
	else{ //when fade is complete
		if (setting.cacheprevpage!=setting.currentpage) //if previous content isn't the same as the current shown div (happens the first time the page loads/ script is run)
			setting.contentdivs[setting.cacheprevpage-1].style.display="none" //collapse last content div shown (it was set to "block")
		setting.onChange(setting.cacheprevpage, setting.currentpage)
	}
},

cleartimer:function(setting, timervar){
	if (typeof timervar!="undefined"){
		clearTimeout(timervar)
		clearInterval(timervar)
		if (setting.cacheprevpage!=setting.currentpage){ //if previous content isn't the same as the current shown div
			setting.contentdivs[setting.cacheprevpage-1].style.display="none"
		}
	}
},

css:function(el, targetclass, action){
	var needle=new RegExp("(^|\\s+)"+targetclass+"($|\\s+)", "ig")
	if (action=="check")
		return needle.test(el.className)
	else if (action=="remove")
		el.className=el.className.replace(needle, "")
	else if (action=="add")
		el.className+=" "+targetclass
},

autorotate:function(setting){
 window["fcsautorun"+setting.id]=setInterval(function(){featuredcontentslider.turnpage(setting, "next")}, setting.autorotate[1])
},

getCookie:function(Name){ 
	var re=new RegExp(Name+"=[^;]+", "i"); //construct RE to search for target name/value pair
	if (document.cookie.match(re)) //if cookie found
		return document.cookie.match(re)[0].split("=")[1] //return its value
	return null
},

setCookie:function(name, value){
	document.cookie = name+"="+value

},

init:function(setting){
	var persistedpage=this.getCookie("fcspersist"+setting.id) || 1
	var urlselectedpage=this.urlparamselect(setting.id) //returns null or index from: mypage.htm?featuredcontentsliderid=index
	this.settingcaches[setting.id]=setting //cache "setting" object
	setting.contentdivs=[]
	setting.toclinks=[]
//	setting.topzindex=0
	setting.currentpage=urlselectedpage || ((this.enablepersist)? persistedpage : 1)
	setting.prevpage=setting.currentpage
	setting.revealtype="on"+(setting.revealtype || "click")
	setting.curopacity=0
	setting.onChange=setting.onChange || function(){}
	if (setting.contentsource[0]=="inline")
		this.buildpaginate(setting)
}

}
//???2 JS??