"""
Escribir un programa que implemente un directorio. En el directorio se podrán guardar para cada dni información relativa a la persona como nombre, dirección y teléfono. El programa nos dará el siguiente menú:

Añadir/modificar: Nos pide un dni. Si el dni se encuentra en el directorio, debe mostrar los datos y, opcionalmente, permitir modificarlos si no es correcto. Si el dni no se encuentra, debe permitir ingresar los datos correspondientes.
Buscar: Nos pide un dni, y nos muestra el contacto.
Borrar: Nos pide un dni y si existe nos preguntará si queremos borrarlo del directorio.
Listar: Nos muestra todos los contactos del directorio. Implementar el programa con un diccionario. 

"""

directorio = {}

def agregar_modificar_contacto():
    dni = input("Ingrese el DNI: ")
    if dni in directorio:
        print("El contacto ya existe:")
        print("Nombre:", directorio[dni]["nombre"])
        print("Dirección:", directorio[dni]["direccion"])
        print("Teléfono:", directorio[dni]["telefono"])
        modificar = input("¿Desea modificar el contacto? (s/n): ")
        if modificar.lower() == "s":
            directorio[dni]["nombre"] = input("Ingrese el nuevo nombre: ")
            directorio[dni]["direccion"] = input("Ingrese la nueva dirección: ")
            directorio[dni]["telefono"] = input("Ingrese el nuevo teléfono: ")
    else:
        nombre = input("Ingrese el nombre: ")
        direccion = input("Ingrese la dirección: ")
        telefono = input("Ingrese el teléfono: ")
        directorio[dni] = {"nombre": nombre, "direccion": direccion, "telefono": telefono}

def buscar_contacto():
    dni = input("Ingrese el DNI: ")
    if dni in directorio:
        print("Contacto encontrado:")
        print("Nombre:", directorio[dni]["nombre"])
        print("Dirección:", directorio[dni]["direccion"])
        print("Teléfono:", directorio[dni]["telefono"])
    else:
        print("Contacto no encontrado.")

def borrar_contacto():
    dni = input("Ingrese el DNI: ")
    if dni in directorio:
        confirmar = input("¿Está seguro de que desea borrar el contacto? (s/n): ")
        if confirmar.lower() == "s":
            del directorio[dni]
            print("Contacto borrado.")
    else:
        print("Contacto no encontrado.")

def listar_contactos():
    print("Contactos en el directorio:")
    for dni, contacto in directorio.items():
        print("DNI:", dni)
        print("Nombre:", contacto["nombre"])
        print("Dirección:", contacto["direccion"])
        print("Teléfono:", contacto["telefono"])
        print()

while True:
    print("Menú:")
    print("1. Agregar/Modificar contacto")
    print("2. Buscar contacto")
    print("3. Borrar contacto")
    print("4. Listar contactos")
    print("5. Salir")
    eleccion = input("Ingrese su elección: ")
    if eleccion == "1":
        agregar_modificar_contacto()
    elif eleccion == "2":
        buscar_contacto()
    elif eleccion == "3":
        borrar_contacto()
    elif eleccion == "4":
        listar_contactos()
    elif eleccion == "5":
        break
    else:
        print("Elección inválida. Por favor, intente nuevamente.")
