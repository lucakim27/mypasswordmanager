document.getElementById("loginForm")
    .addEventListener("submit", async function(event) {

    event.preventDefault();

    const username =
        document.getElementById("username").value;

    const password =
        document.getElementById("password").value;

    const response = await fetch(
        "/api/auth/login",
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

    if (!response.ok) {

        document.getElementById("errorMessage")
            .textContent = "Invalid username or password.";

        return;
    }

    if (response.ok) {
        window.location.href = "/vault";
    }
});
