const baseUrl = 'http://localhost:8080/api/v1/games'
const headers = {
    'Content-Type' : 'application/json'
}
let counter = 0;

const gamesData = [
    {
        title: "Game 1",
        studio: "Studio 1",
        platforms: "Platform 1, Platform 2",
        year: "2022",
        id: -1
    },
    {
        title: "Game 2",
        studio: "Studio 2",
        platforms: "Platform 3",
        year: "2021",
        id: -2
    }
    ]

let newGameFromDb = {

        title: null,
        studio: null,
        platforms: null,
        year: null,
        id: null

}

async function getGame(gameId){
    await fetch(`${baseUrl}/${gameId}`, {
        method: "GET",
        headers: headers
    })
        .then(res =>{
        console.log(res.status);
         return res.json();
        })
        .then(data => {
        console.log(data)
            newGameFromDb = {
                title: JSON.stringify(data.title),
                studio: JSON.stringify(data.studio),
                platforms: JSON.stringify(data.platforms),
                year: JSON.stringify(data.year_released),
                id: JSON.stringify(data.id)
                }
        gamesData.push(newGameFromDb);
        })
        }
//getGame(1);
//getGame(2);

console.log(gamesData)


    // Add more game objects as needed

function createGameBox(gameData) {
    const template = document.getElementById("gameBoxTemplate");
    const gameBox = template.cloneNode(true);
    gameBox.classList.remove("hidden");




    gameBox.innerHTML = `
        <h2 class="text-xl font-semibold">${gameData.title}</h2>
        <p>Studio: ${gameData.studio}</p>
        <p>Platforms: ${gameData.platforms}</p>
        <p>Year Released: ${gameData.year}</p>
                    <div class="absolute top-0 right-0 p-2">

                        <button id="${gameData.id}" onclick="addToSelectedGames('${gameData.id}', 'to-play')" class="px-2 py-1 bg-blue-500 hover:bg-blue-600 text-white font-bold rounded-full focus:outline-none focus:shadow-outline-blue active:bg-blue-800 text-center mr-2">To-Play</button>
                        <button id="${gameData.id}"  onclick="addToSelectedGames('${gameData.id}', 'played')" class="px-2 py-1 bg-green-500 hover:bg-green-600 text-white font-bold rounded-full focus:outline-none focus:shadow-outline-green active:bg-green-800 text-center mr-2">Played</button>

                        <button class="px-2 py-1 bg-red-500 hover:bg-red-600 text-white font-bold rounded-full focus:outline-none focus:shadow-outline-red active:bg-red-800 text-center">Delete</button>
                    </div>
    `;

    return gameBox;
}

// Function to populate game boxes
function populateGameBoxes() {

    const gameBoxesContainer = document.getElementById("gameContainer");

    gamesData.forEach((game) => {
        const gameBox = createGameBox(game);
        gameBoxesContainer.appendChild(gameBox);
    });
}

//document.addEventListener("DOMContentLoaded", () => {
//    // Call the function to populate game boxes
//    populateGameBoxes();
//});


async function initialize() {
    console.log("Initializing...");
    // Fetch all the game data asynchronously
    await counterFun(counter);

    // Now that all data is fetched, populate the game boxes
    console.log(gamesData);
    populateGameBoxes();
}

// Call the initialize function to fetch data and populate game boxes
initialize();





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
    }).then((response) => {
    return response.json()
    })
    .then((data) => {

console.log(data)
        console.log("pop up should happen now");
        counter++;

        // Show the pop-up box and hide register box
        addGameModal.classList.add("hidden");


        const loginSuccessModal = document.getElementById("loginSuccessModal");
        loginSuccessModal.classList.remove("hidden");

            // Close the pop --up after 3 seconds
        setTimeout(() => {
        loginSuccessModal.classList.add("hidden");
           console.log("test 2")
        }, 3000);







    })
//    const responseArr = await response.json();


}

addForm.addEventListener('submit', handleAddGameSubmit);
;

//grab from games data and add to boxes


async function counterFun(counter) {
    console.log("Starting counterFun...");
    while (counter + 30 > 0) {
        await getGame(counter + 30);
        counter--;
    }
    console.log("counterFun completed.");
}
const myLibraryLink = document.getElementById("myLibraryLink");
const toPlayShelf = document.getElementById("toPlayShelf");
const playedShelf = document.getElementById("playedShelf");

myLibraryLink.addEventListener("click", () => {
    // Toggle the visibility of the shelves when the link is clicked
    toPlayShelf.classList.toggle("hidden");
    playedShelf.classList.toggle("hidden");
});

let playedArr = [];
let toPlayArr = [];


function addToSelectedGames(gameName, action) {
  // Check the action parameter to determine whether the game is played or to-play
  if (action === "played") {
    console.log(`Marked "${gameName}" as Played.`);
    playedArr.push(gameName)
    console.log(playedArr)
    // Add your logic for handling the "Played" action here
  } else if (action === "to-play") {
    console.log(`Marked "${gameName}" as To-Play.`);
    toPlayArr.push(gameName)
    console.log(toPlayArr)
    // Add your logic for handling the "To-Play" action here
  }
}





