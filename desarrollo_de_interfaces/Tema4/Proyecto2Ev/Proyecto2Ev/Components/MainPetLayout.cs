using Proyecto2Ev.DAO;
using Proyecto2Ev.Models;
using Proyecto2Ev.Properties;
using Proyecto2Ev.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa el diseño principal de la vista de mascotas.
=======
    /// Clase que representa el diseño principal de la vista de mascotas en una aplicación Windows Forms.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class MainPetLayout : Panel
    {
        /// <summary>
<<<<<<< HEAD
        /// Instancia única del diseño principal de mascotas.
=======
        /// Obtiene o establece una instancia única de MainPetLayout.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static MainPetLayout Instance { get; set; }

        /// <summary>
        /// Instancia de la tarjeta de la mascota seleccionada.
        /// </summary>
        public Pet SelectedPet { get; set; }

        /// <summary>
        /// Diccionario de inputs, para poder acceder a ellos por su nombre,
        /// y para mantener la referencia a ellos en memoria.
        /// </summary>
        private Dictionary<string, LabelledInput> Inputs = new Dictionary<string, LabelledInput>();
<<<<<<< HEAD

        /// <summary>
        /// Obtiene la instancia única del diseño principal de mascotas.
        /// </summary>
        /// <returns>Instancia única del diseño principal de mascotas.</returns>
=======
        /// <summary>
        /// Obtiene una instancia única de MainPetLayout o crea una nueva si aún no existe.
        /// </summary>
        /// <returns>Una instancia única de MainPetLayout.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static MainPetLayout GetInstance()
        {
            if (Instance == null)
            {
                Instance = new MainPetLayout();
            }
            return Instance;
        }
<<<<<<< HEAD

        /// <summary>
        /// Constructor privado de la clase <see cref="MainPetLayout"/>.
=======
        /// <summary>
        /// Constructor privado de la clase MainPetLayout.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private MainPetLayout()
        {
            Dock = DockStyle.Fill;
            InitComponents();
        }
<<<<<<< HEAD

        /// <summary>
        /// Inicializa los componentes del diseño principal de mascotas.
=======
        /// <summary>
        /// Inicializa los componentes principales de la vista de mascotas.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitComponents()
        {
            InitPetList();

            this.Logo = new System.Windows.Forms.PictureBox();
            this.Left = new System.Windows.Forms.Panel();
            this.PetPreview = new System.Windows.Forms.FlowLayoutPanel();
            this.Buttons = new System.Windows.Forms.FlowLayoutPanel();
            this.AddButton = new System.Windows.Forms.Button();
            this.NewButton = new System.Windows.Forms.Button();
            this.EditButton = new System.Windows.Forms.Button();
            this.DeleteButton = new System.Windows.Forms.Button();
            this.Header = new System.Windows.Forms.FlowLayoutPanel();
            this.FilterPanel = new System.Windows.Forms.Panel();
            this.FilterCheckBoxContainer = new System.Windows.Forms.FlowLayoutPanel();
            this.FilterLabel = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.Logo)).BeginInit();
            this.Left.SuspendLayout();
            this.Buttons.SuspendLayout();
            this.Header.SuspendLayout();
            this.FilterPanel.SuspendLayout();

            // 
            // Logo
            // 
            this.Logo.Dock = System.Windows.Forms.DockStyle.Right;
            this.Logo.Image = ImageManager.FromPath(Constants.LOGO_PATH);
            this.Logo.ImageLocation = "";
            this.Logo.Location = new System.Drawing.Point(3, 3);
            this.Logo.Name = "Logo";
            this.Logo.Size = new System.Drawing.Size(50, 52);
            this.Logo.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.Logo.TabIndex = 0;
            this.Logo.TabStop = false;

            // 
            // Left
            // 
            this.Left.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.Left.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(58)))), ((int)(((byte)(58)))), ((int)(((byte)(58)))));
            this.Left.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Left.Controls.Add(this.Buttons);
            this.Left.Dock = System.Windows.Forms.DockStyle.Left;
            this.Left.ForeColor = System.Drawing.SystemColors.Control;
            this.Left.Location = new System.Drawing.Point(0, 84);
            this.Left.Name = "Left";
            this.Left.Padding = new System.Windows.Forms.Padding(0, 6, 0, 0);
            this.Left.Size = new System.Drawing.Size(258, 361);
            this.Left.TabIndex = 2;

            // 
            // Buttons
            // 
            this.Buttons.AutoSize = true;
            this.Buttons.Controls.Add(this.AddButton);
            this.Buttons.Controls.Add(this.NewButton);
            this.Buttons.Controls.Add(this.EditButton);
            this.Buttons.Controls.Add(this.DeleteButton);
            this.Buttons.Dock = System.Windows.Forms.DockStyle.Top;
            this.Buttons.Location = new System.Drawing.Point(0, 6);
            this.Buttons.Name = "Buttons";
            this.Buttons.Size = new System.Drawing.Size(256, 29);
            this.Buttons.TabIndex = 0;

            // 
            // AddButton
            // 
            this.AddButton.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
            this.AddButton.Location = new System.Drawing.Point(3, 3);
            this.AddButton.Name = "AddButton";
            this.AddButton.Size = new System.Drawing.Size(75, 23);
            this.AddButton.TabIndex = 0;
            this.AddButton.Text = "Add";
            this.AddButton.UseVisualStyleBackColor = true;
            this.AddButton.Click += new System.EventHandler(this.AddButton_Click);

            // 
            // EditButton
            // 
            this.EditButton.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
            this.EditButton.Location = new System.Drawing.Point(3, 3);
            this.EditButton.Name = "EditButton";
            this.EditButton.Size = new System.Drawing.Size(75, 23);
            this.EditButton.TabIndex = 0;
            this.EditButton.Text = "Edit";
            this.EditButton.UseVisualStyleBackColor = true;
            this.EditButton.Click += new System.EventHandler(this.EditButton_Click);
            this.EditButton.Visible = false;

            // 
            // DeleteButton
            // 
            this.DeleteButton.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
            this.DeleteButton.Location = new System.Drawing.Point(3, 3);
            this.DeleteButton.Name = "DeleteButton";
            this.DeleteButton.Size = new System.Drawing.Size(75, 23);
            this.DeleteButton.TabIndex = 0;
            this.DeleteButton.Text = "Delete";
            this.DeleteButton.UseVisualStyleBackColor = true;
            this.DeleteButton.Click += new System.EventHandler(this.DeleteButton_Click);
            this.DeleteButton.Visible = false;

            // 
            // New
            // 
            this.NewButton.ForeColor = System.Drawing.SystemColors.ControlDarkDark;
            this.NewButton.Location = new System.Drawing.Point(3, 3);
            this.NewButton.Name = "NewButton";
            this.NewButton.Size = new System.Drawing.Size(75, 23);
            this.NewButton.TabIndex = 0;
            this.NewButton.Text = "New";
            this.NewButton.UseVisualStyleBackColor = true;
            this.NewButton.Click += new System.EventHandler(this.NewButton_Click);
            this.NewButton.Visible = false;

            // 
            // Header
            // 
            this.Header.AutoSize = true;
            this.Header.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(50)))), ((int)(((byte)(50)))), ((int)(((byte)(50)))));
            this.Header.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.Header.Controls.Add(this.Logo);
            this.Header.Controls.Add(this.FilterPanel);
            this.Header.Dock = System.Windows.Forms.DockStyle.Top;
            this.Header.ForeColor = System.Drawing.SystemColors.Control;
            this.Header.Location = new System.Drawing.Point(0, 24);
            this.Header.Name = "Header";
            this.Header.Size = new System.Drawing.Size(821, 60);
            this.Header.TabIndex = 0;

            // 
            // FilterPanel
            // 
            this.FilterPanel.Controls.Add(this.FilterCheckBoxContainer);
            this.FilterPanel.Controls.Add(this.FilterLabel);
            this.FilterPanel.Location = new System.Drawing.Point(59, 5);
            this.FilterPanel.Margin = new System.Windows.Forms.Padding(3, 5, 3, 3);
            this.FilterPanel.Name = "FilterPanel";
            this.FilterPanel.Size = new System.Drawing.Size(466, 50);
            this.FilterPanel.TabIndex = 2;

            // 
            // FilterCheckBoxContainer
            // 
            this.FilterCheckBoxContainer.AutoSize = true;
            this.FilterCheckBoxContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.FilterCheckBoxContainer.Location = new System.Drawing.Point(0, 17);
            this.FilterCheckBoxContainer.Name = "FilterCheckBoxContainer";
            this.FilterCheckBoxContainer.Size = new System.Drawing.Size(466, 33);
            this.FilterCheckBoxContainer.TabIndex = 1;

            // 
            // FilterLabel
            // 
            this.FilterLabel.AutoSize = true;
            this.FilterLabel.Dock = System.Windows.Forms.DockStyle.Top;
            this.FilterLabel.Location = new System.Drawing.Point(0, 0);
            this.FilterLabel.Margin = new System.Windows.Forms.Padding(3, 5, 3, 5);
            this.FilterLabel.Name = "FilterLabel";
            this.FilterLabel.Padding = new System.Windows.Forms.Padding(0, 2, 0, 2);
            this.FilterLabel.Size = new System.Drawing.Size(53, 17);
            this.FilterLabel.TabIndex = 4;
            this.FilterLabel.Text = "Filtrar por:";

            // 
            // PetPreview
            // 
            this.PetPreview.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.PetPreview.Dock = System.Windows.Forms.DockStyle.Fill;
            this.PetPreview.FlowDirection = System.Windows.Forms.FlowDirection.BottomUp;
            this.PetPreview.Name = "PetPreview";
            this.PetPreview.Size = new System.Drawing.Size(0, 206);

            this.Left.Controls.Add(this.PetPreview);

            this.Controls.Add(this.Left);
            this.Controls.Add(this.Header);

            ((System.ComponentModel.ISupportInitialize)(this.Logo)).EndInit();
            this.Left.ResumeLayout(false);
            this.Left.PerformLayout();
            this.Buttons.ResumeLayout(false);
            this.Header.ResumeLayout(false);
            this.FilterPanel.ResumeLayout(false);
            this.FilterPanel.PerformLayout();

            InitFilters();
            InitPetFields();
        }
