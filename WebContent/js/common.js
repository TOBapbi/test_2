﻿// JavaScript Document

function g(o){return document.getElementById(o);}

function openmenu(n){
	var subname = g("sub_" + n).style.display;
	for (i=1; i<16;i++){
		if (g("sub_" + i)!= null && i != n){
			g("menu_" + i).style.background="url(/images/left_menu_#1D64CF1.gif)";
			g("sub_" + i).style.display = "none";
		}
	}
	if(subname == "none"){
		g("sub_" + n).style.display = "block";
		g("menu_" + n).style.background="url(/images/left_menu_#1D64CF2.gif)";
	} else {
		g("menu_" + n).style.background="url(/images/left_menu_#1D64CF1.gif)";
		g("sub_" + n).style.display = "none";
	}
}

function bar()
{
    var openif = g("lefttd").style.display;
    if(openif != "none")
    {
      g("lefttd").style.display = "none";
      g("img1").src = "/images/left_open.gif";
    }else{
      g("lefttd").style.display = "";
      g("img1").src = "/images/left_close.gif";
    }
}
 
 
 
function fetchPageSize(){
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
      xScroll = document.body.scrollWidth;
      yScroll = window.innerHeight + window.scrollMaxY;
    }else if(document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
      xScroll = document.body.scrollWidth;
      yScroll = document.body.scrollHeight;
    }else{ // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
      xScroll = document.body.offsetWidth;
      yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if(self.innerHeight){ // all except Explorer
      windowWidth = self.innerWidth;
      windowHeight = self.innerHeight;
    }else if(document.documentElement && document.documentElement.clientHeight){ // Explorer 6 Strict Mode
      windowWidth = document.documentElement.clientWidth;
      windowHeight = document.documentElement.clientHeight;
    }else if(document.body){ // other Explorers
      windowWidth = document.body.clientWidth;
      windowHeight = document.body.clientHeight;
    }
    // for small pages with total height less then height of the viewport
    var pageWidth,pageHeight;
    if(yScroll < windowHeight){
      pageHeight = windowHeight;
    }else{
      pageHeight = yScroll;
    }
    // for small pages with total width less then width of the viewport
    if(xScroll < windowWidth){
      pageWidth = windowWidth;
    }else{
      pageWidth = xScroll;
    }
    return new Array(pageWidth,pageHeight,windowWidth,windowHeight);
}

function Resize() {
	//document.getElementById("bottom_table").height= fetchPageSize()[1] - 135;
	if(document.getElementById("bar_td") != null){
		var myheight=fetchPageSize()[1] - 60;
		document.getElementById("bar_td").height= myheight;
		document.getElementById("left").height= myheight;
		document.getElementById("main").height= myheight;
	}
}

function switchSysBar(){
  var obj = document.getElementById("switchPoint");

  if (obj.alt == "关闭左栏"){
    obj.alt = "打开左栏";
    obj.src = "../../images/nav_show.gif";
    document.getElementById("frmTitle").style.display="none";

  }
  else{
    obj.alt = "关闭左栏";
    obj.src = "../../images/nav_hide.gif";
    document.getElementById("frmTitle").style.display="";

  }
}
//系统开关变量授权
function userSwitch(switchName)
{
    var URL;
    URL="Power_UserSwitch.aspx?Switch=" + switchName;
    parent.ShowPage(URL,"权限分配");

}
//用户编辑开关
function userEditSwitch(switchName)
{
	
    var URL;
    URL="../Adminis/UserEditSwitch.aspx?Switch=" + switchName;
    parent.ShowPage(URL,"系统开关");
}
//提交毕业论文
function bylw(xh,bjh)
{
    var URL;
    URL="College_Bylw_Edit.aspx?xh=" + xh + "&bjh=" + bjh;
    parent.ShowPage(URL,"");

}
function bylwSXW(xh,bjh)
{
    var URL;
    URL="College_Bylw_SXWEdit.aspx?xh=" + xh + "&bjh=" + bjh;
    parent.ShowPage(URL,"");

}

//学院编辑奖惩
function collegeJC(xh)
{
    var URL;
    URL="..//User_College//Student_Jc.aspx?UserNum=" + xh;
    parent.ShowPage(URL,"");

}

