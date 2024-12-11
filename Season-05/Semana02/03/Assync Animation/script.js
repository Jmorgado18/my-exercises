function startLoading() {
    const loadingBar = document.getElementById('loadingBar');
    const loadingText = document.getElementById('loadingText');
    let progress = 0;

    const interval = setInterval(() => {
        progress += Math.random() * 5;
        
        if (progress >= 100) {
            progress = 100;
            clearInterval(interval);
        }

        loadingBar.style.width = `${progress}%`;
        loadingText.textContent = `Carregando: ${Math.round(progress)}%`;

        if (progress === 100) {
            loadingText.textContent = 'Carregamento Concluído!';
        }
    }, 500);
}

// Iniciar o carregamento quando a página carregar
window.onload = startLoading;