<<<<<<< HEAD

        /// <summary>
        /// Manejador de eventos cuando se hace clic en el botón "Eliminar".
=======
        /// <summary>
        /// Manejador de eventos para el clic en el botón Eliminar.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void DeleteButton_Click(object sender, EventArgs e)
        {
            if (SelectedPet == null) return;
            PetDAO.GetInstance().DeleteObject(SelectedPet);
            ClearSelectedPet();
            PetPanel.Render();
        }
<<<<<<< HEAD

        /// <summary>
        /// Manejador de eventos cuando se hace clic en el botón "Editar".
=======
        /// <summary>
        /// Manejador de eventos para el clic en el botón Editar.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void EditButton_Click(object sender, EventArgs e)
        {
            if (SelectedPet == null){
                MessageManager.ShowMessage("Pet is null", "Is null");
                return;
            }
                
            if (ValidateFields())
            {
                SelectedPet.Name = GetText("Nombre");
                SelectedPet.Family = GetText("Familia");
                SelectedPet.Specie = GetText("Especie");
                SelectedPet.Price = GetDouble("Precio") ?? 0;
                SelectedPet.Picture = GetText("Foto");

                PetDAO.GetInstance().UpdateObject(SelectedPet);
                ClearSelectedPet();
                PetPanel.Render();
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Manejador de eventos cuando se hace clic en el botón "Nuevo".
=======
        /// <summary>
        /// Manejador de eventos para el clic en el botón Nuevo.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void NewButton_Click(object sender, EventArgs e)
        {
            ClearSelectedPet();
        }
<<<<<<< HEAD

        /// <summary>
        /// Limpia la mascota seleccionada y restablece el estado de los controles.
=======
        /// <summary>
        /// Inicializa los campos de entrada de datos de la mascota.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitPetFields()
        {
            AddInput("Foto", "ej: http://www.mifoto.com/foto.png");
            AddInput("Precio", "ej: 10");
            AddInput("Especie", "ej: Pez beta");
            AddInput("Familia", "ej: Pez de agua dulce");
            AddInput("Nombre", "ej: Martín");
        }

        /// <summary>
<<<<<<< HEAD
        /// Inicia el componente de la lista de mascotas.
=======
        /// Inicializa la lista de mascotas.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitPetList()
        {
            PetPanel = PetList.GetInstance();
            Controls.Add(PetPanel);
            PetPanel.Dock = DockStyle.Fill;
        }

        /// <summary>
<<<<<<< HEAD
        /// Añade el imput de la 
=======
        /// Agrega un campo de entrada de datos a la vista.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        /// <param name="name">Nombre del campo.</param>
        /// <param name="placeHolder">Texto de marcador de posición.</param>
        public void AddInput(string name, string placeHolder)
        {
            LabelledInput temp = new LabelledInput(name, placeHolder);
            Inputs.Add(name, temp);
            Left.Controls.Add(temp);
        }
<<<<<<< HEAD

        /// <summary>
        /// Obtiene el texto ingresado en el input correspondiente.
        /// </summary>
        /// <param name="name">Nombre del input.</param>
        /// <returns>Texto ingresado en el input.</returns>
=======
        /// <summary>
        /// Obtiene el texto de un campo de entrada.
        /// </summary>
        /// <param name="name">Nombre del campo.</param>
        /// <returns>El texto del campo de entrada.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public string GetText(string name)
        {
            return ((PlaceHolder)Inputs[name].MainText).GetString();
        }
<<<<<<< HEAD

        /// <summary>
        /// Obtiene el valor numérico ingresado en el input correspondiente.
        /// </summary>
        /// <param name="name">Nombre del input.</param>
        /// <returns>Valor numérico ingresado en el input.</returns>
=======
        /// <summary>
        /// Obtiene un valor decimal desde un campo de entrada.
        /// </summary>
        /// <param name="name">Nombre del campo.</param>
        /// <returns>El valor decimal o nulo si el valor no es válido.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public double? GetDouble(string name)
        {
            return ((PlaceHolder)Inputs[name].MainText).GetDouble();
        }

        /// <summary>
<<<<<<< HEAD
        /// Valida los campos de entrada, mostrando errores si es necesario.
        /// </summary>
        /// <returns>True si todos los campos son válidos, de lo contrario, false.</returns>
=======
        /// Valida los campos de entrada de datos.
        /// </summary>
        /// <returns>true si todos los campos son válidos, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        private bool ValidateFields()
        {
            bool valid = true;
            foreach (var item in Inputs)
            {
                var casted = (PlaceHolder)item.Value.MainText; // Asegurarse de que esto obtiene efectivamente el PlaceHolder

                // Verificar si el campo es "Precio" y si es un doble válido y positivo
                if (item.Key == "Precio")
                {
                    double? price = casted.GetDouble();
                    if (price == null || price <= 0)
                    {
                        casted.SetError();
                        valid = false;
                    }
                    else
                    {
                        casted.SetValid();
                    }
                }
                else if (string.IsNullOrWhiteSpace(casted.GetString())) // Mejora para verificar espacios en blanco
                {
                    casted.SetError();
                    valid = false;
                }
                else
                {
                    casted.SetValid();
                }
            }
            return valid;
        }
        /// <summary>
        /// Manejador de eventos para el clic en el botón Agregar.
        /// </summary>
        /// <param name="sender">La fuente del evento.</param>
        /// <param name="e">La instancia que contiene los datos del evento.</param>
        private void AddButton_Click(object sender, EventArgs e)
        {
            if (ValidateFields())
            {
                Pet temp = new Pet(GetText("Nombre"), GetText("Familia"), GetText("Especie"), GetDouble("Precio") ?? 0, GetText("Foto"), DateTime.Now, 0);
                PetDAO.GetInstance().InsertObject(temp);
                PetPanel.Render();
            }
        }
        /// <summary>
        /// Inicializa los filtros de la vista.
        /// </summary>
        private void InitFilters()
        {
            if (Constants.FilterColumns == null || Constants.FilterColumns.Count == 0)
            {
                FilterPanel.Visible = false;
                return;
            }
            foreach (KeyValuePair<string, string> item in Constants.FilterColumns)
            {
                var temp = new CheckBox();
                temp.AutoSize = true;
                temp.Name = $"{item.Value.ToUpper()}CheckBox";
                temp.Size = new System.Drawing.Size(0, 17);
                temp.TabIndex = 5;
                temp.Text = item.Key;
                temp.UseVisualStyleBackColor = true;
                FilterCheckBoxContainer.Controls.Add(temp);
                temp.CheckedChanged += (sender, e) =>
                {
                    if (temp.Checked)
                    {
                        PetPanel.AddFilter(item.Key, item.Value);
                    }
                    else
                    {
                        PetPanel.RemoveFilter(item.Value);
                    }
                };
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Establece la mascota seleccionada y muestra sus detalles en el diseño.
        /// </summary>
        /// <param name="pet">Tarjeta de mascota seleccionada.</param>
=======
        /// <summary>
        /// Establece la mascota seleccionada en la vista.
        /// </summary>
        /// <param name="pet">La tarjeta de mascota seleccionada.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public void SetSelectedPet(PetCard pet)
        {
            SelectedPet = pet.Pet;
            this.AddButton.Visible = false;
            this.NewButton.Visible = true;
            this.EditButton.Visible = true;
            this.DeleteButton.Visible = true;
            PetPreview.Controls.Clear();
            PetPreview.Controls.Add(pet);
            ((PlaceHolder)Inputs["Nombre"].MainText).SetText(pet.Pet.Name);
            ((PlaceHolder)Inputs["Familia"].MainText).SetText(pet.Pet.Family);
            ((PlaceHolder)Inputs["Especie"].MainText).SetText(pet.Pet.Specie);
            ((PlaceHolder)Inputs["Precio"].MainText).SetText(pet.Pet.Price.ToString());
            ((PlaceHolder)Inputs["Foto"].MainText).SetText(pet.Pet.Picture);
        }
<<<<<<< HEAD

        /// <summary>
        /// Limpia la mascota seleccionada y restablece el estado de los controles.
=======
        /// <summary>
        /// Limpia la mascota seleccionada en la vista.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void ClearSelectedPet()
        {
            PetPreview.Controls.Clear();
            this.NewButton.Visible = false;
            this.AddButton.Visible = true;
            this.EditButton.Visible = false;
            this.DeleteButton.Visible = false;
            SelectedPet = null;
            foreach (var item in Inputs)
            {
                PlaceHolder temp = (PlaceHolder)item.Value.MainText;
                temp.SetPlaceHolder();
                temp.SetValid();
            }
        }

        private PetList PetPanel;
        private System.Windows.Forms.Panel Left;
        private System.Windows.Forms.FlowLayoutPanel PetPreview;
        private System.Windows.Forms.FlowLayoutPanel Buttons;
        private System.Windows.Forms.Button AddButton;
        private System.Windows.Forms.Button NewButton;
        private System.Windows.Forms.Button EditButton;
        private System.Windows.Forms.Button DeleteButton;
        private System.Windows.Forms.PictureBox Logo;
        private System.Windows.Forms.FlowLayoutPanel Header;
        private System.Windows.Forms.FlowLayoutPanel FilterCheckBoxContainer;
        private System.Windows.Forms.Panel FilterPanel;
        private System.Windows.Forms.Label FilterLabel;
    }
}
