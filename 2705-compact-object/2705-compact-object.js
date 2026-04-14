/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    if (Array.isArray(obj)) {
        const result = [];
        for (const el of obj) {
            if (el) {
                if (typeof el === 'object') {
                    result.push(compactObject(el));
                } else {
                    result.push(el);
                }
            } else if (typeof el === 'object' && el !== null) {
                // Handle nested empty arrays/objects
                result.push(compactObject(el));
            }
        }
        return result;
    } else if (obj !== null && typeof obj === 'object') {
        const result = {};
        for (const key in obj) {
            const val = obj[key];
            if (val) {
                if (typeof val === 'object') {
                    result[key] = compactObject(val);
                } else {
                    result[key] = val;
                }
            } else if (typeof val === 'object' && val !== null) {
                result[key] = compactObject(val);
            }
        }
        return result;
    }
    return obj;
};

/**
 * Example usage:
 * console.log(compactObject([null, 0, false, 1]));
 * // [1]
 *
 * console.log(compactObject({"a": null, "b": [false, 1]}));
 * // {"b": [1]}
 *
 * console.log(compactObject([null, 0, 5, [0], [false, 16]]));
 * // [5, [], [16]]
 */
