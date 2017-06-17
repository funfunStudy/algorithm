
var input = [];

require('readline')
.createInterface(process.stdin, process.stdout)
.on('line', function(line) {
  input.push(line.trim());
}).on('close', function() {
  for (var i = 0; i < input.length; i++)
    console.log('Hello, ' + input[i] + '!');
});