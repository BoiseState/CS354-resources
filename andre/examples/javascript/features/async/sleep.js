//read more on promises here: https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise
module.exports = (function sleep(ms) {
  return new Promise((resolve) => {
    // here resolve is the callback function called by setTimeout
    // the promise is resolved, giving control back to the waiting function
    setTimeout(resolve, ms);
  });
});