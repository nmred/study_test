var spawn = require('child_process').spawn;

var iostat = spawn('iostat', ['-x', '1']);

var io = require('socket.io').listen(8080);

io.sockets.on('connection', function (socket) {
	iostat.stdout.on('data', function (data) {
		socket.emit('news', format_string(data));
	});
	socket.on('my other event', function (data) {
		console.log(data);
	});
});
function format_string(line) {
	line = (""+line).replace(/^[\s\n]+|[\s\n]+$/g,"");
	line = line.replace(/[\t\s]+/g," ");
	return line;
}
