const accounts = [];

const accountList = document.getElementById("accountList");

const modal = document.getElementById("modal");

document.getElementById("addButton")
    .onclick = () => {

    modal.classList.remove("hidden");

};

document.getElementById("cancelButton")
    .onclick = () => {

    modal.classList.add("hidden");

};

document.getElementById("saveButton")
    .onclick = async () => {

    const website =
        document.getElementById("website").value;

    const username =
        document.getElementById("accountUsername").value;

    const password =
        document.getElementById("accountPassword").value;

    const response = await fetch(
        "/api/accounts",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                website,
                username,
                password
            })
        });

    const message = await response.text();

    alert(message);

    await loadAccounts();

    modal.classList.add("hidden");
};

async function loadAccounts() {
    const res = await fetch("/api/accounts");
    const data = await res.json();

    console.log(data)

    accounts.length = 0;
    accounts.push(...data);

    renderAccounts();
}

function renderAccounts(){

    accountList.innerHTML = "";

    accounts.forEach((account,index)=>{

        accountList.innerHTML +=

            `
        <div class="account-card">

            <h3>${account.website}</h3>

            <p><strong>Username:</strong> ${account.username}</p>

            <p id="pw${index}">
                <strong>Password:</strong>
                ••••••••••
            </p>

            <div class="actions">

                <button
                    class="showBtn"
                    onclick="togglePassword(${index})">

                    Show

                </button>

                <button
                    class="deleteBtn"
                    onclick="deleteAccount(${account.id})">

                    Delete

                </button>

            </div>

        </div>
        `;

    });

}

function togglePassword(index){

    const p =
        document.getElementById("pw"+index);

    if(p.innerHTML.includes("••")){

        p.innerHTML =
            "<strong>Password:</strong> "
            + accounts[index].password;

    }else{

        p.innerHTML =
            "<strong>Password:</strong> ••••••••••";

    }

}

function deleteAccount(id) {
    fetch(`/api/accounts/${id}`, {
        method: "DELETE"
    }).then(loadAccounts);
}

loadAccounts();