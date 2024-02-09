"""
Los elementos de personas que contienen la vocal “e” y además tienen una longitud de al menos 6 caracteres.
"""

personas = ["Carlota", "Enrique", "Ana"]

def personas_metodo(pers):
    persons = []
    for i in pers:
        if "e" in i and len(i) >= 6:
            persons.append(i)
    return persons

print(personas_metodo(personas))