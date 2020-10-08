import pandas as pd

def get_spread(path_to_file, col1, col2):
    """Returns the row with the minimum spread between two given columns
    """
    table = pd.read_csv(path_to_file, index_col=0)
    difference = table[col1] - table[col2]
    return difference.abs().idxmin()

day = get_spread("resources/weather.csv", "MxT", "MnT")
print(f"Day with smallest temperature spread: {day}")

team = get_spread("resources/football.csv", "Goals Allowed", "Goals")
print(f"Team with smallest goal spread: {team}") 
