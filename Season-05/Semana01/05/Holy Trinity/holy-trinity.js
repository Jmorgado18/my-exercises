const users = require("./users.js");

console.log(users);

//Create a new array with the users that have an odd id;

const oddidUsers = users.filter((user) => user.id % 2 === 1);
console.log(oddidUsers);
console.log("-------------------------------------")


// Transform the array into an object where the key is the id and the value is the user

const userObject = users.reduce((acc, user) => {
    acc[user.id] = user;
    return acc;
}, {});

console.log(userObject);
console.log("-------------------------------------")


//The id of the user should be the index of the user in the array;

const userIndexObject = users.reduce((acc, user, index) => {
    acc[index] = user;
    return acc;
}, {}); 

console.log(userIndexObject);
console.log("-------------------------------------")

