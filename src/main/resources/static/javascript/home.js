//Login Functionality!

console.log(document);
const loginUsername = document.getElementById('usernameLogin');
const loginPassword = document.getElementById('passwordLogin');
const loginForm = document.getElementById('loginForm')
const registerUsername = document.getElementById('usernameRegister');
const registerPassword = document.getElementById('passwordRegister');
const registerPassword2 = document.getElementById('passwordCheckRegister');
const registerFirst_Name = document.getElementById('firstNameRegister');
const registerLast_Name = document.getElementById('lastNameRegister');
const registerAge = document.getElementById('ageRegister');
const registerForm = document.getElementById('registerForm')


const headers = {
    'Content-Type' : 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) =>{
    console.log("Before the prevent Default");
    e.preventDefault();
    console.log("Right after prevent Default");

    let bodyObj = {
    username: loginUsername.value,
    password: loginPassword.value
    }


    const response = await fetch(`${baseUrl}/login`,{
    method: "POST",
    body: JSON.stringify(bodyObj),
    headers: headers
    })

    const responseArr = await response.json()

    if(response.status == 200) {
    console.log("This is connected");
    if(responseArr[0] == "User Login Successful") {
    alert(responseArr[0])
    document.cookie = `userId=${responseArr[1]}`
    window.location.replace(responseArr[0])

    }


    } else {
    alert("Oh oh! Your username or password was incorrect. Get fucked!")
    }
    }



loginForm.addEventListener("submit", handleSubmit)

//Register Functionality

const registerLink = document.getElementById("registerLink")
const registerModal = document.getElementById('registerModal');
const closeModalButton = document.getElementById('closeModal');
registerLink.addEventListener('click', () => {
  registerModal.classList.remove('hidden');
});
closeModalButton.addEventListener('click', () => {
  registerModal.classList.add('hidden');
});
//const registerForm = document.getElementById('registerForm');
//registerForm.addEventListener('submit', async (e) => {
//  e.preventDefault();






///take register information and add to the my SUPERBASEEEE

const handleRegisterSubmit = async (e) =>{
    console.log("Before the prevent Default register");
    e.preventDefault();
    console.log("Right after prevent Default register");

    if(registerPassword.value != registerPassword2.value) {
    alert("Your passwords are not the same!")
    } else{

    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value,
        first_name: registerFirst_Name.value,
        last_name: registerLast_Name.value,
        age: registerAge.value,
    }


    const response = await fetch(`${baseUrl}/register`,{
    method: "POST",
    body: JSON.stringify(bodyObj),
    headers: headers
    })

    const responseArr = await response.json();



if (response.status === 200) {
    const registeredFirstName = responseArr.first_name;
    console.log("pop up should happen now");
    // Show the pop-up box and hide register box
    registerModal.classList.add("hidden");
    const registrationSuccessModal = document.getElementById("registrationSuccessModal");
    registrationSuccessModal.classList.remove("hidden");

    // Close the pop-up after 3 seconds
    setTimeout(() => {
        registrationSuccessModal.classList.add("hidden");
    }, 5000); // 3000 milliseconds (3 seconds)
}
}

    }


registerForm.addEventListener('submit', handleRegisterSubmit);


  // Close the modal after successful registration
  registerModal.classList.add('hidden');
;


