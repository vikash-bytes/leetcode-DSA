/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */
var argumentsLength = function(...args) {
    return args.length;
};

/**
 * Example usage:
 * argumentsLength(1, 2, 3); // 3
 * argumentsLength(5);       // 1
 * argumentsLength({}, null, "3"); // 3
 */
