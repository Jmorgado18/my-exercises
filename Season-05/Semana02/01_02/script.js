
const button = document.createElement('button');
button.textContent = 'Change Background Color';
button.style.padding = '10px 20px';
button.style.fontSize = '18px';
button.style.backgroundColor = '#007BFF';
button.style.color = 'white';
button.style.border = 'none';
button.style.borderRadius = '50px';
button.style.cursor = 'pointer';
button.style.boxShadow = '0 20px 50px rgba(0, 0, 0, 0.3)';
button.style.transition = 'all 0.3s ease-in-out';
button.style.marginTop = '20px';
button.style.marginBottom = '20px';





document.body.style.textAlign = 'center';
document.body.style.padding = '50px';
document.body.style.fontFamily = 'Arial, sans-serif';
document.body.style.color = '#333';
document.body.style.fontSize = '16px';
document.body.appendChild(button);


button.addEventListener('click', () => {
    
    const randomColor = `#${Math.floor(Math.random() * 16777215).toString(16)}`;
    
    
    document.body.style.backgroundColor = randomColor;
});
