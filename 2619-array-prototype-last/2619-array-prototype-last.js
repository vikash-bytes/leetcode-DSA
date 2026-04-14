/**
 * @return {null|boolean|number|string|Array|Object}
 */
Array.prototype.last = function() {
    if (this.length === 0) {
        return -1;
    }
    return this[this.length - 1];
};

/**
 * Example usage:
 * const arr1 = [null, {}, 3];
 * console.log(arr1.last()); // 3
 *
 * const arr2 = [];
 * console.log(arr2.last()); // -1
 *
 * const arr3 = [1, 2, 3];
 * console.log(arr3.last()); // 3
 */
