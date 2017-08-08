const getDigitalRoot = val => {
  if (val.length === 1) {
    return +val;
  }

  return getDigitalRoot(
    val.split('')
      .reduce((a, b) => +a + +b)
      .toString()
  );
};

const getResult = (input, acc) => {
  const [head, ...tail] = input;
  switch (head) {
    case '0':
      return acc;
    default:
      acc.push(getDigitalRoot(head));
      return getResult(tail, acc);
  }
};

require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('close', _ => {
    const input = `24\n39\n0`;
    const result = getResult(input.split('\n'), []);

    console.log();
    console.log(result);
  });