let player1Score = 0;
let player2Score = 0;

const playButton = document.getElementById('play-button');
const player1Img = document.getElementById('player1-img');
const player2Img = document.getElementById('player2-img');
const resultText = document.getElementById('result');

// Ocultar imagens inicialmente
player1Img.style.display = 'none';
player2Img.style.display = 'none';

const choices = ["rock", "paper", "scissors"];
const images = {
    rock: "assets/rock.png",
    paper: "assets/paper.png",
    scissors: "assets/scissors.png",
};

function updateScores(winner) {
    if (winner === "Player 1 Wins!") {
        player1Score++;
        document.getElementById("player1-score").textContent = player1Score;
    } else if (winner === "Player 2 Wins!") {
        player2Score++;
        document.getElementById("player2-score").textContent = player2Score;
    }
}

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

    // Atualizar imagens e exibi-las
    player1Img.src = images[player1Choice];
    player1Img.alt = player1Choice;
    player1Img.style.display = 'block';

    player2Img.src = images[player2Choice];
    player2Img.alt = player2Choice;
    player2Img.style.display = 'block';

    // Determinar o resultado e atualizar na tela
    const result = determineWinner(player1Choice, player2Choice);
    resultText.textContent = result;

    // Atualizar pontuações
    updateScores(result);
}

// Adicionar evento ao botão de "Play"
playButton.addEventListener("click", playGame);
