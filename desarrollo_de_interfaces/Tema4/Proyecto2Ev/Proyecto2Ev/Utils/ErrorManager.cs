using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2Ev.Utils
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que gestiona y registra errores en la aplicación.
=======
    /// Clase utilitaria que proporciona métodos para gestionar errores, mostrar mensajes al usuario y registrar errores en un archivo de registro.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class ErrorManager
    {
        /// <summary>
<<<<<<< HEAD
        /// Registra un error, muestra un mensaje al usuario y guarda detalles del error en un archivo de registro.
        /// </summary>
        /// <param name="ex">La excepción que se va a manejar.</param>
=======
        /// Registra un error, muestra un mensaje al usuario y guarda el error en un archivo de registro.
        /// </summary>
        /// <param name="ex">La excepción que se desea registrar y mostrar.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static void Register(Exception ex)
        {
            ShowToUser(ex); // Muestra un mensaje de alerta al usuario con detalles del error.
            Save(ex); // Guarda los detalles del error en un archivo de registro.
        }

        /// <summary>
<<<<<<< HEAD
        /// Muestra un mensaje de error al usuario.
        /// </summary>
        /// <param name="ex">La excepción cuyo mensaje se va a mostrar.</param>
=======
        /// Muestra un mensaje de alerta al usuario con los detalles de la excepción.
        /// </summary>
        /// <param name="ex">La excepción de la que se mostrarán los detalles.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static void ShowToUser(Exception ex)
        {
            MessageManager.ShowAlert("Error", $"Se produjo un error:\n\n{ex.Message}");
        }

        /// <summary>
<<<<<<< HEAD
        /// Guarda detalles de la excepción en un archivo de registro.
        /// </summary>
        /// <param name="ex">La excepción cuyos detalles se van a guardar.</param>
=======
        /// Guarda los detalles de la excepción en un archivo de registro.
        /// </summary>
        /// <param name="ex">La excepción que se desea registrar.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static void Save(Exception ex)
        {
            // Utilizando un StreamWriter para escribir en el archivo de registro de errores
            using (StreamWriter writer = new StreamWriter(Constants.ErrorLogFile, true))
            {
                // Escribir la fecha y hora actual
                writer.WriteLine($"Fecha y hora: {DateTime.Now}");

                // Escribir la información de la excepción
                writer.WriteLine($"Mensaje de error: {ex.Message}");
                writer.WriteLine($"Tipo de excepción: {ex.GetType().FullName}");
                writer.WriteLine($"Stack Trace: {ex.StackTrace}");

                // Separador para distinguir entre diferentes registros de errores
                writer.WriteLine(new string('-', 50));
            }
        }
    }
}