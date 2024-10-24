function convert() {
    const inputValue = document.getElementById('inputValue').value;
    const inputBase = parseInt(document.getElementById('inputBase').value, 10);
    const outputBase = parseInt(document.getElementById('outputBase').value, 10);
    
    if (!inputValue) {
        alert('Por favor, introduza um número.');
        return;
    }

    let decimalValue;

    // Convert input value to decimal
    try {
        switch (inputBase) {
            case 2:
                decimalValue = parseInt(inputValue, 2);
                break;
            case 10:
                decimalValue = parseInt(inputValue, 10);
                break;
            case 16:
                decimalValue = parseInt(inputValue, 16);
                break;
            case 4:
                decimalValue = parseInt(inputValue, 4);
                break;
            default:
                throw new Error('Base de entrada não suportada.');
        }
    } catch (error) {
        alert('Número inválido para a base de entrada.');
        return;
    }

    // Convert decimal value to output base
    let outputValue;
    switch (outputBase) {
        case 2:
            outputValue = decimalValue.toString(2);
            break;
        case 10:
            outputValue = decimalValue.toString(10);
            break;
        case 16:
            outputValue = decimalValue.toString(16).toUpperCase();
            break;
        case 4:
            outputValue = decimalToBase4(decimalValue);
            break;
        default:
            alert('Base de saída não suportada.');
            return;
    }

    document.getElementById('resultValue').innerText = outputValue;
}

function decimalToBase4(decimal) {
    let base4 = '';
    while (decimal > 0) {
        base4 = (decimal % 4) + base4;
        decimal = Math.floor(decimal / 4);
    }
    return base4 || '0';
}
