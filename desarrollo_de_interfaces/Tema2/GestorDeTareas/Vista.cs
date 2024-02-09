using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using static System.Net.Mime.MediaTypeNames;

namespace GestorDeTareas
{
    internal class Vista
    {
        int MaxYear = Constantes.MaxYearAllowed;
        Controlador Controller { get; set; }
        public Vista()
        {
        }
        public void Init(Controlador controller)
        {
            Controller = controller;
            bool salir = false;
            do {
                salir = Menu();
            } while (!salir);
        }
        public bool Menu()
        {
            Log(
                "\n" +
                "* * * * * * * * * * * * * * * * * * * * * *\n" +
                "* --- Aplicación de gestión de tareas --- *\n" +
                "* * * * * * * * * * * * * * * * * * * * * *\n" +
                "\n" +
                "1. - Listar todas las tareas\n" +
                "2. - Listar tareas incompletas\n" +
                "3. - Listar tareas por fecha de vencimiento\n" +
                "4. - Agregar nueva tarea\n" +
                "5. - Marcar tarea como completada\n" +
                "6. - Guardar tareas en archivo\n" +
                "7. - Cargar tareas desde archivo\n" +
                "8. - Salir\n"
                );

            int response = AskForIntRange("Elige una opción:", 1, 8);
            if (response == 8) return true;

            Controller.performAction(response);

            return false;
        }
        public void Log(string text)
        {
            Console.WriteLine(text);
        }
        public bool CheckExtension(string path, string extensions)
        {
            foreach (string extension in extensions.Split(","))
            {
                if (path.EndsWith(extension)) return true;
            }
            return false;
        }
        public string AskForFileWithExtension(string mensaje, string extensions)
        {
            string ruta;
            bool valid;
            do
            {
                ruta = AskForFile(mensaje);
                valid = CheckExtension(ruta, extensions);
                if (!valid) Log("El fichero introducido no tiene una extensión válida, introduce uno válido:");
            } while (!valid);
            return ruta;
        }
        public string AskForFile(string mensaje)
        {
            Console.WriteLine(mensaje);
            string ruta;
            bool existe;
            do
            {
                ruta = AskForstring();
                existe = File.Exists(ruta);
                if (!existe) Log("El fichero introducido no existe, introduce uno válido:");
            } while (!existe);
            return ruta;
        }
        private bool IsLeap(int año)
        {
            return (año % 4 == 0 && !(año % 100 == 0)) || año % 400 == 0;
        }
        private int MaxMonthDays(int month, int year)
        {
            if (month < 0 || month > 12 || year < 0) return -1;
            bool isLeap = IsLeap(year);
            if(month == 2)
            {
                if (isLeap) return 29;
                return 28;
            }
            if(month == 4 || month == 6 || month == 9 || month == 11) return 30;
            return 31;
        }
        public DateTime AskForDate(string mensaje)
        {
            DateTime fecha = DateTime.Now;
            int year = fecha.Year;
            int month = fecha.Month;
            int day = fecha.Day;
            year = AskForIntRange("introduce el año:", year, MaxYear);
            if (fecha.Year == year)
            {
                month = AskForIntRange("introduce el mes:", month, 12);
                if(fecha.Month == month)
                {
                    day = AskForIntRange("introduce el día:", fecha.Day, MaxMonthDays(month, year));
                } else
                {
                    day = AskForIntRange("introduce el día:", 1, MaxMonthDays(month, year));
                }
            } else
            {
                month = AskForIntRange("introduce el mes:", 1, 12);
                day = AskForIntRange("introduce el día:", 1, MaxMonthDays(month, year));
            }
            return new DateTime(year, month, day);
        }
        public int AskForIntRange(string mensaje, int minIncluded, int maxIncluded)
        {
            int response;
            bool isInRange = false;
            do
            {
                response = AskForInt(mensaje);
                isInRange = minIncluded <= response && response <= maxIncluded;
                if (!isInRange) Console.WriteLine($"El número seleccionado no está en el rango [{minIncluded}, {maxIncluded}], introduce un número en el rango, límites incluidos:");
            } while (!isInRange);
            return response;
        }
        public int AskForInt(string mensaje)
        {
            string response;
            bool isInt = false;
            do
            {
                response = AskForString(mensaje);
                isInt = Regex.IsMatch(response, @"^-?\d+$");
                if (!isInt) Console.WriteLine("Has de introducir un entero:");
            } while (!isInt);
            return int.Parse(response);
        }
        public bool AskForBool(string mensaje)
        {
            string response;
            bool invalidResponse = true;
            do
            {
                invalidResponse = false;
                response = AskForString(mensaje);
                if (response.Equals("si", StringComparison.OrdinalIgnoreCase)) return true;
                else if (response.Equals("no", StringComparison.OrdinalIgnoreCase)) return false;
                else invalidResponse = true;
                if (invalidResponse) Console.WriteLine("Has de introducir Si / No:");
            } while (invalidResponse);
            return false;
        }
        public string AskForString(string mensaje)
        {
            Console.WriteLine(mensaje);
            return AskForstring();
        }
        public string AskForstring()
        {
            string output = "";
            bool empty = true;
            do
            {
                output = Console.ReadLine()?.Trim()?.Replace("\r", "")?.Replace("\n", "") ?? string.Empty;
                empty = output.Length == 0;
                if (empty) Console.WriteLine("No has introducido nada, introduce el dato solicitado:");
            } while (empty);
            return output;
        }
    }
}
