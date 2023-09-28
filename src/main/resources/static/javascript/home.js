console.log(document);
const loginUsername = document.getElementById('usernameLogin');
const loginPassword = document.getElementById('passwordLogin');
const loginForm = document.getElementById('loginForm')


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

