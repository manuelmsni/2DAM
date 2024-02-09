using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    internal class FileManager
    {
        /// <summary>
        /// Escribe el texto especificado en un archivo en la ruta especificada.
        /// </summary>
        /// <param name="text">El texto que se va a escribir en el archivo.</param>
        /// <param name="path">La ruta del archivo en el que se va a escribir.</param>
        /// <param name="append">Indica si se debe agregar el texto al archivo existente (true) o sobrescribir el archivo (false).</param>
        /// <returns>True si la operación de escritura es exitosa, de lo contrario, false.</returns>
        public static bool Write(string text, string path, bool append)
        {
            try
            {
                using (StreamWriter writer = new StreamWriter(path, append))
                {
                    writer.Write(text);
                }
                return true;
            }
            catch (Exception ex)
            {
                Error.Show_Error(ex);
                return false;
            }
        }

        /// <summary>
        /// Lee y retorna el contenido completo de un archivo en la ruta especificada.
        /// </summary>
        /// <param name="path">La ruta del archivo que se va a leer.</param>
        /// <returns>El contenido completo del archivo como una cadena, o una cadena vacía en caso de error.</returns>
        public static string ReadAll(string path)
        {
            try
            {
                using (StreamReader reader = new StreamReader(path))
                {
                    return reader.ReadToEnd();
                }
            }
            catch (Exception ex)
            {
                Error.Show_Error(ex);
                return String.Empty;
            }
        }
    }
}
