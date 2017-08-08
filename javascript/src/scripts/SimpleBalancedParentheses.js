const isSimpleBalancedParentheses = _ => {
  const stack = [];
  const retFunc = {
    validate: val => {
      const [head, ...tail] = val;
      if (!head) {
        return stack.length === 0 ? true : false;
      }

      switch (head) {
        case '(':
        case '{':
        case '[':
          stack.push(head)
          return retFunc.validate(tail);
        case ')':
          if (stack[stack.length - 1] === '(') {
            stack.pop();
            return retFunc.validate(tail);
          }
          return false;
        case '}':
          if (stack[stack.length - 1] === '{') {
            stack.pop();
            return retFunc.validate(tail);
          }
          return false;
        case ']':
          if (stack[stack.length - 1] === '[') {
            stack.pop();
            return retFunc.validate(tail);
          }
          return false;
      }
    }
  };

  return retFunc;
};

const getResult = (input, acc) => {
  const [head, ...tail] = input;
  switch (head) {
    case undefined:
      return acc;
    default:
      acc.push(isSimpleBalancedParentheses().validate(head.split('')));
      return getResult(tail, acc);
  }
};

require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('close', _ => {
    const successInput = '(()()()())\n(((())))\n(()((())()))';
    const failInput = '((((((())\n()))\n(()()(()\n(()))(\n())(()';

    const successResult = getResult(successInput.split('\n'), []);
    const failResult = getResult(failInput.split('\n'), []);

    console.log();
    console.log(`Success: ${successResult}`);
    console.log(`Fail: ${failResult}`);
  });