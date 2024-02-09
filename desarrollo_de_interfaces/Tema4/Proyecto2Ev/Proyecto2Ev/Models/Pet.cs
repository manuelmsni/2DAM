using System;
using System.Collections.Generic;

namespace Proyecto2Ev.Models
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa una mascota en la aplicación.
=======
    /// Clase que representa una mascota con atributos como nombre, familia, especie, precio, imagen, etc.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class Pet
    {
        /// <summary>
        /// Identificador único de la mascota.
        /// </summary>
        public Guid Id { get; set; }

        /// <summary>
        /// Nombre de la mascota.
        /// </summary>
        public string Name { get; set; }

        /// <summary>
        /// Familia a la que pertenece la mascota.
        /// </summary>
        public string Family { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Especie de la mascota.
=======
        /// Especie a la que pertenece la mascota.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public string Specie { get; set; }

        /// <summary>
        /// Precio de la mascota.
        /// </summary>
        public double Price { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Número de visitas que ha recibido la mascota.
=======
        /// Número de visitas a la mascota.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public int Visited { get; set; }

        /// <summary>
        /// Ruta de la imagen de la mascota.
        /// </summary>
        public string Picture { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Fecha de nacimiento de la mascota.
=======
        /// Fecha de nacimiento o edad de la mascota.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public DateTime Age { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Constructor predeterminado de la clase `Pet`.
=======
        /// Constructor vacío de la clase Pet.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public Pet() { }

        /// <summary>
<<<<<<< HEAD
        /// Constructor de la clase `Pet` que inicializa las propiedades básicas.
        /// </summary>
        /// <param name="name">Nombre de la mascota.</param>
        /// <param name="family">Familia a la que pertenece la mascota.</param>
        /// <param name="specie">Especie de la mascota.</param>
        /// <param name="price">Precio de la mascota.</param>
        /// <param name="picture">Ruta de la imagen de la mascota.</param>
        /// <param name="birth">Fecha de nacimiento de la mascota.</param>
        public Pet(string name, string family, string specie, double price, string picture, DateTime birth)
=======
        /// Constructor de la clase Pet que recibe parámetros para inicializar sus atributos.
        /// </summary>
        /// <param name="name">Nombre de la mascota.</param>
        /// <param name="family">Familia de la mascota.</param>
        /// <param name="specie">Especie de la mascota.</param>
        /// <param name="price">Precio de la mascota.</param>
        /// <param name="picture">Ruta de la imagen de la mascota.</param>
        /// <param name="birth">Fecha de nacimiento o edad de la mascota.</param>
        public Pet(string name, string family, string specie, double price, string picture, DateTime birth, int visited)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        {
            Id = Guid.NewGuid();
            Name = name;
            Family = family;
            Specie = specie;
            Price = price;
            Picture = picture;
            Age = birth;
            Visited = visited;
        }

        /// <summary>
        /// Convierte la información de la mascota en una cadena de texto.
        /// </summary>
<<<<<<< HEAD
        /// <returns>Cadena que representa la mascota y su especie.</returns>
=======
        /// <returns>Una cadena de texto que representa la mascota con su nombre y especie.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public override string ToString()
        {
            return $"{Name} ({Specie})";
        }

        /// <summary>
<<<<<<< HEAD
        /// Convierte la información de la mascota en una cadena formateada para su almacenamiento en archivo.
        /// </summary>
        /// <returns>Cadena formateada para almacenar la información de la mascota en un archivo.</returns>
        public string ToFile()
        {
            return $"{Id};{Name};{Family};{Specie};{Price};{Picture};{Age.ToString("yyyy-MM-dd")}";
        }

        /// <summary>
        /// Crea una instancia de la clase `Pet` a partir de una cadena de texto almacenada en un archivo.
        /// </summary>
        /// <param name="line">Cadena que contiene la información de la mascota.</param>
        /// <returns>Instancia de la clase `Pet` creada a partir de la cadena.</returns>
=======
        /// Convierte la información de la mascota en una cadena de texto para ser guardada en un archivo.
        /// </summary>
        /// <returns>Una cadena de texto que representa la mascota con sus atributos separados por punto y coma.</returns>
        public string ToFile()
        {
            return $"{Id};{Name};{Family};{Specie};{Price};{Picture};{Age}";
        }

        /// <summary>
        /// Crea una instancia de mascota a partir de una cadena de texto que contiene sus atributos separados por punto y coma.
        /// </summary>
        /// <param name="line">La cadena de texto que contiene los atributos de la mascota.</param>
        /// <returns>Una instancia de mascota con los atributos correspondientes.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static Pet FromFile(string line)
        {
            string[] data = line.Split(';');
            Pet temp = new Pet(data[1], data[2], data[3], double.Parse(data[4]), data[5], DateTime.Parse(data[6]), int.Parse(data[7]));
            temp.Id = Guid.Parse(data[0]);
            return temp;
        }

        /// <summary>
<<<<<<< HEAD
        /// Compara la instancia actual de la mascota con otro objeto para determinar si son iguales.
        /// </summary>
        /// <param name="obj">Objeto a comparar con la mascota.</param>
        /// <returns>True si los objetos son iguales, False en caso contrario.</returns>
=======
        /// Compara dos objetos mascota para determinar si son iguales.
        /// </summary>
        /// <param name="obj">El objeto a comparar con la mascota actual.</param>
        /// <returns>true si los objetos son iguales, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public override bool Equals(object obj)
        {
            if (obj == null) return false;
            return obj is Pet pet &&
                   Id == pet.Id &&
                   Name == pet.Name &&
                   Family == pet.Family &&
                   Specie == pet.Specie &&
                   Price == pet.Price &&
                   Picture == pet.Picture &&
                   Visited == pet.Visited &&
                   Age == pet.Age;
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene el código hash de la instancia actual de la mascota.
        /// </summary>
        /// <returns>Código hash de la instancia de la mascota.</returns>
=======
        /// Obtiene el código hash de la mascota.
        /// </summary>
        /// <returns>El código hash de la mascota.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public override int GetHashCode()
        {
            int hashCode = -1523756611;
            hashCode = hashCode * -1521134295 + Id.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Name);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Family);
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Specie);
            hashCode = hashCode * -1521134295 + Price.GetHashCode();
            hashCode = hashCode * -1521134295 + EqualityComparer<string>.Default.GetHashCode(Picture);
            hashCode = hashCode * -1521134295 + Visited.GetHashCode();
            hashCode = hashCode * -1521134295 + Age.GetHashCode();
            return hashCode;
        }

        /// <summary>
        /// Obtiene la edad de la mascota en años.
        /// </summary>
<<<<<<< HEAD
        /// <returns>Cadena que representa la edad de la mascota en años.</returns>
=======
        /// <returns>La edad de la mascota en años.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public string GetAge()
        {
            return $"{(DateTime.Now.Year - Age.Year)}";
        }
    }
}