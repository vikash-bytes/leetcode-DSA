/**
 * @param {Function} fn
 * @param {number} t milliseconds
 * @return {Function}
 */
var debounce = function(fn, t) {
    let timerId;

    return function(...args) {
        // Cancel any pending execution
        if (timerId) {
            clearTimeout(timerId);
        }

        // Schedule new execution
        timerId = setTimeout(() => {
            fn(...args);
        }, t);
    }
};

/**
 * Example usage:
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled if another call happens within 100ms
 * log('Hello'); // cancelled if another call happens within 100ms
 * log('Hello'); // executed at ~100ms after last call
 */