//课程大纲编辑
//编辑章
function editZ(kcmlh,zh)
{
    var URL;
    URL="kcdg_edit_z.aspx?kcmlh=" + kcmlh + "&z=" + zh;
    parent.ShowPage(URL,"编辑章内容");
}
//添加章
function addZ(kcmlh)
{
    var URL;
    URL="kcdg_add_z.aspx?kcmlh=" + kcmlh;
    parent.ShowPage(URL,"添加章内容");
}
//编辑节
function editJ(kcmlh,zh,jh)
{
    var URL;
    URL="kcdg_edit_j.aspx?kcmlh=" + kcmlh + "&z=" + zh + "&j=" + jh;
    parent.ShowPage(URL,"编辑节内容");
}
//添加章
function addJ(kcmlh,zh)
{
    var URL;
    URL="kcdg_add_j.aspx?kcmlh=" + kcmlh + "&z=" + zh;
    parent.ShowPage(URL,"添加节内容");
}

//新生导师制：查看学生的人生规划
function showStudentXygh(xh) {
    var URL;
    URL = "../MyControl/daoshi_view_xygh.aspx?xh=" + xh;
    parent.ShowPageNoRefresh(URL, "学业(人生)规划、推荐书目",680,600);
}
//新生导师制：新增工作日志
function showWorkLogAdd() {
    var URL;
    URL = "../MyControl/daoshi_worklog_add.aspx";
    parent.ShowPageRefresh(URL, "新增工作日志",500, 600);
}
function showWorkLogView(ID) {
    var URL;
    URL = "../MyControl/daoshi_worklog_view.aspx?ID=" + ID + "&action=p";
    parent.ShowPageNoRefresh(URL, "工作日志", 500, 600);
}

//第二专业学院审核弹出页面
function DezyXysh(xh)
{
    var URL;
    URL="Dezy_Bm_college_sh.aspx?xh=" + xh;
    parent.ShowPage(URL,"第二专业学位报名审核");
}
//第二专业学院审核弹出页面
function DezyJwcsh(xh)
{
    var URL;
    URL="Dezy_Bm_jwc_sh.aspx?xh=" + xh;
    parent.ShowPage(URL, "第二专业学位报名审核");

}


//结业补考报名
function JybkBm(kch)
{
    var URL;
    URL="Jybk_Xs_bm.aspx?kch=" + kch;
    parent.ShowPage(URL,"结业补考报名窗口");
} 
//结业补考报名
function JybkXyBm(kch,xh)
{
    var URL;
    URL="Jybk_xy_bm.aspx?kch=" + kch + "&xh=" + xh;
    ShowPage(URL,"结业补考报名窗口");
} 
//结业补考报名
function JybkJwcBm(kch,xh)
{
    var URL;
    URL="Jybk_jwc_bm.aspx?kch=" + kch + "&xh=" + xh;
    ShowPage(URL,"教务处 结业补考报名窗口");
} 

//辅修专业审核页面
function FxzyJwcsh(xh)
{
    var URL;
    URL="Fxzy_Bm_jwc_sh.aspx?xh=" + xh;
    parent.ShowPage(URL,"辅修报名审核");
}

//转专业  转出学院审核
function zzyOutCollege(xh)
{
    var URL;
    URL="zzy_college_outSH.aspx?xh=" + xh;
    parent.ShowPage(URL,"转出学生学院审核");
}
//转专业  转入学院审核
function zzyInCollege(xh)
{
    var URL;
    URL="zzy_college_inSH.aspx?xh=" + xh;
    parent.ShowPage(URL,"转入学生学院审核");
}



