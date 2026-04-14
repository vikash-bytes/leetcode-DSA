/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = new Map();

    // Add arr1 objects
    for (const obj of arr1) {
        map.set(obj.id, { ...obj });
    }

    // Merge arr2 objects
    for (const obj of arr2) {
        if (map.has(obj.id)) {
            map.set(obj.id, { ...map.get(obj.id), ...obj });
        } else {
            map.set(obj.id, { ...obj });
        }
    }

    // Convert to array and sort by id
    return Array.from(map.values()).sort((a, b) => a.id - b.id);
};

/**
 * Example usage:
 * console.log(join(
 *   [{"id":1,"x":2,"y":3},{"id":2,"x":3,"y":6}],
 *   [{"id":2,"x":10,"y":20},{"id":3,"x":0,"y":0}]
 * ));
 * // [
 * //   {"id":1,"x":2,"y":3},
 * //   {"id":2,"x":10,"y":20},
 * //   {"id":3,"x":0,"y":0}
 * // ]
 */
