
var a="欢迎来到AAA运营管理平台！我们将提供最好的服务。";
var t = null;
function pmd(){
	$("#pmd").html(a.substr(0,12));
	a=a.substr(1,21)+a[0];
	clearTimeout(t);
	t = setTimeout("pmd()",700);					
}
pmd();
