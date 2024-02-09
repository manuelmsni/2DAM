using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    public class JsonManager<T>
    {
        /// <summary>
        /// Lee y deserializa un archivo JSON en la ruta especificada en una secuencia de elementos de tipo T.
        /// </summary>
        /// <param name="path">La ruta del archivo JSON que se va a leer y deserializar.</param>
        /// <returns>Una secuencia de elementos de tipo T o null en caso de error o si el archivo no existe.</returns>
        public static IEnumerable<T>? GetCurrenciesFromJsonFile(string path)
        {
            if (!File.Exists(path)) return null;
            string json = String.Empty;
            try
            {
                json = File.ReadAllText(path);
            }
            catch (Exception ex)
            {
                Error.Show_Error(ex);
            }
            if (json == String.Empty) return null;
            return JsonSerializer.Deserialize<IEnumerable<T>>(json);
        }
    }
}
