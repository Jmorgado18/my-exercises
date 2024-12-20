/**
 * Invoke the callback and return the amount of time in miliseconds it took to execute
 */
exports.profileFunc = function (cb) {


    const startTime = Date.now();
    cb();
    const endTime = Date.now();
    
    return endTime - startTime;

};




/**
 * Invoke the async callback with the provided value after some delay
 */
exports.returnWithDelay = function (value, delay, cb) {

    setTimeout(function () {
        cb(null, value);
    }, delay);
};

/**
 * Invoke the async callback with an error after some delay
 */
exports.failWithDelay = function (delay, cb) {

    setTimeout(function () {
        cb(new Error('error'));
    }, delay);

};

/**
 * Return a promise that resolves after the specified delay
 * or rejects if the delay is negative or non-existent
 */
exports.promiseBasedDelay = function (delay) {

    return new Promise(function (resolve, reject) {
        if (delay > 0) {
            setTimeout(function () {
                resolve();
            }, delay);
        } else {
            reject(new Error('error'));
        }
    });
};
