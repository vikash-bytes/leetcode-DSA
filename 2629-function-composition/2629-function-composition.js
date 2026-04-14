/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function(functions) {
    return function(x) {
        // Start with initial value x
        return functions.reduceRight((acc, fn) => fn(acc), x);
    }
};

/**
 * Example usage:
 * const fn = compose([x => x + 1, x => x * x, x => 2 * x]);
 * console.log(fn(4)); // 65
 */
