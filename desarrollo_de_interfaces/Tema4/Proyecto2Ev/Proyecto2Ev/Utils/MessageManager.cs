using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev.Utils
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que gestiona la visualización de mensajes y diálogos en la aplicación.
=======
    /// Clase utilitaria que proporciona métodos para mostrar mensajes y solicitar confirmaciones en una aplicación Windows Forms.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class MessageManager
    {
        /// <summary>
<<<<<<< HEAD
        /// Muestra un mensaje de confirmación al usuario.
        /// </summary>
        /// <param name="messaje">El mensaje que se mostrará al usuario.</param>
        /// <returns>True si el usuario hace clic en "Sí", False si hace clic en "No".</returns>
        public static bool AskForConfirmation(string messaje)
        {
            // Muestra un cuadro de diálogo de confirmación con las opciones "Sí" y "No"
            return MessageBox.Show(messaje, "Confirmación", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes;
        }

        /// <summary>
        /// Muestra un mensaje informativo al usuario.
        /// </summary>
        /// <param name="title">El título del mensaje.</param>
        /// <param name="messaje">El mensaje que se mostrará al usuario.</param>
        public static void ShowMessaje(string title, string messaje)
        {
            // Muestra un cuadro de diálogo de mensaje con la opción "Aceptar"
            MessageBox.Show(messaje, title, MessageBoxButtons.OK, MessageBoxIcon.None);
        }

        /// <summary>
        /// Muestra una alerta de error al usuario.
        /// </summary>
        /// <param name="title">El título de la alerta.</param>
        /// <param name="messaje">El mensaje de error que se mostrará al usuario.</param>
        public static void ShowAlert(string title, string messaje)
        {
            // Muestra un cuadro de diálogo de alerta de error con la opción "Aceptar"
            MessageBox.Show(messaje, title, MessageBoxButtons.OK, MessageBoxIcon.Error);
=======
        /// Muestra un cuadro de diálogo de confirmación con un mensaje y botones Sí/No.
        /// </summary>
        /// <param name="message">El mensaje a mostrar en el cuadro de diálogo.</param>
        /// <returns>true si el usuario selecciona "Sí", false si selecciona "No".</returns>
        public static bool AskForConfirmation(string message)
        {
            if (MessageBox.Show(message, "Confirmación", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
            {
                return true;
            }
            return false;
        }

        /// <summary>
        /// Muestra un cuadro de diálogo de mensaje informativo.
        /// </summary>
        /// <param name="title">El título del cuadro de diálogo.</param>
        /// <param name="message">El mensaje a mostrar en el cuadro de diálogo.</param>
        public static void ShowMessage(string title, string message)
        {
            MessageBox.Show(message, title, MessageBoxButtons.OK, MessageBoxIcon.None);
        }

        /// <summary>
        /// Muestra un cuadro de diálogo de alerta con un mensaje de error.
        /// </summary>
        /// <param name="title">El título del cuadro de diálogo de alerta.</param>
        /// <param name="message">El mensaje de error a mostrar en el cuadro de diálogo.</param>
        public static void ShowAlert(string title, string message)
        {
            MessageBox.Show(message, title, MessageBoxButtons.OK, MessageBoxIcon.Error);
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        }
    }
}