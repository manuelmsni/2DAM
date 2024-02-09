using Proyecto2Ev.DAO;
using Proyecto2Ev.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;
using Proyecto2Ev.Utils;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa un contenedor de mascotas con funcionalidades de filtrado.
=======
    /// Clase que representa una lista de mascotas y proporciona funcionalidades para filtrar y mostrar las mascotas.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class PetList : Panel
    {
        /// <summary>
<<<<<<< HEAD
        /// Instancia única de la clase.
        /// </summary>
        public static PetList Instance { get; set; }

        /// <summary>
        /// Colección de mascotas.
=======
        /// Obtiene o establece una instancia única de la clase PetList.
        /// </summary>
        public static PetList Instance { get; set; }
        /// <summary>
        /// Obtiene o establece una lista de objetos Pet que representa las mascotas.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static List<Pet> Pets { get; set; }
        private Dictionary<string, PlaceHolder> Filters;
<<<<<<< HEAD

        /// <summary>
        /// Obtiene una instancia única de la clase <see cref="PetList"/>.
        /// </summary>
        /// <returns>Instancia única de la clase.</returns>
=======
        /// <summary>
        /// Obtiene una instancia única de la clase PetList. Si no existe una instancia, se crea una nueva.
        /// </summary>
        /// <returns>La instancia única de la clase PetList.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static PetList GetInstance()
        {
            if (Instance == null)
            {
                Instance = new PetList();
            }
            return Instance;
        }
<<<<<<< HEAD

        /// <summary>
        /// Constructor privado de la clase <see cref="PetList"/>.
=======
        /// <summary>
        /// Constructor privado de la clase PetList.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private PetList()
        {
            Pets = new List<Pet>();
            Filters = new Dictionary<string, PlaceHolder>();
            InitComponents();
        }
<<<<<<< HEAD

        /// <summary>
        /// Inicializa los componentes del formulario.
=======
        /// <summary>
        /// Inicializa los componentes de la clase PetList.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitComponents()
        {
            InitCustom();
        }
<<<<<<< HEAD

        /// <summary>
        /// Inicializa los componentes personalizados del formulario.
=======
        /// <summary>
        /// Inicializa los componentes personalizados de la clase PetList.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitCustom()
        {
            this.FilterBar = new System.Windows.Forms.FlowLayoutPanel();
            this.FilterLabel = new System.Windows.Forms.Label();
            this.PetContainer = new System.Windows.Forms.FlowLayoutPanel();

<<<<<<< HEAD
            // Configuración del formulario principal
=======
            // Configuración del panel principal (this)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            AutoScroll = true;
            Controls.Add(this.PetContainer);
            Controls.Add(this.FilterBar);
            Dock = System.Windows.Forms.DockStyle.Fill;
            Location = new System.Drawing.Point(258, 82);
            Name = "Container";
            Size = new System.Drawing.Size(563, 363);
            TabIndex = 3;

<<<<<<< HEAD
            // Configuración de la barra de filtros
=======
            // Configuración del panel de filtros (FilterBar)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            this.FilterBar.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(64)))), ((int)(((byte)(64)))), ((int)(((byte)(64)))));
            this.FilterBar.Controls.Add(this.FilterLabel);
            this.FilterBar.Dock = System.Windows.Forms.DockStyle.Top;
            this.FilterBar.Location = new System.Drawing.Point(0, 0);
            this.FilterBar.Name = "FilterBar";
            this.FilterBar.Padding = new System.Windows.Forms.Padding(0, 2, 0, 0);
            this.FilterBar.Size = new System.Drawing.Size(563, 31);
            this.FilterBar.TabIndex = 0;
            FilterBar.Visible = false;

<<<<<<< HEAD
            // Configuración de la etiqueta del filtro
=======
            // Configuración de la etiqueta de filtro (FilterLabel)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            this.FilterLabel.AutoSize = true;
            this.FilterLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.FilterLabel.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.FilterLabel.Location = new System.Drawing.Point(6, 5);
            this.FilterLabel.Margin = new System.Windows.Forms.Padding(6, 3, 3, 3);
            this.FilterLabel.Name = "FilterLabel";
            this.FilterLabel.Size = new System.Drawing.Size(83, 18);
            this.FilterLabel.TabIndex = 0;
            this.FilterLabel.Text = "Filtrar por : ";

<<<<<<< HEAD
            // Configuración del contenedor de mascotas
=======
            // Configuración del contenedor de mascotas (PetContainer)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            this.PetContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.FilterLabel.Margin = new System.Windows.Forms.Padding(0, 2, 0, 0);
            this.PetContainer.Location = new System.Drawing.Point(0, 0);
            this.PetContainer.Name = "PetContainer";
            this.PetContainer.TabIndex = 0;
            this.PetContainer.AutoScroll = true;
        }
<<<<<<< HEAD

        /// <summary>
        /// Agrega un filtro al formulario.
        /// </summary>
        /// <param name="key">Clave del filtro.</param>
        /// <param name="value">Valor del filtro.</param>
=======
        /// <summary>
        /// Agrega un filtro a la lista de filtros en la interfaz de usuario.
        /// </summary>
        /// <param name="key">La clave o nombre del filtro.</param>
        /// <param name="value">El valor del filtro.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public void AddFilter(string key, string value)
        {
            PlaceHolder temp = new PlaceHolder(key);
            Filters.Add(value, temp);
            this.FilterBar.Controls.Add(temp);
            if (!FilterBar.Visible) FilterBar.Visible = true;
            temp.TextChanged += FilterField_TextChanged;
        }
<<<<<<< HEAD

        /// <summary>
        /// Elimina un filtro del formulario.
        /// </summary>
        /// <param name="value">Valor del filtro a eliminar.</param>
=======
        /// <summary>
        /// Elimina un filtro de la lista de filtros en la interfaz de usuario.
        /// </summary>
        /// <param name="value">El valor del filtro que se eliminará.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public void RemoveFilter(string value)
        {
            PlaceHolder temp = Filters[value];
            Filters.Remove(value);
            this.FilterBar.Controls.Remove(temp);
            if (Filters.Count == 0) FilterBar.Visible = false;
        }
<<<<<<< HEAD

        /// <summary>
        /// Muestra un mensaje cuando no hay resultados.
=======
        /// <summary>
        /// Muestra un mensaje cuando no se encuentran resultados coincidentes con los filtros aplicados.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void NoResults()
        {
            this.PetContainer.Controls.Clear();
            Label temp = new Label
            {
                Name = "NoResults",
                Text = "Haz una búsqueda!",
                AutoSize = true,
                Padding = new Padding(10, 10, 0, 0),
                Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)))
            };
            this.PetContainer.Controls.Add(temp);
        }
