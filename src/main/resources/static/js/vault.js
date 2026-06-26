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
    .onclick = () => {

    const website =
        document.getElementById("website").value;

    const username =
        document.getElementById("accountUsername").value;

    const password =
        document.getElementById("accountPassword").value;

    accounts.push({

        website,
        username,
        password

    });

    renderAccounts();

    modal.classList.add("hidden");

};

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
                    onclick="deleteAccount(${index})">

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

function deleteAccount(index){

    accounts.splice(index,1);

    renderAccounts();

}