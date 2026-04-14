/**
 * @param {Object|Array} obj
 * @return {boolean}
 */
var isEmpty = function(obj) {
    if (Array.isArray(obj)) {
        return obj.length === 0;
    }
    return Object.keys(obj).length === 0;
};

/**
 * Example usage:
 * console.log(isEmpty({"x": 5, "y": 42})); // false
 * console.log(isEmpty({}));                // true
 * console.log(isEmpty([null, false, 0]));  // false
 * console.log(isEmpty([]));                // true
 */
