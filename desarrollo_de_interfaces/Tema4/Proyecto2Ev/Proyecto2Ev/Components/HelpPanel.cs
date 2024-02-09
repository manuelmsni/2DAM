using Proyecto2Ev.DAO;
using Proyecto2Ev.Utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev.Components
{
    /// <summary>
    /// Panel de ayuda que proporciona opciones para probar la base de datos y el contenedor.
    /// </summary>
    public class HelpPanel : FlowLayoutPanel
    {
        /// <summary>
        /// Instancia única de la clase HelpPanel.
        /// </summary>
        public static HelpPanel Instance { get; set; }

        /// <summary>
        /// Obtiene una instancia única de la clase `HelpPanel`.
        /// </summary>
        /// <returns>Instancia de `HelpPanel`.</returns>
        public static HelpPanel GetInstance()
        {
            if (Instance == null)
            {
                Instance = new HelpPanel();
            }
            return Instance;
        }
        /// <summary>
        /// Constructor privado de la clase HelpPanel.
        /// </summary>
        private HelpPanel()
        {
            Dock = DockStyle.Fill;
            InitComponents();
            this.ResumeLayout(false);
        }
        /// <summary>
        /// Inicializa los componentes del panel de ayuda.
        /// </summary>
        private void InitComponents()
        {
            this.TestContainerButton = new System.Windows.Forms.Button();

            // 
            // TestContainerButton
            // 
            this.TestContainerButton.Name = "TestContainerButton";
            this.TestContainerButton.Size = new System.Drawing.Size(97, 23);
            this.TestContainerButton.TabIndex = 0;
            this.TestContainerButton.Text = "Docker";
            this.TestContainerButton.UseVisualStyleBackColor = true;
            this.TestContainerButton.Click += new System.EventHandler(this.TestContainerButton_ClickAsync);
            this.Controls.Add(this.TestContainerButton);

            this.TestDatabaseButton = new System.Windows.Forms.Button();

            // 
            // TestDatabaseButton
            // 
            this.TestDatabaseButton.Name = "TestDatabaseButton";
            this.TestDatabaseButton.Size = new System.Drawing.Size(97, 23);
            this.TestDatabaseButton.TabIndex = 0;
            this.TestDatabaseButton.Text = "Database";
            this.TestDatabaseButton.UseVisualStyleBackColor = true;
            this.TestDatabaseButton.Click += new System.EventHandler(this.TestDatabaseButton_Click);
            this.Controls.Add(this.TestDatabaseButton);

            this.InsertTestDataButton = new System.Windows.Forms.Button();

            // 
            // InsertTestDataButton
            // 
            this.InsertTestDataButton.Name = "InsertTestDataButton";
            this.InsertTestDataButton.Size = new System.Drawing.Size(97, 23);
            this.InsertTestDataButton.TabIndex = 0;
            this.InsertTestDataButton.Text = "Test data";
            this.InsertTestDataButton.UseVisualStyleBackColor = true;
            this.InsertTestDataButton.Click += new System.EventHandler(this.InsertTestDataButton_Click);
            this.Controls.Add(this.InsertTestDataButton);

            this.BackupButton = new System.Windows.Forms.Button();
            // 
            // Save Backup Button
            // 
            this.BackupButton.Name = "BackupButton";
            this.BackupButton.Size = new System.Drawing.Size(97, 23);
            this.BackupButton.TabIndex = 0;
            this.BackupButton.Text = "Backup";
            this.BackupButton.UseVisualStyleBackColor = true;
            this.BackupButton.Click += new System.EventHandler(this.BackupButton_Click);
            this.Controls.Add(this.BackupButton);

            this.RestoreButton = new System.Windows.Forms.Button();
            //
            // Restore Backup Button
            //
            this.RestoreButton.Name = "RestoreBackupButton";
            this.RestoreButton.Size = new System.Drawing.Size(97, 23);
            this.RestoreButton.TabIndex = 0;
            this.RestoreButton.Text = "Restore Backup";
            this.RestoreButton.UseVisualStyleBackColor = true;
            this.RestoreButton.Click += new System.EventHandler(this.RestoreBackupButton_Click);
            this.Controls.Add(this.RestoreButton);


        }

        /// <summary>
        /// Maneja el evento Click del botón "RestoreBackupButton".
        /// Carga los datos de respaldo en la base de datos desde un csv.
        /// </summary>
        private void RestoreBackupButton_Click(object sender, EventArgs e)
        {
            PetDAO.GetInstance().LoadFromCsvToDatabase("Backup.csv");
        }

        /// <summary>
        /// Maneja el evento Click del botón "Probar Contenedor".
        /// Verifica si el contenedor está en funcionamiento y ofrece iniciar el contenedor si no lo está.
        /// </summary>
        private async void TestContainerButton_ClickAsync(object sender, EventArgs e)
        {
            bool containerRunning = await DatabaseManager.IsContainerRunning();
            if (!containerRunning)
            {
                MessageManager.ShowAlert("Error", "El contenedor no está iniciado.");
                if (MessageManager.AskForConfirmation("¿Desea iniciar el contenedor?"))
                    DatabaseManager.StartContainer();
            }
            else
                MessageManager.ShowMessage("Contenedor", "El contenedor está iniciado.");
        }

        /// <summary>
        /// Maneja el evento Click del botón "Probar Base de Datos".
        /// Verifica si la tabla en la base de datos existe y maneja excepciones si es necesario.
        /// </summary>
        private void TestDatabaseButton_Click(object sender, EventArgs e)
        {
            if (!DatabaseManager.CheckTable())
                DatabaseManager.ManageDatabaseExceptionsAsync();
            else
                MessageManager.ShowMessage("Base de Datos", "La base de datos funciona correctamente.");
        }

        /// <summary>
        /// Maneja el evento Click del botón "Insertar Datos de Prueba".
        /// Inserta datos de prueba en la base de datos.
        /// </summary>
        private void InsertTestDataButton_Click(object sender, EventArgs e)
        {
            DatabaseManager.InsertTestData();
        }

        /// <summary>
        /// Maneja el evento Click del botón "BackupButton".
        /// Guarda los datos en un csv.
        /// </summary>
        private void BackupButton_Click(object sender, EventArgs e)
        {
            PetDAO.GetInstance().SaveBackupToCsv("Backup.csv");
        }

        private System.Windows.Forms.Button TestContainerButton;
        private System.Windows.Forms.Button TestDatabaseButton;
        private System.Windows.Forms.Button InsertTestDataButton;
        private System.Windows.Forms.Button BackupButton;
        private System.Windows.Forms.Button RestoreButton;
    }
}