//仿windows关机效果
function ShowPage(URL,TITLE)
{
    var h = 600;
    var w = 800;
	var p=document.createElement("DIV");
	if (!URL) var URL='blank:';
	
	
	p.id="p";
	p.style.position="absolute";
	p.style.width=document.body.scrollWidth;
	p.style.height= fetchPageSize()[1];    //(document.body.offsetHeight>document.body.scrollHeight)?'100%':document.body.scrollHeight;
	p.style.zIndex='998';
	p.style.top='0px';
  	p.style.left='0%';
	p.style.backgroundColor="gray";
	p.style.opacity='0.5';
	p.style.filter="alpha(opacity=80)";
	document.body.appendChild(p);
	
	var p1=document.createElement("DIV");
	var top=parseInt(parseInt(document.body.scrollHeight)*0.25)+document.body.scrollTop;
	p1.style.position="absolute";
	p1.style.width="800px";
	p1.id="p1";
	var left=Math.ceil(((document.body.scrollWidth)-parseInt(p1.style.width.replace('px','')))/2)+document.body.scrollLeft;
	p1.style.height="200px";
	p1.style.zIndex='999';	
	p1.style.top=50+'px';
    p1.style.left=left+'px';
	p1.style.border="0px solid #1D64CF";
	var html="";
	html += "<center>"
	html += "<div class='p1' style='height:21px;overflow:hidden;background:#980000;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;color:#fff;font-size:9pt;font-weight:bold;font-color:white;'>"
	//关闭
	html += "<table width='" + w + "'><tr><td align='left'><font color='#FFFFFF'>" + TITLE + "</font></td><td align='right'><a href='javascript:this.cancle()'><font color=#ffffff>关闭</font></a>&nbsp;&nbsp;</td></tr></table>"
	html += "</div>"
	html += "<div id='c' style='height:" + h + ";width:" + w + ";background-color:#FFFFFF;overflow:hidden;border-left:1px solid #980000;border-right:1px solid #980000;padding-top:0px;font-size:9pt;'>"
	html += "<iframe src='" + URL + "' frameborder='0' scrolling='yes' width='" + w + "' height='" + h + "'></iframe>" + "<br><br><br></div>"
	html += "<div class='p1' style='height:2px;overflow:hidden;background:#FFFFFF;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;border-bottom:1px solid #980000;'></div>"
	html += "</center>"

  //滚动到底端
	scroll(0,0);

	document.body.appendChild(p1);
	p1.innerHTML=html;
	var arr=document.getElementsByTagName("select");
	var i=0;
	while(i<arr.length){
	  arr[i].style.visibility='hidden';
	  i++;
	}
	this.cancle=function(){
		document.body.removeChild(document.getElementById('p'));
		document.body.removeChild(document.getElementById('p1'));
		var arr=document.getElementsByTagName("select");
	  var i=0;
	  while(i<arr.length){
	  arr[i].style.visibility='visible';
	  i++;
	  }
	  location.reload();
	 
	}
}

//仿windows关机效果:没有父页刷新
function ShowPageNoRefresh(URL, TITLE,h,w) {
    var p = document.createElement("DIV");
    if (!URL) var URL = 'blank:';


    p.id = "p";
    p.style.position = "absolute";
    p.style.width = document.body.scrollWidth;
    p.style.height = fetchPageSize()[1];    //(document.body.offsetHeight>document.body.scrollHeight)?'100%':document.body.scrollHeight;
    p.style.zIndex = '998';
    p.style.top = '0px';
    p.style.left = '0%';
    p.style.backgroundColor = "gray";
    p.style.opacity = '0.5';
    p.style.filter = "alpha(opacity=80)";
    document.body.appendChild(p);

    var p1 = document.createElement("DIV");
    var top = parseInt(parseInt(document.body.scrollHeight) * 0.25) + document.body.scrollTop;
    p1.style.position = "absolute";
    p1.style.width = "800px";
    p1.id = "p1";
    var left = Math.ceil(((document.body.scrollWidth) - parseInt(p1.style.width.replace('px', ''))) / 2) + document.body.scrollLeft;
    p1.style.height = "200px";
    p1.style.zIndex = '999';
    p1.style.top = 50 + 'px';
    p1.style.left = left + 'px';
    p1.style.border = "0px solid #1D64CF";
    var html = "";
    html += "<center>"
    html += "<div class='p1' style='height:21px;overflow:hidden;background:#980000;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;color:#fff;font-size:9pt;font-weight:bold;font-color:white;'>"
    //关闭
    html += "<table width='" + w + "'><tr><td align='left'><font color='#FFFFFF'>" + TITLE + "</font></td><td align='right'><a href='javascript:this.cancle()'><font color=#ffffff>关闭</font></a>&nbsp;&nbsp;</td></tr></table>"
    html += "</div>"
    html += "<div id='c' style='height:" + h + ";width:" + w + ";background-color:#FFFFFF;overflow:hidden;border-left:1px solid #980000;border-right:1px solid #980000;padding-top:0px;font-size:9pt;'>"
    html += "<iframe src='" + URL + "' frameborder='0' scrolling='yes' width='" + w + "' height='" + h + "'></iframe>" + "<br><br><br></div>"
    html += "<div class='p1' style='height:2px;overflow:hidden;background:#FFFFFF;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;border-bottom:1px solid #980000;'></div>"
    html += "</center>"

    //滚动到底端
    scroll(0, 0);

    document.body.appendChild(p1);
    p1.innerHTML = html;
    var arr = document.getElementsByTagName("select");
    var i = 0;
    while (i < arr.length) {
        arr[i].style.visibility = 'hidden';
        i++;
    }
    this.cancle = function () {
        document.body.removeChild(document.getElementById('p'));
        document.body.removeChild(document.getElementById('p1'));
        var arr = document.getElementsByTagName("select");
        var i = 0;
        while (i < arr.length) {
            arr[i].style.visibility = 'visible';
            i++;
        }
    }
}

