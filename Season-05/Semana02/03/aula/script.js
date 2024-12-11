const elem = document.querySelector("#app");
let counter = 0;
// to be called every 1s
function timerCallback() { 
     counter++; 
     elem.innerHTML = `Counter: ${counter}`;
     
    }
    
    setInterval(timerCallback, 1000);