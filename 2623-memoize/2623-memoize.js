/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    let callCount = 0;

    const memoizedFn = function(...args) {
        const key = JSON.stringify(args);
        if (cache.has(key)) {
            return cache.get(key);
        }
        const result = fn(...args);
        cache.set(key, result);
        callCount++;
        return result;
    };

    memoizedFn.getCallCount = function() {
        return callCount;
    };

    return memoizedFn;
}

/** 
 * Example usage:
 * let callCount = 0;
 * const memoizedSum = memoize(function (a, b) {
 *   callCount += 1;
 *   return a + b;
 * });
 *
 * console.log(memoizedSum(2, 3)); // 5
 * console.log(memoizedSum(2, 3)); // 5 (cached)
 * console.log(memoizedSum.getCallCount()); // 1
 */
