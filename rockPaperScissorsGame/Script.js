let userScore = 0;
let compScore = 0;

const choices = document.querySelectorAll(".choice")
const msg = document.querySelector("#msg");

const userScorePara = document.querySelector("#user-Score");
const userCompPara = document.querySelector("#comp-Score");

const getCompChoice = () => {
    const option = ["rock","paper","scissors"]
    const randomIdx = Math.floor(Math.random()*3);
    return option[randomIdx]
}

const drawGame = () =>{
    console.log("The game was drow...!");
    msg.innerText = "Game was drow.Play Again...!"
}

const showWinner = (userWin) =>{
    if(userWin) {
        userScore++;
        userScorePara.innerText = userScore;
        // console.log("You Win");

        msg.innerText = `You Win! your ${userChoice} beats ${compChoice}`;
        msg.style.backgroundColor = "green";
    }else{
        compScore++;
        userCompPara.innerText = compScore;
        msg.innerText =`You lose! your ${compChoice} beats your${userChoice}`;
        msg.style.backgroundColor = "red";
    }
}

const playGame = (userChoice)=>{
    console.log("User choice =",userChoice)
    //Generate computer choice
    const compChoice = getCompChoice();
    console.log("Comp choice =",compChoice);

    if(userChoice === compChoice)
    {
        drawGame();
    }
    else{
        let userWin = true;
        if (userChoice === "rock") {
            //scissors paper    
            userWin=compChoice==="paper"? false:true;
        }else if (userChoice === "paper"){
            //rock scissors
            userWin = compChoice === "scissors"?false:true;
        }else if (userChoice === "scissors"){
            //rock scissors
            userWin = compChoice === "rock"?false:true;
        }
        showWinner(userWin);
    }
}
choices.forEach((choice) => {
    choice.addEventListener("click", () => {
        const userChoice = choice.getAttribute("id");
        playGame(userChoice);   
    })
});