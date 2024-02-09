using Proyecto2Ev.DAO;
using Proyecto2Ev.Models;
using Proyecto2Ev.Utils;
using System;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que representa una tarjeta de mascota dentro de un contenedor.
=======
    /// Clase que representa una tarjeta de mascota que muestra información sobre una mascota y maneja eventos de clic.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class PetCard : FlowLayoutPanel
    {
        private System.Windows.Forms.Label NameLabel;
        private System.Windows.Forms.Label FamilyLabel;
        private System.Windows.Forms.Label SpecieLabel;
        private System.Windows.Forms.Label PriceLabel;
        private System.Windows.Forms.Label AgeLabel;
        private long LastTimeClicked;

        /// <summary>
<<<<<<< HEAD
        /// Mascota asociada a la tarjeta.
=======
        /// Obtiene o establece el objeto Pet asociado a la tarjeta.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public Pet Pet { get; set; }

        /// <summary>
<<<<<<< HEAD
        /// Constructor de la clase <see cref="PetCard"/>.
        /// </summary>
        /// <param name="pet">Mascota asociada a la tarjeta.</param>
=======
        /// Constructor de la clase PetCard.
        /// </summary>
        /// <param name="pet">El objeto Pet asociado a la tarjeta.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public PetCard(Pet pet)
        {
            Pet = pet;
            LastTimeClicked = 0;
            InitComponents();
        }

        /// <summary>
        /// Inicializa los componentes de la tarjeta.
        /// </summary>
        private void InitComponents()
        {
            InitCustom();
        }

        /// <summary>
<<<<<<< HEAD
        /// Establece la imagen de fondo de la tarjeta.
=======
        /// Configura la imagen de fondo de la tarjeta, ya sea desde una URL o una ruta local.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private async Task SetImage()
        {
            if (Pet.Picture != null)
            {
                BackgroundImage = await ImageManager.FromURL(Pet.Picture);
            }
            else
            {
                BackgroundImage = ImageManager.FromPath("./Assets/img/logoPezinvertido.png");
            }
        }

        /// <summary>
        /// Inicializa los componentes personalizados de la tarjeta.
        /// </summary>
        private void InitCustom()
        {
            BackColor = System.Drawing.Color.Gray;
            Location = new System.Drawing.Point(3, 3);
            Name = "Card_" + Pet.Id;
            Size = new System.Drawing.Size(158, 198);
            FlowDirection = FlowDirection.TopDown;
            SetImage();
            BackgroundImageLayout = ImageLayout.Stretch;

<<<<<<< HEAD
            // Configuración de etiquetas
            this.NameLabel = CreateLabel("Nombre: " + Pet.Name);
            this.FamilyLabel = CreateLabel("Familia: " + Pet.Family);
            this.SpecieLabel = CreateLabel("Especie: " + Pet.Specie);
            this.PriceLabel = CreateLabel("Precio: " + Pet.Price);
            this.AgeLabel = CreateLabel("Edad: " + Pet.GetAge());

            // Manejo de eventos
=======
            // Configuración de las etiquetas de información de la mascota
            this.NameLabel = new System.Windows.Forms.Label();
            Controls.Add(this.NameLabel);
            this.NameLabel.AutoSize = true;
            this.NameLabel.Location = new System.Drawing.Point(13, 12);
            this.NameLabel.Name = "CardLabel_" + Pet.Name;
            this.NameLabel.Size = new System.Drawing.Size(35, 13);
            this.NameLabel.Text = "Nombre: " + Pet.Name;
            this.NameLabel.ForeColor = System.Drawing.Color.Black;

            this.FamilyLabel = new System.Windows.Forms.Label();
            Controls.Add(this.FamilyLabel);
            this.FamilyLabel.AutoSize = true;
            this.FamilyLabel.Location = new System.Drawing.Point(13, 12);
            this.FamilyLabel.Name = "CardLabel_" + Pet.Family;
            this.FamilyLabel.Size = new System.Drawing.Size(35, 13);
            this.FamilyLabel.Text = "Familia: " + Pet.Family;
            this.FamilyLabel.ForeColor = System.Drawing.Color.Black;

            this.SpecieLabel = new System.Windows.Forms.Label();
            Controls.Add(this.SpecieLabel);
            this.SpecieLabel.AutoSize = true;
            this.SpecieLabel.Location = new System.Drawing.Point(13, 12);
            this.SpecieLabel.Name = "CardLabel_" + Pet.Specie;
            this.SpecieLabel.Size = new System.Drawing.Size(35, 13);
            this.SpecieLabel.Text = "Especie: " + Pet.Specie;
            this.SpecieLabel.ForeColor = System.Drawing.Color.Black;

            this.PriceLabel = new System.Windows.Forms.Label();
            Controls.Add(this.PriceLabel);
            this.PriceLabel.AutoSize = true;
            this.PriceLabel.Location = new System.Drawing.Point(13, 12);
            this.PriceLabel.Name = "CardLabel_" + Pet.Price;
            this.PriceLabel.Size = new System.Drawing.Size(35, 13);
            this.PriceLabel.Text = "Precio: " + Pet.Price;
            this.PriceLabel.ForeColor = System.Drawing.Color.Black;

            this.AgeLabel = new System.Windows.Forms.Label();
            Controls.Add(this.AgeLabel);
            this.AgeLabel.AutoSize = true;
            this.AgeLabel.Location = new System.Drawing.Point(13, 12);
            this.AgeLabel.Name = "CardLabel_" + Pet.Age;
            this.AgeLabel.Size = new System.Drawing.Size(35, 13);
            this.AgeLabel.Text = "Edad: " + Pet.GetAge();
            this.AgeLabel.ForeColor = System.Drawing.Color.Black;

            // Manejador de evento de clic en la tarjeta
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            Click += Card_Click;
        }

        /// <summary>
<<<<<<< HEAD
        /// Crea una etiqueta con el texto especificado.
        /// </summary>
        /// <param name="text">Texto de la etiqueta.</param>
        /// <returns>Etiqueta creada.</returns>
        private System.Windows.Forms.Label CreateLabel(string text)
        {
            System.Windows.Forms.Label label = new System.Windows.Forms.Label
            {
                AutoSize = true,
                Location = new System.Drawing.Point(13, 12),
                Name = "CardLabel_" + text,
                Size = new System.Drawing.Size(35, 13),
                Text = text,
                ForeColor = System.Drawing.Color.Black
            };
            Controls.Add(label);
            return label;
        }

        /// <summary>
        /// Manejador de eventos cuando se hace clic en la tarjeta.
        /// </summary>
=======
        /// Manejador de eventos de clic en la tarjeta, que puede manejar tanto un clic simple como un doble clic.
        /// </summary>
        /// <param name="sender">El objeto que generó el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        private void Card_Click(object sender, EventArgs e)
        {
            // Comprobar doble clic
            long currentTime = DateTime.Now.Ticks / TimeSpan.TicksPerMillisecond;
            long difference = currentTime - LastTimeClicked;

            if (difference < 1200)
            {
                MainPetLayout.GetInstance().ClearSelectedPet();
                PetDAO.GetInstance().UpCount(Pet);
                PetWindow.GetInstance(Pet, this.BackgroundImage).ShowDialog();
            }
            else // No ha sido doble clic
            {
                MainPetLayout.GetInstance().SetSelectedPet(this.Clone());
            }

            LastTimeClicked = currentTime;
        }

        /// <summary>
<<<<<<< HEAD
        /// Crea una copia de la tarjeta.
        /// </summary>
        /// <returns>Copia de la tarjeta.</returns>
=======
        /// Crea una copia de la tarjeta PetCard actual.
        /// </summary>
        /// <returns>Una nueva instancia de PetCard con la misma mascota.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public PetCard Clone()
        {
            return new PetCard(Pet);
        }
    }
}
