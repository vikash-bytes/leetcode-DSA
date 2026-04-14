/**
 * @param {number[]} nums
 * @return {void}
 */
var ArrayWrapper = function(nums) {
    this.nums = nums;
};

/**
 * @return {number}
 */
ArrayWrapper.prototype.valueOf = function() {
    // Sum of all elements
    return this.nums.reduce((acc, val) => acc + val, 0);
};

/**
 * @return {string}
 */
ArrayWrapper.prototype.toString = function() {
    // Bracketed, comma-separated string
    return `[${this.nums.join(",")}]`;
};

/**
 * Example usage:
 * const obj1 = new ArrayWrapper([1,2]);
 * const obj2 = new ArrayWrapper([3,4]);
 *
 * console.log(obj1 + obj2); // 10
 * console.log(String(obj1)); // "[1,2]"
 * console.log(String(obj2)); // "[3,4]"
 *
 * const obj3 = new ArrayWrapper([23,98,42,70]);
 * console.log(String(obj3)); // "[23,98,42,70]"
 *
 * const obj4 = new ArrayWrapper([]);
 * const obj5 = new ArrayWrapper([]);
 * console.log(obj4 + obj5); // 0
 */
