/**
 * Creates a counter module with an initial value, zero if not provided
 */
exports.createCounter = function(counter) {

    return {
        counter: counter || 0,
        get: function() {
            return this.counter;
        },
        increment: function() {
            this.counter++;
        },
        reset: function() {
            this.counter = 0;
        }
    };
};

/**
 * Creates a person module with name and age
 * An initial name value should be provided and
 * an exception thrown if not
 */
exports.createPerson = function(name) {

    return {
        age: 0,
        name: name,
    };
};
