using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa el menú principal de la vista.
=======
    /// Clase que representa el menú principal de la vista en una aplicación Windows Forms.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class MainViewMenu : MenuStrip
    {
        /// <summary>
<<<<<<< HEAD
        /// Instancia única del menú principal.
=======
        /// Obtiene o establece una instancia única de MainViewMenu.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static MainViewMenu Instance { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Vista actual seleccionada.
=======
        /// Obtiene o establece el nombre de la vista actual.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public string CurrentView { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene la instancia única del menú principal.
        /// </summary>
        /// <returns>Instancia única del menú principal.</returns>
=======
        /// Obtiene una instancia única de MainViewMenu o crea una nueva si aún no existe.
        /// </summary>
        /// <returns>Una instancia única de MainViewMenu.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static MainViewMenu GetInstance()
        {
            if (Instance == null)
            {
                Instance = new MainViewMenu();
            }
            return Instance;
        }

        /// <summary>
<<<<<<< HEAD
        /// Constructor privado de la clase <see cref="MainViewMenu"/>.
=======
        /// Constructor privado de la clase MainViewMenu.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private MainViewMenu()
        {
            InitComponents();
        }

        /// <summary>
        /// Inicializa los componentes del menú principal.
        /// </summary>
        private void InitComponents()
        {
            this.HelpButton = new System.Windows.Forms.ToolStripMenuItem();
            this.StaitsticsButton = new System.Windows.Forms.ToolStripMenuItem();
            this.PetsButton = new System.Windows.Forms.ToolStripMenuItem();
            SuspendLayout();

            // 
            // Toolbar
            // 
            Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
                this.PetsButton,
                this.StaitsticsButton,
                this.HelpButton
            });
            Location = new System.Drawing.Point(0, 0);
            Name = "Toolbar";
            Size = new System.Drawing.Size(821, 24);
            TabIndex = 1;

            // 
            // HelpButton
            // 
            this.HelpButton.Name = "HelpButton";
            this.HelpButton.Size = new System.Drawing.Size(44, 20);
            this.HelpButton.Text = "Ayuda";
            this.HelpButton.Click += new System.EventHandler(this.HelpToolStripMenuItem_Click);

            //
            // StatisticsButton
            //
            this.StaitsticsButton.Name = "StatisticsButton";
            this.StaitsticsButton.Size = new System.Drawing.Size(44, 20);
            this.StaitsticsButton.Text = "Estadísticas";
            this.StaitsticsButton.Click += new System.EventHandler(this.StatisticsToolStripMenuItem_Click);

            // 
            // petsToolStripMenuItem
            // 
            this.PetsButton.Name = "petsToolStripMenuItem";
            this.PetsButton.Size = new System.Drawing.Size(41, 20);
            this.PetsButton.Text = "Mascotas";
            this.PetsButton.Click += new System.EventHandler(this.PetsToolStripMenuItem_Click);

            ResumeLayout(false);
            PerformLayout();
        }

        /// <summary>
<<<<<<< HEAD
        /// Manejador de eventos cuando se hace clic en la opción de estadísticas.
=======
        /// Manejador de eventos para el clic en la opción de estadísticas en el menú.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void StatisticsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (CurrentView != "statistics")
            {
                MainView.GetInstance().Controls.Clear();
                CurrentView = "statistics";
                ChartPanel chart = new ChartPanel();
                chart.SetMostVisitedData();
                MainView.GetInstance().Controls.Add(chart);
                MainView.GetInstance().Controls.Add(this);
            }
        }

        /// <summary>
<<<<<<< HEAD
        /// Manejador de eventos cuando se hace clic en la opción de mascotas.
=======
        /// Manejador de eventos para el clic en la opción de mascotas en el menú.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void PetsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (CurrentView != "pets")
            {
                MainView.GetInstance().Controls.Clear();
                CurrentView = "pets";
                MainView.GetInstance().Controls.Add(MainPetLayout.GetInstance());
                MainView.GetInstance().Controls.Add(this);
            }
        }

        /// <summary>
<<<<<<< HEAD
        /// Manejador de eventos cuando se hace clic en la opción de ayuda.
=======
        /// Manejador de eventos para el clic en la opción de ayuda en el menú.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void HelpToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (CurrentView != "help")
            {
                MainView.GetInstance().Controls.Clear();
                CurrentView = "help";
                MainView.GetInstance().Controls.Add(HelpPanel.GetInstance());
                MainView.GetInstance().Controls.Add(this);
            }
        }

        private System.Windows.Forms.ToolStripMenuItem HelpButton;
        private System.Windows.Forms.ToolStripMenuItem StaitsticsButton;
        private System.Windows.Forms.ToolStripMenuItem PetsButton;
    }
}
