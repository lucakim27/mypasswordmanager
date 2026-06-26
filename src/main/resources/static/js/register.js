document.getElementById("registerForm").addEventListener("submit", async function(event) {

    event.preventDefault();

    const username = document.getElementById("username").value;

    const password = document.getElementById("password").value;

    const confirmPassword = document.getElementById("confirmPassword").value;

    const errorMessage = document.getElementById("errorMessage");

    if (password !== confirmPassword) {

        errorMessage.textContent = "Passwords do not match.";

        return;
    }

    errorMessage.textContent = "";

    const response = await fetch(
        "/api/auth/register",
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                username: username,
                password: password
            })
        }
    );

    const message = await response.text();

    alert(message);
});
