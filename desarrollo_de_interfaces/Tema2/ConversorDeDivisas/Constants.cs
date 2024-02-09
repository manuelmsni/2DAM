using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    internal class Constants
    {
        // Archivo en el que se guardan los datos de las divisas
        public const string CurrencyDataFile = "Currencies.json";

        // Archivo en el que se guarda el historial de transacciones
        public const string OutputRegisterFile = "Output.txt";

        // Archivo en el que se guarda el historial de errores
        public const string ErrorLogFile = "Errors.log";
    }
}
