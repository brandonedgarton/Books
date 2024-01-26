import random

deck = {"Ace of Spades": 1, "2 of Spades": 2, "3 of Spades": 3,
        "4 of Spades": 4, "5 of Spades": 5, "6 of Spades": 6,
        '7 of Spades': 7, '8 of Spades': 8, '9 of Spades': 9,
        '10 of Spades': 10, 'Jack of Spades': 10,
        'Queen of Spades': 10, 'King of Spades': 10,

        'Ace of Hearts': 1, '2 of Hearts': 2, '3 of Hearts': 3,
        '4 of Hearts': 4, '5 of Hearts': 5, '6 of Hearts': 6,
        '7 of Hearts': 7, '8 of Hearts': 8, '9 of Hearts': 9,
        '10 of Hearts': 10, 'Jack of Hearts': 10,
        'Queen of Hearts': 10, 'King of Hearts': 10,

        'Ace of Clubs': 1, '2 of Clubs': 2, '3 of Clubs': 3,
        '4 of Clubs': 4, '5 of Clubs': 5, '6 of Clubs': 6,
        '7 of Clubs': 7, '8 of Clubs': 8, '9 of Clubs': 9,
        '10 of Clubs': 10, 'Jack of Clubs': 10,
        'Queen of Clubs': 10, 'King of Clubs': 10,

        'Ace of Diamonds': 1, '2 of Diamonds': 2, '3 of Diamonds': 3,
        '4 of Diamonds': 4, '5 of Diamonds': 5, '6 of Diamonds': 6,
        '7 of Diamonds': 7, '8 of Diamonds': 8, '9 of Diamonds': 9,
        '10 of Diamonds': 10, 'Jack of Diamonds': 10,
        'Queen of Diamonds': 10, 'King of Diamonds': 10}

first_player = 0
second_player = 0

first_player_cards = []
second_player_cards = []

while first_player <= 21 and second_player < 21:
    card = random.choice(list(deck))
    if card == "Ace of Spades" or card == "Ace of Hearts" or card == "Ace of Clubs" or card == "Ace of Diamonds":
        if first_player + 11 <= 21:
            first_player += 11
            first_player_cards.append(card)
            del deck[card]
    else:
        first_player += deck[card]
        first_player_cards.append(card)
        del deck[card]

    card = random.choice(list(deck))
    if card == "Ace of Spades" or card == "Ace of Hearts" or card == "Ace of Clubs" or card == "Ace of Diamonds":
        if second_player + 11 <= 21:
            second_player += 11
            second_player_cards.append(card)
            del deck[card]
    else:
        second_player += deck[card]
        second_player_cards.append(card)
        del deck[card]

if first_player >= 21 and second_player >= 21:
    print("Both players' hand are over 21. No Winner!")
    print("Player 1 hands: ", first_player_cards)
    print("Player 2 hands: ", second_player_cards)
elif first_player >= 21:
    print("The winner is Player 2. And his cards are listed below. His total is", second_player)
    print(second_player_cards)
    print()
    print("Player 1 hand: ", first_player_cards, )
    print("Player 1 total: ", first_player)
elif second_player >= 21:
    print("The winner is Player 1. And his cards are listed below. His total is", first_player)
    print(first_player_cards)
    print()
    print("Player 2 hand: ", second_player_cards)
    print("Player 2 total: ", second_player)


