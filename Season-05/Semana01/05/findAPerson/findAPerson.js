let characters = [
    { name: "John", email: "john_the_one@gmail.com", age: 18 },
    { name: "Diane", email: "princess.diane@gmail.com", age: 43 },
    { name: "Snoop", email: "hip-hop@gmail.com", age: 4 },
    { name: "Ice T", email: "OG_ice@gmail.com", age: 14 },
    { name: "Vanilla Ice", email: "wannabeIce@gmail.com", age: 216 },
    { name: "Eminem", email: "theOne@gmail.com", age: 17 },
];

let criteria = {
    age: 18,
    email: "gmail.com",
};

function filterUsers(users, crit){

    let filterdUsers = [];
   
    for(let i = 0; i < users.length; i++){
    

        if(users[i].age == crit.age && users[i].email.includes(crit.email)){

            filterdUsers.push(users[i]);

            console.log(`O user ${users[i].name} tem a idade ${users[i].age} e o email ${users[i].email}`);
          }
        
          return filterdUsers;
    }
    
}

let filteredUsersfunction = filterUsers(characters, criteria);

console.log("Users que correspondem ao filtro :", filteredUsersfunction);


