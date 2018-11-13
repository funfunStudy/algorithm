const counterV1 = (src, acc, result) => {
    if (src.length == 0) {
       return result;
    } else {
       var [score, ...remain] = src;
        if (acc == null) {
            acc = [score, score]
        } else if (acc[0] > score) {
           acc[0] = score;
            result[0]++;
        } else if (acc[1] < score) {
           acc[1] = score;
            result[1]++;
        }
        return counterV1(remain, acc, result);
    }
};

const counterV2 = (src) => {
    var [minResult, maxResult] = src.reduce((acc, score) => {
        if (acc.length == 0) {
            return [0, 0, score, score];
        }
        else {
            var [minCnt, maxCnt, min, max] = acc;
            return [score < min ? minCnt+1 : minCnt,
                    score > max ? maxCnt+1 : maxCnt,
                    Math.min(min, score),
                    Math.max(max, score)];
        }
    }, []);
    return [minResult, maxResult];
}


require('readline')
  .createInterface(process.stdin, process.stdout)
  .on('close', _ => {
    const source = [10, 5, 20, 20, 4, 5, 2, 25, 1];
    console.log('source : ' + source + '\nv1 final : ' + counterV1(source, null, [0, 0]) + '!');
    console.log('\nsource : ' + source + '\nv2 final : ' + counterV2(source) + '!');
  });