import re

# Sample file path (replace with actual path)
file_path = "C:\\Users\\Asus\\Downloads\\Pokemon Essentials v21.1 2023-07-30\\Pokemon Essentials v21.1 2023-07-30\\PBS\\pokemon.txt"

# Function to parse a Pokémon's move list and generate addMove statements
def parse_moves(pokemon_name, moves_data):
    moves = []
    # Find the "Moves" section and extract the pairs of level and move name
    move_entries = re.findall(r"(\d+),([A-Z]+)", moves_data)
    for level, move in move_entries:
        moves.append(f"ivysaur.addMove(new Move(\"{move}\", {level}));")
    return moves

# Read the text file
with open(file_path, 'r') as file:
    data = file.read()

# Find each Pokémon's data block (e.g., [BULBASAUR], [IVYSAUR], etc.)
pokemon_blocks = re.findall(r"\[(.*?)\]\s*Name = (.*?)\s*Moves = (.*?)\s*(?=\[|$)", data, re.S)

# Iterate through each Pokémon and generate their move list
for block in pokemon_blocks:
    pokemon_name = block[1]
    moves_data = block[2]
    move_statements = parse_moves(pokemon_name, moves_data)
    
    print(f"// Moves for {pokemon_name}")
    for statement in move_statements:
        print(statement)
    print()
