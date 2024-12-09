// Add CSS dynamically
const style = document.createElement("style");
style.textContent = `
  body {
    font-family: Arial, sans-serif;
    text-align: center;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    background-color: #f4f4f4;
  }
  #game-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
    width: 80%;
    max-width: 600px;
    margin-bottom: 20px;

  }
  #player1, #player2 {
    flex: 1;
    text-align: center;
  }
  img {
    width: 100px;
    height: auto;
    margin-bottom: 10px;
  }
  #result {
    font-size: 24px;
    font-weight: bold;
    margin: 20px;
  }
  #play-button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  #play-button:hover {
    background-color: #0056b3;
  }
`;
document.head.appendChild(style);


const choices = ["rock", "paper", "scissors"];
const images = {
  rock: "rsc/rock.jpg",
  paper: "rsc/paper.jpg",
  scissors: "rsc/scisors.png",
};

function getRandomChoice() {
  return choices[Math.floor(Math.random() * choices.length)];
}

function determineWinner(choice1, choice2) {
  if (choice1 === choice2) return "It's a draw!";
  if (
    (choice1 === "rock" && choice2 === "scissors") ||
    (choice1 === "paper" && choice2 === "rock") ||
    (choice1 === "scissors" && choice2 === "paper")
  ) {
    return "Player 1 Wins!";
  }
  return "Player 2 Wins!";
}

function playGame() {
  const player1Choice = getRandomChoice();
  const player2Choice = getRandomChoice();

  document.getElementById("player1-img").src = images[player1Choice];
  document.getElementById("player1-img").alt = player1Choice;

  document.getElementById("player2-img").src = images[player2Choice];
  document.getElementById("player2-img").alt = player2Choice;

  const result = determineWinner(player1Choice, player2Choice);
  document.getElementById("result").textContent = result;
}

document.getElementById("play-button").addEventListener("click", playGame);
