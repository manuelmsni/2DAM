using Proyecto2Ev.Utils;
using System;
using System.Drawing;
using System.Windows.Forms;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que extiende TextBox para proporcionar funcionalidad de marcador de posición (placeholder).
=======
    /// Clase personalizada que extiende la funcionalidad de un TextBox para proporcionar un marcador de posición.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class PlaceHolder : TextBox
    {
        /// <summary>
<<<<<<< HEAD
        /// Texto del marcador de posición.
=======
        /// Obtiene o establece el texto del marcador de posición.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public string PlaceHolderText { get; set; }

        private bool PlaceholderActive { get; set; }

        private bool Valid = true;

        /// <summary>
<<<<<<< HEAD
        /// Constructor de la clase PlaceHolder.
        /// </summary>
        /// <param name="placeHolderText">Texto del marcador de posición.</param>
=======
        /// Crea una nueva instancia de la clase PlaceHolder con el texto del marcador de posición especificado.
        /// </summary>
        /// <param name="placeHolderText">Texto del marcador de posición que se mostrará en el cuadro de texto cuando esté vacío.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public PlaceHolder(string placeHolderText)
        {
            PlaceHolderText = placeHolderText;
            Location = new System.Drawing.Point(55, 3);
            Name = $"PlaceHolder_{placeHolderText}";
            Size = new System.Drawing.Size(139, 20);
            TabIndex = 1;
            Dock = DockStyle.Right;
            PlaceHolderText = placeHolderText;

            SetPlaceHolder();

            // Manejar el evento Enter para limpiar el texto por defecto
            Enter += (sender, e) =>
            {
                if (Text == PlaceHolderText)
                {
                    EmptyPlaceHolder();
                }
            };

            // Manejar el evento Leave para restablecer el marcador texto por defecto
            Leave += (sender, e) =>
            {
                if (string.IsNullOrWhiteSpace(Text))
                {
                    SetPlaceHolder();
                }
            };
        }

        /// <summary>
<<<<<<< HEAD
        /// Establece el texto del control.
        /// </summary>
        /// <param name="text">Texto a establecer.</param>
=======
        /// Establece el texto del cuadro de texto.
        /// </summary>
        /// <param name="text">El texto que se establecerá en el cuadro de texto.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public void SetText(string text)
        {
            Text = text;
            ForeColor = System.Drawing.SystemColors.ControlText;
        }

        /// <summary>
<<<<<<< HEAD
        /// Establece el marcador de posición.
=======
        /// Establece el marcador de posición en el cuadro de texto.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void SetPlaceHolder()
        {
            PlaceholderActive = true;
            Text = PlaceHolderText;
            ForeColor = System.Drawing.SystemColors.GrayText;
        }

        /// <summary>
        /// Vacía el marcador de posición.
        /// </summary>
        private void EmptyPlaceHolder()
        {
            PlaceholderActive = false;
            Text = "";
            ForeColor = System.Drawing.SystemColors.ControlText;
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene el texto actual, si es el marcador de posición, devuelve una cadena vacía.
        /// </summary>
        /// <returns>Texto actual o cadena vacía si es el marcador de posición.</returns>
=======
        /// Obtiene el texto del cuadro de texto, evitando devolver el marcador de posición si está presente.
        /// </summary>
        /// <returns>El texto contenido en el cuadro de texto o una cadena vacía si es el marcador de posición.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public string GetString()
        {
            if (Text == PlaceHolderText)
            {
                return string.Empty;
            }
            return Text;
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene el valor entero del texto actual, muestra un mensaje si no es válido.
        /// </summary>
        /// <returns>Valor entero o null si no es válido.</returns>
=======
        /// Obtiene el valor entero del cuadro de texto si es válido; de lo contrario, muestra un mensaje de error.
        /// </summary>
        /// <returns>El valor entero contenido en el cuadro de texto o null si no es un entero válido.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public int? GetInt()
        {
            if (int.TryParse(Text, out int result))
                return result;
            MessageManager.ShowMessage("No has introducido un entero válido", $"\"{Text}\" no es un entero válido.");
            return null;
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene el valor decimal del texto actual, muestra un mensaje si no es válido.
        /// </summary>
        /// <returns>Valor decimal o null si no es válido.</returns>
=======
        /// Obtiene el valor decimal del cuadro de texto si es válido; de lo contrario, muestra un mensaje de error.
        /// </summary>
        /// <returns>El valor decimal contenido en el cuadro de texto o null si no es un número válido.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public double? GetDouble()
        {
            if (double.TryParse(Text, out double result))
                return result;
            MessageManager.ShowMessage("No has introducido un número válido", $"\"{Text}\" no es un número válido.");
            return null;
        }

        /// <summary>
<<<<<<< HEAD
        /// Establece el control en un estado de error, cambiando el color de fondo a LightCoral.
=======
        /// Establece el cuadro de texto en un estado de error, cambiando el color de fondo a LightCoral.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void SetError()
        {
            Valid = false;
            BackColor = Color.LightCoral;
        }

        /// <summary>
<<<<<<< HEAD
        /// Establece el control en un estado válido, cambiando el color de fondo a blanco.
=======
        /// Establece el cuadro de texto en un estado válido, cambiando el color de fondo a White.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void SetValid()
        {
            Valid = true;
            BackColor = Color.White;
        }
    }
}