/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    const result = {};
    for (const item of this) {
        const key = fn(item);
        if (!result[key]) {
            result[key] = [];
        }
        result[key].push(item);
    }
    return result;
};

/**
 * Example usage:
 * console.log([1,2,3].groupBy(String));
 * // {"1":[1], "2":[2], "3":[3]}
 *
 * const arr = [{id:"1"}, {id:"1"}, {id:"2"}];
 * console.log(arr.groupBy(item => item.id));
 * // {"1":[{id:"1"}, {id:"1"}], "2":[{id:"2"}]}
 *
 * const nums = [1,2,3,4,5,6,7,8,9,10];
 * console.log(nums.groupBy(n => String(n > 5)));
 * // {"false":[1,2,3,4,5], "true":[6,7,8,9,10]}
 */
