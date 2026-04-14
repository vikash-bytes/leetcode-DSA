class EventEmitter {
    constructor() {
        this.events = new Map();
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }
        const listeners = this.events.get(eventName);
        listeners.push(callback);

        return {
            unsubscribe: () => {
                const idx = listeners.indexOf(callback);
                if (idx !== -1) {
                    listeners.splice(idx, 1);
                }
                return undefined;
            }
        };
    }

    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if (!this.events.has(eventName)) {
            return [];
        }
        const listeners = this.events.get(eventName);
        const results = [];
        for (const cb of listeners) {
            results.push(cb(...args));
        }
        return results;
    }
}

/**
 * Example usage:
 * const emitter = new EventEmitter();
 *
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * console.log(emitter.emit('onClick')); // [99]
 * sub.unsubscribe(); // undefined
 * console.log(emitter.emit('onClick')); // []
 */
