const arrayWithPeople = [];

class Person {
    constructor(id, name, age, favoriteFood) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }
}

class PersonService {
    constructor(arrayWithPeople) {
        this.arrayWithPeople = arrayWithPeople;
    }

    getName(id) {
        const person = this.get(id);
        if (person) {
            return `My name is ${person.name}`;
        }
        return 'Person not found';
    }


    add(id, name, age, favoriteFood) {
        const newPerson = new Person(id, name, age, favoriteFood);
        this.arrayWithPeople.push(newPerson);
        return newPerson;
    }

    remove(id) {
        const index = this.arrayWithPeople.findIndex(person => person.id === id);
        if (index !== -1) {
            return this.arrayWithPeople.splice(index, 1)[0]; 
        }
        return null;
    }

    destroy(){
        this.arrayWithPeople = [];
        return 'Array destroyed';

    }

    update(id, name, age, favoriteFood) {
        const personUpdated = this.get(id);

        if (personUpdated) {
            personUpdated.name = name;
            personUpdated.age = age;
            personUpdated.favoriteFood = favoriteFood;
            return personUpdated;
        }
        return "error: Person not found, cant update";
    }

    get(id) {
        return this.arrayWithPeople.find(person => person.id === id) || null;
    }

    getAll() {
        return this.arrayWithPeople;
    }
    
}

const personService = new PersonService(arrayWithPeople);





personService.add(1, 'Alice', 25, 'Pizza');
console.log(personService.get(1)); 

console.log(personService.get(2)); 

console.log(personService.getAll()); 

personService.remove(1); 

console.log(personService.get(1)); 

personService.add(2, 'Bob', 30, 'Burgers');
personService.add(3, 'Charlie', 28, 'Salads');

console.log(personService.getAll()); 

console.log(personService.getName(2));

