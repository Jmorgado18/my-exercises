const teams = [
    "Porto",
    "Benfica",
    "Sporting",
    "Braga",
    "Guimarães",
    "Boavista",
    "Estoril",
    "Casa Pia",
    "Chaves",
    "Portimonense",
    "Famalicão",
    "Gil Vicente",
    "Arouca",
    "Vizela",
    "Marítimo",
    "Paços de Ferreira",
    "Santa Clara",
    "Tondela"
  ];

//MAP
  const updateTeams = teams.map((team => team + " FC"));

  console.log(updateTeams);

//FILTER

console.log("-----------------------------------")

const teamsWithLetterP = teams.filter(team => team[0] === "P"); 

console.log(teamsWithLetterP);

//REDUCE


console.log("-----------------------------------")

const allTeams = teams.reduce((acc, team) => acc + ", " + team, "");

console.log(allTeams);
