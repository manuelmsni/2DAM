using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    public class Calc
    {
        /// <summary>
        /// Realiza un cálculo de conversión utilizando los factores proporcionados.
        /// </summary>
        /// <param name="quantity">La cantidad que se va a convertir.</param>
        /// <param name="firstFactor">El factor de conversión de la primera unidad a una unidad común.</param>
        /// <param name="secondFactor">El factor de conversión de la unidad común a la segunda unidad.</param>
        /// <returns>El resultado de la conversión de la cantidad entre las dos unidades.</returns>
        public static decimal? Conversion(decimal? quantity, decimal firstFactor, decimal secondFactor)
        {
            return (quantity * firstFactor) / secondFactor;
        }
    }
}
