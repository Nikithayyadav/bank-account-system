const baseUrl = "http://localhost:8080/api/bank";

async function createAccount() {
    const accNumber = document.getElementById("accNumber").value.trim();
    const accHolder = document.getElementById("accHolder").value.trim();
    const accType = document.getElementById("accType").value;
    const amount = parseFloat(document.getElementById("initialDeposit").value || "0");

    if (!accNumber || !accHolder) {
        alert("Please enter Account Number and Holder Name!");
        return;
    }

    const payload = {
        accountNumber: accNumber,
        accountHolderName: accHolder,
        accountType: accType,
        amount: amount
    };

    try {
        const res = await fetch(`${baseUrl}/create`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        });

        const data = await res.json();
        showOutput(data);
    } catch (err) {
        console.error("Backend Error:", err);
        alert("Failed to connect to backend server!");
    }
}

async function performTransaction(type) {
    const accNumber = document.getElementById("transAccNumber").value.trim();
    const amount = parseFloat(document.getElementById("transAmount").value || "0");

    if (!accNumber || amount <= 0) {
        alert("Please enter a valid Account Number and positive Amount!");
        return;
    }

    const payload = {
        accountNumber: accNumber,
        amount: amount
    };

    try {
        const res = await fetch(`${baseUrl}/${type}`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(payload)
        });

        const data = await res.json();
        showOutput(data);
    } catch (err) {
        console.error("Backend Error:", err);
        alert("Failed to connect to backend server!");
    }
}

function showOutput(data) {
    const out = document.getElementById("output");
    out.style.display = "block";
    
    document.getElementById("msg").innerText = data.message;

    if (data.success) {
        document.getElementById("balanceDisplay").innerText = 
            `Account: ${data.accountNumber} (${data.accountType})\nHolder: ${data.accountHolderName}\nBalance:$${data.balance}`;
    } else {
        document.getElementById("balanceDisplay").innerText = "";
    }
}