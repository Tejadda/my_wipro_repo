document.addEventListener('DOMContentLoaded', function() {
    // Registration Form Validation
    const registrationForm = document.getElementById('registrationForm');
    if (registrationForm) {
        registrationForm.addEventListener('submit', function(event) {
            event.preventDefault();
            let isValid = validateRegistrationForm();
            if (isValid) {
                alert('Registered successfully');
                window.location.href = 'login.html';
            }
        });
    }

    // Login Form Validation
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            let isValid = validateLoginForm();
            if (isValid) {
                alert('Login successful');
            }
        });
    }

    function validateRegistrationForm() {
        let isValid = true;

        // Clear previous error messages
        clearErrorMessages();

        const fname = document.getElementById('fname').value.trim();
        const lname = document.getElementById('lname').value.trim();
        const contact = document.getElementById('contact').value.trim();
        const email = document.getElementById('email').value.trim();
        const gender = document.getElementById('gender').value;
        const password = document.getElementById('password').value.trim();
        const confirmPassword = document.getElementById('confirm_password').value.trim();

        if (!fname) {
            isValid = false;
            document.getElementById('fnameError').textContent = 'First name is required';
        }

        if (!lname) {
            isValid = false;
            document.getElementById('lnameError').textContent = 'Last name is required';
        }

        if (!contact) {
            isValid = false;
            document.getElementById('contactError').textContent = 'Contact number is required';
        }

        if (!email) {
            isValid = false;
            document.getElementById('emailError').textContent = 'Email is required';
        }

        if (!gender) {
            isValid = false;
            document.getElementById('genderError').textContent = 'Gender is required';
        }

        if (!password) {
            isValid = false;
            document.getElementById('passwordError').textContent = 'Password is required';
        }

        if (!confirmPassword) {
            isValid = false;
            document.getElementById('confirmPasswordError').textContent = 'Confirm password is required';
        }

        if (password && confirmPassword && password !== confirmPassword) {
            isValid = false;
            document.getElementById('confirmPasswordError').textContent = 'Passwords do not match';
        }

        return isValid;
    }

    function validateLoginForm() {
        let isValid = true;

        // Clear previous error messages
        clearErrorMessages();

        const email = document.getElementById('email').value.trim();
        const password = document.getElementById('password').value.trim();

        if (!email) {
            isValid = false;
            document.getElementById('loginEmailError').textContent = 'Email is required';
        }

        if (!password) {
            isValid = false;
            document.getElementById('loginPasswordError').textContent = 'Password is required';
        }

        return isValid;
    }

    function clearErrorMessages() {
        const errorMessages = document.querySelectorAll('.error-message');
        errorMessages.forEach(message => {
            message.textContent = '';
        });
    }
});