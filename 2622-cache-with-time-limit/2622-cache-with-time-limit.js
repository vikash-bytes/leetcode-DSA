var TimeLimitedCache = function() {
    this.cache = new Map();
};

/** 
 * @param {number} key
 * @param {number} value
 * @param {number} duration time until expiration in ms
 * @return {boolean} if un-expired key already existed
 */
TimeLimitedCache.prototype.set = function(key, value, duration) {
    const now = Date.now();
    const exists = this.cache.has(key) && this.cache.get(key).expiry > now;

    this.cache.set(key, {
        value: value,
        expiry: now + duration
    });

    return exists;
};

/** 
 * @param {number} key
 * @return {number} value associated with key
 */
TimeLimitedCache.prototype.get = function(key) {
    const now = Date.now();
    if (this.cache.has(key)) {
        const entry = this.cache.get(key);
        if (entry.expiry > now) {
            return entry.value;
        } else {
            this.cache.delete(key); // cleanup expired
        }
    }
    return -1;
};

/** 
 * @return {number} count of non-expired keys
 */
TimeLimitedCache.prototype.count = function() {
    const now = Date.now();
    let count = 0;
    for (const [key, entry] of this.cache.entries()) {
        if (entry.expiry > now) {
            count++;
        } else {
            this.cache.delete(key); // cleanup expired
        }
    }
    return count;
};

/**
 * Example usage:
 * const timeLimitedCache = new TimeLimitedCache();
 * console.log(timeLimitedCache.set(1, 42, 1000)); // false
 * console.log(timeLimitedCache.get(1)); // 42
 * console.log(timeLimitedCache.count()); // 1
 */
