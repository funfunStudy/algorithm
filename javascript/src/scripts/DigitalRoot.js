const getDigitalRoot = val => {
  if (val.length === 1) {
    return parseInt(val);
  }

  return getDigitalRoot(
    val.split('')
      .map(v => parseInt(v))
      .reduce((a, b) => a + b)
      .toString()
  )
};

const getResult = (input, acc) => {
  const [head, ...tail] = input.split('\n');
  switch (head) {
    case '':
      return acc;
    default:
      acc.push(getDigitalRoot(head));
      return getResult(tail.join('\n'), acc);
  }
};

require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('close', _ => {
    const input = `24\n39\n0`;
    const result = getResult(input, []);

    console.log();
    console.log(result);
  });