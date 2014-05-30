phantom.injectJs("./jquery.js");
page = require('webpage').create();
page.open('http://www.360doc.com/classarticle.html?pid=0&rid=30',function(){
	var title = page.evaluate(function() {
		var _html = [];
		$.ajax({
			type: "GET",
			async:false,
			url: "http://www.360doc.com/ajax/getreadroomart.ashx?pagenum=25&curnum=5&cid=0&scid=30&iscream=0&sort=1&_=1401439205999",
			success: function(msg){
				$('body').after(msg);
			}
		});
		$(".numberwz a").each(function() {
			_html.push($(this).attr('href'));
		})
		return _html;
	});
	console.info(title);
	phantom.exit();
});
console.info(';');
