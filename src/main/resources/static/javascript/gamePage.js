//const gamesData = [
//    {
//        title: "Game 1",
//        studio: "Studio 1",
//        platforms: "Platform 1, Platform 2",
//        year: "2022",
//    },
//    {
//        title: "Game 2",
//        studio: "Studio 2",
//        platforms: "Platform 3",
//        year: "2021",
//    },
//    // Add more game objects as needed
//];
//
//function createGameBox(gameData) {
//    const template = document.getElementById("gameBoxTemplate");
//    const gameBox = template.cloneNode(true);
//    gameBox.classList.remove("hidden");
//
//    gameBox.querySelector(".bg-white").innerHTML = `
//        <h2 class="text-xl font-semibold">${gameData.title}</h2>
//        <p>Studio: ${gameData.studio}</p>
//        <p>Platforms: ${gameData.platforms}</p>
//        <p>Year Released: ${gameData.year}</p>
//    `;
//
//    return gameBox;
//}
//
//// Function to populate game boxes
//function populateGameBoxes() {
//    const gameBoxesContainer = document.querySelector(".flex");
//
//    gamesData.forEach((game) => {
//        const gameBox = createGameBox(game);
//        gameBoxesContainer.appendChild(gameBox);
//    });
//}
//
//document.addEventListener("DOMContentLoaded", () => {
//    // Call the function to populate game boxes
//    populateGameBoxes();
//});








//add new Game to db functionality

const newGameButton = document.getElementById("addNewGameButton")
const addGameModal = document.getElementById('addGameModal');
const closeModalButton = document.getElementById('closeModal');
const addTitle = document.getElementById('addTitle');
const addPlatform = document.getElementById('addPlatforms');
const addStudio = document.getElementById('addGameStudio');
const addYearReleased = document.getElementById('addYear');
const addForm = document.getElementById('addForm')



newGameButton.addEventListener('click', () => {
  addGameModal.classList.remove('hidden');
});
closeModalButton.addEventListener('click', () => {
  addGameModal.classList.add('hidden');
});

///take register information and add to the my SUPERBASEEEE
const headers = {
    'Content-Type' : 'application/json'
}
const baseUrl = 'http://localhost:8080/api/v1/games'
const handleAddGameSubmit = async (e) =>{
    e.preventDefault();
    let bodyObj = {
        title: addTitle.value,
        studio: addStudio.value,
        year_released: addYearReleased.value,
        platforms: addPlatform.value
    }
    const response = await fetch(`${baseUrl}/newGame`,{
    method: "POST",
    body: JSON.stringify(bodyObj),
    headers: headers
    })
    const responseArr = await response.json();

if (response.status === 200) {
    console.log("pop up should happen now");
    // Show the pop-up box and hide register box
    addGameModal.classList.add("hidden");


    const loginSuccessModal = document.getElementById("loginSuccessModal");
    loginSuccessModal.classList.remove("hidden");

        // Close the pop --up after 3 seconds
    setTimeout(() => {
    loginSuccessModal.classList.add("hidden");
       console.log("test 2")
    }, 3000);

}
}

addForm.addEventListener('submit', handleAddGameSubmit);
;