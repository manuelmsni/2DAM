"""
Los elementos de personas que contienen la vocal “o”.
"""

personas = ["Carlota", "Enrique", "Ana"]

def personas_metodo(pers):
    persons = []
    for i in pers:
        if "o" in i:
            persons.append(i)
    return persons

print(personas_metodo(personas))

