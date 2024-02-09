"""
Los elementos de personas con más de 5 caracteres.
"""

personas = ["Carlota", "Enrique", "Ana"]

def personas_metodo(pers):
    persons = []
    for i in pers:
        if len(i) > 5:
            persons.append(i)
    return persons

print(personas_metodo(personas))

