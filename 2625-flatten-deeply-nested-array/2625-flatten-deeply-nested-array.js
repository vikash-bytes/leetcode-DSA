/**
 * @param {Array} arr
 * @param {number} n
 * @return {Array}
 */
var flat = function (arr, n) {
    const helper = (array, depth) => {
        const result = [];
        for (const el of array) {
            if (Array.isArray(el) && depth < n) {
                result.push(...helper(el, depth + 1));
            } else {
                result.push(el);
            }
        }
        return result;
    };
    return helper(arr, 0);
};

/**
 * Example usage:
 * console.log(flat([1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]], 0));
 * // [1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]]
 *
 * console.log(flat([1,2,3,[4,5,6],[7,8,[9,10,11],12],[13,14,15]], 1));
 * // [1,2,3,4,5,6,7,8,[9,10,11],12,13,14,15]
 *
 * console.log(flat([[1,2,3],[4,5,6],[7,8,[9,10,11],12],[13,14,15]], 2));
 * // [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
 */
