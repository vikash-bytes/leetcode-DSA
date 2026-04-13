/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let val = init;   // start with the initial value
    for (let i = 0; i < nums.length; i++) {
        val = fn(val, nums[i]);  // apply reducer function sequentially
    }
    return val;  // final accumulated result
};
