require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('close', _ => {
    const input1 = '5 20';
    const input2 = '99 101 1000 0 97';

    const val = input1.split(' ').reduce((a, b) => a * b);
    const result = input2
      .split(' ')
      .map(v => val - v);

    console.log();
    console.log(result.join(' '));
  });