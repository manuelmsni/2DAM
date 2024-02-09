using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace GestorDeArchivos.util
{
    public class ButtonNameFormatter
    {
        /// <summary>
        /// Formatea el texto truncándolo a 7 caracteres seguido de puntos suspensivos si la longitud es mayor que 9.
        /// </summary>
        /// <param name="text">Texto a ser formateado.</param>
        /// <returns>Texto formateado.</returns>
        public static string Format(string text)
        {
            if (text.Count() > 9) text = $"{text.Substring(0, 7)}...";
            return text;
        }
    }
}
