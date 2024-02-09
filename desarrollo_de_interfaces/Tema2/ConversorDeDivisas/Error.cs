using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    internal class Error
    {
        /// <summary>
        /// Trata de registrar un error en el archivo de registro de errores y sale de la aplicación.
        /// Si no puede escribir en él, sale de la aplicación.
        /// </summary>
        /// <param name="ex">La excepción que se va a registrar.</param>
        private static void Log(Exception ex)
        {
            string errorMessage = $"{DateTime.Now:yyyy-MM-dd HH:mm:ss} - Error: {ex.Message}\nStackTrace: {ex.StackTrace}\n";
            if(!FileManager.Write(errorMessage, Constants.ErrorLogFile, true)) Environment.Exit(0);
        }

        /// <summary>
        /// Registra el error y muestra un mensaje de alerta al usuario con el mensaje de la excepción.
        /// </summary>
        /// <param name="ex">La excepción que se va a mostrar.</param>
        public static void Show_Error(Exception ex)
        {
            Log(ex);
            MessageBox.Show(ex.Message, "Alerta", MessageBoxButtons.OK, MessageBoxIcon.Warning);
        }

        /// <summary>
        /// Muestra un mensaje de error fatal al usuario y sale de la aplicación.
        /// </summary>
        /// <param name="ex">La excepción que se va a mostrar como error fatal.</param>
        public static void Fatal_Error(Exception ex)
        {
            Show_Error(ex);
            Environment.Exit(0);
        }

        /// <summary>
        /// Muestra un mensaje de alerta al usuario pidiendo confirmación.
        /// </summary>
        /// <param name="ex">La excepción que se va a mostrar.</param>
        /// <returns>True si el usuario elige No, False si elige Yes.</returns>
        public static bool Ask_Confirmation(Exception ex)
        {
            Log(ex);
            DialogResult resultado = MessageBox.Show(ex.Message, "Alerta", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (resultado == DialogResult.No) return false;
            return true;
        }
    }
}
