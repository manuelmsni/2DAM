using Proyecto2Ev.Models;
using Proyecto2Ev.Utils;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa la ventana de detalle de una mascota en la aplicación.
    /// </summary>
    public partial class PetWindow : Form
    {
        /// <summary>
        /// Instancia única de la clase `PetWindow`.
        /// </summary>
        private static PetWindow Instance;

        /// <summary>
        /// Propiedad que almacena la mascota asociada a la ventana.
        /// </summary>
        public Pet Pet { get; set; }

        /// <summary>
        /// Obtiene una instancia única de la clase `PetWindow` asociada a una mascota.
        /// </summary>
        /// <param name="pet">La mascota a la que está asociada la ventana.</param>
        /// <returns>Instancia única de la clase `PetWindow`.</returns>
        public static PetWindow GetInstance(Pet pet, Image img)
=======
    /// Clase que representa una ventana de detalles de una mascota en una aplicación Windows Forms.
    /// </summary>
    public partial class PetWindow : Form
    {
        private static PetWindow Instance; // Instancia única de la ventana.
        public Pet Pet { get; set; } // Propiedad para almacenar la mascota que se muestra en la ventana.

        /// <summary>
        /// Método estático para obtener una instancia única de la ventana de detalles de la mascota.
        /// </summary>
        /// <param name="pet">La mascota a mostrar en la ventana.</param>
        /// <returns>La instancia única de la ventana.</returns>
        public static PetWindow GetInstance(Pet pet)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        {
            // Crea una nueva instancia si no existe una ya creada
            if (Instance == null)
            {
<<<<<<< HEAD
                Instance = new PetWindow(pet, img);
=======
                Instance = new PetWindow(pet);
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            }
            else
            {
                // Si la instancia ya existe, carga los datos de la nueva mascota
                Instance.LoadPetData(pet, img);
            }
            return Instance;
        }

        /// <summary>
<<<<<<< HEAD
        /// Constructor privado de la clase `PetWindow`.
        /// </summary>
        /// <param name="pet">La mascota asociada a la ventana.</param>
        public PetWindow(Pet pet, Image img)
=======
        /// Constructor de la clase para inicializar la ventana con una mascota.
        /// </summary>
        /// <param name="pet">La mascota a mostrar en la ventana.</param>
        public PetWindow(Pet pet)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        {
            InitializeComponent();
            // TODO: Realizar acciones adicionales necesarias al instanciar la ventana con una mascota
            this.BackgroundImage = img;
            BackgroundImageLayout = ImageLayout.Stretch;
        }

        /// <summary>
<<<<<<< HEAD
        /// Manejador de eventos que se ejecuta al cerrar la ventana, estableciendo la propiedad `Pet` a null.
=======
        /// Método que carga los datos de una mascota en la ventana.
        /// </summary>
        /// <param name="pet">La mascota cuyos datos se cargarán en la ventana.</param>
        private void LoadPetData(Pet pet)
        {
            // Implementa la lógica para cargar los datos de la mascota en la ventana.
        }

        /// <summary>
        /// Manejador de eventos que se ejecuta cuando se cierra la ventana de detalles de la mascota.
        /// Limpia la referencia a la mascota en la instancia única.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void PetWindow_FormClosing(object sender, FormClosingEventArgs e)
        {
            Instance.Pet = null;
        }

        /// <summary>
        /// Carga los datos de una mascota en la ventana.
        /// </summary>
        /// <param name="pet">La mascota cuyos datos se van a cargar.</param>
        private void LoadPetData(Pet pet, Image img)
        {
            // TODO: Implementar la carga de datos de la mascota en la ventana
            this.BackgroundImage = img;
        }
    }
}