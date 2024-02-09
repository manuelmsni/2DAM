using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2Ev.Models
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa un filtro utilizado para la consulta de datos en la aplicación.
=======
    /// Clase que representa un filtro utilizado en una aplicación para filtrar datos por nombre y columna en una base de datos.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class Filter
    {
        /// <summary>
        /// Nombre del filtro.
        /// </summary>
        public string Name { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Nombre de la columna en la base de datos asociada al filtro.
=======
        /// Nombre de la columna de la base de datos asociada al filtro.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public string DBColumn { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Constructor de la clase `Filter` que inicializa el nombre y la columna de la base de datos del filtro.
        /// </summary>
        /// <param name="name">Nombre del filtro.</param>
        /// <param name="dBColumn">Nombre de la columna en la base de datos asociada al filtro.</param>
=======
        /// Constructor de la clase Filter que recibe el nombre y la columna de la base de datos.
        /// </summary>
        /// <param name="name">Nombre del filtro.</param>
        /// <param name="dBColumn">Nombre de la columna de la base de datos asociada al filtro.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public Filter(string name, string dBColumn)
        {
            Name = name;
            DBColumn = dBColumn;
        }

        /// <summary>
<<<<<<< HEAD
        /// Convierte la instancia del filtro en una cadena de texto.
        /// </summary>
        /// <returns>Nombre del filtro.</returns>
=======
        /// Convierte el filtro en una cadena de texto representando su nombre.
        /// </summary>
        /// <returns>El nombre del filtro en forma de cadena de texto.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public override string ToString()
        {
            return Name;
        }
    }
}