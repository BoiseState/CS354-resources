//read more on promises here: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
module.exports = (function sleep(ms) {
  return new Promise((resolve) => {
    setTimeout(resolve, ms);
  });
});