//仿windows关机效果:有父页刷新
function ShowPageRefresh(URL, TITLE, h, w) {
    var p = document.createElement("DIV");
    if (!URL) var URL = 'blank:';


    p.id = "p";
    p.style.position = "absolute";
    p.style.width = document.body.scrollWidth;
    p.style.height = fetchPageSize()[1];    //(document.body.offsetHeight>document.body.scrollHeight)?'100%':document.body.scrollHeight;
    p.style.zIndex = '998';
    p.style.top = '0px';
    p.style.left = '0%';
    p.style.backgroundColor = "gray";
    p.style.opacity = '0.5';
    p.style.filter = "alpha(opacity=80)";
    document.body.appendChild(p);

    var p1 = document.createElement("DIV");
    var top = parseInt(parseInt(document.body.scrollHeight) * 0.25) + document.body.scrollTop;
    p1.style.position = "absolute";
    p1.style.width = "800px";
    p1.id = "p1";
    var left = Math.ceil(((document.body.scrollWidth) - parseInt(p1.style.width.replace('px', ''))) / 2) + document.body.scrollLeft;
    p1.style.height = "200px";
    p1.style.zIndex = '999';
    p1.style.top = 50 + 'px';
    p1.style.left = left + 'px';
    p1.style.border = "0px solid #1D64CF";
    var html = "";
    html += "<center>"
    html += "<div class='p1' style='height:21px;overflow:hidden;background:#980000;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;color:#fff;font-size:9pt;font-weight:bold;font-color:white;'>"
    //关闭
    html += "<table width='" + w + "'><tr><td align='left'><font color='#FFFFFF'>" + TITLE + "</font></td><td align='right'><a href='javascript:this.cancle()'><font color=#ffffff>关闭</font></a>&nbsp;&nbsp;</td></tr></table>"
    html += "</div>"
    html += "<div id='c' style='height:" + h + ";width:" + w + ";background-color:#FFFFFF;overflow:hidden;border-left:1px solid #980000;border-right:1px solid #980000;padding-top:0px;font-size:9pt;'>"
    html += "<iframe src='" + URL + "' frameborder='0' scrolling='yes' width='" + w + "' height='" + h + "'></iframe>" + "<br><br><br></div>"
    html += "<div class='p1' style='height:2px;overflow:hidden;background:#FFFFFF;width:" + w + ";border-left:1px solid #980000;border-right:1px solid #980000;border-bottom:1px solid #980000;'></div>"
    html += "</center>"

    //滚动到底端
    scroll(0, 0);

    document.body.appendChild(p1);
    p1.innerHTML = html;
    var arr = document.getElementsByTagName("select");
    var i = 0;
    while (i < arr.length) {
        arr[i].style.visibility = 'hidden';
        i++;
    }
    this.cancle = function () {
        document.body.removeChild(document.getElementById('p'));
        document.body.removeChild(document.getElementById('p1'));
        var arr = document.getElementsByTagName("select");
        var i = 0;
        while (i < arr.length) {
            arr[i].style.visibility = 'visible';
            i++;
        }
    location.reload();

    }
}