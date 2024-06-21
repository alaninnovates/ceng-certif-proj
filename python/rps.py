import random

while True:
    plr_score = 0
    tries = 0
    while tries < 3:
        print("Round", tries + 1)
        plr = input("Rock, Paper, or Scissors? ").lower()
        if plr not in ["rock", "paper", "scissors"]:
            print("Invalid input. Try again.")
            continue
        comp = random.choice(["rock", "paper", "scissors"])
        print("Computer chose", comp)
        if plr == comp:
            print("Tie!")
        elif (plr == "rock" and comp == "scissors") or (plr == "paper" and comp == "rock") or (plr == "scissors" and comp == "paper"):
            print("You win!")
            plr_score += 1
        else:
            print("You lose!")
        tries += 1
    if plr_score >= 2:
        print("=> You win the game! <=")
    else:
        print("=> You lose the game! <=")
    play_again = input("Do you want to play again? (yes/no) ").lower()
    if play_again != "yes":
        break
