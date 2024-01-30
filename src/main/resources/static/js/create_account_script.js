function createAccountFormValidity() {
    const dob = document.getElementById("dob").value;
    const password = document.getElementById("userPassword").value;
    const confirmPassword = document.getElementById(
        "userConfirmPassword"
    ).value;

    const alertElement = document
        .getElementById("form-alerts")
        .getElementsByTagName("i")[0];

    // validate dob info
    let birthDate = new Date(dob);
    let currentDate = new Date();
    const minAgeDate = new Date(
        currentDate.getFullYear() - 18,
        currentDate.getMonth(),
        currentDate.getDate()
    );

    // validate password info
    let passwordRegex = /^(?=.*\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}$/;
    // validations
    if (birthDate > minAgeDate) {
        alertElement.innerText =
            "Must be at least 18 years or older to create an account.";
    } else if (!passwordRegex.test(password)) {
        alertElement.innerText =
            "Password must contain:\n1 number (0-9)\n1 uppercase letter\n1 lowercase letter\n1 non-alphanumeric character\n8-16 characters";
    } else if (password !== confirmPassword) {
        alertElement.innerText = "Passwords do not match.";
    } else {
        document.getElementById("form-alerts").classList.add("hidden");
        return true;
    }
    document.getElementById("form-alerts").classList.remove("hidden");
    return false;
}

(() => {
    const form = document.getElementsByTagName("form")[0];
    form.addEventListener("submit", (event) => {
        if (!createAccountFormValidity()) {
            // prevent page from default behavior (navigate to a new page or reload current page)
            event.preventDefault();
            // prevents the submit click event from reaching other elements in the dom
            event.stopPropagation();
        }
    });
})();
