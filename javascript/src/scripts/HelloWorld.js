const input = [];

require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('line', line => input.push(line.trim()))
  .on('close', _ => {
    for (let i = 0; i < input.length; i++)
      console.log('Hello, ' + input[i] + '!');
  });