<<<<<<< HEAD

        /// <summary>
        /// Renderiza las mascotas en el formulario según los filtros aplicados.
=======
        /// <summary>
        /// Renderiza la lista de mascotas según los filtros aplicados.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void Render()
        {
            var filters = Filters.Where(f => !string.IsNullOrWhiteSpace(f.Value.GetString()));
            if (filters.Count() == 0) return;
            this.PetContainer.Controls.Clear();
<<<<<<< HEAD

=======
            try { 
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            PetDAO.GetInstance().SelectObjects(Filters)
                .ForEach(p =>
                {
                    PetContainer.Controls.Add(new PetCard(p));
                });
            } catch(Exception e)
            {
                ErrorManager.ShowToUser(e);
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Manejador de eventos cuando se modifica un campo de filtro.
        /// </summary>
=======
        /// <summary>
        /// Manejador de eventos para el cambio de texto en los campos de filtro.
        /// </summary>
        /// <param name="sender">El objeto que generó el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        private void FilterField_TextChanged(object sender, EventArgs e)
        {
            PlaceHolder temp = (PlaceHolder)sender;
            MainPetLayout.GetInstance().SelectedPet = null;
            Render();
        }
        private System.Windows.Forms.FlowLayoutPanel FilterBar;
        private System.Windows.Forms.Label FilterLabel;
        private System.Windows.Forms.FlowLayoutPanel PetContainer;
    }
}
