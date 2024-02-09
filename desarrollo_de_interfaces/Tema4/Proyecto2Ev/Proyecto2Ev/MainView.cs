using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Proyecto2Ev.Components;
using Proyecto2Ev.DAO;
using Proyecto2Ev.Models;
using Proyecto2Ev.Utils;

namespace Proyecto2Ev
{
    /// <summary>
<<<<<<< HEAD
    /// Clase principal que representa la vista principal de la aplicación.
=======
    /// Clase que representa la vista principal de una aplicación Windows Forms.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public partial class MainView : Form
    {
        /// <summary>
<<<<<<< HEAD
        /// Instancia única de la clase `MainView`.
=======
        /// Instancia única de la vista principal.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private static MainView Instance { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Constructor privado de la clase `MainView`.
=======
        /// Constructor privado para evitar la creación de instancias públicas de la clase.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private MainView()
        {

            // Agrega el diseño principal de las mascotas a los controles de la ventana
            Controls.Add(MainPetLayout.GetInstance());
            InitializeComponent();

            // Agrega el menú principal de la vista a los controles de la ventana
            Controls.Add(MainViewMenu.GetInstance());

            // Establece la vista actual en "pets"
            MainViewMenu.GetInstance().CurrentView = "pets";

            // Establece el menú principal de la ventana
            MainMenuStrip = MainViewMenu.GetInstance();
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene una instancia única de la clase `MainView`.
        /// </summary>
        /// <returns>Instancia única de la clase `MainView`.</returns>
=======
        /// Método estático para obtener una instancia única de la vista principal.
        /// </summary>
        /// <returns>La instancia única de la vista principal.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static MainView GetInstance()
        {
            // Crea una nueva instancia si no existe una ya creada
            if (Instance == null)
            {
                Instance = new MainView();
            }
            return Instance;
        }
    }
}
